package FunctionLayer;

import java.util.ArrayList;

/**
 * @author Magdalena
 */
public class WallBuilder {
    public static ArrayList<Wall> addShedWalls(Construction construction){
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
        front.setLength(construction.getShed().getWidth()-100);
        front.setRaising(0);
        front.setMinHeight(construction.getConstructionHeight());

        walls.add(right);
        walls.add(left);
        walls.add(front);
        walls.add(back);

        return walls;

    }

    public static ArrayList<Wall> addCarportWalls(Construction construction, String[] constructionswalls){
        ArrayList<Wall> shedWalls=construction.getShed().getWalls();
        ArrayList<Wall> carportWalls= new ArrayList<>();

        String side="";
        int wallLength;
        int raising;
        int minHeight;



        for (Wall shedWall: shedWalls
             ) {
            for (int i = 0; i < constructionswalls.length ; i++) {
                Wall carportWall = new Wall();
                if (constructionswalls[i].equals(shedWall.getSide())) {
                    wallLength = construction.getCarportLength();
                    minHeight = ConstructionSizeCalculator.carportMinHeight(construction.getConstructionHeight(), shedWall.getLength(), raising);
                    side=shedWall.getSide();
                } else {
                    side=constructionswalls[i];
                    minHeight=construction.getConstructionHeight();
                    switch (constructionswalls[i]){
                        case "back":
                            wallLength=construction.getCarportWidth();
                            break;
                        case "right":
                        case "left":
                            wallLength=construction.getCarportLength()+construction.getShed().getDepth()-100;



                    }



                if(construction.getRoof().getIsPitched() || side.equals("back") || side.equals("front")){
                    raising=0;
                } else {
                    raising = construction.getRoof().getDegree();
                }
                 carportWall.setRaising(raising);
                 carportWall.setMinHeight(minHeight);
                 carportWall.setLength(wallLength);
                 carportWall.setSide(side);
                }

            }

        }
    }
}
