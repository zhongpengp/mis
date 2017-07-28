package common.vo;

import java.util.UUID;

public class applyMachineInfoVO {
	private String id;
	private String applyID;
	private String machineName;
	private String machineType;
	private String machineSize;
	private String machineNum;
	private String unit;
	private String producter;
	private String applyReason;
	private String remark;
	public String getApplyID() {
		return applyID;
	}
	public void setApplyID(String applyID) {
		this.applyID = applyID;
	}
	public String getMachineName() {
		return machineName;
	}
	public void setMachineName(String machineName) {
		this.machineName = machineName;
	}
	public String getMachineType() {
		return machineType;
	}
	public void setMachineType(String machineType) {
		this.machineType = machineType;
	}
	public String getMachineSize() {
		return machineSize;
	}
	public void setMachineSize(String machineSize) {
		this.machineSize = machineSize;
	}
	public String getMachineNum() {
		return machineNum;
	}
	public void setMachineNum(String machineNum) {
		this.machineNum = machineNum;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getProducter() {
		return producter;
	}
	public void setProducter(String producter) {
		this.producter = producter;
	}
	public String getApplyReason() {
		return applyReason;
	}
	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public void init(String[] grade, String applyID) {
		this.id = UUID.randomUUID().toString().replaceAll("-", "");
		this.applyID = applyID;
		this.machineName = grade[0].toString();
		this.machineType = grade[1].toString();
		this.machineSize = grade[2].toString();
		this.machineNum = grade[3].toString();
		this.unit = grade[4].toString();
		this.producter = grade[5].toString();
		this.applyReason = grade[6].toString();
		this.remark = grade[7].toString();		
	}
}
