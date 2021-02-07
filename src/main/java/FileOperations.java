import model.Line;
import model.LineFlag;
import model.Point;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileOperations {

    protected static void writeDataToFile(String fileName, List<Line> inputData) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(inputData);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected static List<Line> readDataFromFile(String fileName) {
        List<Line> listFromFile = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            listFromFile = (List<Line>) objectInputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listFromFile;
    }

    protected static List<Line> selectOnlyTrueLines(List<Point> points, List<LineFlag> lineFlags) {
        List<Line> trueLines = new ArrayList<>();
        for (Point point : points) {
            for (LineFlag lineFlag : lineFlags) {
                if (point.getLineId() == lineFlag.getLineId() && lineFlag.isSomeBoolean())
                    trueLines.add(new Line(point.getX(), point.getY(), lineFlag.isSomeBoolean()));
            }
        }
        return trueLines;
    }

}
