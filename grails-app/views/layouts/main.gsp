<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="StageTime"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
		<link rel="apple-touch-icon" href="${resource(dir: 'images', file: 'apple-touch-icon.png')}">
		<link rel="apple-touch-icon" sizes="114x114" href="${resource(dir: 'images', file: 'apple-touch-icon-retina.png')}">
		<!-- JQuery includes -->
		<script src="//code.jquery.com/jquery.js"></script>
		<script src="${resource(dir:'js', file:'jquery-ui-1.10.4.custom.js')}"></script>
		<!-- Bootstrap includes -->
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap-theme.min.css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">
        <link rel="stylesheet" href="${resource(dir: 'css/smoothness', file: 'jquery-ui-1.10.4.custom.min.css')}" type="text/css">
		<g:layoutHead/>
		<r:layoutResources />
	</head>
	<body>
		<header id="top" class="navbar navbar-static-top bs-docs-nav" role="banner">
			<nav class="navbar navbar-default" role="navigation">
				<div class="container">
					<div class="container-fluid">
						<div class="navbar-header">
							<button class="navbar-toggle collapsed" data-target="#bs-example-navbar-collapse-1" data-toggle="collapse" type="button"></button>
							<a class="navbar-brand" href="#">TimeStage</a>
						</div>
						<ul class="nav navbar-nav"><li><a href="#">click</a></li></ul>
						<ul class="nav navbar-nav navbar-right"><li><a href="#">click</a></li></ul>
					</div>
				</div>
			</nav>
		</header>
		<div class="container">
			<!-- flash messages -->
			<g:if test="${ flash.message }" >
				<div class="alert alert-info">
					<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
					<g:message code="${ flash.message }"/>
				</div>
			</g:if>
			<g:if test="${ flash.error }" >
				<div class="alert alert-error">
					<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
					<g:message code="${ flash.error }"/>
				</div>
			</g:if>
			<g:if test="${ flash.success }" >
				<div class="alert alert-danger">
					<button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
					<g:message code="${ flash.success }"/>
				</div>
			</g:if>
			<!-- body layout -->
			<g:layoutBody/>
		</div>
		<footer class="well">
			<div class="container">
				<div class="row">
					<div class="col-sm-4">
						<h4>Developers</h4>
						<ul class="list-group">
							<li class="list-group-item">Franck Arrecot</li>
							<li class="list-group-item">Loïc Favier</li>
							<li class="list-group-item">Kevin Anatole</li>
							<li class="list-group-item">Julien Barreau</li>
							<li class="list-group-item">Axel Robert</li>
							<li class="list-group-item">Nathanaël Bertran</li>
						</ul>
					</div>
					<div class="col-sm-4">
						<h4>Thanks to</h4>
						<ul class="list-group">
							<li class="list-group-item">Grails community</li>
						</ul>
					</div>
					<div class="col-sm-4">
						<h4>Liens utiles</h4>
						<ul class="list-group">
							<li class="list-group-item">Grails link</li>
							<li class="list-group-item">Master link</li>
							<li class="list-group-item">University link</li>
						</ul>
					</div>
				</div>
			</div>
		</footer>
		<r:layoutResources />
	</body>
</html>
