<!DOCTYPE html>
<html lang="zh-cn">
<head>
  <meta charset="UTF-8">
  <title>${api.serviceName!""}</title>
  <link rel="stylesheet" href="../css/api.css">
</head>

<body>
<div class="content">
    <h2>${api.serviceName!""} - ${api.service!""}</h2>
	
    <div class="apiContents">
        <h3>业务说明</h3>
        <div class="contentWords">
            <div>${api.note!""}</div>
            <div>${api.manualNote!""}</div>
        </div>
    </div>

    <div class="apiContents">
        <h3>API说明</h3>
        <div class="contentWords">
            <div>API名称：<b>${api.service!""}</b></div>
            <div>API版本：<b>${api.version!""}</b></div>
            <div>HTTP请求方式：<b>POST</b></div>
            <div>通讯方式<b>：</b>该接口为: ${api.serviceType!""}</div>
        </div>
    </div>

    <div class="apiContents">
        <h3>系统级别输入参数</h3>
        <div class="contentWords">
            <table border="0" cellspacing="0" cellpadding="0" class="tableAPI">
                <tbody>
                <tr>
                    <th>参数名</th><th>参数说明</th><th>类型</th><th>必选</th><th>备注</th>
                </tr>
                <tr>
                    <td>protocol</td><td>协议类型</td><td>S(16)</td><td>否</td><td>报文协议格式。httpPost(默认)</td>
                </tr>
                <tr>
                    <td>service</td><td>服务代码</td><td>S(32)</td><td>是</td><td>接口服务代码。请根据接口服务定义填写。</td>
                </tr>
                <tr>
                    <td>version</td><td>服务版本</td><td>S(8)</td><td>否</td><td>默认1.0</td>
                </tr>
                <tr>
                    <td>partnerId</td><td>商户ID</td><td>SF(20)</td><td>是</td><td>签约的服务平台账号对应的合作方ID,由服务平台分配。定长20字符</td>
                </tr>
                <tr>
                    <td>orderNo</td><td>请求订单号</td><td>s(20-40)</td><td>是</td><td>服务平台合作商户网站唯一订单号。长度：20-40字符。</td>
                </tr>
                <tr>
                    <td>signType</td><td>签名方式</td><td>S(16)</td><td>否</td><td>目前支持MD5(默认), Sha1Hex, Sha256Hex, HmacSHA1Hex，请注意大写。</td>
                </tr>
                <tr>
                    <td>sign</td><td>签名</td><td>S(32-64)</td><td>是</td><td>参见：3. 安全策略</td>
                </tr>
                <tr>
                    <td>returnUrl</td><td>页面跳转返回URL</td><td>s(256)</td><td>否</td><td>服务平台处理完请求后，当前页面自动跳转(307重定向)到商户网站里指定页面的http路径。</td>
                </tr>
                <tr>
                    <td>notifyUrl</td><td>异步通知URL</td><td>s(256)</td><td>否</td><td>当商户通过接口发起请求时，服务平台异步完成处理后，会主动连接该URL通知接口服务处理结果。</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>

    <#assign la = "R">

    <#list api.messageDocs as m >
        <#if la=="R" && m.messageType!="Request">
            <#assign la = "H">
            <br/><br/>
        </#if>
        <#if m.flag=="DIY">


    <div class="apiContents">
        <h3> <#if m.flag=="SYS">系统级别<#else>服务级别</#if> <#if m.messageType=="Request">输入参数<#else>返回结果</#if> </h3>
        <div class="contentWords">
            <table border="0" cellspacing="0" cellpadding="0" class="tableAPI">
                <tbody>
                <tr>
                    <th style="width: 150px;">参数</th>
                    <th style="width: 150px;">参数名称</th>
                    <th style="width: 100px;">类型(字符)</th>
                    <th style="width: 80px;">必填</th>
                    <th>参数说明</th>
                </tr>
                <#--<tr>
                    <td colspan="5">公共${m.messageType!""}结构 (参考：&quot;<a href="#_%E5%85%AC%E5%85%B1%E8%AF%B7%E6%B1%82%E7%BB%93%E6%9E%84">2.2.1 公共${m.messageType!""}结构</a>&quot;)</td>
                </tr>-->
                <#list m.apiItems as e>
                  <tr>
                      <td class="middle">${e.name!""}</td>
                      <td class="middle">${e.title!""}</td>
                      <td class="middle">${e.dataType!""}<#if e.dataLength??>(${e.dataLength})</#if></td>
                      <td class="middle">${e.status}</td>
                      <td class="left">${e.descn!""} ${e.manualNote!""}</td>
                  </tr>
                </#list>
                </tbody>
            </table>


            <#macro buildItems list>

                <#list list as e>
                    <#if (e.children??) && (e.children?size > 0) >
                        <h6>${e.name} 结构定义：</h6>
                        <table border="0" cellspacing="0" cellpadding="0" class="tableAPI">
                            <tbody>
                            <tr>
                                <th style="width: 150px;">参数</th>
                                <th style="width: 150px;">参数名称</th>
                                <th style="width: 100px;">类型(字符)</th>
                                <th style="width: 80px;">状态</th>
                                <th>参数说明</th>
                            </tr>
                                <#list e.children as x>
                                    <#if x??>
                                    <tr>
                                        <td class="middle">${x.name!""}</td>
                                        <td class="middle">${x.title!""}</td>
                                        <td class="middle">${x.dataType!""}<#if e.dataLength??>(${e.dataLength})</#if></td>
                                        <td class="middle">${x.status}</td>
                                        <td class="left">${x.descn!""} ${x.manualNote!""}</td>
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

        </div>
    </div>
        </#if>
    </#list>
</div>
</html>
