import java.util.ArrayList;

public class BankAccount {

    private double balance;

    // ArrayList : fonctionne comme un tableau mais de taille dynamique
    // Elle grandit automatiquement à chaque transaction ajoutée
    private ArrayList<String> history = new ArrayList<String>();

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
        history.add("Solde initial : " + initialBalance + "€");
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Erreur : le montant doit être positif.");
            return;
        }
        this.balance += amount;
        history.add("Dépôt : +" + amount + "€  →  Solde : " + this.balance + "€");
        System.out.println("Dépôt de " + amount + "€ effectué.");
    }

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
        history.add("Retrait : -" + amount + "€  →  Solde : " + this.balance + "€");
        System.out.println("Retrait de " + amount + "€ effectué.");
        return true;
    }

    public double getBalance() {
        return this.balance;
    }

    // Nouvelle méthode : afficher l'historique
    public void printHistory() {
        System.out.println("\n===== HISTORIQUE =====");

        if (history.isEmpty()) {
            System.out.println("Aucune transaction.");
            return;
        }

        // Boucle for-each : parcourt chaque élément de l'ArrayList
        // "transaction" prend la valeur de chaque String une par une
        for (String transaction : history) {
            System.out.println("- " + transaction);
        }

        System.out.println("======================");
    }
}