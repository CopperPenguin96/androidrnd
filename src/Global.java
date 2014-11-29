
import android.widget.*;
import android.widget.FrameLayout.*;
import java.util.*;
import android.content.*;
import android.app.*;
import android.nfc.*;
public class Global
{
	public static DigitType dType;
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
	}
	public static void ShowCounts() {
		lblHow.setVisibility(0); //4 is hidden
		txtHow.setVisibility(0); //0 is shown
	}
	
	public static void DispMsg(String title, String msg) {
		AlertDialog aD = new AlertDialog.Builder(main).create();
		aD.setTitle(title);
		aD.setMessage(msg);
		aD.show();
	}
	static int getMax() {
		return Integer.parseInt(minMax[1].getText().toString());
	}
	static int getMin() {
		return Integer.parseInt(minMax[0].getText().toString());
	}
	private static Random randomGen = new Random();
	static int prevNum;
	static int rndNum;
	static void setNext() {
		rndNum = randomGen.nextInt(getMax());
		prevNum = rndNum;
		if (rndNum < getMin()) {
			setNext();
		}
	}
	static boolean[] HasRan = new boolean[6];
	public static void dispDefault() {
		if (HasRan[0]) {
			while (rndNum < getMin() || rndNum == 0) {
				setNext();
			}
		} else {
			while (rndNum == prevNum || rndNum < getMin() || rndNum == 0) {
				setNext();
			}
			HasRan[0] = true;
		}
		prevNum = rndNum;
		DispMsg("Random Number Received",
				"Our sources indicate that your random number is " + rndNum);
	}
}
