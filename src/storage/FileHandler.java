package storage;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

import util.Encryption;
import model.Account;

public class FileHandler {
    private static final String FILE = "passwords.enc";

    public static void saveAccount(Account account) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE, true))) {
            String encryptedPassword = Encryption.encrypt(account.getEncryptedPassword());
            writer.write(account.getSite() + "|" + account.getUsername() + "|" + encryptedPassword);
            writer.newLine();
        } catch (Exception e) {
            System.err.println("Error saving account: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static List<Account> loadAccounts() {
        List<Account> accounts = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 3) {
                    String decryptedPassword = Encryption.decrypt(parts[2]);
                    accounts.add(new Account(parts[0], parts[1], decryptedPassword));
                }
            }
        } catch (FileNotFoundException e) {
            
        } catch (Exception e) {
            System.err.println("Error loading accounts: " + e.getMessage());
            e.printStackTrace();
        }
        return accounts;
    }
}
