import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner sc = new Scanner(System.in);
    DataBase db = new DataBase();

    login(db);
    //go to menu

    db.updateDataBase();
  }

  public static void login(DataBase d) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter username: ");
    String usr = sc.next();
    System.out.print("Enter password: ");
    String pass = sc.next();

    while(!(d.verifyLogin(usr, pass))) {
      System.out.println("Username/Password Invalid");
      System.out.print("Enter username: ");
      usr = sc.next();
      System.out.print("Enter password: ");
      pass = sc.next();
    }
  }
}
