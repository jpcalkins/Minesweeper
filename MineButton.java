import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MineButton extends JButton{

	public static JButton[][] myButtons;
	public static int[][] board;

	public MineButton(JButton[][] myButtons, int[][] board){
		this.myButtons = myButtons;
		this.board = board;
		this.addMouseListener(new ClickListener());
	}
	public static void resetBoard(){
		board = Board.fillBombs();
		for(int j=0; j<10; j++){
			for(int k=0; k<10; k++){
				myButtons[j][k].setText("");
				myButtons[j][k].setEnabled(true);
			}
		}
	}
	public static void saveBoard(){
		JFileChooser fc = new JFileChooser();
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int output = fc.showSaveDialog(null);
		if(output == JFileChooser.APPROVE_OPTION) {
			try {
				ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fc.getSelectedFile()));
				out.writeObject(MineFrame.beeboop);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	public static void loadBoard(){
		JFileChooser load = new JFileChooser();
		load.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int returnVal = load.showOpenDialog(null);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			try {
				ObjectInputStream loadStuff = new ObjectInputStream(new FileInputStream(load.getSelectedFile()));
				MineFrame.beeboop = (MinePanel)loadStuff.readObject();
			} catch (IOException ex) {
				ex.printStackTrace();
			} catch (ClassNotFoundException e){
				e.printStackTrace();
			}
		}
	}
	private class ClickListener extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			Object source = e.getSource();
		  	for(int x=0; x<10; x++){
				for(int y=0; y<10; y++){
	   				if (source == myButtons[x][y]){
	   					if(myButtons[x][y].isEnabled() == true){
	   						//Sends the coordinates of the button to the coordinates of the game structure
							myButtons[x][y].setText(Board.move(board, x+1, y+1));
							myButtons[x][y].setEnabled(false);
							//Places flags for right clicks
							if (SwingUtilities.isRightMouseButton(e)) {
								if (myButtons[x][y].getText().equals("Flag")){
									myButtons[x][x].setText(" ");
								} else{
									myButtons[x][y].setText("Flag");
								}
								myButtons[x][y].setEnabled(true);
							}else if (myButtons[x][y].getText().equals("Bomb!")){
			   					JOptionPane.showMessageDialog(null,"You Lose! You hit a bomb. Press OK to restart.","BOOM!!!",JOptionPane.PLAIN_MESSAGE);
			   					MineButton.resetBoard();
							}
		   				}
	    			}	
	   			}
			}
	   	}  	
	}
}