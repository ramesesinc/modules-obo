import React, { useState, useEffect } from "react";
import {
  Panel,
  Spacer,
  ActionBar,
  Button,
  FormPanel,
  Label,
  Decimal,
  Error,
  BackLink
} from 'rsi-react-web-components';

const FireSafetyCost = ({
  appno,
  appService,
  moveNextStep,
  movePrevStep,
}) => {

  const [loading, setLoading] = useState(false);
  const [error, setError] = useState();
  const [app, setApp] = useState({});
  const [cost, setCost] = useState({items: []})

  useEffect(() => {
    appService.invoke("getAppInfos", {appid: appno}, (err, infos) => {
      if (err) {
        setError(err);
      } else {{
        setCost({...cost, items: infos});
      }}
    });
  }, [appno])

  const updateAppInfos = () => {
    setLoading(true);
    appService.invoke("saveAppInfos", {appid: appno, infos: cost.items}, (err, infos) => {
      if (err) {
        setError(err)
      } else {
        moveNextStep();
      }
      setLoading(false);
    })
  }

  return (
    <Panel style={{maxWidth: 600}}>
      <Label>Please indicate the other cost of construction.</Label>
      <Spacer />
      <Error msg={error} />
      <FormPanel context={cost} handler={setCost} style={styles.container}>
        {cost.items.map((cost, idx) => (
          <Panel key={cost.objid} style={styles.row}>
            <Label caption={cost.caption} style={styles.label}  />
            <Decimal name={`items[${idx}].value`} variant="outlined" style={styles.item} fullWdith={false} />
          </Panel>
        ))}
      </FormPanel>
      <ActionBar>
        <BackLink action={movePrevStep} />
        <Button caption="Next" action={updateAppInfos} disableWhen={loading} loading={loading} />
      </ActionBar>
    </Panel>
  )
}

const styles = {
  container: {
    display: "flext",
    flexDirection: "column",
    justifyContent: "flex-start",
  },
  row: {
    display: "flex",
    flexDirection: "row",
    alignItems: "center",
  },
  label: {
    width: "100%",
  },
  item: {
    width: 300,
    marginRight: 10,
  }
}

export default FireSafetyCost;
