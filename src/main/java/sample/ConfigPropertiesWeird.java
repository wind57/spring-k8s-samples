package sample;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "my.weird")
public class ConfigPropertiesWeird {

    private String property;

    public String property() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

}
