package org.tesso.skip.cart.data.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "org.tesso.skip.cart.data.repository")
public class DataConfig {

}
