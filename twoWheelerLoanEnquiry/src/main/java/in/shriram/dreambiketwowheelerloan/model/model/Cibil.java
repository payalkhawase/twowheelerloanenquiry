package in.shriram.dreambiketwowheelerloan.model.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Cibil {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cibilId;
	
	private int cibilScore;
	private Date cibilscoredDateTime;
	private String status;
	private String cibilRemark;
}
