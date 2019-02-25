public class Square implements Comparable<Square>{
  //has 3 fields: x coordinate, y coordinate, number of possible moves
  private int x, y, moves;
  public Square(int xcor, int ycor){
    x = xcor;
    y = ycor;
    moves = 0; //dummy
  }

  //compares moves of this to other Square
  public int compareTo(Square other) {
		return moves - other.moves;
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

  public void setMoves(int newMoves){
    moves = newMoves;
  }

  public void addMove(){
    moves++;
  }

  public void subMove(){
    moves--;
  }

  //return a new square translated r units up and c units right
  public Square translate(int r, int c){
    return new Square(x+r, y+c);
  }
}
