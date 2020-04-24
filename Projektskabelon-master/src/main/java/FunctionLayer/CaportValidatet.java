package FunctionLayer;

public class CaportValidatet extends Carport{
    private int shedDepth;
    private int angle;
    private int shedWidth;
    private boolean pitchedRoof;
    private Shed shed;
    private Roof roof;

    public CaportValidatet(int length, int width,  int shedDepth, int angle, int shedWidth, boolean pitchedRoof) {
        super(width,length);
        this.shedDepth = shedDepth;
        this.angle = angle;
        this.shedDepth = shedDepth;
        this.pitchedRoof = pitchedRoof;
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
