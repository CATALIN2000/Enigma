import java.util.Arrays;

public class Rotor {
	public char[] rotor;
	public char[] basic = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N',
			'O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	public int contor = 0;
	
	public Rotor(){
		this.rotor = "".toCharArray();
	}
	
	public Rotor(int rotnum){
		if(rotnum == 1){
			this.rotor = "EKMFLGDQVZNTOWYHXUSPAIBRCJ".toCharArray();
		}else if(rotnum == 2){
			this.rotor = "AJDKSIRUXBLHWTMCQGZNPYFVOE".toCharArray();
		}else if(rotnum == 3){
			this.rotor = "BDFHJLCPRTXVZNYEIWGAKMUSQO".toCharArray();
		}else if(rotnum == 4){
			this.rotor = "ESOVPZJAYQUIRHXLNFTGKDCMWB".toCharArray();
		}else if(rotnum == 5){
			this.rotor = "VZBRGITYUPSDNHLXAWMJQOFECK".toCharArray();
		}else if(rotnum == 6){
			this.rotor = "JPGVOUMFYQBENHZRDKASXLICTW".toCharArray();
		}else if(rotnum == 7){
			this.rotor = "NZJHGRCXMYSWBOUFAIVLPEKQDT".toCharArray();
		}else{
			this.rotor = "FKQHTLXOCBJSPDZRAMEWNIUYGV".toCharArray();
		}
	}
	
	public char changeLetter (char input){
		int poz = 0;
		for(int i = 0 ; i < basic.length ; i++){
			if(input == basic[i]){
				poz = i;
				break;
			}
		}
		return rotor[poz];
	}
	
	public char changeInverseLetter (char input){
		int poz = 0;
		for(int i = 0 ; i < rotor.length ; i++){
			if(input == rotor[i]){
				poz = i;
				break;
			}
		}
		return basic[poz];
	}

	public int getContor() {
		return contor;
	}

	public void setContor() {
		this.contor++;// = (++this.contor) % 26;
	}
	
	public void subContor() {
		this.contor--;
	}
	
	public void setContor(int cont){
		this.contor = cont;
	}

	public char[] getRotor() {
		return rotor;
	}

	public void setRotor(char[] rotor) {
		this.rotor = rotor;
	}

	public char[] getBasic() {
		return basic;
	}

	public void setBasic(char[] basic) {
		this.basic = basic;
	}

	@Override
	public String toString() {
		return "Rotor [rotor=" + Arrays.toString(rotor) + "]";
	}

}
