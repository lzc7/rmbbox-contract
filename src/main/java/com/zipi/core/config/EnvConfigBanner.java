package com.zipi.core.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.ansi.AnsiColor;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.io.PrintStream;

/**
 * @author liangyu
 * @date 2018/7/15
 */
@Slf4j
public class EnvConfigBanner implements Banner {
    private static final String[] BANNER = {
            "================ BBT CONTRACT SERVER ===============",
            "   SPRING_BOOT_VERSION : ",
            "   APPLICATION_ENVIRONMENT : ",
            "   DATASOURCE_URL : ",
            "   APPLICATION_PID : ",

            "   OS_NAME : ",
            "   OS_VERSION : ",
            "   USER_HOME : ",
            "   USER_TIMEZONE : ",
            "   JAVA_VERSION : ",
            "   JAVA_VM_NAME : ",
            "====================================================" };

    @Override
    public void printBanner(Environment environment, Class<?> sourceClass, PrintStream printStream) {


        MutablePropertySources mutablePropertySources = ((AbstractEnvironment) environment).getPropertySources();

        //load applicationConfigurationProperties
        PropertySource<?> applicationConfigurationProperties = mutablePropertySources.get("applicationConfigurationProperties");
        String environmentName = (String)applicationConfigurationProperties.getProperty("environment.name");
        String databaseUrl = (String)applicationConfigurationProperties.getProperty("spring.datasource.url");

        //loan system config
        PropertySource<?> systemProperties = mutablePropertySources.get("systemProperties");
        String osName = (String)systemProperties.getProperty("os.name");
        String osVersion = (String)systemProperties.getProperty("os.version");
        String userHome = (String)systemProperties.getProperty("user.home");
        String userTimezone = (String)systemProperties.getProperty("user.timezone");
        String pid = (String)systemProperties.getProperty("PID");
        String javaVersion = (String)systemProperties.getProperty("java.version");
        String javaVMName = (String)systemProperties.getProperty("java.vm.name");

        String version = SpringBootVersion.getVersion();

        StringBuilder builder = new StringBuilder();

        builder.append(BANNER[0]).append(System.lineSeparator());
        builder.append(BANNER[1]).append(version).append(System.lineSeparator());
        builder.append(BANNER[2]).append(environmentName).append(System.lineSeparator());
        builder.append(BANNER[3]).append(databaseUrl).append(System.lineSeparator());
        builder.append(BANNER[4]).append(pid).append(System.lineSeparator());

        builder.append(System.lineSeparator());
        builder.append(BANNER[5]).append(osName).append(System.lineSeparator());
        builder.append(BANNER[6]).append(osVersion).append(System.lineSeparator());
        builder.append(BANNER[7]).append(userHome).append(System.lineSeparator());
        builder.append(BANNER[8]).append(userTimezone).append(System.lineSeparator());
        builder.append(BANNER[9]).append(javaVersion).append(System.lineSeparator());
        builder.append(BANNER[10]).append(javaVMName).append(System.lineSeparator());

        builder.append(BANNER[11]).append(System.lineSeparator());

        printStream.print(AnsiOutput.toString(AnsiColor.BRIGHT_BLUE, builder.toString()));

        printStream.println();
    }
}
