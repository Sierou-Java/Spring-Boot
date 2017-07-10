package org.sierou.config.datasource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.util.DruidPasswordCallback;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.sierou.core.SecurityAES;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by wanghongyue on 2017/6/25.
 */
@Configuration
@MapperScan(basePackages = MasterDataSourceConfig.PACKAGE, sqlSessionFactoryRef = "masterSqlSessionFactory")
public class MasterDataSourceConfig {

    // 精确到 master 目录，以便跟其他数据源隔离
    static final String PACKAGE = "org.sierou.mapper";
    static final String MAPPER_LOCATION = "classpath:org/sierou/mapper/*.xml";

    @Value("${master.datasource.url}")
    private String url;

    @Value("${master.datasource.username}")
    private String user;

    @Value("${master.datasource.password}")
    private String password;

    @Value("${master.datasource.driverClassName}")
    private String driverClass;

    @Value("${master.datasource.initialSize}")
    private int initialSize;

    @Value("${master.datasource.minIdle}")
    private int minIdle;

    @Value("${master.datasource.maxActive}")
    private int maxActive;

    @Bean(name = "masterDataSource")
    @Primary
    @ConfigurationProperties(prefix = "master.datasource")
    public DataSource masterDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
//        System.out.println(SecurityAES.decrypt(password, "123"));
//        dataSource.setPassword(SecurityAES.decrypt(password, "123"));
        dataSource.setPassword(password);
        dataSource.setMaxActive(maxActive);
        dataSource.setInitialSize(initialSize);
        dataSource.setMinIdle(minIdle);
//        dataSource.setConnectionProperties("master.datasource.password=" + password);
        return dataSource;
    }

    @Bean(name = "masterTransactionManager")
    @Primary
    public DataSourceTransactionManager masterTransactionManager() {
        return new DataSourceTransactionManager(masterDataSource());
    }

    @Bean(name = "masterSqlSessionFactory")
    @Primary
    public SqlSessionFactory masterSqlSessionFactory(@Qualifier("masterDataSource") DataSource masterDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(masterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(MasterDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }

    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new StatViewServlet());
        servletRegistrationBean.addUrlMappings("/druid/*");

        return servletRegistrationBean;
    }

//    @Bean(name="masterDruidPasswordCallback")
//    @Primary
//    public DruidPasswordCallback masterDruidPasswordCallback(){
//        System.out.println("MasterDataSourceConfig.masterDruidPasswordCallback1");
//        DruidPasswordCallback druidPasswordCallback = new DruidPasswordCallback();
////        Properties properties = druidPasswordCallback.getProperties();
////        String pwd = properties.getProperty("master.datasource.password");
////        System.out.println("pwd = " +  pwd);
//        String decrypropertiespt = SecurityAES.decrypt(password, "123");
//        druidPasswordCallback.setPassword(decrypropertiespt.toCharArray());
//        return druidPasswordCallback;
//    }
}
