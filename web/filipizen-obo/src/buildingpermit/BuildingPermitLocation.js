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
  FormPanel,
  Service
} from 'rsi-react-web-components';

import { BarangayList, useBarangayList } from "rsi-react-filipizen-components";

const BuildingPermitLocation = (props) => {
  const { partner, appno, appService, moveNextStep } = props;
  const barangays = useBarangayList(partner.id);

  const [error, setError] = useState();
  const [loading, setLoading] = useState(false);
  const [location, setLocation] = useState({});


  const initializeLocation = () => {
    appService.invoke("getRpus", {appid: props.appno}, (err, rpus) => {
      if (err) {
        setError(err);
      } else {
        const rpu = rpus[0];
        setLocation({
          lotno: rpu.lotno,
          blockno: rpu.blockno,
          street: rpu.street,
          barangay: barangays.find(brgy => brgy.name === rpu.barangay),
        });
        setLoading(false);
      }
    });
  }

  useEffect(() => {
    setLoading(true);
    appService.invoke("getLocation", {appid: props.appno}, (err, location) => {
      if (err) {
        setError(err);
        setLoading(false);
      } else {
        if (location && location.barangay && location.barangay.objid) {
          location.barangay.parentid = partner.id;
          setLocation(location);
        } else {
          setLocation(null);
        }
      }
    });
  }, []);


  useEffect(() => {
    if (location === null && barangays.length > 0) {
      initializeLocation();
    }
  }, [location, barangays])

  const updateLocation = () => {
    setError(null);
    appService.invoke("saveLocation", {appid: appno, ...location}, (err, app) => {
      if (err) {
        setError(err);
      } else {
        moveNextStep();
      }
    })
  }

  return (
    <Panel>
      <label>{`Tracking No. ${appno}`}</label>
      <Subtitle>Project Location</Subtitle>
      <Spacer />

      <Panel>
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
          <Text name='barangay.name' caption='Barangay' readOnly={true} />
          {/**
            <BarangayList barangays={barangays} name="barangay" caption='Barangay' />
           */}
        </FormPanel>
        <ActionBar>
          <BackLink caption="Back" action={() => setMode("view-rpus")} variant="text" />
          <Button caption='Next' action={updateLocation} />
        </ActionBar>
      </Panel>
    </Panel>
  );
}

export default BuildingPermitLocation;

