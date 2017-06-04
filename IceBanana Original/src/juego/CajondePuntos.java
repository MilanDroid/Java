package juego;

import java.awt.Component;
import java.awt.TextArea;
import java.awt.Window;
import java.io.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import juego.Prime;


public class CajondePuntos {
	private static String strArchivo = "C:"+File.separator+"SurferFish"+File.separator+"Puntuacion.txt";
    private static File archivo = new File(strArchivo);
    private static String line = null;
    private static FileReader fileReader;
   private static BufferedReader bufferedReader;
	 private static String fileName = "C:"+File.separator+"SurferFish"+File.separator+"puntuacion.txt";
     private static File archivo2 = new File(fileName);
     private static File Carpeta = new File("C:"+File.separator+"SurferFish");
	 private static String Nombre;
	private static JTextArea textArea;
	private static Component Puntos;
	private static Object scrollPane;
	 
     
     public static void CajondePuntos(){
    	
     if(Prime.jugando == true){	 
    	 if(Prime.intentos!=-1){
    	 try {
         FileWriter fileWriter = new FileWriter(archivo,true); 
         BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
         
         bufferedWriter.write(Puntuacion.puntuacion+"\t"+Puntuacion.intentos+
        		 "\t"+"\t"+Monedas.monedas);
         bufferedWriter.newLine();
         bufferedWriter.close();
         
         System.out.println("Se ha terminado de escribir el archivo");
        }
     catch(IOException e) {
         System.out.println(
             "Error escribiendo el archivo "
             + fileName + "'");
       			}
    	 	}
    	 }
     }
     
     public static void Final(){
    	 
    	 if(Prime.jugando == false){	 
        	 if(Prime.intentos!=-1){
        	 try {
             FileWriter fileWriter = new FileWriter(archivo,true); 
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
             
             bufferedWriter.write(Nombre +"\t"+Puntuacion.puntuacion+"\t"+Puntuacion.intentos+
            		 "\t"+"\t"+Monedas.monedas);
             bufferedWriter.newLine();
             bufferedWriter.close();
             
             System.out.println("Se ha terminado de escribir el archivo");
            }
         catch(IOException e) {
             System.out.println(
                 "Error escribiendo el archivo "
                 + fileName + "'");
           			}
        	 	}
        	 }
         }
   
   
     @SuppressWarnings("deprecation")
	public static String Revisar(){
         try {
             fileReader = new FileReader(archivo);
             bufferedReader = new BufferedReader(fileReader);
             while((line = bufferedReader.readLine()) != null) {
                
             }
             bufferedReader.close();
         }
         catch(FileNotFoundException ex) {
             System.out.println("No se pudo abrir el archivo '" + archivo + "'");				
         }
         catch(IOException ex) {
             System.out.println("No se pudo leer el archivi '"  + archivo + "'");
         }
		return line;
     }
    
    public static void Contacto(){
      Nombre = String.valueOf(JOptionPane.showInputDialog("Registro", Nombre));
    }
     
     
   
    public static void main(String [] args) {
    	Carpeta.mkdir();
    	Contacto();
    	CajondePuntos();
    	Final();
    	Revisar();
	}

}
