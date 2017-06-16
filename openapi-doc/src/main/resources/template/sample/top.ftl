<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta charset="UTF-8">
<script src="js/jquery/jquery-1.9.1.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/bootstrap/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" href="js/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="js/bootstrap/css/bootstrap-theme.min.css">
<style type="text/css">
body{
 font-family: 微软雅黑;
}
</style>
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" style="font-weight: 800;" href="index.htm" target="_parent">${context.title}<small><#if context
                .subTitle??>（${context.subTitle}）</#if></small></a>
			</div>
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="help/api_spec.htm" target="api">开发规范</a></li>
					<li><a href="index_scheme.htm" target="_parent">行业解决方案</a></li>
					<#list context.links?keys as mkey>
					<li><a href="${context.links[mkey]}" target="api">${mkey}</a></li>
					</#list>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
</body>
</html>
