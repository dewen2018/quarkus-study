package com.dewen;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;
import io.smallrye.config.WithName;

@ConfigMapping(prefix = "server")
public interface Server {
    String host();

    /**
     * 名字与配置项不一致时，用WithName注解指定配置项
     */
    @WithName("port")
    int port();

    Log log();

    interface Log {
        boolean enabled();

        /**
         * 用WithDefault注解设置默认值，如果配置项"student.favorite"不存在，则默认值生效
         */
        @WithDefault("default from code")
        String suffix();

        boolean rotate();
    }
}