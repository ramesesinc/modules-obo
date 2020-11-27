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
        app.contractor = app.contractor || {pcab:{}, manager: {}}
        if (app.contractor && app.contractor.name) {
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
    if (!contractor || !contractor.pcab || !contractor.pcab.idno) errors.pcab.idno = "Required";
    if (!contractor || !contractor.pcab || !contractor.pcab.dtvalid) errors.pcab.dtvalid = "Required";
    if (!contractor || !contractor.tin) errors.tin = "Required";
    if (!contractor || !contractor.manager || !contractor.manager.name) errors.manageroffice = "Required";
    if (!contractor || !contractor.manager || !contractor.manager.email) errors.manageremail = "Required";

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
        <Text name="contractor.pcab.idno" caption="PCAB License No." required={true} error={errors.pcabidno} />
        <Date name="contractor.pcab.dtvalid" caption="Validity Date" required={true} error={errors.pcabdtvalid} />
        <Text name="contractor.tin" caption="TIN" required={true} error={errors.tin} />
        <Text name="contractor.manager.name" caption="Authorized Managing Officer" required={true} error={errors.manageroffice} />
        <Email name="contractor.manager.email" required={true} error={errors.manageremail} />
      </FormPanel>
      <ActionBar>
        <BackLink action={movePrevStep} />
        <Button caption="Next" action={updatePermit} />
      </ActionBar>
    </Panel>
  )
}

export default Contractor;
