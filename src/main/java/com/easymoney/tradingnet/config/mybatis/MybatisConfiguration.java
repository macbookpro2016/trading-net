package com.easymoney.tradingnet.config.mybatis;

import com.easymoney.tradingnet.config.datasource.DataSourceConfig;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @description: mybatis配置类
 *
 * @author: fengzhihang
 * @create: 2019-07-09 20:10
 **/
@Configuration
@AutoConfigureAfter(DataSourceConfig.class)
@MapperScan(basePackages = "com.easymoney.tradingnet.mapper")
public class MybatisConfiguration {

    private static Logger LOGGER = LoggerFactory.getLogger(MybatisConfiguration.class);

    static final String MAPPER_LOCATION = "classpath:mapper/*.xml";

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    /**
     * 配置sqlSessionFactory
     *
     * @return
     * @throws Exception
     */
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactorys() throws Exception{
        LOGGER.info("-----sqlSessionFactory init-----");

        try {
            SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

            // 读取配置
            sqlSessionFactoryBean.setTypeAliasesPackage("com.easymoney.tradingnet.mapper");

            // 设置mapper.xml文件所在位置
            Resource[] resources = new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION);
            sqlSessionFactoryBean.setMapperLocations(resources);
            sqlSessionFactoryBean.setDataSource(dataSource);
            return sqlSessionFactoryBean.getObject();
        }catch (IOException e){
            LOGGER.error("can not find mapper.xml", e);
        }catch (Exception e){
            LOGGER.error("sqlSessionFactory create error", e);
        }
        return null;
    }

    /**
     * 创建sqlSessionTemplate
     *
     * @param sqlSessionFactory
     * @return
     */
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory){
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}