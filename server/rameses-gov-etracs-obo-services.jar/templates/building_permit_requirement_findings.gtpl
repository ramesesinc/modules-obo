<b>Building Permit Requirements</b>
<br>
Tracking No:    ${data.app.trackingno}<br>
Applicant: ${data.app.applicant.name}<br>
Project Title: ${data.app.title}<br>
<br>
<br>
We have evaulated your plans and we have some concerns regarding the 
following requirements. 
<br>
<br>
<br>
<%data.findings.each { k,v-> %>
	<h2>${k.type.title.toUpperCase()}</h2>
	<table border="1">
		<tr>
			<th>Requirement</th>
			<th>Particulars</th>
			<th width="50">Checked By</th>		
		</tr>
		<%v.each { item-> %>
			<tr>
				<td>${item.parent.type.title} ${item.type.title}</td>
				<td>${item.remarks}</td>
				<td>${item.modifiedby.name}</td>
			</tr>
		<%}%>
	</table>
<%}%>

<br>
Please address these concerns and resubmit your 
requirements to this address : <a href="xxx">Specify address</a> or you can contact 
us at ... for clarification.
<br>
Respectfully Yours:<br>
<br>
Office of the Building Official<br>
Legazpi City, Albay


