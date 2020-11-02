import React from 'react'
import { useData } from 'rsi-react-web-components'
import { EPayment } from 'rsi-react-filipizen-components'
import OnlineBilling from './OnlineBilling';

const Payment = (props) => {
  const [ctx, dispatch] = useData()
  const module = {
    title: props.title,
    component: OnlineBilling
  }
  return (
    <EPayment
      module={module}
      {...props}
      initialContact={ctx.contact}
      initialStep={1}
      cancelPayment={props.cancelPayment}
    />
  )
}

export default Payment
