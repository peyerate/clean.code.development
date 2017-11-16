package clean.code.development.connect.four.game.model;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import junit.framework.Assert;

public class GridTest {
	
	@Before
	public void init() {
	}

	@Test
	public void testGridHasDefiniedHeights() {
		Grid grid = new Grid();
		grid.setHeight(10);
		Assert.assertEquals(10, grid.getHeight());
	}
	
	@Test
	public void testGridHasDefiniedWidths() {
		Grid grid = new Grid();
		grid.setWidth(10);
		Assert.assertEquals(10, grid.getWidth());
	}
	
	@Test
	public void testIfDataIsNullIfGridHasNotBeenGenerated() {
		Grid grid = new Grid();
		grid.setHeight(6);
		grid.setWidth(7);
		List<List<String>> data = grid.getData();
		Assert.assertEquals(null, data);
	}
	
	
	@Test
	public void generateGridAndCheckIfDataIsValid() {
		Grid grid = new Grid();
		grid.setHeight(6);
		grid.setWidth(7);
		grid.generateGrid();
		List<List<String>> data = grid.getData();
		Assert.assertEquals("[ ]", data.get(4).get(5));
	}
	
	@Test
	public void testIfInsertingTileIntoGridWorks() {
		Player player = Mockito.mock(Player.class);
		Mockito.when(player.getTile()).thenReturn("[O]");
		Grid grid = new Grid();
		grid.setHeight(6);
		grid.setWidth(7);
		grid.generateGrid();
		grid.insertTile(5, player);
		Assert.assertEquals(player.getTile(), grid.getData().get(5).get(5));
		
	}
}
