import React, { useState, useEffect } from "react";
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
    if (!app.actualtotalfloorarea) errors.actualtotalfloorarea = "Required";
    if (!app.actualnumunits) errors.actualnumunits = "Required";
    if (!app.actualnumfloors) errors.actualnumfloors = "Required";
    if (!app.actualheight) errors.actualheight = "Required";
    if (!app.dtactualstarted) errors.dtactualstarted = "Required";
    if (!app.dtactualcompleted) errors.dtactualcompleted = "Required";
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
          <Decimal name="actualtotalfloorarea" style={styles.item} fullWdith={false} variant="outlined" error={errors.actualtotalfloorarea} autoFocus={true} />
        </Panel>
        <Panel style={styles.row}>
          <Label caption="No. of Units" style={styles.label} />
          <Decimal name="bldgpermit.numunits" disabled={true} variant="outlined" style={styles.item} fullWdith={false} />
          <Decimal name="actualnumunits" style={styles.item} fullWdith={false} variant="outlined" error={errors.actualnumunits}/>
        </Panel>
        <Panel style={styles.row}>
          <Label caption="No. of Floors" style={styles.label} />
          <Decimal name="bldgpermit.numfloors" disabled={true} variant="outlined" style={styles.item} fullWdith={false} />
          <Decimal name="actualnumfloors" style={styles.item} fullWdith={false} variant="outlined" error={errors.actualnumfloors}/>
        </Panel>
        <Panel style={styles.row}>
          <Label caption="Height (m)" style={styles.label} />
          <Decimal name="bldgpermit.height" disabled={true} variant="outlined" style={styles.item} fullWdith={false} />
          <Decimal name="actualheight" style={styles.item} fullWdith={false} variant="outlined" error={errors.actualheight}/>
        </Panel>
        <Panel style={styles.row}>
          <Label caption="Start Date" style={styles.label} />
          <Date name="bldgpermit.dtproposedconstruction" disabled={true} variant="outlined" style={styles.item} fullWdith={false} />
          <Date name="dtactualstarted" style={styles.item} fullWdith={false} variant="outlined" error={errors.dtactualstarted} />
        </Panel>
        <Panel style={styles.row}>
          <Label caption="Completion Date" style={styles.label} />
          <Date name="bldgpermit.dtexpectedcompletion" disabled={true} variant="outlined" style={styles.item} fullWdith={false} />
          <Date name="dtactualcompleted" style={styles.item} fullWdith={false} variant="outlined" error={errors.dtactualcompleted} helperText={errors.dtactualcompleted} />
        </Panel>
        <Spacer />
      </FormPanel>
      <ActionBar>
        <BackLink action={movePrevStep} />
        <Button caption="Next" action={updatePermit} loading={loading}/>
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
