package project1;

import java.util.ArrayList;
import java.util.List;
public class Admin extends User {
	 private int num_badge;
	    private List<Operation> operations = new ArrayList<>();
	    private List<User> users = new ArrayList<>();

	    public Admin(int rib, int code, String nom, String email, String password, int num_badge) {
	        super(rib,code,nom,email,password);
	        this.num_badge = num_badge;
	    }
	    // Getters
	    public int getNum_badge() {
	        return num_badge;
	    }

	    public List<Operation> getOperations() {
	        return operations;
	    }

	    public List<User> getComptes() {
	        return users;
	    }

	    // Setters
	    public void setNum_badge(int num_badge) {
	        this.num_badge = num_badge;
	    }

	    // Method to add account
	    public void ajouter_user(User user) {
	        users.add(user);
	        System.out.println("done!");
	    }
	    
	    public void supprimer_user(double ribcompte) {
	        int initialSize = users.size();
	        users.removeIf(cpt -> this.getCompte().getRib()== ribcompte);
	        
	        if (initialSize == users.size()) {
	            System.out.println("compte n'existe pas");
	        } else {
	            System.out.println("done!");
	        }
	    }

	    // Methode pour ajouter une operation
	    public void ajouter_operation(Operation operation) {
	        operations.add(operation);
	        System.out.println("done!");
	    }
	    // Methode pour supprimer une operation
	    public void supprimer_operation(String nom_operation) {
	        int initialSize = operations.size();
	        operations.removeIf(opr -> opr.get_nom_operation().equals(nom_operation));
	        
	        if (initialSize == operations.size()) {
	            System.out.println("operation n'existe pas");
	        } else {
	            System.out.println("done!");
	        }
	    }

	    // Methode pour afficher tous les comptes
	    public void afficher_comptes() {
	        if (users.isEmpty()) {
	            System.out.println("Aucun compte trouvé");
	            return;
	        }
	        
	        for (User compte : users) {
	            System.out.println("email:"+compte.getEmail()+
	                             " RIB: " + this.getCompte().getRib()+ 
	                             ", Solde: " +this.getCompte().getSolde());
	        }
	    }

	    // Methode pour afficher tous les operations
	    public void afficher_operations() {
	        if (operations.isEmpty()) {
	            System.out.println("Aucune opération trouvée");
	            return;
	        }
	        
	        for (Operation operation : operations) {
	            System.out.println("Opération: " + operation.get_nom_operation());
	        }
	    }
}
