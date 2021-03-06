package common.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import common.persistent.CompanyMapper;
import common.persistent.ProjectMapper;
import common.persistent.SupplierMapper;
import common.service.LoginService;
import common.vo.Company;
import common.vo.LoginQueryVO;
import common.vo.Project;
import common.vo.Supplier;
import common.vo.UserVO;

@Controller
@EnableWebMvc
public class LoginController {
	@Autowired
	private LoginService loginService;
	@Autowired
	private CompanyMapper companyMapper;
	@Autowired
	private ProjectMapper projectMapper;
	@Autowired
	private SupplierMapper supplierMapper;

	@RequestMapping({ "/toLogin" })
	public ModelAndView toLogin(HttpServletRequest request) {
		request.getSession().removeAttribute("userID");
		request.getSession().removeAttribute("userName");
		request.getSession().removeAttribute("userType");
		request.getSession().removeAttribute("loginMessage");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/login");
		return mv;
	}

	@RequestMapping({ "/logout" })
	public ModelAndView logout(HttpServletRequest request) {
		request.getSession().invalidate();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/login");
		return mv;
	}

	@RequestMapping({ "/mis" })
	public ModelAndView doLogin(LoginQueryVO vo, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		try {
			if (request.getSession().getAttribute("userID") != null
					&& request.getSession().getAttribute("userName") != null
					&& request.getSession().getAttribute("userType") != null) {
				request.getSession().setAttribute("loginMessage", "");
				mv.setViewName("common/main");
				return mv;
			}
			if ((vo.getLoginName() == null) || (vo.getLoginPassword() == null)) {
				mv.setViewName("common/login");
				return mv;
			}
			boolean loginSuccess = false;
			String loginMessage = "";
			UserVO user = this.loginService.checkLogin(vo);
			if (user != null) {
				if ("2".equals(user.getUserStatue())) {
					loginSuccess = false;
					loginMessage = "该用户已被注销，登录失败！";
				} else {
					if ("1".equals(user.getUserType())) {
						Company company = companyMapper.selectByPrimaryKey(user.getUserId());
						if (company != null && company.getGsState() != null && !company.getGsState().equals("2")) {
							loginSuccess = true;
						} else {
							loginSuccess = false;
							loginMessage = "对不起，您所在公司状态异常，登录失败！";
						}
					} else if ("2".equals(user.getUserType())) {
						Project project = projectMapper.selectByPrimaryKey(user.getUserId());
						if (project != null && project.getProjectStatue() != null
								&& !project.getProjectStatue().equals("4")) {
							loginSuccess = true;
						} else {
							loginSuccess = false;
							loginMessage = "对不起，您所在项目状态异常，登录失败！";
						}
					} else if ("3".equals(user.getUserType())) {
						Supplier supplier = supplierMapper.selectByPrimaryKey(user.getUserId());
						if (supplier != null && supplier.getSupplierState() != null
								&& !supplier.getSupplierState().equals("3")) {
							loginSuccess = true;
						} else {
							loginSuccess = false;
							loginMessage = "对不起，您所在供应商状态异常，登录失败！";
						}
					} else if ("4".equals(user.getUserType())) {
						loginSuccess = true;
					} else {
						loginSuccess = false;
						loginMessage = "账号异常，登录失败！";
					}
				}
			} else {
				loginSuccess = false;
				loginMessage = "用户名或密码错误，登录失败！";
			}
			if (loginSuccess) {
				if (user.getUserStatue().equals("0")) {
					loginMessage = "登录成功，未修改个人信息状态";
				}
				request.getSession().setAttribute("userID", user.getUserId());
				request.getSession().setAttribute("userName", user.getUserName());
				request.getSession().setAttribute("userType", user.getUserType());
				request.getSession().setAttribute("loginMessage", loginMessage);
				mv.setViewName("common/main");
			} else {
				mv.setViewName("common/login");
				mv.addObject("loginMessage", loginMessage);
			}
			try {
				this.loginService.saveLoginLog(vo, request, loginMessage);
			} catch (Exception e) {
				System.out.println(e);
			}
			return mv;
		} catch (Exception e) {
			mv.setViewName("common/login");
			String loginMessage = "系统出现问题，登录异常，请联系系统管理员！";
			mv.addObject("loginMessage", loginMessage);
			try {
				this.loginService.saveLoginLog(vo, request, loginMessage);
			} catch (Exception e1) {
				System.out.println(e);
			}
			return mv;
		}

	}
}
