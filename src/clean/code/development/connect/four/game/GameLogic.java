package clean.code.development.connect.four.game;

import java.util.Scanner;

import clean.code.development.connect.four.game.Player.TileStyle;

public class GameLogic {

	
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		ScoreEvaluator evaluator = new ScoreEvaluator();
		Grid grid = new Grid();
		grid.setHeight(6);
		grid.setWidth(7);
		grid.generateGameField();
		Player cross = new Player(TileStyle.CROSS.value());
		Player dot = new Player(TileStyle.DOT.value());
		Player winner = null;
		while (true) {

			System.out.print("Hi, how are you?\nWanna play a game?\n");
			
			
			boolean crossturn = true;
			while(true) {
				grid.printGameField();
				
				if (crossturn) {
					System.out.print("Turn: Cross >");
					String input = scanner.nextLine();
					try {
						grid.inserTile(Integer.valueOf(input), cross);
						crossturn = false;
					} catch (NumberFormatException nfe) {
						System.out.println("Die Eingabe war fehlerhaft.");
					}
				} else {
					System.out.print("Turn: Dot >");
					String input = scanner.nextLine();
					try {
						grid.inserTile(Integer.valueOf(input), dot);
						crossturn = true;
					} catch (NumberFormatException nfe) {
						System.out.println("Die Eingabe war fehlerhaft.");
					}
					
				}
				winner = evaluator.evaluateGameStatus(grid, cross, dot);
				if (winner != null) {
					break;
				}
			}
			break;
		}
		grid.printGameField();
		System.out.println("Player " + winner.getTile() + " wins the game.");

		scanner.close();

	}


}
