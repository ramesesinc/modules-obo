import React, { useState } from 'react'
import { Page, Panel, StateProvider, Content } from "rsi-react-web-components";
import "rsi-react-web-components/dist/index.css";

import { ContactVerification } from 'rsi-react-filipizen-components'

const initialState = {
  txntype: "obo",
  contact: {},
  refno: null,
  apptype: null,
  bill: {},
}

const reducer = (draft, action) => {
  switch(action.type) {
    case "SET_BILL":
      draft.refno = action.refno;
      draft.apptype = action.apptype;
      draft.bill = action.bill;
      return;

    case "SET_CONTACT":
      draft.contact = action.contact;
      return;
  }
}

import InitialInfo from "./InitialInfo";
import Payment from "./Payment";

const pages = [
  {step: 1, name: "verification", caption: "Verification", Component: ContactVerification},
  {step: 2, name: "initial", caption: "Initial Information", Component: InitialInfo},
  {step: 3, name: "payment", caption: "Payment", Component: Payment},
]

const OboBillingWebController = ({
  partner,
  service,
  location,
  history,
  initialStep=0
}) => {

  const [step, setStep] = useState(initialStep);

  const moveNextStep = () => {
    setStep(cs => cs+1);
  }

  const movePrevStep = () => {
    if (step === 0) {
      history.goBack();
    } else {
      setStep(cs => cs-1);
    }
  }

  const cancelPayment = () => {
    setStep(1);
  }

  const page = pages[step];
  const PageComponent = page.Component;
  const compProps = {
    partner,
    service,
    location,
    history,
    moveNextStep,
    movePrevStep,
    cancelPayment,
    title: "Building Permit Online Billing",
  };

  return (
    <StateProvider initialState={initialState} reducer={reducer}>
      <Page>
        <Content center>
          <Panel>
            <PageComponent page={page} {...compProps} />
          </Panel>
        </Content>
      </Page>
    </StateProvider>
  )
};

export default OboBillingWebController;
