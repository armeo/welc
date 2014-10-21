public class ScopeMayhem {
	public int foo() {
		boolean a = true;
		boolean b = true;
		boolean c = false;
		boolean d = true;
		boolean e = false;
		boolean f = false;
		boolean g = false;
		boolean h = true;
		boolean i = false;
		boolean j = false;
		boolean k = false;
		boolean l = true;
		boolean m = false;

		int aa = 3;
		int bb = 4;
		int cc = 3;
		int dd = 5;
		int ee = 6;
		int ff = 7;
		int gg = 9;
		int hh = 2;
		int ii = 4;		
		int xx = 4;
		


		if (a == b) {

				aa += 45;
				gg += 48;

				bb += 12;

				if (c == d) {
					bb = gg + hh;
					return bb;
				}
		} else {

				cc += 14;

				if (g) {
					if (h) {
						cc += 12;
					}
					ii += 3;
				}
				if (cc > 12)
					dd += 56 + ii;
			}

		if (cc > 13) {
				dd += 12;
		}


		return dd + ee + xx + ff;
	}
}
