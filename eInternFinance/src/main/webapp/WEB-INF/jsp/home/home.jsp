<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<%-- <html lang="en">
  
  <head>
    <meta charset="utf-8">
    <title>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- Le styles -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
  <!--   <style>
      body { padding-top: 60px; /* 60px to make the container go all the way
      to the bottom of the topbar */ }
    </style> -->
    <link href="assets/css/bootstrap-responsive.css" rel="stylesheet">
    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js">
      </script>
    <![endif]-->
    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">
    <style>
    </style>
  </head>
  <body>
    <div class="navbar navbar-fixed-top navbar-inverse">
      <div class="navbar-inner">
        <div class="container">
          <a class="brand" href="home.do">
            eIntern Finance
          </a>
          <ul class="nav">
          </ul>
        </div>
      </div>
    </div>
    <div class="container">
      <div class="hero-unit">
        <div>
          <h1>
           Welcome <sec:authentication property="name"/>  to eIntern Finance 2.0!
          </h1>
          <p>
            To get started, select expense or income
          </p>
        </div>
        <a class="btn btn-primary" href="income.do">
          Income »
        </a>
        
        <a class="btn btn-primary" href="expense.do">
          Expense »
        </a>
        <sec:authorize ifAnyGranted="ROLE_ADMIN">
       <!--  <a class="btn btn-primary" href="addexpenses.do"> method="get">
          Edit Expense »
        </a>
        -->
        
        </sec:authorize>
         <a class="btn btn-primary" href="j_spring_security_logout">
          Logout »
        </a>
      </div>
      <div>
      </div>
    </div>
    
 <script
		src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

	<!-- Latest compiled and minified JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

  </body>
</html> --%>
<html>
<head>
  <title>eFinance Dashboard</title>
  <!-- jquery -->
  <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
  
  <!-- //charts -->
	<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/1.0.2/Chart.min.js"></script>
  
  
  <link rel="stylesheet"
  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <link rel="stylesheet" type="text/css" href="assets/css/dashboard.css" />
</head>
<body class="application">

  <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
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
        <ul class="nav navbar-nav navbar-left">
          <li><a href="expense.do">Expenses</a></li>
          <li><a href="income.do">Income</a></li>
        </ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="j_spring_security_logout">logout</a></li>
					
				</ul>
			</div>
    </div>
  </div>

  <div class="container-fluid">
  <div class="row">

      <div class="col-sm-12">
        <div class="chart-wrapper">
         <!--  <div class="chart-title">
            
          </div> -->
          <div class="chart-stage">
            <h1>Financial Overview</h1>
          </div>
          <!-- <div class="chart-notes">
           
          </div> -->
        </div>
      </div>

    </div>
  
  
  
  
  
    <div class="row">

      <div class="col-sm-6">
        <div class="chart-wrapper">
          <div class="chart-title">
           <strong>Expenses</strong> 
          </div>
          <div class="canvas-container">
            <!-- <img data-src="holder.js/100%x350/white"> -->
            		
					
					<canvas id = "expenseChart" width="400" height="400" margin="auto" display="block" padding="0"><!-- > --></canvas>	
          </div>
            <div class="chart-legend expense">
        <ul>
            <li class="projects">Projects</li>
            <li class="travel">Travel</li>
            <li class="resources">Resources</li>
            <li class="utilities">Utilities</li>
            <li class="marketing">Marketing</li>
            <li class="other">Other</li>
        </ul>
    </div>
          <div class="chart-notes">
            <h4>Total Expenses: $${totalExpenses}</h4>
          </div>
        </div>
      </div>

      <div class="col-sm-6">
        <div class="chart-wrapper">
          <div class="chart-title">
            <strong>Income</strong>
          </div>
          <div class="canvas-container">
            
            <canvas id = "incomeChart" width="400" height="400"></canvas>
            
          </div>
           <div class="chart-legend income">
        <ul>
            <li class="consultations">Consultations</li>
            <li class="intensives">Intensives</li>
            <li class="media-sales">Media Sales</li>
            <li class="seminars">Seminars</li>
        </ul>
    </div>
          <div class="chart-notes">
            <h4>Total Income: $${totalIncome}</h4>
          </div>
        </div>
      </div>

    </div>


    

    <hr>

    <p class="small text-muted">Built by Qwynn Marcelle - member of the AutoMagix</p>
 					<!-- hidden income values -->
   					<input style="visibility: hidden" id="consult" value="${totalConsult}"/> 
					<input style="visibility: hidden" id="intensive" value="${totalIntensive}"/> 
					<input style="visibility: hidden" id="seminar" value="${totalSeminar}"/>
					<input style="visibility: hidden" id="media" value="${totalMedia}"/>
					<!-- hidden expense values -->
					<input style="visibility: hidden" id="projects" value="${totalProjects}"/>
					<input style="visibility: hidden" id="resources" value="${totalResources}"/>
					<input style="visibility: hidden" id="travel" value="${totalTravel}"/> 
					<input style="visibility: hidden" id="utilities" value="${totalUtilities}"/> 
					<input style="visibility: hidden" id="marketing" value="${totalMarketing}"/>
					<input style="visibility: hidden" id="other" value="${totalOther}"/>

  </div>

<!--   <script type="text/javascript" src="../../assets/lib/jquery/dist/jquery.min.js"></script>
  <script type="text/javascript" src="../../assets/lib/bootstrap/dist/js/bootstrap.min.js"></script>

  <script type="text/javascript" src="../../assets/lib/holderjs/holder.js"></script>
  <script>
    Holder.add_theme("white", { background:"#fff", foreground:"#a7a7a7", size:10 });
  </script>
 -->
<!--   <script type="text/javascript" src="../../assets/lib/keen-js/dist/keen.min.js"></script>
  <script type="text/javascript" src="../../assets/js/meta.js"></script> -->
  
  <script type="text/javascript"
		src="${pageContext.request.contextPath}/assets/js/dashboard.js"></script>

</body>
</html>




