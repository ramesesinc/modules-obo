import React, { useState, useEffect } from "react";
import {
  Panel,
  Button,
  Error,
  FormPanel,
  Text,
  Spacer,
  Decimal,
  Date,
  ActionBar,
  PreviewReport,
  DownloadReport,
} from "rsi-react-web-components";

import { getHeaderInfo } from "../util";

// const getHeaderInfo = (contact={}) => {
//   let headerInfo = "";
//   headerInfo += "Please download and print the Building and Ancillary Permit forms, prepare the ";
//   headerInfo += "requirements listed below, and submit at the receiving window of our ";
//   headerInfo += contact.officename;
//   headerInfo += " at the ";
//   headerInfo += contact.address1;
//   if (contact.address2) {
//     headerInfo += ", " + contact.address2 + ". ";
//   } else {
//     headerInfo += ". ";
//   }
//   const phones = [];
//   if (contact.phoneno) phones.push(contact.phoneno)
//   if (contact.mobileno) phones.push(contact.mobileno)

//   if (contact.email) {
//     if (phones.length > 0) {
//       headerInfo += "You can email at " + contact.email;
//       headerInfo += " or contact us on " + phones.join(" or ");
//     } else {
//       headerInfo += "You can email us at " + contact.email;
//     }
//     headerInfo += " for any inquiries on application."
//   } else if (phones.length > 0)  {
//     headerInfo += "You can contact us on " + phones.join(" or ") + " for any inquiries on application."
//   }
//   return headerInfo;
// }

const BuildingPermitCompleted = ({
  partner,
  appno,
  appService,
  history,
}) => {
  const [error, setError] = useState();
  const [loading, setLoading] = useState(false);
  const [app, setApp] = useState({});
  const [requirements, setRequirements] = useState([]);

  const resetStatus = () => {
    setError(null)
    setLoading(false)
  }

  const loadApplication = () => {
    setLoading(true)
    appService.invoke("getProjectInfo", { appid: appno }, (err, app) => {
      if (err) {
        setError(err)
      } else {
        setApp(app)
        resetStatus()
      }
    })
  }

  const loadRequirements = () => {
    setLoading(true)
    appService.invoke("getRequirements",
      { appid: appno },
      (err, requirements) => {
        if (err) {
          setError(err)
        } else {
          setRequirements(requirements);
          resetStatus()
        }
      }
    )
  }

  useEffect(() => {
    loadApplication();
    loadRequirements();
  }, [])



  const location = [];
  if (app.location) {
    if (app.location.lotno) location.push(`Lot: ${app.location.lotno}`);
    if (app.location.blockno) location.push(`Block: ${app.location.blockno}`);
    if (app.location.street) location.push(`Street: ${app.location.street}`);
    if (app.location.barangay.name) location.push(`Barangay: ${app.location.barangay.name}`);
  }

  let contractor = "";
  if (app.contractor) {
    contractor = `${app.contractor.lastname}, ${app.contractor.firstname} ${app.contractor.middlename}`;
    contractor += `\n${app.contractor.profession}`;
    contractor += ` PRC NO.: ${app.contractor.prc.idno} Issued: ${app.contractor.prc.dtissued}`;
  }

  const headerInfo = getHeaderInfo(app.obocontactinfo, "Building and Ancillary Permit");

  return (
    <Panel>
      <Spacer />
      <Error msg={error} />
      <FormPanel context={app} handler={setApp}>
        <label>{headerInfo}</label>
        <Spacer height={10} />
        <Panel style={styles.container}>
          <Panel style={styles.infoContainer}>
            <Text caption="Tracking No." name="objid" readOnly={true} />
            <Text caption="Project Title" name="title" readOnly={true} />
            <Text caption="Location" expr={() => location.join(" ,")} readOnly={true} />
            <Text caption="Applicant" name="applicant.name" readOnly={true} />
            <Decimal caption="Project Cost" name="projectcost" readOnly={true} textAlign="left" />
            <Panel row>
              <Date caption="Est. Start Date" name="dtproposedconstruction" readOnly={true} />
              <Date caption="Est. End Date" name="dtexpectedcompletion" readOnly={true} />
            </Panel>
            <Text
              caption="Supervisor/In Charge of Project"
              expr={() => contractor}
              readOnly={true}
              multiline={true}
              rows={2}
            />
          </Panel>
        </Panel>
      </FormPanel>
      <Spacer />
      <h3>List of Requirements:</h3>
      <Panel style={styles.requirementsContainer}>
        {requirements.map((req, idx) => {
          const titles = req.title.split("\n");
          const items = getItemsComponent(titles);
          const docs = getDocumentsComponent(partner, req);
          return (
            <Panel>
              <p key={idx} style={styles.requirement}>{`${idx+1}.  ${titles[0]}`}</p>
              {docs}
              {items}
            </Panel>
          )
        })}
      </Panel>
      <ActionBar>
        <Button caption="Return" action={() => history.push(`/partner/${partner.group.name}_${partner.name}/services`)} />
      </ActionBar>
    </Panel>
  )
}

const getItemsComponent = (titles) => {
  if (titles.length === 1) return null;
  const items = titles.map((title, x) => {
    if (x === 0 || !title) return null;
    return <li style={styles.requirement}>{title}</li>
  });
  return <ul>{items}</ul>
}

const getDocumentsComponent = (partner, req) => {
  let docs;
  if (!req.docs) return null;
  docs = req.docs.map(doc =>
    <Panel key={doc.reportid} style={styles.document}>
      <label style={{marginLeft: 20}}>{doc.title}</label>
      <Panel row>
        <PreviewReport href={`/jreports/partner/${partner.group.name}_${partner.name}/obo/${doc.reportid}?refid=${doc.refid}`} />
        <DownloadReport href={`/jreports/download/partner/${partner.group.name}_${partner.name}/obo/${doc.reportid}?refid=${doc.refid}`}/>
      </Panel>
    </Panel>
  )
  return <Panel style={{margin: "0px 20px"}}>{docs}</Panel>;
}


const styles = {
  container: {
    display: "flex",
    flexDirection: "column",
    justifyConent: "flex-start",
    border: "1px solid #aaa",
    padding: 20,
    borderRadius: 3,
  },
  infoContainer: {
    display: "flex",
    flexDirection: "column",
    marginRight: 10,
    width: "100%",
  },
  linkContainer: {
    display: "flex",
    justifyContent: "flex-end",
    alignItems: "center",
    width: "100%",
  },
  requirementsContainer: {
    marginRight: 15,
    marginBottom: 20,
  },
  requirement: {
    fontSize: "0.9rem",
  },
  document: {
    display: "flex",
    justifyContent: "space-between",
    alignItems: "center",
    width: "100%",
    padding: 5,
    marginBottom: "5px",
    border: "1px solid #aaa",
  }
}


export default BuildingPermitCompleted
