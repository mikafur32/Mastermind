public class Main
{
    public static void main(String[] args)
    {
        Game game = new Game();
        while(true)
        {
            //System.out.print("\u001b[1m");
            Code currentGuess = game.guess();
            Code feedback = game.getFeedback(currentGuess);
            if(game.endGame(currentGuess))
            {
                System.out.println("YOU WIN!");
                System.out.println("This was the code: ");
                break;
            }
            gameString(currentGuess, feedback);

            System.out.print("\u001b[0m");
        }

    }
    private static void gameString(Code currentGuess, Code feedback) //186
    {
        System.out.println("\u001b[0m" + "║ " + currentGuess.toString() + "\u001b[0m" + " ║ " + feedback.toString() + "\u001b[0m" + " ║" );
    }
}
