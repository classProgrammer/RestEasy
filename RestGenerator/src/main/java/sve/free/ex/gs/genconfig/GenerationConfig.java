package sve.free.ex.gs.genconfig;

import javax.json.bind.annotation.JsonbProperty;
import javax.validation.constraints.NotBlank;

public class GenerationConfig {

    @NotBlank(message = "First Name must not be null or empty")
    private String path;

    @NotBlank(message = "First Name must not be null or empty")
    @JsonbProperty("resource-name")
    private String resourceName;

    @NotBlank(message = "First Name must not be null or empty")
    @JsonbProperty("base-package")
    private String basePackage;

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
}
