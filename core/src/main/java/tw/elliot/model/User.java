package tw.elliot.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "T_USER")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long oid;
	@Column(length = 30)
	private String name;
	@Column(length = 50)
	private String email;
	@Column(length = 50)
	private String password;

	@ElementCollection(targetClass = RoleEnum.class, fetch = FetchType.EAGER)
	@JoinTable(name = "T_USER_ROLES", joinColumns = @JoinColumn(name = "userOid"))
	@Column(name = "role", length = 20)
	@Enumerated(EnumType.STRING)
	private Set<RoleEnum> roles;
}
