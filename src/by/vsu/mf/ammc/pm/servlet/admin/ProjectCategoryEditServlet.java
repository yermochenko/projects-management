package by.vsu.mf.ammc.pm.servlet.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.vsu.mf.ammc.pm.domain.project.ProjectsCategory;
import by.vsu.mf.ammc.pm.exception.ServiceException;
import by.vsu.mf.ammc.pm.service.ServiceLocator;
import by.vsu.mf.ammc.pm.service.project.ProjectsCategoryService;

@WebServlet("/admin/project/category/edit.html")
public class ProjectCategoryEditServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = null;
		try {
			id = Integer.parseInt(req.getParameter("id"));
		} catch(NumberFormatException e) {}
		ServiceLocator locator = null;
		try {
			locator = new ServiceLocator();
			ProjectsCategoryService service = locator.getService(ProjectsCategoryService.class);
			List<ProjectsCategory> categories = service.findAll();
			req.setAttribute("categories", categories);
			if(id != null) {
				ProjectsCategory category = service.findById(id);
				req.setAttribute("category", category);
			}
		} catch(ServiceException e) {
			throw new ServletException(e);
		} finally {
			try {
				locator.close();
			} catch(NullPointerException | ServiceException e) {}
		}
		req.getRequestDispatcher("/WEB-INF/jsp/admin/project/category/edit.jsp").forward(req, resp);
	}
}