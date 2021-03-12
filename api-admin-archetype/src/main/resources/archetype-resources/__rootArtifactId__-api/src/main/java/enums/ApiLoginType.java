//package ${package}.enums;
//
//import com.fasterxml.jackson.annotation.JsonTypeName;
//import com.wz.shiro.enums.LoginType;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @description:
// * @author: zhi
// * @version: 1.0
// */
//@JsonTypeName("apiLoginType")
//public enum ApiLoginType implements LoginType {
//    /**
//     * 公众号微信
//     */
//    WE_CHAT(1, "公众号"),
//    /**
//     * 手机号和密码
//     */
//    PHONE_PASSWORD(2, "手机号和密码"),
//
//    ;
//
//    private int type;
//
//    private String desc;
//
//    ApiLoginType(int type, String desc) {
//        this.type = type;
//        this.desc = desc;
//    }
//
//    /**
//     * 登录类型
//     */
//    @Override
//    public int getType() {
//        return type;
//    }
//
//    /**
//     * 类型名称
//     */
//    @Override
//    public String getName() {
//        return this.name();
//    }
//
//    public String getDesc() {
//        return desc;
//    }
//
//    private static final Map<Integer, ApiLoginType> MAP = new HashMap<>(values().length);
//
//    static {
//        for (ApiLoginType loginType : values()) {
//            MAP.put(loginType.type, loginType);
//        }
//    }
//
//    public static ApiLoginType getInstance(int type) {
//        return MAP.get(type);
//    }
//
//}
