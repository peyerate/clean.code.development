package clean.code.development.connect.four.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
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
//		Map map = createResultList(field, cross);
//		map.forEach((a,b)->{System.out.println("key: " + a + ", key: " + b);});
//		System.out.println("");
		
		if(checkHorizontalLineForFourInARow(grid, cross)){
			return cross;
		} else if(checkHorizontalLineForFourInARow(grid, dot)) {
			return dot;
		}
		return null;
	}

//	public boolean checkHorizontalLineForFourInARow(Grid field, Player player) {
//		List<Integer> tmp = new ArrayList<>();
//		field.getData().forEach(y -> {
//			if (tmp.size() < 4) {
//				tmp.clear();
//			}
//			y.forEach(x -> {
//				if (x.equals(player.getTile())) {
//					tmp.add(1);
//					if (tmp.size() == 4) {
//						return;
//					}
//				} else {
//					if(tmp.size()<4) {
//						tmp.clear();
//					}
//				}
//			});
//		});
//		if (tmp.size() >= 4) {
//			return true;
//		}
//		return false;
//	}
	
	public boolean checkHorizontalLineForFourInARow(Grid grid, Player player) {
		Map<Integer, List<Integer>> result = createResultList(grid, player);
		for(Map.Entry<Integer, List<Integer>> list : result.entrySet()) {
			if(checkIfFourNumbersAtLeastAreConsecutiveAccending(list.getValue())) {
				return true;
			}
		}
		return false;
		
	}
	
	public boolean checkVerticalLineForFourInARow(Grid grid, Player player) {
		List<String> results = new ArrayList<>();
		grid.getData().stream().filter(y -> {
			
			return true;
		}).collect(Collectors.toList());
		return false;
	}

	public boolean checkDiagonalLineForFourInARow(Grid grid, Player player) {
		return false;
	}
	
	public Map<Integer,List<Integer>> createResultList(Grid grid, Player player) {
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
	
	public boolean checkIfFourNumbersAtLeastAreConsecutiveAccending(List<Integer> list) {
		Collections.sort(list);
		int counter = 0;
		for (int i = 0; i < list.size(); i++) {
			if (i == 0) {
				counter++;
			} else if(i>0) {
				Integer previousValue = list.get(i-1);
				Integer currentValue = list.get(i);
				Integer sum = previousValue + 1;
				if(sum == currentValue) {
					counter++;
				} else {
					counter = 0;
				}
			}
		}
		return counter >= 4;
	}
}
