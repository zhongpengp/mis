package common.persistent;

import common.vo.Supplier;
import common.vo.SupplierExample;
import supplierMng.vo.CompanySupplierApplyReturnVo;
import supplierMng.vo.ProjectSupplierApplyReturnVo;
import supplierMng.vo.SuppliersRetuenVO;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupplierMapper {
    int countByExample(SupplierExample example);

    int deleteByExample(SupplierExample example);

    int deleteByPrimaryKey(String supplierId);

    int insert(Supplier record);

    int insertSelective(Supplier record);

    List<Supplier> selectByExample(SupplierExample example);

    Supplier selectByPrimaryKey(String supplierId);

    int updateByExampleSelective(@Param("record") Supplier record, @Param("example") SupplierExample example);

    int updateByExample(@Param("record") Supplier record, @Param("example") SupplierExample example);

    int updateByPrimaryKeySelective(Supplier record);

    int updateByPrimaryKey(Supplier record);

	List<SuppliersRetuenVO> getCompanySuppliers(String companyID);

	List<SuppliersRetuenVO> getCompanyNotOwnerSuppliers(String companyID);

	List<SuppliersRetuenVO> getProjectSuppliers(String projectID);

	List<SuppliersRetuenVO> getProjectNotOwnerSuppliers(String projectID, String companyID);

	List<CompanySupplierApplyReturnVo> getApprovalSupplierApplyFromGS(String supplierID);

	List<ProjectSupplierApplyReturnVo> getapprovalSupplierApplyFromXM(String supplierID);
}