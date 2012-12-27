
import java.awt.event.*;
import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
public class EventController implements ActionListener{
	WindowLoad window;
	File fileData;
	File fileSql;
	public EventController(WindowLoad objeto){
		window = objeto;
	}
	public void actionPerformed(ActionEvent evento)
    {
		if (evento.getSource()==window.jbExaminar){//si hay evento en el boton examinar
			int returnVal = window.jfcLoadExc.showOpenDialog(window);//mostramos el jFileChooser
		 	if (returnVal == window.jfcLoadExc.APPROVE_OPTION) {//nos aseguramos q haya selecionado algun archivo
             	fileData = window.jfcLoadExc.getSelectedFile();//obtenemos el archivo selecionado
             	window.jtfDataPath.setText(fileData.toString());	}}//mostramos la ruta del archivo en la caja de texto

		if (evento.getSource()==window.jbLExc){//si hay evento en el boton examinar
			int returnVal = window.jfcLoadExc.showOpenDialog(window);//mostramos el jFileChooser
		 	if (returnVal == window.jfcLoadExc.APPROVE_OPTION) {//nos aseguramos q haya selecionado algun archivo
             	fileSql = window.jfcLoadExc.getSelectedFile();//obtenemos el archivo selecionado
             	window.jtfSqlPath.setText(fileSql.toString());	}}//mostramos la ruta del archivo en la caja de texto
		
		if (evento.getSource()==window.jbLoad){//si hay evento en el boton load
		 	if ( fileData != null) {
             	}}
	}
}

