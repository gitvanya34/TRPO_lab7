package ru.volsu.qa.ui.config;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Configuration
@ComponentScan( basePackages = "ru.volsu" )
@PropertySource("classpath:config.properties")
public class Config {

    @Value("${baseUrl}")
    private String baseUrl;

    @Value("${baseTimeout}")
    private int baseTimeout;

    @Bean(name = "webdriver")
    public WebDriver webDriver() {
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.gecko.driver", path + "/geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--start-maximized");
        return new FirefoxDriver(options);

    }
}
