package com.example.knife4jspringbootfastdemo.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Api(tags = "测试2")
public class TestController2 {


    @ApiImplicitParam(name = "id",value = "id",required = true)
    @ApiOperationSupport(order = 1,author = "gwh")
    @ApiOperation(value = "获取ID")
    @PostMapping("/getById")
    public String get(String id){
        return id;
    }


    @ApiImplicitParam(name = "file",value = "文件",required = true)
    @ApiOperationSupport(order = 2,author = "gwh")
    @ApiOperation(value = "文件上传")
    @PostMapping("/upload")
    public String upload(MultipartFile file){
        return "成功";
    }


}
