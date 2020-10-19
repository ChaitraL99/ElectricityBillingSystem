<%@ include file="../common/header.jspf"%>
<%@ page import="java.util.*, java.io.*" %>

 <nav class="navbar navbar-default">
	<a href="/" class="navbar-brand">ELECTRICITY BILLING SYSTEM</a>
		<ul class="nav navbar-nav">
			<li><a href="/main-login.do">Home</a></li>
		</ul>
 </nav>
 
<center>
<div class="container">
    	<div class="row">
    		<div class="span4">
    			<p>
			        <strong>Electricity Bill</strong><br>
		    	</p>
    		</div>
    		<div class="span4 well">
    			<table class="invoice-head">
    				<tbody>
    					<c:forEach items="${invoice}" var="bill">
    					<tr>
    						<td class="pull-right"><strong>Customer : </strong></td>
    						<td>${bill.custId}</td>
    					</tr>
    					<tr>
    						<td class="pull-right"><strong>Date : </strong></td>
    						<td><%
    						Date date = new Date();
    						out.print(date.toString());
    						%>
    						</td>
    					</tr>
    					</c:forEach>
    				</tbody>
    			</table>
    		</div>
    	</div>
    	<div class="row">
    		<div class="span8">
    			<h2>Invoice</h2>
    		</div>
    	</div>
    	<div class="row">
		  	<div class="span8 well invoice-body">
		  		<table class="table table-bordered">
					<thead>
						<tr>
                          <th>Customer</th>
							<th>Meter No</th>
							<th>State</th>
                          	<th>Units</th>
							<th>Price</th>
						</tr>
					</thead>
					<tbody>
					<tr>
					<c:forEach items="${invoice}" var="bill">
						<td>${bill.name}</td>
						<td>${bill.meterNo}</td>
						<td>${bill.state}</td>
                      	<td>${bill.units}</td>
                      	<td>${bill.price}</td>
                     </c:forEach>
					</tr>
            		<tr>
            		<td colspan="4">
            		</td>
            		</tr>
						<tr>
						<c:forEach items="${invoice}" var="bill">
							<td colspan="2">&nbsp;</td>
							<td><strong>Total</strong></td>
							<td><strong>${bill.totalAmount}</strong></td>
						</c:forEach>
						</tr>
					</tbody>
				</table>
		  	</div>
  		</div>
  		
  		<div class="row">
  			<div class="span8 well invoice-thank">
  				<h5 style="text-align:center;">Thank You!</h5>
  			</div>
  		</div>

    </div>
    </center>
    </body>
    </html>
