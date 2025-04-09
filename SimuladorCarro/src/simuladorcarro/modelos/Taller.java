/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simuladorcarro.modelos;

/**
 *
 * @author Daniel Muñoz
 */
public class Taller {
    private Carro car;
    private LectorArchivo LA;
    private Ruedas wheel;
    private Motor engine;

    public Taller() {
        this.LA = new LectorArchivo();
        this.wheel = createCarWheel();
        this.engine = createCarEngine();
        
    }
    
    public Carro createCar(){
        car = new Carro(wheel, engine);
        return car;
    }
    
    public Ruedas createCarWheel(){
        LA = new LectorArchivo();
        String quality = LA.splitWheel();
        return new Ruedas(quality);
    }
    
    public Motor createCarEngine(){
        LA = new LectorArchivo();
        String type = LA.splitEngine();
        return new Motor(type);
    }
}
