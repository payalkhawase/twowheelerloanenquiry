package in.shriram.dreambiketwowheelerloan.model.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Enquiry {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	@NotBlank(message = "First name can not be blank")
	@NotEmpty(message = "First name can not be empty")
	@NotNull(message = "First name can not be null")
	private String firstname;
	@NotBlank(message = "Last name can not be blank")
	@NotEmpty(message = "Last name can not be empty")
	@NotNull(message = "Last name can not be null")
	private String lastName;
	@NotBlank(message = "Address can not be blank")
	@NotEmpty(message = "Address can not be empty")
	@NotNull(message = "Address can not be null")
	private String address;
	@NotBlank(message = "City can not be blank")
	@NotEmpty(message = "City can not be empty")
	@NotNull(message = "City can not be null")
	private String city;
	@Min(value = 18, message="Age should be greater than 18")
	private int age;
	@Email(message = "Email is not valid", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
	@NotEmpty(message = "Email cannot be empty")
	private String email;
	@NotBlank(message = "MobileNumber is required")
	@Size(min = 10, max = 10)
	private String mobileNo;
	@Size(min = 10, max = 10)
	private long alternateMobno;
	@Pattern(regexp = "[A-Z]{5}[0-9]{4}[A-Z]{1}",message = "Invalid format of pan card")
	private String pancardNo;
	
	private String adharcardNo;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Cibil cb;
	
}
