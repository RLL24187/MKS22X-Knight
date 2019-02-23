public class Driver{
  public static void main(String[] args){
    //wonky ones
    KnightBoard k2x4 = new KnightBoard(2, 4);
    KnightBoard k3x4 = new KnightBoard(3, 4);
    KnightBoard k3x5 = new KnightBoard(3, 5);
    KnightBoard k6x8 = new KnightBoard(6, 8);

    //perfect squares
    KnightBoard k1x1 = new KnightBoard(1, 1);
    KnightBoard k2x2 = new KnightBoard(2, 2);
    KnightBoard k3x3 = new KnightBoard(3, 3);
    KnightBoard k4x4 = new KnightBoard(4, 4);
    KnightBoard k5x5 = new KnightBoard(5, 5);
    KnightBoard k6x6 = new KnightBoard(6, 6);
    KnightBoard k7x7 = new KnightBoard(7, 7);
    KnightBoard k8x8 = new KnightBoard(8, 8);
    KnightBoard k9x9 = new KnightBoard(9, 9);
    KnightBoard k10x10 = new KnightBoard(10, 10);


    System.out.println("-----------Testing KnightBoard constructor-----------\n");
    /*System.out.println("-----------Testing toString-----------\n");
    System.out.println("k5x5: \n");
    System.out.println(k5x5.toString());


    System.out.println("-----------Testing addKnight(int row, int col, int level)-----------\n");
    System.out.println("k5x5(0, 0, 5)--> true: "+k5x5.addKnight(0,0,5));
    System.out.println(k5x5.toString());

    System.out.println("k5x5(0, 0, 5)--> false: "+k5x5.addKnight(0,0,5));
    System.out.println(k5x5.toString());

    System.out.println("k5x5(4, 3, 2)--> true: "+k5x5.addKnight(4,3,2));
    System.out.println(k5x5.toString());

    System.out.println("k5x5(6, 0, 0)--> false: "+k5x5.addKnight(6,0,0));
    System.out.println(k5x5.toString());

    System.out.println("k5x5(0, -1, 4)--> false: "+k5x5.addKnight(0,-1,4));
    System.out.println(k5x5.toString());

    System.out.println("-----------Testing removeKnight(int row, int col)-----------\n");
    System.out.println("k5x5(0,0)--> true: "+k5x5.removeKnight(0,0));
    System.out.println(k5x5.toString());

    System.out.println("k5x5(0,0)--> false: "+k5x5.removeKnight(0,0));
    System.out.println(k5x5.toString());

    System.out.println("k5x5(4, 3, 2)--> true: "+k5x5.removeKnight(4,3));
    System.out.println(k5x5.toString());

    System.out.println("k5x5(6, 0, 0)--> false: "+k5x5.removeKnight(6,0));
    System.out.println(k5x5.toString());

    System.out.println("k5x5(0, -1, 4)--> false: "+k5x5.removeKnight(0,-1));
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
    System.out.println("Testing k5x5(0,0): \n");
    System.out.println(k5x5.solve(0,0));
    System.out.println(k5x5.toString());
    k5x5.revert();

    System.out.println("Testing k5x5(3,1): \n");
    System.out.println(k5x5.solve(3, 1));
    System.out.println(k5x5.toString());
    k5x5.revert();

    System.out.println("Testing k6x6(4,3): \n");
    System.out.println(k6x6.solve(4, 3));
    System.out.println(k6x6.toString());
    k6x6.revert();

    System.out.println("Testing k2x4(0,2): \n");
    System.out.println(k2x4.solve(0, 2));
    System.out.println(k2x4.toString());
    k2x4.revert();

    System.out.println("Testing k4x4(1,1): \n");
    System.out.println(k4x4.solve(1, 1));
    System.out.println(k4x4.toString());
    k4x4.revert();

    System.out.println("Testing k4x4(0,1): \n");
    System.out.println(k4x4.solve(0, 1));
    System.out.println(k4x4.toString());
    k4x4.revert();

    System.out.println("Testing k4x4(0,0): \n");
    System.out.println(k4x4.solve(0, 0));
    System.out.println(k4x4.toString());
    k4x4.revert();

    System.out.println("Testing k7x7(0,0): \n");
    System.out.println(k7x7.solve(0, 0));
    System.out.println(k7x7.toString());
    k7x7.revert();

    System.out.println("Testing k7x7(5,3): \n");
    System.out.println(k7x7.solve(5, 3));
    System.out.println(k7x7.toString());
    k7x7.revert();

    System.out.println("Testing k6x8(2,2): \n");
    System.out.println(k6x8.solve(2, 2));
    System.out.println(k6x8.toString());
    k5x5.revert();
    */

    System.out.println("\n----------Testing countSolutions(int startingRow, int startinCol)----------\n");

    System.out.println("Testing k1x1(0,0): \n");
    System.out.println(k1x1.countSolutions(0, 0));
    System.out.println(k1x1.toString());
    k1x1.revert();

    System.out.println("Testing k2x2(0,0): \n");
    System.out.println(k2x2.countSolutions(0, 0));
    System.out.println(k2x2.toString());
    k2x2.revert();

    System.out.println("Testing k3x3(0,0): \n");
    System.out.println(k3x3.countSolutions(0, 0));
    System.out.println(k3x3.toString());
    k3x3.revert();

    System.out.println("Testing k4x4(0,0): \n");
    System.out.println(k4x4.countSolutions(0, 0));
    System.out.println(k4x4.toString());
    k4x4.revert();

    System.out.println("Testing k3x4(0,0): \n");
    System.out.println(k3x4.countSolutions(0, 0));
    System.out.println(k3x4.toString());
    k3x4.revert();

    System.out.println("Testing k3x5(0,0): \n");
    System.out.println(k3x5.countSolutions(0, 0));
    System.out.println(k3x5.toString());
    k3x5.revert();
    //System.out.println("Testing k5x5(0,0): \n");
    //System.out.println(k5x5.countSolutions(0, 0)); //got 304
    //System.out.println(k5x5.toString());
    //k5x5.revert();

    //k3x4.revert();
    //System.out.println("\n----------Testing countAllSolutions()----------\n");
    //System.out.println("k3x4: should be 8: " + k3x4.countAllSolutions());
  }
}
