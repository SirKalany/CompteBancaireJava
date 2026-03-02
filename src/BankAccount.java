import java.util.ArrayList;

public class BankAccount {

    private double balance;
    private ArrayList<String> history = new ArrayList<String>();

    public BankAccount(double initialBalance) throws IllegalArgumentException {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Le solde initial ne peut pas être négatif.");
        }
        this.balance = initialBalance;
        history.add("Solde initial : " + initialBalance + "€");
    }

    // "throws IllegalArgumentException" : signale que cette méthode peut lancer cette exception
    public void deposit(double amount) throws IllegalArgumentException {
        if (amount <= 0) {
            // throw : on lance l'exception, la méthode s'arrête immédiatement
            throw new IllegalArgumentException("Le montant doit être positif.");
        }
        this.balance += amount;
        history.add("Dépôt : +" + amount + "€  →  Solde : " + this.balance + "€");
    }

    // Cette méthode peut lancer DEUX types d'exceptions différents
    public void withdraw(double amount) throws IllegalArgumentException, InsufficientFundsException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Le montant doit être positif.");
        }
        if (amount > this.balance) {
            // On lance notre exception personnalisée
            throw new InsufficientFundsException(amount);
        }
        this.balance -= amount;
        history.add("Retrait : -" + amount + "€  →  Solde : " + this.balance + "€");
    }

    public double getBalance() {
        return this.balance;
    }

    public void printHistory() {
        System.out.println("\n===== HISTORIQUE =====");
        if (history.isEmpty()) {
            System.out.println("Aucune transaction.");
            return;
        }
        for (String transaction : history) {
            System.out.println("- " + transaction);
        }
        System.out.println("======================");
    }
}