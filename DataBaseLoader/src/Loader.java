import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;




public class Loader {
	
	
	String dataPath;
	String sqlPath;
	
	public Loader(String DataPath, String SqlPath){
		dataPath=DataPath;
		sqlPath=SqlPath;
	}
	
	
	public String Createpath(String Path){
		StringBuilder newPath = new StringBuilder();
		if(Path.contains("\\")){
			
			newPath.append(Path);
			int i=0;
			int lon = newPath.length();
			while(i<Path.length()){//word.charAt(i)!='\0'){
			//for(int i=0; i<lon-2;i++){
				if( Path.charAt(i)=='\\'){
					newPath.insert(i+1, '\\');
				i++;
				}
				i++;
			}
		}
		return newPath.toString();
	}
	
	String Path;// = "C:\\Users\\Javi\\workspace\\DataBaseLoader\\src\\MilandiDDBB";

	List<Word> ListWords = null;
	List<Description> ListDescription = null;
	public List<Word> LoadColum(int row, int column, int sheetnum, int IDLanguage) throws SQLException{
		
		ListWords=new ArrayList<Word>();

		
		
		
		
		 String PathData;//="C:\\Users\\Javi\\workspace\\DataBaseLoader\\src\\EspFrenIng.xls";
		 PathData=Createpath(dataPath);
		 
	        //Creamos un Workbook para cargar el XLS en memoria 
	        Workbook workbook = null;
			try {
				workbook = Workbook.getWorkbook(new File(PathData));
			} catch (BiffException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        //Elegimos la primera hoja
	        Sheet sheet = workbook.getSheet(sheetnum);
	        //inicializo el objeto que leerá el valor de la celda
	        Cell ActualCell = null;
	        //Este String guardará el valor de la celda
	        String ValueCell=null;
	 
	        //Obtengo el número de filas ocupadas en la hoja
	        int rows=sheet.getRows();
	        //Obtengo el número de columnas ocupadas en la hoja
	        int cols=column;
	 
	        //Para efectos de ejemplo recorremos las columnas de cada fila
	        for(int x=2;x<rows;x++){
	            
	                //Obtenemos el valor de la celda de la columna Y y fila X
	            	ActualCell= sheet.getCell(cols,x);
	                //Obtenemos el valor de la celda
	            	ValueCell= ActualCell.getContents();
	            	ValueCell=validateWord1(ValueCell);
	            	ValueCell=validateWord2(ValueCell);
	            	Word newWord = new Word(sheetnum+1, x-1, IDLanguage, x-1, ValueCell, x-2);
	                 //System.out.print(ValueCell+"|");
	            	ListWords.add(newWord);
	            
	          
	 
	        }
	 
	        workbook.close();
	        return ListWords;
		
		
	}
	
	
	
public List<Description> LoadColumDescription(int row, int column, int sheetnum, int IDLanguage) throws SQLException{
		
		ListDescription=new ArrayList<Description>();

		
		
		
		
		 String PathData;//="C:\\Users\\Javi\\workspace\\DataBaseLoader\\src\\EspFrenIng.xls";
		 PathData=Createpath(dataPath);
		 
	        //Creamos un Workbook para cargar el XLS en memoria 
	        Workbook workbook = null;
			try {
				workbook = Workbook.getWorkbook(new File( PathData));
			} catch (BiffException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        //Elegimos la primera hoja
	        Sheet sheet = workbook.getSheet(sheetnum);
	        //inicializo el objeto que leerá el valor de la celda
	        Cell ActualCell = null;
	        //Este String guardará el valor de la celda
	        String ValueCell=null;
	 
	        //Obtengo el número de filas ocupadas en la hoja
	        int rows=sheet.getRows();
	        //Obtengo el número de columnas ocupadas en la hoja
	        int cols=column;
	 
	        //Para efectos de ejemplo recorremos las columnas de cada fila
	        for(int x=2;x<rows;x++){
	            
	                //Obtenemos el valor de la celda de la columna Y y fila X
	            	ActualCell= sheet.getCell(cols,x);
	                //Obtenemos el valor de la celda
	            	ValueCell= ActualCell.getContents();
	            	ValueCell=validateWord1(ValueCell);
	            	//ValueCell=validateWord2(ValueCell);
	            	Description newDescription = new Description(sheetnum+1, IDLanguage, x-1, ValueCell, x-1);
	            	
	              //   System.out.print(ValueCell+"|");
	            	ListDescription.add(newDescription);
	            
	          
	 
	        }
	 
	        workbook.close();
	        return ListDescription;
		
		
	}
	
	
	public int LastIdRealWord() throws SQLException{
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName("org.sqlite.JDBC");
			 String PathSql;//="C:\\Users\\Javi\\workspace\\DataBaseLoader\\src\\EspFrenIng.xls";
			 PathSql=Createpath(sqlPath);
		 conn = DriverManager.getConnection("jdbc:sqlite:"+ PathSql);
		 stat = conn.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ResultSet rs = stat.executeQuery("select count(*) from Word");
		
		int id= rs.getInt("count(*)");
		//id++;
		
		//stat.executeUpdate("Select count(*) into Language values ('" +id +"', 'portugues')");
		System.out.println("count" +id);
		conn.close();
		return id;		
	}
	
	public int LastIdWordLanguage(int IdLanguage) throws SQLException{
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName("org.sqlite.JDBC");
			String PathSql;//="C:\\Users\\Javi\\workspace\\DataBaseLoader\\src\\EspFrenIng.xls";
			 PathSql=Createpath(sqlPath);
		 conn = DriverManager.getConnection("jdbc:sqlite:"+ PathSql);
		 stat = conn.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ResultSet rs = stat.executeQuery("select count(*) from Word where IDLanguage=" + IdLanguage);
		
		int id= rs.getInt("count(*)");
		//id++;
		
		//stat.executeUpdate("Select count(*) into Language values ('" +id +"', 'portugues')");
		System.out.println("count" +id);
		conn.close();
		return id;	
		}
	
	public String validateWord1(String word){
		StringBuilder nuevo = new StringBuilder();
		if(word.contains("\"")){
			
			System.out.println("contiene");
			nuevo.append(word);
			int i=0;
			int lon = nuevo.length();
			while(i<word.length()){//word.charAt(i)!='\0'){
			//for(int i=0; i<lon-2;i++){
				if( word.charAt(i)=='"'){
				nuevo.insert(i+1, '"');
				i++;
			
				}
				i++;
			}
				return nuevo.toString();
				
			
		}
		return word;
	}
	
	public String validateWord2(String word){
		StringBuilder nuevo = new StringBuilder();
		if(word.contains("\'")){
			
			System.out.println("contiene");
			nuevo.append(word);
			for(int i=0; i<nuevo.length()-1;i++){
				if( nuevo.charAt(i)=='\''){
				nuevo.insert(i+1, '\'');
				i++;
				}
			}
				return nuevo.toString();
				
			
		}
		return word;
	}
	
	
	public void insertWord(Word myInsertWord) throws SQLException{
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName("org.sqlite.JDBC");
			String PathSql;//="C:\\Users\\Javi\\workspace\\DataBaseLoader\\src\\EspFrenIng.xls";
			 PathSql=Createpath(sqlPath);
		 conn = DriverManager.getConnection("jdbc:sqlite:"+ PathSql);
		 stat = conn.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query= "'" + myInsertWord.IDType  + "','" + myInsertWord.IDWord + "','" + myInsertWord.IDLanguage + "','" + myInsertWord.IDWordAux + "',\"" + myInsertWord.Word + "\",'" + myInsertWord.IDDescription +"'";
		stat.executeUpdate("insert into word (IDType, IDWord, IDLanguage,_id, Word, IDDescription) Values ("+ query +  ")");
		stat.close();
	}
	
	
	public int LastIdRealDescription() throws SQLException{
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName("org.sqlite.JDBC");
			String PathSql;//="C:\\Users\\Javi\\workspace\\DataBaseLoader\\src\\EspFrenIng.xls";
			 PathSql=Createpath(sqlPath);
		 conn = DriverManager.getConnection("jdbc:sqlite:"+ PathSql);
		 stat = conn.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ResultSet rs = stat.executeQuery("select count(*) from Description");
		
		int id= rs.getInt("count(*)");
	//	if(id!=0)id++;
		//id++;
		
		//stat.executeUpdate("Select count(*) into Language values ('" +id +"', 'portugues')");
		System.out.println("count" +id);
		conn.close();
		return id;		
	}
	
	public int LastIdDescriptionLanguage(int IdDescription) throws SQLException{
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName("org.sqlite.JDBC");
			String PathSql;//="C:\\Users\\Javi\\workspace\\DataBaseLoader\\src\\EspFrenIng.xls";
			 PathSql=Createpath(sqlPath);
		 conn = DriverManager.getConnection("jdbc:sqlite:"+ PathSql);
		 stat = conn.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ResultSet rs = stat.executeQuery("select count(*) from Description where IDLanguage='" + IdDescription + "'");
		
		int id= rs.getInt("count(*)");
		//if (id!=0) id=id+1;
		//id++;
		
		//stat.executeUpdate("Select count(*) into Language values ('" +id +"', 'portugues')");
		System.out.println("count" +id);
		conn.close();
		return id;	
		}
	
	
	public void insertDescription(Description myInsertDescription) throws SQLException{
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName("org.sqlite.JDBC");
			String PathSql;//="C:\\Users\\Javi\\workspace\\DataBaseLoader\\src\\EspFrenIng.xls";
			 PathSql=Createpath(sqlPath);
		 conn = DriverManager.getConnection("jdbc:sqlite:"+ PathSql);
		 stat = conn.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String query= "'" + myInsertDescription.IDType+ "','" + myInsertDescription.IDLanguage + "','" + myInsertDescription.IDWord +"','"+ myInsertDescription.IDDescriptionAux +"',\"" + myInsertDescription.Description+ "\""  ;
		stat.executeUpdate("insert into Description (IDType, IDLanguage,IDWord, _id, Description) Values ("+ query +  ")");
		stat.close();
	}
	
	
	public void InsertWords(List<Word> ListWords, int IDLanguage) throws SQLException{
		int IDWordNew=LastIdWordLanguage(IDLanguage);
		int LastID=LastIdRealWord();
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName("org.sqlite.JDBC");
			String PathSql;//="C:\\Users\\Javi\\workspace\\DataBaseLoader\\src\\EspFrenIng.xls";
			 PathSql=Createpath(sqlPath);
		 conn = DriverManager.getConnection("jdbc:sqlite:"+ PathSql);
		 stat = conn.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<ListWords.size();i++){
			
			Word myInsertWord=ListWords.get(i);
			myInsertWord.IDWord=myInsertWord.IDWord+IDWordNew;
			myInsertWord.IDWordAux=myInsertWord.IDWordAux+LastID;
			myInsertWord.IDDescription=myInsertWord.IDWord;
			insertWord(myInsertWord);
			
		}
		
	
		conn.close();
		
	}
	
	
	public void InsertDescriptions(List<Description> ListDescription, int IDLanguage) throws SQLException{
		int IDDescriptionsNew=LastIdDescriptionLanguage(IDLanguage);
		int LastID=LastIdRealDescription();
		Connection conn = null;
		Statement stat = null;
		try {
			Class.forName("org.sqlite.JDBC");
			String PathSql;//="C:\\Users\\Javi\\workspace\\DataBaseLoader\\src\\EspFrenIng.xls";
			 PathSql=Createpath(sqlPath);
		 conn = DriverManager.getConnection("jdbc:sqlite:"+ PathSql);
		 stat = conn.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<ListDescription.size();i++){
			
			Description myInsertDescription=ListDescription.get(i);
			//myInsertDescription.IDDescription=myInsertDescription.IDDescription+IDDescriptionsNew;
			myInsertDescription.IDDescriptionAux=myInsertDescription.IDDescriptionAux+LastID;
			//myInsertDescription.IDWord=myInsertDescription.IDDescription;
			//String query= "'" + myInsertWord.IDType  + "','" + myInsertWord.IDWord + "','" + myInsertWord.IDLanguage + "','" + myInsertWord.IDWordAux + "',\"" + myInsertWord.Word + "\",'" + myInsertWord.IDDescription +"'";
			//stat.executeQuery("insert into word (IDType, IDWord, IDLanguage,IDWordAux, Word, IDDescription) Values ("+ query +  ")");
			//stat.close();
			//int id= rs.getInt("count(*)");
			insertDescription(myInsertDescription);
			
		}
		
	
		conn.close();
		
	}
}
