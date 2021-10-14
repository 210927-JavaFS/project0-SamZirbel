package com.revature.models;

public class FullJoin {

	private String username;
	
	private String userpassword;
	
	private int account;
	
	private String firstname;
	
	private String lastname;
	
	private String gardenstatus;
	
	private String accounttype;
	
	private int treeid;
	
	private int branches;
	
	private int flowers;
	
	private int birdfeeders;
	
	private String plantinggroup;
	
	private int yearplanted;
	
	private int monthplanted;
	
	private int dayplanted;


	


	public FullJoin(String username, String userpassword, int account, String firstname, String lastname,
			String gardenstatus, String accounttype, int treeid, int branches, int flowers, int birdfeeders,
			String plantinggroup, int yearplanted, int monthplanted, int dayplanted) {
		super();
		this.username = username;
		this.userpassword = userpassword;
		this.account = account;
		this.firstname = firstname;
		this.lastname = lastname;
		this.gardenstatus = gardenstatus;
		this.accounttype = accounttype;
		this.treeid = treeid;
		this.branches = branches;
		this.flowers = flowers;
		this.birdfeeders = birdfeeders;
		this.plantinggroup = plantinggroup;
		this.yearplanted = yearplanted;
		this.monthplanted = monthplanted;
		this.dayplanted = dayplanted;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
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

	public int getTreeid() {
		return treeid;
	}

	public void setTreeid(int treeid) {
		this.treeid = treeid;
	}

	public int getBranches() {
		return branches;
	}

	public void setBranches(int branches) {
		this.branches = branches;
	}

	public int getFlowers() {
		return flowers;
	}

	public void setFlowers(int flowers) {
		this.flowers = flowers;
	}

	public int getBirdfeeders() {
		return birdfeeders;
	}

	public void setBirdfeeders(int birdfeeders) {
		this.birdfeeders = birdfeeders;
	}

	public String getPlantinggroup() {
		return plantinggroup;
	}

	public void setPlantinggroup(String plantinggroup) {
		this.plantinggroup = plantinggroup;
	}

	public int getYearplanted() {
		return yearplanted;
	}

	public void setYearplanted(int yearplanted) {
		this.yearplanted = yearplanted;
	}

	public int getMonthplanted() {
		return monthplanted;
	}

	public void setMonthplanted(int monthplanted) {
		this.monthplanted = monthplanted;
	}

	public int getDayplanted() {
		return dayplanted;
	}

	public void setDayplanted(int dayplanted) {
		this.dayplanted = dayplanted;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + account;
		result = prime * result + ((accounttype == null) ? 0 : accounttype.hashCode());
		result = prime * result + birdfeeders;
		result = prime * result + branches;
		result = prime * result + dayplanted;
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + flowers;
		result = prime * result + ((gardenstatus == null) ? 0 : gardenstatus.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + monthplanted;
		result = prime * result + ((plantinggroup == null) ? 0 : plantinggroup.hashCode());
		result = prime * result + treeid;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		result = prime * result + ((userpassword == null) ? 0 : userpassword.hashCode());
		result = prime * result + yearplanted;
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
		FullJoin other = (FullJoin) obj;
		if (account != other.account)
			return false;
		if (accounttype == null) {
			if (other.accounttype != null)
				return false;
		} else if (!accounttype.equals(other.accounttype))
			return false;
		if (birdfeeders != other.birdfeeders)
			return false;
		if (branches != other.branches)
			return false;
		if (dayplanted != other.dayplanted)
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (flowers != other.flowers)
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
		if (monthplanted != other.monthplanted)
			return false;
		if (plantinggroup == null) {
			if (other.plantinggroup != null)
				return false;
		} else if (!plantinggroup.equals(other.plantinggroup))
			return false;
		if (treeid != other.treeid)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		if (userpassword == null) {
			if (other.userpassword != null)
				return false;
		} else if (!userpassword.equals(other.userpassword))
			return false;
		if (yearplanted != other.yearplanted)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FullJoin [username=" + username + ", userpassword=" + userpassword + ", account=" + account
				+ ", firstname=" + firstname + ", lastname=" + lastname + ", gardenstatus=" + gardenstatus
				+ ", accounttype=" + accounttype + ", treeid=" + treeid + ", branches=" + branches + ", flowers="
				+ flowers + ", birdfeeders=" + birdfeeders + ", plantinggroup=" + plantinggroup + ", yearplanted="
				+ yearplanted + ", monthplanted=" + monthplanted + ", dayplanted=" + dayplanted + "]";
	}
	
	

}
