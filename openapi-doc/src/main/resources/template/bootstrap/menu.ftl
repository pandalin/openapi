<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="js/jquery/jquery-1.9.1.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/bootstrap/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" href="js/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="js/bootstrap/css/bootstrap-theme.min.css">
<title>Acooly OpenApi</title>
<style type="text/css">
.list-group-item {
	padding: 5px 10px;
}
.panel {margin-bottom: 0px; border-radius: 0px;}
</style>
</head>

<body>
	<div class="panel panel-default">
		<div class="panel-heading">
			<h3 class="panel-title">API</h3>
		</div>
		<ul class="list-group">
			<#list apis as e>
				<a href="api/${e.fileName}" class="list-group-item" target="parent" title="${e.service}-${e.version}">${e.serviceName}</a></li>
			</#list>		
		</ul>
	</div>
</body>
</html>