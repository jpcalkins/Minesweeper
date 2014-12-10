import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MineBar extends JMenuBar implements ActionListener{

	public static JMenuItem newGame = new JMenuItem("New");
	public static JMenuItem saveGame = new JMenuItem("Save");
	public static JMenuItem loadGame = new JMenuItem("Load");
	public static JMenuItem exitGame = new JMenuItem("Exit");

	public MineBar(){
		JMenu menu = new JMenu("A menu");
		newGame.addActionListener(this);
		saveGame.addActionListener(this);
		loadGame.addActionListener(this);
		exitGame.addActionListener(this);
		menu.add(newGame);
		menu.add(saveGame);
		menu.add(loadGame);
		menu.add(exitGame);
		this.add(menu);
	}
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == newGame){
			MineButton.resetBoard();
		} else if(source == saveGame){
			MineButton.saveBoard();
		} else if (source == loadGame){
			MineButton.loadBoard();
			super.repaint();
		} else{
			System.exit(0);
		}
	}
}