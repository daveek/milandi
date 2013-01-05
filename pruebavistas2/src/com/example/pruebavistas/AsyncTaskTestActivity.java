/*package com.example.pruebavistas;

import android.os.AsyncTask;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;



public class AsyncTaskTestActivity extends Activity {

	Button button;
	ProgressBar progressBar;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        button = (Button)findViewById(R.id.task);
        progressBar = (ProgressBar)findViewById(R.id.progressbar);
        
        button.setOnClickListener(new Button.OnClickListener(){
        	@Override
        	public void onClick(View arg0){
        		button.setClickable(false);
        		new UpdateProgress().execute();
        	}
        });
    }
public class UpdateProgress extends AsyncTask<Void,Integer,Void>{
int progress;
	@Override
	protected Void doInBackground(Void... params) {
		// TODO Auto-generated method stub
		return null;
	}
	
	protected void onPostExecute(Void result){
		
	}
	
	protected void onProgressUpdate(Integer... values){
		progressBar.setProgress(values[0]);
	}
	
	protected void onPreExecute(Void result){
		button.setClickable(true);
	}

}
*/