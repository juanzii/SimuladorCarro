/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simuladorcarro.modelos;

import javax.swing.JOptionPane;
import simuladorcarro.exception.AcelerarMasDelLimiteMotorException;
import simuladorcarro.exception.ApagarElCarroEnMovimientoException;
import simuladorcarro.exception.CarroApagadoException;
import simuladorcarro.exception.CarroPrendidoException;
import simuladorcarro.exception.FrenarMasDeLoNecesarioException;
import simuladorcarro.exception.FrenarVelocidadSuperiorALlantasException;
/**
 *
 * @author Daniel Muñoz
 */
public class CarSimulator {
    private Taller taller;
    private Car car;

    public CarSimulator() {
        this.taller = new Taller();
        this.car = taller.createCar();
    }
    
    public void prenderCarro(){
        if(this.intPrenderCarro() == true){
            car.prender();
        }
    }
    
    public void apagarCarro(){
        if(intApagarCarro() == true && carNotMoving() == true){
            car.apagar();
        }
    }
    
    public void acelerarCarro(){
        if(intApagarCarro()== true && notMaxVelEngine() == true){
            car.acelerar();
        }else{
            car.apagar();
        }
    }
    
    public void frenarCarro(){
        if(intApagarCarro()== true){
            car.frenar();
        }
    }
    
    public void frenarBruscoCarro(){
        if(intApagarCarro() == true && notMaxVelWheel() == true && notFrenoBrusco() == true){
            car.frenarBrusco();
        }else{
            car.setVelocidad(0);
        }
    }
    
    //__________________________________________________________________________
    
    public boolean intPrenderCarro(){
        try{
            car.checkCarNotOnExeption();
            return true;
        }catch(CarroPrendidoException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return false;
    }
    
    public boolean intApagarCarro(){
        try{
            car.checkCarNotOff();
            return true;
        }catch(CarroApagadoException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return false;
    }
    
    public boolean notMaxVelEngine(){
        try {
            car.checkMaxVelEngine();
            return true;
        } catch (AcelerarMasDelLimiteMotorException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return false;
    }
    
    public boolean notMaxVelWheel(){
        try {
            car.checkMaxVelWheel();
            return true;
        } catch (FrenarVelocidadSuperiorALlantasException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return false;
    }
    
    public boolean notFrenoBrusco(){
        try {
            car.checkFrenoBrusco();
            return true;
        } catch (FrenarMasDeLoNecesarioException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return false;
    }
    
    public boolean carNotMoving(){
        try {
            car.checkCarMoving();
            return true;
        } catch (ApagarElCarroEnMovimientoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return false;
    }

    /**
     * @return the car
     */
    public Car getCar() {
        return car;
    }

    /**
     * @param car the car to set
     */
    public void setCar(Car car) {
        this.car = car;
    }
}
