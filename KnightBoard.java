public class KnightBoard{
  //KnightBoard has 3 public methods and a constructor, a private helper is needed as well.
  //Fields
  //private boardSquares = Square[][];
  private board = int[][];

  //@throws IllegalArgumentException when either parameter is negative.
  public KnightBoard(int startingRows,int startingCols){
    //boardSquares = new Square[startingRows][startingCols];
    board = new int[startingRows][startingCols];
  }

    //Initialize the board to the correct size and make them all 0's

public String toString(){
  String output = "";
  for (int i = 0; i < board.length; i++){
    for (int j = 0; j < board.length; j++){
      if (board[i][j]>= 10){
        output+= board[i][j];
      }
      else{
        output+= ' '+board[i][j];
      }
      if (j!= board.length - 1){
        output+=" ";
      }
    }
    output += "\n";
  }
  return output;
}
  /*
  see format for toString below
  blank boards display 0's as underscores
  you get a blank board if you never called solve or
  when there is no solution
  */

  /*Use the following format for toString:

  (THESE ARE NOT VALID SOLUTIONS, They JUST TO DEMONSTRATE FORMAT)

  Single spaces between numbers, but leading spaces on single digit numbers:
   1  2  5
   3  4  6
   7  8  9

  Which is equivalant to: " 1  2  5\n 3  4  6\n 7  8  9\n"

  When there are two digit numbers (rows*cols >= 10) Put a leading space in front of single digit numbers:
  (spaces replaced with _ to show the difference)
  _1 _2 15 _6
  _3 _4 _7 11
  _8 _9 10 12
  13 14 _5 16

  So it looks like this:
   1  2 15  6
   3  4  7 11
   8  9 10 12
  13 14  5 16

  *I will not be testing boards that have a rows*cols that is >= 100, as the program would take a long time to complete.
  */

  /**
  *@throws IllegalStateException when the board contains non-zero values.
  *@throws IllegalArgumentException when either parameter is negative or out of bounds.
 */
public boolean solve(int startingRow, int startingCol){

}

  /**
  *@throws IllegalStateException when the board contains non-zero values.
  *@throws IllegalArgumentException when either parameter is negative or out of bounds.
  */
public int countSolutions(int startingRow, int startingCol){

}

//Suggestion:
private boolean solveH(int row ,int col, int level){

}
// level is the # of the knight

}
