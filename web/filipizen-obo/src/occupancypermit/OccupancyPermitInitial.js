import React, { useState } from "react";
import {
  Panel,
  Card,
  Title,
  Page,
  Text,
  Subtitle,
  Spacer,
  ActionBar,
  BackLink,
  Button,
  FormPanel,
  Decimal,
  Service,
} from 'rsi-react-web-components';

import { EmailVerification } from 'rsi-react-filipizen-components'
import Confirmation from "../components/Confirmation";
import TrackingInfo from "../components/TrackingInfo";


const steps = [
  {name: "email", title: "Email Verification"},
  {name: "specifybldgpermit", title: "Specify Building Permit"},
  {name: "verifybldgpermit", title: "Verify Building Permit Information"},
  {name: "confirmation", title: "Confirmation"},
  {name: "newapp", title: "New Application "},
]

const OccupancyPermitInitial = ({
  partner,
  service,
  onComplete,
  appService,
  onCancel
}) => {

  const [error, setError] = useState();
  const [errorText, setErrorText] = useState({});
  const [contact, setContact] = useState({});
  const [appType, setAppType] = useState("new");
  const [appno, setAppno] = useState();
  const [bldgPermitNo, setBldgPermitNo] = useState();
  const [bldgPermit, setBldgPermit] = useState({});
  const [activeStep, setActiveStep] = useState(0);


  const step = steps[activeStep];

  const moveNextStep = () => {
    setActiveStep(cs => cs + 1);
  }

  const movePrevStep = () => {
    setActiveStep(cs => cs-1);
  }

  const exitInitial = () => {
    onComplete({appType: "new", appno});
  }

  const onVerifyEmail = (contact) => {
    setContact(contact);
    moveNextStep();
  }

  const loadBuildingPermit = () => {
    if (bldgPermitNo) {
      setError(null);
      const svc = Service.lookup(`${partner.id}:OboOnlineService`, "obo");
      svc.invoke("findBldgPermitNo", {permitno: bldgPermitNo}, (err, permit) => {
        if (err) {
          setError(err);
        } else {
          setBldgPermit(permit);
          moveNextStep();
        }
      })
    } else {
      setErrorText({bldgPermitNo: "Please specify the Building Permit No."});
    }
  }

  const submitBuildingPermit = () => {
    moveNextStep();
  }

  const saveApp = () => {
    const newApp = {
      orgcode: partner.id,
      apptype: appType,
      permittype: bldgPermit.apptype,
      applicant: bldgPermit.applicant,
      bldgpermit: bldgPermit,
      contact
    }

    appService.invoke("create", newApp, (err, app) => {
      if (err) {
        setError(err);
      } else {
        setAppno(app.objid)
        moveNextStep();
      }
    });
  }

  if (step.name === "email") {
    return (
      <Page>
          <EmailVerification
            title={service.title}
            showName={true}
            onCancel={onCancel}
            onVerify={onVerifyEmail}
            partner={partner}
            connection="obo"
          />
      </Page>
    )
  }

  return (
    <Page>
      <Card>
        <Title>{service.title}</Title>

        <Panel visibleWhen={step.name === "specifybldgpermit"}>
          <Subtitle>{step.title}</Subtitle>
          <Spacer height={30} />
          <Text
            caption="Building Permit No."
            value={bldgPermitNo} onChange={setBldgPermitNo}
            variant="outlined"
            fullWidth={false}
            required
            error={errorText.bldgPermitNo || error}
            helperText={errorText.bldgPermitNo || error}
            size="small"
            autoFocus={true}
            />
          <ActionBar>
            <BackLink action={movePrevStep} />
            <Button caption="Next" action={loadBuildingPermit} />
          </ActionBar>
        </Panel>

        <FormPanel visibleWhen={step.name === "verifybldgpermit"} context={bldgPermit} handler={setBldgPermit}>
          <Subtitle>Verify Building Permit Information</Subtitle>
          <Spacer height={30} />
          <Text caption="Building Permit No." name="permitno" readOnly={true} />
          <Text caption="Applicant" name="applicant.name" readOnly={true} />
          <Spacer />
          <Text caption="Project Title" name="title" readOnly={true} />
          <Text caption="Location" name="location.text" readOnly={true} />
          <Decimal caption="Project Cost" name="projectcost" readOnly={true} />
          <ActionBar>
            <BackLink action={movePrevStep} />
            <Button caption="Next" action={submitBuildingPermit} />
          </ActionBar>
        </FormPanel>

        <Panel visibleWhen={step.name === "confirmation"}>
          <Confirmation partner={partner} error={error} onCancel={movePrevStep} onContinue={saveApp} />
        </Panel>

        <Panel visibleWhen={step.name === "newapp"} width={400}>
          <TrackingInfo appno={appno} onContinue={exitInitial} />
        </Panel>
      </Card>
    </Page>
  )
}


export default OccupancyPermitInitial;
