import java.io.File;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class DataBase {

  File inputFile = new File("sample-database.txt");
  ArrayList<User> users = new ArrayList<User>();
  String username;
  String password;
  String accountType;
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

      accountType = reader.next();
      accountNum = reader.nextInt();
      routingNum = reader.nextInt();
      balance = reader.nextDouble();
      reader.nextLine();

      if(accountType.equals("Checking")) {
        users.get(users.size() - 1).addAccount(new CheckingsAccount(accountNum, routingNum, balance));
      }
      else {
        users.get(users.size() - 1).addAccount(new SavingsAccount(accountNum, routingNum, balance));
      }
    }
    reader.close();
  }

  public void setDataBase(ArrayList<User> u) {
    users = u;
  }
  public ArrayList<User> getUsers() {
    return users;
  }

  public void printDataBase() {
    for(int i = 0; i < users.size(); i++) {
      System.out.println(users.get(i).getUserName());
      users.get(i).printAccounts();
    }
  }

  public void updateDataBase() throws FileNotFoundException {
    PrintWriter pw = new PrintWriter(new FileOutputStream("tempdatabase.txt", false));

    for(int i = 0; i < users.size(); i++) {
      for(int j = 0; j < users.get(i).getAccounts().size(); j++) {
        pw.print(users.get(i).getUserName() + "\t\t"
          + users.get(i).getPassword() + "\t\t");
        if(users.get(i).getAccounts().get(j).getType().equals("Checking")) {
          pw.println(users.get(i).getAccounts().get(j).getType() + "\t\t"
            + users.get(i).getAccounts().get(j).getAccountNumber() + "\t\t"
            + users.get(i).getAccounts().get(j).getRoutingNumber() + "\t\t"
            + users.get(i).getAccounts().get(j).getAccountBalance());
        }
        else{
          pw.println(users.get(i).getAccounts().get(j).getType() + "\t\t\t"
            + users.get(i).getAccounts().get(j).getAccountNumber() + "\t\t"
            + users.get(i).getAccounts().get(j).getRoutingNumber() + "\t\t"
            + users.get(i).getAccounts().get(j).getAccountBalance());
        }
      }
    }
    pw.close();
  }

  public boolean verifyLogin(String user, String pass) {
    for(int i = 0; i < users.size(); i++) {
      if(users.get(i).getUserName().equalsIgnoreCase(user)
      & users.get(i).getPassword().equals(pass)) {
        return true;
      }
    }
    return false;
  }

  public User getUser(String name) {
    for(int i = 0; i < users.size(); i++) {
      if(name.equalsIgnoreCase(users.get(i).getUserName())) {
        return users.get(i);
      }
    }
    return null;
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
