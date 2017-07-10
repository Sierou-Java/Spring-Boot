package org.sierou;

import com.alibaba.druid.pool.DruidDataSource;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

@SpringBootApplication
//@MapperScan(basePackages = "org.sierou.mapper")
public class SierouBlogServiceAdminApplication {

//	@Bean(initMethod = "init", destroyMethod = "close")
//	@ConfigurationProperties(prefix = "spring.datasource")
//	public DataSource dataSource() {
//		return new DruidDataSource();
//	}
//
//	@Bean
//	public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
//		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//		sqlSessionFactoryBean.setDataSource(dataSource());
//		sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:org/sierou/mapper/*.xml"));
//		return sqlSessionFactoredisryBean.getObject();
//	}

	public static void main(String[] args) {
		SpringApplication.run(SierouBlogServiceAdminApplication.class, args);
	}
}
