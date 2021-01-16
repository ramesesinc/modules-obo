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
  BackLink,
} from "rsi-react-web-components";

import { Person, IdEntry, PrcCard, PtrCard } from "rsi-react-filipizen-components";

const EditProfessional = ({
  appService,
  partner,
  professional: initialProfessional={},
  onCancel,
  onSubmit
}) => {

  const formRef = useRef();

  const [error, setError] = useState();
  const [processing, setProcessing] = useState(false);
  const [professional, setProfessional] = useState(initialProfessional);
  const [hasError, setHasError] = useState(false);

  const updateProfessional = () => {
    if (hasError || !formRef.current.reportValidity()) return;

    setProcessing(true);
    setError(null);
    const updatedProfessional = { objid: professional.objid }
    updatedProfessional.prc = professional.prc;
    updatedProfessional.ptr = professional.ptr;

    appService.invoke("updateProfessional", updatedProfessional, (err, prof) => {
      if (err) {
        setError(err);
      } else {
        onSubmit();
      }
      setProcessing(false);
    })
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
      <Subtitle>Edit Professional Information </Subtitle>
      <Spacer />
      <Error msg={error} />

      <Panel>
        <form ref={formRef}>
          <FormPanel context={professional} handler={setProfessional}>
            <Text caption="Profession" name="profession" readOnly={true} />
            <Text caption="Full Name" name="name" readOnly={true} />
            <Spacer />
            <p>Update the databelow and then submit</p>
            <PrcCard name="prc"
              disableIdNo={true}
              editValidity={true}
              readOnly={true}
              onError={onError}
              dtIssued={professional.prc.dtissued} />
            <PtrCard name="ptr" disableIdNo={true} onError={onError} />
            <ActionBar>
              <BackLink action={onCancel} />
              <Button caption="Next" action={updateProfessional} loading={processing} disableWhen={processing} />
            </ActionBar>
          </FormPanel>
        </form>
      </Panel>
    </Panel>
  )
}

export default EditProfessional;
