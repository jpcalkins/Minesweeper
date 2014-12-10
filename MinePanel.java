import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;


public class MinePanel extends JPanel implements Serializable{
	private int[][] board = Board.fillBombs();
	public MinePanel(){
		setLayout(new GridLayout(10, 10));
		final MineButton[][] buttons = new MineButton[10][10];
		//Fills the panel with the JButtons
		for(int r=0; r<10; r++){
			for(int c=0; c<10; c++){
				buttons[r][c] = new MineButton(buttons, board);
	 			add(buttons[r][c]);
	 		}
		}
		repaint();
	}
	public void init(){
		repaint();
	}
}