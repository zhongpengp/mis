package menu.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import menu.persistent.MenuMapper;
import menu.persistent.RoleMapper;
import menu.vo.Role;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleMapper roleMapper;
	@Autowired
	private MenuMapper menuMapper;

	public List<String> getRoleIDsbyUserID(String userID) {
		return this.roleMapper.getRoleIDsbyUserID(userID);
	}

	public List<Role> getAllRoles() {
		return this.roleMapper.getAllRoles();
	}

	public void saveRole_Menu(String[] menuSelect, String roleID) {
		this.roleMapper.deleteRole_MenuByRoleID(roleID);
		if ((menuSelect != null) && (menuSelect.length > 0)) {
			List<String> childIDList = Arrays.asList(menuSelect);
			ArrayList<String> parentIDList = roleMapper.selectMenuParentIDbyChildID(childIDList);
			Integer maxID = this.roleMapper.getRole_MenuMaxID();
			if(maxID==null){
				maxID=1;
			}
			for (String menuID : menuSelect) {
				roleMapper.saveRole_Menu(String.valueOf(++maxID), roleID, menuID);
			}
			for (String menuID : parentIDList) {
				roleMapper.saveRole_Menu(String.valueOf(++maxID), roleID, menuID);
			}
		}
	}

	public List<Role> getRolesByName(String roleName) {
		return this.roleMapper.getRolesByName(roleName);
	}

	public Map<String, Boolean> checkRoleNameExist(String roleName) {
		Map<String, Boolean> result = new HashMap<String, Boolean>();
		int count = this.roleMapper.checkRoleNameExist(roleName).intValue();
		if (count == 0) {
			result.put("valid", Boolean.valueOf(true));
		} else {
			result.put("valid", Boolean.valueOf(false));
		}
		return result;
	}

	public void saveNewRole(String roleName,String roleDesc) {
		int roleID = 1;
		Integer maxID = this.roleMapper.getRoleMaxID();
		if(maxID!=null){
			roleID = maxID+1;
		}
		this.roleMapper.saveNewRole(String.valueOf(roleID), roleName,roleDesc);
	}

	public Role getRoleByRoleID(String roleID) {
		return this.roleMapper.getRoleByRoleID(roleID);
	}

	public void updateRole(Role role) {
		this.roleMapper.updateRole(role);
	}

	public void deleteRoleByRoleIDs(List<String> ids) {
		this.roleMapper.deleteRoleByRoleIDs(ids);
		this.roleMapper.deleteRole_UserByRoleIDs(ids);
		this.roleMapper.deleteRole_ResponByRoleIDs(ids);
	}
}
