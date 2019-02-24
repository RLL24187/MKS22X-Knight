public class Square{
  //has 3 fields: x coordinate, y coordinate, number of possible moves
  private int x, y;
  public Square(int xcor, int ycor){
    x = xcor;
    y = ycor;
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

  //Setters
  public void setXcor(int xcor){
    x = xcor;
  }

  public void setYcor(int ycor){
    y = ycor;
  }

  public void setCoors(int xcor, int ycor){
    x = xcor;
    y = ycor;
  }
/*
  public void setMoves(int newMoves){
    moves = newMoves;
  }

  public void addMove(){
    moves++;
  }

  public void subMove(){
    moves--;
  }*/
}
