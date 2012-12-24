package com.example.pruebavistas;

import java.io.IOException;
import java.util.ArrayList;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListController extends ListActivity {
	String WordText;
	String Orig;
	String Dest;
	ArrayList<WordList> MyListWords;
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.lista); //establecemos el Layout de esta Actividad
	        
	        Bundle TakeData = getIntent().getExtras();//Creamos un objeto de tipo Bundle que guardará todos los datos recibidos
	        WordText = TakeData.getString("mikey");
	        Orig=TakeData.getString("Orig");
	        Dest=TakeData.getString("Dest");
	        //WordText=(EditText)findViewById(R.id.editText1);
	        crearBBDD();
	        ArrayList<WordList> Libros = getItems();
	        // Entregamos la lista de Libros al adaptador de la lista en el Layout Lista.xml
	        setListAdapter(new WordListAdapter(this, R.layout.lista_item, Libros));
	    }	
	 
	 private class WordListAdapter extends ArrayAdapter<WordList> {
		 
		    private ArrayList<WordList> items;
		 
		    public WordListAdapter(Context context, int textViewResourceId, ArrayList<WordList> items) {
		        super(context, textViewResourceId, items);
		        this.items = items;
		        
		    }
		 
		    @Override
		    public View getView(int position, View convertView, ViewGroup parent) {
		        View v = convertView;
		        if (v == null) {
		            LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		            v = vi.inflate(R.layout.lista_item, null);
		        }
		        WordList word = items.get(position);
		        if (word != null) {
		            TextView WordOrig = (TextView) v.findViewById(R.id.WordOrig);
		            TextView WordDest = (TextView) v.findViewById(R.id.WordDest);
		            if (WordOrig != null) {
		            	StringBuilder Words = new StringBuilder();
		            	Words.append(word.getType() + ": ");
		            	
		            	Words.append(word.getWord());
		            	Words.append("  ->  ");
		            	Words.append(word.getWordDest());
		            	WordOrig.setText(Words.toString());
		            }
		            if (WordDest != null) {
		            	WordDest.setText(word.getDescription());
		            }
		        }
		        return v;
		    }
		}
	 
	 DataBaseHelper myBBDDHelper;
	 
	    public void crearBBDD() {
	        myBBDDHelper = new DataBaseHelper(this);
	        try {
	            myBBDDHelper.CreateDataBase();
	        } catch (IOException ioe) {
	            throw new Error("Unable to create database");
	        }
	    }
	 
	 
	 public ArrayList<WordList> getItems() {
		   // ArrayList<PalabraLista> MiLista = new ArrayList<PalabraLista>();
		 String Word = "Fan";
		 String Word2;
		 int LanguageOr=2;
		 int LanguageDest=1;
		    // Creamos los objetos Libro
		    myBBDDHelper.OpenDataBase();
			//EditText WordText=(EditText)findViewById(R.id.editText1);
		//	Word2=WordText.getText().toString();
	        //Consultamos los datos
		    MyListWords = myBBDDHelper.GetLibros(WordText, Orig, Dest);
	        //Cerramos la conexion
	        myBBDDHelper.close();
	        //Devolvemos los datos
	        return  MyListWords;
		}
	 
	 
	 
	// @Override public void onListItemClick
	 
	 @Override protected void onListItemClick(ListView listView,
             View view,int position, long id) {

super.onListItemClick(listView, view, position, id);

Object o = getListAdapter().getItem(position);

Toast.makeText(this, "Selección: "+ Integer.toString(position)

+  " - "+ o.toString(),Toast.LENGTH_LONG).show();


//View vi=new View(null);
WordList myPalabraLista = new WordList();
myPalabraLista = MyListWords.get(position);

myBBDDHelper.OpenDataBase();
//EditText WordText=(EditText)findViewById(R.id.editText1);
//	Word2=WordText.getText().toString();
//Consultamos los datos
WordList myPalabraListaAux = myBBDDHelper.GetUNL(myPalabraLista);
//Cerramos la conexion
myBBDDHelper.close();

//PalabraLista myPalabraListaAux= GetUNL(myPalabraLista);
Bundle bundle = new Bundle();

bundle.putString("descunl",myPalabraListaAux.getDescription());
bundle.putString("wordorig",myPalabraLista.getWord());
bundle.putString("worddest",myPalabraLista.getWordDest());
bundle.putString("desc",myPalabraLista.getDescription());
bundle.putString("UnlWord",myPalabraListaAux.getWord());

Intent myIntent = new Intent(ListController.this, unlhandler.class);
myIntent.putExtras(bundle);
startActivityForResult(myIntent, 0);
//startActivity(myIntent);
}
}
