package FunctionLayer;

public class CarportBuilder {

}


 Carport buildCarport(CarportRequest carportRequest){
    Carport carport = new Carport();
    carport.setLength(carportRequest.getLength());
    carport.setWidth(carportRequest.getWidth());
    carport.set;
    int length = carportRequest.getLength();
    int width  = carportRequest.getWidth();
    int shedDepth = carportRequest.getShedDepth();
    int sideStolper= ((length-(length%300))/300+1)*2;
    int shedStolper;
       if (shedDepth > 0){
           shedStolper=3;
           if (width==600){
               shedStolper=5;
           }
       }else {
           shedStolper=0;
       }

        return sideStolper+shedStolper;

    int sideStolper= ((length-(length%300))/300+1)*2;




  /*
 przeliczamy jakie czesci sa potrzebne, dodajemy czesc do listy.
  sprawdzamy czy jakies sroby  sie powtarzaja i sprawdzamy ile w sumie potrzebujemy,
   wrzocamy je do listy jako jeden element
   */
}
