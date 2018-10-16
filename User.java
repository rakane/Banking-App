import java.util.ArrayList;

public class User {
  private String username;
  private String password;
  private ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();

  public User(String usr, String pass) {
    username = usr;
    password = pass;
  }

  public String getUserName() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public ArrayList<BankAccount> getAccounts() {
    return accounts;
  }

  public void addAccount(BankAccount act) {
    accounts.add(act);
  }

  public void printAccounts() {
    System.out.println("\t\t\tAccounts\n\t\t\t-------");
    for(int i = 0; i < accounts.size(); i++) {
      if(accounts.get(i).getType().equals("Checking")){
        System.out.println("Checking:\tAccount Number: " + accounts.get(i).getAccountNumber() +
        "\t\tBalance: " + accounts.get(i).getAccountBalance());
      }
      else{
        System.out.println("Savings:\tAccount Number: " + accounts.get(i).getAccountNumber() +
        "\t\tBalance: " + accounts.get(i).getAccountBalance());
      }
      System.out.println();
    }
  }
}
