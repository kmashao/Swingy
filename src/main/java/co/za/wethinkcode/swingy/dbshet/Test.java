package co.za.wethinkcode.swingy.dbshet;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Test {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name_;

	public void setName_(String name_){
		this.name_ = name_;
	}

	public String getName_(){
		return name_;
	}




}
