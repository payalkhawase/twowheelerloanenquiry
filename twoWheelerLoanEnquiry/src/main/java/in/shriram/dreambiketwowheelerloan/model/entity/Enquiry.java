package in.shriram.dreambiketwowheelerloan.model.entity;

import org.hibernate.annotations.Cascade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Enqiry {

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
	
	OneToOne(Cascade=CascadeType.All)
	private Cibil cibilScore;
	
}
