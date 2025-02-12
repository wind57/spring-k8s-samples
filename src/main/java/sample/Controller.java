package sample;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
public class Controller {

    private final ConfigProperties configProperties;

    private final ConfigPropertiesDev configPropertiesDev;

    private final Environment env;

    public Controller(ConfigProperties configProperties, ConfigPropertiesDev configPropertiesDev,
            Environment env) {
        this.configProperties = configProperties;
        this.configPropertiesDev = configPropertiesDev;
        this.env = env;
    }

    @GetMapping("/value")
    public String getValue() {
        return configProperties.property();
    }

    @GetMapping("/valueDev")
    public String getValueDev() {
        return configPropertiesDev.property();
    }

    @GetMapping("/env")
    public String env() {
        return String.join(",", env.getActiveProfiles());
    }

}
