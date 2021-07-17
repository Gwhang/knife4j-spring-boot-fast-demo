package com.example.knife4jspringbootfastdemo.pojo;

import io.swagger.annotations.ApiModelProperty;

public class User {

    // 用户编号
    @ApiModelProperty(value = "用户编号")
    private String number;

    // 用户姓名
    @ApiModelProperty(value = "用户姓名")
    private String name;

    // 用户年龄
    @ApiModelProperty(value = "用户年龄")
    private String age;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
