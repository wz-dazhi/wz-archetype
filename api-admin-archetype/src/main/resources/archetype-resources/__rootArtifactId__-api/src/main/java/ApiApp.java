#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import com.wz.common.annotation.EnableBoot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @projectName: ${parentArtifactId}
 * @package: ${package}
 * @className: ApiApp
 * @description:
 * @author: zhi
 * @version: 1.0
 */
@EnableBoot
@SpringBootApplication
public class ApiApp {

    public static void main(String[] args) {
        SpringApplication.run(ApiApp.class, args);
    }

}
