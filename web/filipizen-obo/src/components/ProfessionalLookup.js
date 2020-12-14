import React, { useState } from 'react'
import {
  Lookup,
  Panel,
  FormPanel,
  Text,
  Button,
  Table,
  TableColumn,
  Service,
  MsgBox
} from 'rsi-react-web-components'

const svc = Service.lookup("OboProfessionalService", "obo");

const ROWS_PER_PAGE = 5;

const ProfessionalLookup = ({
  caption="Search Professional",
  searchFieldTitle="PRC No.",
  onSelect,
  hideSearchText=false,
  fullWidth=true,
  role
}) => {
  const [query, setQuery] = useState({prc:{}});
  const [selectedItems, setSelectedItems] = useState();
  const [professionals, setProfessionals] = useState();
  const [showError, setShowError] = useState(false);
  const [errorMsg, setErrorMsg] = useState();

  const onSelectItems = (items) => {
    setSelectedItems(items);
  }

  const validProfession = (professional) => {
    if (!role) return true;

    const validRole = role.toLowerCase();
    let valid = validRole.indexOf(professional.profession.toLowerCase()) >= 0;

    let requiredRoles = ""
    if (!valid) {
      const roles = validRole.split(",");
      if(roles.length == 1) {
        requiredRoles = "Only " + roles[0].toLowerCase() + " is allowed."
      } else {
        requiredRoles = "Only " + roles.join(", ") + " are allowed."
        const lastCommaIdx = requiredRoles.lastIndexOf(",");
        requiredRoles = requiredRoles.substring(0, lastCommaIdx) + " and " + requiredRoles.substring(lastCommaIdx+2);
      }

      let msg = "The profession of the selected professional is invalid. " + requiredRoles;
      setErrorMsg(msg);
      console.log("ERROR", msg);
      return false;
    }
    return true;
  }

  const onAcceptLookup = () => {
    const profession = selectedItems[0];
    if (validProfession(profession)) {
      onSelect(profession);
      return true;
    } else {
      setShowError(true);
      return false;
    }
  }

  const fetchList = (params) => {
      if (svc && query.prc.idno ) {
        const p = {...query, ...params};
        svc.invoke("getList", p, (err, list) => {
          if (err) {
            console.log("ERROR", err)
          } else {
            setProfessionals(list);
          }
        });
      }
  }

  const search = () => {
    fetchList({limit: ROWS_PER_PAGE, start: 0});
  }

  return (
    <React.Fragment>
      <MsgBox title="Invalid Profession" open={showError} msg={errorMsg} onAccept={() => setShowError(false)} />
      <Lookup caption={caption}
        query={query}
        setQuery={setQuery}
        searchFieldTitle={searchFieldTitle}
        searchField="prc.idno"
        onSelect={onAcceptLookup}
        fetchList={fetchList}
        hideSearchText={hideSearchText}
        enableSelect={selectedItems && selectedItems.length > 0}
        fullWidth={fullWidth}
        rootStyle={{minWidth: 400}}
      >
        <FormPanel context={query} handler={setQuery}>
          <Panel row>
            <Text caption='PRC No.' name='prc.idno' width={200} variant='outlined' />
            <Button caption='Search' action={search} />
          </Panel>
        </FormPanel>
        <Table
          items={professionals}
          fetchList={fetchList}
          rowsPerPage={ROWS_PER_PAGE}
          showPagination={false}
          singleSelect={true}
          keyId="objid"
          onSelectItems={onSelectItems}
        >
          <TableColumn caption='PRC' expr='prc.idno' />
          <TableColumn caption='Name' expr={item => `${item.lastname}, ${item.firstname} ${item.middlename}`} />
          <TableColumn caption='Profession' expr='profession' />
        </Table>
      </Lookup>
    </React.Fragment>
  )
}

export default ProfessionalLookup
