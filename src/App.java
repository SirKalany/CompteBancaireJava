import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount(1000);
        boolean running = true;

        while (running) {
            System.out.println("\n===== MON COMPTE BANCAIRE =====");
            System.out.println("Solde actuel : " + account.getBalance() + "€");
            System.out.println("1. Déposer de l'argent");
            System.out.println("2. Retirer de l'argent");
            System.out.println("3. Voir l'historique");
            System.out.println("4. Quitter");
            System.out.print("Votre choix : ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Montant à déposer : ");
                    double depositAmount = scanner.nextDouble();
                    try {
                        account.deposit(depositAmount);
                        System.out.println("Dépôt effectué !");
                    } catch (IllegalArgumentException e) {
                        // e.getMessage() retourne le message qu'on a mis dans le throw
                        System.out.println("Erreur : " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Montant à retirer : ");
                    double withdrawAmount = scanner.nextDouble();
                    try {
                        account.withdraw(withdrawAmount);
                        System.out.println("Retrait effectué !");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erreur : " + e.getMessage());
                    } catch (InsufficientFundsException e) {
                        // On peut avoir plusieurs catch pour gérer chaque exception différemment
                        System.out.println("Erreur : " + e.getMessage());
                        System.out.println("Votre solde : " + account.getBalance() + "€");
                    }
                    break;

                case 3:
                    account.printHistory();
                    break;

                case 4:
                    System.out.println("Au revoir !");
                    running = false;
                    break;

                default:
                    System.out.println("Choix invalide.");
            }
        }

        scanner.close();
    }
}