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
	        setContentView(R.layout.lista); //set layout
	        
	        /**
	         * create a bundle and take the element of the other view
	         */
	        Bundle TakeData = getIntent().getExtras();
	        WordText = TakeData.getString("mikey");
	        Orig=TakeData.getString("Orig");
	        Dest=TakeData.getString("Dest");
	     
	        crearBBDD();
	        ArrayList<WordList> Words = getItems();
	        // give the list of word to the adapter
	        setListAdapter(new WordListAdapter(this, R.layout.lista_item, Words));
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
		            	//put the word and the translate word
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

		 String Word = "Fan";
		 String Word2;
		 int LanguageOr=2;
		 int LanguageDest=1;

		    myBBDDHelper.OpenDataBase();

	        //take the words
		    MyListWords = myBBDDHelper.GetWords(WordText, Orig, Dest);
	        //Close
	        myBBDDHelper.close();
	        //retunr words
	        return  MyListWords;
		}
	 
	 
	 
	/**
	 * take the position of the item on the listj
	 */
	 
	 @Override protected void onListItemClick(ListView listView,
             View view,int position, long id) {

super.onListItemClick(listView, view, position, id);

Object o = getListAdapter().getItem(position);

//Toast.makeText(this, "Selección: "+ Integer.toString(position)

//+  " - "+ o.toString(),Toast.LENGTH_LONG).show();



WordList myWordList = new WordList();
myWordList = MyListWords.get(position);

myBBDDHelper.OpenDataBase();

WordList myWordListAux = myBBDDHelper.GetUNL(myWordList);

myBBDDHelper.close();


Bundle bundle = new Bundle();
//send the information to the next view UNL
bundle.putString("descunl",myWordListAux.getDescription());
bundle.putString("wordorig",myWordList.getWord());
bundle.putString("worddest",myWordList.getWordDest());
bundle.putString("desc",myWordList.getDescription());
bundle.putString("UnlWord",myWordListAux.getWord());

Intent myIntent = new Intent(ListController.this, unlhandler.class);
myIntent.putExtras(bundle);
startActivityForResult(myIntent, 0);
//startActivity(myIntent);
}
}
