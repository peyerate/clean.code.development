package clean.code.development.connect.four.game.main;

import java.io.IOException;
import java.util.Scanner;

import clean.code.development.connect.four.game.evaluator.GameEvaluator;
import clean.code.development.connect.four.game.model.Grid;
import clean.code.development.connect.four.game.model.Player;
import clean.code.development.connect.four.game.model.Player.TileStyle;

public class GameLogic {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		//Setup start
		GameEvaluator evaluator = new GameEvaluator();
		Grid grid = new Grid();
		grid.setHeight(16);
		grid.setWidth(17);
		grid.generateGrid();
		Player cross = new Player(TileStyle.CROSS.value());
		Player dot = new Player(TileStyle.DOT.value());
		Player activePlayer = null;
		//Setup end
		
		int takeTurn = 1;

		while (true) {
			
			//Check which players turn it is
			if (takeTurn > 0)
				activePlayer = cross;
			else
				activePlayer = dot;
			
			grid.printGrid();
			System.out.print(activePlayer.getTile() + ":");

			String input = scanner.nextLine();
			try {
				//check if tile could be inserted, otherwise throw an exception
				if (!grid.insertTile(Integer.valueOf(input), activePlayer))
					throw new IOException();
				//check if any player has successfully placed four tiles in a row
				activePlayer = evaluator.evaluateGameStatus(grid, activePlayer);
				if (activePlayer != null) {
					break;
				}
				takeTurn *= -1;

			} catch (IOException io) {
				System.out.println("Der Spielstein konnte nicht eingefügt werden!");
			} catch (NumberFormatException nfe) {
				System.out.println("Die Eingabe war fehlerhaft.");
			}
		}
		grid.printGrid();
		System.out.println("Player " + activePlayer.getTile() + " wins the game.");
		scanner.close();
	}

}
