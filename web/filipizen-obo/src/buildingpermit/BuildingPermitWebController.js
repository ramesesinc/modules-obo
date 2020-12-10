import React, { useState, useEffect } from 'react';
import {
  Panel,
  Card,
  Title,
  Service,
  Stepper,
  getUrlParameter,
  Page
} from 'rsi-react-web-components';

const svc = Service.lookup("OnlineBuildingPermitService", "obo");

import ApplicationTypeSelect from "../components/ApplicationTypeSelect";
import BuildingPermitInitial from "./BuildingPermitInitial";
import BuildingPermitApplicant from "./BuildingPermitApplicant";
import BuildingRealPropertyInfo from "./BuildingRealPropertyInfo";
import BuildingPermitLocation from "./BuildingPermitLocation";
import BuildingPermitProject from "./BuildingPermitProject";
import BuildingPermitSupervisor from "./BuildingPermitSupervisor";
import BuildingPermitOccupancy from "./BuildingPermitOccupancy";
import BuildingPermitAccessories from "./BuildingPermitAccessories";
import BuildingPermitOtherPermits from "./BuildingPermitOtherPermits";
import BuildingPermitConfirm from "./BuildingPermitConfirm";
import BuildingPermitCompleted from "./BuildingPermitCompleted";

const pages = [
  { step: 0, component: null },
  { step: 1, name: 'applicant', caption: 'Applicant', component: BuildingPermitApplicant },
  { step: 2, name: 'rpu', caption: 'Real Property Info', component: BuildingRealPropertyInfo },
  { step: 3, name: 'location', caption: 'Project Location', component: BuildingPermitLocation },
  { step: 4, name: 'project', caption: 'Project Details', component: BuildingPermitProject },
  { step: 5, name: 'supervisor', caption: 'Supervisor', component: BuildingPermitSupervisor },
  { step: 6, name: 'occupancy', caption: 'Occupancy Type', component: BuildingPermitOccupancy },
  { step: 7, name: 'accessories', caption: 'Accessories', component: BuildingPermitAccessories },
  { step: 8, name: 'ancillarylist', caption: 'Other Permits', component: BuildingPermitOtherPermits },
  { step: 9, name: 'confirm', caption: 'Confirm', component: BuildingPermitConfirm },
  { step: 10, name: 'completed', caption: 'Completed', component: BuildingPermitCompleted },
]

const BuildingPermitWebController = (props) => {
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(false);
  const [mode, setMode] = useState("init");
  const [appno, setAppno] = useState(getUrlParameter(props.location, "appid"));
  const [hash, setHash] = useState();
  const [app, setApp] = useState({step: 1});
  const [step, setStep] = useState(1)
  const [errorText, setErrorText] = useState({});

  const { partner, service, history } = props;

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
    svc.invoke("findCurrentInfo", {appid: appno}, (err, app) => {
      const orgcode = partner.orgcode || partner.id;
      if (err) {
        setError(err);
      } else {
        if(!app) {
          setError("Application no. does not exist");
          findAppError();
        } else if( orgcode != app.orgcode ) {
          setError("The application number provided is not for this local government");
          findAppError();
        } else {
          setApp(app);
          setStep(app.step);
          setMode("processing");
          const page = pages[app.step];
          props.history.push(`${location.pathname}?appid=${appno}#${page.name}`);
        }
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

  const onCreateNewApp = (appno) => {
    setAppno(appno);
    setMode("processing");
  }

  const processAppType = ({appType, appno}) => {
    if (appType === "new") {
      setMode(appType);
    } else {
      if (appno) {
        setAppno(appno);
      }
    }
  }

  const moveNextStep = () => {
    const stepCompleted = step < app.step && step !== 1;
    if (stepCompleted) {
      setStep(ps => ps + 1);
    } else {
      svc.invoke("update", {appid: appno, step: step+1}, (err, updatedApp) => {
        if (err) {
          setError(err);
        } else {
          setStep(updatedApp.step);
          setApp({...app, step: updatedApp.step});
        }
      });
    }
  }

  const handleStep = (step) => {
    setStep(step);
    const page = pages[step];
    props.history.push(`${location.pathname}?appid=${appno}#${page.name}`);
  }

  if (mode === "init") {
    return <div></div>
  }

  if (mode === "apptype") {
    return (
      <ApplicationTypeSelect partner={partner} appService={svc} service={service} error={error} onCancel={history.goBack} onSubmit={processAppType}  />
    )
  }

  if (mode === "new") {
    return (
      <BuildingPermitInitial {...props} handler={onCreateNewApp} onCancel={()=> props.history.goBack()} />
    )
  }

  const page = pages[step];
  const PageComponent = page.component;
  const compProps = {
    partner,
    appno,
    pages,
    moveNextStep,
    appService: svc,
    stepCompleted: step < app.step
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
        <PageComponent page={page} {...compProps} />
      </Card>
    </Page>
  )
}

const styles = {
  stepperContainer: {
    paddingTop: 10,
    paddingLeft: 40,
  }
}

export default BuildingPermitWebController
