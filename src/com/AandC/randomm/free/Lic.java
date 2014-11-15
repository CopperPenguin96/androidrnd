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
import android.webkit.*;
import android.widget.*;
import com.AandC.randomm.*;

public class Lic extends Activity
{
	@Override
	//Whats happens on activity start
    public void onCreate(Bundle savedInstanceState)
	{
		//Creates the view and inits with the app
        super.onCreate(savedInstanceState);
        setContentView(R.layout.licence);
		WebView webLicense = (WebView) findViewById(R.id.webview);
		webLicense.loadUrl("file:///android_asset/license.html");
		TextView f = (TextView) findViewById(R.id.txtV);
		String x = f.getText().toString();
		x = x + this.getString(R.string.ver);
		f.setText(x);
    }
	
}
