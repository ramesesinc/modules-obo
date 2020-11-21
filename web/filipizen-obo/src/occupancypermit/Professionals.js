import React, { useState, useEffect } from "react";
import {
  Panel,
  ActionBar,
  Button,
  BackLink,
  Service,
  MsgBox
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
  const [showError, setShowError] = useState(false);
  const [errorMsg, setErrorMsg] = useState();
  const [loading, setLoading] = useState(false);
  const [mode, setMode] = useState("design");
  const [permitTypes, setPermitTypes] = useState([]);
  const [professionals, setProfessionals] = useState([]);

  const loadProfessionals = () => {
    appService.invoke("getProfessionals", {appid: appno}, (err, professionals) => {
      if (err) {
        setError(err);
      } else {
        setProfessionals(professionals);
      }
      setLoading(false);
    });
  }

  useEffect(() => {
    setLoading(true);
    const svc = Service.lookup("OboMiscListService", "obo");
    svc.invoke("getPermitTypes", null, (err, permitTypes) => {
      if (err) {
        setError(err);
      } else {
        console.log("permitTypes",permitTypes)
        setPermitTypes(permitTypes);
        loadProfessionals();
      }
    });
  }, [appno])


  const validProfession = (professional, permitType) => {
    const validRole = (mode === "design" ? permitType.designprofessionalrole : permitType.supervisorrole).toLowerCase();
    let valid = validRole.indexOf(professional.profession.toLowerCase()) >= 0;

    let requiredRoles = ""
    if (!valid) {
      const roles = validRole.split(",");
      if(roles.length == 1) {
        requiredRoles = "Only " + roles[0].toLowerCase() + " profession is allowed."
      } else {
        requiredRoles = "Only " + roles.join(", ") + " professions are allowed."
        const lastCommaIdx = requiredRoles.lastIndexOf(",");
        requiredRoles = requiredRoles.substring(0, lastCommaIdx) + " and " + requiredRoles.substring(lastCommaIdx+2);
      }

      let msg = "The profession of the selected professional is invalid. " + requiredRoles;
      setErrorMsg(msg);
      return false;
    }
    return true;
  }

  const onSelectProfessional = (profList, permitType, idx) => {
    if (profList.length === 0) {
      setProfessional({});
      return;
    }

    const professional = profList[0];
    if (!validProfession(professional, permitType)) {
      setShowError(true);
      return;
    }

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
      <MsgBox title="Invalid Profession" open={showError} msg={errorMsg} onAccept={() => setShowError(false)} />
      <Panel visibleWhen={mode === "design"}>
        <h3>List of Design Professionals</h3>
        {professionals.map((prof, idx) => {
          const permitType = permitTypes.find(pt => pt.objid.toLowerCase() === prof.sectionid.toLowerCase())
          if (!permitType) return null;
          if (!permitType.designprofessionalrole) return null;

          return (
            <div key={prof.objid}>
              {prof.designprofessionalid ? (
                <ProfessionalCard
                caption={`${prof.sectionid} Design Professional`}
                professional={professionals[idx].designprofessional}
                onSelectProfessional={(professionals) => onSelectProfessional(professionals, permitType, idx)}
              />
              ) : (
                <ProfessionalLookup
                  caption={`${prof.sectionid} Design Professional`}
                  searchFieldTitle=""
                  onSelect={(professionals) => onSelectProfessional(professionals, permitType, idx)}
                />
              )}
            </div>
          )
        })}
        <ActionBar>
          <BackLink action={movePrevStep} />
          <Button caption="Next" action={updateProfessionals} disableWhen={loading} />
        </ActionBar>
      </Panel>

      <Panel visibleWhen={mode === "supervisor"}>
        <h3>List of Supervisors</h3>
        {professionals.map((prof, idx) => {
          const permitType = permitTypes.find(pt => pt.objid.toLowerCase() === prof.sectionid.toLowerCase())
          if (!permitType) return null;
          if (!permitType.supervisorrole) return null;

          return (
            <div key={prof.objid}>
              {prof.supervisorid ? (
                <ProfessionalCard
                caption={`${prof.sectionid} Supervisor`}
                professional={professionals[idx].supervisor}
                onSelectProfessional={(professionals) => onSelectProfessional(professionals, permitType, idx)}
              />
              ) : (
                <ProfessionalLookup
                  caption={`${prof.sectionid} Supervisor`}
                  searchFieldTitle=""
                  onSelect={(professionals) => onSelectProfessional(professionals, permitType, idx)}
                />
              )}
            </div>
          )
        })}
        <ActionBar>
          <BackLink action={() => setMode("design")} />
          <Button caption="Next" action={updateProfessionals} disableWhen={loading} />
        </ActionBar>
      </Panel>
    </Panel>
  )
}


export default Professionals;
