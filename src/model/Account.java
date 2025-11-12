package model;

public class Account {
    private String site;
    private String username;
    private String encryptedPassword;

    public Account(String site, String username, String encryptedPassword) {
        this.site = site;
        this.username = username;
        this.encryptedPassword = encryptedPassword;
    }

    public String getSite() {
        return site;
    }
    
    public String getUsername() {
        return username;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    @Override
    public String toString() {
        return "Site: " + site + ", Username: " + username;
    }
}
