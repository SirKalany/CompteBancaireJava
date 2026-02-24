public class BankAccount {

    // Champ privé : uniquement accessible via les méthodes de cette classe
    private double balance;

    // Constructeur : appelé quand on fait "new BankAccount(1000)"
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Déposer de l'argent
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Erreur : le montant doit être positif.");
            return;
        }
        this.balance += amount;
        System.out.println("Dépôt de " + amount + "€ effectué.");
    }

    // Retirer de l'argent
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Erreur : le montant doit être positif.");
            return false;
        }
        if (amount > this.balance) {
            System.out.println("Erreur : fonds insuffisants.");
            return false;
        }
        this.balance -= amount;
        System.out.println("Retrait de " + amount + "€ effectué.");
        return true;
    }

    // Getter : retourner le solde
    public double getBalance() {
        return this.balance;
    }
}