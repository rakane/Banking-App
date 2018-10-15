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
    for(int i = 0; i < accounts.size(); i++) {
      System.out.println(accounts.get(i).getAccountNumber() + " " +
        accounts.get(i).getAccountBalance());
    }
  }
}
