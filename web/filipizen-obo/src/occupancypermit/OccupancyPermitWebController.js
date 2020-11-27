import React, { useState, useEffect } from 'react';
import {
  Service,
  getUrlParameter,
  Stepper,
  Page,
  Panel,
  Title,
  Subtitle,
  Subtitle2,
  Card,
  Spacer,
  Error,
} from 'rsi-react-web-components';

import ApplicationTypeSelect from "../components/ApplicationTypeSelect";
import Applicant from "./Applicant";
import OccupancyPermitInitial from "./OccupancyPermitInitial";
import OccupancyType from "./OccupancyType";
import PlannedVsActual from "./PlannedVsActual";
import ActualCost from "./ActualCost";
import OtherCost from "./OtherCost";
import Contractor from "./Contractor";
import Professionals from "./Professionals";
import Confirmation from "./Confirmation";
import Completed from "./Completed";


const svc = Service.lookup("OnlineOccupancyPermitService", "obo");

const pages = [
  { step: 0, component: null },
  { step: 1, name: 'apptype', caption: 'Application Type', component: OccupancyType },
  { step: 2, name: 'applicant', caption: 'Applicant', component: Applicant },
  { step: 3, name: 'actualcost', caption: 'Actual Costs', component: ActualCost },
  { step: 4, name: 'othercost', caption: 'Fire Safety Costs', component: OtherCost },
  { step: 5, name: 'plannedactual', caption: 'Planned vs Actual', component: PlannedVsActual },
  { step: 6, name: 'contractor', caption: 'Contractor', component: Contractor },
  { step: 7, name: 'professionals', caption: 'Professionals', component: Professionals },
  { step: 8, name: 'confirmation', caption: 'Confirmation', component: Confirmation },
  { step: 9, name: 'completed', caption: 'Completed', component: Completed },
]

const OccupancyPermitWebController = (props) => {
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(false);
  const [mode, setMode] = useState("apptype");
  const [appType, setAppType] = useState("full");
  const [appno, setAppno] = useState(getUrlParameter(props.location, "appid"));
  const [app, setApp] = useState({});
  const [step, setStep] = useState(0)

  const { partner, service } = props

  const handleError = (err) => {
    setLoading(false);
    setError(err.toString());
  }

  const findCurrentApp = () => {
    if (!appno) return;
    setLoading(true);
    svc.invoke("findCurrentInfo", {appid: appno}, (err, app) => {
      if (err) {
        setError(err);
      } else {
        if(!app) {
          setError("Application no. does not exist");
        }
        if( partner.id != app.orgcode ) {
          setError("The application number provided is not for this local government");
        }
        setApp(app);
        setStep(app.step);
        setMode("processing");
      }
      setLoading(false);
    });
  }

  useEffect(() => {
    findCurrentApp();
  }, [appno]);

  const onCompleteInitial = ({appType, appno}) => {
    setAppno(appno);
    setStep(step + 1);
    setMode("processing");
  }

  const moveNextStep = () => {
    if (app.step == pages.length - 1) return;

    setError(null);
    const nextStep = step < app.step ? app.step : step + 1;
    svc.invoke("update", {objid: appno, step: nextStep }, (err, updatedApp) => {
      if (!err) {
        setStep(nextStep);
        setApp({...app, step: nextStep});
      } else {
        setError(err);
      }
    })
  }

  const movePrevStep = () => {
    setStep(ps => ps - 1);
  }

  const onSubmitOccupancyType = (appType) => {
    setAppType(appType);
    moveNextStep();
  }

  const handleStep = (step) => {
    setStep(step);
  }

  const submitAppType = ({appType, appno}) => {
    setError(null);
    if (appType === "new") {
      setMode("init");
    } else {
      svc.invoke("findCurrentInfo", {appid: appno}, (err, app) => {
        if (err) {
          setError(err);
        } else if (!app) {
          setError("Application no. does not exist.");
        } else {
          onCompleteInitial({appType, appno});
        }
      })
    }
  }

  const onComplete = () => {
    moveNextStep();
  }

  if (mode === "apptype") {
    return (
      <ApplicationTypeSelect service={props.service} error={error} onCancel={() => props.history.goBack()} onSubmit={submitAppType}  />
    )
  }

  if (mode === "init") {
    return (
      <OccupancyPermitInitial {...props} appService={svc} onComplete={onCompleteInitial} onCancel={()=> props.history.goBack()} />
    )
  }

  const page = pages[step];
  const PageComponent = page.component;
  const compProps = {
    partner,
    appno,
    pages,
    moveNextStep,
    movePrevStep,
    appService: svc,
    currentStep: step,
    stepCompleted: step < app.step,
    onComplete,
    history: props.history,
  };

  return (
    <Page>
      {app.step < 9 &&
        <Panel target="left" style={styles.stepperContainer} >
          <Stepper steps={pages} completedStep={app.step} activeStep={step} handleStep={handleStep} />
        </Panel>
      }
      <Card>
        <Title>{service.title}</Title>
        <Subtitle2>{`Tracking No. ${appno}`}</Subtitle2>
        <Subtitle>{page.caption}</Subtitle>
        <Spacer />
        <Error msg={error} />
        <PageComponent page={page} {...compProps} />
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

export default OccupancyPermitWebController
