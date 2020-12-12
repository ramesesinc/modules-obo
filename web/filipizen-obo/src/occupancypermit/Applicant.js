import React, { useState, useEffect, useRef } from 'react'
import {
  Error,
  FormPanel,
  Text,
  Email,
  Mobileno,
  Spacer,
  Checkbox,
  Combobox,
  Button,
  ActionBar,
  Panel,
  BackLink,
  Subtitle2
} from 'rsi-react-web-components'

import { LocalAddress, NonLocalAddress, IdEntry } from 'rsi-react-filipizen-components';

const entityTypes = ['INDIVIDUAL', 'CORPORATION', 'GOVERNMENT', 'OTHER']

const Applicant = ({
  appno,
  partner,
  appService,
  movePrevStep,
  moveNextStep,
}) => {

  const [loading, setLoading] = useState(false)
  const [error, setError] = useState(false)
  const [editmode, setEditmode] = useState("read");
  const [applicant, setApplicant] = useState({
    appno,
    appid: appno,
    entitytype: 'INDIVIDUAL',
    resident: false,
  })

  const formRef = useRef();

  useEffect(() => {
    setLoading(true);
    setError(null);
    appService.invoke("getApplicant", {appid: appno}, (err, applicant) => {
      if (err) {
        setError(err)
      } else {
        setApplicant(applicant || {});
      };
      setLoading(false);
      setEditmode("read");
    })
  }, []);

  const saveApplicant = () => {
    if (!formRef.current.reportValidity()) return;
    if (applicant.resident && applicant.address && !applicant.address.barangay) {
      return;
    }

    setError(null);
    setLoading(true);
    appService.invoke("saveApplicant", applicant, (err, app) => {
      if (err) {
        setError(err)
      } else {
        moveNextStep();
      }
      setLoading(false)
    });
  }

  const residentHandler = () => {
    const updatedApplicant = {...applicant, resident: !applicant.resident, address: {}};
    setApplicant(updatedApplicant);
  }

  return (
    <Panel>
      <Error msg={error} />
      <FormPanel context={applicant} handler={setApplicant} >
        <form ref={formRef}>
          <Combobox items={entityTypes} name='entitytype' caption='Type of Applicant'/>
          <Text caption='Name' name='name' visibleWhen={applicant.entitytype !== 'INDIVIDUAL'}/>

          <Spacer />
          <Panel>
            <Subtitle2>Administrator or contact name of applicant</Subtitle2>
            <Text caption='Last Name' name='lastname' required={true}/>
            <Text caption='First Name' name='firstname' required={true}/>
            <Text caption='Middle Name' name='middlename' required={true}/>
            <Email name='email'/>
            <Mobileno name='mobileno'/>
          </Panel>

          <Spacer />
          <Subtitle2>Applicant Address</Subtitle2>
          <Checkbox caption='Resident' name='resident' onChange={residentHandler}/>
          {applicant.resident ?
            <LocalAddress orgcode={partner.id} name='address' caption='Address' isResident={applicant.resident} />
            :
            <NonLocalAddress name='address' caption='Address'  />
          }
          <Spacer />
          <Subtitle2>Proof of Identity</Subtitle2>
          <IdEntry name="id" />
        </form>
      </FormPanel>

      <ActionBar>
        <BackLink action={movePrevStep} />
        <Button caption='Next' action={saveApplicant} disableWhen={loading} loading={loading}  />
      </ActionBar>
    </Panel>
  )
}

export default Applicant
