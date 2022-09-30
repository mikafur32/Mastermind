public enum Peg
{
    WHITE, BLANK, R, G, B, C, M, Y;
    //BLANK = should be the color of the background

    public String toString()
    {
        char box = '■';
        return this == Peg.R ? "\u001b[31m" + box
            :  this == Peg.G ? "\u001b[32m" + box
            :  this == Peg.B ? "\u001b[34m" + box
            :  this == Peg.C ? "\u001b[36m" + box
            :  this == Peg.M ? "\u001b[35m" + box
            :  this == Peg.Y ? "\u001b[33m" + box
            : this == Peg.BLANK  ? "\u001b[30m" + box
            :  "\u001b[37m";
    }

}
