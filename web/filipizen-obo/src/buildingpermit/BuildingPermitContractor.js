import React, { useState, useEffect } from "react";
import {
  ActionBar,
  Button,
  Panel,
  Error,
  Subtitle,
  Spacer,
} from "rsi-react-web-components";

import ProfessionalLookup from "../components/ProfessionalLookup";
import ProfessionalCard from "../components/ProfessionalCard";

const BuildingPermitContractor = ({
  partner,
  appno,
  appService,
  moveNextStep,
  stepCompleted
}) => {
  const initialProject = {
    appid: appno,
    apptype: "NEW",
  }

  const [error, setError] = useState();
  const [errors, setErrors] = useState({});
  const [loading, setLoading] = useState(false);
  const [project, setProject] = useState(initialProject);
  const [professional, setProfessional] = useState();

  useEffect(() => {
    appService.invoke("getProjectInfo", {appid: appno}, (err, project) => {
      if (err) {
        setError(err);
      } else {
        setProfessional(project.contractor);
        setProject(project);
      }
    });
  }, [])

  const submitProjectDetail = () => {
    setError(null);
    const detail = {
      appid: appno,
      title: project.title,
      description: project.description,
      numunits: project.numunits,
      totalfloorarea: project.totalfloorarea,
      height: project.height,
      numfloors: project.numfloors,
      projectcost: project.projectcost,
      dtproposedconstruction: project.dtproposedconstruction,
      dtexpectedcompletion: project.dtexpectedcompletion,
    };
    appService.invoke("update", detail, (err, proj) => {
      if (err) {
        setError(err);
      } else {
        clearStatus();
        setMode("select-worktype");
      }
    });
  }

  const clearStatus = () => {
    setError(null);
    setLoading(false);
  }

  const onSelectProfessional = (professionals) => {
    if (professionals.length === 0) {
      setProfessional({});
      return;
    }

    const professional = professionals[0];
    appService.invoke("update", {appid: appno, contractorid: professional.objid}, (err, app) => {
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
      <label>{`Tracking No. ${appno}`}</label>
      <Subtitle>Project Details</Subtitle>
      <Spacer />
      <Error msg={error} />

      <Panel>
        <label>Specify full time inspector and supervisor of construction work</label>
        <Spacer height={10} />
        {professional && professional.lastname &&
          <Panel>
            <ProfessionalCard
              caption="Inspector/Supervisor"
              professional={professional}
              onSelectProfessional={onSelectProfessional}
            />
          </Panel>
        }
        {(!professional || !professional.lastname) &&
          <ProfessionalLookup caption="Search Professional" onSelect={onSelectProfessional} fullWidth={false} />
        }
        <ActionBar>
          <Button caption="Next" action={submitProfessional} disableWhen={!professional || !professional.objid}/>
        </ActionBar>
      </Panel>

    </Panel>
  )
}


export default BuildingPermitContractor
