package baseMachineMng.vo;

public class SendOutProjectMachineInfo_gs {
	private String projectID;
	private String projectName;
	private String supplierID;
	private String supplierName;
	private String companyID;
	private String companyName;
	private Integer waitSendOutNum;
	private Integer hasSendOutNum;
	private Integer hasSendInNum;
	private Integer unusedNum;
	private Integer waitRepaireNum;
	private Integer scarpNum;

	public Integer getUnusedNum() {
		return unusedNum;
	}

	public void setUnusedNum(Integer unusedNum) {
		this.unusedNum = unusedNum;
	}

	public Integer getWaitRepaireNum() {
		return waitRepaireNum;
	}

	public void setWaitRepaireNum(Integer waitRepaireNum) {
		this.waitRepaireNum = waitRepaireNum;
	}

	public Integer getScarpNum() {
		return scarpNum;
	}

	public void setScarpNum(Integer scarpNum) {
		this.scarpNum = scarpNum;
	}

	public String getProjectID() {
		return projectID;
	}

	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(String supplierID) {
		this.supplierID = supplierID;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getCompanyID() {
		return companyID;
	}

	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Integer getWaitSendOutNum() {
		return waitSendOutNum;
	}

	public void setWaitSendOutNum(Integer waitSendOutNum) {
		this.waitSendOutNum = waitSendOutNum;
	}

	public Integer getHasSendOutNum() {
		return hasSendOutNum;
	}

	public void setHasSendOutNum(Integer hasSendOutNum) {
		this.hasSendOutNum = hasSendOutNum;
	}

	public Integer getHasSendInNum() {
		return hasSendInNum;
	}

	public void setHasSendInNum(Integer hasSendInNum) {
		this.hasSendInNum = hasSendInNum;
	}

}
