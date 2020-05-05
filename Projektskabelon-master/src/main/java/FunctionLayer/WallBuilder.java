package FunctionLayer;

import java.util.ArrayList;

/**
 * @author Magdalena
 */
public class WallBuilder {
    public static ArrayList<Wall> addShedWalls(Construction construction) {
        ArrayList<Wall> walls = new ArrayList<>();
        Wall right = new Wall();
        right.setSide("right");
        right.setLength(construction.getShed().getDepth());
        right.setRaising(construction.getRoof().getDegree());
        right.setMinHeight(construction.getConstructionHeight());

        Wall left = new Wall();
        left.setSide("left");
        left.setLength(construction.getShed().getDepth());
        left.setRaising(construction.getRoof().getDegree());
        left.setMinHeight(construction.getConstructionHeight());

        Wall back = new Wall();
        back.setSide("back");
        back.setLength(construction.getShed().getWidth());
        back.setRaising(0);
        back.setMinHeight(construction.getConstructionHeight());

        Wall front = new Wall();
        front.setSide("front");
        front.setLength(construction.getShed().getWidth() - 100);
        front.setRaising(0);
        front.setMinHeight(construction.getConstructionHeight());

        walls.add(right);
        walls.add(left);
        walls.add(front);
        walls.add(back);

        return walls;

    }

    public static ArrayList<Wall> addCarportWalls(Construction construction, String[] constructionswalls) {
        ArrayList<Wall> carportWalls = new ArrayList<>();

        String side = "";
        int wallLength = 0;
        int raising = 0;
        int minHeight = 0;

        if (construction.getRoof().getIsPitched() || side.equals("back") || side.equals("front")) {
            raising = 0;
        } else {
            raising = construction.getRoof().getDegree();
        }

        for (int i = 0; i < constructionswalls.length; i++) {
            Wall extraWall = new Wall();
            if (constructionswalls[i].equals("back")) {
                /*
                builds a wall on the backside where it's length is a difference betwin carpor width anfd shed width
                if shed is as width as whole carport, the wall gets 0 as length
                 */
                wallLength = construction.getCarportWidth() - construction.getShed().getWidth();
                minHeight = construction.getConstructionHeight();
                side = "back";

            } else {
                side = constructionswalls[i];
                //todo find out if the wall is shared with shed
                if (construction.getCarportWidth() == construction.getShed().getWidth()
                        || construction.getShed().getSide().equals(constructionswalls[i])) {
                    wallLength = construction.getCarportLength();
                    minHeight = ConstructionSizeCalculator.carportMinHeight(construction.getConstructionHeight(),
                            construction.getShed().getDepth(), raising);

                } else {
                    wallLength = construction.getCarportLength() + construction.getShed().getDepth() - 100;
                    minHeight = construction.getConstructionHeight();

                }


            }
            extraWall.setSide(side);
            extraWall.setLength(wallLength);
            extraWall.setMinHeight(minHeight);
            extraWall.setRaising(raising);

            carportWalls.add(extraWall);


        } return carportWalls;

    }
}
