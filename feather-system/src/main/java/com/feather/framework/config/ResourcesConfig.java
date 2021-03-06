package com.feather.framework.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.feather.common.config.Global;
import com.feather.common.constant.FeatherConstants;

/**
 * 通用配置
 *
 * @author feather
 */
@Configuration
public class ResourcesConfig implements WebMvcConfigurer {
    /**
     * 首页地址
     */
    @Value("${shiro.user.indexUrl}")
    private String indexUrl;

    // @Autowired
    // private RepeatSubmitInterceptor repeatSubmitInterceptor;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        if (StringUtils.isNotEmpty(indexUrl)) {
            /** 默认首页的设置，当输入域名是可以自动跳转到默认指定的网页 */
            registry.addViewController("/").setViewName("forward:" + indexUrl);
        }
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /** 本地文件上传路径 */
        registry.addResourceHandler(FeatherConstants.RESOURCE_PREFIX + "/**")
                .addResourceLocations("file:" + Global.getProfile() + "/");

        /** swagger配置 */
        registry.addResourceHandler("/swagger-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/")
                .resourceChain(false);

        /** 增加多模块情况下静态文件无法访问的情况 **/
        if (!registry.hasMappingForPattern("/static/**")) {
            registry.addResourceHandler("/static/**").addResourceLocations("classpath*:/static/");
        }
    }

    /**
     * 自定义拦截规则
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // registry.addInterceptor(repeatSubmitInterceptor).addPathPatterns("/**");
    }
}