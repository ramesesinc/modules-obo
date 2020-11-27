import React, { useState, useEffect } from "react";
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
  Service
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

  const validInfo = () => {
    const errors = {}
    if (!info.prc || !info.prc.idno) errors.idno = "PRC No. is required";
    if (!info.profession) errors.profession = "Profession is required";
    if (!info.email) errors.email = "Email is required";

    if (Object.keys(errors).length == 0) {
      setErrors({});
      return true;
    } else {
      setErrors(errors);
      return false;
    }
  }

  const onResendCode = (key) => {
    setKey(key);
  }

  const verifyInfo = () => {
    if (!validInfo()) return;

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
        <Subtitle>Please specify initial information</Subtitle>
        <Spacer />
        <Error msg={error} />
        <Text name="prc.idno" caption="PRC No." required error={errors.idno} helperText={errors.idno} />
        <ProfessionList caption="Profession (Copy profession in the PRC card" name="profession" expr={item => item} professions={professionList} required={true} error={errors.profession} helperText={errors.profession} />
        <Email name="email" required error={errors.email} helperText={errors.email} />
        <Mobileno name="mobileno" />
        <ActionBar>
          <BackLink action={onCancel} />
          <Button caption="Next" action={verifyInfo} />
        </ActionBar>
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
