import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ControlPanel extends JPanel {
	
	//TODO
	public JLabel win, numY, numB;
	private GameBoard game;
	
	public ControlPanel(GameBoard ex) {
		
		game = ex;
		ex.setControlPanel(this);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		win = new JLabel(" ");
		JButton reset = new JButton("Reset");
		BClick Creset = new BClick();
		reset.addActionListener(Creset);
		numY = new JLabel(""+game.getYellow());
		numB = new JLabel(""+game.getBlack());
		
		this.add(new JLabel("Yellow Count"));
		this.add(numY);
		this.add(new JLabel(""));
		this.add(new JLabel("Black Count"));
		this.add(numB);
		this.add(win);
		this.add(reset);	
	}
	
	class BClick implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			game.resetBoard();
			numY.setText(""+64);
			numB.setText(""+0);
			win.setText(" ");
		}
		
	}
}
