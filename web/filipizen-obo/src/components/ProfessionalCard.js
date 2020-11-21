import React from "react";
import {
  Panel,
  Label,
  Image,
} from "rsi-react-web-components";

import ProfessionalLookup from "./ProfessionalLookup";

const ProfessionalCard = ({ professional = {prc:{}, ptr:{}}, caption, onSelectProfessional, photoUrl }) => {
  let name = "";
  if (professional.lastname) {
    name = `${professional.lastname}, ${professional.firstname} ${professional.middlename}`
  };
  let address = "";
  if (professional.address) {
    address = professional.address.text;
  }

  let containerStyle = styles.container;
  let lookupContainerStyle = styles.lookupContainer;
  let captionStyle = styles.caption;

  if (typeof(professional.lastname) === "string") {
    containerStyle = {...containerStyle, backgroundColor:"#d1d7f8"};
    lookupContainerStyle = {...lookupContainerStyle, backgroundColor: "#454f88"};
    captionStyle = {...captionStyle, color: "white"};
  }

  return (
    <div style={containerStyle}>
      <Panel style={lookupContainerStyle}>
        <Label captionStyle={captionStyle} caption={caption} />
        <ProfessionalLookup hideSearchText={true}
          onSelect={onSelectProfessional}
          fullWidth={false}
        />
      </Panel>
      <div style={{marginTop: 10, marginBottom: 10, padding: 10}}>
        <div style={styles.nameContainer}>
          <Panel center>
            <Label labelStyle={styles.name}>{name}</Label>
            <Label labelStyle={styles.profession}>{professional.profession}</Label>
          </Panel>
          <Image src={photoUrl}/>
        </div>
        <Panel style={styles.row}>
          <Panel>
            <Label style={styles.label} captionStyle={{width: 120}} caption="PRC ID No.">{professional.prc.idno}</Label>
            <Label style={styles.label} captionStyle={{width: 120}} caption="Date Issued">{professional.prc.dtissued}</Label>
            <Label style={styles.label} captionStyle={{width: 120}} caption="Valid Until">{professional.prc.dtvalid}</Label>
            <Label style={styles.label} captionStyle={{width: 120}} caption="Place Issued">{professional.prc.placeissued}</Label>
          </Panel>
          <Panel>
            <Label style={styles.label} captionStyle={{width: 120}} caption="PTR ID No.">{professional.ptr.refno}</Label>
            <Label style={styles.label} captionStyle={{width: 120}} caption="Date Issued">{professional.ptr.dtissued}</Label>
            <Label style={styles.label} captionStyle={{width: 120}} caption="Place Issued">{professional.ptr.placeissued}</Label>
          </Panel>
        </Panel>
      </div>
    </div>
  );
};

const styles = {
  container: {
    borderWidth: 1,
    borderColor: "#aaa",
    boxShadow: "0px 5px 7px -7px rgba(0,0,0,0.75)",
    backgroundColor: "#d1d1d1",
    borderRadius: 5,
  },
  caption: {
    fontSize: 18,
    width: "100%"
  },
  lookupContainer: {
    display: "flex",
    justifyContent: "space-between",
    alignItems: "center",
    backgroundColor: "#8b8b8b",
    paddingTop: 5,
    paddingLeft: 10,
    paddingRight: 10,
    borderRadius: 5,
    minWidth: 400
  },
  nameContainer: {
    dipslay: "flex",
    justifyContent: "space-between",
    marginBottom: 5,
  },
  name: {
    fontSize: 18,
    fontWeight: 800,
  },
  profession: {
    fontSize: 14,
    fontWeight: 600,
    backgroundColor: "#ddddd",
    width: "100%",
  },
  row: {
    display: "flex",
    flexDirection: "row",
    justifyContent: "space-between",
  },
  label: {
    paddingBottom: 2,
  }
}

export default ProfessionalCard;
