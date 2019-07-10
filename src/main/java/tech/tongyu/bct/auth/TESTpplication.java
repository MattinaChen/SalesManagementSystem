package tech.tongyu.bct.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * 主程序启动类
 * @ClassName: FASApplication
 * @Description: 启动主程序
 * @Author: cjzhe
 * @Date:2019年7月1日10:16:48
 *
 */
@SpringBootApplication()
@MapperScan("tech.tongyu.bct.auth.mapper")
@EnableTransactionManagement(proxyTargetClass = true)
//@EnableAutoConfiguration
@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
public class TESTpplication extends SpringBootServletInitializer{
	public static void main(String[] args) {	 
        SpringApplication.run(TESTpplication.class, args);//Args 没有参数
    }
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(TESTpplication.class);
    }
}




