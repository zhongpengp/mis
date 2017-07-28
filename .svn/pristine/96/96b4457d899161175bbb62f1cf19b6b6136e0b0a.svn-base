package menu.service;

import menu.vo.Menu;
import menu.vo.MenuWithOwnedRoleID;
import java.util.List;
import java.util.Map;

public abstract interface MenuService
{
  public abstract List<Menu> getMenusByUserID(String paramString);
  
  public abstract List<Menu> getMenusByRoleIDs(List<String> paramList);
  
  public abstract List<Menu> getMenusByRoleID(String paramString);
  
  public abstract List<MenuWithOwnedRoleID> getMenusWithIsOwned(String paramString);
  
  public abstract List<Menu> getAllMenu();
  
  public abstract Map<String, Boolean> checkMenuNameExist(String paramString);
  
  public abstract List<Menu> getRootLevelMenu();
  
  public abstract void saveNewMenu(String paramString1, String paramString2, String paramString3, String menuIcon);
  
  public abstract Menu getMenuByMenuID(String paramString);
  
  public abstract void updateNewMenu(String paramString1, String paramString2, String paramString3, String paramString4, String menuIcon);
  
  public abstract void deleteMenuByIDs(String paramString);
}
