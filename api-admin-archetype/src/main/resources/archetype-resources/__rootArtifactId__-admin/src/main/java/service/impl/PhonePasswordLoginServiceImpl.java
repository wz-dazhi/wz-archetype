//package ${package}.service.impl;
//
//import ${package}.enums.AppEnum;
//import ${package}.shiro.ApiShiroToken;
//import ${package}.shiro.LoginUser;
//import ${package}.enums.ApiLoginType;
//import ${package}.service.LoginService;
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.shiro.authc.IncorrectCredentialsException;
//import org.apache.shiro.authc.UnknownAccountException;
//import org.springframework.stereotype.Service;
//
///**
// * @package: ${package}.service.impl
// * @className: PhonePasswordLoginServiceImpl
// * @description:
// * @author: zhi
// * @version: 1.0
// */
//@Slf4j
//@AllArgsConstructor
//@Service("phonePasswordLoginService")
//public class PhonePasswordLoginServiceImpl implements LoginService {
//
//    @Override
//    public LoginUser login(ApiShiroToken t) {
//        log.info("---> 开始账号密码登录. {}", t);
//        // 模拟数据库查询
////        if (!"zhangsan".equals(t.getUsername())) {
////            throw new UnknownAccountException(AppEnum.USER_UNKNOWN.getMsg());
////        }
////        if (!"123456".equals(String.valueOf(t.getPassword()))) {
////            throw new IncorrectCredentialsException(AppEnum.PASSWORD_ERROR.getMsg());
////        }
//
//        // 数据库中的密码
//        String dbPassword = "e10adc3949ba59abbe56e057f20f883e";
//        return LoginUser.builder()
//                .id(1L)
//                .nickname(t.getUsername())
//                .loginType(ApiLoginType.PHONE_PASSWORD)
//                .password(dbPassword)
//                .build();
//    }
//}
