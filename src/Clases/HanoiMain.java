package Clases;


import java.util.InputMismatchException;
import java.util.Scanner;

public class HanoiMain {
    public static void main(String[] args) throws InterruptedException {

        Scanner input = new Scanner(System.in);
        int num=3, origen=1, aux=2, destino=3; //por defecto
        boolean Excep=true,condA,condB,condC,condD;
        
        do{
            try{
                System.out.println("\033[H\033[2J");
                System.out.println("\tTorres de Hanoi automatico\n");
                input = new Scanner(System.in);
                System.out.print("Ingrese el numero de discos (1-6): ");
                num=input.nextInt();
                System.out.print("Ingrese el origen (num estaca inicial) (1,2,3) : ");
                origen = input.nextInt();
                System.out.print("Ingrese el destino (num estaca final) (1,2,3): ");
                destino = input.nextInt();
                Excep=false;
            }
            catch(InputMismatchException e){
                System.out.println("\nObservacion: Debe ingresar solo valores enteros");
                Excep=true;
            }

            condA = num<1 || num>6;
            condB = origen<1 || origen>3;
            condC = destino<1 || destino>3;
            condD = (origen==destino);

            if(condA || condB || condC){
                System.out.println("\nObservacion: Ingrese valores en rango");
            }
            if(condD){
                System.out.println("\nObservacion: el origen y llegada no pueden ser iguales");
            }
            Thread.sleep(3000);

        }while(Excep || condA || condB || condC || condD);
            
        if(origen==1 & destino==2) aux=3;
        if(origen==1 & destino==3) aux=2;
        if(origen==2 & destino==1) aux=3;
        if(origen==2 & destino==3) aux=1;
        if(origen==3 & destino==1) aux=2;
        if(origen==3 & destino==2) aux=1;

        Hanoi h = new Hanoi(num,origen);
        
        h.printHanoi();
        
        System.out.println("\nEnter para empezar");
        String temp = input.nextLine();
        temp = input.nextLine();

        h.mover(num, origen, aux, destino);

        input.close();

        System.out.println("\033[H\033[2J");
    }
}