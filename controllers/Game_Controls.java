public class Game_Controls {
	private String word;
    private String attempt;
	private char[] essai;
	int len;
	public char[] Controls(String w, String t) {
		this.word = w;
        this.attempt=t;
        this.essai = new char[word.length()];
        for (int i = 0; i < essai.length; i++) {
            essai[i] = '_';
        }
        return essai;
	}

	public boolean makeAttempt(char letter, int position) {
		boolean correct = false;
		if (word.charAt(position)==letter){
			correct = true;  
			essai[position] = letter;
		}
		return correct;
	}
	public char[] getessai() {
		return essai;
    }
    public static void main(String[] args) {
        Game_Controls game = new Game_Controls();
        char[] essai = game.Controls("acetals", "acetate");
        for (int i = 0; i < 7; i++) {
            game.makeAttempt(game.attempt.charAt(i), i);
        }
        essai = game.getessai();
        System.out.println(essai);
    }
}