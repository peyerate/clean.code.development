package clean.code.development.connect.four.game;

import java.util.ArrayList;
import java.util.List;

public class Grid {

	private int height;
	private int width;
	private List<List<String>> data;
	
	private String EMPTY_FIELD = "[ ]";

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public List<List<String>> getData() {
		return data;
	}

	public void setData(List<List<String>> data) {
		this.data = data;
	}

	private List<String> createHorizontalFields(int width) {
		List<String> xAxis = new ArrayList<>();
		for (int i = 0; i < width; i++) {
			xAxis.add(EMPTY_FIELD);
		}
		return xAxis;
	}

	public void generateGameField() {
		List<List<String>> yAxis = new ArrayList<>();
		for (int j = 0; j < height; j++) {
			List<String> xAxis = createHorizontalFields(width);
			yAxis.add(xAxis);
		}
		data = yAxis;
	}
	
	public void resetGameField() {
		generateGameField();
	}

	public String createHorizontalNumbering() {
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < width; i++) {
			sb.append(" " + i + " ");
		}
		return sb.toString();
	}

	public boolean inserTile(int xAxisPosition, Player player) {
		if(xAxisPosition < 0 || xAxisPosition > width) {
			return false;
		}
		for (int j = height - 1; j >= 0; j--) {
			if (data.get(j).get(xAxisPosition) == EMPTY_FIELD) {
				data.get(j).set(xAxisPosition, player.getTile());
				return true;
			}
		}
		return false;
	}
	
	public void printGameField() {
		System.out.println(createHorizontalNumbering());
		for (int i = 0; i < getHeight(); i++) {
			for (int j = 0; j < getWidth(); j++) {
				System.out.print(getData().get(i).get(j));
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		Grid grid = new Grid();
		grid.setHeight(6);
		grid.setWidth(7);

		Player x = new Player("");
		Player o = new Player("");
		grid.generateGameField();
		x.setTile("[X]");
		o.setTile("[O]");
		grid.inserTile(0, x);
		grid.inserTile(0, o);
		grid.inserTile(0, x);
		grid.inserTile(6, o);
		
		
		System.out.println(grid.createHorizontalNumbering());
		for (int i = 0; i < grid.getHeight(); i++) {
			for (int j = 0; j < grid.getWidth(); j++) {
				System.out.print(grid.getData().get(i).get(j));
			}
			System.out.println("");
		}
	}
}
