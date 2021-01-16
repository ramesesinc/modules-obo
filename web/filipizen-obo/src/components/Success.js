import React from 'react'
import {
  Panel,
  Spacer,
  Button,
  Content,
  Label,
  Title,
  CardActions,
  Image
} from 'rsi-react-web-components'

const Success = ({
  onClose,
  msg="You have successfully registered your professional information."
}) => {
  return (
    <Panel>
      <Content center>
        <Spacer />
        <Image src="/assets/success.png" width={120} alt='success' />
        <Spacer />
        <Title>Success!</Title>
        <Spacer />
        <Label style={{ ...styles.text, ...{ maxWidth: 300 } }}>{msg}</Label>
        <Label labelStyle={styles.text}>
          Thank you for using this service.
        </Label>
        <Spacer />
        <CardActions>
          <Button
            variant='text'
            caption='Return'
            onClick={onClose}
          />
        </CardActions>
      </Content>
    </Panel>
  )
}

const styles = {
  text: {
    display: "block",
    textAlign: "center"
  }
};

export default Success
