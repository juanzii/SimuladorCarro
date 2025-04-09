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
    private Car car;
    private LectorArchivo LA;
    private Wheel wheel;
    private Engine engine;

    public Taller() {
        this.LA = new LectorArchivo();
        this.wheel = createCarWheel();
        this.engine = createCarEngine();
        
    }
    
    public Car createCar(){
        car = new Car(wheel, engine);
        return car;
    }
    
    public Wheel createCarWheel(){
        LA = new LectorArchivo();
        String quality = LA.splitWheel();
        return new Wheel(quality);
    }
    
    public Engine createCarEngine(){
        LA = new LectorArchivo();
        String type = LA.splitEngine();
        return new Engine(type);
    }
}
