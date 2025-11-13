import java.util.List;
import java.util.Scanner;
import model.Account;
import storage.FileHandler;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n -----Password Manager-----");
            System.out.println("Choose from the following options:");
            System.out.println("1. Add Account;");
            System.out.println("2. View Accounts");
            System.out.println("3. Exit");

            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.println("Enter site name: ");
                    String site = scanner.nextLine();
                    System.out.println("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.println("Enter password: ");
                    String password = scanner.nextLine();
                    Account account = new Account(site, username, password);
                    FileHandler.saveAccount(account);
                    System.out.println("Account saved successfully!");
                    break;
                case "2":
                    List<Account> accounts = FileHandler.loadAccounts();
                    if (accounts.isEmpty()) {
                        System.out.println("No accounts found.");
                    } else {
                        System.out.println("Saved accounts: ");
                        for (Account acc : accounts) {
                            System.out.println(acc);
                        }
                    }
                    break;
                case "3":
                    running = false;
                    System.out.println("Exiting Password Manager.");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }
}
