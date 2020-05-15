package FunctionLayer;

import java.util.ArrayList;

/**
 * @author Magdalena
 */
public class WallBuilder {

    private final static int DOORSIZE = 1000;
    private final static int POSTWIDTH = 100;

    public static int frontWallHeight(Construction construction) {
        int tilt = construction.getRoof().getTilt();
        int shedDepth = construction.getShedDepth();
        double raising = ConstructionSizeCalculator.raising(shedDepth, tilt);
        int height = construction.getConstructionHeight() + (int) raising;
        return height;
    }

    public static ArrayList<Wall> addShedWalls(Construction construction) {
        ArrayList<Wall> walls = new ArrayList<>();
        if (construction.getShedDepth() != 0) {

            Wall right = new Wall();
            right.setSide("right");
            right.setLength(construction.getShedDepth());
            right.setRaising(construction.getRoof().getTilt());
            right.setMinHeight(construction.getConstructionHeight());

            Wall left = new Wall();
            left.setSide("left");
            left.setLength(construction.getShedDepth());
            left.setRaising(construction.getRoof().getTilt());
            left.setMinHeight(construction.getConstructionHeight());

            Wall back = new Wall();
            back.setSide("back");
            back.setLength(construction.getShed().getWidth());
            back.setRaising(0);
            back.setMinHeight(construction.getConstructionHeight());

            Wall front = new Wall();
            front.setSide("front");
            front.setLength(construction.getShed().getWidth() - DOORSIZE);
            front.setRaising(0);
            front.setMinHeight(frontWallHeight(construction));

            walls.add(right);
            walls.add(left);
            walls.add(front);
            walls.add(back);
        }
        return walls;

    }

    public static ArrayList<Wall> createCarportWalls(Construction construction, ArrayList<String> sides) {
        ArrayList<Wall> carportWalls = new ArrayList<>();
        if (sides.size() == 0) {
            return carportWalls;
        } else {
            String side = "";
            int wallLength = 0;
            int raising = construction.getRoof().getTilt();
            int minHeight = 0;


            if (construction.getShedDepth() == 0) {
                for (String wallSide : sides) {
                    if (wallSide.equals("back")) {

                        wallLength = construction.getCarportWidth();
                        minHeight = construction.getConstructionHeight();
                        side = "back";
                        raising=0;
                    } else {
                        wallLength = construction.getCarportLength();
                        minHeight = construction.getConstructionHeight();
                        side = wallSide;
                    }
                    Wall wall = new Wall();
                    wall.setRaising(raising);
                    wall.setMinHeight(minHeight);
                    wall.setLength(wallLength);
                    wall.setSide("carport" + side);
                    carportWalls.add(wall);
                }
            } else {

                for (String wallSide : sides) {

                    if (wallSide.equals("back") && construction.getCarportWidth() > construction.getShedDepth()) {
                        wallLength = construction.getShed().getWidth();
                        minHeight = construction.getConstructionHeight();
                        side = "back";
                        Wall wall = new Wall();
                        wall.setRaising(0);
                        wall.setMinHeight(minHeight);
                        wall.setLength(wallLength);
                        wall.setSide("carport" + side);
                        carportWalls.add(wall);
                    } else if (wallSide.equals(construction.getShed().getSide())) {
                        wallLength = construction.getCarportLength();
                        minHeight = ConstructionSizeCalculator.carportMinHeight(construction.getConstructionHeight(),
                                construction.getShedDepth()-POSTWIDTH, construction.getRoof().getTilt());
                        side = wallSide;
                        Wall wall = new Wall();
                        wall.setRaising(raising);
                        wall.setMinHeight(minHeight);
                        wall.setLength(wallLength);
                        wall.setSide("carport" + side);
                        carportWalls.add(wall);
                    } else {
                        Wall carportWall = new Wall();
                        wallLength = construction.getCarportLength();
                        minHeight = ConstructionSizeCalculator.carportMinHeight(construction.getConstructionHeight(),
                                construction.getShedDepth()-100, construction.getRoof().getTilt());
                        side = wallSide;
                        carportWall.setRaising(raising);
                        carportWall.setMinHeight(minHeight);
                        carportWall.setLength(wallLength);
                        carportWall.setSide("carport" + side);
                        carportWalls.add(carportWall);

                        if (construction.getShed().getWidth() != construction.getCarportWidth()) {
                            Wall likeShedWall = new Wall();
                            likeShedWall.setSide("likeShed" + wallSide);
                            likeShedWall.setLength(construction.getShedDepth());
                            likeShedWall.setMinHeight(construction.getConstructionHeight());
                            likeShedWall.setRaising(raising);
                            carportWalls.add(likeShedWall);
                        }

                    }

                }
            }

            for (Wall wa :
                    carportWalls) {
            }
            return carportWalls;
        }
    }

}