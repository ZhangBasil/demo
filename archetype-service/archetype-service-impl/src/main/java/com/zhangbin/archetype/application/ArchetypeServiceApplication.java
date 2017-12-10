package com.zhangbin.archetype.application;

import com.zhangbin.base.service.aop.annotation.EnableAspect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zhangbin
 * @Type ArchetypeServiceApplication
 * @Desc
 * @date 2017-11-29
 * @Version V1.0
 */
@SpringBootApplication
@MapperScan("com.zhangbin.archetype.biz.dal")
@ComponentScan("com.zhangbin.archetype")
@EnableTransactionManagement
@EnableAspect
public class ArchetypeServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ArchetypeServiceApplication.class, args);
    }
}
