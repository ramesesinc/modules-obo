import React, { useState, useEffect } from "react";
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

import { BarangayList, useBarangayList } from "rsi-react-filipizen-components";
import LotOwnershipType from "../components/LotOwnershipType";
import OwnershipInfo from "../components/OwnershipInfo";
import LotInformation from "../components/LotInformation";

const BuildingPermitLocation = (props) => {
  const { partner, appno, appService, moveNextStep } = props;
  const barangays = useBarangayList(partner.id);

  const [error, setError] = useState();
  const [loading, setLoading] = useState(false);
  const [mode, setMode] = useState("view-rpus");
  const [editmode, setEditmode] = useState("view")

	const [refno, setRefno] = useState();
  const [rpus, setRpus] = useState([]);
  const [property, setProperty] = useState({});
  const [location, setLocation] = useState({});


  /* load rpus */
  useEffect(() => {
    if (mode === "view-rpus") {
      reloadList();
    }
  }, [mode])

  const viewInitial = () => {
    setRefno();
    setEditmode("edit");
    setMode("initial");
  }

  const findProperty = () => {
    const orgcode = partner.orgcode || partner.id;
    const svc = Service.lookup( orgcode + ":OboOnlineService" );
    svc.findLocation( { refno: refno || newRefno }, (err, property) => {
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
        property.owner.ctc = {};      //allocate ctc
        property.lotowned = 1;
        property.appid = props.appno;
        setProperty(property);
        setMode("view-lot");
      }
    });
  }

  const reloadList = () => {
    appService.getRpus({appid: props.appno}, (err, rpus) => {
      if (err) {
        setError(err);
      } else {
        setRpus(rpus);
      }
    } );
  }

  const viewList = () => {
    setMode("view-rpus");
  }

  const editOwner = () => {

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

  const saveRpu = () => {
    if( !property.owner.id ) {
      alert("Please provide proof of identity for owner/administrator of property");
      return;
    }
    setError(null);
    appService.saveRpu(property, (err, rpu) => {
      if (err) {
        setError(err)
      } else {
        reloadList();
        setMode("view-rpus");
      }
    });
  }

  const viewSpecifyLocation = () => {
    setError(null);
    if (rpus.length === 0) {
      setError("Add at least one Lot Information.");
    } else {
      const prop = rpus[0];
      setLocation({
        lotno: prop.lotno,
        blockno: prop.blockno,
        barangay: barangays.find(brgy => brgy.name === prop.barangay),
      });
      setMode("specify-location");
    }
  }

  const updateLocation = () => {
    setError(null);
    appService.saveLocation({appid: appno, ...location}, (err, app) => {
      if (err) {
        setError(err);
      } else {
        moveNextStep();
      }
    })
  }

  const deleteRpu = (rpu) => {
    setError(null);
    appService.removeRpu(rpu, (err, res) => {
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
      <Panel visibleWhen={mode === "view-rpus"}>
        <Subtitle>Project Location</Subtitle>
        <Spacer />
        <Subtitle2>Lot Information</Subtitle2>
        <Error msg={error} />
        {rpus.map(rpu => (
          <Panel style={styles.locationContainer} key={rpu.tdno}>
            <div style={styles.tdno}>
              <Subtitle2>TD No. {rpu.tdno}</Subtitle2>
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
          <Button caption="Next" action={viewSpecifyLocation} />
        </ActionBar>
      </Panel>

      <Panel visibleWhen={mode === "initial"}>
        <Subtitle>Project Location</Subtitle>
        <Spacer />
        <Subtitle2>Specify the Site Location/Property</Subtitle2>
        <Error msg={error} />
        <Text caption="Tax Declaration No." value={refno} onChange={setRefno} autoFocus={true} />
        <ActionBar>
          <Button caption="Back to List" action={viewList} variant="text" />
          <Button caption="Search" action={findProperty} />
        </ActionBar>
      </Panel>

      <Panel visibleWhen={mode === "view-lot"}>
        <Subtitle>Project Location</Subtitle>
        <p>Please check carefully if the information is correct. If not, please contact the Assessor's Office before proceeding.</p>
        {/** TODO:

        <Label>
          <a href="mailto:assessor@filipizen.com?subject=Building Application Inquiry No: #{appid}&body=Please state your concern: ">[Click Here to Send Message] </a>
        </Label>

            {(property && property.appno)  &&
              <Label style={styles.balanceText}>
                Note: There is still an unpaid balance of <u>Php #{property.bill.amtdue}</u>.
                You can settle this by paying online <a  href="/partners/${partner.name}/services/rptis/billing#viewbill?refno=#{refno}" target="0"><u>here</u></a>
              </Label>
            }
           */}

        <FormPanel context={property} handler={setProperty}>
          <LotInformation editable={false} />
          <LotOwnershipType property={property} name="lotowned" row editable={false} />
          <OwnershipInfo name="owner" orgcode={partner.id} owner={property.owner} editable={false} />
        </FormPanel>
        <ActionBar>
          <BackLink action={viewInitial} caption='Back' visibleWhen={editmode === "edit" } />
          <Button action={editOwnerInfo} caption='Next'  visibleWhen={editmode == "edit"} />
          <Button action={viewList} caption='Back' visibleWhen={editmode === "view" } />
        </ActionBar>
      </Panel>

      <Panel visibleWhen={mode === "edit-owner-info"}>
        <Subtitle>Project Location</Subtitle>
        <p>Please update the information if necessary</p>
        <FormPanel context={property} handler={setProperty}>
          <LotOwnershipType name="lotowned" row autoFocus={true} />
          <OwnershipInfo name="owner" owner={property.owner} orgcode={partner.id} showIdEntry={true} />
        </FormPanel>
        <ActionBar>
          <BackLink action={() => setMode("view-lot")} caption="Back" />
          <Button action={saveRpu} caption="Next" />
        </ActionBar>
      </Panel>

      <Panel visibleWhen={mode === "specify-location"}>
        <Subtitle>Project Location</Subtitle>
        <Subtitle2>Specify Project Location</Subtitle2>
        <Spacer />
        <Error msg={error} />
        <FormPanel context={location} handler={setLocation}>
          <Panel row>
            <Text name='lotno' caption='Lot No.' />
            <Text name='blockno' caption='Block No.' />
          </Panel>
          <Panel row>
            <Text name='unitno' caption='Unit No.' />
            <Text name='bldgno' caption='Building No.' />
          </Panel>
          <Text name='bldgname' caption='Building Name' />
          <Text name='street' caption='Street' />
          <Text name='subdivision' caption='Subdivision' />
          <BarangayList barangays={barangays} name="barangay" caption='Barangay' />
        </FormPanel>
        <ActionBar>
          <BackLink caption="Back" action={() => setMode("view-rpus")} variant="text" />
          <Button caption='Next' action={updateLocation} />
        </ActionBar>
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

export default BuildingPermitLocation;

