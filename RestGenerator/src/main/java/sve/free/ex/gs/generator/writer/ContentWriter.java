package sve.free.ex.gs.generator.writer;

import sve.free.ex.gs.generator.writer.definition.Writer;

import javax.ejb.Local;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Local // V 1.0
public class ContentWriter implements Writer {
    public void write(String path, String filename, String content) {

        String fullPath = path + "/" + filename + ".java";

        File directory = new File(path);
        if (!directory.exists()){
            directory.mkdirs();
        }

        try(FileWriter fileWriter = new FileWriter(fullPath)) {
            fileWriter.write(content);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
