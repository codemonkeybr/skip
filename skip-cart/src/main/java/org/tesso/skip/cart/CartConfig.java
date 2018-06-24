package org.tesso.skip.cart;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@ComponentScan(basePackages = {"org.tesso.skip"})
@Configuration
@Import({SwaggerConfig.class})
public class CartConfig {
}
