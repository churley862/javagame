import java.util.Random;

public class GuessingGame
{
    public final boolean EASY_GAME = true;
    public final boolean DIFFICULT_GAME = false;
    public final int DEFAULT_MAXIMUM_RANGE = 10;

    public final int GAME_WON = 1;
    public final int GAME_LOST = 0;
    public final int GAME_IN_PROGRESS = -1;
    private int gameState = GAME_IN_PROGRESS;

    public int numberToGuess;
    public int numberOfGuesses;
    public int largestPossibleNumber;
    public int maximumNumberOfGuesses;

    public int currentMinimumRange;
    public int currentMaximumRange;
    public boolean guessTooLow = false;
    public boolean easyGame = true;

    private Random rand = new Random();

    public GuessingGame(int largestPossibleNumber, boolean difficulty) {
        setLargestPossibleNumber(largestPossibleNumber);
        setEasyGame(difficulty);
        setNumberToGuess(rand.nextInt(largestPossibleNumber));
    }


    public GuessingGame(boolean difficulty) {
        this(DEFAULT_MAXIMUM_RANGE, difficulty);
    }


    public GuessingGame(int largestPossibleNumber) {
        this(largestPossibleNumber, true);
    }


    public GuessingGame() {
        this(DEFAULT_MAXIMUM_RANGE, true);
    }


    public void setGameState(int state) {
        this.gameState = state;
    }

    public boolean isGameOver() {
        return gameState != GAME_IN_PROGRESS;
    }

    private void setNumberToGuess(int number) {
        this.numberToGuess = number;
    }


    private void setNumberOfGuesses(int number) {
        this.numberOfGuesses = number;
    }



    private void setLargestPossibleNumber(int number) {
        this.largestPossibleNumber = number;
    }


    private void setEasyGame(boolean difficulty) {
        this.easyGame = difficulty;
    }

    private int computeMaxNumberOfGuesses() {
        if (easyGame)
        {
            double a = (double)largestPossibleNumber / 2.0;
            return (int)a;
        } else
        {
            int a = largestPossibleNumber;
            int count = 0;
            while (a != 1) {
                count++;
                a = a/2;
            }
            return count;
        }
    }


    private void setCurrentMinimumRange(int min) {
        this.currentMinimumRange = min;
    }


    private void setCurrentMaximumRange(int max) {
        // TODO implement me
        this.currentMaximumRange = max;
    }


    public void setGuessTooLow(boolean tooLow) {
        // TODO implement me
        if (tooLow)
            this.guessTooLow = true;
        else
            this.guessTooLow = false;
    }


    public void makeGuess(int guess) {
        // TODO implement me
        if(gameState == GAME_IN_PROGRESS)
        {
            if (numberOfGuesses == maximumNumberOfGuesses)
            {
                quit();
            }
            else
            {
                numberOfGuesses++;
                if(guess == numberToGuess)
                {
                    gameState = GAME_WON;
                }
                else if (guess < numberToGuess)
                {
                    guessTooLow = true;
                    if (currentMinimumRange < guess)
                        setCurrentMinimumRange(guess);
                }
                else if (guess > numberToGuess)
                {
                    guessTooLow = false;
                    if (currentMaximumRange > guess)
                        setCurrentMaximumRange(guess);
                }
            }
        }
    }

    public String hint() {
        String hint = "Choose a number between " + currentMinimumRange +
                      "and " + currentMaximumRange;
        return hint;
    }



    public void quit() {
        setGameState(GAME_LOST);
    }



    public String toString()
    {
        if(gameState == GAME_LOST)
        {
            return "Game Over you lost, you used " + numberOfGuesses +
                   "Out of your maximum " + maximumNumberOfGuesses +
                   "guesses, better luck next time!";
        }
        else if (gameState == GAME_WON)
        {
            return "You Win! It took you " + numberOfGuesses +
                   " to determine our number was" + numberToGuess;
        }
        else
        {
            return "You have " + (maximumNumberOfGuesses - numberOfGuesses) +
                   " guesses remaining, good luck!";
        }
    }

}

