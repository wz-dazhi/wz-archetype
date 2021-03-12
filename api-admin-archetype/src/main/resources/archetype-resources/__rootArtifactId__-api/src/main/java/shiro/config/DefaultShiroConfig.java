//package ${package}.shiro.config;
//
//import com.wz.shiro.bean.ShiroProperties;
//import com.wz.shiro.config.AbstractShiroConfig;
//import ${package}.shiro.authc.PhonePasswordRealm;
//import ${package}.shiro.authc.WeChatRealm;
//import ${package}.shiro.filter.LoginFilter;
//import ${package}.shiro.filter.LogoutFilter;
//import lombok.AllArgsConstructor;
//import org.apache.shiro.realm.Realm;
//import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
//import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @className: ShiroConfig
// * @description:
// * @author: zhi
// * @version: 1.0
// */
//@AllArgsConstructor
//@Configuration
//@ConditionalOnProperty(name = {"shiro.enabled", "shiro.annotations.enabled"}, matchIfMissing = true)
//@EnableConfigurationProperties({RedisProperties.class, ShiroProperties.class})
//public class DefaultShiroConfig extends AbstractShiroConfig {
//
//    @Bean
//    public Realm weChatRealm() {
//        final WeChatRealm weChatRealm = new WeChatRealm();
//        weChatRealm.setCredentialsMatcher(hashedCredentialsMatcher());
//        weChatRealm.setAuthenticationCachingEnabled(true);
//        weChatRealm.setAuthorizationCachingEnabled(true);
//        return weChatRealm;
//    }
//
//    @Bean
//    public Realm phonePasswordRealm() {
//        final PhonePasswordRealm phonePasswordRealm = new PhonePasswordRealm();
//        phonePasswordRealm.setCredentialsMatcher(hashedCredentialsMatcher());
//        phonePasswordRealm.setAuthenticationCachingEnabled(true);
//        phonePasswordRealm.setAuthorizationCachingEnabled(true);
//        return phonePasswordRealm;
//    }
//
//    @Bean
//    public LoginFilter loginFilter() {
//        return new LoginFilter(shiroProperties);
//    }
//
//    @Bean
//    public LogoutFilter logoutFilter() {
//        return new LogoutFilter();
//    }
//
//    /**
//     * 登录filter设置不启用. 避免拦截多个请求
//     */
//    @Bean
//    public FilterRegistrationBean<LoginFilter> loginFilterRegistrationBean(LoginFilter loginFilter) {
//        final FilterRegistrationBean<LoginFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
//        filterFilterRegistrationBean.setFilter(loginFilter);
//        filterFilterRegistrationBean.setEnabled(false);
//        return filterFilterRegistrationBean;
//    }
//
//    /**
//     * 退出filter设置不启用. 避免拦截多个请求
//     */
//    @Bean
//    public FilterRegistrationBean<LogoutFilter> logoutFilterRegistrationBean(LogoutFilter logoutFilter) {
//        final FilterRegistrationBean<LogoutFilter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
//        filterFilterRegistrationBean.setFilter(logoutFilter);
//        filterFilterRegistrationBean.setEnabled(false);
//        return filterFilterRegistrationBean;
//    }
//
//}
