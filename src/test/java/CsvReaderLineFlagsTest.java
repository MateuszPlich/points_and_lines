import csvreader.CsvReaderLineFlags;
import model.LineFlag;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class CsvReaderLineFlagsTest {

    @Test
    void readLineFlagsFromCsvTest() {
        //given
        String fileDirection = "src/test/resources/test_lines.csv";
        //when
        List<LineFlag> lineFlags = CsvReaderLineFlags.readLineFlagsFromCsv(fileDirection);
        List<LineFlag> lineWithLineId2 = lineFlags.stream()
                .filter(lineFlag -> lineFlag.getLineId() == 2)
                .collect(Collectors.toList());
        //then
        assertEquals(lineFlags.size(), 4);
        assertFalse(lineWithLineId2.get(0).isSomeBoolean());
    }
}
