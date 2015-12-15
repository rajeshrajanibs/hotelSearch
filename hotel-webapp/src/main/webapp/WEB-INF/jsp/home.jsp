<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content=""/>
    <meta name="author" content=""/>


    <title>Rail Application</title>

    <!-- Bootstrap core CSS -->
    <link href="https://code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css" rel="stylesheet" />
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
    <link href="css/bootstrap-datepicker.css" rel="stylesheet"/>
    <!-- Custom styles for this template -->
    <link href="css/application.css" rel="stylesheet"/>



    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]> -->
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

</head>
<body>
<div class="container">
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a id="hotelSearch" class="navbar-brand" href="/">Hotel Search</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <!--<ul class="nav navbar-nav">
              <li class="active"><a href="#">Home</a></li>
              <li><a href="#about">About</a></li>
              <li><a href="#contact">Contact</a></li>
            </ul>-->
        </div>
    </nav>
</div>
<section id="body">

</section>
</body>
</html>
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="js/jquery.min.js"></script>
<script src="js/jquery-ui.min.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/bootstrap-datepicker.js" type="text/javascript"></script>
<script src="js/handlebars.min.js" type="text/javascript"></script>
<script src="js/underscore.js" type="text/javascript"></script>
<script src="js/backbone-min.js" type="text/javascript"></script>
<script src="js/backbone.crossdomain.js" type="text/javascript"></script>


<%@include file="searchForm.jsp" %>
<%@include file="searchResult.jsp" %>


<script src="js/handlebar_helper.js" type="text/javascript"></script>
<script src="js/backboneApp.js" type="text/javascript"></script>
<script src="js/app.js" type="text/javascript"></script>
