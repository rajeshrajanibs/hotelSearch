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
<div class="container">
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Hotel Search</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <!--<ul class="nav navbar-nav">
              <li class="active"><a href="#">Home</a></li>
              <li><a href="#about">About</a></li>
              <li><a href="#contact">Contact</a></li>
            </ul>-->
        </div><!--/.nav-collapse -->
    </nav>
</div>
<div class="container">
    <div class="containerBody">
        <div id="userForm">
            <form class="form-horizontal">
                <div class="form-group">
                    <label for="city" class="col-sm-4 control-label">City</label>
                    <div class="col-sm-2">
                        <input type="text" name="city" id="city" class="form-control" placeholder="City"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="checkin" class="col-sm-4 control-label">Check In</label>
                    <div class="col-sm-2">
                        <input type="text" name="checkin" id="checkin" class="form-control datepicker" placeholder="Check In"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="checkout" class="col-sm-4 control-label">Check Out</label>
                    <div class="col-sm-2">
                        <input type="text" name="checkout" id="checkout" class="form-control datepicker" placeholder="Check Out"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="guest" class="col-sm-4 control-label">Guests</label>
                    <div class="col-sm-2">
                        <select name="guest" id="guest" class="col-sm-2 form-control">
                            <c:forEach var="i" begin="1" end="4">
                                <option value="${i}" >${i}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-4 col-sm-2">
                        <button class="btn btn-primary btn-block submitButton" type="submit">Search</button>
                    </div>
                </div>
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