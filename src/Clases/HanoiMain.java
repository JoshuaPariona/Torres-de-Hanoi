package Clases;

import java.util.Scanner;

public class HanoiMain {
    public static void main(String[] args) throws InterruptedException {

        Scanner input = new Scanner(System.in);
        int num, origen, destino ,aux;

        System.out.print("Ingrese el numero de discos: ");
        num = input.nextInt();
        System.out.print("Ingrese el origen (num estaca inicial)");
        origen = input.nextInt();
        System.out.print("Ingrese el destino (num estaca final)");
        destino = input.nextInt();
        if(origen==1 & destino==2) aux=3;
        if(origen==1 & destino==3) aux=2;
        if(origen==2 & destino==1) aux=3;
        if(origen==2 & destino==3) aux=1;
        if(origen==3 & destino==1) aux=2;
        if(origen==3 & destino==2) aux=1;

        Hanoi h = new Hanoi(num,origen);

        h.printHanoi();
        
        System.out.println("Enter para empezar");
        String temp = input.nextLine();
        temp = input.nextLine();

        h.mover(num,origen,2,destino);

        input.close();
    }
}