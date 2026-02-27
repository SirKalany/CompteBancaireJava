import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); // pour lire les saisies de l'utilisateur
        BankAccount account = new BankAccount(1000); // solde initial 1000€

        boolean running = true;

        while (running) {
            // Affichage du menu
            System.out.println("\n===== MON COMPTE BANCAIRE =====");
            System.out.println("Solde actuel : " + account.getBalance() + "€");
            System.out.println("1. Déposer de l'argent");
            System.out.println("2. Retirer de l'argent");
            System.out.println("3. Quitter");
            System.out.println("4. Voir l'historique");
            System.out.print("Votre choix : ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Montant à déposer : ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 2:
                    System.out.print("Montant à retirer : ");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 3:
                    System.out.println("Au revoir !");
                    running = false;
                    break;

                case 4:
                    account.printHistory();
                    break;

                default:
                    System.out.println("Choix invalide, réessayez.");
            }
        }

        scanner.close(); // bonne pratique : fermer le scanner quand on en a plus besoin
    }
}