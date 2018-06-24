package org.tesso.skip.cart.data.common;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.tesso.skip.cart.data.config.DataConfig;

@Configuration
@Import(value = { DataConfig.class })
@EntityScan(basePackages = "org.tesso.skip.cart.common.entities")
@ComponentScan(basePackages = "org.tesso.skip.cart")
@EnableAutoConfiguration
public class DataTestConfig {

}
