package com.revature.models;

public class Tree {

	private int treeid;
	
	private int branches;
	
	private int flowers;
	
	private int birdfeeders;
	
	private String plantinggroup;

	public Tree(int treeid, int branches, int flowers, int birdfeeders, String plantinggroup) {
	
		super();
	
		this.treeid = treeid;
		this.branches = branches;
		this.flowers = flowers;
		this.birdfeeders = birdfeeders;
		this.plantinggroup = plantinggroup;
	
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + birdfeeders;
		result = prime * result + branches;
		result = prime * result + flowers;
		result = prime * result + ((plantinggroup == null) ? 0 : plantinggroup.hashCode());
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
		Tree other = (Tree) obj;
		if (birdfeeders != other.birdfeeders)
			return false;
		if (branches != other.branches)
			return false;
		if (flowers != other.flowers)
			return false;
		if (plantinggroup == null) {
			if (other.plantinggroup != null)
				return false;
		} else if (!plantinggroup.equals(other.plantinggroup))
			return false;
		if (treeid != other.treeid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tree [treeid=" + treeid + ", branches=" + branches + ", flowers=" + flowers + ", birdfeeders="
				+ birdfeeders + ", plantinggroup=" + plantinggroup + "]";
	}
	
	

}
