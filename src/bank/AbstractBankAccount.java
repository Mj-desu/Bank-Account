package bank;

public abstract class AbstractBankAccount implements BankAccount {
    /**
     * Variable for balance of the account.
     */
    private double balance;
    /**
     * Variable to check if account is frozen.
     */
    private boolean isFrozen;

    /**
     * Constructor for AbstractBankAccount.
     */
    public AbstractBankAccount() {
        this.balance = 0;
        this.isFrozen = false;
    }

    /**
     * Deposit amount to bank account.
     * @param amount
     * @throws Exception
     */
    public void deposit(final double amount) {
        try {
            if (isFrozen) {
                System.out.println("Account is frozen. Cannot deposit.");
                return;
            }
            if (amount <= 0) {
                throw new IllegalArgumentException(
                        "The deposit amount must be positive.");
            }
            this.balance += amount;
            System.out.printf("Deposited: Php %.2f\n", amount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Withdraw amount from bank account.
     * @param amount
     */
    public void withdraw(final double amount) {
        try {
            if (isFrozen) {
                System.out.println("Account is frozen. Cannot withdraw.");
                return;
            }
            if (amount > balance) {
                throw new IllegalArgumentException("Insufficient balance.");
            }
            if (amount < 0) {
                throw new IllegalArgumentException(
                        "The withdrawn amount must be positive.");
            }
            this.balance -= amount;
            System.out.printf("Withdrawn: Php %.2f\n", amount);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Return the balance of the account.
     * @return balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Returns true if account is frozen.
     * @return isFrozen
     */
    public boolean isFrozen() {
        return isFrozen;
    }

    /**
     * Sets account to frozen.
     */
    public void freezeAccount() {
        this.isFrozen = true;
        System.out.println("Account has been frozen.");
    }

    /**
     * Sets account to not frozen.
     */
    public void unfreezeAccount() {
        this.isFrozen = false;
        System.out.println("Account has been unfrozen.");
    }

}
