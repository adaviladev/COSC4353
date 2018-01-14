using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;
using Assignment4;

namespace Assignment4
{
    class mainModule
    {
        static int turn;
        static BoardInitialize gb;
        static int Level;
        static void Main(string[] args)
        {
            Console.WriteLine("Welcome to Tic-Tac-Toe!");
            boardLoad();
        }
        private static void boardLoad()
        {
            turn += 1;
            int Length = 0;
            string input = "";
            do
            {
                Console.WriteLine("Enter the level of the game");
                Console.WriteLine("1. easy, 2. medium, 3. hard");
                input = Console.ReadLine().Trim();
                Level = Convert.ToInt32(input);
                if (!(Level >= 1 && Level <= 3))
                   Console.WriteLine("Wrong input!Enter only between 1 to 3");
            } while (!( (Level >= 1 && Level <= 3)));
            Console.WriteLine("Please enter the board size:");
            input = Console.ReadLine().Trim();
            Length = Convert.ToInt32(input);
            Console.WriteLine("User is X and Computer is O");
            gb = new BoardInitialize(Length, Length);
            if (turn % 2 == 1)
            {
                dispBoard(Length);
                NextMove(Length);
                Console.ReadLine();
            }
            else
            {
                if (Level == 1)
                {
                    easyLevel(Length);
                    
                }
                else if (Level == 2)
                {
                    mediumLevel(Length);
                    
                }
                else
                {
                    hardLevel(Length);
                }

            }
            
            
        }

        /**
         * Print out current state of the board
         */
        private static void dispBoard(int size)
        {
            int counter = 0;
            for (int i = 0; i < size; i++)
            {
                if (counter == 0)
                {
                    Console.Write(" ");
                    for (int j = 1; j <= size; j++)
                        Console.Write(" " + j);
                    counter++;
                }
                Console.Write("\n" + (i + 1));
                for (int j = 0; j < size; j++)
                {
                    if (gb[i, j].ToString() == "space")
                    {
                        Console.Write("|");
                        Console.Write("_");
                    }
                    else
                    {
                        Console.Write("|" + gb[i, j].ToString());
                    }
                    if (j == size - 1)
                    {
                        Console.WriteLine("|");
                    }
                }
            }
        }

        /**
         * Prompt user for their next move
         */
        private static void NextMove(int size)
        {
            int x = 0, y = 0;
            string input = "";
            Board.Blank b = new Board.Blank();
            do
            {
                Console.WriteLine("What is your move?");

                /**
                 * Error handling for when user selects a row or column that is out of bounds
                 */
                do
                {
                    Console.WriteLine("Please type a row number from 1 to " + size);
                    input = Console.ReadLine().Trim();
                    x = Convert.ToInt32(input) - 1;
                    Console.WriteLine("Please type a column number from 1 to " + size);
                    input = Console.ReadLine().Trim();
                    y = Convert.ToInt32(input) - 1;
                    if (!(x >= 0 && x < size))
                    {
                        Console.WriteLine("Wrong input, please enter row between 1 to " + size);
                    }
                    if (!(y >= 0 && y < size))
                    {
                        Console.WriteLine("Wrong input, please enter column between 1 to " + size);
                    }

                } while (!((x >= 0 && x < size) && (y >= 0 && y < size)));
                b.A = x;
                b.B = y;
                
                if (gb.isFull(x, y))
                {
                    Console.WriteLine("Place is already occupied.");
                }
            } while (gb.isFull(x, y));
            gb[b.A, b.B] = Board.user.O;
            /**
             * Display the board with corrected user inputs and choose AI move based on selected difficulty
             */
            dispBoard(size);
            if(Level==1)
            {
                easyLevel(size);
                //break;
            }
            else if(Level==2)
            {
                mediumLevel(size);
               // break;
            }
            else
            {
                hardLevel(size);
            }

            /**
             * Game is finished.
             * Prompt to restart
             */
            input = "";
            do
            {
                Console.WriteLine("Want to continue the game(Y/N)");
                input = Console.ReadLine().ToLower();
                if (input != "y" && input != "n")
                {
                    Console.WriteLine("Invalid input, please enter y/n");
                }
                else if (input == "y")
                {
                    Console.Clear();
                    boardLoad();
                }
                else
                {
                    Console.WriteLine("Thank you for playing Tic-Tac-Toe.");
                    Thread.Sleep(800);
                    Environment.Exit(0);
                }
            } while (input != "y" && input != "n");
        }
        private static void easyLevel(int size)
        {
            Board.Blank b = new Board.Blank();
            if (!isWin(size))
            {
                Console.WriteLine("Computer is making the move...");
                if (gb.blankPlaces(size,size).Count == gb.Size(size)) //if all spaces are open, randomly pick one for excitement
                {
                    Random r = new Random();
                    b = new Board.Blank(r.Next(0, size), r.Next(0, size));
                }
                else
                {
                    Random r = new Random();
                    do
                    {
                        b = new Board.Blank(r.Next(0, size), r.Next(0, size));
                    } while (gb.isFull(b.A, b.B));
                }
                gb[b.A, b.B] = Board.user.X;
                dispBoard(size);
                if (!isWin(size))
                    NextMove(size);
            }
        }

        /**
         * Pick next winning move if it exists
         * Otherwise, pick a random move.
         */
        private static void mediumLevel(int size)
        {
            Board.Blank b = new Board.Blank();
            if (!isWin(size))
            {
                Console.WriteLine("Computer is making the move...");
                if (gb.blankPlaces(size,size).Count == gb.Size(size)) //if all spaces are open, randomly pick one for excitement
                {
                    Random r = new Random();
                    b = new Board.Blank(r.Next(0, size), r.Next(0, size));
                }
                else
                {
                    b = gb.get_BestMove(size,size);
                }
                gb[b.A, b.B] = Board.user.X;
                dispBoard(size);
                if (!isWin(size))
                    NextMove(size);
            }
        }

        /**
         * 
         */
        private static void hardLevel(int size)
        {
            Board.Blank b = new Board.Blank();
            if (!isWin(size))
            {
                Console.WriteLine("Computer is making the move...");
                if (gb.blankPlaces(size,size).Count == gb.Size(size))
                { 
                    Random r = new Random();
                    b = new Board.Blank(r.Next(0, size), r.Next(0, size));
                }
                else
                {
                    b = AI.GetBestMove(gb, Board.user.X, size, size);
                }
                gb[b.A, b.B] = Board.user.X;
                dispBoard(size);
                /**
                 * Check win conditions to stop the game or continue to the next move
                 */
                if (!isWin(size))
                    NextMove(size);
            }
        }
        public static bool isWin(int size)
        {
           // gb = new Win();
            Board.user? p = gb.Winner(size, size);

            if (p == Board.user.X)
            {
                Console.WriteLine("Sorry! Computer wins!");
                return true;
            }
            else if (p == Board.user.O)
            {
                Console.WriteLine("Congratulations! You win!");
                return true;
            }
            else if (gb.isTaken)
            {
                Console.WriteLine("Draw");
                return true;
            }
            return false;
        }
        
        }
  }
