/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exerc6;

import java.util.Random;

/**
 *
 * @author vitor
 */
public class Organism {
    private String DNA;
    private Organism [] children;
    
    Organism(String DNA){
        this.DNA = DNA;
        this.children = new Organism[2];
    }
    
    String getDNA(){
        return DNA;
    }
    
    Organism getChild(int child){
        return this.children[child];
    }
    
    String [] getDNAfrags(int splitPoint){
        String [] frags = new String [2];
        
        frags[0] = this.getDNA().substring(0, splitPoint);
        frags[1] = this.getDNA().substring(splitPoint);
        
        return frags;
    }
    
    boolean recombineDNA(Organism recombiner){
        if(recombiner.getDNA().length() != this.getDNA().length())
            return false;
        
        int splitPoint = new Random().nextInt(this.getDNA().length());
        
        String [][] DNAPieces  = {
            this.getDNAfrags(splitPoint),
            recombiner.getDNAfrags(splitPoint)
        };
        
        this.children[0] = new Organism(DNAPieces[0][0] + DNAPieces[1][1]);
        this.children[1] = new Organism(DNAPieces[1][0] + DNAPieces[0][1]);
        
        //recombiner.children = this.children;
        
        return true;
    }
}
