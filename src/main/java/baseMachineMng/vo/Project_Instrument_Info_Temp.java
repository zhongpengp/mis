package baseMachineMng.vo;

import java.util.Date;

import util.UUID_Util;

public class Project_Instrument_Info_Temp {
	private String id;

	private String projectId;

	private String supplierId;

	private String machineName;

	private String machineType;

	private String machineSize;

	private String rangeJingdu;

	private String producerOrd;

	private String machineState;

	private String unit;

	private String producer;

	private String oldNew;

	private Date sendDate;

	private Date importDate;

	private Date installDate;

	private Date checkDate;

	private String checkPeriod;

	private Date baozhiqi;

	private Integer repairNum;

	private Integer applyState;

	private String approvalDetail;

	private Date applyTime;

	private Double unitPrice;

	private String machineClassify;

	private String remark;

	private Integer machineNum;

	public void init(String[] machineInfo, String projectID2, String supplierID2) {
		this.id = UUID_Util.getUUID();
		this.projectId = projectID2;
		this.supplierId = supplierID2;
		this.applyTime = new Date();
		this.applyState = 1;
		this.machineClassify = machineInfo[0];
		this.machineName = machineInfo[1];
		this.machineType = machineInfo[2];
		this.machineSize = machineInfo[3];
		this.machineNum = Integer.valueOf(machineInfo[4]);
		this.rangeJingdu = machineInfo[5];
		this.unit = machineInfo[6];
		this.producer = machineInfo[7];
		this.unitPrice = Double.valueOf(machineInfo[8]);
		this.remark = machineInfo[9];
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
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

	public String getRangeJingdu() {
		return rangeJingdu;
	}

	public void setRangeJingdu(String rangeJingdu) {
		this.rangeJingdu = rangeJingdu;
	}

	public String getProducerOrd() {
		return producerOrd;
	}

	public void setProducerOrd(String producerOrd) {
		this.producerOrd = producerOrd;
	}

	public String getMachineState() {
		return machineState;
	}

	public void setMachineState(String machineState) {
		this.machineState = machineState;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public String getOldNew() {
		return oldNew;
	}

	public void setOldNew(String oldNew) {
		this.oldNew = oldNew;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public Date getImportDate() {
		return importDate;
	}

	public void setImportDate(Date importDate) {
		this.importDate = importDate;
	}

	public Date getInstallDate() {
		return installDate;
	}

	public void setInstallDate(Date installDate) {
		this.installDate = installDate;
	}

	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	public String getCheckPeriod() {
		return checkPeriod;
	}

	public void setCheckPeriod(String checkPeriod) {
		this.checkPeriod = checkPeriod;
	}

	public Date getBaozhiqi() {
		return baozhiqi;
	}

	public void setBaozhiqi(Date baozhiqi) {
		this.baozhiqi = baozhiqi;
	}

	public Integer getRepairNum() {
		return repairNum;
	}

	public void setRepairNum(Integer repairNum) {
		this.repairNum = repairNum;
	}

	public Integer getApplyState() {
		return applyState;
	}

	public void setApplyState(Integer applyState) {
		this.applyState = applyState;
	}

	public String getApprovalDetail() {
		return approvalDetail;
	}

	public void setApprovalDetail(String approvalDetail) {
		this.approvalDetail = approvalDetail;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getMachineClassify() {
		return machineClassify;
	}

	public void setMachineClassify(String machineClassify) {
		this.machineClassify = machineClassify;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getMachineNum() {
		return machineNum;
	}

	public void setMachineNum(Integer machineNum) {
		this.machineNum = machineNum;
	}
}