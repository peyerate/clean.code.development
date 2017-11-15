package clean.code.development;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import clean.code.development.connect.four.game.Grid;
import clean.code.development.connect.four.game.Player;
import clean.code.development.connect.four.game.Player.TileStyle;
import clean.code.development.connect.four.game.ScoreEvaluator;
import junit.framework.Assert;

public class ScoreEvaluatorTest {

	private Grid field;
	private ScoreEvaluator evaluator;

	@Before
	public void init() {
		evaluator = new ScoreEvaluator();
		field = new Grid();
		field.setHeight(6);
		field.setWidth(7);
		field.generateGameField();
	}

	@Test
	public void testIfPlayerCrossHasHorizontalWin() {
		Player cross = new Player(TileStyle.CROSS.value());
		Player dot = new Player(TileStyle.DOT.value());
		field.inserTile(0, cross);
		field.inserTile(1, cross);
		field.inserTile(2, cross);
		field.inserTile(3, cross);
		field.inserTile(4, dot);
		field.inserTile(5, dot);
		field.inserTile(6, dot);
		// field.printGameField();
		Assert.assertEquals(evaluator.checkHorizontalLineForFourInARow(field, cross), true);
	}

	@Test
	public void testIfPlayerDotHasHorizontalWin() {
		Player cross = new Player(TileStyle.CROSS.value());
		Player dot = new Player(TileStyle.DOT.value());
		field.inserTile(0, cross);
		field.inserTile(1, cross);
		field.inserTile(2, cross);
		field.inserTile(0, cross);
		field.inserTile(6, cross);
		field.inserTile(6, cross);
		field.inserTile(1, dot);
		field.inserTile(2, dot);
		field.inserTile(3, dot);
		field.inserTile(3, dot);
		field.inserTile(4, dot);
		field.inserTile(4, dot);
		field.inserTile(5, dot);
		// field.printGameField();
		Assert.assertEquals(evaluator.checkHorizontalLineForFourInARow(field, dot), true);
	}

	@Test
	public void testIfPlayerCrossHasVerticalWin() {
		Player cross = new Player(TileStyle.CROSS.value());
		Player dot = new Player(TileStyle.DOT.value());
		field.inserTile(0, cross);
		field.inserTile(0, cross);
		field.inserTile(0, cross);
		field.inserTile(0, cross);

		field.inserTile(1, dot);
		field.inserTile(1, dot);
		field.inserTile(1, dot);
		// field.printGameField();
		Assert.assertEquals(evaluator.checkVerticalLineForFourInARow(field, cross), true);
	}

	@Test
	public void testIfPlayerDotHasVerticalWin() {
		Player cross = new Player(TileStyle.CROSS.value());
		Player dot = new Player(TileStyle.DOT.value());
		field.inserTile(0, cross);
		field.inserTile(0, cross);
		field.inserTile(0, cross);
		field.inserTile(1, dot);
		field.inserTile(1, dot);
		field.inserTile(1, dot);
		field.inserTile(1, dot);
		// field.printGameField();
		Assert.assertEquals(evaluator.checkVerticalLineForFourInARow(field, dot), true);
	}

	@Test
	public void testIfPlayerCrossHasDiagonalWin() {
		Player cross = new Player(TileStyle.CROSS.value());
		Player dot = new Player(TileStyle.DOT.value());
		field.inserTile(0, cross);
		field.inserTile(1, dot);
		field.inserTile(1, cross);
		field.inserTile(2, dot);
		field.inserTile(2, dot);
		field.inserTile(2, cross);
		field.inserTile(3, cross);
		field.inserTile(3, dot);
		field.inserTile(3, cross);
		field.inserTile(3, cross);
		field.inserTile(6, dot);
		field.inserTile(6, dot);
		field.inserTile(6, dot);
		// field.printGameField();
		Assert.assertEquals(evaluator.checkDiagonalLineForFourInARow(field, cross), true);
	}

	@Test
	public void testIfPlayerDotHasDiagonalWin() {
		Player cross = new Player(TileStyle.CROSS.value());
		Player dot = new Player(TileStyle.DOT.value());
		field.inserTile(0, dot);
		field.inserTile(1, cross);
		field.inserTile(1, dot);
		field.inserTile(2, cross);
		field.inserTile(2, cross);
		field.inserTile(2, dot);
		field.inserTile(3, dot);
		field.inserTile(3, cross);
		field.inserTile(3, dot);
		field.inserTile(3, dot);
		field.inserTile(6, cross);
		field.inserTile(6, cross);
		field.inserTile(6, cross);
		// field.printGameField();
		Assert.assertEquals(evaluator.checkDiagonalLineForFourInARow(field, dot), true);
	}

	@Test
	public void testIfPlayerDotHasInvertedDiagonalWin() {
		Player cross = new Player(TileStyle.CROSS.value());
		Player dot = new Player(TileStyle.DOT.value());
		field.inserTile(0, dot);
		field.inserTile(1, cross);
		field.inserTile(2, dot);
		field.inserTile(3, cross);
		field.inserTile(3, dot);
		field.inserTile(5, cross);
		field.inserTile(3, dot);
		field.inserTile(6, cross);
		field.inserTile(6, dot);
		field.inserTile(5, cross);
		field.inserTile(4, dot);
		field.inserTile(4, cross);
		field.inserTile(4, dot);
		field.inserTile(5, cross);
		field.inserTile(5, dot);
		// field.printGameField();
		Assert.assertEquals(evaluator.checkDiagonalLineForFourInARow(field, dot), true);
	}

	@Test
	public void testIfPlayerCrossHasInvertedDiagonalWin() {
		Player cross = new Player(TileStyle.CROSS.value());
		Player dot = new Player(TileStyle.DOT.value());
		field.inserTile(0, dot);
		field.inserTile(1, cross);
		field.inserTile(1, dot);
		field.inserTile(2, cross);
		field.inserTile(2, cross);
		field.inserTile(2, dot);
		field.inserTile(3, cross);
		field.inserTile(3, dot);
		field.inserTile(3, dot);
		field.inserTile(6, cross);
		field.inserTile(6, cross);
		field.inserTile(6, cross);
		field.inserTile(1, cross);
		field.inserTile(0, dot);
		field.inserTile(0, dot);
		field.inserTile(0, cross);
		// field.printGameField();
		Assert.assertEquals(evaluator.checkDiagonalLineForFourInARow(field, cross), true);
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
