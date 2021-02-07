import model.Line;
import model.LineFlag;
import model.Point;
import csvreader.CsvReaderLineFlags;
import csvreader.CsvReaderPoints;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FileOperationsTest {
    List<Line> inputData;
    String filename = "src/test/output/filename.xml";

    @BeforeEach
    public void init() {
        //given
        inputData = new ArrayList<>();
        inputData.add(new Line(1, 1, true));
        inputData.add(new Line(2, 2, false));
        inputData.add(new Line(2, 3, true));
    }

    @Test
    public void checkIfInputListSizeIsEqualToOutputListSize() {
        //when
        FileOperations.writeDataToFile(filename, inputData);
        List<Line> outputData = FileOperations.readDataFromFile(filename);
        //then
        assertEquals(outputData.size(), inputData.size());
    }

    @Test
    public void checkIfOutputListIsNotEmpty() {
        //when
        FileOperations.writeDataToFile(filename, inputData);
        List<Line> outputData = FileOperations.readDataFromFile(filename);
        //then
        assertEquals(outputData.size(), 3);
    }

    @Test
    public void selectOnlyTrueLinesTest() {
        //given
        List<Point> points = CsvReaderPoints.readPointsFromCsv("src/test/resources/test_points.csv");
        List<LineFlag> lineFlags = CsvReaderLineFlags.readLineFlagsFromCsv("src/test/resources/test_lines.csv");
        //when
        List<Line> onlyTrueLineList = FileOperations.selectOnlyTrueLines(points, lineFlags);
        boolean areAllLinesTrue = onlyTrueLineList.stream().allMatch(Line::isSomeFlag);
        //then
        assertTrue(areAllLinesTrue);
    }


}
