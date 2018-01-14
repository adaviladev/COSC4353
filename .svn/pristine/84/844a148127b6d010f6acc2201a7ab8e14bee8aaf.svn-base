using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Assignment4
{
    public class BoardInitialize : Board
    {
        public user[,] gameBoard;
        public Blank get_BestMove(int iLength, int iWidth)
        {
            int count = 0, cnt_player = 0;
            Blank s = new Blank();
            Random rand = new Random();
            for (int x = 0; x < iLength; x++)
            {
                count = 0;
                for (int y = 0; y < iWidth; y++)
                {
                    count += (int)gameBoard[x, y];
                    if ((int)gameBoard[x, y] == 0)
                    {
                        s = new Blank(x, y);
                    }
                }
                if (count == iWidth - 1 || count == -iWidth + 1)
                {
                    return s;
                }
            }

            for (int x = 0; x < iWidth; x++)
            {
                count = 0;
                for (int y = 0; y < iLength; y++)
                {
                    count += (int)gameBoard[y, x];
                    if ((int)gameBoard[y, x] == 0)
                    {
                        s = new Blank(y, x);
                    }
                }
                if (count == iWidth - 1 || count == -iWidth + 1)
                {
                    return s;
                }
            }


            count = 0;
            for (int i = 0; i < iLength; i++)
            {
                for (int j = 0; j < iWidth; j++)
                {
                    if (i == j)
                    {
                        count += (int)gameBoard[i, j];
                        if ((int)gameBoard[i, j] == 0)
                        {
                            s = new Blank(i, j);
                        }
                    }
                }
            }
            if (count == iWidth - 1 || count == -iWidth + 1)
            {
                return s;
            }

            count = 0;
            for (int i = 0; i < iLength; i++)
            {
                for (int j = 0; j < iWidth; j++)
                {
                    if (i + j + 1 == iWidth)
                    {
                        count += (int)gameBoard[i, j];
                        if ((int)gameBoard[i, j] == 0)
                        {
                            s = new Blank(i, j);
                        }
                    }
                }
            }
            if (count == iWidth - 1 || count == -iWidth + 1)
            {
                return s;
            }
            for (int x = 0; x < iLength; x++)
            {
                count = 0;
                cnt_player = 0;
                for (int y = 0; y < iWidth; y++)
                {
                    count += (int)gameBoard[x, y];
                    if ((int)gameBoard[x, y] == -1)
                        cnt_player++;
                    if ((int)gameBoard[x, y] == 0)
                    {
                        s = new Blank(x, y);
                    }
                }
                if (count < iWidth && cnt_player == 0)
                {
                    return s;
                }
            }


            for (int x = 0; x < iWidth; x++)
            {
                count = 0;
                cnt_player = 0;
                for (int y = 0; y < iLength; y++)
                {
                    count += (int)gameBoard[y, x];
                    if ((int)gameBoard[y, x] == -1)
                        cnt_player++;
                    if ((int)gameBoard[y, x] == 0)
                    {
                        s = new Blank(y, x);
                    }
                }
                if (count < iWidth && cnt_player == 0)
                {
                    return s;
                }
            }

            count = 0;
            cnt_player = 0;
            for (int i = 0; i < iLength; i++)
            {
                for (int j = 0; j < iWidth; j++)
                {
                    if (i == j)
                    {
                        count += (int)gameBoard[i, j];
                        if ((int)gameBoard[i, j] == -1)
                            cnt_player++;
                        if ((int)gameBoard[i, j] == 0)
                        {
                            s = new Blank(i, j);
                        }
                    }
                }
                if (count < iWidth && cnt_player == 0)
                {
                    return s;
                }
            }


            count = 0;
            cnt_player = 0;
            for (int i = 0; i < iLength; i++)
            {
                for (int j = 0; j < iWidth; j++)
                {
                    if (i + j + 1 == iWidth)
                    {
                        count += (int)gameBoard[i, j];
                        if ((int)gameBoard[i, j] == -1)
                            cnt_player++;
                        if ((int)gameBoard[i, j] == 0)
                        {
                            s = new Blank(i, j);
                        }
                    }
                }
                if (count < iWidth && cnt_player == 0)
                {
                    return s;
                }
            }
            do
            {
                s = new Blank(rand.Next(0, iLength), rand.Next(0, iWidth));
            } while (isFull(s.A, s.B));
            return s;
        }
        public BoardInitialize(int X, int Y)
        {
            gameBoard = new user[X, Y];
            for (int i = 0; i < X; i++)
            {
                for (int j = 0; j < Y; j++)
                {
                    gameBoard[i, j] = 0;
                }
            }

        }

        public bool isTaken
        {
            get
            {
                foreach (user u in gameBoard)
                    if (u == user.space) { return false; }
                return true;
            }
        }
        public int Size(int X)
        {
            return X * X;
        }

        public user this[int x, int y]
        {
            get
            {
                return gameBoard[x, y];
            }

            set
            {
                gameBoard[x, y] = value;
            }
        }
        public List<Blank> blankPlaces(int X, int Y)
        {
            List<Blank> bP = new List<Blank>();
            for (int x = 0; x < X; x++)
                for (int y = 0; y < Y; y++)
                    if (gameBoard[x, y] == user.space)
                        bP.Add(new Blank(x, y));
            return bP;
        }
        public bool isFull(int x, int y)
        {
            if (gameBoard[x, y] == user.space)
                return false;
            else
                return true;
        }




        public BoardInitialize Clone(int Length, int width)
        {
            BoardInitialize b = new BoardInitialize(Length, width);
            b.gameBoard = (user[,])this.gameBoard.Clone();
            return b;
        }
        public user Winner(int iLength, int iWidth)
        {
            int count = 0;

            for (int x = 0; x < iLength; x++)
            {
                count = 0;
                for (int y = 0; y < iLength; y++)
                    count += (int)gameBoard[x, y];
                if (count == iLength)
                    return user.X;
                if (count == -iWidth)
                    return user.O;
            }


            for (int x = 0; x < iWidth; x++)
            {
                count = 0;

                for (int y = 0; y < iWidth; y++)
                    count += (int)gameBoard[y, x];

                if (count == iWidth)
                    return user.X;
                if (count == -iWidth)
                    return user.O;
            }


            count = 0;
            for (int i = 0; i < iLength; i++)
            {
                for (int j = 0; j < iWidth; j++)
                {
                    if (i == j)
                        count += (int)gameBoard[i, j];
                }
            }
            if (count == iWidth)
                return user.X;
            if (count == -iWidth)
                return user.O;


            count = 0;
            for (int i = 0; i < iLength; i++)
            {
                for (int j = 0; j < iWidth; j++)
                {
                    if (i + j + 1 == iWidth)
                        count += (int)gameBoard[i, j];
                }
            }
            if (count == iWidth)
                return user.X;
            if (count == -iWidth)
                return user.O;
            return user.space;
        }

    }
}
