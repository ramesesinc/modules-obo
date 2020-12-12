import React, { useState, useEffect, useRef } from "react";
import {
  Panel,
  Spacer,
  ActionBar,
  Button,
  FormPanel,
  Label,
  Decimal,
  Date,
  BackLink,
  isDateBefore,
  hasErrors
} from 'rsi-react-web-components';


const PlannedVsActual = ({
  appno,
  appService,
  moveNextStep,
  movePrevStep
}) => {

  const [error, setError] = useState();
  const [loading, setLoading] = useState(false);
  const [errors, setErrors] = useState({});
  const [app, setApp] = useState({});

  const formRef = useRef();

  useEffect(() => {
    appService.invoke("getApplication", {appid: appno}, (err, app) => {
      if (err) {
        setError(err);
      } else {{
        setApp(app);
      }}
    });
  }, [appno]);

  const isValid = () => {
    const errors = {};
    if (app.dtactualstarted && app.dtactualcompleted && isDateBefore(app.dtactualcompleted, app.dtactualstarted)) {
      errors.dtactualcompleted = "Actual date completed should be after actual date started."
    }

    if (hasErrors(errors)) {
      setErrors(errors);
      return false;
    } else {
      setErrors({});
      return true;
    }
  }

  const updatePermit = () => {
    if (!formRef.current.reportValidity()) return;

    if (isValid()) {
      setLoading(true);
      appService.invoke("update", app, (err, updatedApp) => {
        if (err) {
          setError(err);
        } else {
          moveNextStep();
        }
        setLoading(false);
      });
    }
  }

  return (
    <Panel style={{maxWidth: 600}}>
      <Label>Please indicate the actual values of construction.</Label>
      <Spacer />
      <FormPanel context={app} handler={setApp} style={styles.container}>
        <form ref={formRef}>
          <Panel style={styles.row}>
            <Label caption="" style={styles.label}  />
            <div style={styles.columnTitle}>Planned</div>
            <div style={styles.columnTitle}>Actual</div>
          </Panel>
          <Panel style={styles.row}>
            <Label caption="Project Total Cost" style={styles.label} />
            <Decimal name="bldgpermit.projectcost" disabled={true} variant="outlined" style={styles.item} fullWdith={false} />
            <Decimal name="actualprojectcost" disabled={true} style={styles.item} fullWdith={false} variant="outlined" />
          </Panel>
          <Panel style={styles.row}>
            <Label caption="Total Floor Area (sqm)" style={styles.label}  />
            <Decimal name="bldgpermit.totalfloorarea" disabled={true} variant="outlined" style={styles.item} fullWdith={false} />
            <Decimal name="actualtotalfloorarea" required style={styles.item} fullWdith={false} variant="outlined" autoFocus={true} />
          </Panel>
          <Panel style={styles.row}>
            <Label caption="No. of Units" style={styles.label} />
            <Decimal name="bldgpermit.numunits" disabled={true} variant="outlined" style={styles.item} fullWdith={false} />
            <Decimal name="actualnumunits" style={styles.item} fullWdith={false} variant="outlined" required />
          </Panel>
          <Panel style={styles.row}>
            <Label caption="No. of Floors" style={styles.label} />
            <Decimal name="bldgpermit.numfloors" disabled={true} variant="outlined" style={styles.item} fullWdith={false} />
            <Decimal name="actualnumfloors" style={styles.item} fullWdith={false} variant="outlined" required />
          </Panel>
          <Panel style={styles.row}>
            <Label caption="Height (m)" style={styles.label} />
            <Decimal name="bldgpermit.height" disabled={true} variant="outlined" style={styles.item} fullWdith={false} />
            <Decimal name="actualheight" style={styles.item} fullWdith={false} variant="outlined" required />
          </Panel>
          <Panel style={styles.row}>
            <Label caption="Start Date" style={styles.label} />
            <Date name="bldgpermit.dtproposedconstruction" disabled={true} variant="outlined" style={styles.item} fullWdith={false} />
            <Date name="dtactualstarted" style={styles.item} fullWdith={false} variant="outlined" required />
          </Panel>
          <Panel style={styles.row}>
            <Label caption="Completion Date" style={styles.label} />
            <Date name="bldgpermit.dtexpectedcompletion" disabled={true} variant="outlined" style={styles.item} fullWdith={false} />
            <Date name="dtactualcompleted" style={styles.item} fullWdith={false} variant="outlined" required error={errors.dtactualcompleted} helperText={errors.dtactualcompleted} />
          </Panel>
          <Spacer />
        </form>
      </FormPanel>
      <ActionBar>
        <BackLink action={movePrevStep} />
        <Button caption="Next" action={updatePermit} disableWhen={loading} loading={loading}/>
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
  columnTitle: {
    fontWeight: "bold",
    textAlign: "center",
    width: 300,
    padding: 10,
  },
  row: {
    display: "flex",
    flexDirection: "row",
    alignItems: "flex-start",
  },
  label: {
    width: "100%",
  },
  item: {
    width: 400,
    marginRight: 10,
  }
}

export default PlannedVsActual;
