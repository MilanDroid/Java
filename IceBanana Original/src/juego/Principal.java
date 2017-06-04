package juego;

import javax.swing.JOptionPane;
import juego.CajondePuntos;


public class Principal{
	static int iniciar;
	
	public static void main(String[] args){
		iniciar =Integer.valueOf(JOptionPane.showConfirmDialog(null, "De si para comenzar a jugar, no para salir."));
		  if(iniciar==1){  
			  System.exit(0);
		       }
		  if(iniciar==0){
			  new Prime();
			  Over.Gameover();
			  CajondePuntos.main(args);
			  Presentaciones.Presentaciones();
		       }	
			}
}