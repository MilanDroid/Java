package juego;

public class Menu extends Prime {

	public static void menu(){
		if(pezverde == true){
			pez = 29;
			pezla = 30;
		}
		if(pezrojo == true){
			pez = 31;
			pezla = 32;
		}
		if(pezmorado == true){
			pez = 11;
			pezla = 16;
		}
		if(pezamarillo == true){
			pez = 33;
			pezla = 33;
		}
	}	
	public static void remenu(){
		menu = 17;
		inicio = 25;
		pezspeed = 2;
		velocidad_tubos = 2;
		velocidad_suelo = 2;
	}
}
