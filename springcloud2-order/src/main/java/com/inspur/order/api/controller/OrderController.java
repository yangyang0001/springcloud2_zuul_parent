package com.inspur.order.api.controller;

import com.inspur.feign.client.MemberFeignClient;
import com.spring4all.swagger.EnableSwagger2Doc;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * User: YANG
 * Date: 2019/7/17-14:50
 * Description: No Description
 */
@RestController
@EnableSwagger2Doc
@Api("OrderController")
public class OrderController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private MemberFeignClient feignClient;

	@ApiOperation("getOrder接口,调用MemberService中的getMember接口")
	@RequestMapping("/getOrder")
	public String getOrder(){
		//这里的访问路径有两种方式:
		/**
		 * 1.直接写URL的具体链接方式
		 *      http://localhost:8000/getMember
		 * 2.使用注册中心上的别名去获取具体的链接
		 *      http://app-memeber/getMember
		 */
//		String url = "http://localhost:8000/getMember";
		String url = "http://app-memeber/getMember";
		String result = restTemplate.getForObject(url, String.class);
		System.out.println("OrderService调用MemberService返回结果:" + result);
		return result;
	}

	@ApiOperation("getOrderByFeignClient接口")
	@RequestMapping("/getOrderByFeignClient")
	public String getOrderByFeignClient(){
		System.out.println("getOrderByFeignClient -----------:" + feignClient.getMember());
		return feignClient.getMember();
	}

}
