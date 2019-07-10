This is EMAIL service from ${data.name}

Dear Applicant<br>

OBO Permits 

<table border="1">
	<tr>
		<th>Particulars</th>
		<th>Link</th>		
	</tr>
	<% data.findings.each { item-> %>
		<tr>
			<td>${item.particulars}</td>
			<td><a href="https://www.filipizen.com">Filipizen</a></td>		
		</tr>
	<%}%>
</table>
Findings:

Respectfully Yours:



