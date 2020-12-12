import React, { useState, useEffect } from 'react'
import {
  Card,
  Panel,
  Button,
  Label,
  ActionBar,
  Spacer,
  Text,
  Error,
  Subtitle,
  Title,
  BackLink,
  useData,
  Table,
  TableColumn,
  currencyFormat
} from 'rsi-react-web-components'

const ORIGIN = 'filipizen'

const OnlineBilling = ({
  title,
  partner,
  onCancel,
  onSubmit,
  error: paymentError
}) => {
  const [ctx, dispatch] = useData();
  const { refno, apptype, txntype, contact, bill: initialBill } = ctx;

  const [bill, setBill] = useState(initialBill);
  const [error, setError] = useState(paymentError);
  const [loading, setLoading] = useState(false)

  const checkoutPayment = () => {
    onSubmit({
      refno,
      txntype,
      origin: ORIGIN,
      orgcode: partner.id,
      info: { data: bill },
      paidby: bill.paidby,
      paidbyaddress: bill.paidbyaddress,
      amount: bill.amount,
      particulars: `Obo Application No. ${bill.appno}`,
    })
  }

  const onCancelBilling = () => {
    onCancel(0);
  }

  return (
    <Card style={{maxWidth: 800}}>
      <Title>{title}</Title>
      <Subtitle>Billing Information</Subtitle>
      <Spacer />
      <Error msg={error} />
      <Panel>
        <Panel row>
          <Text context={bill} caption="Tracking No." expr="trackingno" readOnly={true} />
          <Text context={bill} caption="Application No." expr="appno" readOnly={true} />
        </Panel>
        <Panel row>
          <Text context={bill} caption="Permit Type" expr="permittype" readOnly={true} />
          <Text context={bill} caption="Application Type" expr="apptype" readOnly={true} />
        </Panel>
        <Text context={bill} caption="Project Name" expr="title" readOnly={true} />
        <Text context={bill} caption="Applicant" expr="applicant.name" readOnly={true} />
        <Text context={bill} caption="Address" expr="applicant.address.text" readOnly={true} />
        <h4>Bill Details</h4>
        <Table items={bill ? bill.items : []} size="small" showPagination={false} >
          <TableColumn caption="Particulars" expr="item.title" width={500}/>
          <TableColumn caption="Amount" expr="amount" align="right" format="currency" />
        </Table>
        <Panel style={{display: "flex", flexDirection: "row", justifyContent: "flex-end", paddingRight: 15}}>
          <Label context={bill} caption="Bill Amount:" expr={item => currencyFormat(item.amount)} />
        </Panel>
      </Panel>
      <ActionBar disabled={loading}>
        <BackLink caption='Back' action={onCancelBilling} />
        <Button caption='Confirm Payment' action={checkoutPayment} disableWhen={bill.amount === 0} />
      </ActionBar>
    </Card>
  )
}

export default OnlineBilling
