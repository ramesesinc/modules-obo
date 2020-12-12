import React, { useState, useEffect } from "react";
import {
  Panel,
  ActionBar,
  Button,
  Label,
  Spacer,
  PreviewReport,
  DownloadReport,
  Error,
  Service
} from 'rsi-react-web-components';

import { getHeaderInfo } from "../util";

const Completed = ({
  appno,
  partner,
  appService,
  history
}) => {

  const [error, setError] = useState();
  const [loading, setLoading] = useState(false);
  const [app, setApp] = useState({});
  const [contactInfo, setContactInfo] = useState({});
  const [requirements, setRequirements] = useState([]);

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

  const loadRequirements = () => {
    setLoading(true);
    setError(null);
    appService.invoke("getRequirements", { appid: appno }, (err, requirements) => {
        if (err) {
          setError(err)
        } else {
          setRequirements(requirements);
          setLoading(false);
        }
      }
    )
  }

  useEffect(() => {
    appService.invoke("getApplication", {appid: appno}, (err, app) => {
      if (err) {
        setError(err);
      } else {{
        setApp(app);
        loadContactInfo();
        loadRequirements();
      }}
    });
  }, [appno])

  const headerInfo = getHeaderInfo(contactInfo, "Application for Occupancy Permit and Certificate of Completion");

  return (
    <Panel>
      {error &&
        <React.Fragment>
          <Error msg={error} />
          <Spacer />
        </React.Fragment>
      }
      <label>{headerInfo}</label>
      <Spacer />
      <Panel style={styles.container}>
        <Panel  style={styles.document}>
          <Label style={styles.label}>Application for Occupancy Permit</Label>
          <Panel row>
            <PreviewReport href={`/jreports/partner/${partner.group.name}_${partner.name}/obo/certificate_of_occupancy?refid=${appno}`} />
            <DownloadReport href={`/jreports/download/partner/${partner.group.name}_${partner.name}/obo/certificate_of_occupancy?refid=${appno}`}/>
          </Panel>
        </Panel>
        <Panel style={styles.document}>
          <Label style={styles.label}>Certificate of Completion</Label>
          <Panel row>
            <PreviewReport href={`/jreports/partner/${partner.group.name}_${partner.name}/obo/certificate_of_completion?refid=${appno}`} />
            <DownloadReport href={`/jreports/download/partner/${partner.group.name}_${partner.name}/obo/certificate_of_completion?refid=${appno}`}/>
          </Panel>
        </Panel>
      </Panel>
      <Spacer />
      <h3>List of Requirements:</h3>
      <Panel style={styles.requirementsContainer}>
        {requirements.map((req, idx) => {
          const titles = req.title.split("\n");
          const items = getItemsComponent(titles);
          const docs = getDocumentsComponent(partner, req);
          return (
            <Panel>
              <p key={idx} style={styles.requirement}>{`${idx+1}. ${titles[0]}`}</p>
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


export const getItemsComponent = (titles) => {
  if (titles.length === 1) return null;
  const items = titles.map((title, x) => {
    if (x === 0 || !title) return null;
    return <li style={styles.requirement}>{title}</li>
  });
  return <ul>{items}</ul>
}

export const getDocumentsComponent = (partner, req) => {
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
    padding: "0px 30px",
  },
  row: {
    display: "flex",
    justifyContent: "space-between",
    alignItems: "center",
  },
  label: {
    fontWeight: "bold",
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

export default Completed;
