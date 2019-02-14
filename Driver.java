public class Driver{
  public static void main(String[] args){
    KnightBoard k5x5 = new KnightBoard(5,5);
    System.out.println("-----------Testing KnightBoard constructor-----------\n");
    System.out.println("-----------Testing toString-----------\n");
    System.out.println("k5x5: \n");
    System.out.println(k5x5.toString());


    System.out.println("-----------Testing solve() exceptions-----------\n");
    System.out.println("k5x5(5, 0) --> IllegalArgumentException\n");
    try{
      k5x5(5,0)
    }
    catch (IllegalArgumentException e){
      System.out.println(e);
    }
  }
}
