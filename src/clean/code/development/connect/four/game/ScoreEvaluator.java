package clean.code.development.connect.four.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ScoreEvaluator {

	/**
	 * This method checks if there is currently a winning player. That means
	 * player cross or dot must have four tiles in a row, stacked, or diagonal.
	 * 
	 * @param field
	 * @param cross
	 * @param dot
	 */
	public Player evaluateGameStatus(Grid grid, Player cross, Player dot) {
		if (checkHorizontalLineForFourInARow(grid, cross)) {
			return cross;
		} else if (checkHorizontalLineForFourInARow(grid, dot)) {
			return dot;
		}

		if (checkVerticalLineForFourInARow(grid, cross)) {
			return cross;
		} else if (checkVerticalLineForFourInARow(grid, dot)) {
			return dot;
		}

		if (checkDiagonalLineForFourInARow(grid, cross)) {
			return cross;
		} else if (checkVerticalLineForFourInARow(grid, dot)) {
			return dot;
		}
		return null;
	}

	public boolean checkHorizontalLineForFourInARow(Grid grid, Player player) {
		Map<Integer, List<Integer>> result = createResultList(grid, player);
		for (Map.Entry<Integer, List<Integer>> list : result.entrySet()) {
			if (checkIfFourNumbersAtLeastAreConsecutiveAscending(list.getValue())) {
				return true;
			}
		}
		return false;

	}

	public boolean checkVerticalLineForFourInARow(Grid grid, Player player) {
		for (int i = 0; i < grid.getWidth(); i++) {
			Integer counter = 0;
			for (int j = 0; j < grid.getHeight(); j++) {
				if (grid.getData().get(j).get(i).equals(player.getTile())) {
					counter++;
				} else if (j > 0) {
					if (grid.getData().get(j - 1).get(i).equals(player.getTile())) {
						counter++;
					} else {
						counter = 0;
					}
				}
				if (counter >= 4) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean checkDiagonalLineForFourInARow(Grid grid, Player player) {
		List<Integer> keyList = createResultList(grid, player).keySet().stream().collect(Collectors.toList());
		if(checkIfFourNumbersAtLeastAreConsecutiveAscending(keyList)) {
			
			
			
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Creates a map with all placed tiles of a specific player.
	 * Example:
	 * 4 = [1,2,3,4]
	 * 5 = [2,3]
	 * 
	 * @param grid
	 * @param player
	 * @return
	 */
	public Map<Integer, List<Integer>> createResultList(Grid grid, Player player) {
		Map<Integer, List<Integer>> results = new HashMap<>();
		for (int i = 0; i < grid.getData().size(); i++) {
			for (int j = 0; j < grid.getData().get(i).size(); j++) {
				if (grid.getData().get(i).get(j).equals(player.getTile())) {
					if (results.containsKey(i)) {
						results.get(i).add(j);
					} else {
						List<Integer> innerlist = new ArrayList<>();
						innerlist.add(j);
						results.put(i, innerlist);
					}
				}
			}

		}
		return results;
	}

	/**
	 * Checks if the entries of a list are consecutive ascending.
	 * Example:
	 * [1,2,3,5,6,7,8] => true
	 * [1,2,3,5,6,7] => false
	 * @param list
	 * @return
	 */
	public boolean checkIfFourNumbersAtLeastAreConsecutiveAscending(List<Integer> list) {
		Collections.sort(list);
		int counter = 0;
		for (int i = 0; i < list.size(); i++) {
			if (i == 0) {
				counter++;
			} else if (i > 0) {
				Integer previousValue = list.get(i - 1);
				Integer currentValue = list.get(i);
				Integer sum = previousValue + 1;
				if (sum == currentValue) {
					counter++;
				} else {
					counter = 0;
				}
			}
		}
		return counter >= 4;
	}

	public boolean checkIfFourNumberAtLeastAreConnsecutiveEqual(List<Integer> list) {
		int counter = 0;
		for (int i = 0; i < list.size(); i++) {
			if (i == 0) {
				counter++;
			} else if (i > 0) {
				Integer previousValue = list.get(i - 1);
				Integer currentValue = list.get(i);
				if (previousValue == currentValue) {
					counter++;
				} else {
					counter = 0;
				}
			}
		}
		return counter >= 4;
	}
}
