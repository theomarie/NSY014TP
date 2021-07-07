package rest;



public class Employe {
	
	  private final long id;
	  private final String name;

	  public Employe(long id,String name ) {
		this.id = id;
	    this.name = name;
	  }

	  public Long getId() {
	    return this.id;
	  }

	  public String getName() {
	    return this.name;
	  }

}
