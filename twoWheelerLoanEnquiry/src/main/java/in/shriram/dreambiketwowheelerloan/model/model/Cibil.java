package in.shriram.dreambiketwowheelerloan.model.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class Cibil {
	@Id
	private int cibilId;
	@Min(300)
	@Max(900)
	private int cibilScore;
	@NotEmpty
	private Date cibilscoredDateTime;
	@NotBlank
	@NotNull
	private enum status{Excellent,VeryGood,Good};
	@NotBlank
	@NotEmpty
	private String cibilRemark;
}
