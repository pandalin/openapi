<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <title>API菜单</title>
    <script src="js/jquery/jquery-1.9.1.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="js/bootstrap/js/bootstrap.min.js" type="text/javascript" charset="utf-8"></script>
    <link rel="stylesheet" href="js/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="js/bootstrap/css/bootstrap-theme.min.css">
    <style type="text/css">
        body {font-size: 12px;font-family: 微软雅黑;margin: 5px;}
        .list-group-item {padding: 8px 10px;}
        .panel {border-radius: 0px;}
        .panel-heading {border-bottom: 0px;}
    </style>
</head>
<body>
<div>

<#list apis?keys as mkey>
    <#assign la = apis[mkey]>
    <#if la?size gt 0 >
        <div class="panel panel-default" style="margin-bottom: 0px;">
            <div class="panel-heading" data-toggle="collapse" data-target="#collapseSearchBody${mkey_index}" style="height:40px;cursor: pointer;">
                <div style="float:left;font-size:14px;"><span class="glyphicon glyphicon-book"></span> ${mkey}</div>
                <div style="float:right"><span class="badge">${la?size}</span></div>
            </div>
            <ul id="collapseSearchBody${mkey_index}" class="list-group collapse <#if mkey_index == 0>in<#else>out</#if>">
                <#list la as e>
                    <a href="api/${e.fileName}" class="list-group-item" target="api" title="${e.service}-${e.version}">${e.serviceName}</a></li>
                </#list>
            </ul>
        </div>
    </#if>
</#list>
</div>
</html>
