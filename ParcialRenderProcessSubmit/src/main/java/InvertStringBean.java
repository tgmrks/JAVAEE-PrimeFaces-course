import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class InvertStringBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String word;
	private String inverted;
	private int countWord;
	
	public void inverter() {
		this.inverted = "";
		this.countWord = 0;
		
		if (this.word != null && !this.word.isEmpty()) {
			this.countWord = 1;
		}
		
		for (int i = this.word.length() - 1; i >= 0; i--) {
			char c = this.word.charAt(i);
			this.inverted += c;
			
			if (c == ' ') {
				this.countWord++;
			}
		}
		
		System.out.println("Inverted word: " + this.inverted);
	}
	
	public String getWord() {
		return word;
	}
	
	public void setWord(String word) {
		this.word = word;
	}

	public String getInverted() {
		return inverted;
	}

	public int getCountWord() {
		return countWord;
	}

}