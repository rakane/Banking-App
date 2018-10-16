/**
 * File: BankAccount.java
 * @author: Ryan Kane
 * @email: rakane@syr.edu
 **/

import java.util.Random;

public class BankAccount {

  Random gen = new Random();
  protected int accountNumber;
  protected int routingNumber;
  protected double accountBalance;
  private String type;

  /**
  *  Constructs a valid BankAccount
  *  postcondition
  *  A valid BankAccount has been initialized
  **/
  public BankAccount(){
    accountNumber = (int)(1000000 + gen.nextDouble() * 9000000);
    routingNumber = (int)(1000000 + gen.nextDouble() * 9000000);
    accountBalance = 0;
  }

  /**
  *  Constructs a valid BankAccount
  *  @param accountNum
  *   the 7 digit account number
  *  @param routingNum
  *   the 7 digit routing number
  *  @param accountBal
  *   the account balance
  *  postcondition
  *   A valid BankAccount has been initialized
  **/
  public BankAccount(int accountNum, int routingNum, double accountBal){
    accountNumber = accountNum;
    routingNumber = routingNum;
    accountBalance = accountBal;
  }

  /**
  *  @return the account number
  **/
  public int getAccountNumber() {
    return accountNumber;
  }

  /**
  *  @return the routing number
  **/
  public int getRoutingNumber() {
    return routingNumber;
  }

  /**
  *  @return the current account balance
  **/
  public double getAccountBalance() {
    return accountBalance;
  }

  /**
  *  @return the account type
  **/
  public String getType() {
    return type;
  }

  /**
  *  @param amount
  *   the amount to be deposited
  *  @return true if successfully deposited
  **/
  public boolean deposit(double amount) {
    if(amount <= 0) {
      System.out.println("Cannot deposit negative amount");
      return false;
    }
    else{
      accountBalance += amount;
      System.out.println("Your account balance is now $" + accountBalance);
      return true;
    }
  }

  /**
  *  @param amount
  *   the amount to be withdrawn
  *  @return true if successfully withdrawn
  **/
  public boolean withdraw(double amount){
    if(amount > accountBalance){
      System.out.println("Cannot withdraw more than account balance");
      return false;
    }
    else{
      accountBalance -= amount;
      System.out.println("Your account balance is now $" + accountBalance);
      return true;
    }
  }

}
