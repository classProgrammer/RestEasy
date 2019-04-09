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
        StringGenerator generator = new StringGenerator();
        ContentWriter writer = new ContentWriter();
        StringBuilder sb = new StringBuilder();

        generator.addPackage(sb, config, "dao.implementation");

        String lowerCaseStart = config.getResourceName().substring(0, 1).toLowerCase() + config.getResourceName().substring(1);

        sb.append(
                        "import "+ config.getBasePackage() + ".domain." + config.getResourceName() + ";\n" +
                        "import javax.ejb.Stateless;\n" +
                        "import javax.persistence.EntityManager;\n" +
                        "import javax.persistence.PersistenceContext;\n" +
                        "import javax.persistence.TypedQuery;\n" +
                        "import java.util.List;\n" +
                        "\n" +
                        "@Stateless // V 1.0\n" +
                        "public class " + config.getResourceName() +"DaoBean implements " + config.getResourceName() + "Dao {\n" +
                        "\n" +
                        "    @PersistenceContext(unitName = \"TODO:\") // inject entity manager\n" +
                        "    private EntityManager em;\n" +
                        "\n" +
                        "    @Override\n" +
                        "    public " + config.getResourceName() + " findById(Long id) {\n" +
                        "        return em.find(" + config.getResourceName() + ".class, id);\n" +
                        "    }\n" +
                        "\n" +
                        "    @Override\n" +
                        "    public List<" + config.getResourceName() + "> findAll() {\n" +
                        "        TypedQuery<" + config.getResourceName() + "> selQry = em.createQuery(\"select c from " + config.getResourceName() + " c\", " + config.getResourceName() + ".class);\n" +
                        "        return selQry.getResultList();\n" +
                        "    }\n" +
                        "\n" +
                        "    @Override\n" +
                        "    public " + config.getResourceName() + " merge(" + config.getResourceName() + " " + lowerCaseStart + ") {\n" +
                        "        return em.merge(" + lowerCaseStart + ");\n" +
                        "    }\n" +
                        "\n" +
                        "    @Override\n" +
                        "    public void persist(" + config.getResourceName() + " " + lowerCaseStart + ") {\n" +
                        "        em.persist(" + lowerCaseStart + ");\n" +
                        "    }\n" +
                        "\n" +
                        "    @Override\n" +
                        "    public void remove(" + config.getResourceName() + " " + lowerCaseStart + ") {\n" +
                        "        em.remove(" + lowerCaseStart + ");\n" +
                        "    }\n" +
                        "}\n");

        writer.write(config.getPath() + "/dao/implementation", config.getResourceName() + "DaoBean", sb.toString());
    }

    public void generate(GenerationConfig config) {
        generateBaseDaoInteface(config);
        generateDaoInteface(config);
        generateDaoImplementation(config);
    }

}
