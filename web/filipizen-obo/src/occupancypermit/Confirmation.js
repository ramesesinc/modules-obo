import React, { useState, useEffect } from "react";
import {
  Panel,
  Spacer,
  ActionBar,
  Button,
  Label,
  BackLink,
  PreviewReport,
  DownloadReport,
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
          <Panel row>
            <PreviewReport href={`/jreports/partner/${partner.group.name}_${partner.name}/obo/certificate_of_occupancy?refid=${appno}`} />
            <DownloadReport href={`/jreports/download/partner/${partner.group.name}_${partner.name}/obo/certificate_of_occupancy?refid=${appno}`}/>
          </Panel>
        </Panel>
        <Panel style={styles.row}>
          <Label style={styles.label}>Certificate of Completion</Label>
          <Panel row>
            <PreviewReport href={`/jreports/partner/${partner.group.name}_${partner.name}/obo/certificate_of_completion?refid=${appno}`} />
            <DownloadReport href={`/jreports/download/partner/${partner.group.name}_${partner.name}/obo/certificate_of_completion?refid=${appno}`}/>
          </Panel>
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
    padding: "0px 30px",
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
