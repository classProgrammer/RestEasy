package sve.free.ex.gs.generator.writer;

import sve.free.ex.gs.genconfig.GenerationConfig;
import sve.free.ex.gs.genconfig.Property;

import javax.ejb.Local;

@Local // V 1.0
public class StringGenerator {

    public void addPackage(StringBuilder sb, GenerationConfig config, String packageName) {
        sb.append("package " + config.getBasePackage() + "." + packageName + ";\n");
    }

    public void addBaseDomainImports(StringBuilder sb) {
        sb.append("import javax.persistence.Entity;\n" +
                "import javax.persistence.GeneratedValue;\n" +
                "import javax.persistence.Id;\n");
    }

    public void addClass(StringBuilder sb, GenerationConfig config) {
        sb.append("@Entity\n");
        sb.append("public class " + config.getResourceName() + " {\n\n");
        sb.append(
                "    @Id\n" +
                "    @GeneratedValue\n" +
                "    private Long id;\n\n" +
                "    public void setId(Long id) {\n" +
                "        this.id = id;\n" +
                "    }\n\n" +
                "    public Long getId() {\n" +
                "        return id;\n" +
                "    }\n\n");
    }

    public void addEnd(StringBuilder sb) {
        sb.append("}\n");
    }


    public void addProperty(StringBuilder sb, Property p) {
        String upperKey = p.getKey().substring(0, 1).toUpperCase() + p.getKey().substring(1);


        sb.append("    private " + p.getType() + " " + p.getKey() + ";\n\n");
        sb.append("    public " + p.getType() +  " get" + upperKey + "() {\n" +
                  "        return " + p.getKey() + ";\n" +
                  "    }\n\n");
        sb.append("    public void set" + upperKey + "(String "+ p.getKey() + ") {\n" +
                  "        this."+ p.getKey() + " = " + p.getKey() + ";\n" +
                  "    }\n\n");
    }
}
