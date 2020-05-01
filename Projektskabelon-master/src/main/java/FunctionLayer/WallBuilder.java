package FunctionLayer;

import java.util.ArrayList;

public class WallBuilder {
    public static ArrayList<Wall> addShedWalls(Carport carport){
        ArrayList<Wall> walls = new ArrayList<>();
        Wall side = new Wall();
        side.setSide("side");
        side.setLength(carport.getShed().getDepth());
        side.setRaising(carport.getRoof().getDegree());
        side.setMinHeight(carport.getConstructionHeight());

        Wall back = new Wall();
        back.setSide("back");
        back.setLength(carport.getShed().getWidth());
        back.setRaising(0);
        back.setMinHeight(carport.getConstructionHeight());

        Wall front = new Wall();
        front.setSide("front");
        front.setLength(carport.getShed().getWidth()-100);
        front.setRaising(0);
        front.setMinHeight(carport.getConstructionHeight());
        walls.add(side);
        walls.add(side);
        walls.add(front);
        walls.add(back);
        return walls;

    }
}
