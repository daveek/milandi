package com.example.pruebavistas;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

public class PersonalEditText extends EditText{
	public String defaultValue = "";
	final Drawable imgX = getResources().getDrawable(android.R.drawable.presence_offline ); 		// Imagen de la X.
	
	public PersonalEditText(Context context) {
		super(context);
	    init();
	}

	public PersonalEditText(Context context, AttributeSet attrs, int defStyle){
		super(context, attrs, defStyle);
		init();
	}

	public PersonalEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
	        init();
	}


	public void init(){
		// Establece los límites de nuestro botón X.
	    imgX.setBounds(0, 0, imgX.getIntrinsicWidth()+10, imgX.getIntrinsicHeight()+10);      

	    // Puede iniciar el texto inicial en el campo, por lo que se puede necesitar para mostrar el botón.
	    manageClearButton();

	    this.setOnTouchListener(new OnTouchListener() {
	    	@Override
	        public boolean onTouch(View v, MotionEvent event) {
	    		PersonalEditText et = PersonalEditText.this;

	            // ¿Existe una proyección X?
	            if (et.getCompoundDrawables()[2] == null) 
	            	return false;
	            
	            // Solo si se toca.
	            if (event.getAction() != MotionEvent.ACTION_UP) 
	            	return false;
	            
	            // Is touch on our clear button?
	            if (event.getX() > et.getWidth() - et.getPaddingRight() - imgX.getIntrinsicWidth()) {
	            	et.setText("");
	                PersonalEditText.this.removeClearButton();
	            }
	            return false;
	        }
	    });

	    this.addTextChangedListener(new TextWatcher() {
	    	@Override
	        public void onTextChanged(CharSequence s, int start, int before, int count) {
	    		PersonalEditText.this.manageClearButton();
	        }

	        @Override
	        public void afterTextChanged(Editable arg0) {
	        }

	        @Override
	        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
	        }
	    });
	}

	public void manageClearButton() {
		if(this.getText().toString().equals("")){
			removeClearButton();
		}else{
			addClearButton();
		}     
	}
	
	public void addClearButton() {
		this.setCompoundDrawables(this.getCompoundDrawables()[0], this.getCompoundDrawables()[1], imgX, this.getCompoundDrawables()[3]);
	}
	
	public void removeClearButton() {
		this.setCompoundDrawables(this.getCompoundDrawables()[0], this.getCompoundDrawables()[1], null, this.getCompoundDrawables()[3]);
	}

}
