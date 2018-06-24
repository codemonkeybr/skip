package org.tesso.skip.product;


import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;
import java.util.List;

import static org.tesso.skip.product.resources.common.Path.ROOT_PATH;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    private static final String PATH = ROOT_PATH + "/.*";

    private static final String API_DESCRIPTION = "Swagger API";

    @Value("${server.version}")
    private String serverVersion;

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${keycloak.realm}")
    private String realm;

    @Value("${swagger.auth.token-url:}")
    private String authTokenUrl;

    @Value("${swagger.auth.client-id:}")
    private String authClientId;

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .paths(PathSelectors.regex(PATH))
                .build()
                .securityContexts(Lists.newArrayList(securityContext()))
                .securitySchemes(Lists.newArrayList(securitySchema()));
    }

    @Bean
    public SecurityConfiguration securityConfiguration() {
        return new SecurityConfiguration(authClientId, "", realm, "", "", Collections.emptyMap(), false);
    }

    private OAuth securitySchema() {
        List<GrantType> grantTypes = Lists.newArrayList(new ResourceOwnerPasswordCredentialsGrant(authTokenUrl));
        return new OAuth("oauth2", Collections.EMPTY_LIST, grantTypes);
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(Lists.newArrayList(new SecurityReference("oauth2", new AuthorizationScope[0])))
                .forPaths(PathSelectors.regex(PATH))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(applicationName)
                .description(API_DESCRIPTION)
                .version(serverVersion)
                .build();
    }
}
