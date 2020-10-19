<%@ include file="../common/header.jspf"%>

 <nav class="navbar navbar-default">
	<a href="/" class="navbar-brand">ELECTRICITY BILLING SYSTEM</a>
		<ul class="nav navbar-nav">
			<li><a href="/main-login.do">Home</a></li>
			<li><a href="/list-customers.do">Customers</a></li>
			<li class="active"><a href="/list-meters.do">Meters</a></li>
		</ul>
 </nav>

<div class="container">
	<H1>Welcome ${name}</H1>


	<table class="table table-striped">
		<caption>Meters</caption>
		<thead>
			<th>Meter Number</th>
			<th>Customer ID</th>
		</thead>
		<tbody>
			<c:forEach items="${meters}" var="meter">
				<tr>
					<td>${meter.meterNo}</td>
					<td>${meter.custId}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<p>
		<font color="red">${errorMessage}</font>
	</p>
	<a class="btn btn-success" href="/add-meter.do">Add New Meter</a>
</div>

<%@ include file="../common/footer.jspf"%>