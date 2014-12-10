import javax.swing.*;
import java.awt.*;

public class MineFrame extends JFrame{
	public static MinePanel beeboop = new MinePanel();
	public MineFrame(){
		setTitle("Minesweeper");
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		setSize(screenSize.width/2,screenSize.height/2);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(new MineBar());
		
		add(beeboop);
		setVisible(true);
	}
}