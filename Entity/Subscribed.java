package it.objectmethod.demo.springboot.Entity;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "subscribe")

public class Subscribed {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Long id;
	
	@Column(name="name")
	String name;
	
	@Column(name="surname")
	String surname;
	
	@Column(name="fiscal_code")
	String fiscalCode;
	
	@Column(name="birth_date")
	Date birthDate;
	
	public Long getId() { return id; }

	  public String getName() { return name; }
	  public void setName(String name) { this.name = name; }

	  public String getSurname() { return surname; }
	  public void setSurname(String surname) { this.surname = surname; }

	  public String getFiscalCode() { return fiscalCode; }
	  public void setFiscalCode(String fiscalCode) { this.fiscalCode = fiscalCode; }

	  public Date getBirthDate() { return birthDate; }
	  public void setBirthDate(Date date) { this.birthDate = date; }
}
