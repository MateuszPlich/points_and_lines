package model;

public class LineFlag {
    private final int lineId;
    private final boolean someBoolean;

    public LineFlag(int lineId, boolean someBoolean) {
        this.lineId = lineId;
        this.someBoolean = someBoolean;
    }

    public boolean isSomeBoolean() {
        return someBoolean;
    }

    public int getLineId() {
        return lineId;
    }

    @Override
    public String toString() {
        return "lineId= " + lineId +"\tsomeBoolean=" + someBoolean;
    }
}
