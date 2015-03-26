package model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the USERDETAILS database table.
 * 
 */
@Entity
@Table(name="USERDETAILS")
@NamedQuery(name="Userdetail.findAll", query="SELECT u FROM Userdetail u")
public class Userdetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USERDETAILS_USERDETAILDID_GENERATOR", sequenceName="USERDETAIL_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USERDETAILS_USERDETAILDID_GENERATOR")
	private long userdetaildid;

	private String constituincy;

	private String email;

	private String firstname;

	private String lastname;

	private String phonenumber;

	private String status;
	@Transient
	private BigDecimal userloginid;

	//bi-directional one-to-one association to Userlogin
	@OneToOne(cascade={CascadeType.PERSIST})
	@JoinColumn(name="USERLOGINID")
	private Userlogin userlogin;

	//bi-directional many-to-one association to Addre
	@OneToMany(mappedBy="userdetail", cascade= CascadeType.ALL)
	private List<Addre> addres;

	public Userdetail() {
	}

	public long getUserdetaildid() {
		return this.userdetaildid;
	}

	public void setUserdetaildid(long userdetaildid) {
		this.userdetaildid = userdetaildid;
	}

	public String getConstituincy() {
		return this.constituincy;
	}

	public void setConstituincy(String constituincy) {
		this.constituincy = constituincy;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhonenumber() {
		return this.phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getUserloginid() {
		return this.userloginid;
	}

	public void setUserloginid(BigDecimal userloginid) {
		this.userloginid = userloginid;
	}

	public Userlogin getUserlogin() {
		return this.userlogin;
	}

	public void setUserlogin(Userlogin userlogin) {
		this.userlogin = userlogin;
	}

	public List<Addre> getAddres() {
		return this.addres;
	}

	public void setAddres(List<Addre> addres) {
		this.addres = addres;
	}

	public Addre addAddre(Addre addre) {
		if(this.addres==null){
			this.addres= new ArrayList<Addre>();
		}
		getAddres().add(addre);
		addre.setUserdetail(this);

		return addre;
	}

	public Addre removeAddre(Addre addre) {
		getAddres().remove(addre);
		addre.setUserdetail(null);

		return addre;
	}

}