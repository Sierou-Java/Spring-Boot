package org.sierou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
//在启动类上使用@EnableAutoConfiguration注解，就会开启自动配置，简单点说就是它会根据定义在classpath下的类，
//自动的给你生成一些Bean，并加载到Spring的Context中。
//它的神秘之处，不在于它能做什么，而在于它会生成什么样的Bean对于开发人员是不可预知（或者说不容易预知）
public class SierouBlogAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(SierouBlogAdminApplication.class, args);
	}
}
