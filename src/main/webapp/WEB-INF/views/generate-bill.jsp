<%@ include file="../common/header.jspf"%>

 <nav class="navbar navbar-default">
	<a href="/" class="navbar-brand">ELECTRICITY BILLING SYSTEM</a>
		<ul class="nav navbar-nav">
			<li><a href="/main-login.do">Home</a></li>
		</ul>
 </nav>

<div class="container">
	Generate Bill : 
	<form method="POST" action="/generate-bill.do">
		<fieldset class="form-group">
			<label>METER NO : </label> <input name="meter_no" type="text"
				class="form-control" /> <BR />
		</fieldset>
		<fieldset class="form-group">
			<label>Units Consumed : </label> <input name="units" type="text"
				class="form-control" /> <BR />
		</fieldset>

		<input name="add" type="submit" class="btn btn-success" value="Submit" />
	</form>
	<p>Total Amount : ${totalAmount}</p>
</div>

<%@ include file="../common/footer.jspf"%>