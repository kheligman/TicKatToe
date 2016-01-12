import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class TicKatToe extends JPanel{

	public boolean player1 = true;
	public JLabel player;
	private int movesPlayed = 0;
	private ArrayList<Square> squares = new ArrayList<Square>();
	private int justPlayed = -1;
	private ArrayList<Integer> xMoves = new ArrayList<Integer>();
	private  ArrayList<Integer> yMoves = new ArrayList<Integer>();

	public TicKatToe()
	{
		JPanel board = new JPanel();
		for(int i = 0; i<25; i++)
		{
			squares.add(new Square(i));
		}

		GridLayout layout = new GridLayout(5,5);
		board.setLayout(layout);
		for(int i = 0; i<25; i++)
		{
			board.add(squares.get(i));
		}

		JPanel bottom = new JPanel();
		player = new JLabel("Player 1");

		bottom.add(player);

		add(board);
		add(bottom);

	}

	public void nextMove()
	{
		movesPlayed++;
		if(noWin())
		{
			if(player1)
			{
				player.setText("Player 2");
			}

			else
			{
				player.setText("Player 1");
			}

			player1 = !player1;
		}
		else 
		{
			winner();
		}

	}

	private void winner() 
	{
		this.invalidate();
		this.removeAll();
		JLabel winner;
		if(player1)
		{
			winner = new JLabel("Player 1 Wins!");
		}
		else
		{
			winner = new JLabel("Player 2 Wins!");
		}
		add(winner);
		
	}

	public void setJustPlayed(int x)
	{
		justPlayed = x;
		if(player1)
		{
			xMoves.add(x);
		}
		else 
		{
			yMoves.add(x);
		}
	}

	public boolean noWin()
	{
		if(movesPlayed < 7)
		{
			return true;
		}
		if(player1)
		{
			return !checkMoves(xMoves, justPlayed);	
			
		}
		else if(!player1)
		{
			return !checkMoves(yMoves, justPlayed);	
		}
		return true;
	}

	public static boolean checkMoves(ArrayList<Integer> moves, int curr)
	{
		if(moves.contains(curr+5) && moves.contains(curr+10) && moves.contains(curr+15)) return true;
		if(moves.contains(curr+5) && moves.contains(curr+10) && moves.contains(curr-5)) return true;
		if(moves.contains(curr+5) && moves.contains(curr-5) && moves.contains(curr-10)) return true;
		if(moves.contains(curr-5) && moves.contains(curr-10) && moves.contains(curr-15)) return true;
		if(moves.contains(curr+6) && moves.contains(curr+12) && moves.contains(curr+18)) return true;
		if(moves.contains(curr+6) && moves.contains(curr+12) && moves.contains(curr-6)) return true;
		if(moves.contains(curr+6) && moves.contains(curr-6) && moves.contains(curr-12)) return true;
		if(moves.contains(curr-6) && moves.contains(curr-12) && moves.contains(curr-18)) return true;
		if(moves.contains(curr+4) && moves.contains(curr+8) && moves.contains(curr+12)) return true;
		if(moves.contains(curr+4) && moves.contains(curr+8) && moves.contains(curr-4)) return true;
		if(moves.contains(curr+4) && moves.contains(curr-4) && moves.contains(curr-8)) return true;
		if(moves.contains(curr-4) && moves.contains(curr-8) && moves.contains(curr-12)) return true;
		
		if(curr == 0 || curr==5 || curr == 10 || curr == 15 || curr==20)
		{
			if(moves.contains(curr+1) && moves.contains(curr+2) && moves.contains(curr+3)) return true;
			
		}
		if(curr == 1 || curr==6 || curr == 11 || curr == 16 || curr==21)
		{
			if(moves.contains(curr+1) && moves.contains(curr+2) && moves.contains(curr+3)) return true;
			if(moves.contains(curr-1) && moves.contains(curr+1) && moves.contains(curr+2)) return true;
			
		}
		if(curr == 2 || curr==7 || curr == 12 || curr == 17 || curr==22)
		{
			if(moves.contains(curr-1) && moves.contains(curr+1) && moves.contains(curr+2)) return true;
			if(moves.contains(curr-1) && moves.contains(curr+1) && moves.contains(curr-2)) return true;
			
		}
		if(curr == 3 || curr==8 || curr == 13 || curr == 18 || curr==23)
		{
			if(moves.contains(curr-1) && moves.contains(curr-2) && moves.contains(curr-3)) return true;
			if(moves.contains(curr-1) && moves.contains(curr+1) && moves.contains(curr-2)) return true;
			
		}
		if(curr == 4 || curr==9 || curr == 14 || curr == 19 || curr==24)
		{
			if(moves.contains(curr-1) && moves.contains(curr-2) && moves.contains(curr-3)) return true;
		}
		
		return false;
	}
	
	
	public static void main(String[] args)
	{
		JFrame f = new JFrame();
		TicKatToe t = new TicKatToe();
		f.add(t);
		f.pack();
		f.setVisible(true);

	}

	public boolean getPlayer() {
		return player1;
	}


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
			if(player1)
			{
				setLabel("x");
			}
			
			else
			{
				setLabel("o");
			}
			setJustPlayed(id);
			nextMove();
		} 
		
	}
}


}
