using System.Collections.Generic;
using System;
using Assignment4;

namespace Assignment4
{
    public class AI
    {
        public static Board.Blank GetBestMove(BoardInitialize gb, Board.user p, int length,int width)
        {
            Board.Blank? bestSpace = null;
            List<Board.Blank> openSpaces = gb.blankPlaces(length, width);
            BoardInitialize newBoard;
            for (int i = 0; i < openSpaces.Count; i++)
            {
                newBoard = gb.Clone(length, width);
                Board.Blank newSpace = openSpaces[i];

                newBoard[newSpace.A, newSpace.B] = p;

                if (newBoard.Winner(length, width) == Board.user.space && newBoard.blankPlaces(length, width).Count > 0)
                {
                    Board.Blank tempMove = GetBestMove(newBoard, (Board.user)(-(int)p), length,width);  
                    newSpace.Rank = tempMove.Rank;
                }
                else
                {
                    if (newBoard.Winner(length, width) == Board.user.space)
                        newSpace.Rank = 0;
                    else if (newBoard.Winner(length, width) == Board.user.X)
                        newSpace.Rank = -1;
                    else if (newBoard.Winner(length, width) == Board.user.O)
                        newSpace.Rank = 1;
                }

                if (bestSpace == null ||
                   (p == Board.user.X && newSpace.Rank < ((Board.Blank)bestSpace).Rank) ||
                   (p == Board.user.O && newSpace.Rank > ((Board.Blank)bestSpace).Rank))
                {
                    bestSpace = newSpace;
                }
            }

            return (Board.Blank)bestSpace;
        }
    }
}