package io.javabrains.ratingsdataservice.model;

import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class UserRating {
@Id
    private String rId;
	private String uId;
	private String mId;
	private int rate;
	public String getrId() {
		return rId;
	}
	public void setrId(String rId) {
		this.rId = rId;
	}
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public UserRating(String rId, String uId, String mId, int rate) {
		super();
		this.rId = rId;
		this.uId = uId;
		this.mId = mId;
		this.rate = rate;
	}
	public UserRating() {
		super();
	}
	
   
}
