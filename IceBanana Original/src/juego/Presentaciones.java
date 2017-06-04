package juego;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

public class Presentaciones extends JFrame {
	private String line;
	private JTextArea textArea;
	private JPanel contentPane;
	private Container contentPanel;
	private Component lblPuntuaciones;
	private JLabel lblPuntuaciones_1;
	private JTextArea textArea_1;
	private JButton btnSalir;
	private JScrollPane scrollPane_1;
	private JButton btnCargar;
	private static Presentaciones frame;

	public static void main(String[] args) {
		frame = new Presentaciones();
	}
	
	public static void Presentaciones() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Presentaciones();
					if(Prime.jugando == false){
						frame.setVisible(true);
					}else
					frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public Presentaciones() {
		setUndecorated(true);
		setLocationRelativeTo(null);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 102, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Puntuaciones");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Elephant", Font.PLAIN, 17));
		lblNewLabel.setBounds(63, 0, 324, 37);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 430, 184);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.append("Nombre:"+"\t"+"Puntos:"+"\t"+"Intentos: "+"\t"+"Monedas:"+"\t"+"\n");
		scrollPane.setViewportView(textArea);
		
		btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String strArchivo = "C:"+File.separator+"SurferFish"+File.separator+"Puntuacion.txt";
		        File archivo = new File(strArchivo);
		        line = null;
		        FileReader fileReader;
		        BufferedReader bufferedReader;
		        try {
		            fileReader = new FileReader(archivo);
		            bufferedReader = new BufferedReader(fileReader);
		            while((line = bufferedReader.readLine()) != null) {
		                textArea.append(line +"\n");
		            }
		            bufferedReader.close();
		        }
		        catch(FileNotFoundException ex) {
		            System.out.println("No se pudo abrir el archivo '" + archivo + "'");				
		        }
		        catch(IOException ex) {
		            System.out.println("No se pudo leer el archivi '"  + archivo + "'");
		        }
			}
		});
		btnCargar.setBounds(106, 237, 89, 23);
		contentPane.add(btnCargar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(246, 237, 89, 23);
		contentPane.add(btnSalir);
	}

}
