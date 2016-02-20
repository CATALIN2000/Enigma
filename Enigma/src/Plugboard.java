import java.util.*;

public class Plugboard {
	public char[] basic = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N',
			'O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	public char[] board = new char[26];
	
	public Plugboard(){
		int len = basic.length;
		for(int i = 0 ; i < len ; i++){
			board[i] = basic[i];
		}
	}
	
	public Plugboard(ArrayList<Pair> pluginput){
		int len = basic.length;
		for(int i = 0 ; i < len ; i++){
			board[i] = basic[i];
		}
		for(Pair pereche: pluginput){
			char compare = pereche.getX();
			char put = pereche.getY();
			for(int i = 0 ; i < len ; i++){
				if(basic[i] == compare){
					board[i] = put;
					i++;
				}
				if(basic[i] == put){
					board[i] = compare;
					i++;
				}
			}
		}
	}
	
	public char getLetter(char input){
		int poz = 0;
		for(int i = 0 ; i < 26 ; i++){
			if(basic[i] == input){
				poz = i;
				break;
			}
		}
		return board[poz];
	}
	
	public char getInverseLetter(char input){
		int poz = 0;
		for(int i = 0 ; i < 26 ; i++){
			if(board[i] == input){
				poz = i;
				break;
			}
		}
		return basic[poz];
	}

	public char[] getBasic() {
		return basic;
	}

	public void setBasic(char[] basic) {
		this.basic = basic;
	}

	public char[] getBoard() {
		return board;
	}

	public void setBoard(char[] board) {
		this.board = board;
	}

	@Override
	public String toString() {
		return "Plugboard [board=" + Arrays.toString(board) + "]";
	}
	
}
