1、本项目最重要的模块是：
  openapi-service       API服务定义(主要开发模块)
  openapi-integration   调用其他系统接口集成(主要开发模块)
  openapi-core  OpenApi核心实现
  openapi-dal   数据库操作
  openapi-facade    就定义了几个枚举

  其他模块用作统计结构以及OpenAPI自身业务逻辑

2、开发流程

  a、入参开发：
    参照：com.jvv.openapi.service.demo.test.request.TestRequest

    @NotNull
    @OpenApiField(desc = "用户ID", constraint = "必填")
    注解标识了属性是一个接口字段，是否必填是是有@NotNull来校验决定的


  b、结果定义：
    参照：com.jvv.openapi.service.demo.test.response.TestResponse


    @OpenApiField(desc = "服务响应状态")
    注解标识了属性是一个接口字段，需要返回给商户(调用者)


    绝大多数都不需要写这个类，直接使用ApiResponse即可


  c、数据定义：
    参照：com.jvv.openapi.service.demo.test.response.TestResponseData

    这是一个普通的pojo，将放到 结果的data字段里，


  d、接口开发：
    参照：com.jvv.openapi.service.demo.test.api.TestApiSrevice

    @OpenApiService(name = "test",desc = "测试例子")
    这个服务名，就是访问时候的服务名

    逻辑中，使用 Client 进行远程调用



  e、编写远程调用客户端
    参照：com.jvv.openapi.intergration.demo.DemoClient
