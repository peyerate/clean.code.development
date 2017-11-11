package clean.code.development;


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
	public void testIf() {
		Player cross = new Player(TileStyle.CROSS.value());
		Player dot = new Player(TileStyle.DOT.value());
		field.inserTile(0, cross);
		field.inserTile(1, cross);
		field.inserTile(2, cross);
		field.inserTile(3, cross);
		
		field.inserTile(4, dot);
		field.inserTile(5, dot);
		field.inserTile(6, dot);
		
//		field.getData().get(5).set(0, "[X]");
//		field.getData().get(5).set(1, "[X]");
//		field.getData().get(5).set(2, "[X]");
//		field.getData().get(5).set(3, "[X]");
//		field.getData().get(5).set(4, "[O]");
//		field.getData().get(5).set(5, "[O]");
//		field.getData().get(5).set(6, "[O]");
		field.printGameField();
		evaluator.evaluateWinningStatusOfPlayer(field, cross, dot);
		Assert.assertEquals(2, 2);
	}
}
