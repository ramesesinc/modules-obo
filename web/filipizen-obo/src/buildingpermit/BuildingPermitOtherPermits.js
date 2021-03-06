import React, { useState, useEffect } from "react";
import {
  ActionBar,
  Button,
  Checkbox,
  Panel,
  Error,
  Subtitle,
  Subtitle2,
  FormPanel,
  Spacer,
  BackLink,
  EditButton,
  DeleteButton,
  Decimal,
  CheckIcon,
  Service,
  PreviewReport,
  EditIcon,
} from "rsi-react-web-components";

import ProfessionalCard from "../components/ProfessionalCard";
import InfoComponent from "../components/InfoComponent";

const BuildingPermitOtherPermits = ({
  partner,
  appno,
  appService,
  moveNextStep,
  stepCompleted
}) => {

  const [loaded, setLoaded] = useState(false);
  const [error, setError] = useState();
  const [loading, setLoading] = useState(false);
  const [mode, setMode] = useState("permit-list");
  const [availableAncillaryPermits, setAvailableAncillaryPermits] = useState([]);
  const [ancillaryPermits, setAncillaryPermits] = useState([]);
  const [ancillaryPermit, setAncillaryPermit] = useState({worktypes:[], type:{}});

  const loadAvailableAccillaryPermits = () => {
    setLoading(true);
    appService.invoke("getAvailableAncillaryPermitTypes", {appid: appno}, (err, list) => {
      if (err) {
        setError(err);
      } else {
        setAvailableAncillaryPermits(list);
      }
      setLoading(false);
    })
  }

  const loadAncillaryPermits = () => {
    setLoading(true);
    appService.invoke("getAncillaryPermits", {appid: appno}, (err, list) => {
      if (err) {
        setError(err)
      } else {
        setAncillaryPermits(list);
        if (!loaded && list.length === 0) {
          setLoaded(true);
          setMode("available-list");
        }
      }
      setLoading(false);
    })
  }

  useEffect(() => {
    loadAvailableAccillaryPermits();
  }, [ancillaryPermits])

  useEffect(() => {
    loadAncillaryPermits();
  }, [mode, loaded]);

  const submitSelectedAncillaryPermits = () => {
    const selectedPermits = availableAncillaryPermits.filter((permit => permit.selected === true));
    if (selectedPermits.length > 0 ) {
      setLoading(true);
      setAncillaryPermits(selectedPermits);
      appService.invoke("saveAncillaryPermits", {appid: appno, permits: selectedPermits}, (err, _) => {
        if (err) {
          setError(err);
        } else {
          setError(null);
          setMode("permit-list");
        }
        setLoading(false);
      })
    } else {
      setMode("permit-list");
    }
  }

  const loadPermitWorkTypes = (permit) => {
    setLoading(true);
    const svc = Service.lookup("OboMiscListService", "obo");
    svc.invoke("getWorkTypes", {typeid: permit.type.objid}, (err, workTypes) => {
      if (err) {
        setError(err);
      } else {
        if (workTypes && workTypes.length > 0) {
          workTypes.forEach(wt => {
            if (permit.worktypes.findIndex(pwt => pwt.toLowerCase() === wt.name.toLowerCase()) >= 0) {
              wt.checked = true;
            }
          })
          setAncillaryPermit({...permit, worktypes: workTypes});
          setMode("select-worktypes");
        } else {
          if (permit.infos.length > 0) setMode("infos");
          else if (permit.type.includecost === 1) setMode("cost");
          else setMode("professional");
          setAncillaryPermit(permit);
        }
      }
      setLoading(false);
    })
  }

  const editPermit = (o) => {
    setLoading(true);
    appService.invoke("getAncillaryPermit", {objid: o.objid}, (err, permit) => {
      if (err) {
        setError(err);
      } else {
        setError(null);
        loadPermitWorkTypes(permit);
      }
      setLoading(false);
    })
  }

  const removePermit = (permit) => {
    setLoading(true);
    appService.invoke("removeAncillaryPermit", {objid: permit.objid}, (err, res) => {
      if (err) {
        setError(err);
      } else {
        setError(null);
        loadAncillaryPermits();
      }
      setLoading(false);
    });
  }

  const submitWorkType = () => {
    setError(null);
    setError(null);
    setLoading(true);
    const updatedWorkTypes = {
      objid: ancillaryPermit.objid,
      worktypes: ancillaryPermit.worktypes.filter(wt => wt.checked).map(wt => wt.name)
    };
    appService.invoke("updateAncillaryPermit", updatedWorkTypes, (err, proj) => {
      if (err) {
        setError(error);
      } else {
        setMode("infos");
        setLoading(false);
      }
      setLoading(false);
    });

  }

  const onSelectDesignProfessional = (professional) => {
    setAncillaryPermit({
      ...ancillaryPermit,
      designprofessional: professional,
      designprofessionalid: professional.objid
    });
  }

  const onSelectSupervisor = (professional) => {
    setAncillaryPermit({
      ...ancillaryPermit,
      supervisor: professional,
      supervisorid: professional.objid,
    });
  }

  const submitInfos = () => {
    setLoading(true);
    const updatedInfos = {
      objid: ancillaryPermit.objid,
      projectcost: ancillaryPermit.projectcost,
      equipmentcost: ancillaryPermit.equipmentcost,
    }
    appService.invoke("updateAncillaryPermit", updatedInfos, (err, _) => {
      if (err) {
        setError(err);
      } else {
        if (ancillaryPermit.type.includecost === 1)
          setMode("cost");
        else
          setMode("professional");
      }
      setLoading(false);
    })
  }

  const saveCost = () => {
    setLoading(true);
    setError(null);
    const updatedCost = {appid: appno, objid: ancillaryPermit.objid, infos: ancillaryPermit.infos }
    appService.invoke("saveAncillaryPermit", updatedCost, (err, _) => {
      if (err) {
        setError(err);
      } else {
        setMode("professional");
      }
      setLoading(false);
    })
  }

  const savePermit = () => {
    setError(null);
    if (!ancillaryPermit.designprofessionalid) {
      setError("Design Professional is required.");
      return;
    }
    if (!ancillaryPermit.supervisorid) {
      setError("Supervisor is required.");
      return;
    }

    setLoading(true);
    const updatedPermit = {
      ...ancillaryPermit,
      worktypes: ancillaryPermit.worktypes.filter(wt => wt.checked).map(wt => wt.name)
    }
    appService.invoke("saveAncillaryPermit", updatedPermit, (err, _) => {
      if (err) {
        setError(err);
      } else {
        setMode("permit-list");
      }
      setLoading(false);
    })
  }

  const submitAncillaryPermits = () => {
    const incompletePermits = [];
    ancillaryPermits.forEach(permit => {
      if (!permit.designprofessionalid) {
        incompletePermits.push(permit.type.title);
      }
    })
    if (incompletePermits.length === 1) {
      setError(`Permit ${incompletePermits[0]} is not processed`);
    } else if (incompletePermits.length > 1) {
      setError(`The following permist are not processed: ${incompletePermits.join(",")}`);
    } else {
      moveNextStep();
    }
  }

  let hasIncompletePermit = false;
  if (ancillaryPermits.length > 0) {
    const idx = ancillaryPermits.findIndex(permit => !permit.designprofessionalid);
    hasIncompletePermit =  idx >= 0;
  }

  let prevInfo = null;

  const backFromInfos = () => {
    if (ancillaryPermit.worktypes && ancillaryPermit.worktypes.length > 0)
      setMode("select-worktypes");
    else
      setMode("permit-list");
  }

  return (
    <Panel>
      <label>{`Tracking No. ${appno}`}</label>
      <Subtitle>Other Permits</Subtitle>
      <Spacer />
      <Error msg={error} />

      <Panel visibleWhen={mode === "permit-list"}>
        <label>Click on edit <EditIcon fontSize="small" color="primary"/> for each document and complete the details.</label>
        <Spacer height={40}/>
        {ancillaryPermits.map(permit => (
          <Panel style={{display: "flex", flexDirection: "row", justifyContent: "space-between"}}>
            <Panel row>
              {permit.designprofessionalid ? (
                <div style={{width: 40}}>
                  <CheckIcon style={{ color: "green", paddingRight: 10}} />
                </div>
              )
              : (
                <div style={{width: 40}}/>
              )}
              <label>{permit.type.title}</label>
            </Panel>
            <Panel row>
              {permit.designprofessionalid &&
                <PreviewReport caption={null} href={`/jreports/partner/${partner.group.name}_${partner.name}/obo/building_ancillary_${permit.type.objid}?refid=${permit.objid}`} />
              }
              <EditButton action={() => editPermit(permit)} size="small" />
              <DeleteButton action={() => removePermit(permit)} size="small" />
            </Panel>
          </Panel>
        ))}
        <ActionBar>
          <BackLink caption="Add New Permits" action={() => setMode("available-list")} />
          <Button caption="Next" action={submitAncillaryPermits} disableWhen={hasIncompletePermit} />
        </ActionBar>
      </Panel>

      <FormPanel visibleWhen={mode === "select-worktypes"} context={ancillaryPermit} handler={setAncillaryPermit} >
        <h4>{ancillaryPermit.type.title}</h4>
        <Subtitle2>Select Work Types</Subtitle2>
        <Panel style={styles.workTypeContainer}>
          {ancillaryPermit.worktypes.map((worktype, idx) => (
            <Checkbox
              caption={worktype.name.toUpperCase()}
              name={`worktypes[${idx}].checked`}
              value={worktype.name} />
          ))}
        </Panel>
        <ActionBar>
          <BackLink action={() => setMode("permit-list")} />
          <Button caption="Next" action={submitWorkType} disableWhen={loading} loading={loading} />
        </ActionBar>
      </FormPanel>

      <FormPanel visibleWhen={mode === "infos"} context={ancillaryPermit} handler={setAncillaryPermit}>
        <Subtitle2>{ancillaryPermit.type?.title}</Subtitle2>
        <Spacer />
        <p>Please fill the applicable values and click Save and Complete when done.</p>
        {ancillaryPermit.infos && ancillaryPermit.infos.map((info, ix) => {
          let category = null;
          if (prevInfo === null || prevInfo.category !== info.category) {
            category = info.category;
            prevInfo = info;
          }
          return (
            <InfoComponent
              key={`${info.name}:${ix}`}
              name={`infos[${ix}].value`}
              category={category}
              dataType={info.datatype}
              caption={info.caption}
              unit={info.unit}
            />
          )
        })}
        <ActionBar>
          <BackLink action={backFromInfos}  />
          <Button caption="Next" action={submitInfos} disableWhen={loading} loading={loading}  />
        </ActionBar>
      </FormPanel>

      <Panel visibleWhen={mode === "available-list"}>
        <Subtitle2>Select ancillary and other permits to include in the project</Subtitle2>
        <FormPanel
          context={availableAncillaryPermits}
          handler={setAvailableAncillaryPermits}
          style={styles.itemsContainer}
        >
          {availableAncillaryPermits.map((permit,idx) =>
            <Checkbox key={permit.objid} caption={permit.title} name={`[${idx}].selected`} />
          )}
        </FormPanel>
        <ActionBar>
          <Button caption="Next" action={submitSelectedAncillaryPermits} disableWhen={loading} loading={loading} />
        </ActionBar>
      </Panel>

      <FormPanel visibleWhen={mode === "cost"} context={ancillaryPermit} handler={setAncillaryPermit}>
        <Subtitle2>{ancillaryPermit.type?.title}</Subtitle2>
        <Decimal name="projectcost" caption="Project Cost" textAlign="left" fullWidth={false} />
        <Decimal name="equipmentcost" caption="Equipment Cost" textAlign="left" />
        <Spacer />
        <ActionBar>
          <BackLink action={() => setMode("infos")} />
          <Button caption="Next" action={saveCost} disableWhen={loading} loading={loading} />
        </ActionBar>
      </FormPanel>


      <FormPanel visibleWhen={mode === "professional"} context={ancillaryPermit} handler={setAncillaryPermit}>
        <Subtitle2>{ancillaryPermit.type?.title}</Subtitle2>
        <Spacer />
        <ProfessionalCard
          caption="Design Professional"
          professional={ancillaryPermit.designprofessional}
          onSelectProfessional={onSelectDesignProfessional}
          role={ancillaryPermit.type.designprofessionalrole}
        />
        <Spacer />
        <ProfessionalCard
          caption="Supervisor in Charge Professional"
          professional={ancillaryPermit.supervisor}
          onSelectProfessional={onSelectSupervisor}
          role={ancillaryPermit.type.supervisorrole}
        />
        <ActionBar>
          <BackLink action={() => setMode("permit-list")} />
          <Button caption="Save and Complete" action={savePermit} disableWhen={loading} loading={loading}  />
        </ActionBar>
      </FormPanel>
    </Panel>
  )
}

const styles = {
  professionalLookup: {
    display: "flex",
    justifyContent: "space-between",
    alignItems: "center",
    backgroundColor: "lightgray",
  },
  itemsContainer: {
    marginLeft: 20,
    display: "flex",
    flexDirection: "column"
  },
  workTypeContainer: {
    display: "flex",
    flexDirection: "column",
    marginLeft: 20,
  },
}


export default BuildingPermitOtherPermits;
