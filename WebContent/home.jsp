<!DOCTYPE HTML>
<html lang="en">
<!-- Make sure the <html> tag is set to the .full CSS class. Change the background image in the full.css file. -->

<head>


<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Weight Tracker</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- <link
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css"
	rel="stylesheet" /> -->

<!-- Custom CSS -->
<link href="css/the-big-picture.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body class="full">

	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-bottom"
		role="navigation">
		<div class="container">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"></a>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="home.jsp">HOME</a></li>
					<li><a href="readData.jsp">METRICS</a></li>
					

				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>

	<!-- Page Content -->
	<div class="container">
		<div class="row">
			<div class="col-md-6 col-sm-12">
				<h1>Personal Weight Tracker</h1>

			</div>
		</div>
		<!-- /.row -->
		<!-- <img src="img/weight.png" class="img-responsive" alt="Cinque Terre"> -->

	</div>
	<br>
	<div class="container">
		<div class="row">
			<div class="col-lg-5"></div>
			<div class="col-lg-12">
				<div class="col-lg-4">
					<input type="text" class="form-control" id="name" name="name"
						placeholder="Enter Name" required="required" autofocus="autofocus">
				</div>
				<div class="col-lg-4">
					<input type="text" class="form-control" name="weight" id="weight"
						placeholder="Your Weight - AutoGenerated" readonly="readonly">
				</div>
				<div class="col-lg-4">
					<input type="text" class="form-control" id="baseWeight"
						name="baseWeight" placeholder="Base Weight(pounds)"
						required="required">
				</div>
				<br>
				<h3 style="text-align: center;">Stand or Click</h3>
				<div class="col-lg-12" style="text-align: center;">
					<button class="button" onclick="addWeight()">Check Your
						Weight</button>
				</div>
				<div class="col-lg-4"></div>
			</div>
		</div>
		<!-- /.row -->
	</div>
	<!-- /.container -->

	<!-- jQuery -->
	<script src="js/jquery.js"></script>
	<!-- <script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.0/jquery.min.js"></script>
	<script type="text/javascript"
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script> -->
	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

	<script src="js/addWeight.js"></script>
</body>

</html>
