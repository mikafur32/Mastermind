public class Code
{
    private Peg one;
    private Peg two;
    private Peg three;
    private Peg four;

    public Code(final Peg one, final Peg two, final Peg three, final Peg four)
    {
        this.one = one;
        this.two = two;
        this.three = three;
        this.four = four;
    }
    public Code()
    {
        one = Peg.BLANK;
        two = Peg.BLANK;
        three = Peg.BLANK;
        four = Peg.BLANK;
    }
    public void set(Peg peg, int index)
    {
        if(index == 0)
        {
            one = peg;
        }
        if(index == 1)
        {
            two = peg;
        }
        if(index == 2)
        {
            three = peg;
        }
        if(index == 3)
        {
            four = peg;
        }
    }

    public boolean isValid()
    {
        if(this == null)
        {
            return false;
        }
        return one != null &&
            two != null &&
            three != null &&
            four != null;
    }

    public String toString()
    {
        return one.toString() + " "
            +  two.toString() + " "
            +  three.toString() + " "
            +  four.toString();
    }

    public Peg pegAt(int index)
    {
        return index == 0 ? one
            : index == 1 ? two
            : index == 2 ? three
            : four;
    }

    public boolean contains(Peg guess)
    {
        for (int i = 0; i < 4; i++)
        {
            if(guess.equals(this.pegAt(i)))
            {
                return true;
            }
        }
        return false;
    }

    public int numSameColor(Peg guess)
    {
        int numPegs = 0;
        for (int i = 0; i < 4; i++)
        {
            if(guess.equals(this.pegAt(i)))
            {
                numPegs++;
            }
        }
        return numPegs;
    }
    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        final Code code = (Code)o;
        return one == code.one &&
            two == code.two &&
            three == code.three &&
            four == code.four;
    }

}
