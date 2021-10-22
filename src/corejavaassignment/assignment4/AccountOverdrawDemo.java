package corejavaassignment.assignment4;

import java.util.InputMismatchException;
import java.util.Scanner;

class ThreadUnsafe implements Runnable{
    Account account = new Account(1000.00);
    public void run(){
            account.unsafeWithdraw(1000);
            if(account.balance < 0){
                System.out.println("Account Empty");
        }
    }
}

class ThreadSafe implements Runnable{
    Account account = new Account(1000.00);

    public void run(){
        account.safeWithdraw(1000);
        if(account.balance < 0){
            System.out.println("Account Empty");
        }
    }
}

public class AccountOverdrawDemo {

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

            while (true){
                ThreadUnsafe threadUnsafe = new ThreadUnsafe();
                Thread thread1 = new Thread(threadUnsafe, "Roneet");
                Thread thread2 = new Thread(threadUnsafe, "Michae");

                ThreadSafe threadSafe = new ThreadSafe();
                Thread thread3 = new Thread(threadSafe, "Roneet");
                Thread thread4 = new Thread(threadSafe, "Michae");

                System.out.println("1. Thread Safe Mode Demo");
                System.out.println("2. Thread Unsafe Mode Demo");
                System.out.println("3. Exit");
                System.out.print("Enter your choice ");

                try {
                    int choice = scanner.nextInt();

                    switch (choice){

                        case 1:
                            thread3.start();
                            thread4.start();
                            break;
                        case 2:
                            thread1.start();
                            thread2.start();
                            break;

                        case 3: System.exit(0);
                        default:
                            System.out.println("Please enter a valid choice");
                    }
                Thread.sleep(3000);
            }   catch (InputMismatchException inputMismatchException){
                    System.out.println("Invalid Choice. Please try again...");
                }
            finally {
                System.exit(0);
            }
        }
    }
}

