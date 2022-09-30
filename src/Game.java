import java.util.*;
import sison.ui.*;
public class Game
{
    private Random rng;
    private Code code;
    private int numGuesses;

    public Game()
    {
        rng = new Random();
        code = getRandomCode();
        numGuesses = 0;
    }

    private int getNewRNG()
    {
         return rng.nextInt(6); //  R, G, B, C, M, Y
    }

    public Code guess()
    {
        String guess = Input.get("Enter guess");
        if(guess.length() != 4 || getCode(guess) == null || !getCode(guess).isValid())
        {
            System.out.println("Invalid guess! Try Again.");
            return guess();
        }
        numGuesses++;
        return this.getCode(guess);
    }

    public Code getFeedback(Code guess)
    {
        Code feedback = new Code();
        int redCount = 0;
        int whiteCount = 0;
        for (int i = 0; i < 4; i++)
        {
            if (guess.pegAt(i).equals(code.pegAt(i)))
            {
                redCount++;
            }
        }
        for (int i = 0; i < 4; i++)
        {
            if(code.contains(guess.pegAt(i)) && code.numSameColor(guess.pegAt(i)) != whiteCount && code.numSameColor(guess.pegAt(i)) != redCount)
            {
                whiteCount++;
            }
        }
        for (int i = 0; i < redCount; i++)
        {
            feedback.set(Peg.R, i);
        }
        for (int i = redCount; i < redCount + whiteCount ; i++)
        {
            feedback.set(Peg.WHITE, i);
        }
        return feedback;
    }

    private Peg rnConvert(String rn)
    {
        return rn.equalsIgnoreCase("R") ? Peg.R
            :  rn.equalsIgnoreCase("G") ? Peg.G
            :  rn.equalsIgnoreCase("B") ? Peg.B
            :  rn.equalsIgnoreCase("C") ? Peg.C
            :  rn.equalsIgnoreCase("M") ? Peg.M
            :  rn.equalsIgnoreCase("Y") ? Peg.Y : null;
    }

    private static Peg rnConvert(int rn)
    {
        return rn == 0 ? Peg.R
            : rn ==  1 ? Peg.G
            : rn ==  2 ? Peg.B
            : rn ==  3 ? Peg.C
            : rn ==  4 ? Peg.M
            : rn ==  5 ? Peg.Y : null;
    }

    public Code getCode(int one, int two, int three, int four)
    {
        return new Code(rnConvert(one), rnConvert(two), rnConvert(three), rnConvert(four));
    }
    public Code getCode(String guess)
    {
        if(guess.length() != 4)
        {
            return null;
        }
        String one = guess.substring(0,1);
        String two = guess.substring(1,2);
        String three = guess.substring(2,3);
        String four = guess.substring(3,4);

        return new Code(rnConvert(one), rnConvert(two), rnConvert(three), rnConvert(four));
    }

    public Code getRandomCode()
    {
        return new Code(rnConvert(getNewRNG()), rnConvert(getNewRNG()), rnConvert(getNewRNG()), rnConvert(getNewRNG()));
    }

    public boolean endGame(Code guess)
    {
        return guess.equals(code) || numGuesses >= 10;
    }
}
    //$ Create a method that can randomly generate a code.
    //$ Each peg in the code must be able to represent one of at least four distinct colors.

    //Print at least one randomly generated code to the terminal.
    //$ Each peg in the code must be printed in its appropriate color.
    //$ You may choose whatever symbol you’d like for representing pegs (I recommend the ■ character!).

    //$ Create a method that converts user input into a code.
    //$ For example, to convert a string like “RGBB” into a code.
    //$ Take in user input for a code, convert the input into a code, and print the code out.
    //$ You must appropriately handle invalid input by displaying an error message
    //$ and re-asking the user for input until they enter something valid.
