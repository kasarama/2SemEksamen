package FunctionLayer;

import java.util.ArrayList;

public class CarportBuilder {

// algorytmer for calculation of needed materials
    public void buildCarport(CarportRequest carportRequest) {
        Carport carport = new Carport();
        ArrayList<Material> materials = new ArrayList<>();

        int length = carportRequest.getLength();
        int width = carportRequest.getWidth();
        int shedDepth = carportRequest.getShedDepth();
        int angle = carportRequest.getAngle();

        carport.setLength(length);
        carport.setWidth(width);
        carport.setShedDepth(shedDepth);
        carport.setAngle(angle);


        int sidePost = ((length - (length % 300)) / 300 + 1) * 2;
        int shedPost;
        if (shedDepth > 0) {
            shedPost = 3;
            if (width == 600) {
                shedPost = 5;
            }
        } else {
            shedPost = 0;
        }

        for (int i = 0; i < (sidePost + shedPost); i++) {
            materials.add(new Material("97x97mm.trykimp.Stolpe", 300));
        }
    }


    /*
    Strap/Rem bygges af 45x19mm.spærtræubh.
     */
}





  /*
 przeliczamy jakie czesci sa potrzebne, dodajemy czesc do listy.
  sprawdzamy czy jakies sroby  sie powtarzaja i sprawdzamy ile w sumie potrzebujemy,
   wrzocamy je do listy jako jeden element
   */

