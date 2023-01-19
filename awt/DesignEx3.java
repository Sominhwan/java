package awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DesignEx3 extends MFrame2 implements ActionListener {

	List list;
	Button b[] = new Button[4];
	String lab[] = { "�߰�", "�����", "��ü�����", "����" };
	TextField tf;
	String food[] = { "¥���", "«��", "�쵿" };

	public DesignEx3() {
		super(300, 200);
		setTitle("������ ����3");
		setLocationRelativeTo(null);

		Panel p1 = new Panel();
		Panel p2 = new Panel();

		add(list = new List(), "Center");
		for (int i = 0; i < food.length; i++) {
			list.add(food[i]);
		}
		list.select(0);// ��½� ù��° ����Ʈ ����

		p1.add(tf = new TextField(37));
		add(p1, "South");
		tf.requestFocus();
		p2.setLayout(new GridLayout(4, 1));
		for (int i = 0; i < b.length; i++) {
			b[i] = new Button(lab[i]);
			p2.add(b[i]);
		}

		tf.addActionListener(this);
		for (int i = 0; i < b.length; i++) {
			b[i].addActionListener(this);
		}

		add(p2, BorderLayout.EAST);
		validate();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = tf.getText().trim();
		int index = list.getSelectedIndex();

		if (e.getSource() == b[0]) {
			list.add(str);
		} else if (e.getSource() == b[1]) {
			list.remove(index);
		} else if (e.getSource() == b[2]) {
			list.removeAll();
		} else if (e.getSource() == b[3]) {
			setVisible(false);
		}
		tf.setText("");
		tf.requestFocus();
	}

	public static void main(String[] args) {
		new DesignEx3();
	}
}
