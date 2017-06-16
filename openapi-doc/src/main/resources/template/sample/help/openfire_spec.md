<style>
.tableAPI { border:1px solid #e7e7e7; border-collapse: collapse;width:100%}
.tableAPI th { background:#efefef; color:#3f4346;padding-top:5px; padding-bottom:5px;}
.tableAPI td, .tableAPI th { border:1px solid #ddd; line-height:20px; padding:4px 10px;}
.tableAPI td { text-align:left;}
</style>
Openfire开发说明
===============

---------------

## 1. 环境说明
### 测试环境
1. 域名： test-openfire.1119e.com
2. 接口地址：http://test-openfire.1119e.com:8090
3. 服务端口：4222 (客户端到服务器，如smack)
4. JID：userName@domain/resource，其中resource为：andorid，ios，web。例如：zhangpu@**test-openfire.1119e.com**/ios; 登录密码为6个1。
### 生产环境
1. 域名： t.1119e.com
2. 接口地址：http://t.1119e.com:9090
3. 服务端口：5222 (客户端到服务器，如smack)
4. JID：userName@domain/resource，其中resource为：andorid，ios，web。例如：zhangpu@**t.1119e.com**/ios; 登录密码为6个1。

## 2. 专用接口

### 2.1 查询聊天会话
>	该接口采用HTTP(GET/POST)直接请求openfire服务器插件方式获取用户的聊天会话数据。每次聊天过程为一次聊天会话。数据直接响应到响应报文的body体，可以使用流式获取。
	
请求地址：/plugins/asearch/asearch?service=queryConversation&start=0&limit=10&owner=


#### 请求参数
<table width="100%" border="1" cellpadding="0" cellspacing="0" class="tableAPI">
	<tr>
		<th>参数名</th><th>参数说明</th><th>类型</th><th>必选</th><th>备注</th>
	</tr>
	<tr>
		<td>service</td><td>服务名</td><td>S</td><td>是</td><td>固定值：queryConversation</td>
	</tr>
	<tr>
		<td>owner</td><td>用户</td><td>S</td><td>是</td><td>用户名</td>
	</tr>
	<tr>
		<td>start</td><td>开始位置</td><td>N</td><td>否</td><td>分页开始行号，第1行为0，默认为0</td>
	</tr>
	<tr>
		<td>limit</td><td>页大小</td><td>N</td><td>否</td><td>默认为10</td>
	</tr>
</table>

#### 响应参数
<table width="100%" border="1" cellpadding="0" cellspacing="0" class="tableAPI">
	<tr>
		<th>参数名</th><th>参数说明</th><th>类型</th><th>必选</th><th>备注</th>
	</tr>
	<tr>
		<td>entities</td><td>会话数据</td><td>Array</td><td>是</td><td>会话数据结构请参考：报文示例</td>
	</tr>
	<tr>
		<td>start</td><td>开始位置</td><td>N</td><td>否</td><td>分页开始行号，第1行为0，默认为0</td>
	</tr>
	<tr>
		<td>limit</td><td>页大小</td><td>N</td><td>否</td><td>默认为10</td>
	</tr>
	<tr>
		<td>end</td><td>是否末页</td><td>N</td><td>是</td><td>true:最后页，false:存在下一页</td>
	</tr>
</table>

#### 报文示例
	# 请求报文
	http://t.1119e.com:9090/plugins/asearch/asearch?service=queryConversation&start=0&limit=10&owner=zhangpu
	
	# 响应报文
	{
		"end": "true",
		"limit": 10,
		"start": 0,
		"entities": [
			{
				"id": "109",
				"owner": "zhangpu@t.1119e.com",
				"with": "admin@t.1119e.com",
				"startTime": "2015-04-15 19:47:51",
				"subject": "trade_confirm"
			},
			{
				"id": "106",
				"owner": "zhangpu@t.1119e.com",
				"with": "zw6638@t.1119e.com",
				"startTime": "2015-04-15 19:45:46",
				"subject": "32"
			},
			{
				"id": "2",
				"owner": "zhangpu@t.1119e.com",
				"with": "zw6638@t.1119e.com",
				"startTime": "2015-04-01 22:11:27",
				"subject": "8"
			}
		]
	}

### 2.2 查询聊天记录
>	该接口采用HTTP(GET/POST)直接请求openfire服务器插件方式获取用户的聊天聊天记录。
	
请求地址：
/plugins/asearch/asearch?service=queryMessage&owner=zhangpu&with=zw6638&subject=11&start=0&limit=10

#### 请求参数
<table width="100%" border="1" cellpadding="0" cellspacing="0" class="tableAPI">
	<tr>
		<th>参数名</th><th>参数说明</th><th>类型</th><th>必选</th><th>备注</th>
	</tr>
	<tr>
		<td>service</td><td>服务名</td><td>S</td><td>是</td><td>固定值：queryConversation</td>
	</tr>
	<tr>
		<td>owner</td><td>发送用户</td><td>S</td><td>是</td><td>发送消息用户名</td>
	</tr>
	<tr>
		<td>with</td><td>接收用户</td><td>S</td><td>否</td><td>接收消息用户名</td>
	</tr>
	<tr>
		<td>subject</td><td>交易ID</td><td>N</td><td>否</td><td>如果是议价聊天的会话，则传入该ID</td>
	</tr>
	<tr>
		<td>start</td><td>开始位置</td><td>N</td><td>否</td><td>分页开始行号，第1行为0，默认为0</td>
	</tr>
	<tr>
		<td>limit</td><td>页大小</td><td>N</td><td>否</td><td>默认为10</td>
	</tr>
</table>

#### 响应参数
<table width="100%" border="1" cellpadding="0" cellspacing="0" class="tableAPI">
	<tr>
		<th>参数名</th><th>参数说明</th><th>类型</th><th>必选</th><th>备注</th>
	</tr>
	<tr>
		<td>entities</td><td>会话数据</td><td>Array</td><td>是</td><td>会话数据结构请参考：报文示例</td>
	</tr>
	<tr>
		<td>start</td><td>开始位置</td><td>N</td><td>否</td><td>分页开始行号，第1行为0，默认为0</td>
	</tr>
	<tr>
		<td>start</td><td>页大小</td><td>N</td><td>否</td><td>默认为10</td>
	</tr>
	<tr>
		<td>end</td><td>是否末页</td><td>N</td><td>是</td><td>true:最后页，false:存在下一页</td>
	</tr>
</table>

#### 报文示例
	# 请求报文
	http://t.1119e.com:9090/plugins/asearch/asearch?service=queryMessage&owner=zhangpu&with=zw6638&subject=32&start=0&limit=2
	
	# 响应报文
	{
		"end": "true",
		"limit": 2,
		"start": 0,
		"entities": [
			{
				"messageId": 399,
				"talker": "zhangpu@t.1119e.com",
				"resource": "web",
				"time": "2015-04-15 19:45:46",
				"subject": "32",
				"body": "没钱钱"
			},
			{
				"messageId": 400,
				"talker": "zw6638@t.1119e.com",
				"resource": "web",
				"time": "2015-04-15 19:46:19",
				"subject": "32",
				"body": "%%%"
			}
		]
	}

## 3. 客户端聊天记录处理方案

1. 每次XMPP收到消息，包括离线和在线（离线消息是登录的时候就下来的），存储在本地（浏览器本地）并记录未读数。进入聊天窗口首先拉去服务器最新一页的聊天记录，清空本会话相关的所有未读计数（根据会话双发+subject）；本地只根据收到的聊天记录进行计数的存储。根据用户打开聊天窗口（会话）判断减去对应的未读计数。

2. 进入聊天界面显示的聊天记录初始化全部来至服务器端，然后在聊天记录时收到的消息直接显示在聊天记录，不做存储。只有在未进入对应的聊天记录界面时收到的信息才存储

本地存储的格式:

	{
		"from" : "",
		"to" : "",
		"subject" : "",
		"count" : 0
	}

