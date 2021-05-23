package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {
	private String name;
	private String email;
	private String birthDateString;
	private Date birthDate;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public Client() {

	}

	public Client(String name, String email, String birthDateString) {
		this.name = name;
		this.email = email;
		this.birthDateString = birthDateString;
		try {
			birthDate = sdf.parse(birthDateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	
	
	@Override
	public String toString() {
		return "Client [name=" + name + ", email=" + email + ", birthDateString=" + birthDateString + ", birthDate="
				+ birthDate + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

}
