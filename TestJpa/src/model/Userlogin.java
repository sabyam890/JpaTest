package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the USERLOGIN database table.
 * 
 */
@Entity
@NamedQuery(name="Userlogin.findAll", query="SELECT u FROM Userlogin u")
public class Userlogin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USERLOGIN_USERID_GENERATOR", sequenceName="USERLOGIN_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USERLOGIN_USERID_GENERATOR")
	private long userid;

	private String password;

	private String username;

	//bi-directional one-to-one association to Userdetail
	@OneToOne(mappedBy="userlogin", cascade={CascadeType.PERSIST})
	private Userdetail userdetail;

	public Userlogin() {
	}

	public long getUserid() {
		return this.userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Userdetail getUserdetail() {
		return this.userdetail;
	}

	public void setUserdetail(Userdetail userdetail) {
		this.userdetail = userdetail;
	}

}