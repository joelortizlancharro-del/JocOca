import java.util.InputMismatchException;
import java.util.Scanner;

public class JocDeOca {
     
    Scanner escaner = new Scanner(System.in);
    

    public static void main(String[] args) {
        JocDeOca p = new JocDeOca();
        p.principal();
    }
    public void principal(){

    int controladorDeJugadors = 1;
    int jugadorActual = 0;
    int controlJugadorPerGuanyar = 0;
    int ronda = 1;
    int tirNegatiu = 0;
    
    int[] ocaEnTauler = oca();
    int[] pontEnTauler = pont();

    int fonda = fonda();
    int pouEnTauler = pou();
    int laberintEnTauler = laberint();
    int presoEnTauler = preso();
    int laMortEnTauler = laMort();
    int jardiDeLaOcaEnTauler = jardiDeLaOca();


    int numeroDeJugadors = numJugadors();
    String[] nomFinals = preguntarNomJugadors(numeroDeJugadors);
    int[] posicionsJugadors = posiciojugadors(numeroDeJugadors);

    
    System.out.println("_______________________");
    System.out.println("||| El joc comença! |||");
    System.out.println("_______________________");
  
    do{
    System.out.println("Es la ronda " + ronda);
    int primerDau = dauUn();
    int segonDau = dauDos();
  
    if(controladorDeJugadors > numeroDeJugadors){
                controladorDeJugadors = 1;
     }
        torn(nomFinals, numeroDeJugadors, controladorDeJugadors);
        controladorDeJugadors++;

        
        llençada(primerDau, segonDau, posicionsJugadors, numeroDeJugadors, jugadorActual, pontEnTauler, segonDau, primerDau, ocaEnTauler, segonDau, fonda, ronda);
         jugadorActual++;
    
        controlJugadorPerGuanyar++;
        if(controlJugadorPerGuanyar == numeroDeJugadors){
            controlJugadorPerGuanyar = 0;
        }

       if(jugadorActual == numeroDeJugadors){
        ronda++;
        tirNegatiu--;
       }
          if(jugadorActual == numeroDeJugadors){
             jugadorActual = 0;
        }
        }
        while (posicionsJugadors[controlJugadorPerGuanyar] != 63);
   }
   


    public int numJugadors(){
        int quantitatJugadors = 5;
        while (quantitatJugadors > 4 || quantitatJugadors < 2) {
        try {
            System.out.println("Quans jugadors sou? Ha de ser de 2 a 4.");
            quantitatJugadors = escaner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Has de posar un numero que sigui entre 2 i 4 sense decimals.");
            quantitatJugadors = 5;
            escaner.next();
        }
        
    }
        return quantitatJugadors;
}

    public String[] preguntarNomJugadors(int numeroDeJugadors){
        System.out.println("Insereix el nom del jugadors");
        String[] nomFinals = new String[numeroDeJugadors];
        escaner.nextLine();
        for(int i = 0; i < numeroDeJugadors; i++){
          System.out.println("Quin es el nom del jugador " + (i+1) + "?");
         nomFinals[i] = escaner.nextLine();
        }
        
        return nomFinals;
    }

    public int[] oca(){
     int [] ocaEnTauler = new int[13];
     ocaEnTauler[0] = 5;
     ocaEnTauler[1] = 9;
     ocaEnTauler[2] = 14;
     ocaEnTauler[3] = 18;
     ocaEnTauler[4] = 23;
     ocaEnTauler[5] = 27;
     ocaEnTauler[6] = 32;
     ocaEnTauler[7] = 36;
     ocaEnTauler[8] = 41;
     ocaEnTauler[9] = 45;
     ocaEnTauler[10] = 50;
     ocaEnTauler[11] = 54;
     ocaEnTauler[12] = 59;

     return ocaEnTauler;
    }

    public int[] pont(){
        int[] pontEnTauler = new int[2];
        pontEnTauler[0] = 6; 
        pontEnTauler[1] = 12; 

        return pontEnTauler;
    }

    public int fonda(){
        int fonda = 19;
        return fonda;
    }

    public int pou(){
        
        int pouEnTauler = 31;
        return pouEnTauler;
    }

    public int laberint(){
        int laberintEnTauler = 42;
        return laberintEnTauler;
    }

    public int preso(){
        int presoEnTauler = 52;
        return presoEnTauler;
    }

    public int laMort(){
        int laMortEnTauler = 58;
        return laMortEnTauler;
    }

    public int jardiDeLaOca(){
        int jardiDeLaOcaEnTauler = 63;
        return jardiDeLaOcaEnTauler;
    }

    public int dauUn(){
        int dauUnRandom = (int)(Math.random()*6)+1;
        return dauUnRandom;
    }
    public int dauDos(){
        int dauDosRandom = (int)(Math.random()*6)+1;
        return dauDosRandom;
    }

    public int[] posiciojugadors(int numeroDeJugadors){
    int [] posicionDelsJugadors = new int[numeroDeJugadors];
       for(int i = 0; i < numeroDeJugadors; i++){
        posicionDelsJugadors[i] = 0;
       }
      return posicionDelsJugadors;
    }

    public void llençada(int primerDau, int segonDau, int[] posicionsJugadors, int numeroDeJugadors, int jugadorActual, int[] pontEnTauler,int dauUn, int dauDos, int[] ocaEnTauler, int tirNegatiu, int fonda, int ronda){
        // if(tirNegatiu == 0){ Buscar el error aqui
          if (posicionsJugadors[jugadorActual] < 60){ //tirada de dos daus
            posicionsJugadors[jugadorActual] = posicionsJugadors[jugadorActual] + primerDau + segonDau;
            System.out.println(">> Tiro \n " + "Has obtingut " + primerDau + " i " + segonDau + " = " + (primerDau+segonDau) + "\n Avances fins a la casella " + posicionsJugadors[jugadorActual]);
            System.out.println(" ");
        }
        else{   //tirada de un dau
            posicionsJugadors[jugadorActual] = posicionsJugadors[jugadorActual] + primerDau;
            System.out.println(">> Tiro \n " + "Has obtingut " + primerDau + "\n Avances fins a la casella " + posicionsJugadors[jugadorActual]);
            System.out.println(" ");
        }
        for(int i = 0; i < ocaEnTauler.length - 1; i++){//aqui comença la oca.
           
             if(posicionsJugadors[jugadorActual] == ocaEnTauler[i]){
            int nouDauUn =dauUn();
            int nouDauDos = dauDos();//nous daus per quan tornem a tirar despres de la oca;
            
            posicionsJugadors[jugadorActual] = ocaEnTauler[i+1];
            System.out.println("De oca en oca y tiro porque me toca. \n" + "Avances fins a la casella " + posicionsJugadors[jugadorActual]);
            posicionsJugadors[jugadorActual] = posicionsJugadors[jugadorActual] + nouDauUn + nouDauDos;
            System.out.println(">> Tiro \n " + "Has obtingut " + nouDauUn + " i " + nouDauDos + " = " + (nouDauUn+nouDauDos) + "\n Avances fins a la casella " + posicionsJugadors[jugadorActual]);
            System.out.println(" ");
            }//fins aqui esta la oca.
        }

           
            if(posicionsJugadors[jugadorActual] == 12){ //Aqui comença el pont
            int nouDauUn =dauUn();
            int nouDauDos = dauDos();
            
                posicionsJugadors[jugadorActual] = pontEnTauler[0];
                System.out.println("De puente a puente y tiro porque me lleva la corriente. \n" + "Tornes a la casella " + posicionsJugadors[jugadorActual]);
                posicionsJugadors[jugadorActual] = posicionsJugadors[jugadorActual] + nouDauUn + nouDauDos;
                System.out.println(">> Tiro \n " + "Has obtingut " + nouDauUn + " i " + nouDauDos + " = " + (nouDauUn+nouDauDos) + "\n Avances fins a la casella " + posicionsJugadors[jugadorActual]);
                System.out.println(" ");
                }
                else if(posicionsJugadors[jugadorActual] == 6){
            int nouDauUn =dauUn();
            int nouDauDos = dauDos();

                    posicionsJugadors[jugadorActual] = pontEnTauler[1];
                    System.out.println("De puente a puente y tiro porque me lleva la corriente. \n" + "Avances fins a la casella " + posicionsJugadors[jugadorActual]);
                    posicionsJugadors[jugadorActual] = posicionsJugadors[jugadorActual] + nouDauUn + nouDauDos;
                    System.out.println(">> Tiro \n " + "Has obtingut " + nouDauUn + " i " + nouDauDos + " = " + (nouDauUn+nouDauDos) + "\n Avances fins a la casella " + posicionsJugadors[jugadorActual]);
                     System.out.println(" ");  
                }//Aqui acaba el pont
       
                if(posicionsJugadors[jugadorActual] == fonda){
                    tirNegatiu++;
                }
                
     // } treure quan acabi amb el error

             
          
    }

    public void torn(String[] nomFinals, int numeroDeJugadors, int controladorDeJugadors){
       
            System.out.println("Es el torn del jugador " + controladorDeJugadors + ", " + nomFinals[controladorDeJugadors-1] + "." );
            escaner.nextLine();

       }
    


    
    }
