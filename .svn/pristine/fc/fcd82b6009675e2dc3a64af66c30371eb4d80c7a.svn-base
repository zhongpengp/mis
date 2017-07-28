package menu.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import menu.persistent.MenuMapper;
import menu.vo.Menu;
import menu.vo.MenuWithOwnedRoleID;

@Service
public class MenuServiceImpl implements MenuService {
	@Autowired
	private RoleService roleService;
	@Autowired
	private MenuMapper menuMapper;

	public List<Menu> getMenusByUserID(String userID) {
		List<String> roleIDs = this.roleService.getRoleIDsbyUserID(userID);
		List<Menu> menus = getMenusByRoleIDs(roleIDs);
		List<Menu> rootMenu = new ArrayList<>();
		List<Menu> childMenu = new ArrayList<>();
		List<Menu> returnMenu = new ArrayList<>();
		for (Menu menu : menus) {
			if(menu.getBelongMenuID().equals("0")){
				rootMenu.add(menu);
			}else{
				childMenu.add(menu);
			}
		}
		for (Menu menu : rootMenu) {
			returnMenu.add(menu);
			for (Menu menu1 : childMenu) {
				if(menu1.getBelongMenuID().equals(menu.getMenuID())){
					returnMenu.add(menu1);
				}
			}
		}
		return returnMenu;
	}

	public List<Menu> getMenusByRoleIDs(List<String> roleIDs) {
		List<Menu> menus = this.menuMapper.getMenusByRoleIDs(roleIDs);
		return menus;
	}

	public List<Menu> getMenusByRoleID(String roleID) {
		List<Menu> menus = this.menuMapper.getMenusByRoleID(roleID);
		return menus;
	}

	public List<MenuWithOwnedRoleID> getMenusWithIsOwned(String roleID) {
		List<MenuWithOwnedRoleID> menus = this.menuMapper.getMenusWithIsOwned(roleID);
		List<MenuWithOwnedRoleID> rootMenu = new ArrayList<>();
		List<MenuWithOwnedRoleID> returnMenu = new ArrayList<>();
		for (MenuWithOwnedRoleID menu : menus) {
			if(menu.getBelongMenuID().equals("0")){
				rootMenu.add(menu);
			}
		}
		for (MenuWithOwnedRoleID menu : rootMenu) {
			returnMenu.add(menu);
			for (MenuWithOwnedRoleID menu1 : menus) {
				if(menu1.getBelongMenuID().equals(menu.getMenuID())){
					returnMenu.add(menu1);
				}
			}
		}
		return returnMenu;
	}

	public List<Menu> getAllMenu() {
		return this.menuMapper.getAllMenu();
	}

	public Map<String, Boolean> checkMenuNameExist(String menuName) {
		Map<String, Boolean> result = new HashMap<String, Boolean>();
		int count = this.menuMapper.checkMenuNameExist(menuName).intValue();
		if (count == 0) {
			result.put("valid", Boolean.valueOf(true));
		} else {
			result.put("valid", Boolean.valueOf(false));
		}
		return result;
	}

	public List<Menu> getRootLevelMenu() {
		return this.menuMapper.getRootLevelMenu();
	}

	public void saveNewMenu(String menuName, String targetPage, String belongMenuID, String menuIcon) {
		int menuID = 1;
		Integer maxID = this.menuMapper.getMenuMaxID();
		if (maxID != null) {
			menuID = maxID + 1;
		}
		this.menuMapper.saveNewMenu(String.valueOf(menuID), menuName, targetPage, belongMenuID,menuIcon);
	}

	public Menu getMenuByMenuID(String menuID) {
		return this.menuMapper.getMenuByMenuID(menuID);
	}
	public void updateNewMenu(String menuID, String menuName, String targetPage, String belongMenuID,String menuIcon) {
		this.menuMapper.updateNewMenu(menuID, menuName, targetPage, belongMenuID,menuIcon);
	}

	public void deleteMenuByIDs(String menuIDs) {
		List<String> menuIDList = null;
		try {
			menuIDList = Arrays.asList(menuIDs.split(","));
		} catch (Exception e) {
			System.out.println(e);
		}
		this.menuMapper.deleteMenuByIDs(menuIDList);
		this.menuMapper.deleteMenuDistributionByIDs(menuIDList);
	}
}
