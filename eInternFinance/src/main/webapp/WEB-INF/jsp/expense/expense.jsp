<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="spring"
	uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <%@ taglib prefix="t" uri="tiles.apache.org/tags-tiles"%> --%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Expenses</title>


<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	
	<!-- //charts -->
	<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/1.0.2/Chart.min.js"></script>
	
	

<!-- Optional theme -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/incexp.css" />




<!-- Latest compiled and minified JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</head>
<body>

	<!-- NAV BAR -->
	<div>
		<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"	data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="home.do">
       <span> <img style="max-width:125px; margin-top: -7px;"
        src="assets/img/eintern-logo.png"></span>
        </a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				
				<li class="active"><a href="expense.do">Expenses</a> </li>
				<li><a href="income.do">Income</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
					<li><a href="j_spring_security_logout">logout</a></li>
					
				</ul>
		</div>
		
		</div>
	</div>
	<br />
	<br />

	<!-- END NAV BAR -->

	<div class="container">
		<div class="row">
			<div class="col-sm-12">
				<h1>My Expenses</h1>
				<table class="table table-hover">
					<thead>
						<tr>
							<th style="display: none;">Entry ID</th>
							<th>Description</th>
							<th>Date of Transaction</th>
							<th>Category</th>
							<th>Amount</th>
							<sec:authorize ifAnyGranted="ROLE_ADMIN">
								<th>Edit</th>
								<th>Remove</th>
							</sec:authorize>
						</tr>
					</thead>
					<c:forEach items="${expenses}" var="expense">
						<!-- Dynamically Generate class names -->
						<tr class="${expense.iD}">
							<td style="display: none;"><c:out value="${expense.iD}" /></td>
							<td><c:out value="${expense.name}" /></td>
							<td><fmt:formatDate value="${expense.date}"
									pattern="MM/dd/20yy" /></td>
							<td><c:out value="${expense.category}" /></td>
							<td><c:out value="${expense.ammount}" /></td>
							<%-- <td><fmt:setLocale value="en_US" />
								<fmt:parseNumber  value="$${expense.ammount}" type="currency"></fmt:parseNumber></td> --%>
							<sec:authorize ifAnyGranted="ROLE_ADMIN">

								<td><button class="btn btn-primary btn-xs"
										id="${expense.iD}" type="button" data-toggle="modal"
										data-target="#editExpenseModal">
										<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>
									</button></td>
								<td><a class="btn btn-danger btn-xs" id="${expense.iD}"
									type="button" data-toggle="modal"
									data-target="#deleteExpenseModal"><span
										class="glyphicon glyphicon-minus-sign" aria-hidden="true"></span>
								</a>
							</sec:authorize>
							</button>
							</td>
							<!-- real delete below -->
							<%-- <td><a href="deleteExpense.do?id=${expense.iD}" class="btn btn-danger btn-xs" id="${expense.iD}">
							<span class="glyphicon glyphicon-minus-sign" aria-hidden="true"></span>
						</a>
						</td> --%>
							<!--  -->
						</tr>

					</c:forEach>
				</table>

				<button type="button" data-toggle="modal" data-target="#addModal">Add
					Expense</button>
					
					
					<!-- <wicket:id="chart1"></wicket:id> -->
		
	
	
		
		
		
					
					
					
					
			</div>
		</div>
	</div>



	<!-- add modal -->
	<div class="modal fade" id="addModal" tabindex="-1" role="dialog"
		aria-labelledby="editModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel">Add Expense</h4>
				</div>
				<div class="modal-body">
					<spring:form modelAttribute="expense" action="managexpenses.do"
						method="post">
						<div class="form-group">
							<label for="recipient-name" class="control-label">Description:</label>
							<spring:input path="name" type="text" class="form-control"
								id="recipient-name" placeholder="description" />
						</div>
						<div class="form-group">
							<label for="message-text" class="control-label">Date of
								Transaction:</label>
							<spring:input path="date" class="form-control"
								placeholder="MM-dd-yyyy" type="date" />
						</div>
						<div class="form-group">
							<label for="message-text" class="control-label">Category</label>
							<spring:select path="category" class="form-control"
								placeholder="category">
								<option>Projects</option>
								<option>Resources</option>
								<option>Travel</option>
								<option>Utilities</option>
								<option>Marketing</option>
								<option>Other Activities</option>
							</spring:select>
						</div>
						<div class="form-group">
							<label for="message-text" class="control-label">Amount:</label>
							<spring:input path="ammount" class="form-control"
								placeholder="ammount" />
							</textarea>
						</div>
						<button type="submit" class="btn btn-success">Save</button>
						<button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
					</spring:form>
				</div>
				<div class="modal-footer"></div>
			</div>
		</div>
	</div>




	<!-- edit modal -->
	<div class="modal fade" id="editExpenseModal" tabindex="-1"
		role="dialog" aria-labelledby="editModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel">Edit Expense</h4>
				</div>
				<div class="edit-content" style="visibility: hidden">
					<%
						int id2 = 0;
					%>
					<c:forEach items="${expenses}" var="expense">

					</c:forEach>
					num to delete
				</div>

				<spring:form modelAttribute="expense" action="editexpenses.do"
					method="get">
					<div class="form-group">
						<!-- <label for="recipient-name" class="control-label">ID:</label> -->
						<spring:input style="display:none;" path="iD" type="text"
							class="form-control" id="edit-id" />
					</div>
					<div class="form-group">
						<label for="recipient-name" class="control-label">Description:</label>
						<spring:input path="name" type="text" class="form-control"
							id="recipient-name" placeholder="description" />
					</div>
					<div class="form-group">
						<label for="message-text" class="control-label">Date of
							Transaction:</label>
						<spring:input path="date" class="form-control"
							placeholder="MM-dd-yyyy" type="date" />
					</div>
					<div class="form-group">
							<label for="message-text" class="control-label">Category</label>
							<spring:select path="category" class="form-control"
								placeholder="category">
								<option>Projects</option>
								<option>Resources</option>
								<option>Travel</option>
								<option>Utilities</option>
								<option>Marketing</option>
								<option>Other Activities</option>
							</spring:select>
						</div>
					<div class="form-group">
						<label for="message-text" class="control-label">Amount:</label>
						<spring:input path="ammount" class="form-control"
							placeholder="ammount" />
					</div>
					<button type="submit" class="btn btn-success">Save</button>
					<button type="button" class="btn btn-danger" data-dismiss="modal">Cancel</button>
				</spring:form>

			</div>
			<div class="modal-footer"></div>
		</div>
	</div>
	</div>


	<!-- delete modal -->
	<div class="modal fade" id="deleteExpenseModal" tabindex="-1"
		role="dialog" aria-labelledby="editModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="exampleModalLabel">Confirmation</h4>
				</div>
				<div class="modal-body">
					<label>Are you sure you wan to delete this entry?</label>
					<div class="edit-content" style="visibility: hidden">
						<%
							int id = 0;
						%>
						<c:forEach items="${expenses}" var="expense">

						</c:forEach>
						num to delete
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-success" data-dismiss="modal">Cancel</button>
					<button type="button" class="btn btn-danger deleteBut">Delete</button>
				</div>
			</div>
		</div>
	</div>



	<script type="text/javascript"
		src="${pageContext.request.contextPath}/assets/js/scripts.js"></script>


</body>
</html>