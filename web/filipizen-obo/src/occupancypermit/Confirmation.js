import React, { useState, useEffect } from "react";
import {
  Panel,
  Spacer,
  ActionBar,
  Button,
  Label,
  BackLink,
  ButtonLink,
  PageviewIcon,
} from 'rsi-react-web-components';

const Confirmation = ({
  appno,
  partner,
  appService,
  movePrevStep,
  onComplete
}) => {

  const [error, setError] = useState();
  const [app, setApp] = useState({});
  const [isContracted, setIsContracted] = useState(false);

  useEffect(() => {
    appService.invoke("getApplication", {appid: appno}, (err, app) => {
      if (err) {
        setError(err);
      } else {{
        setApp(app);
      }}
    });
  }, [appno])

  const confirmPermit = () => {
    appService.invoke("update", app, (err, updatedApp) => {
      if (err) {
        setError(err)
      } else {
        onComplete();
      }
    })
  }

  return (
    <Panel>
      <p>
        Before sending please check first the generated
        application info. If everything is in order, you can
        click Submit button to complete the transaction.
      </p>
      <Spacer />
      <Panel style={styles.container}>
        <Panel  style={styles.row}>
          <Label style={styles.label}>Application for Occupancy Permit</Label>
          <ButtonLink
              caption="Preview"
              href={`/jreports/obo/certificate_of_occupancy?refid=${appno}`}
              Icon={PageviewIcon}
            />
        </Panel>
        <Panel style={styles.row}>
          <Label style={styles.label}>Certificate of Completion</Label>
          <ButtonLink
              caption="Preview"
              href={`/jreports/obo/certificate_of_completion?refid=${appno}`}
              Icon={PageviewIcon}
            />
        </Panel>
      </Panel>
      <ActionBar>
        <BackLink action={movePrevStep} />
        <Button caption="Submit" action={confirmPermit} />
      </ActionBar>
    </Panel>
  )
}

const styles = {
  container: {
    maxWidth: 350,
    marginLeft: 50,
  },
  row: {
    display: "flex",
    justifyContent: "space-between",
    alignItems: "center",
  },
  label: {
    fontWeight: "bold",
  }
}

export default Confirmation;
