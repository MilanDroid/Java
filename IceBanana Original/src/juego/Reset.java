package juego;

import javax.swing.JOptionPane;

public class Reset extends Prime{
	
	public static void reset(){
		pezx = 75;
		pezy = 240;
		pezlad = 1;
		tubox1 = 370;
		tubox2 = 570;
		tubox3 = 770;
		tuboy = -150;
		tuboy2 = -190;
		tuboy3 = -101;
		monedax = 0;
		monedax2 = 1200;
		monedax3 = 0;
		puntuacion = 0;	
		over = 17;
		monedas = 0;
		bonuscon = 0;
		bonus = 17;
		toque1 = 22;
		toque2 = 22;
		toque3 = 22;
		primer_orden = 0;
		segundo_orden = 0;
		tercer_orden = 0;
		pezspeed = 2;
		velocidad_tubos = 2;
		velocidad_suelo = 2;
	}
	
	public static void conRest(){
		if(reset==-1){
			 reset =Integer.valueOf(JOptionPane.showConfirmDialog(null, "Desea volver a jugar?"));
			  if(reset==1){
				  over = 5;
			        System.exit(0);
			       }
			  if(reset==0){
				  intentos++;
				   CajondePuntos.CajondePuntos();
				  	reset();
				  	
			       }
			  }
	}
}