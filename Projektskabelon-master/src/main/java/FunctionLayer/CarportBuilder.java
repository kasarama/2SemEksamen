package FunctionLayer;

public class CarportBuilder {
    Carport carport = new Carport();

    // Stolper og Rem
    public int posts (){
        int numberOfPosts = 0;
        int length = carport.getLength();
        int width = carport.getWidth();

        if (length < 300 && width < 510){
            numberOfPosts = 4;
        }
        if (length < 300 && width > 510){
            numberOfPosts = 6;
        }
        if (length > 300 && width < 510){
            numberOfPosts = 6;
        }
        if (length > 300 && width > 510){
            numberOfPosts = 9;
        }
        return numberOfPosts;
    }
    public int rem (){
        int numberOfRem = 0;
        int length = carport.getLength();
        int width = carport.getWidth();

        if (length < 300 && width < 510){
            numberOfRem = 2;
        }
        if (length < 300 && width > 510){
            numberOfRem = 3;
        }
        if (length > 300 && width < 510){
            numberOfRem = 4;
        }
        if (length > 300 && width > 510){
            numberOfRem = 6;
        }
        return numberOfRem;
    }

    // Bræddebolte
    public int carriageBolts() {
        int carriageBolts = posts()*2;
        return carriageBolts;
    }

    // Spær
    //public int


    // Firkantskiver
    // Universalbeslag
    // Beslagskruer
    // Hulbånd
    // Understern- og over sternbrædder
    // Skruer
    // Trapezplader
    // Bundskruer
    // Tætningsprofil
    // Vandbræt 360
    // Vandbræt540
    // Skruer til vandbræt
    // Skruer til ydrebeklædning
    // Skruer til inderbeklædning

 // Skur:
    // Stolpe
    // Lås
    // Hængsel
    // Lægte
    // Vinkelbeslag
    // Beklædning

}

/*
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
