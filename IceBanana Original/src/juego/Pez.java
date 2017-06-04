package juego;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

@SuppressWarnings("serial")
public class Pez extends Prime {
		
		public static void Movpez(){
			
			if (monedas == 10 || monedas == 40 || monedas == 60 || monedas == 80 || monedas == 100){
				antig = true;
			}
			
			if (antig == true){
				pezy -= pezspeed;
			}
			
			if (antig == false){
				pezy += pezspeed;
			}
			
			if(pezy <= 0){
				pezy=0;
			}
			if(pezlado == false){
				pezlad= pez;
			}
			if(pezlado == true){
				pezlad=pezla;
			}
		}
		
		public static void pintar(BufferedImage bufferedImage, int pezx, int pezy, Prime prime) {
			  g = (Graphics2D)dobleBuffer.getDrawGraphics();
				
				g.drawImage(picture.get(pezlad), pezx, pezy, null);
		}
		
		}