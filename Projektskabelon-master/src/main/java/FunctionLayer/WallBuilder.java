package FunctionLayer;

import java.util.ArrayList;

public class WallBuilder {
    public static ArrayList<Wall> addShedWalls(Construction construction){
        ArrayList<Wall> walls = new ArrayList<>();
        Wall side = new Wall();
        side.setSide("side");
        side.setLength(construction.getShed().getDepth());
        side.setRaising(construction.getRoof().getDegree());
        side.setMinHeight(construction.getConstructionHeight());

        Wall back = new Wall();
        back.setSide("back");
        back.setLength(construction.getShed().getWidth());
        back.setRaising(0);
        back.setMinHeight(construction.getConstructionHeight());

        Wall front = new Wall();
        front.setSide("front");
        front.setLength(construction.getShed().getWidth()-100);
        front.setRaising(0);
        front.setMinHeight(construction.getConstructionHeight());
        walls.add(side);
        walls.add(side);
        walls.add(front);
        walls.add(back);
        return walls;

    }
}
