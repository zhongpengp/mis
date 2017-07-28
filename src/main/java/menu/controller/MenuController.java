package menu.controller;

import menu.service.MenuService;
import menu.service.RoleService;
import menu.vo.Menu;
import menu.vo.MenuWithOwnedRoleID;
import menu.vo.Role;
import java.io.PrintStream;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
@RequestMapping({ "/menuController" })
public class MenuController {
	@Autowired
	private MenuService menuService;
	@Autowired
	private RoleService roleService;

	@ResponseBody
	@RequestMapping({ "/getMenuByUserID" })
	public List<Menu> getMenusByUserID(String userID) {
		return this.menuService.getMenusByUserID(userID);
	}

	@ResponseBody
	@RequestMapping({ "/checkRoleNameExist" })
	public Map<String, Boolean> checkRoleNameExist(String roleName) {
		return this.roleService.checkRoleNameExist(roleName);
	}

	@ResponseBody
	@RequestMapping({ "/checkEditRoleNameExist" })
	public Map<String, Boolean> checkEditRoleNameExist(String oldName, String newName) {
		if (oldName.trim().equals(newName.trim())) {
			Map<String, Boolean> map = new HashMap();
			map.put("valid", Boolean.valueOf(true));
			return map;
		}
		return this.roleService.checkRoleNameExist(newName);
	}

	@ResponseBody
	@RequestMapping({ "/checkEditMenuNameExist" })
	public Map<String, Boolean> checkEditMenuNameExist(String oldName, String newName) {
		if (oldName.trim().equals(newName.trim())) {
			Map<String, Boolean> map = new HashMap();
			map.put("valid", Boolean.valueOf(true));
			return map;
		}
		return this.menuService.checkMenuNameExist(newName);
	}

	@ResponseBody
	@RequestMapping({ "/saveNewRole" })
	public void saveNewRole(String roleName, String roleDesc) {
		this.roleService.saveNewRole(roleName, roleDesc);
	}

	@ResponseBody
	@RequestMapping({ "/saveNewMenu" })
	public void saveNewMenu(String menuName, String targetPage, String belongMenuID, String menuIcon) {
		this.menuService.saveNewMenu(menuName, targetPage, belongMenuID, menuIcon);
	}

	@ResponseBody
	@RequestMapping({ "/updateNewMenu" })
	public void updateNewMenu(String menuID, String menuName, String targetPage, String belongMenuID, String menuIcon) {
		this.menuService.updateNewMenu(menuID, menuName, targetPage, belongMenuID, menuIcon);
	}

	@ResponseBody
	@RequestMapping({ "/getMenuByMenuID" })
	public Menu getMenuByMenuID(String menuID) {
		Menu menu = this.menuService.getMenuByMenuID(menuID);
		return menu;
	}

	@ResponseBody
	@RequestMapping({ "/updateNewRole" })
	public void updateRole(Role role) {
		this.roleService.updateRole(role);
	}

	@ResponseBody
	@RequestMapping({ "/getAllRoles" })
	public List<Role> getAllRoles() {
		return this.roleService.getAllRoles();
	}

	@ResponseBody
	@RequestMapping({ "/getRolesByName" })
	public List<Role> getRolesByName(String roleName) {
		try {
			roleName = URLDecoder.decode(roleName, "UTF-8");
		} catch (Exception e) {
			System.out.println(e);
		}
		return this.roleService.getRolesByName(roleName);
	}

	@ResponseBody
	@RequestMapping({ "/getRoleByRoleID" })
	public Role getRoleByRoleID(String roleID) {
		return this.roleService.getRoleByRoleID(roleID);
	}

	@ResponseBody
	@RequestMapping({ "/getMenusByRoleID" })
	public List<Menu> getMenusByRoleID(String roleID) {
		return this.menuService.getMenusByRoleID(roleID);
	}

	@ResponseBody
	@RequestMapping({ "/getMenusWithIsOwned" })
	public List<MenuWithOwnedRoleID> getMenusWithIsOwned(String roleID) {
		List<MenuWithOwnedRoleID> list = this.menuService.getMenusWithIsOwned(roleID);
		return list;
	}

	@ResponseBody
	@RequestMapping({ "/saveRole_Menu" })
	public String saveRole_Menu(String[] menuSelect, String roleID) {
		this.roleService.saveRole_Menu(menuSelect, roleID);
		return "success";
	}

	@ResponseBody
	@RequestMapping({ "/deleteRoleByIDs" })
	public void deleteRoleByRoleIDs(String roleIDs) {
		List<String> ids = Arrays.asList(roleIDs.split(","));
		this.roleService.deleteRoleByRoleIDs(ids);
	}

	@ResponseBody
	@RequestMapping({ "/getAllMenu" })
	public List<Menu> getAllMenu() {
		return this.menuService.getAllMenu();
	}

	@ResponseBody
	@RequestMapping({ "/checkMenuNameExist" })
	public Map<String, Boolean> checkMenuNameExist(String menuName) {
		return this.menuService.checkMenuNameExist(menuName);
	}

	@ResponseBody
	@RequestMapping({ "/getRootLevelMenu" })
	public List<Menu> getRootLevelMenu() {
		return this.menuService.getRootLevelMenu();
	}

	@ResponseBody
	@RequestMapping({ "/deleteMenuByIDs" })
	public void deleteMenuByIDs(String menuIDs) {
		this.menuService.deleteMenuByIDs(menuIDs);
	}
}
