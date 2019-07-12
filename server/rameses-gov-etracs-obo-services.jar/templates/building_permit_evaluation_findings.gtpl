<b>Building Permit Evaluation</b>
<br>
App No:    ${data.app.appno}<br>
Applicant: ${data.app.applicant.name}<br>
Project Title: ${data.app.title}<br>
<br>
<br>
We have evaulated your plans and we have some concerns regarding the 
following issues. 
<br>
<br>
<br>

<%data.findings.each { k,v-> %>
	<h2>${k.typeid.toUpperCase()}</h2>
	<table border="1">
		<tr>
			<th>Particulars</th>
			<th width="50">Checked By</th>		
		</tr>
		<%v.each { item-> %>
			<tr>
				<td>${item.particulars}</td>
				<td>${item.createdby.name}</td>
			</tr>
		<%}%>
	</table>

<%}%>

<br>
Please address these concerns and resubmit your 
application to this address : <a href="xxx">Specify address</a> or you can contact 
us at ... for clarification.
<br>
Respectfully Yours:<br>
<br>
Office of the Building Official<br>
Legazpi City, Albay


