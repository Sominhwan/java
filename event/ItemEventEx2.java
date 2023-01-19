package event;

import java.awt.Checkbox;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ItemEventEx2 extends MFrame {
	Label label;
	Checkbox cb1, cb2, cb3;

	public ItemEventEx2() {
		super(300, 200);
		setLayout(new FlowLayout());
		add(cb1 = new Checkbox("수박"));
		add(cb2 = new Checkbox("바나나"));
		add(cb3 = new Checkbox("멜론"));
		add(label = new Label("현재 상태 :                    "));
		MyItem mi = new MyItem(this);
		cb1.addItemListener(mi);
		cb2.addItemListener(mi);
		cb3.addItemListener(mi);
	}

	public static void main(String[] args) {
		new ItemEventEx2();
	}
}

//외부 클래스에서 필요한 이벤트 리스너 구현(Event2.java 참고)
class MyItem implements ItemListener {
	ItemEventEx2 f;

	public MyItem(ItemEventEx2 f) {
		this.f = f;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Checkbox cb = (Checkbox) e.getSource();
		String str = cb.getLabel() + " : " + cb.getState();
		f.label.setText(str);
		f.setTitle(str);
	}
}
