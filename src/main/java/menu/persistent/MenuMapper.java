package menu.persistent;

import menu.vo.Menu;
import menu.vo.MenuWithOwnedRoleID;
import java.util.List;

public abstract interface MenuMapper
{
  public abstract List<Menu> getMenusByRoleIDs(List<String> paramList);
  
  public abstract List<Menu> getMenusByRoleID(String paramString);
  
  public abstract List<MenuWithOwnedRoleID> getMenusWithIsOwned(String paramString);
  
  public abstract String getParentIDByMenuID(String paramString);
  
  public abstract List<Menu> getAllMenu();
  
  public abstract Integer checkMenuNameExist(String paramString);
  
  public abstract List<Menu> getRootLevelMenu();
  
  public abstract Integer getMenuMaxID();
  
  public abstract Integer getNotRootMenuMaxID(String paramString);
  
  public abstract void saveNewMenu(String paramString1, String paramString2, String paramString3, String paramString4, String menuIcon);
  
  public abstract Menu getMenuByMenuID(String paramString);
  
  public abstract void updateNewMenu(String paramString1, String paramString2, String paramString3, String paramString4, String menuIcon);
  
  public abstract void deleteMenuByIDs(List<String> paramList);
  
  public abstract void deleteMenuDistributionByIDs(List<String> paramList);
}
