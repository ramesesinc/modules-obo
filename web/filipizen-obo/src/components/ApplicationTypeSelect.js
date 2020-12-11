import React, { useState } from "react";
import {
  Button,
  Radio,
  ActionBar,
  BackLink,
  Item,
  Spacer,
  Error,
  Text,
  Subtitle,
  Page,
  Card,
  Title,
  Panel,
} from 'rsi-react-web-components';

const ApplicationTypeSelect = ({
  onCancel,
  onSubmit,
  service,
  partner,
  appService
}) => {
  const [errorText, setErrorText] = useState({});
  const [appType, setAppType]= useState("new");
  const [appno, setAppno] = useState();
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState();

  const submitAppType = () => {
    if (appType === "new") {
      onSubmit({appType, appno});
      return;
    }

    if (!appno) {
      setErrorText({appno: "Tracking No. is required."});
      return
    }

    setLoading(true);
    setError(null);
    appService.invoke("findCurrentInfo", {appid: appno}, (err, app) => {
      if (err) {
        setError(err);
      } else if(!app) {
        setErrorText({appno: "Application no. does not exist"});
      } else if( partner.id !== app.orgcode ) {
        setErrorText({appno: "The application number provided is not for this local government"});
      } else {
        onSubmit({appType, appno});
      }
      setLoading(false);
    });
  }

  return (
    <Page>
      <Card>
        <Title>{service.title}</Title>
        <Subtitle>Select an action</Subtitle>
        <Spacer height={30} />
        <Error msg={error} />
        <Radio value={appType} onChange={setAppType} >
          <Item caption="Create New Application" value="new" />
          <Item caption="Resume Pending Application" value="resume" />
        </Radio>
        <Panel style={{paddingLeft: 30}}>
          <Text
            caption="Application Tracking No."
            value={appno} onChange={setAppno}
            visibleWhen={appType === "resume"}
            variant="outlined"
            fullWidth={false}
            required
            style={{marginLeft: 40}}
            error={errorText.appno || error}
            helperText={errorText.appno || error}
            size="small"
            />
        </Panel>
        <ActionBar>
          <BackLink caption="Cancel" action={onCancel} />
          <Button caption="Next" action={submitAppType} loading={loading} disableWhen={loading} />
        </ActionBar>
      </Card>
    </Page>
  )
}

export default ApplicationTypeSelect;
