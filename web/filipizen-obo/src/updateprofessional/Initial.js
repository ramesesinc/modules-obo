import React, { useState, useEffect, useRef } from "react";
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
  MaskedInput,
  useData
} from 'rsi-react-web-components';

import { ACTIONS } from "./UpdateProfessionalWebController";

import { VerifyEmailCode } from "rsi-react-filipizen-components";
import ProfessionList from "../components/ProfessionList";

const svc = Service.lookup("OboProfessionalService", "obo");

const Initial = ({
  partner,
  history,
  moveNextStep,
}) => {

  const [ctx, dispatch] = useData();
  const { professional } = ctx;

  const [mode, setMode] = useState("init");
  const [error, setError] = useState();
  const [loading, setLoading] = useState(false);
  const [info, setInfo] = useState({});
  const [professionList, setProfessionList] = useState([]);
  const [key, setKey] = useState();

  const formRef = useRef();

  const onResendCode = (key) => {
    setKey(key);
  }

  useEffect(() => {
    svc.invoke("getProfessionList", null, (err, list) => {
      setProfessionList(list);
    })
  }, []);

  const verifyEmail = async ({email, mobileno}) => {
    const emailSvc = Service.lookupAsync(`${partner.id}:VerifyEmailService`, "obo");
    return emailSvc.invoke("verifyEmail", { email, mobileno});
  };

  const verifyProfessional = () => {
    if (!formRef.current.reportValidity()) return;

    setError(null);
    setLoading(true);
    svc.invoke("verifyProfessional", info, (err, professional) => {
      if (err) {
        setError(err);
      } else {
        verifyEmail(professional)
          .then((data) => {
            setError(null);
            dispatch({type: ACTIONS.SET_PROFESSIONAL, professional })
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
      <form ref={formRef}>
        <FormPanel visibleWhen={mode === "init"} context={info} handler={setInfo}>
          <Subtitle>Please specify PRC Number</Subtitle>
          <Spacer />
          <Error msg={error} />
          <MaskedInput name="prc.idno" caption="PRC No." required  autoFocus/>
          <ProfessionList caption="Profession (Copy profession in the PRC card)" name="profession" expr={item => item} professions={professionList} required={true} />
          <ActionBar>
            <BackLink caption="Cancel" action={() => history.goBack()} />
            <Button caption="Next" action={verifyProfessional} loading={loading} disableWhen={loading} />
          </ActionBar>
        </FormPanel>
      </form>

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
          onVerified={moveNextStep}
          onResendCode={onResendCode}
          width={200}
          connection="obo"
        />
      </Panel>
    </React.Fragment>
  );
}

export default Initial;
