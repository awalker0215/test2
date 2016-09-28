package boomgame;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;

public class function {
	public static int setboom(int num2) {
		int loc;
		do {
			loc = (int) (Math.random() * num2);
		} while (loc == num2);
		return loc;

	}

	public static int find(int stempj, int stempk, int c2, boolean[][] boomloc) {
		if (stempj - 1 >= 0) {
			if (boomloc[stempj - 1][stempk] == true)
				c2++;
			if (stempk - 1 >= 0)
				if (boomloc[stempj - 1][stempk - 1] == true)
					c2++;
			if (stempk + 1 < boomloc.length)
				if (boomloc[stempj - 1][stempk + 1] == true)
					c2++;
		}

		if (stempk - 1 >= 0)
			if (boomloc[stempj][stempk - 1] == true)
				c2++;

		if (stempk + 1 < boomloc.length)
			if (boomloc[stempj][stempk + 1] == true)
				c2++;

		if (stempj + 1 < boomloc.length) {
			if (boomloc[stempj + 1][stempk] == true)
				c2++;
			if (stempk - 1 >= 0)
				if (boomloc[stempj + 1][stempk - 1] == true)
					c2++;
			if (stempk + 1 < boomloc.length)
				if (boomloc[stempj + 1][stempk + 1] == true)
					c2++;
		}

		return c2;
	}
}