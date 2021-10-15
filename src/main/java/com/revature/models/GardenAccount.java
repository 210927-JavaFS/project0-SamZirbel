package com.revature.models;

public class GardenAccount {

	private int account;
	private String firstname;
	private String lastname;
	private int treeid;
	private String gardenstatus;
	private String accounttype;
	
	
	
	
	public GardenAccount(int account, String firstname, String lastname, int treeid, String gardenstatus,
			String accounttype) {
		super();
		this.account = account;
		this.firstname = firstname;
		this.lastname = lastname;
		this.treeid = treeid;
		this.gardenstatus = gardenstatus;
		this.accounttype = accounttype;
	}
	
	
	public int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getTreeid() {
		return treeid;
	}
	public void setTreeid(int treeid) {
		this.treeid = treeid;
	}
	public String getGardenstatus() {
		return gardenstatus;
	}
	public void setGardenstatus(String gardenstatus) {
		this.gardenstatus = gardenstatus;
	}
	public String getAccounttype() {
		return accounttype;
	}
	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}


	@Override
	public String toString() {
		return "GardenAccount [account=" + account + ", firstname=" + firstname + ", lastname=" + lastname + ", treeid="
				+ treeid + ", gardenstatus=" + gardenstatus + ", accounttype=" + accounttype + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + account;
		result = prime * result + ((accounttype == null) ? 0 : accounttype.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((gardenstatus == null) ? 0 : gardenstatus.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + treeid;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GardenAccount other = (GardenAccount) obj;
		if (account != other.account)
			return false;
		if (accounttype == null) {
			if (other.accounttype != null)
				return false;
		} else if (!accounttype.equals(other.accounttype))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (gardenstatus == null) {
			if (other.gardenstatus != null)
				return false;
		} else if (!gardenstatus.equals(other.gardenstatus))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (treeid != other.treeid)
			return false;
		return true;
	}
	
	
	
	

}
