package org.serratec.backend.projetojava2.Exception;

public class DataNotFoundException extends Exception {
	
	private Integer id;
	
	public DataNotFoundException(Integer id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}

	

}
