import java.io.*;

public class HighScoreManager {

    private static final String HIGH_SCORE_FILE = "highscores.txt";

    public static int loadHighScore() {
        try (BufferedReader reader = new BufferedReader(new FileReader(HIGH_SCORE_FILE))) {
            String line = reader.readLine();
            return Integer.parseInt(line.trim());
        } catch (IOException | NumberFormatException e) {
            return 0; // Handle exceptions and return a default value
        }
    }

    public static void saveHighScore(int highScore) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(HIGH_SCORE_FILE))) {
            writer.write(Integer.toString(highScore));
        } catch (IOException e) {
            e.printStackTrace(); // Handle exceptions appropriately
        }
    }

    public static void updateHighScore(int currentScore) {
        int existingHighScore = loadHighScore();
        if (currentScore > existingHighScore) {
            saveHighScore(currentScore);
        }
    }
}