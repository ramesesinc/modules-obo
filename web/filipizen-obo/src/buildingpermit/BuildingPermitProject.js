import React, { useState, useEffect, useRef } from "react";
import {
  ActionBar,
  Button,
  Checkbox,
  Panel,
  Error,
  Subtitle,
  Subtitle2,
  FormPanel,
  Text,
  Spacer,
  BackLink,
  Service,
  Integer,
  Decimal,
  Date,
  isDateBefore
} from "rsi-react-web-components";

const svc = Service.lookup("OboMiscListService", "obo");

const BuildingPermitProject = ({
  appno,
  appService,
  moveNextStep,
}) => {
  const initialProject = {
    appid: appno,
    apptype: "NEW",
    worktypes: [],
    numfloors: 1,
    numunits: 1,
    occupancytype: {
      objid: null,
      group: {},
      division: {},
    }
  }

  const [error, setError] = useState();
  const [errors, setErrors] = useState({});
  const [loading, setLoading] = useState(false);
  const [mode, setMode] = useState("project-detail");
  const [occupancyMode, setOccupancyMode] = useState("group");
  const [project, setProject] = useState(initialProject);
  const [occupancyGroups, setOccupancyGroups] = useState([]);
  const [occupancyDivisions, setOccupancyDivisions] = useState([]);
  const [occupancyTypes, setOccupancyTypes] = useState([]);
  const [professional, setProfessional] = useState();
  const [masterWorkTypes, setMasterWorkTypes] = useState([]);
  const [errorCompletionDate, setErrorCompletionDate] = useState(false);

  const formRef = useRef();

  const loadOccupancyGroups = () => {
    svc.invoke("getOccupancyTypeGroups", null, (err, groups) => {
      if (err) {
        setError(err)
      } else {
        setOccupancyGroups(groups);
      }
    });
  }

  const loadOccupancyDivisions = () => {
    const groupid = project.occupancytype.group.objid;
    svc.invoke("getOccupancyTypeDivisions", {groupid} ,(err, divisions) => {
      if (err) {
        setError(err)
      } else {
        setOccupancyDivisions(divisions);
      }
    });
  }

  const loadOccupancyTypes = () => {
    const divisionid = project.occupancytype.division.objid;
    svc.invoke("getOccupancyTypes", {divisionid} ,(err, types) => {
      if (err) {
        setError(err)
      } else {
        setOccupancyTypes(types);
      }
    });
  }

  useEffect(() => {
    setLoading(true);
    setError(null);
    svc.invoke("getWorkTypes", null, (err, workTypes) => {
      if (err) {
        setError(err);
      } else {
        setMasterWorkTypes(workTypes);
      }
      setLoading(false);
    });
  }, []);

  useEffect(() => {
    if (masterWorkTypes.length === 0) return;

    setLoading(true);
    setError(null);

    appService.invoke("getProjectInfo", {appid: appno}, (err, project) => {
      if (err) {
        setError(err);
      } else {
        if (project.worktypes.length === 0) {
          project.worktypes = masterWorkTypes;
        } else {
          const updatedWorkTypes = masterWorkTypes.map(wt => {
            let workType = project.worktypes.find(pwt => wt.objid === pwt)
            if (workType) {
              return {...wt, checked: true};
            }
            return wt;
          })
          project.worktypes = updatedWorkTypes;
        }
        project.numunits = project.numunits || 1;
        project.numfloors = project.numfloors || 1;
        setProfessional(project.contractor);
        setProject(project);
        setMode("project-detail");
      }
      setLoading(false);
    });
  }, [masterWorkTypes])

  useEffect(() => {
    if (occupancyMode === "group")
      loadOccupancyGroups();
    else if (occupancyMode === "division")
      loadOccupancyDivisions();
    else if (occupancyMode === "type")
      loadOccupancyTypes();
  }, [occupancyMode])

  const onErrorCompletionDate = () => {
    setErrorCompletionDate(true);
  }

  const submitProjectDetail = () => {
    if (!formRef.current.reportValidity()) return;
    if (isDateBefore(project.dtexpectedcompletion, project.dtproposedconstruction)) return;

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

  const validWorkTypes = () => {
    const idx = project.worktypes.findIndex(wt => wt.checked === true);
    return idx >= 0;
  }

  const submitWorkType = () => {
    setError(null);
    if (validWorkTypes()) {
      setError(null);
      const updatedWorkTypes = {
        appid: appno,
        worktypes: project.worktypes.filter(wt => wt.checked).map(wt => wt.objid),
      };
      appService.invoke("update", updatedWorkTypes, (err, proj) => {
        if (err) {
          setError(error);
        } else {
          setLoading(false);
          moveNextStep();
        }
      });
    } else {
      setError("Please check at least one work type.")
    }
  }

  const clearStatus = () => {
    setError(null);
    setLoading(false);
  }

  if (loading) {
    return (
      <Panel>
        <label>{`Tracking No. ${appno}`}</label>
        <Subtitle>Project Details</Subtitle>
      </Panel>
    )
  }

  return (
    <Panel>
      <label>{`Tracking No. ${appno}`}</label>
      <Subtitle>Project Details</Subtitle>
      <Spacer />
      <Error msg={error} />

      <FormPanel visibleWhen={mode === "project-detail"} context={project} handler={setProject}>
        <form ref={formRef}>
          <Text caption="Project Title" name="title" required={true} autoFocus={true}/>
          <Text caption="Project Description" name="description" required={true} />
          {project.occupancytypeid &&
            <Text caption="Occupancy Type" name="occupancytype.title" required={true} />
          }
          <Spacer/>
          <Integer caption="No of Units" name="numunits" required={true} fullWidth/>
          <Panel row>
            <Decimal caption="Total Floor Area [sq.meter]" name="totalfloorarea" required={true} fullWidth textAlign="left" />
            <Decimal caption="Building Height [meter]" name="height" required={true} fullWidth textAlign="left" />
          </Panel>
          <Integer caption="No. of Storeys" name="numfloors" required={true} fullWidth />
          <Spacer/>
          <Decimal caption="Estimated Cost [Php]" name="projectcost" required={true} decimalScale={2} textAlign="left" fullWidth/>
          <Panel row>
            <Date caption="Proposed Construction Date" name="dtproposedconstruction" required={true} />
            <Date caption="Expected Completion Date" name="dtexpectedcompletion" required={true}
              minDate={project.dtproposedconstruction}
              helperText={errorCompletionDate ? "Date should not be before proposed date" : null}
              onError={onErrorCompletionDate}
              />
          </Panel>
          <ActionBar>
            <Button caption="Next" action={submitProjectDetail} />
          </ActionBar>
        </form>
      </FormPanel>

      <FormPanel visibleWhen={mode === "select-worktype"} context={project} handler={setProject} >
        <Subtitle2>Select Work Types</Subtitle2>
        <Panel style={styles.column}>
          {project.worktypes.map((worktype, idx) => (
            <Checkbox
              caption={worktype.name}
              name={`worktypes[${idx}].checked`}
              value={worktype.objid} />
          ))}
        </Panel>
        <ActionBar>
          <BackLink action={() => setMode("project-detail")} />
          <Button caption="Next" action={submitWorkType} />
        </ActionBar>
      </FormPanel>
    </Panel>
  )
}

const styles = {
  column: {
    display: "flex",
    flexDirection: "column",
    marginLeft: 20,
  },
}

export default BuildingPermitProject
