//package ${package}.shiro.filter;
//
//import com.wz.common.constant.DateConsts;
//import com.wz.common.exception.ParameterException;
//import com.wz.common.model.JwtData;
//import com.wz.common.util.DateUtil;
//import com.wz.common.util.JsonUtil;
//import com.wz.common.util.JwtUtil;
//import com.wz.common.util.MapUtil;
//import com.wz.common.util.StringUtil;
//import com.wz.redis.util.RedisUtil;
//import com.wz.shiro.bean.ShiroProperties;
//import com.wz.shiro.enums.LoginType;
//import com.wz.shiro.filter.AbstractLoginFilter;
//import com.wz.shiro.util.ShiroUtil;
//import ${package}.shiro.ApiShiroToken;
//import ${package}.shiro.LoginUser;
//import ${package}.constant.AppConst;
//import ${package}.enums.ApiLoginType;
//import ${package}.enums.AppEnum;
//import lombok.Cleanup;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.subject.Subject;
//import org.springframework.beans.factory.annotation.Value;
//
//import javax.annotation.Resource;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.BufferedReader;
//import java.time.LocalDateTime;
//import java.util.Map;
//import java.util.Objects;
//import java.util.concurrent.TimeUnit;
//
///**
// * @className: LoginFilter
// * @description:
// * @author: zhi
// * @version: 1.0
// */
//@Slf4j
//public class LoginFilter extends AbstractLoginFilter {
//    private final String tokenPrefixKey;
//
//    @Value("${api.config.login-expire}")
//    private long expire;
//    @Value("${api.config.login-secret}")
//    private String secret;
//
//    @Resource
//    private RedisUtil redisUtil;
//
//    public LoginFilter(ShiroProperties shiroProperties) {
//        super(shiroProperties);
//        tokenPrefixKey = shiroProperties.getCacheKeyPrefix() + shiroProperties.getToken();
//    }
//
//    @Override
//    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
//        HttpServletRequest req = (HttpServletRequest) request;
//        // 解析body数据
//        final ApiShiroToken t;
//        try {
//            @Cleanup final BufferedReader reader = req.getReader();
//            final String body = reader.lines()
//                    .reduce(String::concat)
//                    .orElseThrow(ParameterException::new);
//            t = JsonUtil.toBean(body, ApiShiroToken.class);
//        } catch (Exception e) {
//            log.error("Create token error. e: ", e);
//            throw new ParameterException();
//        }
//        // 判断登录类型; body中获取
//        if (Objects.nonNull(ApiLoginType.getInstance(t.getLoginType()))) {
//            return t;
//        }
//        // header params 中获取
//        final LoginType loginType = this.getLoginType(req);
//        if (Objects.isNull(loginType)) {
//            throw new ParameterException(AppEnum.LOGIN_TYPE_ERROR);
//        }
//        t.setLoginType(loginType.getType());
//        return t;
//    }
//
//    /**
//     * 登录成功，生成token令牌
//     */
//    @Override
//    protected String onGenerateToken(AuthenticationToken t, Subject subject, HttpServletRequest req, HttpServletResponse resp) {
//        final LoginUser principal = (LoginUser) subject.getPrincipal();
//        // jwt 过期
//        final LocalDateTime expireTime = DateUtil.nowTime().plusDays(expire);
//        final Map<String, Object> payload = MapUtil.beanToMap(principal);
//        // 排除password字段
//        payload.remove("password");
//        payload.put(AppConst.EXP_KEY, expireTime.format(DateConsts.DATE_TIME_HH_MM_SS_SSS_FORMATTER));
//        final String token = JwtUtil.create(payload, secret);
//        // 根据登录类型设置token, 便于多realm登录 不被踢出
//        final String key = Filters.getTokenKey(tokenPrefixKey, principal);
//        // redis 过期
//        redisUtil.set(key, token, expire, TimeUnit.DAYS);
//        return token;
//    }
//
//    /**
//     * 校验token
//     */
//    @Override
//    public boolean verifyToken(String token, HttpServletRequest req, HttpServletResponse resp) {
//        log.debug("--> 校验token. {}", token);
//        final JwtData<LoginUser> j = JwtUtil.verify(token, secret, LoginUser.class, AppConst.EXP_KEY);
//        if (j.isSuccess() && Objects.nonNull(j.getData())) {
//            final LoginUser u = j.getData();
//            // 根据登录类型设置token, 便于多realm登录 不被踢出
//            final String key = Filters.getTokenKey(tokenPrefixKey, u);
//            final String redisToken = String.valueOf(redisUtil.get(key));
//            // 校验成功, 绑定subject; 避免多账号登录出现Subject不一致的问题
//            if (token.equals(redisToken)) {
//                ShiroUtil.bindSubject(u, u.getRealmName(), req.getSession().getId());
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private LoginType getLoginType(HttpServletRequest req) {
//        String loginTypeStr = req.getHeader(AppConst.LOGIN_TYPE);
//        if (StringUtil.isBlank(loginTypeStr)) {
//            loginTypeStr = req.getParameter(AppConst.LOGIN_TYPE);
//            if (StringUtil.isBlank(loginTypeStr)) {
//                log.error("Login request login_type is null. request uri: {}", req.getRequestURI());
//                return null;
//            }
//        }
//        try {
//            final int loginType = Integer.parseInt(loginTypeStr);
//            return ApiLoginType.getInstance(loginType);
//        } catch (NumberFormatException e) {
//            log.error("login type error. type is [{}], msg: {}, e: ", loginTypeStr, e.getMessage(), e);
//            return null;
//        }
//    }
//
//}
