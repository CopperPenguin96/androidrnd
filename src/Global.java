
import android.widget.*;
import android.widget.FrameLayout.*;
import java.util.*;
import android.content.*;
import android.app.*;
public class Global
{
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
	public static int RandomInt() {
		Random rNd = new Random();
		int rNdReturn = rNd.nextInt();
		/*if (rNdReturn > max || rNdReturn < min) {
			return RandomInt(min, max);
		} else {
			return rNdReturn;
		}*/
		return 0;
	}
	public static void DispMessage(String title, String msg, Context c) {
		AlertDialog ad = new AlertDialog.Builder(c).create();
		ad.setTitle(title);
		ad.setMessage(msg);
		ad.show();
	}
	
	public static boolean ErrorChecking() {
		return false;
	}
}
