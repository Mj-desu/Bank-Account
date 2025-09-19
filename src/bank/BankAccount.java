package bank;

public interface BankAccount {
  /**
   * Deposit amount to bank account.
   * @param amount
   * @throws Exception
   */
  void deposit(double amount) throws Exception;
  /**
   * Withdraw amount from bank account.
   * @param amount
   */
  void withdraw(double amount);
  /**
   * Return the balance of the account.
   * @return balance
   */
  double getBalance();
  /**
   * Returns true if account is frozen.
   * @return isFrozen
   */
  boolean isFrozen();
}

