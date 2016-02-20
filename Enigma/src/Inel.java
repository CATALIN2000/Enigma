import java.util.*;

public class Inel {
	public char[] inel;
	public char notch, notch2;
	public char[] basic = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N',
			'O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	public int contor = 0;

	public Inel(){
		this.inel = "".toCharArray();
	}
	
	public Inel(int inelnum){
		if(inelnum == 1){
			this.inel = "EKMFLGDQVZNTOWYHXUSPAIBRCJ".toCharArray();
			this.notch = 'R';
		}else if(inelnum == 2){
			this.inel = "AJDKSIRUXBLHWTMCQGZNPYFVOE".toCharArray();
			this.notch = 'F';
		}else if(inelnum == 3){
			this.inel = "BDFHJLCPRTXVZNYEIWGAKMUSQO".toCharArray();
			this.notch = 'W';
		}else if(inelnum == 4){
			this.inel = "ESOVPZJAYQUIRHXLNFTGKDCMWB".toCharArray();
			this.notch = 'K';
		}else if(inelnum == 5){
			this.inel = "VZBRGITYUPSDNHLXAWMJQOFECK".toCharArray();
			this.notch = 'A';
		}else if(inelnum == 6){
			this.inel = "JPGVOUMFYQBENHZRDKASXLICTW".toCharArray();
			this.notch = 'A';
			this.notch2 = 'N';
		}else if(inelnum == 7){
			this.inel = "NZJHGRCXMYSWBOUFAIVLPEKQDT".toCharArray();
			this.notch = 'A';
			this.notch2 = 'N';
		}else{
			this.inel = "FKQHTLXOCBJSPDZRAMEWNIUYGV".toCharArray();
			this.notch = 'A';
			this.notch2 = 'N';
		}
	}

	public int getContor() {
		return contor;
	}

	public void setContor() {
		this.contor++;
	}

	public char[] getInel() {
		return inel;
	}

	public void setInel(char[] inel) {
		this.inel = inel;
	}

	public char getNotch() {
		return notch;
	}

	public void setNotch(char notch) {
		this.notch = notch;
	}

	public char getNotch2() {
		return notch2;
	}

	public void setNotch2(char notch2) {
		this.notch2 = notch2;
	}

	public char[] getBasic() {
		return basic;
	}

	public void setBasic(char[] basic) {
		this.basic = basic;
	}

	@Override
	public String toString() {
		return "Inel [inel=" + Arrays.toString(inel) + ", notch=" + notch + ", notch2=" + notch2 + "]";
	}
	
	
}
