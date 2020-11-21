import React, { useState, useEffect } from "react";
import {
  Panel,
  ActionBar,
  Button,
  Label,
  Spacer,
  PreviewReport,
  DownloadReport,
  Service
} from 'rsi-react-web-components';


const getHeaderInfo = (contact={}) => {
  let headerInfo = "";
  headerInfo += "Please download and print the Application for Occupancy Permit and Certificate of Completion forms, ";
  headerInfo += "and submit at the receiving window of our ";
  headerInfo += contact.officename;
  headerInfo += " at the ";
  headerInfo += contact.address1;
  if (contact.address2) {
    headerInfo += ", " + contact.address2 + ". ";
  } else {
    headerInfo += ". ";
  }
  const phones = [];
  if (contact.phoneno) phones.push(contact.phoneno)
  if (contact.mobileno) phones.push(contact.mobileno)

  if (contact.email) {
    if (phones.length > 0) {
      headerInfo += "You can email at " + contact.email;
      headerInfo += " or contact us on " + phones.join(" or ");
    } else {
      headerInfo += "You can email us at " + contact.email;
    }
    headerInfo += " for any inquiries on application."
  } else if (phones.length > 0)  {
    headerInfo += "You can contact us on " + phones.join(" or ") + " for any inquiries on application."
  }
  return headerInfo;
}

const Completed = ({
  appno,
  partner,
  appService,
  onComplete,
  history
}) => {

  const [error, setError] = useState();
  const [app, setApp] = useState({});
  const [contactInfo, setContactInfo] = useState({});

  const loadContactInfo = () => {
    const svc = Service.lookup("OboContactInfoService", "obo");
    svc.invoke("getInfo", {orgcode: partner.id}, (err, info) => {
      if (err) {
        setError(err);
      } else {
        setContactInfo(info);
      }
    })
  }

  useEffect(() => {
    appService.invoke("getApplication", {appid: appno}, (err, app) => {
      if (err) {
        setError(err);
      } else {{
        setApp(app);
        loadContactInfo();
      }}
    });
  }, [appno])

  const headerInfo = getHeaderInfo(contactInfo);

  return (
    <Panel>
      <label>{headerInfo}</label>
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
        <Button caption="Return" action={() => history.goBack()} />
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

export default Completed;
