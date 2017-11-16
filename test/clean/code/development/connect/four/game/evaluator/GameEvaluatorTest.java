package clean.code.development.connect.four.game.evaluator;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import clean.code.development.connect.four.game.evaluator.GameEvaluator;
import clean.code.development.connect.four.game.model.Grid;
import clean.code.development.connect.four.game.model.Player;
import clean.code.development.connect.four.game.model.Player.TileStyle;
import junit.framework.Assert;

public class GameEvaluatorTest {

	private Grid grid;
	private GameEvaluator evaluator;

	@Before
	public void init() {
		evaluator = new GameEvaluator();
		grid = new Grid();
		grid.setHeight(6);
		grid.setWidth(7);
		grid.generateGrid();
	}

	@Test
	public void testIfPlayerCrossHasHorizontalWin() {
		Player cross = new Player(TileStyle.CROSS.value());
		Player dot = new Player(TileStyle.DOT.value());
		grid.insertTile(0, cross);
		grid.insertTile(1, cross);
		grid.insertTile(2, cross);
		grid.insertTile(3, cross);
		grid.insertTile(4, dot);
		grid.insertTile(5, dot);
		grid.insertTile(6, dot);
		Assert.assertEquals(evaluator.checkHorizontalLineForFourInARow(grid, cross), true);
	}

	@Test
	public void testIfPlayerDotHasHorizontalWin() {
		Player cross = new Player(TileStyle.CROSS.value());
		Player dot = new Player(TileStyle.DOT.value());
		grid.insertTile(0, cross);
		grid.insertTile(1, cross);
		grid.insertTile(2, cross);
		grid.insertTile(0, cross);
		grid.insertTile(6, cross);
		grid.insertTile(6, cross);
		grid.insertTile(1, dot);
		grid.insertTile(2, dot);
		grid.insertTile(3, dot);
		grid.insertTile(3, dot);
		grid.insertTile(4, dot);
		grid.insertTile(4, dot);
		grid.insertTile(5, dot);
		Assert.assertEquals(evaluator.checkHorizontalLineForFourInARow(grid, dot), true);
	}

	@Test
	public void testIfPlayerCrossHasVerticalWin() {
		Player cross = new Player(TileStyle.CROSS.value());
		Player dot = new Player(TileStyle.DOT.value());
		grid.insertTile(0, cross);
		grid.insertTile(0, cross);
		grid.insertTile(0, cross);
		grid.insertTile(0, cross);

		grid.insertTile(1, dot);
		grid.insertTile(1, dot);
		grid.insertTile(1, dot);
		Assert.assertEquals(evaluator.checkVerticalLineForFourInARow(grid, cross), true);
	}

	@Test
	public void testIfPlayerDotHasVerticalWin() {
		Player cross = new Player(TileStyle.CROSS.value());
		Player dot = new Player(TileStyle.DOT.value());
		grid.insertTile(0, cross);
		grid.insertTile(0, cross);
		grid.insertTile(0, cross);
		grid.insertTile(1, dot);
		grid.insertTile(1, dot);
		grid.insertTile(1, dot);
		grid.insertTile(1, dot);
		Assert.assertEquals(evaluator.checkVerticalLineForFourInARow(grid, dot), true);
	}

	@Test
	public void testIfPlayerCrossHasDiagonalWin() {
		Player cross = new Player(TileStyle.CROSS.value());
		Player dot = new Player(TileStyle.DOT.value());
		grid.insertTile(0, cross);
		grid.insertTile(1, dot);
		grid.insertTile(1, cross);
		grid.insertTile(2, dot);
		grid.insertTile(2, dot);
		grid.insertTile(2, cross);
		grid.insertTile(3, cross);
		grid.insertTile(3, dot);
		grid.insertTile(3, cross);
		grid.insertTile(3, cross);
		grid.insertTile(6, dot);
		grid.insertTile(6, dot);
		grid.insertTile(6, dot);
		Assert.assertEquals(evaluator.checkDiagonalLineForFourInARow(grid, cross), true);
	}

	@Test
	public void testIfPlayerDotHasDiagonalWin() {
		Player cross = new Player(TileStyle.CROSS.value());
		Player dot = new Player(TileStyle.DOT.value());
		grid.insertTile(0, dot);
		grid.insertTile(1, cross);
		grid.insertTile(1, dot);
		grid.insertTile(2, cross);
		grid.insertTile(2, cross);
		grid.insertTile(2, dot);
		grid.insertTile(3, dot);
		grid.insertTile(3, cross);
		grid.insertTile(3, dot);
		grid.insertTile(3, dot);
		grid.insertTile(6, cross);
		grid.insertTile(6, cross);
		grid.insertTile(6, cross);
		Assert.assertEquals(evaluator.checkDiagonalLineForFourInARow(grid, dot), true);
	}

	@Test
	public void testIfPlayerDotHasInvertedDiagonalWin() {
		Player cross = new Player(TileStyle.CROSS.value());
		Player dot = new Player(TileStyle.DOT.value());
		grid.insertTile(0, dot);
		grid.insertTile(1, cross);
		grid.insertTile(2, dot);
		grid.insertTile(3, cross);
		grid.insertTile(3, dot);
		grid.insertTile(5, cross);
		grid.insertTile(3, dot);
		grid.insertTile(6, cross);
		grid.insertTile(6, dot);
		grid.insertTile(5, cross);
		grid.insertTile(4, dot);
		grid.insertTile(4, cross);
		grid.insertTile(4, dot);
		grid.insertTile(5, cross);
		grid.insertTile(5, dot);
		Assert.assertEquals(evaluator.checkDiagonalLineForFourInARow(grid, dot), true);
	}

	@Test
	public void testIfPlayerCrossHasInvertedDiagonalWin() {
		Player cross = new Player(TileStyle.CROSS.value());
		Player dot = new Player(TileStyle.DOT.value());
		grid.insertTile(0, dot);
		grid.insertTile(1, cross);
		grid.insertTile(1, dot);
		grid.insertTile(2, cross);
		grid.insertTile(2, cross);
		grid.insertTile(2, dot);
		grid.insertTile(3, cross);
		grid.insertTile(3, dot);
		grid.insertTile(3, dot);
		grid.insertTile(6, cross);
		grid.insertTile(6, cross);
		grid.insertTile(6, cross);
		grid.insertTile(1, cross);
		grid.insertTile(0, dot);
		grid.insertTile(0, dot);
		grid.insertTile(0, cross);
		Assert.assertEquals(evaluator.checkDiagonalLineForFourInARow(grid, cross), true);
	}

	@Test
	public void testEvaluateGameStatusMethod() {
		Player cross = new Player(TileStyle.CROSS.value());
		Player dot = new Player(TileStyle.DOT.value());
		grid.insertTile(0, dot);
		grid.insertTile(1, cross);
		grid.insertTile(1, dot);
		grid.insertTile(2, cross);
		grid.insertTile(2, cross);
		grid.insertTile(2, dot);
		grid.insertTile(3, cross);
		grid.insertTile(3, dot);
		grid.insertTile(3, dot);
		grid.insertTile(6, cross);
		grid.insertTile(6, cross);
		grid.insertTile(6, cross);
		grid.insertTile(1, cross);
		grid.insertTile(0, dot);
		grid.insertTile(0, dot);
		grid.insertTile(0, cross);
		Assert.assertEquals(evaluator.evaluateGameStatus(grid, cross), cross);
	}
	
	@Test
	public void testIfNumbersAreConsecutiveAccending() {
		List<Integer> list = new ArrayList<>();
		list.add(13);
		list.add(11);
		list.add(12);
		list.add(10);
		Assert.assertEquals(evaluator.checkIfFourNumbersAtLeastAreConsecutiveAscending(list), true);
	}

	@Test
	public void testIfNumbersAreNotConsecutiveAccending() {
		List<Integer> list = new ArrayList<>();
		list.add(11);
		list.add(10);
		list.add(14);
		list.add(13);
		Assert.assertEquals(evaluator.checkIfFourNumbersAtLeastAreConsecutiveAscending(list), false);
	}

	@Test
	public void testIfMethodReturnsFalseIfListIsSmallerThanFour() {
		List<Integer> list = new ArrayList<>();
		list.add(11);
		list.add(12);
		Assert.assertEquals(evaluator.checkIfFourNumbersAtLeastAreConsecutiveAscending(list), false);
	}
}
