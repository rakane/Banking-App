import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class DataBase {

  File inputFile = new File("database.txt");
  File outputFile = new File("tempdatabase.txt");
  ArrayList<User> users = new ArrayList<User>();
  String username;
  String password;
  int accountType;
  int accountNum;
  int routingNum;
  double balance;

  public DataBase() throws FileNotFoundException {
    Scanner reader = new Scanner(inputFile);

    while(reader.hasNextLine()) {
      boolean alreadyExists = true;
      username = reader.next();
      password = reader.next();

      if(alreadyExists(users, username)) {
        users.add(new User(username, password));
      }

      accountType = reader.nextInt();
      accountNum = reader.nextInt();
      routingNum = reader.nextInt();
      balance = reader.nextDouble();
      reader.nextLine();

      if(accountType == 0) {
        users.get(users.size() - 1).addAccount(new CheckingsAccount(accountNum, routingNum, balance));
      }
      else {
        users.get(users.size() - 1).addAccount(new SavingsAccount(accountNum, routingNum, balance));
      }
    }

    reader.close();
  }

  public void printDataBase() {
    for(int i = 0; i < users.size(); i++) {
      System.out.println(users.get(i).getUserName());
      users.get(i).printAccounts();
    }
  }

  public static boolean alreadyExists(ArrayList<User> db, String name) {
    boolean exists = true;

    for(int i = 0; i < db.size(); i++) {
      if(db.get(i).getUserName().equals(name)) {
        exists = false;
      }
    }
    return exists;
  }


}
