package com.inspur.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: YANG
 * Date: 2019/7/19-13:40
 * Description: No Description
 */
@FeignClient(name = "app-memeber")
public interface MemberFeignClient {

	@RequestMapping("/getMember")
	public String getMember();

}