package in.shriram.dreambiketwowheelerloan.model.model;

import java.util.Date;
import java.util.Random;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
/*import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
*/
@Entity
public class Cibil {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cibilId;
	
	//@Min(value=300,message = "Cibil score greater than 300")
	//@Max(value=900,message = "Cibil score less than 900")
	private int cibilScore;

	//@NotEmpty(message = "Date should not empty")
	private Date cibilscoredDateTime = new Date();
	
	//@NotBlank(message = "Status should not be blank")
	@NotEmpty(message = "Status should not be empty")
	private String status;
	//{Excellent,VeryGood,Good};
	//@NotBlank(message = "Cibil remark should not be blank")
	//@NotEmpty(message = "Cibil remark should not be empty")
	//@NotNull(message = "Cibil remark should not be null")
	private String cibilRemark;
	
	
	public int getCibilId() {
		return cibilId;
	}
	public void setCibilId(int cibilId) {
		this.cibilId = cibilId;
	}
	public int getCibilScore() {
		return cibilScore;
	}
	public void setCibilScore(int cibilScore) {
		Random randam = new Random();
		
		int low = 300;
		int high = 900;
		int score =  randam.nextInt(high-low) + low;
		
		this.cibilScore = score;
	}
	public Date getCibilscoredDateTime() {
		return cibilscoredDateTime;
	}
	public void setCibilscoredDateTime(Date cibilscoredDateTime) {
		this.cibilscoredDateTime = new Date();
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		
		String status1;
		
		if(this.getCibilScore() > 700)
			status1 = "Approved";
		else
			status1="Rejected";
		
		this.status = status1;
	}
	public String getCibilRemark() {
		return cibilRemark;
	}
	public void setCibilRemark(String cibilRemark) {
		
		String remark = "Good";
		
		
		if(this.getCibilScore() >= 300 && this.getCibilScore() <= 600)
			remark="Need Help";
		
		if(this.getCibilScore() > 600 && this.getCibilScore() <= 700)
			remark="Average";
		
		if(this.getCibilScore() > 700 && this.getCibilScore() <= 760)
			remark="Good";
		
		if(this.getCibilScore() > 760 && this.getCibilScore() <= 800)
			remark="Very Good";
		
		if(this.getCibilScore() > 800 && this.getCibilScore() <= 900)
			remark="Excellent";
		
		this.cibilRemark = remark;
	}
	
	
	
}
