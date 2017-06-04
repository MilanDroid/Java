package juego;

import javax.swing.JOptionPane;

public class Pausa extends Prime{
	
	public Pausa(){
	}
	
	public static void pausa(){
		if(pausa==-1){
			 pausa =Integer.valueOf(JOptionPane.showConfirmDialog(null, "Desea volver a jugar?"));
			  if(pausa==1){
				  over = 5;
			       jugando = false;
			       }
			  if(pausa==2){
			        System.exit(0);
			       }
			  }
	}
}