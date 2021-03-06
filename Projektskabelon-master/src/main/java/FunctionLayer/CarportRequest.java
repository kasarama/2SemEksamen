package FunctionLayer;

public class CarportRequest {
    private int length;
    private int width;
    private int shedDepth;
    private int angle;

    public CarportRequest(int length, int width,  int shedDepth, int angle) {
        this.length = length;
        this.width = width;
        this.shedDepth = shedDepth;
        this.angle = angle;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getShedDepth() {
        return shedDepth;
    }

    public void setShedDepth(int shedDepth) {
        this.shedDepth = shedDepth;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }
}