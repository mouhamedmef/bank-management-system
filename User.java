package project1;

public class User {
	 private String nom;
	    private String email;
	    private String password;
	    private Compte compte;

	    public User(double rib, int code, String nom, String email, String password) { 
	        this.compte=new Compte(rib,code);
	        this.nom = nom;
	        this.email = email;
	        this.password = password;
	    }

	    // Getters
	    public String getNom() {
	        return nom;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public String getPassword() {
	        return password;
	    }


	    // Setters
	    public void setNom(String nom) {
	        this.nom = nom;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public void setPassword(String password) {
	        this.password = password;
	    }

	    public void modifierinfo(String nom, String email) {
	        this.nom = nom;
	        this.email = email;
	    }

		public Compte getCompte() {
			return compte;
		}
	    
}

