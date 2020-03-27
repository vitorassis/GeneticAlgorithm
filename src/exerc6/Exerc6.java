/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerc6;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author vitor
 */
public class Exerc6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Organism org1, org2;
        
        System.out.print("Primeiro DNA: ");
        org1 = new Organism(in.nextLine());
        System.out.print("Segundo DNA : ");
        org2 = new Organism(in.nextLine());
        
        if(!org1.recombineDNA(org2))
            System.out.println("OS DNAS DEVEM TER O MESMO TAMANHO!");
        else{
            System.out.println("");
            System.out.println("Filho 1: "+org1.getChild(0).getDNA());
            System.out.println("Filho 2: "+org1.getChild(1).getDNA());
            
            Organism father = org1.getChild(0);
            Organism mother = org1.getChild(1);
            
            while(in.nextLine()!= "0"){
                
                father.recombineDNA(mother);
                mother.recombineDNA(father.getChild(new Random().nextInt(2)));
                
                System.out.println("");
                System.out.println("Filho Father 1: "+father.getChild(0).getDNA());
                System.out.println("Filho Father 2: "+father.getChild(1).getDNA());
                System.out.println("Filho Mother 1: "+mother.getChild(0).getDNA());
                System.out.println("Filho Mother 2: "+mother.getChild(1).getDNA());
                
                father = father.getChild(new Random().nextInt(2));
                mother = mother.getChild(new Random().nextInt(2));
            }
            
        }
    }
    
}
