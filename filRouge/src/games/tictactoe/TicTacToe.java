package games.tictactoe;
import java.util.ArrayList;

public class TicTacToe {
	private String player1;
	private String player2;
	private String currentPlayer;
	private String state[][];

	private static final String playerChar[] = {"X", "O"};

	public TicTacToe(String joueur1, String joueur2)
	{
		this.player1 = joueur1;
		this.player2 = joueur2;
		this.state = new String[3][3];
		this.currentPlayer = joueur1;
	}

	public String getCurrentPlayer()
	{
		return this.currentPlayer;
	}

	public void execute(int n)
	{
		String playerChar = (player1 == currentPlayer) ? "X" : "O";
		this.state[TicTacToe.getLigne(n)][TicTacToe.getColonne(n)] = playerChar;
		this.currentPlayer = (player1 == currentPlayer) ? player2 : player1;
	}

	public static int getLigne(int n)
	{
		return n/3;
	}
	public static int getColonne(int n)
	{
		return (n)%3;
	}

	public boolean isValid(int n)
	{
		if(n > 8 || n < 0)
		{
			return false;
		}

		return (this.state[TicTacToe.getLigne(n)][TicTacToe.getColonne(n)] == null);
	}

	public ArrayList<Integer> validMoves()
	{
		ArrayList<Integer> movs = new ArrayList<Integer>();
		for(int i = 0; i < 9; i++)
		{
			if(isValid(i)) movs.add(i);
		}
		return movs;
	}

	public boolean wins(String player, int row, int col, int drow, int dcol)
	{
		String currentChar = (player == player1) ? "X" : "O";

		for(int i = 0; i < 3; i++)
		{
			if(state[row][col] != currentChar) return false;
			row += drow;
			col += dcol;
		}
		return true;
	}

	public String getWinner()
	{
		boolean p1Win = false;
		p1Win |= wins(player1, 0, 0, 0, 1); // ligne 0
		p1Win |= wins(player1, 1, 0, 0, 1); // ligne 1
		p1Win |= wins(player1, 2, 0, 0, 1); // ligne 2
		p1Win |= wins(player1, 0, 0, 1, 0); // colonne 0
		p1Win |= wins(player1, 0, 1, 1, 0); // colonne 1
		p1Win |= wins(player1, 0, 2, 1, 0); // colonne 2
		p1Win |= wins(player1, 0, 0, 1, 1); // diagonale haut gauche vers bas droit
		p1Win |= wins(player1, 0, 2, 1,-1); // diagonale haut droit vers bas gauche


		boolean p2Win = false;
		p2Win |= wins(player2, 0, 0, 0, 1); // ligne 0
		p2Win |= wins(player2, 1, 0, 0, 1); // ligne 1
		p2Win |= wins(player2, 2, 0, 0, 1); // ligne 2
		p2Win |= wins(player2, 0, 0, 1, 0); // colonne 0
		p2Win |= wins(player2, 0, 1, 1, 0); // colonne 1
		p2Win |= wins(player2, 0, 2, 1, 0); // colonne 2
		p2Win |= wins(player2, 0, 0, 1, 1); // diagonale haut gauche vers bas droit
		p2Win |= wins(player2, 0, 2, 1,-1); // diagonale haut droit vers bas gauche

		if(p1Win) return this.player1;
		if(p2Win) return this.player2;

		return null;
	}

	public boolean isOver()
	{
		if(getWinner() != null) return true; // Il y as un gagnant, il reste possiblement des cases vides

		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				if(state[i][j] == null) return false; // Il n'y as pas encore de gagant, il reste des cases vides
			}
		}

		return true; // Il n'y as pas de gagnant, il ne reste pas de cases vides (nulle)
	}

	public String toString()
	{
		String str = new String();
		str += "  1 2 3\n";
		for(int i = 0; i < 3; i++)
		{
			str += i;
			for(int j = 0; j < 3; j++)
			{
				str += " " + ((state[i][j] == null) ? "." : state[i][j]);
			}
			str += "\n";
		}
		return str;
	}
}
