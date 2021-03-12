//package ${package}.service.impl;
//
//import com.wz.shiro.bean.ShiroProperties;
//import com.wz.shiro.util.ShiroUtil;
//import ${package}.shiro.ApiShiroToken;
//import ${package}.shiro.LoginUser;
//import ${package}.enums.ApiLoginType;
//import ${package}.service.LoginService;
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
///**
// * @package: ${package}.service.impl
// * @className: WeChatLoginServiceImpl
// * @description:
// * @author: zhi
// * @version: 1.0
// */
//@Slf4j
//@AllArgsConstructor
//@Service("weChatLoginService")
//public class WeChatLoginServiceImpl implements LoginService {
//    private final ShiroProperties shiroProperties;
//
//    @Override
//    public LoginUser login(ApiShiroToken t) {
//
//        final String shaPassword = ShiroUtil.simpleHash(shiroProperties.getAlgorithm().getAlgorithmName(), shiroProperties.getHashIterations(), String.valueOf(t.getPassword()), null);
//        return LoginUser.builder()
//                .id(1L)
//                .nickname(t.getUsername())
//                .loginType(ApiLoginType.WE_CHAT)
//                .password(shaPassword)
//                .build();
//    }
//
//}
