package com.example.SyLibrary;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SyLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SyLibraryApplication.class, args);
	}
	
	@Bean
	SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/**/*.xml");
		bean.setMapperLocations(res);
		return bean.getObject();
	}

	@Bean
	SqlSessionTemplate sqlSession(SqlSessionFactory factory) {
		return new SqlSessionTemplate(factory);
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
