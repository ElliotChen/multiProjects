package tw.elliot.model;

import lombok.Data;

import javax.persistence.*;

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
}
