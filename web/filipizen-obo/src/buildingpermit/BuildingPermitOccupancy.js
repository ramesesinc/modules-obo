import React, { useState, useEffect } from "react";
import {
  ActionBar,
  Button,
  Panel,
  Radio,
  Error,
  Subtitle,
  Subtitle2,
  FormPanel,
  Spacer,
  BackLink,
  Service,
} from "rsi-react-web-components";

const svc = Service.lookup("OboMiscListService", "obo");

const styles = {
  row: {
    display: "flex",
    alignItems: "flex-start",
  },
  group: {
    fontSize: 20,
    fontWeight: 700,
    marginRight: 15,
    paddingTop: 8,
  }
}

const RadioItem = ({item}) => {
  return (
    <Panel style={{paddingBottom: 5}}>
      <Panel style={styles.row}>
        <div style={styles.group}>{item.objid}</div>
        <Panel>
          <Subtitle2>{item.title}</Subtitle2>
          <label>{item.description}</label>
        </Panel>
      </Panel>
    </Panel>
  )
}

const BuildingPermitOccupancy = ({
  partner,
  appno,
  appService,
  moveNextStep,
}) => {

  const [error, setError] = useState();
  const [loading, setLoading] = useState(false);
  const [mode, setMode] = useState("select-occupancytype");
  const [occupancyMode, setOccupancyMode] = useState("group");
  const [project, setProject] = useState({});
  const [occupancyGroups, setOccupancyGroups] = useState([]);
  const [occupancyDivisions, setOccupancyDivisions] = useState([]);
  const [occupancyTypes, setOccupancyTypes] = useState([]);
  const [prevOccupancyId, setPrevOccupancyId] = useState(false);
  const [showConfirm, setShowConfirm] = useState(false);


  useEffect(() => {
    setLoading(true);
    appService.invoke("getApplication", {appid: appno}, (err, app) => {
      if (err) {
        setError(err);
      } else {
        setProject({occupancytype: app.occupancytype});
        setPrevOccupancyId(app.occupancytype.objid);
      }
      setLoading(false);
    })
  }, [])

  const loadOccupancyGroups = () => {
    setLoading(true);
    svc.invoke("getOccupancyTypeGroups", null, (err, groups) => {
      if (err) {
        setError(err)
      } else {
        setOccupancyGroups(groups);
      }
      setLoading(false);
    });
  }

  const loadOccupancyDivisions = () => {
    setLoading(true);
    const groupid = project.occupancytype.group.objid;
    svc.invoke("getOccupancyTypeDivisions", {groupid} ,(err, divisions) => {
      if (err) {
        setError(err)
      } else {
        setOccupancyDivisions(divisions);
      }
      setLoading(false);
    });
  }

  const loadOccupancyTypes = () => {
    setLoading(true);
    const divisionid = project.occupancytype.division.objid;
    svc.invoke("getOccupancyTypes", {divisionid} ,(err, types) => {
      if (err) {
        setError(err)
      } else {
        setOccupancyTypes(types);
      }
      setLoading(false);
    });
  }

  useEffect(() => {
    if (occupancyMode === "group")
      loadOccupancyGroups();
    else if (occupancyMode === "division")
      loadOccupancyDivisions();
    else if (occupancyMode === "type")
      loadOccupancyTypes();
  }, [occupancyMode])

  const submitOccupancyGroup = () => {
    if (!project.occupancytype.group.objid) {
      setError("Kindly select an occupancy group.")
    } else {
      setOccupancyMode("division");
    }
  }

  const submitOccupancyDivision = () => {
    if (!project.occupancytype.division.objid) {
      setError("Kindly select an occupancy division group.")
    } else {
      setOccupancyMode("type");
    }
  }

  const updateOccupancyType = () => {
    setLoading(true);
    let occupancytype = {appid: appno, occupancytype: project.occupancytype};
    appService.invoke("updateOccupancyType", occupancytype, (err, res) => {
      if (err) {
        setError(err);
      } else {
        clearStatus();
        setShowConfirm(false);
        moveNextStep();
      }
      setLoading(false);
    });
  }

  const submitOccupancyType = () => {
    if (!project.occupancytype.objid) {
      setError("Kindly select an occupancy type.")
    } else {
      updateOccupancyType();
    }
  }
  const clearStatus = () => {
    setError(null);
    setLoading(false);
  }


  return (
    <Panel>
      <label>{`Tracking No. ${appno}`}</label>
      <Subtitle>Occupancy Type</Subtitle>
      <Spacer />
      <Error msg={error} />

      <Panel visibleWhen={mode === "select-occupancytype"}>
        <FormPanel visibleWhen={occupancyMode === "group"} context={project} handler={setProject}>
          <Subtitle2>Select Occupancy Group</Subtitle2>
          <Radio name="occupancytype.group.objid" list={occupancyGroups} Control={RadioItem}/>
          <ActionBar>
            <Button caption="Next" action={submitOccupancyGroup} disableWhen={loading} loading={loading} />
          </ActionBar>
        </FormPanel>

        <FormPanel visibleWhen={occupancyMode === "division"} context={project} handler={setProject}>
          <Subtitle2>Select Occupancy Group Division</Subtitle2>
          <Radio name="occupancytype.division.objid" list={occupancyDivisions} Control={RadioItem}/>
          <ActionBar>
            <BackLink caption="Back" action={() => setOccupancyMode("group")} />
            <Button caption="Next" action={submitOccupancyDivision}  disableWhen={loading} loading={loading} />
          </ActionBar>
        </FormPanel>

        <FormPanel visibleWhen={occupancyMode === "type"} context={project} handler={setProject}>
          <Subtitle2>Select Occupancy Type</Subtitle2>
          <Radio name="occupancytype.objid" list={occupancyTypes} Control={RadioItem}/>
          <ActionBar>
            <BackLink caption="Back" action={() => setOccupancyMode("division")} />
            <Button caption="Next" action={submitOccupancyType}  disableWhen={loading} loading={loading}  />
          </ActionBar>
        </FormPanel>
      </Panel>

    </Panel>
  )
}

export default BuildingPermitOccupancy
