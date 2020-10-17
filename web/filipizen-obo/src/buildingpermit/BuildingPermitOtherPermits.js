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
  ViewButton,
  EditButton,
  DeleteButton,
  Label,
  Decimal,
  Integer,
  CheckIcon,
  Service
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
    appService.getAvailableAncillaryPermitTypes({appid: appno}, (err, list) => {
      if (err) {
        setError(err);
      } else {
        setAvailableAncillaryPermits(list);
      }
    })
  }

  const loadAncillaryPermits = () => {
    appService.getAncillaryPermits({appid: appno}, (err, list) => {
      if (err) {
        setError(err)
      } else {
        setAncillaryPermits(list);
        if (!loaded && list.length === 0) {
          setLoaded(true);
          setMode("available-list");
        }
      }
    })
  }

  useEffect(() => {
    loadAvailableAccillaryPermits();
  }, [ancillaryPermits])

  useEffect(() => {
    loadAncillaryPermits();
  }, [mode]);

  useEffect(() => {
    loadAncillaryPermits();
  }, [loaded]);

  const submitSelectedAncillaryPermits = () => {
    const selectedPermits = availableAncillaryPermits.filter((permit => permit.selected === true));
    if (selectedPermits.length > 0 ) {
      setAncillaryPermits(selectedPermits);
      appService.saveAncillaryPermits({appid: appno, permits: selectedPermits}, (err, _) => {
        if (err) {
          setError(err);
        } else {
          setError(null);
          setMode("permit-list");
        }
      })
    } else {
      setMode("permit-list");
    }
  }

  const loadPermitWorkTypes = (permit) => {
    const svc = Service.lookup("OboMiscListService", "obo");
    svc.getWorkTypes({typeid: permit.type.objid}, (err, workTypes) => {
      if (err) {
        setError(err);
      } else {
        console.log("workTypes", workTypes);
        workTypes.forEach(wt => {
          if (permit.worktypes.findIndex(pwt => pwt.toLowerCase() === wt.name.toLowerCase()) >= 0) {
            wt.checked = true;
          }
        })
        setAncillaryPermit({...permit, worktypes: workTypes});
        setMode("select-worktypes");
      }
    })
  }

  const editPermit = (o) => {
    appService.getAncillaryPermit({objid: o.objid}, (err, permit) => {
      if (err) {
        setError(err);
      } else {
        setError(null);
        loadPermitWorkTypes(permit);
      }
    })
  }

  const removePermit = (permit) => {
    appService.removeAncillaryPermit({objid: permit.objid}, (err, res) => {
      if (err) {
        setError(err);
      } else {
        setError(null);
        loadAncillaryPermits();
      }
    });
  }

  const validWorkTypes = () => {
    const idx = ancillaryPermit.worktypes.findIndex(wt => wt.checked === true);
    return idx >= 0;
  }

  const submitWorkType = () => {
    setError(null);
    setError(null);
    const updatedWorkTypes = {
      objid: ancillaryPermit.objid,
      worktypes: ancillaryPermit.worktypes.filter(wt => wt.checked).map(wt => wt.name)
    };
    appService.updateAncillaryPermit(updatedWorkTypes, (err, proj) => {
      if (err) {
        setError(error);
      } else {
        setMode("infos");
        setLoading(false);
      }
    });

  }

  const onSelectDesignProfessional = (professionals) => {
    const professional = professionals[0]
    setAncillaryPermit({
      ...ancillaryPermit,
      designprofessional: professional,
      designprofessionalid: professional.objid
    });
  }

  const onSelectSupervisor = (professionals) => {
    const professional = professionals[0]
    setAncillaryPermit({
      ...ancillaryPermit,
      supervisor: professional,
      supervisorid: professional.objid,
    });
  }

  const submitInfos = () => {
    const updatedInfos = {objid: ancillaryPermit.objid, infos: ancillaryPermit.infos }
    appService.updateAncillaryPermit(updatedInfos, (err, _) => {
      if (err) {
        setError(err);
      } else {
        setMode("professional");
      }
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

    const updatedPermit = {
      ...ancillaryPermit,
      worktypes: ancillaryPermit.worktypes.filter(wt => wt.checked).map(wt => wt.name)
    }

    appService.saveAncillaryPermit(updatedPermit, (err, _) => {
      if (err) {
        setError(err);
      } else {
        setMode("permit-list");
      }
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
    console.log("idx", idx)
    hasIncompletePermit =  idx >= 0;
  }

  let prevInfo = null;

  return (
    <Panel>
      <Subtitle>Other Permits</Subtitle>
      <Spacer />
      <Error msg={error} />

      <Panel visibleWhen={mode === "permit-list"}>
        <Spacer />
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
        <Subtitle2>Select Work Type</Subtitle2>
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
          <Button caption="Next" action={submitWorkType} />
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
          <BackLink action={() => setMode("select-worktypes")}  />
          <Button caption="Next" action={submitInfos} />
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
          <Button caption="Next" action={submitSelectedAncillaryPermits} />
        </ActionBar>
      </Panel>

      <FormPanel visibleWhen={mode === "professional"} context={ancillaryPermit} handler={setAncillaryPermit}>
        <Subtitle2>{ancillaryPermit.type?.title}</Subtitle2>
        <Spacer />
        <ProfessionalCard
          caption="Design Professional"
          professional={ancillaryPermit.designprofessional}
          onSelectProfessional={onSelectDesignProfessional}
        />
        <Spacer />
        <ProfessionalCard
          caption="Supervisor in Charge Professional"
          professional={ancillaryPermit.supervisor}
          onSelectProfessional={onSelectSupervisor}
        />
        <ActionBar>
          <BackLink action={() => setMode("permit-list")} />
          <Button caption="Save and Complete" action={savePermit} />
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
