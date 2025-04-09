/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simuladorcarro.modelos;

/**
 *
 * @author Daniel Muñoz
 */
public class Engine {
    private String type;
    private int maxVel;
    private LectorArchivo LA;

    public Engine(String type) {
        if(type.equals("1000")){
            this.maxVel = 100;
        }
        if(type.equals("2000")){
            this.maxVel = 160;
        }
        if(type.equals("3000")){
            this.maxVel = 220;
        }
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the maxVel
     */
    public int getMaxVel() {
        return maxVel;
    }

    /**
     * @param maxVel the maxVel to set
     */
    public void setMaxVel(int maxVel) {
        this.maxVel = maxVel;
    } 
}
