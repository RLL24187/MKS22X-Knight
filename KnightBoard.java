public class KnightBoard{
  //KnightBoard has 3 public methods and a constructor, a private helper is needed as well.
  //Fields
  private Square[][] boardSquares;
  private int[][] board;
  private int rows;
  private int cols;

  //@throws IllegalArgumentException when either parameter is negative.
  public KnightBoard(int startingRows,int startingCols){
    boardSquares = new Square[startingRows][startingCols];
    for (int i = 0; i < startingRows; i++){
      for (int j = 0; j < startingCols; j++){
        boardSquares[i][j] = new Square(i, j, 0);
      }
    }
    board = new int[startingRows][startingCols];
    rows = startingRows;
    cols = startingCols;
  }

    //Initialize the board to the correct size and make them all 0's

/**
*-you get a blank board if you never called solve or when there is no solution
*-blank boards display 0's as underscores
*@return the properly formatted string (see format for toString later in the post)
*/
public String toString(){
  String output = "";
  for (int i = 0; i < rows; i++){
    for (int j = 0; j < cols; j++){
      if (board[i][j]>= 10){
        output+= board[i][j];
      }
      else if (allZero()){
        output += " _";
      }
      else{
        output += " "+board[i][j];
      }
      if (j!= cols - 1){
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

  //Checks to see if all spaces are 0s
  private boolean allZero(){
    for (int i = 0; i < rows; i++){
      for (int j = 0; j < cols; j++){
        if (board[i][j]!=0){
          return false;
        }
      }
    }
    return true;
  }

  /**
  *@throws IllegalStateException when the board contains non-zero values.
  *@throws IllegalArgumentException when either parameter is negative or out of bounds.
  Modifies the board by labeling the moves from 1 (at startingRow,startingCol) up to the area of the board in proper knight move steps.
  @return true when the board is solvable from the specified starting position
 */
public boolean solve(int startingRow, int startingCol){
  if (!allZero()){
    throw new IllegalStateException("solve(int startingRow, int startingCol) only works on blank boards!");
  }
  if (startingRow < 0 || startingCol <0 || startingRow >= rows || startingCol >= cols){
    throw new IllegalArgumentException("Both parameters must be nonnegative and in the range!");
  }
  return solveH(startingRow, startingCol, 1);
}

  /**
  *@throws IllegalStateException when the board contains non-zero values.
  *@throws IllegalArgumentException when either parameter is negative or out of bounds.
  *@return number of solutions when either parameter is negative
  */
public int countSolutions(int startingRow, int startingCol){
  if (!allZero()){
    throw new IllegalStateException("solve(int startingRow, int startingCol) only works on blank boards!");
  }
  if (startingRow < 0 || startingCol <0 || startingRow >= rows || startingCol >= cols){
    throw new IllegalArgumentException("Both parameters must be nonnegative and in the range!");
  }
  return countH(startingRow, startingCol, 1, 0);
}

public int countAllSolutions(){
  if (rows == 0 || cols == 0){
    return 1;
  }
  int count = 0;
  for (int i = 0; i < rows; i++){
    for (int j = 0; j < cols; j++){
      revert();
      count += countSolutions(i, j);
    }
  }
  return count;
}

private boolean addKnight(int r, int c, int level){ //add a knight
  //level goes into the int[][] board
  //reduce the possible moves in boardSquares (later)
  if (r < 0 || c < 0 || r>=rows || c>= cols){ //avoid out of bounds and negatives
    return false;
  }
  if (board[r][c]==0){ //if no knight added here
    board[r][c]=level; //set num equal to level
    return true;
  }
  return false;
}

private boolean removeKnight(int r, int c){ //remove a knight
  if (r < 0 || c < 0 || r>=rows || c>= cols){ //avoid out of bounds and negatives
    return false;
  }
  if (board[r][c]!= 0){
    board[r][c]=0;
    return true;
  }
  return false;
}

//Suggestion:
//row is starting xcor
//col is starting ycor
//level is the number to place in the box
private boolean solveH(int row ,int col, int level){
  //Base case:
  if (level == rows * cols && addKnight(row, col, level)){ //if you've placed down all knights
    return true; //return true
  }
  if (addKnight(row, col, level)){ //can you add the knight?
    //expanded to debug
    if (solveH(row + 1, col + 2, level + 1)){
      return true;
    }
    if (solveH(row + 2, col + 1, level + 1)){
      return true;
    }
    if (solveH(row - 1, col + 2, level + 1)){
      return true;
    }
    if (solveH(row - 2, col + 1, level + 1)){
      return true;
    }
    if (solveH(row + 1, col - 2, level + 1)){
      return true;
    }
    if (solveH(row + 2, col - 1, level + 1)){
      return true;
    }
    if (solveH(row - 1, col - 2, level + 1)){
      return true;
    }
    if (solveH(row - 2, col - 1, level + 1)){
      return true;
    }
    removeKnight(row, col); //otherwise remove it again
  }
  return false;
}
// level is the # of the knight

public int countH(int row, int col, int level, int sum){
  //Base case:
  if (level == rows * cols && addKnight(row, col, level)){ //if you've placed down all knights
    sum++;
  }
  for (int r = -2; r <= 2; r++){
    if (r==0) r++;
    if (addKnight(row, col, level)){
      if (r % 2 == 1){
        countH(row+r, col + 2, level + 1, sum);
        removeKnight(row+r, col+2);
        countH(row+r, col - 2, level + 1, sum);
        removeKnight(row+r, col-2);
      }
      else{
        countH(row+r, col + 1, level + 1, sum);
        removeKnight(row+r, col + 1);
        countH(row+r, col - 1, level + 1, sum);
        removeKnight(row+r, col - 1);
      }
    }
    removeKnight(row, col);
  }
  //if (addKnight(row, col, level)){ //can you add the knight?
    //expanded to debug
    /*
    count+=countH(row+2, col+1, level + 1);
    count+=countH(row+2, col-1, level + 1);
    count+=countH(row+1, col+2, level + 1);
    count+=countH(row+1, col-2, level + 1);
    count+=countH(row-1, col+2, level + 1);
    count+=countH(row-1, col-2, level + 1);
    count+=countH(row-2, col+1, level + 1);
    count+=countH(row-2, col-1, level + 1);
    */
  //}
  //removeKnight(row, col);
  return sum;
}

public void revert(){ //returns board to 0 everywhere
  for (int i = 0; i < rows; i++){
    for (int j = 0; j < cols; j++){
      board[i][j] = 0;
    }
  }
}
}
