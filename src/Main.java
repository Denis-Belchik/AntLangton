import AntLangton.AntGame;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        AntGame antGame = new AntGame(3);
        antGame.play(30000);
    }
}