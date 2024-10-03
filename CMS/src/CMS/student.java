package CMS;

public class student 
{
	private int Adm_no;
	private String name,dob,Guardian_name,email,role;


	public int getAdm_no() {
		return Adm_no;
	}

	public void setAdm_no(int adm_no) {
		Adm_no = adm_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGuardian_name() {
		return Guardian_name;
	}

	public void setGuardian_name(String guardian_name) {
		Guardian_name = guardian_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
