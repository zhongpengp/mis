package menu.service;

import menu.vo.Role;
import java.util.List;
import java.util.Map;

public abstract interface RoleService
{
  public abstract List<String> getRoleIDsbyUserID(String paramString);
  
  public abstract List<Role> getAllRoles();
  
  public abstract void saveRole_Menu(String[] paramArrayOfString, String paramString);
  
  public abstract List<Role> getRolesByName(String paramString);
  
  public abstract Map<String, Boolean> checkRoleNameExist(String paramString);
  
  public abstract void saveNewRole(String paramString1, String paramString2);
  
  public abstract Role getRoleByRoleID(String paramString);
  
  public abstract void updateRole(Role role);
  
  public abstract void deleteRoleByRoleIDs(List<String> paramList);
}
