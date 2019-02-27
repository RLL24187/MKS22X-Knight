import java.util.*;
public class KnightBoard{
  //Fields
  private int[][] increments = {
    { 2,  1},
    { 2, -1},
    { 1,  2},
    { 1, -2},
    {-1,  2},
    {-1, -2},
    {-2,  1},
    {-2, -1}
  };
  //list of squares to move to (relative locations for translation)

  private int[][] board;
  //board is the displayed order
  private Square[][] squares;
  //board of Squares
  private int rows;
  private int cols;

  //@throws IllegalArgumentException when either parameter is negative.
  public KnightBoard(int startingRows,int startingCols){
    if (startingRows <= 0 || startingCols <= 0) throw new IllegalArgumentException();
    board = new int[startingRows][startingCols];
    squares = new Square[startingRows][startingCols];
    rows = startingRows;
    cols = startingCols;
    //Make the number of moves for each Square
    for (int r = 0; r < rows; r++){
      for (int c = 0; c < cols; c++){
        squares[r][c]=new Square(r, c, rows, cols); //constructs square and finds number of moves
      }
    }
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

  public String toStringMoves(){
    String output = "";
    for (int i = 0; i < rows; i++){
      for (int j = 0; j < cols; j++){
        output+=squares[i][j].getMoves();
        if (j!=cols-1){
          output+=" ";
        }
      }
      output += "\n";
    }
    return output;
  }

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
    //board[startingRow][startingCol]=1;
    //boolean b = solveH(startingRow, startingCol, 2);
    //if (!b) revert(); //if you can't solve it, revert to allzero state
    //System.out.println(toString());
    //return b;
    board[startingRow][startingCol]=1;
    boolean b = solveH(startingRow, startingCol, 2);
    System.out.println(toString());
    if (!b) revert(); //if you can't solve it, revert to allzero state
    return b;
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
    int n = countH(startingRow, startingCol, 1);
    revert();
    return n;
  }

  //not actually mandatory just felt curious :P
  //counts up all solutions from all positions on the board
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
    if (!inRange(r,c)){ //avoid out of bounds and negatives
      return false;
    }
    if (board[r][c]==0){ //if no knight added here
      board[r][c]=level; //set num equal to level
      for (int s = 0; s < increments.length; s++){
        //for each square in the set of moves, reduce the number of moves by 1
        //check if in range first
        //Square x = squareMoves[s].translate(r, c);
        //x.findMoves(rows, cols);
        int tempR = increments[s][0] + r;
        int tempC = increments[s][1] + c;
        if (inRange(tempR, tempC)){//check if the row and col are valid
          squares[tempR][tempC].subMove(); //decrease number of moves
        }
      }
      return true;
    }
    return false;
  }

  private boolean removeKnight(int r, int c){ //remove a knight
    if (!inRange(r,c)){ //avoid out of bounds and negatives
      return false;
    }
    if (board[r][c]!= 0){
      board[r][c]=0;
      for (int s = 0; s < increments.length; s++){
        //for each square in the set of moves, increase the number of moves by 1
        //check if in range first
        //Square x = squareMoves[s].translate(r, c);
        int tempR = increments[s][0] + r;
        int tempC = increments[s][1] + c;
        if (inRange(tempR, tempC)){//check if the row and col are valid
          squares[tempR][tempC].addMove(); //add number of moves
        }
      }
      return true;
    }
    return false;
  }

  //Suggestion:
  //row is starting xcor
  //col is starting ycor
  //level is the number to place in the box
  private boolean solveH(int row, int col, int level){
    //
    //Base case:
    if (level == rows * cols && addKnight(row, col, level)){ //if you've placed down all knights
      return true; //return true
    }

    ArrayList<Square> possibilities = new ArrayList<Square>(8);
    //actual list of Squares to move to

    addKnight(row, col, level);

		for (int s = 0; s < increments.length; s++){
      int tempR = row+increments[s][0];
      int tempC = col+increments[s][1];
      if (inRange(tempR, tempC)){
        Square newSquare = squares[tempR][tempC];// squares[row][col].translate(squareMoves[s]); //to be added to possibilities
        if (board[tempR][tempC] == 0){ //if it is in the board and can be added
          possibilities.add(newSquare);
        }
      }
		}
		Collections.sort(possibilities); //sort by moves
    for (int s = 0; s < possibilities.size(); s++){ //loop through each possibile Square
      //addKnight(possibilities.get(s).getRow(),possibilities.get(s).getCol(),level);
      if (solveH(possibilities.get(s).getRow(),possibilities.get(s).getCol(), level+1)){ //recursive part
        return true;
      }
      removeKnight(possibilities.get(s).getRow(),possibilities.get(s).getCol()); //remove if false
    }
    return false;

    /*
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
  return false;*/
  }
  // level is the # of the knight

  public int countH(int row, int col, int level){
    //Base case:
    //System.out.println(toString());
    if (level == rows * cols && addKnight(row, col, level)){ //if you've placed down all knights
      //sum++;
      //System.out.println("Got one!");
      //System.out.println(toString());
      return 1;
    }
    int count = 0;
    if (addKnight(row, col, level)){ //can you add the knight?
      //expanded to debug
      //System.out.println("Case 1\n");
      count+=countH(row+2, col+1, level + 1);
      if (inRange(row + 2, col + 1))
        if(board[row+2][col+1] == level + 1)
          removeKnight(row + 2, col + 1);

      //System.out.println("Case 2\n");
      count+=countH(row+2, col-1, level + 1);
      if (inRange(row + 2, col - 1))
        if(board[row+2][col-1] == level + 1)
          removeKnight(row + 2, col - 1);

      //System.out.println("Case 3\n");
      count+=countH(row+1, col+2, level + 1);
      if (inRange(row + 1, col + 2))
        if(board[row+1][col+2] == level + 1)
          removeKnight(row + 1, col + 2);

      //System.out.println("Case 4\n");
      count+=countH(row+1, col-2, level + 1);
      if (inRange(row + 1, col - 2))
        if(board[row+1][col-2] == level + 1)
          removeKnight(row + 1, col - 2);

      //System.out.println("Case 5\n");
      count+=countH(row-1, col+2, level + 1);
      if (inRange(row - 1, col + 2))
        if(board[row-1][col+2] == level + 1)
          removeKnight(row - 1, col + 2);

      //System.out.println("Case 6\n");
      count+=countH(row-1, col-2, level + 1);
      if (inRange(row - 1, col - 2))
        if(board[row-1][col-2] == level + 1)
          removeKnight(row - 1, col - 2);

      //System.out.println("Case 7\n");
      count+=countH(row-2, col+1, level + 1);
      if (inRange(row - 2, col + 1))
        if(board[row-2][col+1] == level + 1)
          removeKnight(row - 2, col + 1);

      //System.out.println("Case 8\n");
      count+=countH(row-2, col-1, level + 1);
      if (inRange(row - 2, col - 1))
        if(board[row-2][col-1] == level + 1)
          removeKnight(row - 2, col - 1);
    }
    //System.out.println("Removing ("+row+","+col+")\n");
    return count;
  }

  public boolean inRange(int r, int c){ //checks if the row and col are in range
    return (r < rows && r >= 0 && c < cols && c>= 0);
  }

  public boolean inRange(Square s){ //checks if square s is in the range
    return (s.getCol() < cols && s.getCol() >=0 && s.getRow() < rows && s.getRow() >= 0); //x cols: y rows
  }

  public void revert(){ //returns board to 0 everywhere
    for (int i = 0; i < rows; i++){
      for (int j = 0; j < cols; j++){
        board[i][j] = 0;
      }
    }
  }
}
