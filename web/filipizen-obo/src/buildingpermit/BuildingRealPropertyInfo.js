import React, { useState, useEffect, useRef } from "react";
import {
  Panel,
  Subtitle,
  Subtitle2,
  BackLink,
  ActionBar,
  Button,
  Spacer,
  Error,
  Text,
  Service,
  Label,
  FormPanel,
} from 'rsi-react-web-components';

import LotOwnershipType from "../components/LotOwnershipType";
import OwnershipInfo from "../components/OwnershipInfo";
import LotInformation from "../components/LotInformation";

const BuildingRealPropertyInfo = ({
  partner, appno, appService, moveNextStep
}) => {
  const [error, setError] = useState();
  const [loading, setLoading] = useState(false);
  const [mode, setMode] = useState("view-rpus");

	const [refno, setRefno] = useState();
  const [rpus, setRpus] = useState([]);
  const [property, setProperty] = useState({});
  const [hasError, setHasError] = useState(false);

  const formRef = useRef();

  /* load rpus */
  useEffect(() => {
    if (mode === "view-rpus") {
      reloadList();
    }
  }, [mode])

  const viewInitial = () => {
    setRefno();
    setError(null);
    setMode("initial");
  }

  const findProperty = () => {
    setLoading(true);
    const orgcode = partner.orgcode || partner.id;
    const svc = Service.lookup( orgcode + ":OboOnlineService", "obo");
    svc.invoke("findLocation", { refno: refno || newRefno }, (err, property) => {
      if (err) {
        setError(err);
      } else {
        if(property.owner.address.type == 'local' ) {
          property.owner.resident = 1;
        }
        else {
          property.owner.resident = 0;
        }
        if( property.owner.address.city ) property.owner.address.citymunicipality = property.owner.address.city;
        if( property.owner.address.municipality ) property.owner.address.citymunicipality = property.owner.address.municipality;
        property.owner.ctc = {};
        property.lotowned = "1";
        property.appid = appno;
        console.log("Property", property)
        setProperty(property);
        setMode("view-lot");
      }
      setLoading(false);
    });
  }

  const reloadList = () => {
    appService.invoke("getRpus", {appid: appno}, (err, rpus) => {
      if (err) {
        setError(err);
      } else {
        setRpus(rpus);
      }
    } );
  }

  const editOwnerInfo = props => {
    setMode("edit-owner-info");
    //TODO: activate validation below
    // if(property.bill !== null && property.bill.amtdue != null &&  property.bill.amtdue > 0 ) {
    //   setError("Please settle all unpaid balances first before proceeding");
    // } else {
    //   setError(null);
    //   setMode("edit-owner-info");
    // }
  }

  const viewList = () => {
    setMode("view-rpus");
  }

  const onError = (error) => {
    setHasError(error);
  }

  const saveRpu = () => {
    // if( !property.owner.id ) {
    //   alert("Please provide proof of identity for owner/administrator of property");
    //   return;
    // }
    if (!hasError && formRef.current.reportValidity()) {
      setError(null);
      appService.invoke("saveRpu", property, (err, rpu) => {
        if (err) {
          setError(err)
        } else {
          reloadList();
          setMode("view-rpus");
        }
      });
    }
  }

  const viewLocations = () => {
    setError(null);
    if (rpus.length === 0) {
      setError("Add at least one Lot Information.");
    } else {
      moveNextStep();
    }
  }

  const deleteRpu = (rpu) => {
    setError(null);
    appService.invoke("removeRpu", rpu, (err, res) => {
      if (err) {
        setError(err);
      } else {
        setRpus(rpus.map(r => r.objid !== rpu.objid));
      }
    })
  }

  const getAddressText = (item) =>  {
    const addr = [];
    if (item.lotno) addr.push(`Lot: ${item.lotno}`);
    if (item.blockno) addr.push(`Block: ${item.blockno}`);
    if (item.street) addr.push(`Street: ${item.street}`);
    if (item.barangay) addr.push(`Barangay: ${item.barangay}`);
    return addr.join(" ");
  }

  return (
    <Panel>
      <label>{`Tracking No. ${appno}`}</label>
      <Subtitle>Real Property Information</Subtitle>
      <Spacer />
      <Panel visibleWhen={mode === "view-rpus"}>
        <Subtitle2>Lot Information</Subtitle2>
        <Error msg={error} />
        {rpus.map(rpu => (
          <Panel style={styles.locationContainer} key={rpu.tdno}>
            <div style={styles.tdno}>
              <Subtitle2>{`TD No. ${rpu.tdno}`}</Subtitle2>
            </div>
            <div style={styles.rpuInfoContainer}>
              <Label caption="Title No.">{rpu.titleno}</Label>
              <Label caption="PIN">{rpu.pin}</Label>
              <Label caption="Address">{getAddressText(rpu)}</Label>
              <Label caption="Class">{rpu.classcode}</Label>
              <Label caption="Area">{rpu.areasqm}</Label>
              <Label caption="Owner">{rpu.owner.name}</Label>
            </div>
          </Panel>
        ))}
        <ActionBar>
          <Button caption="Add Lot Info" action={viewInitial} />
          <Button caption="Next" action={viewLocations} />
        </ActionBar>
      </Panel>

      <Panel visibleWhen={mode === "initial"}>
        <Subtitle2>Specify the Site Location/Property</Subtitle2>
        <Error msg={error} />
        <Spacer />
        <Text caption="Tax Declaration No." value={refno} onChange={setRefno} autoFocus={true} />
        <ActionBar>
          <Button caption="Back to List" action={viewList} variant="text" />
          <Button caption="Search" action={findProperty} disableWhen={loading} loading={loading} />
        </ActionBar>
      </Panel>

      <Panel visibleWhen={mode === "view-lot"}>
        <p>
        Please check carefully if the information is correct.
        For any discrepancies, please contact the Assessor's Office before proceeding.
        </p>

          {(property && property.bill && property.appno )  &&
            <label style={styles.balanceText}>
              Note: There is still an unpaid balance of <u>Php #{property.bill ? property.bill.amtdue : 0.0}</u>.
              You can settle this by paying online <a  href={`/partner/${partner.group.name}_${partner.name}/rptis/rptbilling`} target="0"><u>here</u></a>
            </label>
          }
        <FormPanel context={property} handler={setProperty}>
          <LotInformation editable={false} />
          <Spacer />
          <OwnershipInfo name="owner" orgcode={partner.id} owner={property.owner} editable={false} />
        </FormPanel>
        <ActionBar>
          <BackLink action={viewInitial} caption='Back' />
          <Button action={editOwnerInfo} caption='Next' />
        </ActionBar>
      </Panel>

      <Panel visibleWhen={mode === "edit-owner-info"}>
          <form ref={formRef}>
            <label>Please update the information if necessary</label>
            <FormPanel context={property} handler={setProperty}>
              <LotOwnershipType caption="Is lot owned or leased?" property={property} name="lotowned" row autoFocus={true} />
              <OwnershipInfo name="owner" owner={property.owner}
                orgcode={partner.id}
                editable={false}
                showIdEntry={true}
                editableAddress={true}
                editableIdEntry={true}
                onError={onError} />
            </FormPanel>
            <ActionBar>
              <BackLink action={() => setMode("view-lot")} caption="Back" />
              <Button action={saveRpu} caption="Next" />
            </ActionBar>
          </form>
      </Panel>
    </Panel>
  );
}

const styles = {
  balanceText: {
    color: "red",
    fontWeight: "bold",
  },
  locationContainer: {
    border: "1px solid #aaa",
    borderRadius: 5,
    boxShadow: "0px 5px 7px -7px rgba(0,0,0,0.75)",
    marginBottom: 10
  },
  tdno: {
    padding: "5px 10px",
    backgroundColor: "#ddd",
    borderBottom: "1px solid #aaa",
    borderRadius: 5,
  },
  rpuInfoContainer: {
    padding: "10px",
  }
}

export default BuildingRealPropertyInfo;

