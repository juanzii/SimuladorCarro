/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package simuladorcarro.modelos;

import java.io.RandomAccessFile;

/**
 *
 * @author Daniel Muñoz
 */
public class LectorArchivo {
    public String openFile(){
        String text = "";
        String direccion = "C:\\Users\\Marco Sanint\\Documents\\MotoresYLlantas\\Carro1.txt";
        try {
            RandomAccessFile file = new RandomAccessFile(direccion, "r");
            String line1 = file.readLine();
            String line2 = file.readLine();
            text = line1 + " " + line2;
        } catch (Exception e) {
            System.err.println("No se encontro el archivo");
        }
        return text;
    }
    
    public String splitWheel(){
        String x = "";
        String arr [] = openFile().split(" ");
        for(String a : arr){
            if(a.equals("Buenas")){
                x = "Buenas";
            }else if(a.equals("Bonitas")){
                x = "Bonitas";
            }else{
                x = "Baratas";
            }
        }  
        return x;
    }
    
    public String splitEngine(){
        String y = "";
        String arr [] = openFile().split(" ");
        for(String b : arr){
            if(b.equals("1000")){
                y = "1000";
            }else if(b.equals("2000")){
                y = "2000";
            }else{
                y = "3000";
            }
        }
        return y;
    }
}
