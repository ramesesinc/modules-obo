import React, { useState } from "react";
import {
  Subtitle,
  Error,
  FormPanel,
  Spacer,
  ActionBar,
  Button,
  BackLink,
  Panel,
  Service,
  MaskedInput
} from 'rsi-react-web-components';

import { VerifyEmailCode } from "rsi-react-filipizen-components";

const svc = Service.lookup("OboProfessionalService", "obo");


const Initial = ({
  partner,
  onCancel,
  onVerified
}) => {

  const [mode, setMode] = useState("init");
  const [error, setError] = useState();
  const [loading, setLoading] = useState(false);
  const [info, setInfo] = useState({});
  const [professional, setProfessional] = useState({});
  const [key, setKey] = useState();

  // const verifyEmail = async () => {
  //   const emailSvc = Service.lookupAsync(`${partner.id}:VerifyEmailService`, "obo");
  //   return emailSvc.invoke("verifyEmail", { email: info.email, mobileno: info.mobileno });
  // };

  const onResendCode = (key) => {
    setKey(key);
  }

  const verifyEmail = async ({email, mobileno}) => {
    const emailSvc = Service.lookupAsync(`${partner.id}:VerifyEmailService`, "obo");
    return emailSvc.invoke("verifyEmail", { email, mobileno});
  };

  const verifyProfessional = () => {
    setError(null);
    setLoading(true);
    svc.invoke("verifyProfessional", info, (err, professional) => {
      if (err) {
        setError(err);
      } else {
        verifyEmail(professional)
          .then((data) => {
            setError(null);
            setProfessional(professional);
            setKey(data.key);
            setMode("verifyemail")
          })
          .catch((err) => {
            setError(err);
          });
      }
      setLoading(false);
    });
  }

  return (
    <React.Fragment>
      <FormPanel visibleWhen={mode === "init"} context={info} handler={setInfo}>
        <Subtitle>Please specify PRC Number</Subtitle>
        <Spacer />
        <Error msg={error} />
        <MaskedInput name="prc.idno" caption="PRC No." required  autoFocus/>
        <ActionBar>
          <BackLink caption="Cancel" action={onCancel} />
          <Button caption="Next" action={verifyProfessional} loading={loading} disableWhen={loading} />
        </ActionBar>
      </FormPanel>

      <Panel visibleWhen={mode === "verifyemail"}>
        <Subtitle>Email Verification</Subtitle>
        <Spacer />
        <Error msg={error} />
        <p>Please enter the key code sent to your email at {professional ? professional.email : ""}.</p>
        <VerifyEmailCode
          partner={partner}
          hiddenCode={key}
          email={professional.email}
          onCancel={() => setMode("init")}
          onVerified={() => onVerified(professional)}
          onResendCode={onResendCode}
          width={200}
          connection="obo"
        />
      </Panel>
    </React.Fragment>
  );
}

export default Initial;
