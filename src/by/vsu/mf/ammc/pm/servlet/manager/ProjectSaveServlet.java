package by.vsu.mf.ammc.pm.servlet.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.vsu.mf.ammc.pm.domain.project.Project;
import by.vsu.mf.ammc.pm.domain.project.ProjectsCategory;
import by.vsu.mf.ammc.pm.domain.user.User;
import by.vsu.mf.ammc.pm.exception.ServiceException;
import by.vsu.mf.ammc.pm.service.ServiceLocator;
import by.vsu.mf.ammc.pm.service.project.ProjectService;

@WebServlet("/manager/project/save.html")
public class ProjectSaveServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = null;
		Integer category_id = null;
		Integer manager_id = null;
		try {
			id = Integer.parseInt(req.getParameter("id"));
			category_id = Integer.parseInt(req.getParameter("category_id"));
			manager_id = Integer.parseInt(req.getParameter("manager_id"));
		} catch (NumberFormatException e) {
		}
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		if (name != null && description != null) {
			Project save = new Project();
			save.setId(id);
			save.setName(name);
			save.setDescription(description);
			ServiceLocator locator = null;
			try {
				locator = new ServiceLocator();
				ProjectService service = locator.getService(ProjectService.class);
				service.save(save);
			} catch (ServiceException e) {
				throw new ServletException(e);
			} finally {
				try {
					locator.close();
				} catch (NullPointerException | ServiceException e) {
				}
			}
		}
		if (category_id != null && manager_id != null) {
			Project save = new Project();
			save.setId(id);
			save.setCategory(new ProjectsCategory());
			save.getCategory().setId(category_id);
			save.setManager(new User());
			save.getManager().setId(manager_id);
			ServiceLocator locator = null;
			try {
				locator = new ServiceLocator();
				ProjectService service = locator.getService(ProjectService.class);
				service.save(save);
			} catch (ServiceException e) {
				throw new ServletException(e);
			} finally {
				try {
					locator.close();
				} catch (NullPointerException | ServiceException e) {
				}
			}
		}
		resp.sendRedirect(req.getContextPath() + "/manager/project/list.html");
	}
}
