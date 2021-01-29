import React, { useState, useEffect } from "react";
import {
  Panel,
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
    setLoading(true);
    appService.invoke("getProfessionals", {appid: appno}, (err, professionals) => {
      if (err) {
        setError(err);
      } else {
        setProfessionals(professionals);
      }
      setLoading(false);
    });
  }, [appno])

  const onSelectProfessional = (professional, idx) => {
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
        {professionals.map((prof, idx) => {
          if (!prof.section.designprofessionalrole) return null;
          return (
            <div key={prof.objid}>
              {prof.designprofessionalid ? (
                <ProfessionalCard
                caption={`${prof.sectionid} Design Professional`}
                professional={professionals[idx].designprofessional}
                onSelectProfessional={(professional) => onSelectProfessional(professional, idx)}
                role={prof.section.designprofessionalrole}
              />
              ) : (
                <ProfessionalLookup
                  caption={`${prof.sectionid} Design Professional`}
                  searchFieldTitle="Please input the 7-digit PRC ID Number and click search"
                  onSelect={(professional) => onSelectProfessional(professional, idx)}
                  role={prof.section.designprofessionalrole}
                />
              )}
            </div>
          )
        })}
        <ActionBar>
          <BackLink action={movePrevStep} />
          <Button caption="Next" action={updateProfessionals} disableWhen={loading} loading={loading} />
        </ActionBar>
      </Panel>

      <Panel visibleWhen={mode === "supervisor"}>
        <h3>List of Supervisors</h3>
        {professionals.map((prof, idx) => {
          if (!prof.section.supervisorrole) return null;
          return (
            <div key={prof.objid}>
              {prof.supervisorid ? (
                <ProfessionalCard
                caption={`${prof.sectionid} Supervisor`}
                professional={professionals[idx].supervisor}
                onSelectProfessional={(professional) => onSelectProfessional(professional, idx)}
                role={prof.section.supervisorrole}
              />
              ) : (
                <ProfessionalLookup
                  caption={`${prof.sectionid} Supervisor`}
                  searchFieldTitle=""
                  onSelect={(professional) => onSelectProfessional(professional, idx)}
                  role={prof.section.supervisorrole}
                />
              )}
            </div>
          )
        })}
        <ActionBar>
          <BackLink action={() => setMode("design")} />
          <Button caption="Next" action={updateProfessionals} disableWhen={loading} loading={loading} />
        </ActionBar>
      </Panel>
    </Panel>
  )
}


export default Professionals;
