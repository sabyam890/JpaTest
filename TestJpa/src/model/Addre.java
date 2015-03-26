package model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the ADDRES database table.
 * 
 */
@Entity
@Table(name="ADDRES")
@NamedQuery(name="Addre.findAll", query="SELECT a FROM Addre a")
public class Addre implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ADDRES_ADDRESID_GENERATOR", sequenceName="ADDRESID_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ADDRES_ADDRESID_GENERATOR")
	private long addresid;

	private String addrline1;

	private String addrline2;

	private String city;

	@Column(name="\"STATE\"")
	private String state;

	private BigDecimal zip;

	//bi-directional many-to-one association to Userdetail
	@ManyToOne
	@JoinColumn(name="USERDETAIL_ID", referencedColumnName="userdetaildid")
	private Userdetail userdetail;

	public Addre() {
	}

	public long getAddresid() {
		return this.addresid;
	}

	public void setAddresid(long addresid) {
		this.addresid = addresid;
	}

	public String getAddrline1() {
		return this.addrline1;
	}

	public void setAddrline1(String addrline1) {
		this.addrline1 = addrline1;
	}

	public String getAddrline2() {
		return this.addrline2;
	}

	public void setAddrline2(String addrline2) {
		this.addrline2 = addrline2;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public BigDecimal getZip() {
		return this.zip;
	}

	public void setZip(BigDecimal zip) {
		this.zip = zip;
	}

	public Userdetail getUserdetail() {
		return this.userdetail;
	}

	public void setUserdetail(Userdetail userdetail) {
		this.userdetail = userdetail;
	}
	
	public Userdetail addUserdetails(Userdetail userdetail) {
		if(userdetail.getAddres()==null){
			List<Addre> addres= new ArrayList<Addre>();
			userdetail.setAddres(addres);
		}
		userdetail.getAddres().add(this);
		return userdetail;
	}

	public Userdetail removeUserdetail(Userdetail userdetail) {
		this.setUserdetail(null);
		return userdetail;
	}

}