package by.vsu.mf.ammc.pm.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.vsu.mf.ammc.pm.domain.user.User;
import by.vsu.mf.ammc.pm.domain.user.UsersGroup;
import by.vsu.mf.ammc.pm.exception.ServiceException;
import by.vsu.mf.ammc.pm.service.ServiceLocator;
import by.vsu.mf.ammc.pm.service.user.UserService;
import by.vsu.mf.ammc.pm.service.user.UsersGroupService;

@WebServlet("/admin/user/save.html")
public class UserSaveServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Integer id = null;
		Integer groupId = null;
		Boolean admin = req.getParameter("is-admin") != null;
		String name = req.getParameter("name");
		String firstName = req.getParameter("first-name");
		String middleName = req.getParameter("middle-name");
		String lastName = req.getParameter("last-name");
		try {
			id = Integer.parseInt(req.getParameter("id"));
		} catch(NumberFormatException e) {}
		try {
			groupId = Integer.parseInt(req.getParameter("group"));
		} catch(NumberFormatException e) {}
		if(name != null && firstName != null && middleName != null && lastName != null && groupId != null) {
			ServiceLocator locator = null;
			try {
				locator = new ServiceLocator();
				UsersGroupService groupService = locator.getService(UsersGroupService.class);
				UsersGroup group = groupService.findById(groupId);
				if(group != null) {
					User user = new User();
					user.setId(id);
					user.setName(name);
					user.setFirstName(firstName);
					user.setMiddleName(middleName);
					user.setLastName(lastName);
					user.setGroup(group);
					user.setAdmin(admin);
					UserService service = locator.getService(UserService.class);
					service.save(user);
					id = user.getId();
				}
			} catch(ServiceException e) {
				throw new ServletException(e);
			} finally {
				try {
					locator.close();
				} catch(NullPointerException | ServiceException e) {}
			}
		}
		if(id != null) {
			resp.sendRedirect(req.getContextPath() + "/admin/user/edit.html?id=" + id);
		} else {
			resp.sendRedirect(req.getContextPath() + "/admin/user/list.html");
		}
	}
}