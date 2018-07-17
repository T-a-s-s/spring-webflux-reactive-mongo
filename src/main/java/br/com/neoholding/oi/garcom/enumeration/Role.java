package br.com.neoholding.oi.garcom.enumeration;

public enum Role {
	
	ADMIN ("ADMIN"),
	MANAGER ("GERENTE"),
	TABLE ("MESA"),
	WAITER ("GARÇON"),
	KITCHEN ("COZINHA"),
	KITCHEN_CUP ("COPA"),
	ORDER_USER ("COMANDA");
	
	private String name;
	
	Role (String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public static Role getByName(String roleName) {
		for(Role n : Role.values()) {
			if(n.getName().equals(roleName)) {
				return n;
			}
		}
		return null;
	}
}

