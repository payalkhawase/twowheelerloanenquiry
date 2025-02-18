package in.shriram.dreambiketwowheelerloan.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Enquiry {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
	private String firstname;
	private String lastName;
	private String address;
	private String city;
	private int age;
	private String email;
	private String mobileNo;
	private long alternateMobno;
	private String pancardNo;
	private String adharcardNo;
	
	
}
