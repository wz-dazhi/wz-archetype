//package ${package}.shiro;
//
//import com.fasterxml.jackson.annotation.JsonAlias;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.hibernate.validator.constraints.Range;
//
///**
// * @className: ApiShiroToken
// * @description:
// * @author: zhi
// * @version: 1.0
// */
//@EqualsAndHashCode(callSuper = true)
//@Data
//@ApiModel("shiro登录")
//public class ApiShiroToken extends UsernamePasswordToken {
//
//    @ApiModelProperty("登录类型：1-公众号, 2-手机号和密码")
//    @Range(min = 1, max = 2, message = "{apiShiroToken.loginType.Range}")
//    private int loginType;
//
//    @ApiModelProperty("手机号, 微信code")
//    @JsonAlias({"phone", "code"})
//    private String username;
//
//    @ApiModelProperty("密码, 微信code可以不填")
//    private char[] password;
//
//    @ApiModelProperty(hidden = true)
//    @JsonIgnore
//    private boolean rememberMe = false;
//    @ApiModelProperty(hidden = true)
//    @JsonIgnore
//    private String host;
//}
