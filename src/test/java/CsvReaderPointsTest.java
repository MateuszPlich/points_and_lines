import model.Point;
import csvreader.CsvReaderPoints;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CsvReaderPointsTest {

    @Test
    public void readPointsFromCsvTest() {
        //given
        String fileDirection = "src/test/resources/test_points.csv";
        //when
        List<Point> pointsList = CsvReaderPoints.readPointsFromCsv(fileDirection);

        List<Point> pointWithLineId2 = pointsList.stream()
                .filter(point -> point.getLineId() == 2)
                .collect(Collectors.toList());
        //then
        assertEquals(pointsList.size(), 3);
        assertEquals(pointWithLineId2.size(), 1);
    }
}
