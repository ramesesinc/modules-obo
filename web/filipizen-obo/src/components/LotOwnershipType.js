import React from "react";
import { Subtitle2, Radio, Item  } from "rsi-react-web-components";

const LotOwnershipType = ({
  name,
  caption="Lot Ownership",
  showCaption=true,
  ...rest
}) => {
  return (
    <React.Fragment>
      {showCaption && <Subtitle2>{caption}</Subtitle2>}
      <Radio name={name} {...rest}>
        <Item caption="Lot Owned" value="1" />
        <Item caption="Leased" value="0" />
      </Radio>
    </React.Fragment>
  );
};

export default LotOwnershipType;
