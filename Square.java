public class Square implements Comparable<Square>{
  //has 3 fields: x coordinate, y coordinate, number of possible moves
  private int r, c, moves;
  public Square(int row, int col){
    r = row;
    c = col;
    moves = 0; //dummy
  }

  //compares moves of this to other Square
  public int compareTo(Square other) {
		return moves - other.moves;
	}

  //Getters
  public int getRow(){
    return r;
  }

  public int getCol(){
    return c;
  }

  public int getMoves(){
    return moves;
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
    return new Square(this.r+r, this.c+c);
  }

  //same as above but square as parameter
  public Square translate(Square s){
    return new Square(this.r+s.r, this.c+s.c);
  }
}
