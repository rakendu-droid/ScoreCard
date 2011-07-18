package rrj.SC;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Home extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
	
	ImageButton lp;
	EditText eTeamSize,eTotalOver;
	Intent i;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        
        
        lp = (ImageButton)findViewById(R.id.butlp);
        eTeamSize = (EditText)findViewById(R.id.editwik);
        eTotalOver = (EditText)findViewById(R.id.editovers);

        lp.setOnClickListener(this);
        
    }
	@Override
	public void onClick(View arg0) 
	{
		
		String steam = eTeamSize.getText().toString();
		String sovers = eTotalOver.getText().toString();
		// TODO Auto-generated method stub
		
		int length = steam.length() + sovers.length();
		if(length>0)
		{
		//i.putExtra("team size", team);
		//i.putExtra("overs", overs);
		int team = Integer.parseInt(eTeamSize.getText().toString());
		int overs = Integer.parseInt(eTotalOver.getText().toString());
		length = team + overs;
		i=new Intent(Home.this,ScoreBoard.class);
		i.putExtra("team", team);
		i.putExtra("overs", overs);
		startActivity(i);
		}
		else
		{
			Toast toast1 = Toast.makeText(this, "Please Enter all the details ", Toast.LENGTH_SHORT);
			toast1.show();
		}
		
//		 AlertDialog.Builder alertbox = new AlertDialog.Builder(this);
//		 
//         // set the message to display
//         alertbox.setMessage("This is the alertbox!");
//
//         // add a neutral button to the alert box and assign a click listener
//         alertbox.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
//
//             // click listener on the alert box
//             public void onClick(DialogInterface arg0, int arg1) {
//                 // the button was clicked
//                 Toast.makeText(getApplicationContext(), "OK button clicked", Toast.LENGTH_LONG).show();
//             }
//         });
//
//         // show it
//         alertbox.show();
//		
	}
}