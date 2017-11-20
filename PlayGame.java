import java.util.Scanner;

public class PlayGame
{
	private GamePlayer gamePlayer;
   
	public static void main(String [] args)throws Exception
    {
		// TODO implement me
      Scanner player = new Scanner(System.in);	
      String playAgain = "yes";
      while(playAgain == "yes")
      {
         GamePlayer gamePlayer = new GamePlayer(player);
         gamePlayer.play();
         System.out.println("play again?");
         playAgain = player.next();
      }
	}
}

