import React from "react";
import {
  Panel,
  PreviewReport,
  DownloadReport
} from "rsi-react-web-components";

export const getHeaderInfo = (contact={}, forms="") => {
  let headerInfo = "";
  headerInfo += "Please download and print the " + forms + " forms, prepare the ";
  headerInfo += "requirements listed below, and submit at the receiving window of our ";
  headerInfo += contact.officename;
  headerInfo += " at the ";
  headerInfo += contact.address1;
  if (contact.address2) {
    headerInfo += ", " + contact.address2 + ". ";
  } else {
    headerInfo += ". ";
  }
  const phones = [];
  if (contact.phoneno) phones.push(contact.phoneno)
  if (contact.mobileno) phones.push(contact.mobileno)

  if (contact.email) {
    if (phones.length > 0) {
      headerInfo += "You can email at " + contact.email;
      headerInfo += " or contact us on " + phones.join(" or ");
    } else {
      headerInfo += "You can email us at " + contact.email;
    }
    headerInfo += " for any inquiries on application."
  } else if (phones.length > 0)  {
    headerInfo += "You can contact us on " + phones.join(" or ") + " for any inquiries on application."
  }
  return headerInfo;
}

