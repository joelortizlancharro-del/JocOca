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
    int jugadorsEnPou = 0;
    int menysDe63 = 0;
    String tiro = "tiro";
    //String escriureTiro = "";

    
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
    int[] controlTirsNegatiusPerJugador = controlTirsNegatius(numeroDeJugadors);


    
    System.out.println("_______________________");
    System.out.println("||| El joc comença! |||");
    System.out.println("_______________________");

    System.out.println("Per llençar els daus has de escriure: tiro. ");
  
    do{
    System.out.println("|||Ronda actual: " + ronda + "|||");
    int primerDau = dauUn();
    int segonDau = dauDos();
    if(controladorDeJugadors > numeroDeJugadors){ //Serveix per dir el numero del jugador i controlarlo
                controladorDeJugadors = 1;
     }
        torn(nomFinals, numeroDeJugadors, controladorDeJugadors);
        controladorDeJugadors++;

        
       llençada(primerDau, segonDau, posicionsJugadors, numeroDeJugadors, jugadorActual, pontEnTauler, primerDau, segonDau, ocaEnTauler, tirNegatiu, fonda, controlTirsNegatiusPerJugador, presoEnTauler, pouEnTauler, jugadorsEnPou, nomFinals, laberintEnTauler, jardiDeLaOcaEnTauler, laMortEnTauler, ronda, menysDe63);
         jugadorActual++;
         System.out.println("--------------------------");

    
        controlJugadorPerGuanyar++;
        if(controlJugadorPerGuanyar == numeroDeJugadors){ //controlem el jugador per saber quin pot guanyar
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
        while (posicionsJugadors[controlJugadorPerGuanyar] != jardiDeLaOcaEnTauler);
        if(posicionsJugadors[controlJugadorPerGuanyar] == jardiDeLaOcaEnTauler){
            System.out.println("Ha guanyat el jugador " + nomFinals[jugadorActual]  + "!");
            return;
        }
        
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

    public void llençada(int primerDau, int segonDau, int[] posicionsJugadors, int numeroDeJugadors, int jugadorActual, int[] pontEnTauler,int dauUn, int dauDos, int[] ocaEnTauler, int tirNegatiu, int fonda, int[] controlTirsNegatiusPerJugador, int presoEnTauler, int pouEnTauler, int jugadorsEnPou, String[] nomFinals, int laberintEnTauler, int jardiDeLaOcaEnTauler, int laMortEnTauler, int ronda, int menysDe63){
        if(controlTirsNegatiusPerJugador[jugadorActual] == 0){ 
            controlarTiro();
          if (posicionsJugadors[jugadorActual] < 60){ //tirada de dos daus
            posicionsJugadors[jugadorActual] = posicionsJugadors[jugadorActual] + primerDau + segonDau;
            if(posicionsJugadors[jugadorActual] <= 63){
              System.out.println(">> Tiro \n " + "Has obtingut " + primerDau + " i " + segonDau + " = " + (primerDau+segonDau) + "\n Avances fins a la casella " + posicionsJugadors[jugadorActual]); 
            }
            else{
            menysDe63 = posicionsJugadors[jugadorActual] - 63;
            posicionsJugadors[jugadorActual] = 63 - menysDe63;
            System.out.println("Has obtingut " + primerDau + " i " + segonDau +", com el resultat es superior a 63 retrocedeixes desde la casella 63 fins la casella " + posicionsJugadors[jugadorActual]);
            }
        }
        else{   //tirada de un dau
            posicionsJugadors[jugadorActual] = posicionsJugadors[jugadorActual] + primerDau;
            if(posicionsJugadors[jugadorActual] <= 63){
               System.out.println(">> Tiro \n " + "Has obtingut " + primerDau + "\n Avances fins a la casella " + posicionsJugadors[jugadorActual]);
            }
            else{
                 menysDe63 = posicionsJugadors[jugadorActual] - 63;
            posicionsJugadors[jugadorActual] = 63 - menysDe63;
            System.out.println("Has obtingut " + primerDau + ", com el resultat es superior a 63 retrocedeixes desde la casella 63 fins la casella " + posicionsJugadors[jugadorActual]);
            }
        }
        for(int i = 0; i < ocaEnTauler.length - 1; i++){//aqui comença la oca.
           
             if(posicionsJugadors[jugadorActual] == ocaEnTauler[i]){
            int nouDauUn =dauUn();
            int nouDauDos = dauDos();//nous daus per quan tornem a tirar despres de la oca;
            
            posicionsJugadors[jugadorActual] = ocaEnTauler[i+1];
            System.out.println("De oca en oca y tiro porque me toca. \n" + "Avances fins a la casella " + posicionsJugadors[jugadorActual]);
            controlarTiro();
            posicionsJugadors[jugadorActual] = posicionsJugadors[jugadorActual] + nouDauUn + nouDauDos;
            System.out.println(">> Tiro \n " + "Has obtingut " + nouDauUn + " i " + nouDauDos + " = " + (nouDauUn+nouDauDos) + "\n Avances fins a la casella " + posicionsJugadors[jugadorActual]);
            System.out.println(" ");
            }//fins aqui esta la oca
        }

           
            if(posicionsJugadors[jugadorActual] == 12){ //Aqui comença el pont
            int nouDauUn =dauUn();
            int nouDauDos = dauDos();
            
                posicionsJugadors[jugadorActual] = pontEnTauler[0];
                System.out.println("De puente a puente y tiro porque me lleva la corriente. \n" + "Tornes a la casella " + posicionsJugadors[jugadorActual]);
                controlarTiro();
                posicionsJugadors[jugadorActual] = posicionsJugadors[jugadorActual] + nouDauUn + nouDauDos;
                System.out.println(">> Tiro \n " + "Has obtingut " + nouDauUn + " i " + nouDauDos + " = " + (nouDauUn+nouDauDos) + "\n Avances fins a la casella " + posicionsJugadors[jugadorActual]);
                System.out.println(" ");
                }
                else if(posicionsJugadors[jugadorActual] == 6){
            int nouDauUn =dauUn();
            int nouDauDos = dauDos();

                    posicionsJugadors[jugadorActual] = pontEnTauler[1];
                    System.out.println("De puente a puente y tiro porque me lleva la corriente. \n" + "Avances fins a la casella " + posicionsJugadors[jugadorActual]);
                    controlarTiro();
                    posicionsJugadors[jugadorActual] = posicionsJugadors[jugadorActual] + nouDauUn + nouDauDos;
                    System.out.println(">> Tiro \n " + "Has obtingut " + nouDauUn + " i " + nouDauDos + " = " + (nouDauUn+nouDauDos) + "\n Avances fins a la casella " + posicionsJugadors[jugadorActual]);
                     System.out.println(" ");  
                }//Aqui acaba el pont
       
                if(posicionsJugadors[jugadorActual] == fonda){//Comença la fonda
                    controlTirsNegatiusPerJugador[jugadorActual]++;
                    System.out.println("Has caigut en la fonda, et perdras " + controlTirsNegatiusPerJugador[jugadorActual] + " torns.");
                }//Acaba la fonda
                if(posicionsJugadors[jugadorActual] == presoEnTauler){//comença la preso
                    controlTirsNegatiusPerJugador[jugadorActual] += 3;
                    System.out.println("Has caigut en la preso, et perdras " + controlTirsNegatiusPerJugador[jugadorActual] + " torns.");
                }//Termina la preso
                if(posicionsJugadors[jugadorActual] == pouEnTauler){//comença el pou
                    controlTirsNegatiusPerJugador[jugadorActual] += 2;
                    System.out.println("Has caigut en el pou, perdras " + controlTirsNegatiusPerJugador[jugadorActual] + " torns.");
                    if(controlTirsNegatiusPerJugador[jugadorActual] == 2){
                        jugadorsEnPou++;
                        if(jugadorsEnPou > 1){
                            for(int i = 0; i < controlTirsNegatiusPerJugador.length; i++){
                            if( i != jugadorActual && controlTirsNegatiusPerJugador[i] > 0){
                            controlTirsNegatiusPerJugador[i] = 0;
                            jugadorsEnPou--;
                            System.out.println("El jugador " + nomFinals[i] + " es alliberat!");
                            }
                        }
                      }
                    }
                }//acaba el pou
                if(posicionsJugadors[jugadorActual] == laberintEnTauler){
                    posicionsJugadors[jugadorActual] = 39;
                    System.out.println("Et perds en el laberint, retrocedeixes a la casella 39.");
                }
                if(posicionsJugadors[jugadorActual] == laMortEnTauler){
                    posicionsJugadors[jugadorActual] = 0;
                    System.out.println("Has mort, tornes a la casella de inici!");
                }
                if(primerDau == 3 && segonDau == 6 && ronda == 1){
                    posicionsJugadors[jugadorActual] = 26;
                    System.out.println("De dado a dado y tiro porque me ha tocado. \n" + "Avances fins a la casella " + posicionsJugadors[jugadorActual]);
                }
                if(primerDau == 4 && segonDau == 5 && ronda == 1){
                    posicionsJugadors[jugadorActual] = 53;
                    System.out.println("De dado a dado y tiro porque me ha tocado. \n" + "Avances fins a la casella " + posicionsJugadors[jugadorActual]);
                }
                
     }
     else{
        controlTirsNegatiusPerJugador[jugadorActual]--;
        System.out.println("Perds el torn, et queden " + controlTirsNegatiusPerJugador[jugadorActual] + " torns per tornar a jugar.");
     }

 }

    public void torn(String[] nomFinals, int numeroDeJugadors, int controladorDeJugadors){
            System.out.println("Es el torn del jugador " + controladorDeJugadors + ", " + nomFinals[controladorDeJugadors-1] + "." );
            String escriureTiro = "";
            while(!escriureTiro.equals("tiro")){
             System.out.println("Has de escriure: tiro");
             escriureTiro = escaner.nextLine();
            }

       }

    public int[] controlTirsNegatius(int numeroDeJugadors){
        int[] tirNegatiuControl = new int[numeroDeJugadors];
        return tirNegatiuControl;
    }
    
    public void controlarTiro(){
        String escriureTiro = "";
            while(!escriureTiro.equals("tiro")){
            System.out.println("Has de escriure: tiro");
            escriureTiro = escaner.nextLine();
        }
    }
}
