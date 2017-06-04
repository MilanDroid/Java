package juego;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import javax.swing.JOptionPane;

public class Over extends Prime {

	private static final long serialVersionUID = 1L;
	
	public static void verfOver(){
		if(pezy >= 455){
			Sonidos.Choque();
			Over.Reanudar();
					
			System.out.println("Perdiste");
			}
			if(cajapez.intersects(cajatubo1up)){
				Sonidos.Choque();
				Over.Reanudar();
				System.out.println("Perdiste");
			}
			if(cajapez.intersects(cajatubo2up)){
				Sonidos.Choque();
				Over.Reanudar();
				System.out.println("Perdiste");
			}
			if(cajapez.intersects(cajatubo3up)){
				Sonidos.Choque();
				Over.Reanudar();
				System.out.println("Perdiste");
			}
			if(cajapez.intersects(cajatubo1down)){
				Sonidos.Choque();
				Over.Reanudar();
				System.out.println("Perdiste");
			}
			if(cajapez.intersects(cajatubo2down)){
				Sonidos.Choque();
				Over.Reanudar();
				System.out.println("Perdiste");
			}
			if(cajapez.intersects(cajatubo3down)){
				Sonidos.Choque();
				Over.Reanudar();
				System.out.println("Perdiste");
			}
	}

	public static void Reanudar(){
		
		rnd = -1;
		if(rnd==-1){
			 rnd =Integer.valueOf(JOptionPane.showConfirmDialog(null, "Si para jugar, No para salir."));
			 if (rnd == 0){
				 over = 15;
				 intentos++;
				 inicio = 17;
				 Reset.reset();
			 }
			 if(rnd==1){
				  over = 15;
				  jugando = false;
			       }
			  if(rnd==2){
			        System.exit(0);
			       }
			  }
	}
	
	public static void Gameovercajas(){
		cajapez = new Rectangle(pezx, pezy, pezancho, pezalto);
		cajatubo1up = new Rectangle(tubox1,tuboy, tuboancho, tuboalto);
		cajatubo2up = new Rectangle(tubox2,tuboy2, tuboancho, tuboalto);
		cajatubo3up = new Rectangle(tubox3,tuboy3, tuboancho, tuboalto);
		cajatubo1down = new Rectangle(tubox1,tuboy + 450, tuboancho, tuboalto);
		cajatubo2down = new Rectangle(tubox2,tuboy2 + 450, tuboancho, tuboalto);
		cajatubo3down = new Rectangle(tubox3,tuboy3 + 450, tuboancho, tuboalto);
		cajamonedas = new Rectangle(tubox1 + monedax, tuboy + 355, monedaancho, monedaalto);
		cajamonedas1 = new Rectangle(tubox2 + monedax2, tuboy2 + 355, monedaancho, monedaalto);
		cajamonedas2 = new Rectangle(tubox3 + monedax3, tuboy3 + 355, monedaancho, monedaalto);
		
		cajapez.setBounds(pezx,pezy, pezancho, pezalto);
		cajatubo1up.setBounds(tubox1,tuboy, tuboancho, tuboalto);
		cajatubo2up.setBounds(tubox2,tuboy2, tuboancho, tuboalto);
		cajatubo3up.setBounds(tubox3,tuboy3, tuboancho, tuboalto);
		cajatubo1down.setBounds(tubox1,tuboy + 450, tuboancho, tuboalto);
		cajatubo2down.setBounds(tubox2,tuboy2 + 450, tuboancho, tuboalto);
		cajatubo3down.setBounds(tubox3,tuboy3 + 450, tuboancho, tuboalto);
		cajamonedas.setBounds(tubox1 + monedax, tuboy + 355, monedaancho, monedaalto);
		cajamonedas1.setBounds(tubox2 + monedax2, tuboy2 + 355, monedaancho, monedaalto);
		cajamonedas2.setBounds(tubox3 + monedax3, tuboy3 + 355, monedaancho, monedaalto);
		
	}
	public static void Gameover(){
  		g = (Graphics2D)dobleBuffer.getDrawGraphics();
		g.drawImage(picture.get(over), 0,0, null);
		dobleBuffer.show();
		
		}
}

