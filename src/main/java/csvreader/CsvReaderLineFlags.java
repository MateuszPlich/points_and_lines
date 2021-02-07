package csvreader;

import model.LineFlag;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvReaderLineFlags {


    public static List<LineFlag> readLineFlagsFromCsv(String filename) {
        List<LineFlag> lines = new ArrayList<>();
        Path pathToFile = Paths.get(filename);

        try {
            BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);
            String readline = br.readLine();
            while (readline != null) {
                String[] attributes = readline.split(";");
                LineFlag lineFlag = createLine(attributes);
                lines.add(lineFlag);
                readline = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private static LineFlag createLine(String[] metadata) {
        int line_id = Integer.parseInt(metadata[0]);
        boolean some_boolean = Boolean.parseBoolean(metadata[1]);

        return new LineFlag(line_id, some_boolean);
    }
}
