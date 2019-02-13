public class Square{
  //has 3 fields: x coordinate, y coordinate, number of possible moves
  private int x, y, moves;
  public Square(int xcor, int ycor, int numMoves){
    x = xcor;
    y = ycor;
    moves = numMoves;
  }
  //Getters
  public int getXcor(){
    return x;
  }

  public int getYcor(){
    return y;
  }

  public int getMoves(){
    return moves;
  }
}
