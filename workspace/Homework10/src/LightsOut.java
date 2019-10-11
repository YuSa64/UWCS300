import java.awt.BorderLayout;

import javax.swing.JFrame;

public class LightsOut extends JFrame {

	//TODO
	public LightsOut() {
		this.setTitle("LightsOut");
		this.setSize(800, 750);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		GameBoard game = new GameBoard();
		this.add(game, BorderLayout.CENTER);
		ControlPanel control = new ControlPanel(game);
		this.add(control, BorderLayout.EAST);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new LightsOut();
	}
}
