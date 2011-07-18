package rrj.SC;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ScoreBoard extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
	
	Button bWkts,bRuns,bExt,b1,b2,b3,b4,b6,b0;
	TextView tRuns,tWkts,tOvers,tRr,targetRuns,targetWkts;
	int total,extFlag,wck,balls,overs,totalOvers,teamSize,target;
	float runRate;
	Boolean innings2;
	String runs,over,rRate;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        tWkts = (TextView)findViewById(R.id.twkts);
        tRuns = (TextView)findViewById(R.id.truns);
        tOvers = (TextView)findViewById(R.id.tovers);
        tRr = (TextView)findViewById(R.id.trunrate);
        targetRuns = (TextView)findViewById(R.id.targetruns);
        targetWkts = (TextView)findViewById(R.id.targetwkts);
        
        b1 =(Button)findViewById(R.id.b1);
        b2 =(Button)findViewById(R.id.b2);
        b3 =(Button)findViewById(R.id.b3);
        b4 =(Button)findViewById(R.id.b4);
        //b5 =(Button)findViewById(R.id.b5);
        b6 =(Button)findViewById(R.id.b6);
        b0 =(Button)findViewById(R.id.b0);
        bWkts =(Button)findViewById(R.id.bwck);
        bExt =(Button)findViewById(R.id.bext);
               
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
       // b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b0.setOnClickListener(this);
        bWkts.setOnClickListener(this);
        bExt.setOnClickListener(this);
        
        targetRuns.setEnabled(false);
        targetWkts.setEnabled(false);
        innings2 = false;
        
        Bundle extras = getIntent().getExtras();
        teamSize =  extras.getInt("team");
        totalOvers = extras.getInt("overs");
        
        
    }

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		switch(arg0.getId())
		{
			case(R.id.b0): runs(0);
				break;
			
			case(R.id.b1): runs(1);
				break;
		
			case(R.id.b2): runs(2);
				break;
		
			case(R.id.b3): runs(3);
				break;
		
			case(R.id.b4): runs(4);
				break;
		
			case(R.id.b6): runs(6);
				break;
		
			case(R.id.bext): extFlag =1;
				total=total+1;
				//runs(0);
				break;
		
			case(R.id.bwck): wck=wck+1;
				String wkt = Integer.toString(wck);
				tWkts.setText(wkt);
				balls++;
				over = +overs+"."+balls;
				tOvers.setText(over);
				break;
		
		default: 
			break;
			
		}
	}
	
	public void runs(int run)
	{
		
		total = total+run;
		runs = Integer.toString(total);
		//Toast toast = Toast.makeText(this, ""+extFlag, Toast.LENGTH_SHORT);
		//toast.show();
		//extFlag =0;
		tRuns.setText(runs);
		if(extFlag == 0)
		{
			
			balls++;
			over = +overs+"."+balls;
			tOvers.setText(over);
			Toast toast = Toast.makeText(this, ""+balls, Toast.LENGTH_SHORT);
			//toast.show();
			if(balls==6)
			{
				
				overs++;
				if(overs==totalOvers)
				{
					 AlertDialog.Builder alertbox = new AlertDialog.Builder(this);
					 
					 alertbox.setTitle("End of Innigs");
			         // set the message to display
			         alertbox.setMessage(tRuns.getText().toString()+"/"+tWkts.getText().toString());
			//
			         // add a neutral button to the alert box and assign a click listener
			         alertbox.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
			//
			             // click listener on the alert box
			             public void onClick(DialogInterface arg0, int arg1) 
			             {
			            	 tRuns.setText("0");
			            	 tWkts.setText("0");
			            	 tOvers.setText("0.0");
			            	 tRr.setText("0.0");
			            	 total = 0;
			            	 extFlag =0;
			            	 wck=0;
			            	 balls = 0;
			            	 overs=0;
			            	 if(innings2==false)
			            	 {
			            		 targetRuns.setText(tRuns.getText().toString());
			            		 targetRuns.setEnabled(true);
			            		 target = Integer.parseInt(targetRuns.getText().toString());
			            	     targetWkts.setEnabled(true);
			            	 }
			            	 else
			            	 {
			            		 if(target>Integer.parseInt(tRuns.getText().toString()))
			            		 {
			            			 
			            			 Toast.makeText(getApplicationContext(), "The team batting Second won the match", Toast.LENGTH_LONG).show();
//			            			 AlertDialog.Builder winnerbox = new AlertDialog.Builder(this);
//			    					 
//			            			 winnerbox.setTitle("End of Match");
//			    			         // set the message to display
//			            			 winnerbox.setMessage("The team batting Second won the match");
//			            			 
//			            			 winnerbox.setNeutralButton("End", new DialogInterface.OnClickListener() {
//			            					//
//			            					             // click listener on the alert box
//			            					             public void onClick(DialogInterface arg0, int arg1) 
//			            					             {
//			            					            	 
//			            					             }
//			            			 });
//			            			 
			            		 }
			            		 else
			            		 {
			            			 Toast.makeText(getApplicationContext(), "The team batting First won the match", Toast.LENGTH_LONG).show();

			            		 }
			            	 }
			                 // the button was clicked
			                 //Toast.makeText(getApplicationContext(), "OK button clicked", Toast.LENGTH_LONG).show();
			             }
			         });
			//
			         // show it
			         alertbox.show();
					
				}
				balls = 0;
				over = +overs+"."+balls;
				tOvers.setText(over);
				runRate = (total/overs);
				rRate = ""+runRate;
				tRr.setText(rRate);
				//Toast toast = Toast.makeText(this, ""+overs+"     "+total, Toast.LENGTH_SHORT);
				//toast.show();
			}
			
		}
		
		if(extFlag ==1)
		{
			//total = total+1;
			//runs = Integer.toString(total);
//			//Toast toast = Toast.makeText(this, ""+extFlag, Toast.LENGTH_SHORT);
//			//toast.show();
//			//extFlag =0;
			//tRuns.setText(runs);
			
		}
		
		extFlag =0;	
	}
}