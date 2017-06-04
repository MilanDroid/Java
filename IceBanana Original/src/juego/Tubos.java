package juego;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Tubos extends Prime {
	
		private static final long serialVersionUID = 1L;
		
		
		public static void pintar(BufferedImage bufferedImage, int x, 
				int y,	Prime prime) {
			 g = (Graphics2D)dobleBuffer.getDrawGraphics();
				
			 g.drawImage(picture.get(13), tubox1, tuboy, null );
			 g.drawImage(picture.get(12), tubox1, tuboy + 450, null );
			 g.drawImage(picture.get(18), tubox2, tuboy2, null );
			 g.drawImage(picture.get(19), tubox2, tuboy2 + 450, null );
			 g.drawImage(picture.get(20), tubox3, tuboy3, null );
			 g.drawImage(picture.get(21), tubox3, tuboy3 + 450, null );
				
		 
		}
		
		public static void verftubos(){
			tubox1 -= velocidad_tubos;
			tubox2 -= velocidad_tubos;
			tubox3 -= velocidad_tubos;		
			
			if(tubox1 + 52 <=0){
				
				tubox1 = 530;
				tuboy = (int)(Math.random()*((tubomax - tubomin) + 1) + tubomin);
				bonus = 17;
				monedar1 = (int)(Math.random()*((monedamax - monedamin) + 1) + monedamin);
				System.out.println("numero moneda1 : "+ monedar1);
				
				switch (monedar1) {
				 
		        case 1:
		        	monedax = 0;
		        	toque1 = 22;
		        break;
		 
		        case 2:
		        	monedax = 1200;
		        break;
		        
		        case 3:
		        	monedax = 1200;
		        break;
		   
		        default:
		        	monedax = 0;
		        	toque1 = 22;
		        break;
			}
				}
			if(tubox2 + 52 <=0){
				tubox2 = 530;
				tuboy2 = (int)(Math.random()*((tubomax - tubomin) + 1) + tubomin);
				bonus = 17;
				
				monedar2 = (int)(Math.random()*((monedamax - monedamin) + 1) + monedamin);
				System.out.println("numero moneda 2: "+ monedar2);
				
				switch (monedar2) {
				 
		        case 1:
		        	monedax2 = 0;
		        	toque2 = 22;
		        break;
		 
		        case 2:
		        	monedax2 = 1200;
		        break;
		        
		        case 3:
		        	monedax2 = 1200;
		        break;
		   
		        default:
		        	monedax2 = 0;
		        	toque2 = 22;
		        break;
			}
				}
			if(tubox3 + 52 <=0){
				tubox3 = 530;
				tuboy3 = (int)(Math.random()*((tubomax - tubomin) + 1) + tubomin);
				bonus = 17;
				antig = false;
				
				monedar3 = (int)(Math.random()*((monedamax - monedamin) + 1) + monedamin);
				System.out.println("numero moneda3 : "+ monedar3);
				
				switch (monedar3) {
				 
		        case 1:
		        	monedax3 = 0;
		        	toque3 = 22;
		        break;
		 
		        case 2:
		        	monedax3 = 1200;
		        break;
		        
		        case 3:
		        	monedax3 = 1200;
		        break;
		   
		        default:
		        	monedax3 = 0;
		        	toque3 = 22;
		        break;
			}
				}
				
		}
					
}