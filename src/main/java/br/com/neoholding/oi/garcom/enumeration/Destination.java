package br.com.neoholding.oi.garcom.enumeration;

public enum Destination {
	
	KITCHEN(0),
	KITCHEN_CUP(1),
	KITCHEN_AND_KITCHEN_CUP(2);
	
	private Integer cod;
	
	Destination(Integer cod) {
		this.cod = cod;
	}
	
	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public Destination getByCod(Integer cod) {
		for(Destination d : Destination.values()) {
			if(d.cod == cod) {
				return d;
			}
		}
		return null;
	}

	public boolean shouldGoTo(Role neoRole) {
		switch (this) {
			case KITCHEN:
				if (neoRole != Role.KITCHEN) {
					return false;
				}
				break;
			case KITCHEN_CUP:
				if (neoRole != Role.KITCHEN_CUP) {
					return false;
				}
				break;
			case KITCHEN_AND_KITCHEN_CUP:
				if (neoRole != Role.KITCHEN 
				 && neoRole != Role.KITCHEN_CUP) {
					return false;
				}
				break;
			default:
				break;
		}
		return true;
	}

}

