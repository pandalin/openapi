<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="../js/jquery/jquery-1.9.1.min.js" type="text/javascript" charset="utf-8"></script>
<script src="../js/bootstrap/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" href="../js/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="../js/bootstrap/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../css/api.css">
<style type="text/css">
/* Move down content because we have a fixed navbar that is 50px tall */
body {
	padding-top: 60px;
	margin: 0px;
	font-family: 微软雅黑;
}

.list-group-item {
	padding: 7px 10px;
}

.panel {
	margin-bottom: 0px;
	border-radius: 0px;
}

.page-header {
	padding-bottom: 0px;
	margin: 0px 0 10px;
}
</style>
<title>Acooly OpenApi</title>
</head>

<body>
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Acooly OpenApi</a>
			</div>
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">帮助中心 <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">安全认证</a></li>
							<li><a href="#">公共报文</a></li>
							<li><a href="#">常见问题</a></li>
						</ul></li>
					<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">联系我们 <span class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">联系我们</a></li>
							<li><a href="#">意见反馈</a></li>
						</ul></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-2">
				<iframe id="apiMenu" width="100%" src="../menu.htm" frameborder="0" marginwidth="0" marginheight="0"></iframe>
			</div>
			<div class="col-lg-10">
				<div class="page-header">
					<h3>
						${api.serviceName!""} - ${api.service!""} <small>${api.version!""}</small>
					</h3>
				</div>
				<p class="text-left small">
					HTTP请求方式：<b>POST</b> 通讯方式<b>：</b>该接口为: ${api.serviceType!""}
				</p>

				<div class="panel panel-default" style="margin-bottom: 10px;">
					<div class="panel-heading">
						<h3 class="panel-title">业务说明</h3>
					</div>
					<div class="panel-body">
						<div>${api.note!""}</div>
						<div>${api.manualNote!""}</div>
					</div>
				</div>


				<#list api.messageDocs as m >
				<div class="well well-sm text-primary">
					<span class="glyphicon glyphicon-menu-right"></span> ${m.messageType!""}
				</div>
				<table border="0" cellspacing="0" cellpadding="0" class="tableAPI">
					<tbody>
						<tr>
							<th style="width: 150px;">参数</th>
							<th style="width: 150px;">参数名称</th>
							<th style="width: 100px;">类型（字节）</th>
							<th style="width: 80px;">状态</th>
							<th>参数说明</th>
						</tr>
						<tr>
							<td colspan="5">公共${m.messageType!""}结构 (参考：&quot;<a href="#_%E5%85%AC%E5%85%B1%E8%AF%B7%E6%B1%82%E7%BB%93%E6%9E%84">2.2.1 公共${m.messageType!""}结构</a>&quot;)
							</td>
						</tr>
						<#list m.apiItems as e>
						<tr>
							<td>${e.name!""}</td>
							<td>${e.title!""}</td>
							<td>${e.dataType!""}</td>
							<td>${e.status}</td>
							<td>${e.descn!""} ${e.manualNote!""}</td>
						</tr>
						</#list>
					</tbody>
				</table>


				<#macro buildItems list> 
				
				<#list list as e> 
				<#if (e.children?size > 0) >
				<h6>${e.name} 结构定义：</h6>
				<table border="0" cellspacing="0" cellpadding="0" class="tableAPI">
					<tbody>
						<tr>
							<th style="width: 150px;">参数</th>
							<th style="width: 150px;">参数名称</th>
							<th style="width: 100px;">类型（字节）</th>
							<th style="width: 80px;">状态</th>
							<th>参数说明</th>
						</tr>
						<#list e.children as x> 
						<#if x??>
						<tr>
							<td>${x.name!""}</td>
							<td>${x.title!""}</td>
							<td>${x.dataType!""}</td>
							<td>${x.status}</td>
							<td>${x.descn!""} ${x.manualNote!""}</td>
						</tr>
						</#if> 
						</#list>
					</tbody>
				</table>
				</#if> 
				</#list> 
				
				<#list list as x> 
					<#if x.children?exists && (x.children?size > 0) > 
						<@buildItems list=x.children/> 
					</#if> 
				</#list> 
				
			</#macro> 
			<@buildItems list=m.apiItems/>
		</#list>
	</div>
	</div>
	</div>

	<script type="text/javascript">
		function adjustIFramesHeightOnLoad(iframe) {
			var iframeHeight = Math.min(iframe.contentWindow.window.document.documentElement.scrollHeight, iframe.contentWindow.window.document.body.scrollHeight);
			$(iframe).height(iframeHeight);
		}

		$(function() {
			$("#apiMenu").load(function() {
				$(this).height($(this).contents().find("body").height() - 180);
			});
		});
	</script>

</body>
</html>