package ch12;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import awt.MColor;

public class RunnableFrameEx3 extends MFrame implements Runnable {
	Random r = new Random();
	int x, y;
	Color c;

	public RunnableFrameEx3(Color c, int x, int y) {
		super(200, 200);
		this.c = c;
		this.x = x;
		this.y = y;
		setLocation(x, y);

	}

	public void run() {
		for (int i = 0; i < 30; i++) {
			x = r.nextInt(200);
			y = r.nextInt(200);
			try {
				Thread.sleep(500);
				repaint();
			} catch (Exception e) {
			}
		} // --for
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(c);
		g.fillOval(x, y, 10, 10);
	}

	@Override
	public void update(Graphics g) {
		g.clipRect(x, y, 10, 10);
		paint(g);
	}

	public static void main(String[] args) {
		int x1 = 0, y1 = 0;
		int k = 0;
		
		RunnableFrameEx3[] r = new RunnableFrameEx3[9];
		Thread[] t = new Thread[9];
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				r[k] = new RunnableFrameEx3(MColor.rColor(), x1 + j * 200, y1 + i * 200);
				t[k] = new Thread(r[k]);
				t[k].start();
				k++;
			}
		}		
	}
}
