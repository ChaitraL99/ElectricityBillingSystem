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
	NEW METER
	<form method="POST" action="/add-meter.do">
		<fieldset class="form-group">
			<label>METER NO : </label> <input name="meter_no" type="text"
				class="form-control" /> <BR />
		</fieldset>

		<fieldset class="form-group">
			<label>Select Customer ID : </label> 
			<select class="form-control" name="cust_id">
			<c:forEach items = "${customerIds}" var="customer">
				<option value="${customer}">${customer}</option>
			</c:forEach>
			</select>
			 <BR />
		</fieldset>
		<input name="add" type="submit" class="btn btn-success" value="Submit" />
	</form>
</div>

<%@ include file="../common/footer.jspf"%>