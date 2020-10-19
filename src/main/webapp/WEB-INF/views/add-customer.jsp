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
	Your New Action Item:
	<form method="POST" action="/add-customer.do">
		<fieldset class="form-group">
			<label>Name : </label> <input name="name" type="text"
				class="form-control" /> <BR />
		</fieldset>
		<fieldset class="form-group">
			<label>Password : </label> <input name="password" type="text"
				class="form-control" /> <BR />
		</fieldset>
		<fieldset class="form-group">
			<label>State : </label> <select class="form-control" name="state">
			<c:forEach items = "${states}" var="state">
				<option value="${state}">${state}</option>
			</c:forEach>
			</select> <BR />
		</fieldset>
		<input name="add" type="submit" class="btn btn-success" value="Submit" />
	</form>
</div>

<%@ include file="../common/footer.jspf"%>