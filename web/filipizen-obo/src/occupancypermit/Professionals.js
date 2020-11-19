import React, { useState, useEffect } from "react";
import {
  Panel,
  Spacer,
  ActionBar,
  Button,
  BackLink

} from 'rsi-react-web-components';

import ProfessionalLookup from "../components/ProfessionalLookup";
import ProfessionalCard from "../components/ProfessionalCard";

const Professionals = ({
  appno,
  appService,
  movePrevStep,
  moveNextStep,
}) => {

  const [error, setError] = useState();
  const [loading, setLoading] = useState(false);
  const [mode, setMode] = useState("design");
  const [professionals, setProfessionals] = useState([]);

  useEffect(() => {
    appService.invoke("getProfessionals", {appid: appno}, (err, professionals) => {
      if (err) {
        setError(err);
      } else {{
        setProfessionals(professionals);
      }}
    });
  }, [appno])

  const onSelectProfessional = (profList, idx) => {
    console.log("idx", idx)
    if (profList.length === 0) {
      setProfessional({});
      return;
    }

    const professional = profList[0];
    const updatedProfessional = professionals[idx];
    if (mode === "design") {
      updatedProfessional.designprofessionalid = professional.objid;
      updatedProfessional.designprofessional = professional;
    } else {
      updatedProfessional.supervisorid = professional.objid;
      updatedProfessional.supervisor = professional;
    }
    const updatedProfessionals = [...professionals];
    updatedProfessionals[idx] = updatedProfessional;
    setProfessionals(updatedProfessionals);
  }

  const updateProfessionals = () => {
    setLoading(true);
    appService.invoke("updateProfessionals", professionals, (err, professionals) => {
      if (err) {
        setError(err);
      } else {
        if (mode === "design") {
          setMode("supervisor");
        } else {
          moveNextStep();
        }
      }
      setLoading(false);
    });
  }

  return (
    <Panel>
      <Panel visibleWhen={mode === "design"}>
        <h3>List of Design Professionals</h3>
        {professionals.map((prof, idx) => (
          <div key={prof.objid}>
            {prof.designprofessionalid ? (
              <ProfessionalCard
              caption={prof.sectionid}
              professional={professionals[idx].designprofessional}
              onSelectProfessional={(professionals) => onSelectProfessional(professionals, idx)}
            />
            ) : (
              <ProfessionalLookup
                caption={`${prof.sectionid} Design Professional`}
                searchFieldTitle=""
                onSelect={(professionals) => onSelectProfessional(professionals, idx)}
               />
            )}
          </div>
        ))}
        <ActionBar>
          <BackLink action={movePrevStep} />
          <Button caption="Next" action={updateProfessionals} disableWhen={loading} />
        </ActionBar>
      </Panel>

      <Panel visibleWhen={mode === "supervisor"}>
        <h3>List of Supervisors</h3>
        {professionals.map((prof, idx) => (
          <div key={prof.objid}>
            {prof.supervisorid ? (
              <ProfessionalCard
              caption={prof.sectionid}
              professional={professionals[idx].supervisor}
              onSelectProfessional={(professionals) => onSelectProfessional(professionals, idx)}
            />
            ) : (
              <ProfessionalLookup
                caption={`${prof.sectionid} Supervisor`}
                searchFieldTitle=""
                onSelect={(professionals) => onSelectProfessional(professionals, idx)}
               />
            )}
          </div>
        ))}
        <ActionBar>
          <BackLink action={() => setMode("design")} />
          <Button caption="Next" action={updateProfessionals} disableWhen={loading} />
        </ActionBar>
      </Panel>
    </Panel>
  )
}


export default Professionals;
