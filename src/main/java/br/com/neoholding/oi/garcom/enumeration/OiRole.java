package br.com.neoholding.oi.garcom.enumeration;

import lombok.Getter;

public enum OiRole {
	
	ADMIN ("ADMINISTRADOR", "ROLE_ADMIN"),
	MANAGER ("GERENTE", "ROLE_MANAGER"),
	CUSTOMER ("MESA", "ROLE_USER"),
	WAITER ("GARÇOM", "ROLE_WAITER"),
	KITCHEN ("COZINHA", "ROLE_KITCHEN"),
	CUP ("COPA", "ROLE_CUP"),
	CARD ("COMANDA", "ROLE_CARD");

	@Getter
	private String name;
	@Getter
	private String roleName;
	
	OiRole(String name, String roleName) {
		this.name = name;
		this.roleName = roleName;
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

