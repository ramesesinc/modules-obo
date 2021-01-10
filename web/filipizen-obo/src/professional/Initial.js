import React, { useState, useEffect, useRef } from "react";
import {
  Subtitle,
  Error,
  FormPanel,
  Spacer,
  Text,
  Email,
  Mobileno,
  ActionBar,
  Button,
  BackLink,
  Panel,
  Service,
  MaskedInput
} from 'rsi-react-web-components';

import { VerifyEmailCode } from "rsi-react-filipizen-components";
import ProfessionList from "../components/ProfessionList";

const svc = Service.lookup("OboProfessionalService", "obo");


const Initial = ({
  partner,
  onCancel,
  onVerified
}) => {

  const [mode, setMode] = useState("init");
  const [errors, setErrors] = useState({});
  const [error, setError] = useState();
  const [loading, setLoading] = useState(false);
  const [info, setInfo] = useState({});
  const [key, setKey] = useState();
  const [professionList, setProfessionList] = useState([]);

  const formRef = useRef();

  useEffect(() => {
    svc.invoke("getProfessionList", null, (err, list) => {
      setProfessionList(list);
    })
  }, []);

  useEffect(() => {
    if (Object.keys(errors).length > 0)
    validInfo();
  }, [info]);

  const verifyEmail = async () => {
    const emailSvc = Service.lookupAsync(`${partner.id}:VerifyEmailService`, "obo");
    return emailSvc.invoke("verifyEmail", { email: info.email, mobileno: info.mobileno });
  };

  const isValidInfo = () => {
    return formRef.current.reportValidity();
  }

  const onResendCode = (key) => {
    setKey(key);
  }

  const verifyInfo = () => {
    if (!isValidInfo()) return;

    setError(null);
    setLoading(true);
    svc.invoke("verifyInfo", info, (err, res) => {
      if (err) {
        setError(err);
      } else {
        verifyEmail()
          .then((data) => {
            setError(null);
            setKey(data.key);
            setMode("verify");
          })
          .catch((err) => {
            setError(err);
          });
        setLoading(false);
      }
    });
  }

  return (
    <React.Fragment>
      <FormPanel visibleWhen={mode === "init"} context={info} handler={setInfo}>
        <form ref={formRef}>
          <Subtitle>Please specify initial information</Subtitle>
          <Spacer />
          <Error msg={error} />
          <MaskedInput name="prc.idno" caption="PRC No." required />
          <ProfessionList caption="Profession (Copy profession in the PRC card" name="profession" expr={item => item} professions={professionList} required={true} />
          <Email name="email" required/>
          <Mobileno name="mobileno" required />
          <ActionBar>
            <BackLink caption="Cancel" action={onCancel} />
            <Button caption="Next" action={verifyInfo} loading={loading} disableWhen={loading} />
          </ActionBar>
        </form>
      </FormPanel>

      <Panel visibleWhen={mode === "verify"}>
        <Subtitle>Email Verification</Subtitle>
        <Spacer />
        <Error msg={error} />
        <p>Please enter the key code sent to your email at {info.email}.</p>
        <VerifyEmailCode
          partner={partner}
          hiddenCode={key}
          email={info.email}
          onCancel={() => setMode("init")}
          onVerified={() => onVerified(info)}
          onResendCode={onResendCode}
          width={200}
          connection="obo"
        />
      </Panel>
    </React.Fragment>
  );
}

export default Initial;
