package model;

import java.io.Serializable;

public class Line implements Serializable {
    private final float x;
    private final float y;
    private final boolean someFlag;

    public Line(float x, float y, boolean someFlag) {
        this.x = x;
        this.y = y;
        this.someFlag = someFlag;
    }

    public boolean isSomeFlag() {
        return someFlag;
    }

    @Override
    public String toString() {
        return "x= "+x+"\ty= "+y+"\tsomeFlag= " + someFlag;
    }
}
