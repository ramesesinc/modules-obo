import React, { useState, useEffect } from "react";
import {
  Panel,
  Subtitle,
  Spacer,
  ActionBar,
  Button,
  Radio,
  Item,
  FormPanel,
  Error
} from 'rsi-react-web-components';

const OccupancyType = ({
  appno,
  appService,
  currentStep,
  stepCompleted,
  moveNextStep,
  onSubmitOccupancyType
}) => {
  const [error, setError] = useState();
  const [loading, setLoading] = useState(false);
  const [app, setApp] = useState({});

  useEffect(() => {
    setError(null);
    appService.invoke("getApplication", {appid: appno}, (err, app) => {
      if (err) {
        setError(err);
      } else {{
        setApp(app);
      }}
    });
  }, []);

  const submitApplicationType = () => {
    const updatedApp = { objid: app.objid, apptype: app.apptype }
    appService.invoke("update", updatedApp, (err, app) => {
      if (!err) {
        moveNextStep();
      } else {
        setError(err)
      }
    });
  }

  return (
    <Panel>
      <Error msg={error} />
      <FormPanel context={app} handler={setApp}>
        <Radio name="apptype">
          <Item caption="Full (Completed)" value="full" />
          <Item caption="Partial" value="partial" />
        </Radio>
      </FormPanel>
      <ActionBar>
        <Button caption="Next" action={submitApplicationType} />
      </ActionBar>
    </Panel>
  )
}

export default OccupancyType;
