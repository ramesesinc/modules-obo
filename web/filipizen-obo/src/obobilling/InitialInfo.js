import React, { useState } from 'react'
import {
  FormPanel,
  Panel,
  Text,
  Title,
  Button,
  ActionBar,
  Subtitle,
  Spacer,
  Service,
  Error,
  BackLink,
  useData,
  Card,
  Radio,
  Item
} from 'rsi-react-web-components'


const appTypes = ["building", "occupancy"];

const InitialInfo = ({
  title,
  partner,
  moveNextStep,
  movePrevStep,
}) => {

  const [ctx, dispatch] = useData();
  const { txntype } = ctx;

  const [error, setError] = useState();
  const [errorText, setErrorText] =  useState({});
  const [loading, setLoading] = useState(false);
  const [params, setParams] = useState({apptype: "building"});

  const getBilling = async () => {
    const svc = await Service.lookupAsync(`${partner.id}:OboOnlineBillingService`, "obo");
    return await svc.invoke("getBilling", {txntype, ...params, qtr: 4, showdetails:true})
  }

  const loadBill = () => {
    setErrorText({});
    if (!params.refno) {
      setErrorText({refno: "Application No. is required."})
      return;
    }
    setLoading(true);
    setError(null);
    getBilling().then(bill => {
      dispatch({type: "SET_BILL", ...params, bill: bill});
      moveNextStep();
    }).catch(err => {
      setError(err.toString());
      setLoading(false)
    })
  }

  return (
    <Card>
      <Title>{title}</Title>
      <Subtitle>Initial Information</Subtitle>
      <Spacer />
      <Error msg={error} />
      <FormPanel context={params} handler={setParams}>
        <Text
          name="refno"
          caption="Application No."
          autoFocus={true}
          error={errorText.refno}
          helperText={errorText.refno}
        />
        <Spacer />
        <Panel>
          <label>Application Type:</label>
          <Panel style={{marginLeft: 20}}>
            <Radio name="apptype">
              <Item caption="Building Permit" value="building" />
              <Item caption="Occupancy Permit" value="occupancy" />
            </Radio>
          </Panel>
        </Panel>
      </FormPanel>
      <ActionBar>
        <BackLink caption='Back' variant="text" action={movePrevStep} />
        <Button caption='Next' action={loadBill} loading={loading} disabled={loading} />
      </ActionBar>
    </Card>
  )
}

export default InitialInfo
