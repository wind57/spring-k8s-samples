package sample;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final ConfigProperties configProperties;

    public Controller(ConfigProperties configProperties) {
        this.configProperties = configProperties;
    }

    @GetMapping("/value")
    public String getValue() {
        return configProperties.property();
    }
}
