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
*Class that provides access to a database SQLite 
*Database created from a file in the Assets folder
* blog.findemor.es 06/02/2011
**/
public class DataBaseHelper extends SQLiteOpenHelper {
 
       
        private static String DB_PATH = "/data/data/com.example.pruebavistas/";
        private static String DB_NAME = "MilandiDDBB";
        private SQLiteDatabase myDataBase;
 
        private final Context myContext;
 
        /**
         * Constructor
         *Save a reference to contect to acces the dir assets and take the database
         * @param contexto
         **/
        public DataBaseHelper(Context context) {
 
            super(context, DB_NAME, null, 1);
            this.myContext = context;
        }
 
      /**
       * Create a empty database and overwrite this with our database
       **/
        public void CreateDataBase() throws IOException{
 
            boolean dbExist = CheckDataBase();
 
            if(dbExist){
                //if exist dont do nothing
            }else{
            	//If not exist, create a new database in the folder of the aplication
                //later we overwrite the database
                this.getReadableDatabase();
                try {
                    CopyDataBase();
                } catch (IOException e) {
                    throw new Error("Error at copy Data Base");
                }
            }
        }
 
        /**
         * check the existence od the database
         * @return true if exist, else false
         **/
        private boolean CheckDataBase(){
            SQLiteDatabase checkDB = null;
            try{
                String myPath = DB_PATH + DB_NAME;
                checkDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
            }catch(SQLiteException e){
                //no exist
            }
 
            if(checkDB != null){
                checkDB.close();
            }
 
            return checkDB != null ? true : false;
        }
 
        /**
         * Copy the new database overwriting the old database.
         * 
         **/
        private void CopyDataBase() throws IOException{
 
            //open database from folder assests
            InputStream myInput = myContext.getAssets().open(DB_NAME);
 
            //Destiny folder
            String outFileName = DB_PATH + "databases/" + DB_NAME;
 
            //Open empty database
            OutputStream myOutput = new FileOutputStream(outFileName);
 
            //Copy database
            byte[] buffer = new byte[1024];
            int length;
            while ((length = myInput.read(buffer))>0){
                myOutput.write(buffer, 0, length);
            }
 
            //close files
            myOutput.flush();
            myOutput.close();
            myInput.close();
        }
 
        /**
         * Open Database
         **/
        public void OpenDataBase() throws SQLException{
            String myPath = DB_PATH + "databases/" + DB_NAME;
            myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READONLY);
 
        }
 
        /**
         * close Database
         **/
        @Override
        public synchronized void close() {
                if(myDataBase != null)
                    myDataBase.close();
 
                super.close();
        }
 
        @Override
        public void onCreate(SQLiteDatabase db) {
            //not used
        }
 
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //Not used
        }
 

        
  
        /*
         * Take all the words searched
         */
        
        
        
         public ArrayList<WordList> GetWords(String Word, String LanguageOr, String LanguageDest){
            ArrayList<WordList> WordList1 = new ArrayList<WordList>();
            ArrayList<WordList> WordList2 = new ArrayList<WordList>();
          
            
            //transform the IDLanguage into a text name
            Cursor Or = myDataBase.rawQuery("Select _id from Language where Name='" +LanguageOr + "'", null);
            Cursor Des = myDataBase.rawQuery("Select _id from Language where Name='" +LanguageDest + "'", null);
         
            
            Or.moveToFirst();
            String Orig=Or.getString(0);
            Or.close();
            Des.moveToFirst();
            String Dest=Des.getString(0);
            Des.close();
            
            //search the words
            Cursor c = myDataBase.rawQuery("Select Word, IDWord, IDType from Word where Word.Word like '%"+Word+"%' and IDLanguage='"+Orig+"'", null);
         
   
         
            //enter words in the list
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
            	 //query for translate the word
            	 String queryrw="Select Word,IDWord,IDType from Word where Word.IDWord = '"+WordinList.getIDnumber()+"' and IDLanguage='"+Dest+"' and IDType='"+WordinList.getType()+"'";
            	//query for take the translated description
            	 String querydescription="Select Description from Description where IDType = '"+WordinList.getType()+"' and IDLanguage='"+Dest+"' and IDWord='"+WordinList.getIDnumber()+"'";
            	 Cursor DescriptionTrans = myDataBase.rawQuery(querydescription, null);
            	 Cursor wordTranslated = myDataBase.rawQuery(queryrw, null);
            	 DescriptionTrans.moveToFirst();
            	wordTranslated.moveToFirst();
            	WordList WordNewList = new WordList();
            	//insert the word and the description in the new list.
            	 WordNewList.setIDnumber(wordTranslated.getString(1));
            	 WordNewList.setWordDest(wordTranslated.getString(0));
            	 WordNewList.setType(changeType(Integer.parseInt(wordTranslated.getString(2))));
            	 WordNewList.setWord(WordinList.getWord());
            	 WordNewList.setDescription(DescriptionTrans.getString(0));
            	 WordNewList.setiddesc(WordinList.getType());
            	 WordNewList.settypeNumber(WordinList.getIDnumber());
            	 WordList2.add(WordNewList);
            	 wordTranslated.close();
            	 DescriptionTrans.close();
            	 i++;
             }
             
             return WordList2;
         }
         
         private String changeType(int number){
        	 String res=" ";
        	 switch (number) {
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
        	 //querys for search the UNL word and the Atributes of UNL word
        	 String querydescription="Select Description from Description where IDType = '"+types+"' and IDLanguage='4' and IDWord='"+WordinList.getIDnumber()+"'";
        	 String queryUNLword="Select Word from Word where IDType = '"+types+"' and IDLanguage='4' and IDWord='"+WordinList.getIDnumber()+"'";
        	 
        	 Cursor c = myDataBase.rawQuery(querydescription, null);
        	 Cursor w = myDataBase.rawQuery(queryUNLword, null);
        	 c.moveToFirst();
        	 w.moveToFirst();
        	 WordList res= new WordList();
        	 res.setDescription(c.getString(0));
        	 res.setWord(w.getString(0));
             c.close();
             w.close();
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