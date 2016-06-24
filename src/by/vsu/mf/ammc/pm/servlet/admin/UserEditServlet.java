package by.vsu.mf.ammc.pm.servlet.admin;

import java.io.IOException;
import java.util.List;

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

@WebServlet("/admin/user/edit.html")
public class UserEditServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = null;
		try {
			id = Integer.parseInt(req.getParameter("id"));
		} catch(NumberFormatException e) {}
		ServiceLocator locator = null;
		try {
			locator = new ServiceLocator();
			UsersGroupService groupService = locator.getService(UsersGroupService.class);
			List<UsersGroup> groups = groupService.findAll();
			req.setAttribute("groups", groups);
			User user = null;
			if(id != null) {
				UserService userService = locator.getService(UserService.class);
				user = userService.findById(id);
			}
			if(user != null) {
				req.setAttribute("user", user);
			} else {
				Integer groupdId = null;
				try {
					groupdId = Integer.parseInt(req.getParameter("group"));
				} catch(NumberFormatException e) {}
				if(groupdId != null) {
					UsersGroup group = groupService.findById(groupdId);
					req.setAttribute("group", group);
				}
			}
		} catch(ServiceException e) {
			throw new ServletException(e);
		} finally {
			try {
				locator.close();
			} catch(NullPointerException | ServiceException e) {}
		}
		req.getRequestDispatcher("/WEB-INF/jsp/admin/user/edit.jsp").forward(req, resp);
	}
}