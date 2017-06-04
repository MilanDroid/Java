package juego;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class Suelo extends Prime {
	
		private static final long serialVersionUID = 1L;
		
		
		public Suelo(){
		}
		
		public static void suelovel(){
			if(suelox <=0){
				suelox -= velocidad_suelo;
				suelox2 -= velocidad_suelo;
				suelox3 = 1199;
				}
			if(suelox2 <0){
				suelox2 -= velocidad_suelo;
				suelox3 -= velocidad_suelo;
				suelox = 1199;
			}
			if(suelox3 < 0){
				suelox3 -= velocidad_suelo;
				suelox -= velocidad_suelo; 
				suelox2= 1199;
				}
		}
		
		public int getSpeed() {
			return velocidad_tubos;
		}

		public void setSpeed(int speed) {
			Suelo.velocidad_tubos = speed;
		}

		public static void pintar(BufferedImage bufferedImage, int x, 
				int y,	Prime prime) {
			 g = (Graphics2D)dobleBuffer.getDrawGraphics();
				
			 g.drawImage(picture.get(14), suelox2, sueloy, null);
				
				g.drawImage(picture.get(14), suelox, sueloy, null);
				
				g.drawImage(picture.get(14), suelox3, sueloy, null);
		 
		}


		@Override
		public void keyPressed(KeyEvent arg0) {		
		}


		@Override
		public void keyReleased(KeyEvent arg0) {
		}
					
}