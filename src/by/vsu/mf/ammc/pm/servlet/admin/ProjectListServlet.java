package by.vsu.mf.ammc.pm.servlet.admin;

import by.vsu.mf.ammc.pm.domain.project.Project;
import by.vsu.mf.ammc.pm.domain.project.ProjectsCategory;
import by.vsu.mf.ammc.pm.exception.ServiceException;
import by.vsu.mf.ammc.pm.service.ServiceLocator;
import by.vsu.mf.ammc.pm.service.project.ProjectService;
import by.vsu.mf.ammc.pm.service.project.ProjectsCategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Pasha_R on 08.06.2016.
 */
@WebServlet("/admin/project/list.html")
public class ProjectListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer categoryId = null;
		try {
			categoryId = Integer.parseInt(req.getParameter("category"));
		} catch(NumberFormatException e) {}
		ServiceLocator locator = null;
		try {
			locator = new ServiceLocator();
			ProjectsCategoryService categoryService = locator.getService(ProjectsCategoryService.class);
			List<ProjectsCategory> categories = categoryService.findAll();
			req.setAttribute("categories", categories);
			if(categoryId != null) {
				ProjectsCategory category = categoryService.findById(categoryId);
				if(category != null) {
					req.setAttribute("category", category);
					ProjectService service = locator.getService(ProjectService.class);
					List<Project> projects = service.findByCategory(category);
					req.setAttribute("projects", projects);
				}
			}
			req.getRequestDispatcher("/WEB-INF/jsp/admin/project/list.jsp").forward(req, resp);
		} catch(ServiceException e) {
			throw new ServletException(e);
		} finally {
			try {
				locator.close();
			} catch(NullPointerException | ServiceException e) {}
		}
	}
}