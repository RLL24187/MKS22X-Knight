public class Driver{
  public static void main(String[] args){
    KnightBoard k2x4 = new KnightBoard(2, 4);
    KnightBoard k6x6 = new KnightBoard(6, 6);
    KnightBoard k5x5 = new KnightBoard(5, 5);
    KnightBoard k7x7 = new KnightBoard(7, 7);
    KnightBoard k6x8 = new KnightBoard(6, 8);
    System.out.println("-----------Testing KnightBoard constructor-----------\n");
    System.out.println("-----------Testing toString-----------\n");
    System.out.println("k5x5: \n");
    System.out.println(k5x5.toString());


    System.out.println("-----------Testing solve() exceptions-----------\n");
    System.out.println("k5x5(5, 0) --> IllegalArgumentException\n");
    try{
      k5x5.solve(5,0);
    }
    catch (IllegalArgumentException e){ //out of bounds
      System.out.println(e);
    }
    System.out.println("k5x5(-1, 2) --> IllegalArgumentException\n");
    try{
      k5x5.solve(-1,2);
    }
    catch (IllegalArgumentException e){ //negative
      System.out.println(e);
    }

    System.out.println("-----------Testing solve()-----------");
    System.out.println(k5x5.solve(0,0));
    System.out.println(k5x5.toString());
    k5x5.revert();

    System.out.println(k5x5.solve(3, 1));
    System.out.println(k5x5.toString());
    k5x5.revert();

    System.out.println(k6x6.solve(4, 3));
    System.out.println(k6x6.toString());
    k6x6.revert();

    System.out.println(k2x4.solve(0, 2));
    System.out.println(k2x4.toString());
    k2x4.revert();

    System.out.println(k7x7.solve(5, 3));
    System.out.println(k7x7.toString());
    k7x7.revert();


    System.out.println(k6x8.solve(2, 7));
    System.out.println(k6x8.toString());
    k5x5.revert();
  }
}
