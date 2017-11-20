import java.util.Scanner;

public class GamePlayer
{

    private GuessingGame guessingGame;
    private Scanner player;
    public GamePlayer(Scanner player) {
        this.player = player;
        guessingGame = new GuessingGame(GuessingGame.EASY_GAME);
        int state = 0;
        while (state != 3)
        {
         System.out.println("1.  choose difficulty level.");
         System.out.println("2.  pick upper bound for guess.");
         System.out.println("3.  play game.");
         System.out.println("Pick and option 1-3");
         
         state = player.nextInt();
         if (state == 1)
         {
            System.out.println("Please input the difficulty level you want to play");
            System.out.println("1. Easy");
            System.out.println("2. Hard");
            int input = player.nextInt();
            if (input == 1)
            {
               GuessingGame.easyGame = EASY_GAME;
               guessingGame = new GuessingGame(GuessingGame.easyGame);
            }
            else if (input == 2)
            {
               GuessingGame.easyGame = DIFFICULT_GAME;
               guessingGame = new GuessingGame(GuessingGame.easyGame);
               
            }
         } else if (state == 2)
         {
            System.out.println("Please input the upper bound of guess");
            GuessingGame.largestPossibleNumber = player.nextInt();
            guessingGame = new GuessingGame(GuessingGame.easyGame,GuessingGame.largestPossibleNumber);
         }
         
        }
}

    public void play() {
        while (!guessingGame.isGameOver()) {
            System.out.println("1.  make a guess.");
            System.out.println("2.  get a hint.");
            System.out.println("3.  print statistics.");
            System.out.println("4.  quit this game.");
            int input = player.nextInt();
            String s = "";
            switch (input) {
                case 1: {
                    System.out.println("Please input your guess");
                    guessingGame.makeGuess(player.nextInt());
                    s = "";
                }
                break;
                case 2: {
                    s = guessingGame.hint();
                }
                break;
                case 3: {
                    s = guessingGame.toString();
                }
                break;
                case 4: {
                    s = "Thanks For Playing";
                    guessingGame.quit();
                }
                break;
            }
        }
    }

}

