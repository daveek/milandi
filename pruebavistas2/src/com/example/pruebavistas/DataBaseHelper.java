package com.example.pruebavistas;



import java.io.FileOutputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
 
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import static android.provider.BaseColumns._ID;
 
/**
* Clase que facilita el acceso a una Base de Datos SQLite creando la Base de datos a partir de un fichero
* en la carpeta Assets
* blog.findemor.es 06/02/2011
**/
public class DataBaseHelper extends SQLiteOpenHelper {
 
        //La carpeta por defecto donde Android espera encontrar la Base de Datos de tu aplicación
        private static String DB_PATH = "/data/data/com.example.pruebavistas/";
        private static String DB_NAME = "MilandiDDBB";
        private SQLiteDatabase myDataBase;
 
        private final Context myContext;
 
        /**
         * Constructor
         *
         * Guarda una referencia al contexto para acceder a la carpeta assets de la aplicación y a los recursos
         * @param contexto
         **/
        public DataBaseHelper(Context context) {
 
            super(context, DB_NAME, null, 1);
            this.myContext = context;
        }
 
      /**
       * Crea una base de datos vacía en el sistema y la sobreescribe con la que hemos puesto en Assets
       **/
        public void CreateDataBase() throws IOException{
 
            boolean dbExist = CheckDataBase();
 
            if(dbExist){
                //Si ya existe no hacemos nada
            }else{
                //Si no existe, creamos una nueva Base de datos en la carpeta por defecto de nuestra aplicación,
                //de esta forma el Sistema nos permitirá sobreescribirla con la que tenemos en la carpeta Assets
                this.getReadableDatabase();
                try {
                    CopyDataBase();
                } catch (IOException e) {
                    throw new Error("Error at copy Data Base");
                }
            }
        }
 
        /**
         * Comprobamos si la base de datos existe
         * @return true si existe, false en otro caso
         **/
        private boolean CheckDataBase(){
            SQLiteDatabase checkDB = null;
            try{
                String myPath = DB_PATH + DB_NAME;
                checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
            }catch(SQLiteException e){
                //No existe
            }
 
            if(checkDB != null){
                checkDB.close();
            }
 
            return checkDB != null ? true : false;
        }
 
        /**
         * Copia la base de datos desde la carpeta Assets sobre la base de datos vacía recién creada en la carpeta del sistema,
         * desde donde es accesible
         **/
        private void CopyDataBase() throws IOException{
 
            //Abrimos la BBDD de la carpeta Assets como un InputStream
            InputStream myInput = myContext.getAssets().open(DB_NAME);
 
            //Carpeta de destino (donde hemos creado la BBDD vacia)
            String outFileName = DB_PATH + "databases/" + DB_NAME;
 
            //Abrimos la BBDD vacia como OutputStream
            OutputStream myOutput = new FileOutputStream(outFileName);
 
            //Transfiere los Bytes entre el Stream de entrada y el de Salida
            byte[] buffer = new byte[1024];
            int length;
            while ((length = myInput.read(buffer))>0){
                myOutput.write(buffer, 0, length);
            }
 
            //Cerramos los ficheros abiertos
            myOutput.flush();
            myOutput.close();
            myInput.close();
        }
 
        /**
         * Abre la base de datos
         **/
        public void OpenDataBase() throws SQLException{
            String myPath = DB_PATH + "databases/" + DB_NAME;
            myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
 
        }
 
        /**
         * Cierra la base de datos
         **/
        @Override
        public synchronized void close() {
                if(myDataBase != null)
                    myDataBase.close();
 
                super.close();
        }
 
        @Override
        public void onCreate(SQLiteDatabase db) {
            //No usamos este método
        }
 
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //No usamos este método
        }
 
        //Podemos añadir métodos públicos que accedan al contenido de la base de datos,
        //para realizar consultas, u operaciones CRUD (create, read, update, delete)
        
  
        /*
         * Obtiene todos los libros desde la Base de Datos
         */
        
        
        
         public ArrayList<WordList> GetLibros(String Word, String LanguageOr, String LanguageDest){
            ArrayList<WordList> WordList1 = new ArrayList<WordList>();
            
            ArrayList<WordList> WordList2 = new ArrayList<WordList>();
           // Cursor wordTranslated = myDataBase.rawQuery("Select Word, IDWord, IDType from Word where IDWord ='238' and IDLanguage='2' and IDType='1'", null);
            Cursor Or = myDataBase.rawQuery("Select _id from Language where Name='" +LanguageOr + "'", null);
            Cursor Des = myDataBase.rawQuery("Select _id from Language where Name='" +LanguageDest + "'", null);
           // Cursor random = myDataBase.rawQuery("Select IDWord, Word from Language where IDWord='238' and IDLanguage='2'", null);
            
            Or.moveToFirst();
            String Orig=Or.getString(0);
            Or.close();
            Des.moveToFirst();
            String Dest=Des.getString(0);
            Des.close();
            Cursor c = myDataBase.rawQuery("Select Word, IDWord, IDType from Word where Word.Word like '%"+Word+"%' and IDLanguage='"+Orig+"'", null);
         
   
         
            //Iteramos a traves de los registros del cursor
            c.moveToFirst();
             while (c.isAfterLast() == false) {
            	 WordList WordAux = new WordList();
          
               WordAux.setWord(c.getString(0));
                WordAux.setIDnumber(c.getString(1));
                WordAux.setType(c.getString(2));
                WordList1.add(WordAux);
                    c.moveToNext();
             }
             c.close();
         int i=0;
             while(i<WordList1.size()){
            	 WordList WordinList = WordList1.get(i); 
            	 String queryrw="Select Word,IDWord,IDType from Word where Word.IDWord = '"+WordinList.getIDnumber()+"' and IDLanguage='"+Dest+"' and IDType='"+WordinList.getType()+"'";
            	 String querydescription="Select Description from Description where IDType = '"+WordinList.getType()+"' and IDLanguage='"+Dest+"' and IDWord='"+WordinList.getIDnumber()+"'";
            	 Cursor DescriptionTrans = myDataBase.rawQuery(querydescription, null);
            	 Cursor wordTranslated = myDataBase.rawQuery(queryrw, null);
            	 DescriptionTrans.moveToFirst();
            	wordTranslated.moveToFirst();
            	WordList WordNewList = new WordList();
            	 WordNewList.setIDnumber(wordTranslated.getString(1));
            	 WordNewList.setWordDest(wordTranslated.getString(0));
            	 WordNewList.setType(changeType(Integer.parseInt(wordTranslated.getString(2))));
            	 WordNewList.setWord(WordinList.getWord());
            	 WordNewList.setDescription(DescriptionTrans.getString(0));
            	 WordNewList.setiddesc(WordinList.getType());
            	 WordNewList.settypeNumber(WordinList.getIDnumber());
            	 WordList2.add(WordNewList);
            	 wordTranslated.close();
            	 i++;
             }
             
             return WordList2;
         }
         
         private String changeType(int numero){
        	 String res=" ";
        	 switch (numero) {
			case 1:
				res=("Noun");
				break;
			case 2:
				res=("Adjective");
				break;
			case 3:
				res=("Adverb");
				break;
			case 4:
				res=("Verb");
				break;
			default:
				break;
			}
			return res;
         }
         
         public WordList GetUNL(WordList WordinList){
        	 int types=Typetoint(WordinList.getType());
        	 String querydescription="Select Description from Description where IDType = '"+types+"' and IDLanguage='4' and IDWord='"+WordinList.getIDnumber()+"'";
        	 String queryUNLword="Select Word from Word where IDType = '"+types+"' and IDLanguage='4' and IDWord='"+WordinList.getIDnumber()+"'";
        	 
        	 Cursor c = myDataBase.rawQuery(querydescription, null);
        	 Cursor w = myDataBase.rawQuery(queryUNLword, null);
        	 c.moveToFirst();
        	 w.moveToFirst();
        	 WordList res= new WordList();
        	 res.setDescription(c.getString(0));
        	 res.setWord(w.getString(0));
             
			return res;
         }
         
         private int Typetoint(String type){
        	 if(type.equals("Noun")) return 1;
        	 if(type.equals("Adjective")) return 2;
        	 if(type.equals("Adverb")) return 3;
        	 if(type.equals("Verb")) return 4;
			return 0;
         }
         
 
}