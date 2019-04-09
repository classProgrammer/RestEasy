package sve.free.ex.gs.generator.writer;

import sve.free.ex.gs.genconfig.GenerationConfig;

public class DaoGenerator {


    private void generateBaseDaoInteface(GenerationConfig config) {
        StringGenerator generator = new StringGenerator();
        ContentWriter writer = new ContentWriter();
        StringBuilder sb = new StringBuilder();

        generator.addPackage(sb, config, "dao.definition");

        sb.append(
                "import javax.ejb.Local;\n" +
                "import java.util.List;\n" +
                "\n" +
                "@Local // V 1.0\n" +
                "public interface BaseDao<T> {\n" +
                "    T findById(Long id);\n" +
                "    List<T> findAll();\n" +
                "\n" +
                "    T merge(T obj);\n" +
                "    void persist(T obj);\n" +
                "    void remove(Long id);\n" +
                "}");


        writer.write(config.getPath() + "/dao/definition", "BaseDao", sb.toString());
    }

    private void generateDaoInteface(GenerationConfig config) {
        StringGenerator generator = new StringGenerator();
        ContentWriter writer = new ContentWriter();
        StringBuilder sb = new StringBuilder();

        generator.addPackage(sb, config, "dao.definition");

        sb.append(
                        "import "+ config.getBasePackage() + ".domain." + config.getResourceName() + ";\n" +
                        "import javax.ejb.Local;\n" +
                        "\n" +
                        "@Local // V 1.0\n" +
                        "public interface " + config.getResourceName() + "Dao extends BaseDao<" + config.getResourceName() + "> {\n" +
                        "}\n");

        writer.write(config.getPath() + "/dao/definition", config.getResourceName() + "Dao", sb.toString());
    }

    private void generateDaoImplementation(GenerationConfig config) {

    }

    public void generate(GenerationConfig config) {
        generateBaseDaoInteface(config);
        generateDaoInteface(config);
        generateDaoImplementation(config);
    }

}
