/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simuladorcarro.modelos;

/**
 *
 * @author Daniel Muñoz
 */
public class Ruedas {
    private String quality;
    private int maxVel;

    public Ruedas(String quality) {
        this.quality = quality;
        if(getQuality().equals("Buenas")){
            this.maxVel = 110;
        }
        if(getQuality().equals("Bonitas")){
            this.maxVel = 70;
        }
        if(getQuality().equals("Baratas")){
            this.maxVel = 50;
        }
    }


    /**
     * @return the maxVel
     */
    public int getMaxVel() {
        return maxVel;
    }

    /**
     * @return the quality
     */
    public String getQuality() {
        return quality;
    }

    /**
     * @param quality the quality to set
     */
    public void setQuality(String quality) {
        this.quality = quality;
    }

    /**
     * @param maxVel the maxVel to set
     */
    public void setMaxVel(int maxVel) {
        this.maxVel = maxVel;
    }
    
    
}
