package tw.elliot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "T_TASK")
public class Task {
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	@Column(name="oid", length = 32)
	private String oid;

	@Column
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;

	@Column(length = 30)
	private String title;

}
