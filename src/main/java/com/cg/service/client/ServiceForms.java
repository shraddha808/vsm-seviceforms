package com.cg.service.client;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User class is POJO class for User/Admin.
 * @author 15BW089AX
 *
 */
@Entity
//@Table(name ="services")
public class ServiceForms {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)		
	private int UId;
	@Column(unique = true, length=50)
	private String emailid;
	@Column(name="Uname", length=50)
	private String name;
	@Column(unique = true,length = 10)
	private String mobile;
	@Column
	private float amount;
	@Column (length = 10)
	private String status="pending";
	@Column (length = 100)
	private String service_type;
	@Column (length = 10)
	private String veh_type;
	@Column (length = 100)
	private String parts_name_qty="Not ordered";
	
	
	public int getUId() {
		return UId;
	}
	public void setUId(int UId) {
		this.UId = UId;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getService_type() {
		return service_type;
	}
	public void setService_type(String service_type) {
		this.service_type = service_type;
	}
	
	public String getParts_name() {
		return parts_name_qty;
	}
	public void setParts_name(String parts_name) {
		this.parts_name_qty = parts_name;
	}
	public String getVeh_type() {
		return veh_type;
	}
	public void setVeh_type(String veh_type) {
		this.veh_type = veh_type;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "ServiceForms [UId=" + UId + ", emailid=" + emailid + ", name=" + name + ", mobile=" + mobile
				+ ", amount=" + amount + ", status=" + status + ", service_type=" + service_type + ", veh_type="
				+ veh_type + ", parts_name=" + parts_name_qty + "]";
	}
	
	
}