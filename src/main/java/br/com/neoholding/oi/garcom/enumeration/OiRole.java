package br.com.neoholding.oi.garcom.enumeration;

public enum OiRole {
	
	ADMIN ("ADMINISTRADOR"),
	MANAGER ("GERENTE"),
	CUSTOMER ("MESA"),
	WAITER ("GARÇOM"),
	KITCHEN ("COZINHA"),
	CUP ("COPA"),
	CARD ("COMANDA");
	
	private String name;
	
	OiRole(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static OiRole getByName(String roleName) {
		for(OiRole n : OiRole.values()) {
			if(n.getName().equals(roleName)) {
				return n;
			}
		}
		return null;
	}
}

