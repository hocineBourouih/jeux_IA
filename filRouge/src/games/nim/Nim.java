package games.nim;

import java.util.Scanner;

public class Nim {

	private int initialNbMatches;
	private int currentNbMatches;

	private int maxMatchesToTake;

	private String currentPlayer;
	private String player1Name;
	private String player2Name;


	public Nim(int initialMatchesNb, int maxMatchesToTake, String player1Name, String player2Name)
	{
		this.initialNbMatches = initialMatchesNb;
		this.currentNbMatches = initialMatchesNb;

		this.maxMatchesToTake = maxMatchesToTake;

		this.player1Name = player1Name;
		this.player2Name = player2Name;

		this.currentPlayer = player1Name;
	}

	public void play() // Fonction non demandé
	{
		Scanner scanner = new Scanner(System.in);
		String winner;

		while(true)
		{
			System.out.println(situationToString());
			System.out.println("À " + this.currentPlayer + " de jouer : ");

			int matchesToRemove;
			boolean reselect;
			do
			{
				matchesToRemove = scanner.nextInt();
				reselect = !(isValid(matchesToRemove));

				if(reselect)
				{
					System.out.println("Veuillez selectionner une valeur valide... ");
				}
			} while(reselect);

			removeMatches(matchesToRemove);
			winner = getWinner();
			if(winner != null)
			{
				break;
			}

		}

		System.out.println("Le gagnant est : " + winner + " !!!");
		scanner.close();
	}

	public void switchPlayer()
	{
		if(this.currentPlayer == player1Name) {
			this.currentPlayer = player2Name;
			return;
		}
		this.currentPlayer = player1Name;

	}

	public boolean isValid(int matchesToRemove)
	{
		return (matchesToRemove <= this.maxMatchesToTake
				&& matchesToRemove <= this.currentNbMatches
				&& matchesToRemove > 0);
	}

	public boolean isOver()
	{
		return this.currentNbMatches == 0;
	}

	public String getWinner()
	{
		if(isOver())
		{
			/*
			if(this.currentPlayer == player1Name) return player1Name;
			return player2Name;
			*/
			return this.currentPlayer;
		}
		return null;
	}

	public void removeMatches(int matchesToRemove)
	{
		if(isValid(matchesToRemove))
		{
			this.currentNbMatches -= matchesToRemove;
			this.switchPlayer();
		}
	}


	public String situationToString()
	{
		String s = "";
		for(int i = 0; i < this.currentNbMatches; i++)
		{
			s += "|";
		}

		s += " (" + this.currentNbMatches + ")";
		return s;
	}

	/**
	 * @return the initialMatchesNb
	 */
	public int getInitialNbMatches() {
		return initialNbMatches;
	}


	/**
	 * @return the currentMatchesNb
	 */
	public int getCurrentNbMatches() {
		return currentNbMatches;
	}


	/**
	 * @return the currentPlayer
	 */
	public String getCurrentPlayer() {
		return currentPlayer;
	}

}
