
import android.widget.*;
import android.widget.FrameLayout.*;
import java.util.*;
import android.content.*;
import android.app.*;
import android.nfc.*;
public class Global
{
	public static TextView[] minMax;
	public static Context main;
	public static TextView lblHow;
	public static EditText txtHow;
	public static Button btnGo;
	public static int GoOrigin;
	public static LinearLayout lLay;
	public static void SetViews(TextView lbl, EditText txt, Button btn, LinearLayout l) {
		lblHow = lbl;
		txtHow = txt;
		btnGo = btn;
		lLay = l;
	}
	public static void HideCounts() {
		lblHow.setVisibility(4); //4 is hidden
		txtHow.setVisibility(4); //0 is shown
		btnGo.setY(lblHow.getTop());
	}
	public static void ShowCounts() {
		lblHow.setVisibility(0); //4 is hidden
		txtHow.setVisibility(0); //0 is shown
		btnGo.setY(GoOrigin);
	}
	static int RandomInt() {
		return new Random().nextInt();
	}
	public static void DispMessage(String title, String msg, Context c) {
		AlertDialog ad = new AlertDialog.Builder(c).create();
		ad.setTitle(title);
		ad.setMessage(msg);
		ad.show();
	}
	final static String msg = "Numbers only please";
	static int getMin() throws Exception {
		try {
			int num = Integer.parseInt(minMax[0].getText().toString()); 
			return num;
		} catch (Exception ex) {
			throw new Exception(msg);
		}
	}
	static int getMax() throws Exception {
		try {
			int num = Integer.parseInt(minMax[1].getText().toString()); 
			return num;
		} catch (Exception ex) {
			throw new Exception(msg);
		}
	}
	public static DigitType digitType;
	static int[] Digits;
	public static boolean HasErrors() {
		try
		{
			if (getMax() < getMin())
			{
				throw new InvalidResponseException("Max cannot " +
					"be less than min");
			}
		
		} catch (Exception e) {
			DispMessage("Invalid setup", e.getMessage(), main);
			return true;
		}
		try
		{
			Digits = new int[] {
				getMin(), getMin()
			};
		}
		catch (Exception e) {
			
		}
		return false;
	}
	static void ShowMessage() {
		String title = null;
		String message = null;
		switch (digitType) {
			case Default:
				int desired = GetSet();
				title = "Single Digit";
				message = "Your random digit is " + GetSet();
				break;
		}
		DispMessage(title, message, main);
	}
	static int GetSet() {
		int des = RandomInt();
		if (des < Digits[0] || des > Digits[1]) {
			return GetSet();
		} else {
			return des;
		}
	}
}
