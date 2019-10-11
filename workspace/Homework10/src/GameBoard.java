
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

public class GameBoard extends JPanel {

	//TODO
	private LightsOutCircle[][] lights;
	private int numYellow, numBlack;
	private ControlPanel control;
	
	public GameBoard() {
		this.setLayout(new GridLayout(8,8));
		numYellow = 64;
		numBlack = 0;
		lights = new LightsOutCircle[8][8];
		BClick clicklight = new BClick();
		for(int i = 0; i < 64; i++) {
			lights[i/8][i%8] = new LightsOutCircle(i/8,i%8);
			this.add(lights[i/8][i%8]);
			lights[i/8][i%8].addActionListener(clicklight);
		}		
	}
	
	public void setControlPanel(ControlPanel control) {
		this.control = control;
	}
	
	public void controlset() {
		control.numB.setText(""+getBlack());
		control.numY.setText(""+getYellow());
		if(isWin()) {
			control.win.setText("You Win!");
		}
	}
	
	private void countNum() {
		int temp = 0;
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++)
				if(lights[i][j].isYellow()) temp++;
		}
		numYellow = temp;
		numBlack = 64-temp;
	}
	
	public int getYellow() {
		return numYellow;
	}
	
	public int getBlack() {
		return numBlack;
	}
	
	public boolean isWin() {
		if(getBlack() == 64) return true;
		else return false;
	}
	
	public void resetBoard() {
		for(int i = 0; i < 8; i++) {
			for(int j =0; j<8; j++) {
				lights[i][j].setYellow();
			}
		}
	}
	
	class BClick implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(!isWin()) {
				LightsOutCircle center = (LightsOutCircle) e.getSource();
				int c_row = center.row, c_col = center.col;
				
				
				if(c_row != 0) {
					LightsOutCircle target = lights[c_row-1][c_col];
					if(target.isBlack()) target.setYellow();
					else target.setBlack();
				}
				if(c_row != 7) {
					LightsOutCircle target = lights[c_row+1][c_col];
					if(target.isBlack()) target.setYellow();
					else target.setBlack();
				}
				if(c_col != 0) {
					LightsOutCircle target = lights[c_row][c_col-1];
					if(target.isBlack()) target.setYellow();
					else target.setBlack();
				}
				if(c_col != 7) {
					LightsOutCircle target = lights[c_row][c_col+1];
					if(target.isBlack()) target.setYellow();
					else target.setBlack();
				}

			}
			countNum();
			controlset();
		}
		
	}
}
