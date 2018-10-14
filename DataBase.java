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
      int count = 0;

      //adds user to users ArrayList
      while(reader.hasNextLine()) {
        username = reader.next();
        password = reader.next();
        users.add(new User(username, password));

        //adds account to users accounts LinkedList
        while(reader.hasNextInt()) {
          accountType = reader.nextInt();
          accountNum = reader.nextInt();
          routingNum = reader.nextInt();
          balance = reader.nextDouble();
          if(accountType == 0){
            users.get(count).addAccount(new SavingsAccount(accountNum, routingNum, balance));
          }
          else {
            users.get(count).addAccount(new CheckingsAccount(accountNum, routingNum, balance));
          }
        }
        count++;
      }
      reader.close();
    }

}
