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
public class Car {
    private int velocidad;
    private boolean estado;
    private Wheel myWheel;
    private Engine myEngine;

    public Car(Wheel wheel, Engine engine) {
        this.myWheel = wheel;
        this.myEngine = engine;
    }
    
        public void prender(){
        setEstado(true);
    }
    
    public void apagar(){
        setEstado(false);
        setVelocidad(0);
    }
    
    public void acelerar(){
        setVelocidad(getVelocidad() + 5);
    }
    
    public int frenar(){
        setVelocidad(getVelocidad() - 5);
        if(getVelocidad() < 0){
            setVelocidad(0);
        }
        return getVelocidad();
    }
    
    public int frenarBrusco(){
        setVelocidad(getVelocidad() - 30);
        if(getVelocidad() < 0){
            setVelocidad(0);
        }
        return getVelocidad();
    }

    public boolean checkCarNotOnExeption() throws CarroPrendidoException{
        if (this.isEstado() == false){
            return true;
        }else{
            throw new CarroPrendidoException("El vehiculo se encuentra encendido");
        }
    }
    
    public boolean checkCarNotOff() throws CarroApagadoException{
        if(this.isEstado() == true){
            return true;
        }else{
            throw new CarroApagadoException("El vehiculo se encuentra apagado");
        }
    }
    
    public boolean checkMaxVelEngine() throws AcelerarMasDelLimiteMotorException{
        if(this.getVelocidad() < this.getMyEngine().getMaxVel()){
            return true;
        }else{
            throw new AcelerarMasDelLimiteMotorException("Aceleraste mas de lo que soporta el motor y accidentaste");
        }
    }
    
    public boolean checkMaxVelWheel() throws FrenarVelocidadSuperiorALlantasException{
        if(this.getVelocidad() < this.getMyWheel().getMaxVel()){
            return true;
        }else{
            throw new FrenarVelocidadSuperiorALlantasException("Ibas muy rapido y las llantas derraparon");
        }
    }
    
    public boolean checkFrenoBrusco() throws FrenarMasDeLoNecesarioException{
        if(this.getVelocidad() > 30 | this.getVelocidad() == 0){
            return true;
        }else{
            throw new FrenarMasDeLoNecesarioException("Frenaste de mas y se derrapo el vehiculo");
        }
    }
    
    public boolean checkCarMoving() throws ApagarElCarroEnMovimientoException{
        if(this.getVelocidad() <= 60){
            return true;
        }else{
            this.apagar();
            throw new ApagarElCarroEnMovimientoException(""
                    + " vehiculo mientras andabas a mas de 60 km/h" );
        }
    }
    
    /**
     * @return the myWheel
     */
    public Wheel getMyWheel() {
        return myWheel;
    }

    /**
     * @return the myEngine
     */
    public Engine getMyEngine() {
        return myEngine;
    }  

    /**
     * @param myWheel the myWheel to set
     */
    public void setMyWheel(Wheel myWheel) {
        this.myWheel = myWheel;
    }

    /**
     * @param myEngine the myEngine to set
     */
    public void setMyEngine(Engine myEngine) {
        this.myEngine = myEngine;
    }

    /**
     * @return the velocidad
     */
    public int getVelocidad() {
        return velocidad;
    }

    /**
     * @param velocidad the velocidad to set
     */
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    /**
     * @return the estado
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
