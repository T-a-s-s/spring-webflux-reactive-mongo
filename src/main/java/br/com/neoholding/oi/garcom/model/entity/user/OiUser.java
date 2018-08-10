package br.com.neoholding.oi.garcom.model.entity.user;

import br.com.neoholding.oi.garcom.enumeration.OiRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
public class OiUser
{
	@Id
	private String id;
	@Getter
	@Setter
	private String name;
	@Getter
	private String password;
	@Getter
	@Setter
	private OiRole role;

}
