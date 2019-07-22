package com.inspur.swagger.config;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * User: YANG
 * Date: 2019/7/22-14:02
 * Description: No Description
 */
@Component
@Primary
public class SwaggerConfig implements SwaggerResourcesProvider {

	@Override
	public List<SwaggerResource> get() {
		List resources = new ArrayList<>();
		// app-order
		resources.add(swaggerResource("app-member", "/app-member/v2/api-docs?userToken=aa", "2.0"));
		resources.add(swaggerResource("app-order", "/app-order/v2/api-docs?userToken=aa", "2.0"));
		resources.add(swaggerResource("app-order-demo", "/app-order-demo/v2/api-docs?userToken=aa", "2.0"));
		return resources;
	}

	//这里的就是上面的swaggerResource()方法的调用,这里的name可以随便写

	/**
	 *
	 * @param name      这里的随便写,但是写成spring.application.name就行了
	 * @param location  这里绝对不能乱写的,只能是网关中的配置的映射的地址
	 * @param version
	 * @return
	 */
	private SwaggerResource swaggerResource(String name, String location, String version) {
		SwaggerResource swaggerResource = new SwaggerResource();
		swaggerResource.setName(name);
		swaggerResource.setLocation(location);
		swaggerResource.setSwaggerVersion(version);
		return swaggerResource;
	}

}
