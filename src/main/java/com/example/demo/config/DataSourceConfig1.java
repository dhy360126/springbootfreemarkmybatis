package com.example.demo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
@Configuration 
//@MapperScan(basePackages = "com.example.demo.dao.db1",sqlSessionFactoryRef = "db1SqlsessionFactory")
@MapperScan(basePackages = "com.example.demo.dao.db1",sqlSessionTemplateRef = "db1SqlSessionTemplate")
public class DataSourceConfig1 {
/*1.使用@Bean可以创建一个bean对象交给spring容器管理sql
2.@Bean创建的bean对象的名称默认为方法名，也可以指定
3.@Bean方法参数表示，接收一个bean对象，默认按照type类型接收注入的对象，若要修改为byName方式，可以使用@Qualifier注解注入准确的对象
4.@Primary 表示该bean为此类型的默认bean，在其他地方引用的时候用@Autowired即可按照类型注入，不受同类型多个对象影响*/
    @Bean("db1DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.test")
    public DataSource db1DataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean("db1SqlSessionFactory")
    public SqlSessionFactory db1SqlSessionFactory(@Qualifier("db1DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        //mapper的xml文件必须要配置，不然的话报错 no statement 这种错误也可能是mapper的xml中，namespace与项目的路径不一致导致
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapping/db1/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }


    @Bean("db1SqlSessionTemplate")
    public SqlSessionTemplate db1SqlSessionTemplate(@Qualifier("db1SqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
