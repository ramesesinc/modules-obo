import React, { useState } from 'react'
import {
  Lookup,
  Panel,
  FormPanel,
  Text,
  Button,
  Table,
  TableColumn,
  Service
} from 'rsi-react-web-components'

const svc = Service.lookup("OboProfessionalService", "obo");

const ROWS_PER_PAGE = 5;

const ProfessionalLookup = ({
  caption="Search Professional",
  searchFieldTitle="PRC No.",
  onSelect,
  hideSearchText=false,
  fullWidth=true
}) => {
  const [showLookup, setShowLookup] = useState(false)
  const [query, setQuery] = useState({prc:{}});
  const [selectedItems, setSelectedItems] = useState();
  const [professionals, setProfessionals] = useState()

  const onSelectItems = (items) => {
    setSelectedItems(items);
  }

  const onAcceptLookup = () => {
    onSelect(selectedItems);
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
  )
}

export default ProfessionalLookup
