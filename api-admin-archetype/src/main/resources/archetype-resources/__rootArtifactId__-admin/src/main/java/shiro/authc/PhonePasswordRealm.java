//package ${package}.shiro.authc;
//
//import com.wz.shiro.authc.AbstractShiroRealm;
//import ${package}.shiro.ApiShiroToken;
//import ${package}.shiro.LoginUser;
//import ${package}.enums.ApiLoginType;
//import ${package}.service.LoginService;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authc.SimpleAuthenticationInfo;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.crypto.hash.Md5Hash;
//import org.apache.shiro.subject.PrincipalCollection;
//
//import javax.annotation.Resource;
//
///**
// * @className: PhonePasswordRealm
// * @description:
// * @author: zhi
// * @version: 1.0
// */
//@Slf4j
//public class PhonePasswordRealm extends AbstractShiroRealm {
//    @Resource(name = "phonePasswordLoginService")
//    private LoginService loginService;
//
//    @Override
//    public boolean supports(AuthenticationToken token) {
//        return token instanceof ApiShiroToken && ApiLoginType.PHONE_PASSWORD.getType() == ((ApiShiroToken) token).getLoginType();
//    }
//
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        final ApiShiroToken t = (ApiShiroToken) token;
//        final LoginUser loginUser = loginService.login(t);
//        loginUser.setRealmName(this.getName());
//        return new SimpleAuthenticationInfo(loginUser, loginUser.getPassword(), loginUser.getRealmName());
//    }
//
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        return null;
//    }
//
//    public static void main(String[] args) {
//        String password = "123456";
//        Md5Hash md5 = new Md5Hash(password);
//        // e10adc3949ba59abbe56e057f20f883e
//        System.out.println(md5.toHex());
//    }
//}
