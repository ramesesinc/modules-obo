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
  LinearProgress
} from 'rsi-react-web-components';

import ApplicationTypeSelect from "../components/ApplicationTypeSelect";
import Applicant from "./Applicant";
import OccupancyPermitInitial from "./OccupancyPermitInitial";
import OccupancyType from "./OccupancyType";
import PlannedVsActual from "./PlannedVsActual";
import ActualCost from "./ActualCost";
import FireCodeFees from "./FireCodeFees";
import Contractor from "./Contractor";
import Professionals from "./Professionals";
import Supervisor from "./Supervisor";
import Confirmation from "./Confirmation";
import Completed from "./Completed";


const svc = Service.lookup("OnlineOccupancyPermitService", "obo");

const pages = [
  { step: 0, component: null },
  { step: 1, name: 'apptype', caption: 'Application Type', component: OccupancyType },
  { step: 2, name: 'applicant', caption: 'Applicant', component: Applicant },
  { step: 3, name: 'actualcost', caption: 'Actual Costs', component: ActualCost },
  { step: 4, name: 'firecodefee', caption: 'Fire Code Fees', component: FireCodeFees },
  { step: 5, name: 'plannedactual', caption: 'Planned vs Actual', component: PlannedVsActual },
  { step: 6, name: 'contractor', caption: 'Contractor', component: Contractor },
  { step: 7, name: 'professionals', caption: 'Professionals', component: Professionals },
  { step: 8, name: 'supervisor', caption: 'Supervisor', component: Supervisor },
  { step: 9, name: 'confirmation', caption: 'Confirmation', component: Confirmation },
  { step: 10, name: 'completed', caption: 'Completed', component: Completed },
]

const OccupancyPermitWebController = (props) => {
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(false);
  const [mode, setMode] = useState("init");
  const [appType, setAppType] = useState("full");
  const [appno, setAppno] = useState(getUrlParameter(props.location, "appid"));
  const [hash, setHash] = useState();
  const [app, setApp] = useState({});
  const [step, setStep] = useState(1)

  const { partner, service } = props

  if (hash !== props.location.hash) {
    setHash(props.location.hash);
  }

  const findAppError = () => {
    if (mode === "init") {
      setMode("apptype");
      props.history.push(`${location.pathname}`);
    }
  }

  const findCurrentApp = () => {
    setLoading(true);
    svc.invoke("findCurrentInfo", {appid: appno}, (err, app) => {
      if (err) {
        setError(err);
      } else {
        if(!app) {
          setError("Application no. does not exist");
          findAppError();
        }
        if( partner.id != app.orgcode ) {
          setError("The application number provided is not for this local government");
          setMode("init");
          return;
        }
        setApp(app);
        setStep(app.step);
        setMode("processing");
        const page = pages[app.step];
        props.history.push(`${location.pathname}?appid=${appno}#${page.name}`);
      }
      setLoading(false);
    });
  }

  useEffect(() => {
    if (appno) {
      setLoading(true);
      findCurrentApp();
    } else {
      setMode("apptype");
    }
  }, [appno]);

  useEffect(() => {
    if (hash) {
      const page = pages.find(page => page.name === hash.substring(1));
      setStep(page.step);
    }
  }, [hash]);

  const onCompleteInitial = ({appno}) => {
    setAppno(appno);
    setStep(1);
    setMode("processing");
  }

  const moveNextStep = (state) => {
    if (app.step == pages.length - 1) return;

    setError(null);
    const nextStep = step < app.step ? app.step : step + 1;
    svc.invoke("update", {objid: appno, state, step: nextStep }, (err, updatedApp) => {
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

  const handleStep = (step) => {
    setStep(step);
    const page = pages[step];
    props.history.push(`${location.pathname}?appid=${appno}#${page.name}`);
  }

  const submitAppType = ({appType, appno, appStep=1}) => {
    setError(null);
    if (appType === "new") {
      setMode("new");
    } else {
      svc.invoke("findCurrentInfo", {appid: appno}, (err, app) => {
        if (err) {
          setError(err);
        } else {
          onCompleteInitial({appType, appno, step: app.step});
        }
      })
    }
  }

  const onComplete = () => {
    moveNextStep('END');
  }

  if (mode === "init" || loading) {
    return (
      <div>
        <LinearProgress />
      </div>
    )
  }

  if (mode === "apptype") {
    return (
      <ApplicationTypeSelect appService={svc} partner={partner} service={props.service} error={error} onCancel={() => props.history.goBack()} onSubmit={submitAppType}  />
    )
  }

  if (mode === "new") {
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
      {app.step < pages.length - 1 &&
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
    paddingLeft: 40,
  }
}

export default OccupancyPermitWebController
