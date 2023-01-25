package graphics;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class imageViewsEx1 extends MFrame {

	Image img;

	public imageViewsEx1() {
		super(500, 350);
		img = Toolkit.getDefaultToolkit().getImage("graphics/aaa.jpg");
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, this);
	}
	public static void main(String[] args) {
		new imageViewsEx1();
	}
}
