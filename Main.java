package project1;

import java.util.Scanner;
public class Main {
	
	public static void main(String[] args) {
        User u1 = new User(456, 4586, "mohamed mef", "mohamed01.mefteh@gmail.com", "4569mmk");
        Admin a1 = new Admin(456789628, 1287, "mohamed bn ali", "mohamed@gmail.com", "123", 69);
        a1.ajouter_user(u1);
        a1.ajouter_operation(new Operation("deposer"));
        a1.ajouter_operation(new Operation("retirer"));
        a1.ajouter_operation(new Operation("transfer argent (mandat)"));
        a1.ajouter_operation(new Operation("faire un fond"));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== SYSTÈME BANCAIRE ===");
            System.out.println("1. Login Utilisateur");
            System.out.println("2. Login Admin");
            System.out.println("3. Quitter");
            System.out.print("Votre choix: ");
            int a = scanner.nextInt();
            

            switch (a) {
                case 1: // User login
                    System.out.print("Email: ");
                    String email = scanner.next();
                    System.out.print("Password: ");
                    String password = scanner.next();

                    User loggedInUser = null;
                    for (User user : a1.getComptes()) {
                        if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                            loggedInUser = user;
                            break;
                        }
                    }

                    if (loggedInUser != null) {
                        userMenu(loggedInUser, scanner);
                    } else {
                        System.out.println("Identifiants incorrects.");
                    }
                    break;

                case 2: // Admin login
                    System.out.print("Email: ");
                    String adminEmail = scanner.next();
                    System.out.print("Password: ");
                    String adminPassword = scanner.next();

                    if (a1.getEmail().equals(adminEmail) && a1.getPassword().equals(adminPassword)) {
                        adminMenu(a1, scanner);
                    } else {
                        System.out.println("Identifiants incorrects.");
                    }
                    break;

                case 3: // Quit
                    System.out.println("Au revoir!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Choix invalide. Essayez de nouveau.");
            }
        }
    }
    private static void userMenu(User user, Scanner scanner) {
        while (true) {
            System.out.println("\n=== MENU UTILISATEUR ===");
            System.out.println("1. Voir informations du compte");
            System.out.println("2. Voir solde");
            System.out.println("3. Faire un dépôt");
            System.out.println("4. Faire un retrait");
            System.out.println("5. Faire un transfert d'argent");
            System.out.println("6. Faire un fond");
            System.out.println("7. Modifier informations personnelles");
            System.out.println("8. Déconnexion");
            System.out.print("Votre choix: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n=== INFORMATIONS DU COMPTE ===");
                    System.out.println("Nom: " + user.getNom());
                    System.out.println("Email: " + user.getEmail());
                    System.out.printf("Solde: %.2f€%n", user.getCompte().getSolde());
                    break;

                case 2:
                    System.out.printf("Solde actuel: %.2f€%n", user.getCompte().getSolde());
                    break;

                case 3: // Deposit
                    System.out.print("Montant à ajouter: ");
                    double depositAmount = scanner.nextDouble();
                    if (depositAmount > 0) {
                        user.getCompte().setSolde(user.getCompte().getSolde() + depositAmount);
                        System.out.println("Dépôt de " + depositAmount + "€ effectué.");
                    } else {
                        System.out.println("Le montant doit être positif.");
                    }
                    break;

                case 4: // Withdrawal
                    System.out.print("Montant à retirer: ");
                    double withdrawalAmount = scanner.nextDouble();
                    if (withdrawalAmount > 0 && withdrawalAmount <= user.getCompte().getSolde()) {
                        user.getCompte().setSolde(user.getCompte().getSolde() - withdrawalAmount);
                        System.out.println("Retrait de " + withdrawalAmount + "€ effectué.");
                    } else {
                        System.out.println("Montant invalide ou solde insuffisant.");
                    }
                    break;

                case 5: // Transfer
                    System.out.print("Montant à transférer: ");
                    double transferAmount = scanner.nextDouble();
                    if (transferAmount > 0 && transferAmount <= user.getCompte().getSolde()) {
                        System.out.print("Entrer le RIB du destinataire: ");
                        double recipientRib = scanner.nextDouble();
                        // Here you would normally check if the recipient exists in your user list
                        // For simplicity, we'll just assume the recipient is valid
                        user.getCompte().setSolde(user.getCompte().getSolde() - transferAmount);
                        System.out.println("Transfert de " + transferAmount + "€ à " + recipientRib + " effectué.");
                    } else {
                        System.out.println("Montant invalide ou solde insuffisant.");
                    }
                    break;

                case 6: // Fund Management (example placeholder)
                    System.out.print("Montant à investir: ");
                    double fundAmount = scanner.nextDouble();
                    if (fundAmount > 0) {
                        System.out.println("Investissement de " + fundAmount + "€ effectué.");
                        // Here you could implement actual fund management logic
                    } else {
                        System.out.println("Le montant doit être positif.");
                    }
                    break;

                case 7: // Update Personal Information
                    System.out.print("Nouvelle adresse email: ");
                    String newEmail = scanner.next();
                    System.out.print("Nouveau nom: ");
                    String newNom = scanner.next();
                    user.setEmail(newEmail);
                    user.setNom(newNom);
                    System.out.println("Informations personnelles mises à jour.");
                    break;

                case 8: // Logout
                    System.out.println("Déconnexion...");
                    return;

                default:
                    System.out.println("Choix invalide. Veuillez essayer de nouveau.");
            }
        }
    }

    private static void adminMenu(Admin admin, Scanner scanner) {
        while (true) {
            System.out.println("\n=== MENU ADMIN ===");
            System.out.println("1. Afficher tous les utilisateurs");
            System.out.println("2. Afficher toutes les opérations");
            System.out.println("3. Ajouter un utilisateur");
            System.out.println("4. Supprimer un utilisateur");
            System.out.println("5. Ajouter une opération");
            System.out.println("6. Supprimer une opération");
            System.out.println("7. Déconnexion");
            System.out.print("Votre choix: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: 
                    admin.afficher_comptes();
                    break;

                case 2: 
                    admin.afficher_operations();
                    break;

                case 3: 
                    System.out.print("RIB: ");
                    double rib = scanner.nextDouble();
                    System.out.print("Code: ");
                    int code = scanner.nextInt();
                    System.out.print("Nom: ");
                    String nom = scanner.next();
                    System.out.print("Email: ");
                    String email = scanner.next();
                    System.out.print("Password: ");
                    String password = scanner.next();
                    
                    User newUser = new User(rib, code, nom, email, password);
                    admin.ajouter_user(newUser);
                    System.out.println("Utilisateur ajouté avec succès!");
                    break;

                case 4: 
                    System.out.print("Entrer le RIB du compte à supprimer: ");
                    double ribToRemove = scanner.nextDouble();
                    admin.supprimer_user(ribToRemove);
                    break;

                case 5: 
                    System.out.print("Entrer le nom de l'opération à ajouter: ");
                    String nomOperation = scanner.next();
                    Operation newOperation = new Operation(nomOperation);
                    admin.ajouter_operation(newOperation);
                    System.out.println("Opération ajoutée avec succès!");
                    break;

                case 6: 
                    System.out.print("Entrer le nom de l'opération à supprimer: ");
                    String operation = scanner.next();
                    admin.supprimer_operation(operation);
                    break;

                case 7:
                    System.out.println("Déconnexion...");
                    return;

                default:
                    System.out.println("Choix invalide. Veuillez essayer de nouveau.");
            }
        }
    }
}

