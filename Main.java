import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) throws FileNotFoundException {
    Scanner sc = new Scanner(System.in);
    DataBase db = new DataBase();

    System.out.print("Enter username: ");
    String usrname = sc.next();
    System.out.print("Enter password: ");
    String pass = sc.next();

    while(!(db.verifyLogin(usrname, pass))) {
      System.out.println("Username/Password Invalid");
      System.out.print("Enter username: ");
      usrname = sc.next();
      System.out.print("Enter password: ");
      pass = sc.next();
    }
    User user = db.getUser(usrname);
    db.setDataBase(homeMenu(db, user));


    db.updateDataBase();
    sc.close();
  }


  public static ArrayList<User> homeMenu (DataBase d, User u) {
    Scanner sc = new Scanner(System.in);
    int input;
    ArrayList<User> usr;
    u.printAccounts();

    System.out.println("Enter 1 to deposit\t\t\tEnter 2 to withdraw");
    System.out.println("Enter 3 to add account\t\t\tEnter 4 to delete account");
    input = sc.nextInt();
    while(input > 4 || input < 1) {
      System.out.print("Input invalid, try again: ");
      input = sc.nextInt();
    }

    switch(input) {
      case 1: usr = depositMenu(d, u, sc);
              sc.close();
              return usr;
      case 2: usr = withdrawMenu(d, u, sc);
              sc.close();
              return usr;
      case 3: usr = addAccountMenu(d, u, sc);
              sc.close();
              return usr;
      case 4: usr = deleteAccountMenu(d, u, sc);
              sc.close();
              return usr;
      default: usr = depositMenu(d, u, sc);
               sc.close();
               return usr;
    }
  }

  public static ArrayList<User> depositMenu(DataBase d, User u, Scanner s) {
    String input1;
    double input2;
    System.out.print("Enter Checking or Saving to deposit into respective account: ");
    input1 = s.next();
    System.out.print("Enter amount to deposit: ");
    input2 = s.nextDouble();

    for(int i = 0; i < d.getUsers().size(); i++){
      if(d.getUsers().get(i).getUserName().equalsIgnoreCase(u.getUserName())) {
        for(int j = 0; j < d.getUsers().get(i).getAccounts().size(); j++) {
          if(d.getUsers().get(i).getAccounts().get(j).getType().equals(input1)) {
            while(d.getUsers().get(i).getAccounts().get(j).deposit(input2) == false) {
              System.out.print("Enter amount to deposit: ");
              input2 = s.nextDouble();
            }
          }
        }
      }
    }
    s.close();
    return d.getUsers();
  }

  public static ArrayList<User> withdrawMenu(DataBase d, User u, Scanner s) {
    String input1;
    double input2;
    System.out.print("Enter Checking or Saving to withdraw from respective account: ");
    input1 = s.next();
    System.out.print("Enter amount to withdraw: ");
    input2 = s.nextDouble();

    for(int i = 0; i < d.getUsers().size(); i++){
      if(d.getUsers().get(i).getUserName().equalsIgnoreCase(u.getUserName())) {
        for(int j = 0; j < d.getUsers().get(i).getAccounts().size(); j++) {
          if(d.getUsers().get(i).getAccounts().get(j).getType().equals(input1)) {
            while(d.getUsers().get(i).getAccounts().get(j).withdraw(input2) == false) {
              System.out.print("Enter amount to withdraw: ");
              input2 = s.nextDouble();
            }
          }
        }
      }
    }
    s.close();
    return d.getUsers();
  }

  public static ArrayList<User> addAccountMenu(DataBase d, User u, Scanner s) {
    String input1;
    System.out.print("Enter Checking or Saving to add respective account: ");
    input1 = s.next();

    for(int i = 0; i < d.getUsers().size(); i++){
      if(d.getUsers().get(i).getUserName().equalsIgnoreCase(u.getUserName())) {
        for(int j = 0; j < d.getUsers().get(i).getAccounts().size(); j++) {
          if(d.getUsers().get(i).getAccounts().get(j).getType().equals(input1)) {
            System.out.println("Already have " + input1 + " account");
            return d.getUsers();
          }
        }
        if(input1.equals("Checking")) {
          d.getUsers().get(i).addAccount(new CheckingsAccount());
        }
        else {
          d.getUsers().get(i).addAccount(new SavingsAccount());
        }
      }
    }

    s.close();
    return d.getUsers();
  }

  public static ArrayList<User> deleteAccountMenu(DataBase d, User u, Scanner s) {
    String input1;
    String input2;
    System.out.print("Enter Checking or Saving to delete respective account: ");
    input1 = s.next();
    System.out.print("Enter account number to confirm: ");
    input2 = s.next();

    s.close();
    return d.getUsers();
  }


}
