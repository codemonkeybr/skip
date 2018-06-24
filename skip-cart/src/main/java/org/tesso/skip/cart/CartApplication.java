package org.tesso.skip.cart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class CartApplication {

    private static final Logger logger = LoggerFactory.getLogger(CartApplication.class);

    public static void main(String[] args) throws UnknownHostException {
        ApplicationContext app = SpringApplication.run(CartConfig.class, args);

        String name = app.getEnvironment().getProperty("spring.application.name");
        String port = app.getEnvironment().getProperty("server.port");
        String hostAddress = InetAddress.getLocalHost().getHostAddress();
        String version = app.getEnvironment().getProperty("server.version");
        String contextPath = app.getEnvironment().getProperty("server.servlet.contextPath");
        String[] profiles = app.getEnvironment().getActiveProfiles();

        if (contextPath == null) {
            contextPath = "/";
        }

        logger.info("\n----------------------------------------------------------\n" +
                        "Application '{}' is running!\n\t" +
                        "Local: \t\thttp://127.0.0.1:{}{}\n\t" +
                        "External: \thttp://{}:{}{}\n\t" +
                        "Version: \t{}\n\t" +
                        "Profile(s): {}\n" +
                        "----------------------------------------------------------",
                name, port, contextPath, hostAddress, port, contextPath, version, profiles);
    }
}
