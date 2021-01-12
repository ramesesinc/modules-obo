import React, { useState, useRef } from "react";
import {
  ActionBar,
  Button,
  Panel,
  Error,
  Subtitle,
  FormPanel,
  Text,
  BackLink,
  useData,
  Date,
  Checkbox,
  Email,
  Mobileno
} from "rsi-react-web-components";

import {
  LocalAddress,
  NonLocalAddress,
  IdEntry,
  PrcCard,
  PtrCard
} from "rsi-react-filipizen-components";

import { ACTIONS } from "./UpdateProfessionalWebController"

const EditInfo = ({
  partner,
  history,
  appService,
  moveNextStep,
  movePrevStep
}) => {

  const [ctx, dispatch] = useData();
  const { professional: initialProfessional, changeType } = ctx;

  const formRef = useRef();

  const [error, setError] = useState();
  const [processing, setProcessing] = useState(false);
  const [professional, setProfessional] = useState(initialProfessional);
  const [hasError, setHasError] = useState(false);

  const onError = (error, name) => {
    setHasError(error);
    if (name) {
      if (name === "prc.dtissued") {
        const id = {...professional.id}
        id.dtvalid = null;
        setProfessional({...professional, id})
      } else if (name === "id.dtissued") {
        const prc = {...professional.prc}
        prc.dtvalid = null;
        setProfessional({...professional, prc})
      }
    }
  }

  const updateProfessional = () => {
    if (!formRef.current.reportValidity()) return;

    setProcessing(true);
    const updatedProf = { ...professional, changetype: changeType };
    appService.invoke("updateProfessional", updatedProf, (err, updatedProfessional) => {
      if (err) {
        setError(err)
      } else {
        dispatch({type: ACTIONS.SET_PROFESSIONAL, updatedProfessional})
        moveNextStep();
      }
      setProcessing(false);
    })
  }

  return (
    <Panel>
      <Subtitle>Edit Professional Information </Subtitle>
      <Error msg={error} />

      <Panel>
        <form ref={formRef}>
          <FormPanel context={professional} handler={setProfessional}>
            <Panel visibleWhen={changeType === "CHANGE_PERSONINFO"}>
              <h4>Change Personal Information</h4>
              <Text caption="Last Name" name="lastname" required />
              <Text caption="First Name" name="firstname" required />
              <Text caption="Middle Name" name="middlename" required />
              <Date caption="Birth Date" name="birthdate" required />
            </Panel>

            <Panel visibleWhen={changeType === "CHANGE_ADDRESS"}>
              <h4>Change Address Information</h4>
              <React.Fragment>
                <Checkbox caption="Resident?" name="resident"/>
                {professional.resident  ?
                  <LocalAddress orgcode={partner.id} name="address" caption="Address"  />
                  :
                  <NonLocalAddress name="address" caption="Address"   />
                }
              </React.Fragment>
            </Panel>

            <Panel visibleWhen={changeType === "CHANGE_ID"}>
              <h4>Change Primary ID Information</h4>
              <IdEntry caption="" name="id" onError={onError} dtIssued={professional.id.dtissued} />
            </Panel>

            <Panel visibleWhen={changeType === "CHANGE_PTR"}>
              <h4>Change PTR Information</h4>
              <PtrCard caption="" name="ptr" disableIdNo={true} onError={onError} dtIssued={professional.ptr.dtissued} />
            </Panel>

            <Panel visibleWhen={changeType === "CHANGE_PRC"}>
              <h4>Change PRC Information</h4>
              <PrcCard caption=""
                name="prc"
                disableIdNo={true}
                editValidity={true}
                onError={onError}
                dtIssued={professional.prc.dtissued}
              />
            </Panel>
            <Panel visibleWhen={changeType === "CHANGE_CONTACT"}>
              <h4>Change Email/Mobile No. Information</h4>
              <Email name="email" required />
              <Mobileno name="mobileno" required />
            </Panel>

            <ActionBar>
              <BackLink action={movePrevStep} />
              <Button caption="Update" action={updateProfessional} loading={processing} disableWhen={processing} />
            </ActionBar>
          </FormPanel>
        </form>
      </Panel>
    </Panel>
  )
}

export default EditInfo;
