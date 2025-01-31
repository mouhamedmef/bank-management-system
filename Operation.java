package project1;
import java.util.Date;
public class Operation {
	 private static int id = 0;
	    private int idOperation;
	    private String nom_operation;
	    private Date date;
	    public Operation(String nom_operation) {
	        this.idOperation = ++id;
	        this.nom_operation = nom_operation;
	        this.date = new Date();  
	    }

	    // Getters
	    public int getIdOperation() {
	        return idOperation;
	    }
	    public String get_nom_operation() {
	        return nom_operation;
	    }
	    public Date getDate() {
	        return date;
	    }

	    // Setters
	    public void setNom_operation(String nom_operation) {
	        this.nom_operation = nom_operation;
	    }

	    @Override
	    public String toString() {
	        return "Operation{" +
	               "idOperation=" + idOperation +
	               ", nom_operation='" + nom_operation + '\'' +
	               ", date=" + date +
	               '}';
	    }
}
