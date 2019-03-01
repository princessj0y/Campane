/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package campane;

/**
 *
 * @author Princess Joy Padua
 * 
 */
public class DatiCondivisi {
    /**
     * @author Princess Joy Padua 
     * 
     * Creo variabili di tipo int che mi vanno a contare i suoni effettuati dai thread.
     * 
     */
    int contaDIN=0,contaDON=0,contaDAN=0;
    
    int maxElem=10000000;
    String schermo[];
    int p;

    public DatiCondivisi() {
        this.schermo=new String [maxElem];
        this.p=0;
    }

    public DatiCondivisi(int contaDIN, int contaDON, int contaDAN) {
        this.contaDIN = contaDIN;
        this.contaDON = contaDON;
        this.contaDAN = contaDAN;
        this.schermo=new String [maxElem];
        this.p=0;
    }

    synchronized public int getContaDIN() {
        return contaDIN;
    }

    synchronized public void setContaDIN(int contaDIN) {
        this.contaDIN = contaDIN;
    }

    synchronized public int getContaDON() {
        return contaDON;
    }

    synchronized public void setContaDON(int contaDON) {
        this.contaDON = contaDON;
    }

    synchronized public int getContaDAN() {
        return contaDAN;
    }

    synchronized public void setContaDAN(int contaDAN) {
        this.contaDAN = contaDAN;
    }
    
    
    
    /**
     * 
     * @param c Indico la scelta effettuata dall'untete fatta nel main
     * 
     * @return indica se hai vinto o no.
     * 
     */
    synchronized public String verificaSeHaiVinto(int c) {
        String x="Hai Perso";
        if(c==1 && contaDIN>contaDON && contaDIN>contaDAN) {
            x="Hai Vinto!";
        }
        if(c==2 && contaDON>contaDIN && contaDON>contaDAN) {
            x="Hai Vinto!";
        }
        if(c==3 && contaDAN>contaDON && contaDAN>contaDON) {
            x="Hai Vinto!";
        }
        return x;
    }
    synchronized public void aggiungi(String x) {
        if (p >= maxElem)
            p = 0;
        schermo[p]=x;
        p+=1;
    }
    synchronized public void printSchermo() {
        System.out.println("-------------------------------");
        for (int i = 0; i < p; i ++) {
            System.out.print(schermo[i] + " ");
            if (i % 20 == 19)
                System.out.println("");
        }
        System.out.println("\n-------------------------------");
    }
}
