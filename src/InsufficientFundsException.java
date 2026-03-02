// On crée notre propre type d'exception personnalisée
// "extends Exception" : elle hérite de la classe Exception de Java
public class InsufficientFundsException extends Exception {

    private double amount; // le montant qui a causé le problème

    public InsufficientFundsException(double amount) {
        // super() appelle le constructeur de la classe parente (Exception)
        // et lui passe le message d'erreur
        super("Fonds insuffisants pour retirer " + amount + "€");
        this.amount = amount;
    }

    // Getter pour récupérer le montant si besoin
    public double getAmount() {
        return amount;
    }
}