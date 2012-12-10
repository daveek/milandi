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

public class ControladorLista extends ListActivity {
	String WordText;
	String Orig;
	String Dest;
	ArrayList<PalabraLista> MiLista;
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.lista); //establecemos el Layout de esta Actividad
	        
	        Bundle TakeData = getIntent().getExtras();//Creamos un objeto de tipo Bundle que guardará todos los datos recibidos
	        WordText = TakeData.getString("mikey");
	        Orig=TakeData.getString("Orig");
	        Dest=TakeData.getString("Dest");
	        //WordText=(EditText)findViewById(R.id.editText1);
	        crearBBDD();
	        ArrayList<PalabraLista> Libros = getItems();
	        // Entregamos la lista de Libros al adaptador de la lista en el Layout Lista.xml
	        setListAdapter(new PalabraListaAdapter(this, R.layout.lista_item, Libros));
	    }	
	 
	 private class PalabraListaAdapter extends ArrayAdapter<PalabraLista> {
		 
		    private ArrayList<PalabraLista> items;
		 
		    public PalabraListaAdapter(Context context, int textViewResourceId, ArrayList<PalabraLista> items) {
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
		        PalabraLista libro = items.get(position);
		        if (libro != null) {
		            TextView WordOrig = (TextView) v.findViewById(R.id.WordOrig);
		            TextView WordDest = (TextView) v.findViewById(R.id.WordDest);
		            if (WordOrig != null) {
		            	StringBuilder Words = new StringBuilder();
		            	Words.append(libro.getType() + ": ");
		            	
		            	Words.append(libro.getWord());
		            	Words.append("  ->  ");
		            	Words.append(libro.getWordDest());
		            	WordOrig.setText(Words.toString());
		            }
		            if (WordDest != null) {
		            	WordDest.setText(libro.getDescription());
		            }
		        }
		        return v;
		    }
		}
	 
	 BaseDatosHelper miBBDDHelper;
	 
	    public void crearBBDD() {
	        miBBDDHelper = new BaseDatosHelper(this);
	        try {
	            miBBDDHelper.crearDataBase();
	        } catch (IOException ioe) {
	            throw new Error("Unable to create database");
	        }
	    }
	 
	 
	 public ArrayList<PalabraLista> getItems() {
		   // ArrayList<PalabraLista> MiLista = new ArrayList<PalabraLista>();
		 String Word = "Fan";
		 String Word2;
		 int LanguageOr=2;
		 int LanguageDest=1;
		    // Creamos los objetos Libro
		    miBBDDHelper.abrirBaseDatos();
			//EditText WordText=(EditText)findViewById(R.id.editText1);
		//	Word2=WordText.getText().toString();
	        //Consultamos los datos
		     MiLista = miBBDDHelper.GetLibros(WordText, Orig, Dest);
	        //Cerramos la conexion
	        miBBDDHelper.close();
	        //Devolvemos los datos
	        return  MiLista;
		}
	 
	 
	 
	// @Override public void onListItemClick
	 
	 @Override protected void onListItemClick(ListView listView,
             View view,int position, long id) {

super.onListItemClick(listView, view, position, id);

Object o = getListAdapter().getItem(position);

Toast.makeText(this, "Selección: "+ Integer.toString(position)

+  " - "+ o.toString(),Toast.LENGTH_LONG).show();


//View vi=new View(null);
PalabraLista myPalabraLista = new PalabraLista();
myPalabraLista = MiLista.get(position);

miBBDDHelper.abrirBaseDatos();
//EditText WordText=(EditText)findViewById(R.id.editText1);
//	Word2=WordText.getText().toString();
//Consultamos los datos
PalabraLista myPalabraListaAux = miBBDDHelper.GetUNL(myPalabraLista);
//Cerramos la conexion
miBBDDHelper.close();

//PalabraLista myPalabraListaAux= GetUNL(myPalabraLista);
Bundle bundle = new Bundle();

bundle.putString("descunl",myPalabraListaAux.getDescription());
bundle.putString("wordorig",myPalabraLista.getWord());
bundle.putString("worddest",myPalabraLista.getWordDest());
bundle.putString("desc",myPalabraLista.getDescription());

Intent myIntent = new Intent(ControladorLista.this, unlhandler.class);
myIntent.putExtras(bundle);
startActivityForResult(myIntent, 0);
//startActivity(myIntent);
}
}
