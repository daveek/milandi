package com.example.pruebavistas;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import com.example.pruebavistas.PersonalEditText;

public class MainActivity extends Activity {

	final public static String MyKey = "mikey";
	PersonalEditText WordText;
    String Word;
  //  final Drawable searchicon = getResources().getDrawable(android.R.drawable.ic_menu_search ); 		
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WordText=(PersonalEditText)findViewById(R.id.editText1);
       // Button searchb=(Button)findViewById(R.id.search);
        //searchb.setBackgroundDrawable(searchicon);
        // languajes of the spinner
        final String[] languages =
		        new String[]{"Spanish","English","French","Swahili","Elem5"};
		// set languages in the spinner 
		ArrayAdapter<String> adapter =
		        new ArrayAdapter<String>(this,
		            android.R.layout.simple_spinner_item, languages);
		
		final Spinner cmbLenOrig = (Spinner)findViewById(R.id.LangOrig);
		 
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		 
		cmbLenOrig.setAdapter(adapter);
		
		final Spinner cmbLenDest = (Spinner)findViewById(R.id.LangDest);
		 
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		 
		cmbLenDest.setAdapter(adapter);

        /**
         * Functionality of the search button
         * take the selected language in the spinner
         * we use bundle because we need to send information to the next view
         */
        Button search = (Button) findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            	  Bundle bundle = new Bundle();
            	  Word=WordText.getText().toString();
            	  String Orig = cmbLenOrig.getSelectedItem().toString();
            	  String Dest = cmbLenDest.getSelectedItem().toString();
                  bundle.putString(MyKey,Word);
                  bundle.putString("Orig", Orig);
                  bundle.putString("Dest", Dest);
                Intent myIntent = new Intent(view.getContext(), ListController.class);
                myIntent.putExtras(bundle);
                startActivityForResult(myIntent, 0);
            }
        });
        
        
        /**
         * Functionality of the information view
         */
        Button information = (Button) findViewById(R.id.info);
        information.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            	
            	Bundle bundle = new Bundle();
            	bundle.putString("MyKey2","texto unl2");

            	Intent myIntent = new Intent(view.getContext(), info.class);
            	myIntent.putExtras(bundle);
            	startActivity(myIntent);
            	
            }
        });
        
       /* Button cancel = (Button) findViewById(R.id.delete);
        cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            	 WordText=(PersonalEditText)findViewById(R.id.editText1);
            	 WordText.setText(null);
            	
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    
}
