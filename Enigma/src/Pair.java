
public class Pair {
	private char x;
	private char y;
	
	public Pair(){
		this.x = '\0';
		this.y = '\0';
	}
	
	public Pair(char x, char y){
		this.x = x;
		this.y = y;
	}

	public char getX() {
		return x;
	}

	public void setX(char x) {
		this.x = x;
	}

	public char getY() {
		return y;
	}

	public void setY(char y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Pair [x=" + x + ", y=" + y + "]";
	}
	
}
