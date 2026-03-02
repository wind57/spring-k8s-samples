package sample;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final ConfigProperties configProperties;

    private final ConfigPropertiesWeird configPropertiesWeird;

    private final Environment env;

    public Controller(ConfigProperties configProperties, ConfigPropertiesWeird configPropertiesWeird,
            Environment env) {
        this.configProperties = configProperties;
        this.configPropertiesWeird = configPropertiesWeird;
        this.env = env;
    }

    @GetMapping("/value")
    public String getValue() {
        return configProperties.property();
    }

    @GetMapping("/valueWeird")
    public String getValueDev() {
        return configPropertiesWeird.property();
    }

    @GetMapping("/env")
    public String env() {
        return String.join(",", env.getActiveProfiles());
    }

}
