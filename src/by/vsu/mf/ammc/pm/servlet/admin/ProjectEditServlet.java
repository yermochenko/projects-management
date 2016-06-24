package by.vsu.mf.ammc.pm.servlet.admin;

import java.io.IOException;
import java.util.List;

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
import by.vsu.mf.ammc.pm.service.project.ProjectsCategoryService;
import by.vsu.mf.ammc.pm.service.user.UserService;

@WebServlet("/admin/project/edit.html")
public class ProjectEditServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = null;
		try {
			id = Integer.parseInt(req.getParameter("id"));
		} catch(NumberFormatException e) {}
		ServiceLocator locator = null;
		try {
			locator = new ServiceLocator();
			UserService userService = locator.getService(UserService.class);
			List<User> users = userService.findAll();
			req.setAttribute("users", users);
			ProjectsCategoryService categoryService = locator.getService(ProjectsCategoryService.class);
			List<ProjectsCategory> categories = categoryService.findAll();
			req.setAttribute("categories", categories);
			Project project = null;
			if(id != null) {
				ProjectService projectService = locator.getService(ProjectService.class);
				project = projectService.findById(id);
			}
			if(project != null) {
				req.setAttribute("project", project);
			} else {
				Integer categoryId = null;
				try {
					categoryId = Integer.parseInt(req.getParameter("category"));
				} catch(NumberFormatException e) {}
				if(categoryId != null) {
					ProjectsCategory category = categoryService.findById(categoryId);
					req.setAttribute("category", category);
				}
			}
		} catch(ServiceException e) {
			throw new ServletException(e);
		} finally {
			try {
				locator.close();
			} catch(NullPointerException | ServiceException e) {}
		}
		req.getRequestDispatcher("/WEB-INF/jsp/admin/project/edit.jsp").forward(req, resp);
	}
}