import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.*;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class prueba {

	/**
	 * @param args
	 * @throws SQLException 
	 */

	static ResultSet rs=null;
	static Statement s=null;
	static Connection conexion=null;
	static JTextField Numero = new JTextField();
	static JTextField Edicion = new JTextField();
	
	
	
	static ResultSetMetaData metaDatos;
	static int i=0,j=0;
	static JPanel Panel;
	static JTable tablaResultados = null;
	static DefaultTableModel modelo;
	static JDialog ventanaSecundaria;
	static JScrollPane ventanaSecundaria2;

	static JPanel Panel2;


	static JTextField nombreLibro;
	static JTextField nombreAutor;
	static JTextField Lugar;
	static JTextField Editorial;
	static JTextField LugarEdicion;
	static JTextField Fecha;
	static JTextField Isbn;
	static JTextField Resumen;
	
	static JTextField numeroeditar;
	static JTextField nombreLibro1;
	static JTextField nombreAutor1;
	static JTextField Lugar1;
	static JTextField Editorial1;
	static JTextField LugarEdicion1;
	static JTextField Fecha1;
	static JTextField Isbn1;
	static JTextField Resumen1;
	static JTable tabla;

	static JTextField Busqueda;

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		/*
		 * solucion para el editar que meta el numero de mierda ese y con eso lo cambia	
		 */

		JButton Titulo = new JButton();
		JButton Autor = new JButton();
		//JButton Fecha = new JButton();
		//JButton Ubicacion = new JButton();
		JButton Buscar = new JButton();
		JButton Editar = new JButton();
		JButton EditarCompleto = new JButton();
		JButton Insertar = new JButton();

		Busqueda = new JTextField();




		JLabel etiquetaTitulo = new JLabel("Titulo");	
		JLabel etiquetaAutor = new JLabel("Autor");	
		JLabel etiquetaLugar = new JLabel("Lugar");	
		JLabel etiquetaEditorial = new JLabel("Editorial");	
		JLabel etiquetaLugarEdicion = new JLabel("Lugar Edicion");	
		JLabel etiquetaFecha = new JLabel("Fecha");	
		JLabel etiquetaIsbn = new JLabel("ISBN");
		JLabel etiquetaResumen = new JLabel("Resumen");	
		
		
		JLabel etiquetaNumero1 = new JLabel("Nº");
		JLabel etiquetaTitulo1 = new JLabel("Titulo");	
		JLabel etiquetaAutor1 = new JLabel("Autor");	
		JLabel etiquetaLugar1 = new JLabel("Lugar");	
		JLabel etiquetaEditorial1 = new JLabel("Editorial");	
		JLabel etiquetaLugarEdicion1 = new JLabel("Lugar Edicion");	
		JLabel etiquetaFecha1 = new JLabel("Fecha");	
		JLabel etiquetaIsbn1 = new JLabel("ISBN");
		JLabel etiquetaResumen1 = new JLabel("Resumen");	
		
		JLabel etiquetaordentitulo = new JLabel("Ordenados por");	
		JLabel etiquetaordentautor = new JLabel("Ordenados por");	
		JLabel nlibro = new JLabel("Nº libro");	
		JLabel etiubicacionnueva = new JLabel("Nueva ubicación");	
		//JLabel etiquetaNCopias = new JLabel("Copias");	
		nombreLibro = new JTextField();
		nombreAutor = new JTextField();
		Lugar = new JTextField();
		Editorial = new JTextField();
		LugarEdicion = new JTextField();
		Fecha = new JTextField();
		Isbn = new JTextField();
		Resumen = new JTextField();
		
		numeroeditar = new JTextField();
		nombreLibro1 = new JTextField();
		nombreAutor1 = new JTextField();
		Lugar1 = new JTextField();
		Editorial1 = new JTextField();
		LugarEdicion1 = new JTextField();
		Fecha1 = new JTextField();
		Isbn1 = new JTextField();
		Resumen1 = new JTextField();
		//JTextField NumeroCopias = new JTextField();


		Panel = new JPanel(null);




		Panel.setBounds(new Rectangle(1280,720));

		Panel.add(Titulo);
		Panel.add(Autor);
		Panel.add(Buscar);
		Panel.add(Editar);
		Panel.add(Insertar);
		Panel.add(EditarCompleto);
		
		Panel.add(etiquetaordentitulo);
		Panel.add(etiquetaordentautor);
		Panel.add(nlibro);
		Panel.add(etiubicacionnueva);
		
		Panel.add(Busqueda);
		Panel.add(Numero);
		Panel.add(Edicion);

		Panel.add(etiquetaTitulo);
		Panel.add(etiquetaAutor);
		Panel.add(etiquetaLugar);
		Panel.add(etiquetaEditorial);
		Panel.add(etiquetaLugarEdicion);
		Panel.add(etiquetaFecha);
		Panel.add(etiquetaIsbn);
		Panel.add(etiquetaResumen);
		
		Panel.add(etiquetaNumero1);
		Panel.add(etiquetaTitulo1);
		Panel.add(etiquetaAutor1);
		Panel.add(etiquetaLugar1);
		Panel.add(etiquetaEditorial1);
		Panel.add(etiquetaLugarEdicion1);
		Panel.add(etiquetaFecha1);
		Panel.add(etiquetaIsbn1);
		Panel.add(etiquetaResumen1);
		
	

		Panel.add(nombreLibro);
		Panel.add(nombreAutor);
		Panel.add(Lugar);
		Panel.add(Editorial);
		Panel.add(LugarEdicion);
		Panel.add(Fecha);
		Panel.add(Isbn);
		Panel.add(Resumen);

		Panel.add(numeroeditar);
		Panel.add(nombreLibro1);
		Panel.add(nombreAutor1);
		Panel.add(Lugar1);
		Panel.add(Editorial1);
		Panel.add(LugarEdicion1);
		Panel.add(Fecha1);
		Panel.add(Isbn1);
		Panel.add(Resumen1);

		Titulo.setText("Título");
		Autor.setText("Autor");
		Buscar.setText("Buscar");
		Editar.setText("Editar");
		Insertar.setText("Insertar");
		EditarCompleto.setText("Editar Todo");


		etiquetaordentitulo.setBounds(new Rectangle (0,0, 100, 30));
		etiquetaordentautor.setBounds(new Rectangle (110,0, 100, 30));
		nlibro.setBounds(new Rectangle (550,0, 100, 30));
		etiubicacionnueva.setBounds(new Rectangle (600,0, 100, 30));

		Titulo.setBounds(new Rectangle (0,30, 100, 30));
		Autor.setBounds(new Rectangle (110,30, 100, 30));
		Buscar.setBounds(new Rectangle (220,30, 100, 30));
		Busqueda.setBounds(new Rectangle (330,30, 100, 30));

		Editar.setBounds(new Rectangle (440,30, 100, 30));
		Numero.setBounds(new Rectangle (550,30, 40, 30));
		Edicion.setBounds(new Rectangle (600,30, 100, 30));
		
		
	

		etiquetaTitulo.setBounds(new Rectangle (145,60, 100, 30));
		etiquetaAutor.setBounds(new Rectangle (255,60, 100, 30));
		etiquetaLugar.setBounds(new Rectangle (365,60, 100, 30));
		etiquetaEditorial.setBounds(new Rectangle (465,60, 100, 30));
		etiquetaLugarEdicion.setBounds(new Rectangle (560,60, 100, 30));
		etiquetaFecha.setBounds(new Rectangle (695,60, 100, 30));
		etiquetaIsbn.setBounds(new Rectangle (805,60, 100, 30));
		etiquetaResumen.setBounds(new Rectangle (915,60, 100, 30));
		
		etiquetaNumero1.setBounds(new Rectangle (120,120, 100, 30));
		etiquetaTitulo1.setBounds(new Rectangle (165,120, 100, 30));
		etiquetaAutor1.setBounds(new Rectangle (275,120, 100, 30));
		etiquetaLugar1.setBounds(new Rectangle (385,120, 100, 30));
		etiquetaEditorial1.setBounds(new Rectangle (485,120, 100, 30));
		etiquetaLugarEdicion1.setBounds(new Rectangle (580,120, 100, 30));
		etiquetaFecha1.setBounds(new Rectangle (715,120, 100, 30));
		etiquetaIsbn1.setBounds(new Rectangle (825,120, 100, 30));
		etiquetaResumen1.setBounds(new Rectangle (935,120, 100, 30));

		Insertar.setBounds(new Rectangle (0,90, 100, 30));
		nombreLibro.setBounds(new Rectangle (110,90, 100, 30));
		nombreAutor.setBounds(new Rectangle (220,90, 100, 30));
		Lugar.setBounds(new Rectangle (330,90, 100, 30));
		Editorial.setBounds(new Rectangle (440,90, 100, 30));
		LugarEdicion.setBounds(new Rectangle (550,90, 100, 30));
		Fecha.setBounds(new Rectangle (660,90, 100, 30));
		Isbn.setBounds(new Rectangle (770,90, 100, 30));
		Resumen.setBounds(new Rectangle (880,90, 300, 30));
		
		EditarCompleto.setBounds(new Rectangle (0,150, 100, 30));
		numeroeditar.setBounds(new Rectangle (110,150, 30, 30));
		nombreLibro1.setBounds(new Rectangle (140,150, 100, 30));
		nombreAutor1.setBounds(new Rectangle (250,150, 100, 30));
		Lugar1.setBounds(new Rectangle (360,150, 100, 30));
		Editorial1.setBounds(new Rectangle (470,150, 100, 30));
		LugarEdicion1.setBounds(new Rectangle (580,150, 100, 30));
		Fecha1.setBounds(new Rectangle (690,150, 100, 30));
		Isbn1.setBounds(new Rectangle (800,150, 100, 30));
		Resumen1.setBounds(new Rectangle (910,150, 300, 30));
		//Insertar.setBounds(new Rectangle (550,80, 100, 30));

		/*	Texto.setBounds(new Rectangle( 110, 0, 100, 50));

		Buscar.setText("Buscar");
		Titulo.setBounds(new Rectangle(0,60, 100,50));

		 */


		JFrame Ventana = new JFrame();
		Ventana.setBounds(new Rectangle(1280,720));

		Ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		Panel2 = new JPanel(null);
		Panel.add(Panel2);
		Panel2.setBounds(new Rectangle(10, 200, 1260, 600));


		ventanaSecundaria = new JDialog(Ventana,"Ventana secundaria");
		ventanaSecundaria2 = new JScrollPane();


		Panel2.add(ventanaSecundaria2);
		//JLabel etiqueta = new JLabel("Hola");
		//ventanaSecundaria.getContentPane().add(etiqueta);
		//ventanaSecundaria.pack();

		modelo = new DefaultTableModel();
		 tabla = new JTable(modelo);

		modelo.addColumn("id");
		modelo.addColumn("Título");
		modelo.addColumn("Autor");
		modelo.addColumn("Ubicación");
		modelo.addColumn("Editorial");
		modelo.addColumn("L. Edición");
		modelo.addColumn("Fecha");
		modelo.addColumn("Isbn");
		modelo.addColumn("Resumen");

		//tabla.setBounds(new Rectangle( 500, 500, 500, 500));
		//ventanaSecundaria.add(tabla);

		//ventanaSecundaria.getContentPane().add(tabla);
		tabla.setBounds(new Rectangle(100, 200, 500, 500));

		//Ventana.getContentPane().add(tabla);



		tabla.setPreferredScrollableViewportSize(new Dimension(500, 70));
		//Creamos un JscrollPane y le agregamos la JTable
		JScrollPane scrollPane = new JScrollPane(tabla);
		//Agregamos el JScrollPane al contenedor

		Ventana.getContentPane().add(scrollPane);
		scrollPane.setBounds(new Rectangle(10, 200, 1250, 500));

		//Panel2.getRootPane().add(tabla);

		// Nos devuelve la posición en pixels de una celda en fila,columna
		//	Rectangle r = tabla.getCellRect( i, j, true);

		// Mueve el scroll para que el rectangulo sea visible

		///ventanaSecundaria2.getViewport().scrollRectToVisible (r);

		Ventana.add(Panel);
		Ventana.setVisible(true);

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e)
		{
			e.printStackTrace();
		} 



		try {
			conexion = DriverManager.getConnection ("jdbc:mysql://localhost/biblioteca","root", "kakama22");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



		s = conexion.createStatement();






		Titulo.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				
				try {
					int filas = modelo.getRowCount();
					int columnas = modelo.getColumnCount();
					for(int x= 0 ; x<filas;x++){
						for(int y = 0; y<columnas;y++){
							modelo.setValueAt("", x, y);
						
						}
						
					}
					modelo.setRowCount(0);
					
					rs = s.executeQuery ("select * from libro order by Titulo");
					
				} catch (SQLException e1) {
				}

				try {
					while (rs.next())
					{
						try {
							Object [] fila = new Object[9]; // Hay tres columnas en la tabla
							for (int i=0;i<9;i++)
								fila[i] = rs.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
							// Se añade al modelo la fila completa.
							modelo.addRow(fila); 
						} catch (SQLException e1) {
						}
					}
				} catch (SQLException e1) {
				}


			}
		});

		Autor.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				try {
					int filas = modelo.getRowCount();
					int columnas = modelo.getColumnCount();
					for(int x= 0 ; x<filas;x++){
						for(int y = 0; y<columnas;y++){
							modelo.setValueAt("", x, y);	
						}	
					}
					modelo.setRowCount(0);
					
					
					rs = s.executeQuery ("select *  from libro order by Autor");
				} catch (SQLException e1) {
				}

				try {
					while (rs.next())
					{
						try {
							Object [] fila = new Object[9]; // Hay tres columnas en la tabla
							for (int i=0;i<9;i++)
								fila[i] = rs.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
							// Se añade al modelo la fila completa.
							modelo.addRow(fila); 
						} catch (SQLException e1) {
						}
					}
				} catch (SQLException e1) {
				}


			}
		});


		Editar.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				try {
					String num = Numero.getText();
					String ubi = Edicion.getText();
					String query = "update libro set Ubicacion = '" + ubi+ "' where Numero = '" +  num + "'";
					s.executeUpdate(query);
				} catch (SQLException e1) {
				}
			}
		});

		

		Insertar.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				try {
					rs = s.executeQuery ("select * from libro");
					rs.last();
					int contador = rs.getRow()+1;

				
					String NomAutor = nombreAutor.getText();
					String NomLibro = nombreLibro.getText();
					String NombLugar = Lugar.getText();
					String NomEditorial = Editorial.getText();
					String NomLugarEdicion = LugarEdicion.getText();
					String NombFecha = Fecha.getText();
					String NomIsbn = Isbn.getText();
					String NomResumen = Resumen.getText();
										
					int rows_updated = 0;   
					String query = "INSERT INTO libro (Numero, Titulo, Autor, Ubicacion, Editorial, LugarEdicion, Fecha, Isbn, Resumen) "
						+ "VALUES  ( '" + contador+ "', '" +  NomLibro + "' , '" + NomAutor + 
						"' , '" + NombLugar + "' , '" + NomEditorial + "' , '" + NomLugarEdicion + "' , '" + NombFecha + "' , '" + NomIsbn +"' , '" + NomResumen + "' );";
					System.out.println(query);

					PreparedStatement stmt1 = conexion.prepareStatement(query);
					stmt1.execute();  
				} catch (SQLException e1) {
				}
			}
		});
		
		
		
		Buscar.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				try {
					int filas = modelo.getRowCount();
					int columnas = modelo.getColumnCount();
					for(int x= 0 ; x<filas;x++){
						for(int y = 0; y<columnas;y++){
							modelo.setValueAt("", x, y);	
						}	
					}
					modelo.setRowCount(0);
					
					
String datos = Busqueda.getText();
					
					String query = "select * from libro where Autor like '%" + datos + "%' or Titulo like '%" + datos + "%' or Ubicacion like '%" + datos + "%' or Editorial like '%" + datos + "%'";
					rs = s.executeQuery (query);
				} catch (SQLException e1) {
				}
				
				try {
					while (rs.next())
					{
						try {
							Object [] fila = new Object[9]; // Hay tres columnas en la tabla
							for (int i=0;i<9;i++)
								fila[i] = rs.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
							// Se añade al modelo la fila completa.
							modelo.addRow(fila); 
						} catch (SQLException e1) {
						}
					}
				} catch (SQLException e1) {
				}
			}
		});

		
		
		EditarCompleto.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				try {
					
					
					
					
					String num = numeroeditar.getText();
					String titulolibro = nombreLibro1.getText();
					String nomautor = nombreAutor1.getText();
					String lugarnuevo = Lugar1.getText();
					String editorialnueva = Editorial1.getText();
					String lugaredicionnuevo = LugarEdicion1.getText();
					String fechanueva = Fecha1.getText();
					String Isbnnueva = Isbn1.getText();
					String resumennuevo = Resumen1.getText();
					
					String query = "update libro set Titulo ='" + titulolibro + "' , Autor ='" + nomautor + "' , Ubicacion ='" + lugarnuevo + "' , Editorial='" + editorialnueva + "' , LugarEdicion='" + lugaredicionnuevo + "' , Fecha='" + fechanueva + "' , Isbn ='" + Isbnnueva + "' , Resumen ='" + resumennuevo + "'  where Numero ='" +  num + "'";
				//	String query = "update 'libro' set (Titulo ='" + titulolibro + "' , Autor ='" + nomautor + "' , Ubicacion ='" + lugarnuevo + "'  where Numero ='" +  num + "'";
				//	String query = "update libro set Titulo = '" + titulolibro + "' , Ubicacion = '" + lugarnuevo + "' where Numero = '" +  num + "'";
					
					System.out.println(query);
					s.executeUpdate(query);
				} catch (SQLException e1) {
				}
			}
		});
		
	}

}
