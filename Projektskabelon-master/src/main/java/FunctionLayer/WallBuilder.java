package FunctionLayer;

import java.util.ArrayList;

/**
 * @author Magdalena
 */
public class WallBuilder {
    public static ArrayList<Wall> addShedWalls(Construction construction) {
        ArrayList<Wall> walls = new ArrayList<>();
        if (construction.getShed().getDepth()!=0) {

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
        }
        return walls;

    }

    public static ArrayList<Wall> addConstructionWalls(Construction construction, String[] constructionswalls) {
        ArrayList<Wall> carportWalls = new ArrayList<>();

        if (constructionswalls.length == 0) {
            return carportWalls;
        } else {

            String side = "";
            int wallLength = 0;
            int raising = 0;
            int minHeight = 0;

            if (construction.getRoof().getIsPitched() || side.equals("back")) {
                raising = 0;
            } else {
                raising = construction.getRoof().getDegree();
            }


            if (construction.getShed().getDepth() == 0) {
                for (int i = 0; i < constructionswalls.length; i++) {
                    if (constructionswalls[i].equals("back")) {

                        wallLength = construction.getCarportWidth();
                        minHeight = construction.getConstructionHeight();
                        side = "back";
                    } else {
                        wallLength = construction.getCarportLength();
                        minHeight = construction.getConstructionHeight();
                        side = constructionswalls[i];
                    }
                    Wall wall = new Wall();
                    wall.setRaising(raising);
                    wall.setMinHeight(minHeight);
                    wall.setLength(wallLength);
                    wall.setSide("carport"+side);
                    carportWalls.add(wall);
                }
            } else {
                for (int i = 0; i < constructionswalls.length; i++) {
                    if (constructionswalls[i].equals("back")) {
                        wallLength = construction.getCarportWidth() - construction.getShed().getWidth() - 100;
                        minHeight = construction.getConstructionHeight();
                        side = "back";
                    } else
                    if (constructionswalls[i].equals(construction.getShed().getSide())) {
                        wallLength = construction.getCarportLength();
                        minHeight = ConstructionSizeCalculator.carportMinHeight(construction.getConstructionHeight(),
                                construction.getShed().getDepth(), construction.getRoof().getDegree());
                        side = constructionswalls[i];
                        Wall wall = new Wall();
                        wall.setRaising(raising);
                        wall.setMinHeight(minHeight);
                        wall.setLength(wallLength);
                        wall.setSide("carport"+side);
                        carportWalls.add(wall);
                    } else {
                        Wall carportWall=new Wall();
                        wallLength = construction.getCarportLength();
                        minHeight = ConstructionSizeCalculator.carportMinHeight(construction.getConstructionHeight(),
                                construction.getShed().getDepth(), construction.getRoof().getDegree());
                        side = constructionswalls[i];
                        carportWall.setRaising(raising);
                        carportWall.setMinHeight(minHeight);
                        carportWall.setLength(wallLength);
                        carportWall.setSide("carport"+side);
                        carportWalls.add(carportWall);

                        if (construction.getShed().getWidth()!=construction.getCarportWidth()){
                            Wall likeShedWall=new Wall();
                            likeShedWall.setSide("likeShed"+constructionswalls[i]);
                            likeShedWall.setLength(construction.getShed().getDepth());
                            likeShedWall.setMinHeight(construction.getConstructionHeight());
                            likeShedWall.setRaising(raising);
                            carportWalls.add(likeShedWall);
                        }

                    }

                }
            }
            return carportWalls;
        }
    }
}
