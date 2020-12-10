import React, { useState, useRef } from "react";
import {
  ActionBar,
  Button,
  Panel,
  Error,
  Subtitle,
  FormPanel,
  Spacer,
  Text,
  BackLink
} from "rsi-react-web-components";

import { Person, IdEntry, PrcCard, PtrCard } from "rsi-react-filipizen-components";

const NewProfessional = ({
  info = {},
  partner,
  onCancel,
  onSubmit
}) => {

  const formRef = useRef();

  const initialProfessional = {
    entity: {...info, resident: true},
    prc: info.prc,
    id: {},
    resident: true
  }

  const [error, setError] = useState();
  const [professional, setProfessional] = useState(initialProfessional);
  const [hasError, setHasError] = useState(false);

  const submitHandler = () => {
    if (!hasError && formRef.current.reportValidity()) {
      onSubmit(professional);
    }
  }

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

  return (
    <Panel>
      <Subtitle>Register New Professional</Subtitle>
      <Spacer />
      <Error msg={error} />

      <Panel>
        <form ref={formRef}>
          <FormPanel context={professional} handler={setProfessional}>
            <p>Please fill in the necessary data below. Text marked with * are required fields. </p>
            <Text caption="Profession" name="entity.profession" readOnly={true} />
            <Person name="entity" person={professional} showAddress={true} orgcode={partner.id} />
            <Spacer />
            <PrcCard name="prc" disableIdNo={true} onError={onError} dtIssued={professional.prc.dtissued} />
            <PtrCard name="ptr" onError={onError} />
            <IdEntry caption="Primary Identification" name="id" onError={onError} dtIssued={professional.id.dtissued} />
            <ActionBar>
              <BackLink action={onCancel} />
              <Button caption="Next" action={submitHandler} />
            </ActionBar>
          </FormPanel>
        </form>
      </Panel>
    </Panel>
  )
}

export default NewProfessional;
