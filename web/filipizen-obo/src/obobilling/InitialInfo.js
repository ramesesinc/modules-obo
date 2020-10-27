import React, { useState } from 'react'
import {
  FormPanel,
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
  Combobox
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
  const [loading, setLoading] = useState(false);
  const [params, setParams] = useState({apptype: "building"});

  const getBilling = async () => {
    const svc = await Service.lookupAsync(`${partner.id}:OboOnlineBillingService`);
    return await svc.getBilling({txntype, ...params, qtr: 4, showdetails:true})
  }

  const loadBill = () => {
    setLoading(true);
    setError(null);
    getBilling().then(bill => {
      console.log("BILL", bill);
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
        <Text name="refno" caption="Application No." autoFocus={true} />
        <Combobox caption="Application Type" name="apptype" items={appTypes} />
      </FormPanel>
      <ActionBar>
        <BackLink caption='Back' variant="text" action={movePrevStep} />
        <Button caption='Next' action={loadBill} loading={loading} disabled={loading} />
      </ActionBar>
    </Card>
  )
}

export default InitialInfo
