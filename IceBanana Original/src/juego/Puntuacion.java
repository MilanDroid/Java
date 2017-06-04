package juego;

import java.awt.Graphics2D;

public class Puntuacion extends Prime {
	private static final long serialVersionUID = 1L;
	
	public static void puntuacion(){
		if(pezx == (tubox1 + tuboancho)+1 || pezx == (tubox2 + tuboancho)+1 || pezx == (tubox3 + tuboancho)+1){
			 puntuacion++;	
			 primer_orden++;
			 System.out.println("Puntuacion : "+puntuacion);
		}
	}
	
	public static void Numeros(){
		if (primer_orden > 9){
			segundo_orden = segundo_orden +1;
			primer_orden = 0;
		}
		
		if (segundo_orden > 9){
			tercer_orden = tercer_orden +1;
			segundo_orden = 0;
		}
		
		if (tercer_orden > 9){
			tercer_orden = 0;
			segundo_orden = 0;
			puntuacion = 0;
		}
	}
	
	
	
	public static void puntuacionpintar(){
		g = (Graphics2D)dobleBuffer.getDrawGraphics();
		
		g.drawImage(picture.get(primer_orden), 215, 10, null);
		g.drawImage(picture.get(segundo_orden), 187, 10, null);
		g.drawImage(picture.get(tercer_orden), 155, 10, null);
		
	}
}
