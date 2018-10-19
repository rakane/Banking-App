/**
 * File: User.java
 * @author: Ryan Kane
 * @email: rakane@syr.edu
 **/

import java.util.ArrayList;

public class User {
  
  private String username;
  private String password;
  private ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();

  /**
  *  Constructs a valid User
  *  @param usr
  *   the username
  *  @param pass
  *   the password
  *  postcondition
  *   A valid User has been initialized
  **/
  public User(String usr, String pass) {
    username = usr;
    password = pass;
  }

  /**
  *  @return the username
  **/
  public String getUserName() {
    return username;
  }

  /**
  *  @return the password
  **/
  public String getPassword() {
    return password;
  }

  /**
  *  @return the users accounts
  **/
  public ArrayList<BankAccount> getAccounts() {
    return accounts;
  }

  /**
  *  Adds BankAccount to user accounts
  *  @param act
  *   the account to be added
  *  postcondition
  *   The account has been added
  **/
  public void addAccount(BankAccount act) {
    accounts.add(act);
  }

  /**
  *  Prints user accounts
  **/
  public void printAccounts() {
    System.out.println("\t\t\tAccounts\n\t\t\t-------");
    for(int i = 0; i < accounts.size(); i++) {
      if(accounts.get(i).getType().equals("Checking")){
        System.out.println("Checking:\tAccount Number: " + accounts.get(i).getAccountNumber() +
        "\t\tBalance: " + accounts.get(i).getAccountBalance());
      }
      else {
        System.out.println("Savings:\tAccount Number: " + accounts.get(i).getAccountNumber() +
        "\t\tBalance: " + accounts.get(i).getAccountBalance());
      }
      System.out.println();
    }
  }

}
