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
    <link href="css/bootstrap.min.css" rel="stylesheet"/>
    <link href="https://code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css" rel="stylesheet" />
    <!-- Custom styles for this template -->
    <link href="css/application.css" rel="stylesheet"/>



    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Rail Application</a>
            </div>
            <div id="navbar" class="collapse navbar-collapse">
                <!--<ul class="nav navbar-nav">
                  <li class="active"><a href="#">Home</a></li>
                  <li><a href="#about">About</a></li>
                  <li><a href="#contact">Contact</a></li>
                </ul>-->
            </div><!--/.nav-collapse -->
        </div>
    </nav>

    <div class="container">
        <div class="containerBody">
            <div id="userForm">
                <form name="createUserForm" class="form-signin">
                    <div class="formElements">
                        <span><input type="text" name="originStation" id="originStation" class="form-control" placeholder="Origin Station"/></span>
                        <span><input type="text" name="destinationStation" id="destinationStation" class="form-control" placeholder="Destination Station"/></span>
                        <span><input type="text" name="leaveDate" id="leaveDate" class="form-control datepicker" placeholder="Leave Date"/></span>
                        <span><input type="text" name="returnDate" id="returnDate" class="form-control datepicker" placeholder="Return Date"/></span>
                        <span><input type="text" name="totalCost" id="totalCost" class="form-control" placeholder="Total Cost"/></span>
                        <span><input type="text" name="trainNumber" id="trainNumber" class="form-control" placeholder="Train Number"/></span>
                    </div>
                    <div class="submitButton"><button class="btn btn-primary btn-block submitButton" type="submit">Search</button></div>
                </form>
            </div>
            <div id="content"></div>
        </div>
    </div><!-- /.container -->
</body>
</html>
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.0.4/handlebars.min.js" type="text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/underscore.js/1.8.3/underscore.js" type="text/javascript"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/backbone.js/1.2.3/backbone-min.js" type="text/javascript"></script>
<script type="text/template" id="backTemplate">
    <table class="table table-striped">
        <tr>
            <th>Id</th>
            <th>Train Number</th>
            <th>Origin Station</th>
            <th>Destination Station</th>
            <th>Total Cost</th>
        </tr>
        {{#each solutions}}
        <tr>
            <td>{{plusOne @index}}</td>
            <td>{{this.trainNumber}}</td>
            <td>{{this.originStation}}</td>
            <td>{{this.destinationStation}}</td>
            <td>{{this.totalCost}}</td>
        </tr>
        {{/each}}
    </table>
</script>
<script src="js/handlebar_helper.js" type="text/javascript"></script>
<script src="js/backboneApp.js" type="text/javascript"></script>
<script src="js/app.js" type="text/javascript"></script>