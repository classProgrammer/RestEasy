package sve.free.ex.gs.generator.writer;

import sve.free.ex.gs.genconfig.GenerationConfig;
import sve.free.ex.gs.genconfig.Property;

import javax.ejb.Local;
import javax.inject.Inject;

@Local // V 1.0
public class DomainGenerator {
    @Inject
    private ContentWriter writer;

    @Inject
    private StringGenerator generator;

    public void generate(GenerationConfig config) {
        StringGenerator generator = new StringGenerator();
        ContentWriter writer = new ContentWriter();
        StringBuilder sb = new StringBuilder();

        generator.addPackage(sb, config, "domain");
        generator.addBaseDomainImports(sb);
        generator.addClass(sb, config);

        for (Property p : config.getProperties()) {
            generator.addProperty(sb, p);
        }

        generator.addEnd(sb);

        writer.write(config.getPath() + "/domain", config.getResourceName(), sb.toString());
    }

    public void test(GenerationConfig config) {
        ContentWriter writer = new ContentWriter();

        writer.write(config.getPath() + "/domain", config.getResourceName(), "Kablaem");
    }

}
