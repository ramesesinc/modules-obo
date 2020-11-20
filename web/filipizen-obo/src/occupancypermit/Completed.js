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

const Completed = ({
  appno,
  partner,
  appService,
  onComplete
}) => {

  const [error, setError] = useState();
  const [app, setApp] = useState({});

  useEffect(() => {
    appService.invoke("getApplication", {appid: appno}, (err, app) => {
      if (err) {
        setError(err);
      } else {{
        setApp(app);
      }}
    });
  }, [appno])

  return (
    <Panel>
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
        <Button caption="Return" action={onComplete} />
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

export default Completed;
