public class Square implements Comparable<Square>{
  //has 3 fields: x coordinate, y coordinate, number of possible moves
  private int r, c, moves;
  public Square(int row, int col, int rows, int cols){
    r = row;
    c = col;
    moves = 0; //dummy
    this.findMoves(rows, cols);
  }

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

  public void findMoves(int rows, int cols){
    if (inRange(r+2, c+1, rows, cols)){
      addMove(); //increase number of moves from Squares[r][c]
    }
    if (inRange(r+2, c-1, rows, cols)){
      addMove();
    }
    if (inRange(r-2, c+1, rows, cols)){
      addMove();
    }
    if (inRange(r-2, c-1, rows, cols)){
      addMove();
    }
    if (inRange(r+1, c+2, rows, cols)){
      addMove();
    }
    if (inRange(r+1, c-2, rows, cols)){
      addMove();
    }
    if (inRange(r-1, c+2, rows, cols)){
      addMove();
    }
    if (inRange(r-1, c-2, rows, cols)){
      addMove();
    }
  }

  //return a new square translated r units up and c units right
  public Square translate(int r, int c){
    return new Square(this.r+r, this.c+c);
  }

  //same as above but square as parameter
  public Square translate(Square s){
    return new Square(this.r+s.r, this.c+s.c);
  }

  public boolean inRange(int r, int c, int rows, int cols){
    return (r>=0&&c>=0&&r<rows&&c<cols);
  }
}
