using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Assignment4
{
    public class Board
    {

        public struct Blank
        {
            public int A, B;
            public double Rank;
            public Blank(int A, int B)
            {
                this.A = A;
                this.B = B;
                Rank = 0;
            }

        }
        public enum user
        {
            X = 1,
            O = -1,
            space = 0,
        }

    }
}
