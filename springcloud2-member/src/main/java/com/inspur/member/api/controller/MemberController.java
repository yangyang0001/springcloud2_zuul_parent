package com.inspur.member.api.controller;

import com.spring4all.swagger.EnableSwagger2Doc;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: YANG
 * Date: 2019/7/17-0:59
 * Description: No Description
 */
@RestController
@EnableSwagger2Doc
@Api("MemberController")
public class MemberController {

	@Value("${server.port}")
	private String serverPort;

	@ApiOperation("getMember接口")
	@RequestMapping("/getMember")
	public String getMember(){
		return "this is member service this is springcloud2.0 ! server port is :" + serverPort;
	}

	@ApiOperation("swagger演示getUserName带有参数的接口")
	@ApiImplicitParams({@ApiImplicitParam(name="userName",value="用户名",dataType="string", paramType = "query",example="zhangsan")})
	@PostMapping("/getUserName")
	public String getUserName(String userName) {
		System.out.println("userName is :" + userName);
		return "userName is :" + userName;
	}
}
