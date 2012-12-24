package com.example.pruebavistas;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends Activity {

	final public static String MyKey = "mikey";
	EditText WordText; //Cuadro de texto donde se inserta la cadéna
    String Word;//Aquí guardaremos el contenido del cuadro de texto para pasarselo a la sigu
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WordText=(EditText)findViewById(R.id.editText1);
        
        final String[] datos =
		        new String[]{"Spanish","English","French","Swahili","Elem5"};
		 
		ArrayAdapter<String> adaptador =
		        new ArrayAdapter<String>(this,
		            android.R.layout.simple_spinner_item, datos);
		
		final Spinner cmbLenOrig = (Spinner)findViewById(R.id.LangOrig);
		 
		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		 
		cmbLenOrig.setAdapter(adaptador);
		
		final Spinner cmbLenDest = (Spinner)findViewById(R.id.LangDest);
		 
		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		 
		cmbLenDest.setAdapter(adaptador);

        
        Button next = (Button) findViewById(R.id.search);
        next.setOnClickListener(new View.OnClickListener() {
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
        
        Button cancel = (Button) findViewById(R.id.delete);
        cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            	 WordText=(EditText)findViewById(R.id.editText1);
            	 WordText.setText(null);
            	
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    
}
