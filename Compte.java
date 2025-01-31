package project1;

public class Compte {
	  private double rib;
	    private int code;
	    private double solde = 0;

	    public Compte(double rib, int code) {
	        this.rib = rib;
	        this.code = code;
	        this.solde = 0;
	    }


	    public double getRib() {
	        return rib;
	    }

	    public int getCode() {
	        return code;
	    }

	    public double getSolde() {
	        return solde;
	    }

	    // Setters
	    public void setRib(double rib) {
	        this.rib = rib;
	    }

	    public void setCode(int code) {
	        this.code = code;
	    }

	    public void setSolde(double solde) {
	        this.solde = solde;
	    }
}
