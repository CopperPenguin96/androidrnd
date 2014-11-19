/*
 Copyright 2014- Present Date apotter96

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
package com.AP.randomm;

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
import Global;
import DigitType;
public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
		System.out.println(new Random().nextInt(2));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		Global.SetViews((TextView) findViewById(R.id.lblHow),
			(EditText) findViewById(R.id.txtHow),
			(Button) findViewById(R.id.btnGo), (LinearLayout) findViewById(R.id.mainContentView));
		Global.GoOrigin = Global.btnGo.getTop();
		Global.HideCounts();
		Global.btnGo.setY(-175);
		Global.minMax = new TextView[] {
			(TextView) findViewById(R.id.txtMin),
			(TextView) findViewById(R.id.txtMax)
		};
		Global.main = this;
    }
	
	public void setDefault(View v) {
		Global.HideCounts();
		Global.digitType = DigitType.Default;
	}
	public void GetR(View v) {
		if (Global.HasErrors()) {
			return;
		}
	}
	
}
