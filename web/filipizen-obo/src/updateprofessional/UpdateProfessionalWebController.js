import React, { useState } from 'react';
import {
  Service,
  Stepper,
  Page,
  Panel,
  Title,
  Card,
  Error
} from 'rsi-react-web-components';

import Initial from "./Initial";
import EditProfessional from "./EditProfessional";
import Success from "../components/Success";

const svc = Service.lookup("OboProfessionalService", "obo");

const steps = [
  { step: 1, name: "initial", caption: "Initial" },
  { step: 2, name: "editinfo", caption: "Edit Information" },
  { step: 3, name: "success", caption: "Success" },
]

const UpdateProfessionalWebController = (props) => {
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(false);
  const [errorText, setErrorText] = useState({});
  const [mode, setMode] = useState("new");
  const [step, setStep] = useState(0);
  const [key, setKey] = useState();
  const [professional, setProfessional] = useState({});

  const { partner, service, history } = props;

  const handleError = (err) => {
    setLoading(false);
    setError(err.toString());
  }

  const moveNextStep = () => {
    setStep(cs => cs+1);
  }

  const movePrevStep = () => {
    setStep(cs => cs-1);
  }

  const activeStep = steps[step];

  const onVerifiedProfessional = (professional) => {
    setProfessional(professional);
    moveNextStep();
  }

  return (
    <Page>
      <Panel target="left" style={styles.stepperContainer} >
        <Stepper steps={steps} activeStep={step} />
      </Panel>
      <Card>
        <Title>{service.title}</Title>
        <Error msg={error} />
        <Panel visibleWhen={activeStep.name === "initial"}>
          <Initial partner={partner} onCancel={history.goBack} onVerified={onVerifiedProfessional} />
        </Panel>
        <Panel visibleWhen={activeStep.name === "editinfo"}>
          <EditProfessional
            appService={svc}
            partner={partner}
            professional={professional}
            onCancel={movePrevStep}
            onSubmit={moveNextStep}
          />
        </Panel>
        <Panel visibleWhen={activeStep.name === "success"}>
          <Success
            onClose={() => history.goBack()}
            msg="You have successfully updated your professional information."
          />
        </Panel>
      </Card>
    </Page>
  )
}

const styles = {
  stepperContainer: {
    paddingTop: 30,
    paddingLeft: 40,
  }
}

export default UpdateProfessionalWebController
