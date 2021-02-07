package csvreader;

import model.Point;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvReaderPoints {

    public static List<Point> readPointsFromCsv(String filename) {
        List<Point> points = new ArrayList<>();
        Path pathToFile = Paths.get(filename);

        try {
            BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII);
            String line = br.readLine();
            while (line != null) {
                String[] attributes = line.split(";");
                Point point = createPoint(attributes);
                points.add(point);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return points;
    }

    private static Point createPoint(String[] metadata) {
        float x = Float.parseFloat(metadata[0]);
        float y = Float.parseFloat(metadata[1]);
        int line_id = Integer.parseInt(metadata[2]);

        return new Point(x, y, line_id);
    }
}
