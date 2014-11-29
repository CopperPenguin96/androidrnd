
import android.widget.*;
import android.widget.FrameLayout.*;
import java.util.*;
import android.content.*;
import android.app.*;
import android.nfc.*;
import java.text.*;
public class Global
{
	static String[] Letters = new String[] {
		null, "A", "B", "C", "D", "E", "F", "G", "I",
		"J", "K", "L", "M", "N", "O", "P", "Q",
		"R", "S", "T", "U", "V", "W", "X", "Y", "Z"
	};
	public static boolean IsHidden = false;
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
		IsHidden = true;
	}
	public static void ShowCounts() {
		lblHow.setVisibility(0); //4 is hidden
		txtHow.setVisibility(0); //0 is shown
		IsHidden = false;
	}
	
	public static void DispMsg(String title, String msg) {
		AlertDialog aD = new AlertDialog.Builder(main).create();
		aD.setTitle(title);
		aD.setMessage(msg);
		aD.show();
	}
	public static int getMax() {
		return Integer.parseInt(minMax[1].getText().toString());
	}
	public static int getMin() {
		return Integer.parseInt(minMax[0].getText().toString());
	}
	public static int getHow() {
		return Integer.parseInt(txtHow.getText().toString());
	}
	private static Random randomGen = new Random();
	static int prevNum;
	static int rndNum;
	
	static Double prevDo;
	static Double rndDo;
	static void setNext() {
		switch (dType) {
			case Default:
				rndNum = randomGen.nextInt(getMax());
				if (rndNum < getMin() || prevNum == rndNum) {
					setNext();
					return;
				}
				prevNum = rndNum;
				break;
			case Decimal:
				rndDo = randomGen.nextDouble() + randomGen.nextInt(getMax());
				if (rndDo < getMin() || prevDo == rndDo || rndDo > getMax()) {
					setNext();
					return;
				}
				prevDo = rndDo;
				break;
			case MultipleDefault:
				rndNum = randomGen.nextInt(getMax());
				if (rndNum < getMin() || prevNum == rndNum) {
					setNext();
					return;
				}
				prevNum = rndNum;
				break;
			case MultipleDecimal:
				rndDo = randomGen.nextDouble() + randomGen.nextInt(getMax());
				if (rndDo < getMin() || prevDo == rndDo || rndDo > getMax()) {
					setNext();
					return;
				}
				prevDo = rndDo;
				break;
			case Letter:
				rndNum = randomGen.nextInt(getMax());
				if (rndNum < getMin() || prevNum == rndNum) {
					setNext();
					return;
				}
				prevNum = rndNum;
				break;
			case MultipleLetter:
				rndNum = randomGen.nextInt(getMax());
				if (rndNum < getMin() || prevNum == rndNum) {
					setNext();
					return;
				}
				prevNum = rndNum;
				break;
		}
	}
	static boolean[] HasRan = new boolean[6];
	public static void dispDefault() {
		switch (dType) {
			case Default:
				if (HasRan[0]) {
					if (rndNum < getMin() || rndNum == 0 || rndNum == prevNum) {
						setNext();
					}
				} else {
					if (rndNum == prevNum || rndNum < getMin() || rndNum == 0) {
						setNext();
					}
					HasRan[0] = true;
				}
				prevNum = rndNum;
				DispMsg("Random Number Received",
						"Our sources indicate that your random number is " + rndNum);
				break;
			case Decimal:
				if (HasRan[1]) {
					if (rndDo < getMin() || rndDo == 0 || rndDo == prevDo) {
						setNext();
					}
				} else {
					if (rndDo == prevDo || rndDo < getMin() || rndDo == 0) {
						setNext();
					}
					HasRan[1] = true;
				}
				prevDo = rndDo;
				DispMsg("Decimals are inproper fractions in disquise!",
						"Your imposter is " + rndDo);
				break;
			case MultipleDefault:
				int[] RndNums = new int[getHow() + 1];
				for (int x = 0; x <= getHow(); x++) {
					if (HasRan[0]) {
						if (rndNum < getMin() || rndNum == 0 || rndNum == prevNum) {
							setNext();
						}
					} else {
						if (rndNum == prevNum || rndNum < getMin() || rndNum == 0) {
							setNext();
						}
						HasRan[0] = true;
					}
					RndNums[x] = rndNum;
					prevNum = rndNum;
				}
				String fMessage = "Your grand army contains: ";
				int lCou = 0;
				for (int i:RndNums) {
					if (lCou < getHow() - 1) {
						fMessage += i + ", ";
					}
					lCou++;
				}
				fMessage += "and " + RndNums[getHow() - 1];
				DispMsg("You are the general of the grand number army!",
						fMessage);
				break;
			case MultipleDecimal:
				Double[] RndDos = new Double[getHow() + 1];
				for (int x = 0; x <= getHow(); x++) {
					if (HasRan[0]) {
						if (rndDo < getMin() || rndDo == 0 || rndDo == prevDo) {
							setNext();
						}
					} else {
						if (rndDo == prevDo || rndDo < getMin() || rndDo == 0) {
							setNext();
						}
						HasRan[0] = true;
					}
					RndDos[x] = rndDo;
					prevDo = rndDo;
				}
				String fMessageZ = "And you teach them! Your class has: ";
				int lCouZ = 0;
				for (Double i:RndDos) {
					if (lCouZ < getHow() - 1) {
						fMessageZ += i + ", ";
					}
					lCouZ++;
				}
				fMessageZ += "and " + RndDos[getHow() - 1];
				DispMsg("Decimals are complicated children!",
						fMessageZ);
				break;
			case Letter:
				if (HasRan[0]) {
					if (rndNum < getMin() || rndNum == 0 || rndNum == prevNum) {
						setNext();
					}
				} else {
					if (rndNum == prevNum || rndNum < getMin() || rndNum == 0) {
						setNext();
					}
					HasRan[0] = true;
				}
				prevNum = rndNum;
				DispMsg("I thought this was a number app!",
						"Meh, take it and get outta here: " + Letters[rndNum]);
				break;
			case MultipleLetter:
				int[] RndNumsY = new int[getHow() + 1];
				for (int x = 0; x <= getHow(); x++) {
					if (HasRan[0]) {
						if (rndNum < getMin() || rndNum == 0 || rndNum == prevNum) {
							setNext();
						}
					} else {
						if (rndNum == prevNum || rndNum < getMin() || rndNum == 0) {
							setNext();
						}
						HasRan[0] = true;
					}
					RndNumsY[x] = rndNum;
					prevNum = rndNum;
				}
				String[] lets = new String[getHow() + 1];
				int LK = 0;
				for (int iC : RndNumsY) {
					lets[LK] = Letters[iC];
					LK++;
				}
				String fMessageY = "Enough is enough!: ";
				int lCouY = 0;
				String funC = "";
				for (String i:lets) {
					try {
						funC += i.toLowerCase();
					} catch (NullPointerException e){}
					if (lCouY < getHow() - 1) {
						fMessageY += i + ", ";
					}
					lCouY++;
				}
				if (funC.equals("android")) {
					DispMsg("Best OS Ever!", "Android that is");
				}
				fMessageY += "and " + lets[getHow() - 1];
				DispMsg("Why are there so many letters!?",
						fMessageY);
				break;
		}
	}
	public static void MsgBox(String title, String msg, Context c) {
		AlertDialog aFia = new AlertDialog.Builder(c).create();
		aFia.setTitle(title);
		aFia.setMessage(msg);
		aFia.show();
	}
}
