<%@ include file="../common/header.jspf"%>

 <nav class="navbar navbar-default">
	<a href="/" class="navbar-brand">ELECTRICITY BILLING SYSTEM</a>
		<ul class="nav navbar-nav">
			<li><a href="/main-login.do">Home</a></li>
			<li class="active"><a href="/list-customers.do">Customers</a></li>
			<li><a href="/list-meters.do">Meters</a></li>
		</ul>
 </nav>

<div class="container">
	<H1>Welcome ${name}</H1>


	<table class="table table-striped">
		<caption>The Customers</caption>
		<thead>
			<th>Name</th>
			<th>State</th>
			<th>Meter Number</th>
			
		</thead>
		<tbody>
			<c:forEach items="${customers}" var="customer">
				<tr>
					<td>${customer.name}</td>
					<td>${customer.state}</td>
					<td>${customer.meterNo}</td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<p>
		<font color="red">${errorMessage}</font>
	</p>
	<a class="btn btn-success" href="/add-customer.do">Add New Customer</a>
</div>

<%@ include file="../common/footer.jspf"%>