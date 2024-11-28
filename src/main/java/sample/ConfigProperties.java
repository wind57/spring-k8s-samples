package sample;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "my")
public class ConfigProperties {

    private String property;

    public String property() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }
}
