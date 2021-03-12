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
 * @className: AdminApp
 * @description:
 * @author: zhi
 * @date: 2021/2/18
 * @version: 1.0
 */
@EnableBoot
@SpringBootApplication
public class AdminApp {

    public static void main(String[] args) {
        SpringApplication.run(AdminApp.class, args);
    }

}
