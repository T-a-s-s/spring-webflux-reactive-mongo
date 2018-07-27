package br.com.neoholding.oi.garcom.model.entity.user;

import br.com.neoholding.oi.garcom.enumeration.OiRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;

@AllArgsConstructor
public class OiUser
{
	@Id
	private String id;
	@Getter
	private String name;
	@Getter
	private String password;
	@Getter
	private OiRole role;
}
