package sve.free.ex.gs.genconfig;

import javax.json.bind.annotation.JsonbProperty;
import java.util.ArrayList;

public class GenerationConfig {

    private String path;

    @JsonbProperty("resource-name")
    private String resourceName;

    @JsonbProperty("base-package")
    private String basePackage;

    private ArrayList<Property> Properties;

    public ArrayList<Property> getProperties() {
        return Properties;
    }

    public void setProperties(ArrayList<Property> properties) {
        Properties = properties;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    @Override
    public String toString() {
        return "GenerationConfig{" +
                "path='" + path + '\'' +
                ", resourceName='" + resourceName + '\'' +
                ", basePackage='" + basePackage + '\'' +
                '}';
    }
}
