package by.vsu.mf.ammc.pm.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.vsu.mf.ammc.pm.domain.user.UsersGroup;
import by.vsu.mf.ammc.pm.exception.ServiceException;
import by.vsu.mf.ammc.pm.service.ServiceLocator;
import by.vsu.mf.ammc.pm.service.user.UsersGroupService;

@WebServlet("/admin/user/group/edit.html")
public class UsersGroupEditServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = null;
		try {
			id = Integer.parseInt(req.getParameter("id"));
		} catch(NumberFormatException e) {}
		ServiceLocator locator = null;
		try {
			locator = new ServiceLocator();
			UsersGroupService service = locator.getService(UsersGroupService.class);
			List<UsersGroup> groups = service.findAll();
			req.setAttribute("groups", groups);
			if(id != null) {
				UsersGroup group = service.findById(id);
				req.setAttribute("group", group);
			}
		} catch(ServiceException e) {
			throw new ServletException(e);
		} finally {
			try {
				locator.close();
			} catch(NullPointerException | ServiceException e) {}
		}
		req.getRequestDispatcher("/WEB-INF/jsp/admin/user/group/edit.jsp").forward(req, resp);
	}
}