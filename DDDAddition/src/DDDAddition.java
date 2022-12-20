import domain.repository.UserRepository;
import domain.service.AdditionService;
import infrastructure.UserRepositoryImpl;
import java.util.Scanner;

public class DDDAddition {
  public static void main(String[] args) {
    System.out.println("'username 1 2'のように入力すると、username.csvに'1,2,3'(1つ目の値,2つ目の値,足し算結果)と出力します");
    System.out.println("'q'を入力すると終了します");
    
    Scanner sc = new Scanner(System.in);
    while(sc.hasNextLine()) {
      String[] lineArgs = sc.nextLine().split(" ");
      execute(lineArgs);
    }
  }
  
  private static void execute(String[] args) {
    if(args[0].equals("q")) {
      System.out.println("終了します");
      System.exit(0);
    }
    
    if(args.length != 3) {
      System.out.println("引数を3つ指定してください");
      System.exit(1);
    }
    
    String username = args[0];
    int num1 = 0;
    int num2 = 0;
    try {
      num1 = Integer.parseInt(args[1]);
      num2 = Integer.parseInt(args[2]);
    }catch(NumberFormatException e) {
      System.out.println("整数を指定してください");
      System.exit(1);
    }
    
    UserRepository userRepository = new UserRepositoryImpl();
    AdditionService service = new AdditionService(userRepository);
    int result = 0;
    try {
      result = service.execute(username, num1, num2);
    }catch(Exception e) {
      System.out.println("足し算サービスでエラーが発生しました");
      e.printStackTrace();
      System.exit(1);
    }
    
    System.out.printf("%s + %s = %s%n", num1, num2, result);
  }
}
