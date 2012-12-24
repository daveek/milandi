package com.example.pruebavistas;

import org.w3c.dom.Text;

import android.app.Activity;
//import android.os.Bundle;
import android.os.Bundle;
import android.widget.TextView;

public class unlhandler extends Activity{

	 public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unlview);
        StringBuilder unlphraparts = new StringBuilder();
        StringBuilder atribs = new StringBuilder();
        unlphraparts.append("Form of Word in UNL: [HW]{ID} “UW” (ATTR,ATTR,…) <FLG,FRE,PRI>\n");
        unlphraparts.append("An entry must end with a semicolon. <FLG,FRE,PRI> can be omitted.\n");
        unlphraparts.append("HW| headword of a language\n");
        unlphraparts.append("ID| identifier, can be empty\n");
        unlphraparts.append("UW| Universal Word, can be empty if not necessary \n");
        unlphraparts.append("ATTR| grammar code\n");
        unlphraparts.append("FLG| language flag, one character in ASCII code\n");
        unlphraparts.append("FRC| frequency to be used in EnCo\n");
        unlphraparts.append("PRI| priority to be used in DeCo\n");
        atribs.append("Types of atributes in UNL \n");
        atribs.append("Describing logicality| @transitive,@symmetric,@identifiable,@disjointed \n");
        atribs.append("Describing times| @future,@past,@present \n");
        atribs.append("Describing aspects| @begin,@complete,@continue,@end,@progress,@state,…\n");
        atribs.append("Describing genericity and specificity| @generic,@def,@indef,@not,@ordinal\n");
        atribs.append("Describing emphasis, focus and topic| @emphasis,@entry,@focus,@topic,…\n");
        atribs.append("Describing attitudes| @affirmative,@imperative,@interrogative,@request,…\n");
        atribs.append("Describing feelings and judgments| @ability,@grant,@wish,@will,@obligation,@possible,@regret,…\n");
        atribs.append("For convention| @passive,@pl,@parenthesis,…\n");
        
        Bundle TakeData = getIntent().getExtras();
        String unldesc = TakeData.getString("descunl");
        String wordorig = TakeData.getString("wordorig");
        String worddest = TakeData.getString("worddest");
        String desc = TakeData.getString("desc");
        String UNLWord=TakeData.getString("UnlWord");
        TextView mytext1= (TextView) findViewById(R.id.TranslateWordUNL);
        TextView mytext2= (TextView) findViewById(R.id.DescrUNL);
        TextView mytext3= (TextView) findViewById(R.id.UNLDescription);
        TextView mytext4= (TextView) findViewById(R.id.phraseUNL);
        TextView mytext5= (TextView) findViewById(R.id.atribs);
        mytext1.setText("Word in original Language, and word in destiny language: "+wordorig + "->" + worddest );
        mytext2.setText("Description (destiny language): "+desc);
        mytext3.setText("Universal Word with Atributes -> "+ UNLWord + " " + unldesc);
        mytext4.setText(unlphraparts.toString());
        mytext5.setText(atribs.toString());
	}
	
	
}
