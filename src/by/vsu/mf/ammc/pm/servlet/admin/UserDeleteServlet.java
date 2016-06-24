package by.vsu.mf.ammc.pm.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.vsu.mf.ammc.pm.domain.user.User;
import by.vsu.mf.ammc.pm.exception.ServiceException;
import by.vsu.mf.ammc.pm.service.ServiceLocator;
import by.vsu.mf.ammc.pm.service.user.UserService;

@WebServlet("/admin/user/delete.html")
public class UserDeleteServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = null;
		try {
			id = Integer.parseInt(req.getParameter("id"));
		} catch(NumberFormatException e) {}
		if(id != null) {
			ServiceLocator locator = null;
			try {
				locator = new ServiceLocator();
				UserService service = locator.getService(UserService.class);
				User user = service.findById(id);
				if(user != null) {
					Integer groupId = user.getGroup().getId();
					service.delete(id);
					id = groupId;
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
			resp.sendRedirect(req.getContextPath() + "/admin/user/list.html?group=" + id);
		} else {
			resp.sendRedirect(req.getContextPath() + "/admin/user/list.html");
		}
	}
}