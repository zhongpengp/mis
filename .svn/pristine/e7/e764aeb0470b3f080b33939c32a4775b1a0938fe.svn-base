package menu.persistent;

import menu.vo.Role;

import java.util.ArrayList;
import java.util.List;

public abstract interface RoleMapper
{
  public abstract List<String> getRoleIDsbyUserID(String paramString);
  
  public abstract List<Role> getAllRoles();
  
  public abstract void saveRole_Menu(String paramString1, String paramString2, String paramString3);
  
  public abstract void deleteRole_MenuByRoleID(String paramString);
  
  public abstract Integer getRole_MenuMaxID();
  
  public abstract Integer getRoleMaxID();
  
  public abstract int checkExistParent(String paramString1, String paramString2);
  
  public abstract List<Role> getRolesByName(String paramString);
  
  public abstract Integer checkRoleNameExist(String paramString);
  
  public abstract void saveNewRole(String paramString1, String paramString2, String paramString3);
  
  public abstract Role getRoleByRoleID(String paramString);
  
  public abstract void updateRole(Role paramRole);
  
  public abstract void deleteRoleByRoleIDs(List<String> paramList);

public abstract void deleteRole_UserByRoleIDs(List<String> ids);

public abstract void deleteRole_ResponByRoleIDs(List<String> ids);

public abstract ArrayList<String> selectMenuParentIDbyChildID(List<String> childIDList);
}
