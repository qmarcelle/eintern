<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
			<!-- Latest compiled and minified JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>	
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<!-- Optional theme -->
<!-- <link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css"> -->



	
<title>Insert title here</title>
</head>
<body>

<h1>Add an expense below</h1>


<!-- 	ammount
     category
     date
     name
     text, password, datetime, datetime-local, date, month, time, week, number, email, url, search, tel, and color. -->

<%-- <form modelAttribute="expense" ="expense" action="managexpenses.do" method="post">
  <div class="form-group">
    <label for="exampleInputEmail1">Ammount</label>
    <input type="number" class="form-control"  path="ammount" id="exampleInputEmail1" placeholder="ammount">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">category</label>
    <input type="text" class="form-control" path="category" id="exampleInputPassword1" placeholder="category">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">date</label>
    <input type="date" class="form-control" path="date" id="exampleInputPassword1" placeholder="date">
  </div>
    <div class="form-group">
    <label for="exampleInputPassword1">name</label>
    <input type="text" class="form-control" path="description" id="exampleInputPassword1" placeholder="description">
  </div>
  <!-- <div class="form-group">
    <label for="exampleInputFile">File input</label>
    <input type="file" id="exampleInputFile">
    <p class="help-block">Example block-level help text here.</p>
  </div>
  <div class="checkbox">
    <label>
      <input type="checkbox"> Check me out
    </label>
  </div> -->
  <button type="submit" class="btn btn-default">add expense</button>
</form> --%>

   





<spring:form modelAttribute="expense" action="managexpenses.do" method="post">
<spring:errors path="*"/>
<spring:input path = "name" placeholder="name"/></br>
<spring:input path ="date" placeholder="MM-dd-yyyy" type="date"/></br>
<spring:input path = "category" placeholder = "category"/></br>
<spring:input path="ammount" placeholder="ammount" /></br>

<input type="submit" value="add expense">
<%-- <spring:button>add expense</spring:button> --%>

</spring:form>



<%-- <form:form commandName="expense">
<form:errors path="*"/>
<form action="/expense/expense.do" method="post" >
	<input type="text" name="ammount" placeholder="ammount"/><br/>
	<input type="text" name="category" placeholder="category"/><br/> 
	 <input type="text" name="date"placeholder="MM/dd/yyyy"><br />
	<input type="text" name="name" placeholder="name"/><br />
	
	<input type=submit value="save" name="submit_expense">
</form>
</form:form>

 --%>


</body>
</html>