package Clases;

import java.util.Vector;

public class Hanoi {
    private char[][] board;
    private Vector<Integer> estaca1; 
    private Vector<Integer> estaca2;
    private Vector<Integer> estaca3;
    private int discos;

    public Hanoi(int discos,int origen){
        this.discos = discos;
        this.board = new char[10][46];
        this.estaca1 = new Vector<>();
        this.estaca2 = new Vector<>();
        this.estaca3 = new Vector<>(); 
        llenarDiscInit(discos, origen);
    }


    public void printHanoi(){
        llenarTabla();
        llenarDisc(estaca1,9);
        llenarDisc(estaca2,24);
        llenarDisc(estaca3,39);
        printTabla();
    }

    private void printTabla() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 46 ; j++) {
                System.out.print(this.board[i][j]);
            }
            System.out.println();
        }
    }

    private void moverDisco(int origen, int destino) throws InterruptedException{
        Integer disc=0;
        switch (origen){
            case 1: {
                disc = this.estaca1.elementAt(this.estaca1.size()-1);
                this.estaca1.removeElementAt(this.estaca1.size()-1);break;
            }
            case 2: {
                disc = this.estaca2.elementAt(this.estaca2.size()-1);
                this.estaca2.removeElementAt(this.estaca2.size()-1);break;
            }
            case 3:{
                disc = this.estaca3.elementAt(this.estaca3.size()-1);
                this.estaca3.removeElementAt(this.estaca3.size()-1);break;
            }
        }
        switch (destino) {
            case 1: this.estaca1.add(disc);break;
            case 2: this.estaca2.add(disc);break;
            case 3: this.estaca3.add(disc);break;
        }
        System.out.println("\033[H\033[2J");
        printHanoi();
        Thread.sleep(1000);
    }

    public void mover(int n, int origen,  int auxiliar, int destino) throws InterruptedException{
        if(n==1){
            //System.out.println("mover disco de " + origen + " a " + destino);
            moverDisco(origen,destino);

        }else{
            mover(n-1, origen, destino, auxiliar);
            //System.out.println("mover disco de "+ origen + " a " + destino);
            moverDisco(origen,destino);
            mover(n-1, auxiliar, origen, destino);
        }
    }
    

    private void llenarDisc(Vector<Integer> estaca, int col) {
        //Estacas en columna [9] [24] [39]
        //llenar desde la fila [7] hacia el [2]
        int j = 0,aux,aux1;
        for (int i = 7; i > (7-estaca.size()) ; i--) {
            aux = col+estaca.elementAt(j);
            aux1 = col-estaca.elementAt(j);
            for (int k = col ; k <= aux ; k++) {
                this.board[i][k] = '*';
            }
            for (int k = col ; k >= aux1; k--) {
                this.board[i][k] = '*';
            }
            j++;
        }

    }


    private void llenarDiscInit(int discos,int  origen){
        switch (origen) {
            case 1: 
                for (int i = discos ; i > 0 ; i--) {
                    this.estaca1.add(i);
                }
                ;break;
            case 2: 
                for (int i = discos ; i > 0 ; i--) {
                    this.estaca2.add(i);
                }
                ;break;
            case 3: 
                for (int i = discos ; i > 0 ; i--) {
                    this.estaca3.add(i);
                }
                
                ;break;
            default:
                break;
        }
        
    }

    private void llenarTabla(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 46; j++) {
                this.board[i][j] = ' ';
            }
        }

        //Estacas vacias columna [9] [24] [39]
        for (int i = 0 ; i < 8 ; i++) {
            this.board[i][9] = '|';
            this.board[i][24] = '|';
            this.board[i][39] = '|';
        }

        // indices
        this.board[9][9] = '1';
        this.board[9][24] = '2';
        this.board[9][39] = '3';
    }
    
}
