
import java.awt.event.*;
import java.io.File;
import java.sql.SQLException;
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
		
		if (evento.getSource()==window.InsertTheLanguage){//si hay evento en el boton examinar
			//mostramos el jFileChooser
			
			LoadInfo myInfo=new LoadInfo(window.jtfDataPath.getText(), window.jtfSqlPath.getText(),Integer.parseInt(window.LanguageColumn.getText()),Integer.parseInt(window.LanguageIdVocabulary.getText()));
		 	try {
				myInfo.loadWords();
				//myInfo.loadDescription();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		if (evento.getSource()==window.InsertTheLanguageDesc){//si hay evento en el boton examinar
			//mostramos el jFileChooser
			
			LoadInfo myInfo=new LoadInfo(window.jtfDataPath.getText(), window.jtfSqlPath.getText(),Integer.parseInt(window.LanguageColumn2.getText()),Integer.parseInt(window.LanguageIdVocabulary2.getText()));
		 	try {
				//myInfo.loadWords();
				myInfo.loadDescription();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (evento.getSource()==window.InsertLanguage){
			LoadInfo myInfo=new LoadInfo(window.jtfDataPath.getText(), window.jtfSqlPath.getText(),0,0);
		 	try {
				myInfo.insertLang(Integer.parseInt(window.LanguageId.getText()), window.LanguageName.getText());
			System.out.println("idioma introducido");
		 	} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		if (evento.getSource()==window.jbDelete){
			//System.out.println(window.jtfDataPath.getText() +  window.jtfDataPath.getText());
			LoadInfo myInfo=new LoadInfo(window.jtfDataPath.getText(), window.jtfSqlPath.getText(),1,Integer.parseInt(window.LanguageIdDelete.getText()));
		 	try {
		 		System.out.println("borra");
				myInfo.deleteLang(Integer.parseInt(window.LanguageIdDelete.getText()));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//mostramos la ruta del archivo en la caja de texto
		
		
		//if (evento.getSource()==window.jbLoad){//si hay evento en el boton load
		 //	if ( fileData != null) {
          //   	}}
	}
}

