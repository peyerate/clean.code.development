package clean.code.development.connect.four.game;

public class Player {

	public enum TileStyle {
		CROSS("[X]"), DOT("[O]");
		String tile;
		
		TileStyle(String tile) {
			this.tile = tile;
		}
		
		public String value() {
			return this.tile;
		}
	}

	private String tile;


	public Player(String tile) {
		this.tile = tile;
	}

	public String getTile() {
		return tile;
	}

	public void setTile(String tile) {
		this.tile = tile;
	}

}
