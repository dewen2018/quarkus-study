package com.dewen.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import io.quarkus.runtime.Startup;
import io.quarkus.runtime.StartupEvent;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
@Startup
public class BeanConfig {
    @Inject
    SqlSessionFactory sqlSessionFactory;

    void startup(@Observes StartupEvent event) {
        // MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        // interceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        // sqlSessionFactory.getConfiguration().addInterceptor(interceptor);

        sqlSessionFactory.getConfiguration().addInterceptor(new MybatisPlusInterceptor());
    }
}