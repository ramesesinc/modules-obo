import React, { useState } from "react";
import {
  Subtitle,
  Error,
  FormPanel,
  Spacer,
  ActionBar,
  Button,
  Panel,
  Radio,
  Item,
  Text,
  useData
} from 'rsi-react-web-components';

import { ACTIONS } from "./UpdateProfessionalWebController";

const ChangeType = ({
  moveNextStep,
}) => {

  const [ctx, dispatch] = useData();
  const { professional } = ctx;
  const [info, setInfo] = useState({ changeType: "CHANGE_PERSONINFO"});

  const submitChangeType = () => {
    dispatch({ type: ACTIONS.SET_CHANGE_TYPE, changeType: info.changeType });
    moveNextStep();
  }

  return (
    <Panel>
      <Subtitle>Edit Professional Information </Subtitle>
      <Spacer />
      <Text caption="Profession" value={professional.profession} readOnly={true} />
      <Text caption="Name" value={professional.name} readOnly={true} />

      <FormPanel context={info} handler={setInfo}>
        <Spacer />
        <h4>Please select type of change to make</h4>
        <Radio name="changeType">
          <Item caption="Change Personal Info" value="CHANGE_PERSONINFO" />
          <Item caption="Change Address" value="CHANGE_ADDRESS" />
          <Item caption="Change Primary ID" value="CHANGE_ID" />
          <Item caption="Change PTR" value="CHANGE_PTR" />
          <Item caption="Change PRC" value="CHANGE_PRC" />
          <Item caption="Change Email/Mobile No." value="CHANGE_CONTACT" />
        </Radio>
        <ActionBar>
          <Button caption="Next" action={submitChangeType} />
        </ActionBar>
      </FormPanel>
    </Panel>
  )
}

export default ChangeType;
