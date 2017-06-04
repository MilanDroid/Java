package juego;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Sonidos {
	private static File archivo;
	private static String ruta;
	public static boolean tchoque = true;
	public static boolean tcorrer = true;
	public static boolean tburbuja = true;
	public static boolean tpop = true;
	public static boolean tbur = true;
	public static Thread hilo;
	
	public static void Correr(){
		if(tcorrer == true){
			tcorrer = false;
			archivo = new File(".");
			ruta = archivo.getAbsolutePath();// permite obtener el sonido
			
			Thread hilo = new Thread() {
				@SuppressWarnings("deprecation")
				@Override
				public void run(){
					try{
                        Thread.sleep(600);
                        FileInputStream fis;
                        Player reproducir;
                        try{
                            fis = new FileInputStream(ruta + "/src/sonidos/sond.mp3");
                        }catch(FileNotFoundException e){
                            fis = new FileInputStream(ruta + "/sonidos/sond.mp3");
                        }
                        BufferedInputStream bis = new BufferedInputStream(fis);
                        reproducir = new Player(bis);
                        reproducir.play();
                        stop();
                    } catch (InterruptedException | JavaLayerException | FileNotFoundException e) {
                    }
				}
			};
			hilo.start();
		}
	}
	
	
	public static void Burbuja(){
		if (tburbuja == true){
			tburbuja = false;
			archivo=new File(".");
			ruta =archivo.getAbsolutePath();
			Thread hilo = new Thread() {
				@Override
				public void run(){
					try{
                        Thread.sleep(0);
                        FileInputStream fis;
                        Player reproducir;
                        try{
                            fis = new FileInputStream(ruta + "/src/sonidos/monedas.mp3");
                        }catch(FileNotFoundException e){
                            fis = new FileInputStream(ruta + "/sonidos/monedas.mp3");
                        }
                        BufferedInputStream bis = new BufferedInputStream(fis);
                        reproducir = new Player(bis);
                        reproducir.play();
                        stop();
					 } catch (InterruptedException | JavaLayerException | FileNotFoundException e) {
	                    }
					}
				};
				hilo.start();
			}
		}
	
	public static void Pop(){
		if (tpop == true){
			tpop = false;
			archivo=new File(".");
			ruta =archivo.getAbsolutePath();
			Thread hilo = new Thread() {
				@Override
				public void run(){
					try{
                        Thread.sleep(0);
                        FileInputStream fis;
                        Player reproducir;
                        try{
                            fis = new FileInputStream(ruta + "/src/sonidos/pop.mp3");
                        }catch(FileNotFoundException e){
                            fis = new FileInputStream(ruta + "/sonidos/pop.mp3");
                        }
                        BufferedInputStream bis = new BufferedInputStream(fis);
                        reproducir = new Player(bis);
                        reproducir.play();
                        stop();
					 } catch (InterruptedException | JavaLayerException | FileNotFoundException e) {
	                    }
					}
				};
				hilo.start();
			}
		}
	
	public static void Bur(){
		if (tbur == true){
			tbur = false;
			archivo=new File(".");
			ruta =archivo.getAbsolutePath();
			Thread hilo = new Thread() {
				@Override
				public void run(){
					try{
                        Thread.sleep(0);
                        FileInputStream fis;
                        Player reproducir;
                        try{
                            fis = new FileInputStream(ruta + "/src/sonidos/burbuja.mp3");
                        }catch(FileNotFoundException e){
                            fis = new FileInputStream(ruta + "/sonidos/burbuja.mp3");
                        }
                        BufferedInputStream bis = new BufferedInputStream(fis);
                        reproducir = new Player(bis);
                        reproducir.play();
                        stop();
					 } catch (InterruptedException | JavaLayerException | FileNotFoundException e) {
	                    }
					}
				};
				hilo.start();
			}
		}
	
	public static void Choque(){
		if(tchoque){
			tchoque= false;
			archivo= new File(".");
			ruta= archivo.getAbsolutePath();
			Thread hilo = new Thread() {
				@Override
				public void run(){
					try{
                        Thread.sleep(0);
                        FileInputStream fis;
                        Player reproducir;
                        try{
                            fis = new FileInputStream(ruta + "/src/sonidos/choque.mp3");
                        }catch(FileNotFoundException e){
                            fis = new FileInputStream(ruta + "/sonidos/choque.mp3");
                        }
                        BufferedInputStream bis = new BufferedInputStream(fis);
                        reproducir = new Player(bis);
                        reproducir.play();
                        stop();
                    } catch (InterruptedException | JavaLayerException | FileNotFoundException e) {
                    }
				}
			};
			hilo.start();
		}
	}
	
}
