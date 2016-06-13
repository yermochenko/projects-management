package by.vsu.mf.ammc.pm.servlet.admin;

import by.vsu.mf.ammc.pm.domain.user.UsersGroup;
import by.vsu.mf.ammc.pm.exception.ServiceException;
import by.vsu.mf.ammc.pm.service.ServiceLocator;
import by.vsu.mf.ammc.pm.service.user.UsersGroupService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Влад on 08.06.2016.
 */
@WebServlet("/admin/user/group/save.html")
public class UsersGroupSaveServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Integer id = null;
		String name = req.getParameter("name");
		Integer parentId = null;
		try {
			id = Integer.parseInt(req.getParameter("id"));
		} catch(NumberFormatException e) {}
		try {
			parentId = Integer.parseInt(req.getParameter("parent_id"));
		} catch(NumberFormatException e) {}
		if(name != null) {
			UsersGroup group = new UsersGroup();
			group.setId(id);
			group.setName(name);
			ServiceLocator locator = null;
			try {
				locator = new ServiceLocator();
				UsersGroupService service = locator.getService(UsersGroupService.class);
				if(parentId != null) {
					group.setParent(service.findById(parentId));
				}
				service.save(group);
			} catch(ServiceException e) {
				throw new ServletException(e);
			} finally {
				try {
					locator.close();
				} catch(NullPointerException | ServiceException e) {}
			}
		}
		resp.sendRedirect(req.getContextPath() + "/admin/user/group/list.html");
	}
}