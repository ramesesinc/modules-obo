import React, { useState, useEffect } from "react";
import {
  Panel,
  Subtitle,
  Subtitle2,
  ActionBar,
  Button,
  Spacer,
  Error,
  Text,
  FormPanel,
  Decimal
} from 'rsi-react-web-components';

import { BarangayList, useBarangayList } from "rsi-react-filipizen-components";


const BuildingPermitLocation = (props) => {
  const { partner, appno, appService, moveNextStep } = props;
  const barangays = useBarangayList(partner.id);

  const [error, setError] = useState();
  const [loading, setLoading] = useState(false);
  const [location, setLocation] = useState({});
  const [brgyName, setBrgyName] = useState();

  useEffect(() => {
    setLoading(true);
    appService.invoke("getLocation", {appid: props.appno}, (err, location) => {
      if (err) {
        setError(err);
        setLoading(false);
      } else {
        if (location && location.barangay && location.barangay.name) {
          setLocation(location);
          setBrgyName(location.barangay.name);
        } else {
          setLocation({});
        }
      }
    });
  }, []);


  useEffect(() => {
    const initializeLocation = () => {
      appService.invoke("getRpus", {appid: props.appno}, (err, rpus) => {
        if (err) {
          setError(err);
        } else {
          const rpu = rpus[0];
          const brgyName = location && location.barangay ? location.barangay.name : rpu.barangay;
          const updatedLocation = {...location};
          if (!(location && location.barangay && location.barangay.objid)) {
            updatedLocation.lotno =  rpu.lotno;
            updatedLocation.lotarea =  rpu.areasqm;
            updatedLocation.blockno =  rpu.blockno;
            updatedLocation.street =  rpu.street;
          }
          updatedLocation.barangay = barangays.find(brgy => brgy.name === brgyName);

          setLocation(updatedLocation);
          setLoading(false);
        }
      });
    }

    if (barangays.length > 0) {
      initializeLocation();
    }
  }, [brgyName, barangays])

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

  if (loading) {
    return (
      <Panel>
        <label>{`Tracking No. ${appno}`}</label>
        <Subtitle>Project Location</Subtitle>
      </Panel>
    )
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
          <BarangayList barangays={barangays} name="barangay" caption='Barangay' />
          <Decimal name="lotarea" caption="Lot Area (sq.m.)" textAlign="left" />
        </FormPanel>
        <ActionBar>
          <Button caption='Next' action={updateLocation} />
        </ActionBar>
      </Panel>
    </Panel>
  );
}

export default BuildingPermitLocation;

