import React, { useState } from 'react';
import {
  Service,
  Stepper,
  Page,
  Panel,
  Title,
  Card,
  Error,
  StateProvider
} from 'rsi-react-web-components';

export const ACTIONS = {
  SET_PROFESSIONAL: "SET_PROFESSIONAL",
  SET_CHANGE_TYPE: "SET_CHANGE_TYPE",
}

const initialState = {
  professional: {},
  changeType: null,
}

const reducer = (draft, action) => {
  switch(action.type) {
    case ACTIONS.SET_PROFESSIONAL:
      draft.professional = action.professional;
      return;

    case ACTIONS.SET_CHANGE_TYPE:
      draft.changeType = action.changeType;
      return;
  }
}


import Initial from "./Initial";
import ChangeType from "./ChangeType";
import EditInfo from "./EditInfo";
import Success from "../components/Success";

const svc = Service.lookup("OboProfessionalService", "obo");

const pages = [
  { step: 0, component: null },
  { step: 1, name: "initial", caption: "Initial", component: Initial },
  { step: 2, name: "changetype", caption: "Change Type", component: ChangeType },
  { step: 3, name: "editinfo", caption: "Edit Information", component: EditInfo},
  { step: 4, name: "success", caption: "Success", component: Success },
]

const UpdateProfessionalWebController = ({
  partner,
  service,
  history
}) => {
  const [step, setStep] = useState(1);

  const moveNextStep = () => {
    setStep(cs => cs+1);
  }

  const movePrevStep = () => {
    setStep(cs => cs-1);
  }

  const onClose = () => {
    history.goBack();
  }

  const page = pages[step];
  const PageComponent = page.component;
  const compProps = {
    partner,
    service,
    appService: svc,
    moveNextStep,
    movePrevStep,
    history,
    page,
    onClose,
    msg: page.name === "success" ? "You have successfully updated your professional information." : null
  };

  return (
    <StateProvider initialState={initialState} reducer={reducer}>
      <Page>
        <Panel target="left" style={styles.stepperContainer} >
          <Stepper steps={pages} activeStep={step - 1} />
        </Panel>
        <Card>
          <Title>{service.title}</Title>
          <PageComponent page={page} {...compProps} />
        </Card>
      </Page>
    </StateProvider>
  )
}

const styles = {
  stepperContainer: {
    paddingTop: 30,
    paddingLeft: 40,
  }
}

export default UpdateProfessionalWebController
