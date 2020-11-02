import React, { useState, useEffect } from "react";
import {
  Panel,
  Subtitle,
  Subtitle2,
  Spacer,
  Service,
  Error,
  FormPanel,
  Checkbox,
  ActionBar,
  Button,
  Label,
  Decimal,
  Integer,
  Radio,
  Item,
  BackLink
} from "rsi-react-web-components";

import InfoComponent from "../components/InfoComponent";

const BuildingPermitAccessories = ({
  partner,
  appno,
  appService,
  moveNextStep,
  stepCompleted
}) => {
  const [error, setError] = useState();
  const [loading, setLoading] = useState(false);
  const [mode, setMode] = useState("initial");
  const [hasAccessories, setHasAccessories] = useState("TRUE");
  const [accessories, setAccessories] = useState([]);
  const [accessoryTypes, setAccessoryTypes] = useState([]);
  const [occupancyTypes, setOccupancyTypes] = useState([]);

  const isJAccessoryType = (accessories) => {
    if (accessories.length > 0 && /j.*/i.test(accessories[0].occupancytypeid)) {
      return true;
    }
    return false;
  }

  const loadAccessories = () => {
    appService.getAccessories({appid: appno}, (err, accessories) => {
      setAccessories(accessories);
      if (isJAccessoryType(accessories)) {
        setMode("infos")
      }
    });
  }

  const loadAccessoryOccupancyTypes = () => {
    const svc = Service.lookup("OboMiscListService", "obo");
    svc.getAccessoryOccupancyTypes((err, occupancyTypes) => {
      if (err) {
        setError(err);
      } else {
        const accessoryTypes = {};
        occupancyTypes.forEach(ot => {
          accessoryTypes[`${ot.objid.toLowerCase()}`] = false;
        });
        setOccupancyTypes(occupancyTypes);
        setAccessoryTypes(accessoryTypes);
      }
    });
  }

  useEffect(() => {
    loadAccessoryOccupancyTypes();
    loadAccessories();
  }, []);


  const submitInitial = () => {
		if (hasAccessories === "TRUE") {
			setMode("select-accessories");
		} else {
      setError(null);
      appService.saveAccessories({appid: appno, items: []}, (err, res) => {
        if (err) {
          setError(err);
        } else {
          moveNextStep();
        }
      });
		}
  }

  const submitAccessoryTypes = () => {
    if (Object.keys(accessoryTypes).length > 0) {
      const accessories = getSelectedAccessoryTypes();
      appService.saveAccessories(accessories, (err, accessories) => {
        if (err) {
          setError(err);
        } else {
          loadAccessories();
          setMode("infos");
        }
      });
    } else {
      setError("Select at least one accessory type before proceeding.")
    }
  }

  const getSelectedAccessoryTypes = () => {
		const items = [];
    for (const prop in accessoryTypes) {
      if (accessoryTypes[prop]) {
				items.push(prop);
			}
    }
    return { appid: appno, items }
  }

  const saveAccesoryInfos = () => {
		var p = {appid: appno, infos: []};
    p.infos = [];
    accessories.forEach(accessory => {
      p.infos.push(...accessory.infos);
    });

		appService.saveAccessoryInfos(p, (err, res) => {
      if (err) {
        setError(err)
      } else {
        moveNextStep();
      }
    });
	}

  return (
    <Panel>
      <Subtitle>Accessories</Subtitle>
      <Spacer />
      <Error msg={error} />

			<Panel visibleWhen={mode==="initial"}>
        <p>Does the plan include accessories?</p>
        <Radio name="hasAccessories" value={hasAccessories} onChange={setHasAccessories}>
          <Item caption="Yes" value="TRUE" />
          <Item caption="No" value="FALSE" />
        </Radio>
        <ActionBar>
          <Button caption="Next" action={submitInitial} />
        </ActionBar>
      </Panel>

      <Panel visibleWhen={mode === "select-accessories"}>
        <Subtitle2>Select accessory to add if applicable</Subtitle2>
        <FormPanel context={accessoryTypes} handler={setAccessoryTypes}>
          {occupancyTypes.map(ot =>
            <Checkbox key={ot.objid} caption={ot.title} name={`${ot.objid.toLowerCase()}`} />
          )}
        </FormPanel>
        <ActionBar>
          <BackLink action={() => setMode("initial")} />
          <Button caption="Next" action={submitAccessoryTypes} />
        </ActionBar>
      </Panel>

      <FormPanel visibleWhen={mode === "infos"} context={accessories} handler={setAccessories}>
        {accessories.map((o, ix) => {
          return (
            <div key={o.objid}>
              <Label style={styles.infoTitle}>{o.type.title}</Label>
              {o.infos.map((info, iy) => {
                return (
                  <InfoComponent
                    key={`${info.name}:${ix}:${iy}`}
                    name={`[${ix}].infos[${iy}].value`}
                    dataType={info.datatype}
                    caption={info.caption}
                    unit={info.unit}
                  />
                )
              })}
            </div>
          )
        })}
        <ActionBar>
          <BackLink action={() => setMode("select-accessories")}  />
          <Button caption="Next" action={saveAccesoryInfos} />
        </ActionBar>
      </FormPanel>
    </Panel>

  )
}

const styles = {
  infoTitle: {
    fontWeight: "bold",
  },
  infoContainer: {
    display: "flex",
    justifyContent: "space-between",
    alignItems: "center",
    marginLeft: 20,
  },
}

export default BuildingPermitAccessories
