import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Dictionnary {
    private ArrayList<String> words = new ArrayList<>();

    public Dictionnary(String filePath, int len) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.length() == len) {
                    words.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getRandomWord() {
        Random random = new Random();
        int index = random.nextInt(words.size());
        return words.get(index);
    }

    public static void main(String[] args) {
        Dictionnary dictionary = new Dictionnary("./Doc.txt", 7);
        String randomWord = dictionary.getRandomWord();
        System.out.println(randomWord);
    }

}
