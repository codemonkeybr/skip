package org.tesso.skip.product.data.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "org.tesso.skip.product.data.repository")
public class DataConfig {

}
