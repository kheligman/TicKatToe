import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;


public class Square extends JButton{
	
	private String played;
	private int id;
	
	public Square(int num)
	{
		played = " ";
		id = num;
		setLabel(" ");
		addActionListener(new Clicked());
		
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setLabel(String x)
	{
		played = x;
		this.setText(x);
	}
	
	public String beenPlayed()
	{
		//returns x or o, n for not played yet
		return played;
	}
	
	public class Clicked implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(TicKatToe.player1)
			{
				setLabel("x");
			}
			
			else
			{
				setLabel("o");
			}
			TicKatToe.setJustPlayed(id);
			TicKatToe.nextMove();
		} 
		
	}
}
