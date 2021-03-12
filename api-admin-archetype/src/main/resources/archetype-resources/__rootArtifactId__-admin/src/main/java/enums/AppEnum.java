package ${package}.enums;

import com.wz.common.config.Resources;
import com.wz.common.exception.IErrorCode;

/**
 * @projectName: ${parentArtifactId}
 * @package: ${package}
 * @description:
 * @author: Zhi
 * @version: 1.0
 **/
public enum AppEnum implements IErrorCode {

    /**
     * 登录类型错误
     */
    LOGIN_TYPE_ERROR("0001"),

    ;

    private String code;

    AppEnum(String code) {
        this.code = code;
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return Resources.getMessage("i18n/app/app", this.code);
    }
}
