package juego;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Monedas extends Prime{
	
	public static int pezmoneda = pezx + 40;
	
	public Monedas(){
		
	}
	
	public static void pintar(BufferedImage bufferedImage, int x, 
			int y,	Prime prime) {
		 g = (Graphics2D)dobleBuffer.getDrawGraphics();

				g.drawImage(picture.get(toque1), tubox1 + monedax, tuboy + 355, null );
				g.drawImage(picture.get(toque2), tubox2 + monedax2, tuboy2 + 355, null );
				g.drawImage(picture.get(toque3), tubox3 + monedax3, tuboy3 + 355, null );
		 
	}
	
	public static void monedas(){
		if(cajapez.intersects(cajamonedas)){
			toque1 = 17;
			Sonidos.Burbuja();
			Sonidos.Pop();
		}
		
		if(cajapez.intersects(cajamonedas1)){
			toque2 = 17;
			Sonidos.Burbuja();
			Sonidos.Pop();
		}
		
		if(cajapez.intersects(cajamonedas2)){
			toque3 = 17;
			Sonidos.Burbuja();
			Sonidos.Pop();
		}
		
		if (monedax == 0 || monedax2 == 0 || monedax3 == 0){
		
		if (pezmoneda == (tubox1 + monedax)+1){
			monedas ++;
			bonuscon ++;
			puntuacion = puntuacion +3;
			primer_orden = primer_orden +3;
			Sonidos.tburbuja = true;
			Sonidos.tpop = true;
		}
		if (pezmoneda == (tubox2 + monedax2)+1){
			monedas ++;
			bonuscon ++;
			puntuacion = puntuacion +3;
			primer_orden = primer_orden +3;
			Sonidos.tburbuja = true;
			Sonidos.tpop = true;
		}
		if (pezmoneda == (tubox3 + monedax3)+1){
			monedas ++;
			bonuscon ++;
			puntuacion = puntuacion +3;
			primer_orden = primer_orden +3;
			Sonidos.tburbuja = true;
			Sonidos.tpop = true;
		}
		
		if(bonuscon == 5){
			bonus = 26;
			bonuscon = 0;
			monedas += 2;
			puntuacion += 2;
			primer_orden += 2;
			Sonidos.Bur();
			Sonidos.tbur = true;
		}
		}
	}
}