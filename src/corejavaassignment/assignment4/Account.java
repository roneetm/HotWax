package corejavaassignment.assignment4;

public class Account extends Thread {
    private String name;
    public Double balance;

    Account(Double balance) {
        this.balance = balance;
    }

    public Double getBalance() {
        return balance;
    }

    synchronized void safeWithdraw(double withdrawAmount) {
        if (withdrawAmount <= getBalance()) {
            System.out.println("Balance Before " + Thread.currentThread().getName()+ " withdrawal " +getBalance());
            balance = getBalance() - withdrawAmount;
            System.out.println(Thread.currentThread().getName() + " has Withdrawn " + withdrawAmount + " Remaining Balance " + getBalance());
        } else {
            System.out.println("Balance Empty for "+ Thread.currentThread().getName());
        }
    }

    public void unsafeWithdraw(double withdrawAmount) {
        if (withdrawAmount <= getBalance()) {
            System.out.println("Balance Before " + Thread.currentThread().getName() + " withdrawal " +getBalance());
            balance = getBalance() - withdrawAmount;
            System.out.println(Thread.currentThread().getName() + " has Withdrawn " + withdrawAmount + " Remaining Balance " + getBalance());
        } else {
            System.out.println("Balance Empty for "+ Thread.currentThread().getName());
        }

    }
}
