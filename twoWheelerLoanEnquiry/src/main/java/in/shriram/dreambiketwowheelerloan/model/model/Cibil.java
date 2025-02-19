package in.shriram.dreambiketwowheelerloan.model.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Cibil {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cibilId;
	@Min(300)
	@Max(900)
	private int cibilScore;
	@NotEmpty
	private Date cibilscoredDateTime;
	@NotBlank
	@NotNull
	private String status;
	@NotBlank
	@NotEmpty
	private String cibilRemark;
}
