package juego;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Prime extends Canvas implements KeyListener{

	private static final long serialVersionUID = 1L;
	protected static BufferStrategy dobleBuffer;
	protected static boolean jugando  = false;
	
	protected static ArrayList<BufferedImage>picture;
		
	protected static Graphics2D g;
	protected final static int ANCHO_VENTANA = 400;
	protected final static int ALTO_VENTANA = 560;
	static Rectangle cajapez;
	static Rectangle cajatubo1up;
	static Rectangle cajatubo2up;
	static Rectangle cajatubo3up;
	static Rectangle cajatubo1down;
	static Rectangle cajatubo2down;
	static Rectangle cajatubo3down;
	static Rectangle cajamonedas;
	static Rectangle cajamonedas1;
	static Rectangle cajamonedas2;

	//Variables objetos
	
	protected static int lastFpsTime;
	protected static int fps;	
	
	//Variables pez
	protected static int pezx = 75;
	protected static int pezy = 240;
	protected static int pezspeed = 0;
	protected static int pezlad;
	protected static int pez = 11;
	protected static int pezla = 16;
	static boolean pezlado = false;
	protected static int pezancho = 40;
	protected static int pezalto = 41;
	protected static boolean pezverde = false;
	protected static boolean pezrojo = false;
	protected static boolean pezmorado = false;
	protected static boolean pezamarillo = false;
	protected static boolean antig = false;
	
	//Variables tubos
	protected static int velocidad_tubos = 0;
	
	protected static int tuboalto = 320;
	protected static int tuboancho = 50;
		
	protected static int tubox1 = 370;
	protected static int tubox2 = 555;
	protected static int tubox3 = 740;
		
	protected static int tuboy = -150;
	protected static int tuboy2 = -190;
	protected static int tuboy3 = -101;
		
	protected static int tubomax = -35;
	protected static int tubomin = -250;
	
	//Variables suelo
	protected static int suelox = 0;
	protected static int suelox2 = 1199;
	protected static int suelox3;
	protected static int sueloy =492;
	protected static int velocidad_suelo = 0;
	
	//Variables over
	protected static int over = 17 ;
	protected static int pausa=1;
	protected static int reset = 1;
	protected static int rnd = 1;
	
	//Puntuacion
	protected static int puntuacion = 0;
	protected static int primer_orden = 0;
	protected static int segundo_orden = 0;
	protected static int tercer_orden = 1;
	protected static int intentos = -1;
	protected static int monedas = 0;
	protected static int monedax = 0;
	protected static int monedax2 = 0;
	protected static int monedax3 = 0;
	protected static int monedamax = 4;
	protected static int monedamin = 1;
	protected static int monedaalto = 45;
	protected static int monedaancho = 45;
	protected static int monedar1;
	protected static int monedar2;
	protected static int monedar3;
	protected static int toque1 = 22;
	protected static int toque2 = 22;
	protected static int toque3 = 22;
	protected static int bonus = 17;
	protected static int bonuscon = 0;
	
	//Pantalla inicio
	protected static int inicio = 25;
	protected static int menu = 28;
	

	public Prime(){
		JFrame ventana;
		ventana = new JFrame();
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(ANCHO_VENTANA, ALTO_VENTANA);
		ventana.setResizable(false);
		ventana.setLocationRelativeTo(null);
		ventana.setTitle("Surfer Fish");
		ventana.getContentPane().add(this);
		ventana.setVisible(true);
		
		createBufferStrategy(2);
		dobleBuffer = this.getBufferStrategy();
		picture = new ArrayList<BufferedImage>();
		
		try {
			BufferedImage num0 = (ImageIO.read(getClass().getResource("/Imagenes/num0.png")));
			BufferedImage num1 = (ImageIO.read(getClass().getResource("/Imagenes/num1.png")));
			BufferedImage num2 = (ImageIO.read(getClass().getResource("/Imagenes/num2.png")));
			BufferedImage num3 = (ImageIO.read(getClass().getResource("/Imagenes/num3.png")));
			BufferedImage num4 = (ImageIO.read(getClass().getResource("/Imagenes/num4.png")));
			BufferedImage num5 = (ImageIO.read(getClass().getResource("/Imagenes/num5.png")));
			BufferedImage num6 = (ImageIO.read(getClass().getResource("/Imagenes/num6.png")));
			BufferedImage num7 = (ImageIO.read(getClass().getResource("/Imagenes/num7.png")));
			BufferedImage num8 = (ImageIO.read(getClass().getResource("/Imagenes/num8.png")));
			BufferedImage num9 = (ImageIO.read(getClass().getResource("/Imagenes/num9.png")));
			
			BufferedImage fondo = (ImageIO.read(getClass().getResource("/Imagenes/MAPA_NRO13.png")));
			BufferedImage pez = (ImageIO.read(getClass().getResource("/Imagenes/pezMorado.png")));
			BufferedImage tubodown = (ImageIO.read(getClass().getResource("/Imagenes/Tubo_1.png")));
			BufferedImage tuboup = (ImageIO.read(getClass().getResource("/Imagenes/Tubo_2.png")));
			BufferedImage piso = (ImageIO.read(getClass().getResource("/Imagenes/piso.png")));			
			BufferedImage over = (ImageIO.read(getClass().getResource("/Imagenes/gamerover.png")));
			BufferedImage pezlado = (ImageIO.read(getClass().getResource("/Imagenes/pezMoradolado.png")));
			BufferedImage over_trans = (ImageIO.read(getClass().getResource("/Imagenes/over_trans.png")));
			BufferedImage tubodownblue = (ImageIO.read(getClass().getResource("/Imagenes/Tubo_2_2.png")));
			BufferedImage tuboupblue = (ImageIO.read(getClass().getResource("/Imagenes/Tubo_1_2.png")));
			BufferedImage tubodownyellow = (ImageIO.read(getClass().getResource("/Imagenes/Tubo_2_1.png")));
			BufferedImage tuboupyellow = (ImageIO.read(getClass().getResource("/Imagenes/Tubo_1_1.png")));
			BufferedImage moneda = (ImageIO.read(getClass().getResource("/Imagenes/monedas.png")));
			BufferedImage instruc = (ImageIO.read(getClass().getResource("/Imagenes/instruc.png")));
			BufferedImage pausa = (ImageIO.read(getClass().getResource("/Imagenes/pausa.png")));
			BufferedImage inicio = (ImageIO.read(getClass().getResource("/Imagenes/Pantallainicio.png")));
			BufferedImage bonus = (ImageIO.read(getClass().getResource("/Imagenes/Bonus.png")));	
			BufferedImage cont = (ImageIO.read(getClass().getResource("/Imagenes/moneda_cont.png")));
			BufferedImage menu = (ImageIO.read(getClass().getResource("/Imagenes/menu.png")));
			BufferedImage pezverde = (ImageIO.read(getClass().getResource("/Imagenes/pezVerde.png")));
			BufferedImage verdelado = (ImageIO.read(getClass().getResource("/Imagenes/pezVerdelado.png")));	
			BufferedImage pezrojo = (ImageIO.read(getClass().getResource("/Imagenes/pezRojo.png")));
			BufferedImage rojolado = (ImageIO.read(getClass().getResource("/Imagenes/pezRojolado.png")));
			BufferedImage pezamari = (ImageIO.read(getClass().getResource("/Imagenes/pezAmarillo.png")));	
			BufferedImage amarillolado = (ImageIO.read(getClass().getResource("/Imagenes/pezAmarillolado.png")));
			
			picture.add(num0);	
			picture.add(num1);
			picture.add(num2);
			picture.add(num3);
			picture.add(num4);
			picture.add(num5);
			picture.add(num6);
			picture.add(num7);
			picture.add(num8);
			picture.add(num9);
			
/* 10 */	picture.add(fondo);
/* 11 */	picture.add(pez);	
/* 12 */	picture.add(tubodown);
/* 13 */	picture.add(tuboup);
/* 14 */	picture.add(piso);		
/* 15 */	picture.add(over);
/* 16 */	picture.add(pezlado);
/* 17 */	picture.add(over_trans);
/* 18 */	picture.add(tubodownblue);
/* 19 */	picture.add(tuboupblue);
/* 20 */	picture.add(tubodownyellow);
/* 21 */	picture.add(tuboupyellow);
/* 22 */	picture.add(moneda);
/* 23 */	picture.add(instruc);
/* 24 */	picture.add(pausa);
/* 25 */	picture.add(inicio);
/* 26 */	picture.add(bonus);	
/* 27 */	picture.add(cont);
/* 28 */	picture.add(menu);	
/* 29 */	picture.add(pezverde);
/* 30 */	picture.add(verdelado);
/* 31 */	picture.add(pezrojo);
/* 32 */	picture.add(rojolado);	
/* 33 */	picture.add(pezamari);
/* 34 */	picture.add(amarillolado);				
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		jugando = true;	
		
		
		
		this.requestFocus();
		this.addKeyListener(this);
		
		cicloPrincipal();
	}
	
	
	protected static void pintar(){
		
		 g = (Graphics2D)dobleBuffer.getDrawGraphics();
		 //BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	        //Fondo
		 	/*g.setColor(Color.BLACK);
			g.drawImage(image, 0, 0, ANCHO_VENTANA, ALTO_VENTANA, null);*/
		 g.drawImage(picture.get(10), 0, 0, null);

			//Pez
			Pez.pintar(picture.get(pezlad), pezx, pezy, null);
			Monedas.pintar(picture.get(toque1), tubox1 + monedax, tuboy + 355, null);
			Monedas.pintar(picture.get(toque2), tubox2 + monedax, tuboy2 + 355, null);
			Monedas.pintar(picture.get(toque3), tubox3 + monedax, tuboy3 + 355, null);
	         

	        //Tubos
			Tubos.pintar(picture.get(13), tubox1, tuboy, null );
			Tubos.pintar(picture.get(12), tubox1, tuboy + 450, null );
			Tubos.pintar(picture.get(18), tubox2, tuboy, null );
			Tubos.pintar(picture.get(19), tubox2, tuboy + 450, null );
			Tubos.pintar(picture.get(20), tubox3, tuboy, null );
			Tubos.pintar(picture.get(21), tubox3, tuboy + 450, null );
			
			//Suelo
			Suelo.pintar(picture.get(14), suelox2, sueloy, null);
			
			Suelo.pintar(picture.get(14), suelox, sueloy, null);
			
			Suelo.pintar(picture.get(14), suelox3, sueloy, null);
			
			//Gamerover
			
			g.drawImage(picture.get(over), 0,0, null);
			
			//Puntuacion
			
			g.setColor(Color.white);
			g.setFont(new java.awt.Font( "Calibri", Font.BOLD, 16 ) );
			g.drawImage(picture.get(24), 153, 499, null);
			g.drawString(""+ intentos, 100, 55 );
			g.drawString(": "+ monedas, 358, 38 );
			g.drawImage(picture.get(27), 322, 18, null );
			g.drawImage(picture.get(23), 8, 10, null );
			
			Puntuacion.puntuacionpintar();

			g.drawImage(picture.get(bonus), 0, 0, null);
			g.drawImage(picture.get(inicio), 0, 0, null);
			g.drawImage(picture.get(menu), 0, 0, null);
			
	        dobleBuffer.show();
		
	}



	public static void actualizar(){
		
		Pausa.pausa();
		
		Reset.conRest();
		
		//Movimeiento tubosâ€�
		Tubos.verftubos();
		
		//Movimiento pez
		Pez.Movpez();
	
		//Movimiento suelo 
		Suelo.suelovel();
	
		//Condicionales GameOver
		Over.Gameovercajas();
	
		//Over
		Over.verfOver();
		Menu.menu();
	
		//Puntuacion
		Puntuacion.puntuacion();
		Monedas.monedas();
		Puntuacion.Numeros();
		
		// Sonidos
		Sonidos.tchoque= true; // hace que el sonido del choque pueda reproducirse cuando se reinicia el juego
		
		System.out.println("Puntuacion: " + tercer_orden + ": " + segundo_orden + ": " +primer_orden );
		
		
		}
	
	public static void cicloPrincipal(){
	   long lastLoopTime = System.nanoTime(); 
       final int TARGET_FPS = 60;
       final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
       
       while (jugando){
    	   
    	   Sonidos.Correr();
    	   long now = System.nanoTime();
    	   long updateLength = now - lastLoopTime;
    	   lastLoopTime = now;
    	   @SuppressWarnings("unused")
		double delta = updateLength / ((double)OPTIMAL_TIME);
    	   lastFpsTime += updateLength;
    	   fps++;
    	   if (lastFpsTime >= 1000000000){
    		   System.out.println("(FPS: "+fps+")");
    		   lastFpsTime = 0;
    		   fps = 0;
    	   }
    	  
    	   
    	   
    	   pintar();    	   
    	   actualizar();
    	   
    	  
    	   try{
    		   Thread.sleep((lastLoopTime-System.nanoTime() + OPTIMAL_TIME)/1000000 );}
    	   catch(Exception e){
    		   
    	   };
       }
    }
	
	public void keyPressed(KeyEvent e){
		switch(e.getKeyCode()){
        case KeyEvent.VK_SPACE:	
        	pezlado = true;
        	
        	if (antig == true ){
        		pezy += pezspeed + 45;
        	}
        	
        	if (antig == false){
        		pezy -= pezspeed + 45;
        	}
        	//Sonidos.Bur();
        	
        	System.out.println("Presiono la tecla espacio");
            break;
        case KeyEvent.VK_P:
            pausa=-1;
            break;
        case KeyEvent.VK_R:
            reset=-1;
            break;
        case KeyEvent.VK_V:
        	pezverde = true;
            break;
        case KeyEvent.VK_N:
        	pezrojo = true;
            break;
        case KeyEvent.VK_B:
        	pezmorado = true;
            break;
        case KeyEvent.VK_A:
            pezamarillo = true;
            break;
        case KeyEvent.VK_C:
           Menu.remenu();
            break;
            }
	     
    }
	
    public void keyReleased(KeyEvent e) {
    	switch(e.getKeyCode()){
        case KeyEvent.VK_SPACE:
        	pezlado = false;
        	//Sonidos.tbur = true;
        	System.out.println("Solto la tecla espacio");
        	break;     
    }     
    }    
    
  	public void keyTyped(KeyEvent e) {
  		
  	}
}