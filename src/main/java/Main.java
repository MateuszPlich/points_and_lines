import model.Line;
import model.LineFlag;
import model.Point;
import csvreader.CsvReaderLineFlags;
import csvreader.CsvReaderPoints;

import java.util.List;

public class Main {
    private static final String FILENAME = "onlyTrueLines.xml";
    private static final List<Point> POINTS = CsvReaderPoints.readPointsFromCsv("src/main/resources/csv/points.csv");
    private static final List<LineFlag> LINE_FLAGS = CsvReaderLineFlags.readLineFlagsFromCsv("src/main/resources/csv/lines.csv");

    public static void main(String[] args) {
        List<Line> onlyTrueLines = FileOperations.selectOnlyTrueLines(POINTS, LINE_FLAGS);
        FileOperations.writeDataToFile(FILENAME, onlyTrueLines);
        List<Line> dataFromFile = FileOperations.readDataFromFile(FILENAME);

        for (Line l : dataFromFile)
            System.out.println(l.toString());
    }
}



