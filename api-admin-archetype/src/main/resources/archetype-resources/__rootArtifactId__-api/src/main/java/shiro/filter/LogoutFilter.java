//package ${package}.shiro.filter;
//
//import com.wz.common.util.Results;
//import com.wz.redis.util.RedisUtil;
//import com.wz.shiro.bean.ShiroProperties;
//import com.wz.web.filter.FilterHelper;
//import ${package}.shiro.LoginUser;
//import ${package}.shiro.authc.PhonePasswordRealm;
//import ${package}.shiro.authc.WeChatRealm;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.shiro.cache.CacheManager;
//import org.apache.shiro.session.SessionException;
//import org.apache.shiro.subject.Subject;
//import org.apache.shiro.web.filter.AccessControlFilter;
//import org.apache.shiro.web.util.WebUtils;
//
//import javax.annotation.PostConstruct;
//import javax.annotation.Resource;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import java.util.Locale;
//import java.util.Objects;
//
//import static com.wz.shiro.enums.ShiroEnum.METHOD_NOT_ALLOWED;
//
///**
// * @className: LogoutFilter
// * @description:
// * @author: zhi
// * @version: 1.0
// */
//@Slf4j
//public class LogoutFilter extends org.apache.shiro.web.filter.authc.LogoutFilter {
//    @Resource
//    private ShiroProperties shiroProperties;
//    @Resource
//    private RedisUtil redisUtil;
//    @Resource
//    private WeChatRealm weChatRealm;
//    @Resource
//    private PhonePasswordRealm phonePasswordRealm;
//    @Resource
//    private CacheManager cacheManager;
//
//    private String tokenPrefixKey;
//
//    @PostConstruct
//    public void init() {
//        tokenPrefixKey = shiroProperties.getCacheKeyPrefix() + shiroProperties.getToken();
//    }
//
//    @Override
//    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
//        Subject subject = getSubject(request, response);
//        // 检查是否开启使用post请求
//        if (isPostOnlyLogout()) {
//            // 如果当前请求方式不等于post or get, 直接返回false
//            final String requestMethod = WebUtils.toHttp(request).getMethod().toUpperCase(Locale.ENGLISH);
//            if (!AccessControlFilter.POST_METHOD.equals(requestMethod) && !AccessControlFilter.GET_METHOD.equals(requestMethod)) {
//                FilterHelper.writeResponse(response, Results.fail(METHOD_NOT_ALLOWED));
//                return false;
//            }
//        }
//
//        // 清空缓存
//        final LoginUser principal = (LoginUser) subject.getPrincipal();
//        if (Objects.nonNull(principal)) {
//            final String key = Filters.getTokenKey(tokenPrefixKey, principal);
//            redisUtil.del(key);
//            this.delCache(subject);
//        } else {
//            // 未认证, 不需要退出
//            FilterHelper.writeResponse(response, Results.ok());
//            return false;
//        }
//
//        // 获取重定向地址;
//        // 退出成功后, 跳转页面应由前端来定
//        //String redirectUrl = getRedirectUrl(request, response, subject);
//        //try/catch added for SHIRO-298:
//        try {
//            subject.logout();
//        } catch (SessionException ise) {
//            log.debug("Encountered session exception during logout.  This can generally safely be ignored.", ise);
//        }
//        //issueRedirect(request, response, redirectUrl);
//        FilterHelper.writeResponse(response, Results.ok());
//        return false;
//    }
//
//    private void delCache(Subject s) {
//        final Object principal = s.getPrincipal();
//        final LoginUser u = (LoginUser) principal;
//        final Long id = u.getId();
//        String authenticationCacheName;
//        String authorizationCacheName;
//        switch (u.getLoginType()) {
//            case WE_CHAT:
//                authenticationCacheName = weChatRealm.getAuthenticationCacheName();
//                authorizationCacheName = weChatRealm.getAuthorizationCacheName();
//                break;
//            case PHONE_PASSWORD:
//                authenticationCacheName = phonePasswordRealm.getAuthenticationCacheName();
//                authorizationCacheName = phonePasswordRealm.getAuthorizationCacheName();
//                break;
//            default:
//                return;
//        }
//        cacheManager.getCache(authenticationCacheName).remove(id);
//        cacheManager.getCache(authorizationCacheName).remove(id);
//    }
//
//}
