package FunctionLayer;

import sun.security.internal.spec.TlsKeyMaterialSpec;

import java.util.ArrayList;

public class Roof {
    private int height;
    private int degree;
    private boolean pitchedRoof;

    public Roof(int height, int degree, boolean pitchedRoof) {
        this.height = height;
        this.degree = degree;
        this.pitchedRoof = pitchedRoof;
    }

    public int getHeight() {
        return height;
    }

    public int getDegree() {
        return degree;
    }

    public boolean isPitchedRoof() {
        return pitchedRoof;
    }
}
