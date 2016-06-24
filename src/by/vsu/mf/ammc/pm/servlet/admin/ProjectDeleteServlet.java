package by.vsu.mf.ammc.pm.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.vsu.mf.ammc.pm.domain.project.Project;
import by.vsu.mf.ammc.pm.exception.ServiceException;
import by.vsu.mf.ammc.pm.service.ServiceLocator;
import by.vsu.mf.ammc.pm.service.project.ProjectService;

@WebServlet("/admin/project/delete.html")
public class ProjectDeleteServlet extends HttpServlet {
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
				ProjectService service = locator.getService(ProjectService.class);
				Project project = service.findById(id);
				if(project != null) {
					Integer categoryId = project.getCategory().getId();
					service.delete(id);
					id = categoryId;
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
			resp.sendRedirect(req.getContextPath() + "/admin/project/list.html?category=" + id);
		} else {
			resp.sendRedirect(req.getContextPath() + "/admin/project/list.html");
		}
	}
}