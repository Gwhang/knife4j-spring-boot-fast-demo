package com.example.knife4jspringbootfastdemo.controller;


import com.example.knife4jspringbootfastdemo.pojo.User;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@Api(tags = "测试1")
@RestController
public class IndexController {

    // 传递参数校验
    @ApiImplicitParam(name = "name",value = "姓名",required = true)
    // 可加接口开发作者， 加排序
    @ApiOperationSupport(author = "gwh",order = 1)
    // 方法描述
    @ApiOperation(value = "向客人问好")
    @GetMapping("/sayHi")
    public ResponseEntity<String> sayHi(@RequestParam(value = "name")String name){
        return ResponseEntity.ok("Hi:"+name);
    }

    @ApiImplicitParam(name = "name",value = "姓名",required = true)
    @ApiOperationSupport(author = "gwh",order = 2)
    @ApiOperation(value = "向客人挥手")
    @GetMapping("/byebye")
    public ResponseEntity<String> byebye(@RequestParam(value = "name")String name){
        return ResponseEntity.ok("bye-bye:"+name);
    }

    // 使用自定义增强注解ApiOperationSupport中的ignoreParameters属性,可以强制忽略要显示的参数.
    // 例如新增接口时,某实体类不需要显示Id,即可使用该属性对参数进行忽略.ignoreParameters={"id"}
    // 如果存在多个层次的参数过滤,则使用名称.属性的方式,例如 ignoreParameters={"uptModel.id","uptModel.uptPo.id"},其中uptModel是实体对象参数名称,id为其属性,uptPo为实体类,作为uptModel类的属性名称
    // 如果参数层级只是一级的情况下,并且参数是实体类的情况下,不需要设置参数名称,直接给定属性值名称即可
    // 如果是JSON 请求的话需要加上一级参数名
    @ApiOperationSupport(author = "gwh",order = 3,ignoreParameters={"user.number"})
    @ApiOperation("获取用户数据")
    @PostMapping("/getUser")
    public User getUser(@RequestBody User user){
        return user;
    }
    // 使用自定义增强注解ApiOperationSupport中的includeParameters属性,可以强制包含要显示的参数.去除多余的参数显示
    // 新增接口时,某实体类不需要显示Id,即可使用该属性对参数进行忽略.includeParameters={"id"}
    // 如果是JSON请求的话 需要把一级参数名称带上
    @ApiOperationSupport(author = "gwh",order = 5,includeParameters = {"user.number"})
    @ApiOperation("获取用户数据")
    @PostMapping("/getUser1")
    public User getUser1(@RequestBody User user){
        return user;
    }
}
