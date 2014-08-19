
/*
 Copyright 2014- Present Date A & C Development

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software 
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.

 */
package com.AandC.randomm.free;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.app.AlertDialog;
import android.content.*;
import android.net.*;
import java.lang.String;
import java.lang.Throwable;

import java.util.Random;
import android.view.View.*;
import android.nfc.*;
import android.webkit.*;
import android.content.res.*;
import android.text.*;
import com.AandC.randomm.*;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
	//Whats happens on activity start
    public void onCreate(Bundle savedInstanceState)
	{
		//Creates the view and inits with the app
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		
		showNew(false, false);
    }
	AlertDialog alertDialog;
	public static Random randomGenerator = new Random();
	public static int prevRnd = 0;
	boolean isCaught = false;
	String ex = null;
	public static int rndNum = 0;
	public static double prevRndd = 0;
	public static double rndNumd = 0;
	public void dec(View v) {
		showNew(false, false);
	}
	public void getMD(View v) {
		showNew(false, false); //HEHEHEHE
	}
	private void showNew(boolean is2, boolean is3)
	{
		if (!is3)
		{
			final String url = "http://play.google.com/store/apps/details?id=com.AandC.randomm";
			if (is2)
			{
				
				alertDialog = new AlertDialog.Builder(this).create();
				//Dialog Name
				alertDialog.setTitle("Awww...");
				//Dialog Message
				alertDialog.setMessage("Dude! Why? Go ahead and buy the full version!");
				//Adds a button to the dialog
				alertDialog.setButton("What? Fine", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						Uri uri = Uri.parse(url);
						Intent intent = new Intent(Intent.ACTION_VIEW, uri);
						startActivity(intent);
					}
				});
				alertDialog.setButton2("Never", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
					}
				});
			alertDialog.setIcon(R.drawable.ic_launcher);
			alertDialog.show();
			}
			else
			{
				alertDialog = new AlertDialog.Builder(this).create();
				alertDialog.setTitle("ACK!!! You are using the free version!");
				//Dialog Message
				alertDialog.setMessage("Would you like to buy the full version?");
				//Adds a button to the dialog
				alertDialog.setButton("Alright", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						Uri uri = Uri.parse(url);
						Intent intent = new Intent(Intent.ACTION_VIEW, uri);
						startActivity(intent);
					}
				});
				alertDialog.setButton2("No", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						showNew(true, false);
					}
				});
				alertDialog.setIcon(R.drawable.ic_launcher);
				alertDialog.show();
			}
		}
		else
		{
			if (isCaught)
			{
				iBroke();
			}
		}
	}
	public void iBroke()
	{
		//Creates the dialog
		alertDialog = new AlertDialog.Builder(this).create();
		alertDialog.setTitle(":'( I broke!");
		//Dialog Message
		alertDialog.setMessage(ex);
		alertDialog.setIcon(R.drawable.ic_launcher);
		alertDialog.show();
	}
	int minNum = 0;
	int maxNum = 0;
	double minNumd = 0;
	double maxNumd = 0;
	String mmaxNum = null;
	String mminNum = null;
	EditText[] e = new EditText[2];
	public void getBase(String methy) {
		try
		{
			e[0] = (EditText)findViewById(R.id.numMin);
			e[1] = (EditText)findViewById(R.id.numMax);
			mminNum = e[0].getText().toString();
			mmaxNum = e[1].getText().toString();
		}
		catch (Exception rndIt)
		{
			showNew(false, true);
			isCaught = true;
			ex = rndIt.toString();
		}
		try
		{
			minNum = Integer.parseInt(mminNum);
			maxNum = Integer.parseInt(mmaxNum);
		}
		catch (Exception npeMin)
		{
			showNew(false, true);
			isCaught = true;
			ex = npeMin.toString();
		}
		//Creates the dialog

		alertDialog = new AlertDialog.Builder(this).create();
		//Dialog Message
		try
		{
			String wNot = "Sorry, that will not work...";
			if (minNum <= 0 || maxNum <= 0)
			{
				alertDialog.setTitle(wNot);
				alertDialog.setMessage("Please enter a valid integer that is greater than 0");
				alertDialog.setIcon(R.drawable.ic_launcher);
				alertDialog.show();
			}
			else if ((minNum <= 0 & maxNum > 0) || (maxNum <= 0 & minNum > 0))
			{
				alertDialog.setTitle(wNot);
				alertDialog.setMessage("Please enter a valid integer that is greater than 0");
				alertDialog.setIcon(R.drawable.ic_launcher);
				alertDialog.show();
			}
			else if (maxNum < 0)
			{
				alertDialog.setTitle(wNot);
				alertDialog.setMessage("Your max number cannot be greater than your min number!");
				alertDialog.setIcon(R.drawable.ic_launcher);
				alertDialog.show();
			}
		    else if (minNum == maxNum)
			{
				alertDialog.setTitle(wNot);
				alertDialog.setMessage("Your min and max values cannot be the same.");
				alertDialog.setIcon(R.drawable.ic_launcher);
				alertDialog.show();
			}
			else if (minNum > 0)
			{
				//default is one random integer
				//mul is multiple
				if (methy == "default") gse(true);
				if (methy == "mul") gse(false);
			}
		}
		catch (Exception exc)
		{
			showNew(false, true);
			isCaught = true;
			ex = exc.toString();
		}
		
	}
	public void gse(boolean isOne) {
		try {
			if (rndNum == prevRnd) {
				getNext(maxNum, minNum);
			}
			else if (rndNum < minNum)
			{
				//Cuts out a whole ton of work by simplifying a line of code into a single void
				//It will require the maxNum integer to operate
				getNext(maxNum, minNum);
			}
			else if (rndNum == 0)
			{
				//Same method
				//Works just the same
				getNext(maxNum, minNum);
			}
			//Sets the message
		
			if (isOne) is1();
			else is2();
		}
		catch (Exception exc) {
			showNew(false, true);
			isCaught = true;
			ex = exc.toString();
		}
	}
	
	public void is1() {
		alertDialog.setTitle("A random number has been received!");
		alertDialog.setMessage("Our sources indicate that your random number is " + (rndNum + 1));
		alertDialog.setIcon(R.drawable.ic_launcher);
		alertDialog.show();
	}
	
	int howManyint = 0;
	EditText howMany;
	Dialog dialog;
	public void is2() {
		try
		{
			howMany = (EditText) findViewById(R.id.etHow);
		}
		catch (NullPointerException excv) {
			alertDialog.setTitle(excv.toString());
			alertDialog.setMessage(excv.getCause().toString());
			alertDialog.setIcon(R.drawable.ic_launcher);
			alertDialog.show();
		}
		dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog);
        dialog.setTitle("How many?");
		/*Does not allow changes to the objects
		  Because the final identifer has been used*/
		  //Without objects being declared NullPointer arises
		final EditText exT = (EditText) dialog.findViewById(R.id.etHow);
		final Button dialogButton = (Button) dialog.findViewById(R.id.btnGen);
        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					/*TODO
						=> Make sure 0 is invalid and try
						catches are in place for possible
						exceptions
						
						=> Setup method to retreive how many
						and create for x = 1 to how many
					*/
					//Finds the EditText
					String getC = null;
					try {
						final String inv = "Invalid Count";
						getC = exT.getText().toString();
						howManyint = Integer.parseInt(getC);
						if (howManyint <= 1) {
							alertDialog.setTitle(inv);
							alertDialog.setMessage("Sorry, but you need a number " +
													"greater than 1");
							alertDialog.setIcon(R.drawable.ic_launcher);
							alertDialog.show();
						}
						else {
							final String mainH = "Number Invasion!";
							String disp = "The army contains: ";
							for (int ierT = 1; ierT <= howManyint - 1; ierT++) {
								getNext(maxNum, minNum);
								disp += rndNum + ", ";
							}
							getNext(maxNum, minNum);
							disp += "and " + rndNum;
							alertDialog.setTitle(mainH);
							alertDialog.setMessage(disp);
							alertDialog.setIcon(R.drawable.ic_launcher);
							alertDialog.show();
						}
					}
					catch (NullPointerException bad) {
						alertDialog.setTitle(bad.toString());
						alertDialog.setMessage(bad.toString());
						alertDialog.setIcon(R.drawable.ic_launcher);
						alertDialog.show();
					}
					catch (Exception bad){
						alertDialog.setTitle(bad.toString());
						alertDialog.setMessage(bad.toString());
						alertDialog.setIcon(R.drawable.ic_launcher);
						alertDialog.show();
					}
					
				}
			});
        dialog.show();
		
		
	}
	/*public void finishMu() {
		
	}
	*/
	public void getRnd1(View v)
	{
		getBase("default");
	}
	public static void getNext(int maxNum, int minNum)
	{
		rndNum = randomGenerator.nextInt(maxNum);
		prevRnd = rndNum;
		
		if (rndNum < minNum)
		{
			getNext(maxNum, minNum);
		}
	}
	
	public void getMul(View v) {
		showNew(false,false);
	}
	public void full(View v) {
		showNew(false, false);
	}
	
	public void license(View v) {
		Intent licv = new Intent(this, Lic.class);
		startActivity(licv);
	}
	public void getLetter(View v) {
		full(v);
	}
}
