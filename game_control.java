public class Game_Controls {
	private String word;
	private String essai;
	int len;
	public Game_Controls(String w) {
		this.word = w;
		this.essai = "______";
	}

	public boolean makeAttempt(char letter, int position) {
		boolean correct = false;
		if word[position]==letter{
			boolean correct = true;
			essai[position] = letter;
		}
		return boolean correct;
	}
	public String getessai() {
		return essai;
	}
}
