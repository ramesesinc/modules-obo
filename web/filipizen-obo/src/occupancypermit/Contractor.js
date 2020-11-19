import React, { useState, useEffect } from "react";
import {
  Panel,
  Spacer,
  ActionBar,
  Button,
  FormPanel,
  Label,
  Text,
  Date,
  Email,
  Checkbox,
  BackLink,
  hasErrors
} from 'rsi-react-web-components';

import ProfessionalCard from "../components/ProfessionalCard";


const Contractor = ({
  appno,
  appService,
  moveNextStep,
  movePrevStep,
}) => {

  const [error, setError] = useState();
  const [loading, setLoading] = useState(false);
  const [errors, setErrors] = useState({});
  const [app, setApp] = useState({});
  const [isContracted, setIsContracted] = useState(false);

  useEffect(() => {
    appService.invoke("getApplication", {appid: appno}, (err, app) => {
      if (err) {
        setError(err);
      } else {{
        if (app.contractorid) {
          setIsContracted(true);
        } else {
          setIsContracted(false);
        }
        setApp(app);
      }}
    });
  }, [appno])

  const isValid = () => {
    const { contractor } = app;
    const errors = {};
    if (!contractor || !contractor.name) errors.name = "Required";
    if (!contractor || !contractor.address) errors.address = "Required";
    if (!contractor || !contractor.pcabno) errors.pcabno = "Required";
    if (!contractor || !contractor.pcabvalidaty) errors.pcabvalidaty = "Required";
    if (!contractor || !contractor.tin) errors.tin = "Required";
    if (!contractor || !contractor.managingofficer || !contractor.managingofficer.name) errors.managingofficername = "Required";
    if (!contractor || !contractor.managingofficer || !contractor.managingofficer.email) errors.managingofficeremail = "Required";

    if (hasErrors(errors)) {
      setErrors(errors);
      return false;
    } else {
      setErrors({});
      return true;
    }
  }

  const updatePermit = () => {
    if (!isContracted || isValid()) {
      setLoading(true);
      const updatedApp = {
        objid: app.objid,
        contractorid: app.contractorid,
        contractor: app.contractor
      }
      appService.invoke("update", updatedApp, (err, app) => {
        if (err) {
          setError(err)
        } else {
          moveNextStep();
        }
        setLoading(false);
      })
    }
  }

  return (
    <Panel>
      <Label>Please specify contractor if available</Label>
      <Spacer />
      <Checkbox value={isContracted} onChange={setIsContracted} caption="Is undertaken by a Contractor?" />
      <FormPanel visibleWhen={isContracted} context={app} handler={setApp}>
        <Text name="contractor.name" caption="Contractor" required={true} error={errors.name} />
        <Text name="contractor.address" caption="Address" required={true} error={errors.address} />
        <Text name="contractor.pcabno" caption="PCAB License No." required={true} error={errors.pcabno} />
        <Date name="contractor.pcabvalidaty" caption="Validity Date" required={true} error={errors.pcabvalidaty} />
        <Text name="contractor.tin" caption="TIN" required={true} error={errors.tin} />
        <Text name="contractor.managingofficer.name" caption="Authorized Managing Officer" required={true} error={errors.managingofficername} />
        <Email name="contractor.managingofficer.email" required={true} error={errors.managingofficeremail} />
      </FormPanel>
      <ActionBar>
        <BackLink action={movePrevStep} />
        <Button caption="Next" action={updatePermit} />
      </ActionBar>
    </Panel>
  )
}

export default Contractor;
