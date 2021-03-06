import React, { useState, useEffect } from "react";
import {
  ActionBar,
  Button,
  Panel,
  Error,
  Spacer,
  BackLink,
} from "rsi-react-web-components";

import ProfessionalCard from "../components/ProfessionalCard";
import ProfessionalLookup from "../components/ProfessionalLookup";

const Supervisor = ({
  partner,
  appno,
  appService,
  movePrevStep,
  moveNextStep,
}) => {
  const [error, setError] = useState();
  const [errors, setErrors] = useState({});
  const [loading, setLoading] = useState(false);
  const [app, setApp] = useState({});
  const [professional, setProfessional] = useState();

  useEffect(() => {
    appService.invoke("getApplication", {appid: appno}, (err, app) => {
      if (err) {
        setError(err);
      } else {
        console.log("app.supervisor", app.supervisor)
        setProfessional(app.supervisor);
        setApp(app);
      }
    });
  }, [])

  const onSelectProfessional = (professional) => {
    appService.invoke("update", {objid: app.objid, supervisorid: professional.objid}, (err, app) => {
      if (err) {
        setError(err);
      } else {
        setError(null);
        setProfessional(professional);
      }
    });
  }

  const submitProfessional = () => {
    if (!professional) {
      setError("Please select a professional.")
    } else {
      moveNextStep();
    }
  }

  return (
    <Panel>
      <label>Specify full time inspector and supervisor of construction work</label>
      <Error msg={error} />
      <Spacer />
      <Panel>
        {professional && professional.lastname ? (
          <ProfessionalCard
            caption="Inspector/Supervisor"
            professional={professional}
            onSelectProfessional={onSelectProfessional}
          />
        ) : (
          <ProfessionalLookup
            caption="Inspector/Supervisor"
            searchFieldTitle=""
            onSelect={onSelectProfessional}
          />
        )}
      </Panel>
      <ActionBar>
        <BackLink action={movePrevStep} />
        <Button caption="Next" action={submitProfessional} disableWhen={!professional || !professional.objid} />
      </ActionBar>
    </Panel>
  )
}


export default Supervisor
