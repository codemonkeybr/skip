package org.tesso.skip.product.data.common;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.tesso.skip.product.data.config.DataConfig;

@Configuration
@Import(value = { DataConfig.class })
@EntityScan(basePackages = "org.tesso.skip.product.common.entities")
@ComponentScan(basePackages = "org.tesso.skip.product")
@EnableAutoConfiguration
public class DataTestConfig {

}
