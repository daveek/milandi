package com.example.pruebavistas;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
//import android.os.Bundle;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

public class info extends Activity{

	 public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info); 
        
   	 Button information = (Button) findViewById(R.id.btninfo1);
	 information.setOnClickListener(new View.OnClickListener() {
         public void onClick(View view) {
        	 ArrayList<Drawable> list = new ArrayList<Drawable>();
        	 list.add((Drawable) getResources().getDrawable(R.drawable.plantillaorig));
        	 list.add((Drawable) getResources().getDrawable(R.drawable.plantilladest));
        	 list.add((Drawable) getResources().getDrawable(R.drawable.plantillawrite));
        	 list.add((Drawable) getResources().getDrawable(R.drawable.plantillasearch));
        	 
         	ImageView myImage = (ImageView)findViewById(R.id.imageView1);
         	int i=1;
         	if(i<=4){
         	myImage.setImageDrawable(list.get(i));
         	i++;
         	}if(i==4)i=0;
         	///myImage.draw(null);
         	
        
         	
         }
     });
     
	}
	 


	
	
}
