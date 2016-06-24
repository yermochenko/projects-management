package by.vsu.mf.ammc.pm.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.vsu.mf.ammc.pm.domain.project.ProjectsCategory;
import by.vsu.mf.ammc.pm.exception.ServiceException;
import by.vsu.mf.ammc.pm.service.ServiceLocator;
import by.vsu.mf.ammc.pm.service.project.ProjectsCategoryService;

@WebServlet("/admin/project/category/save.html")
public class ProjectCategorySaveServlet extends HttpServlet {
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
			parentId = Integer.parseInt(req.getParameter("parent"));
		} catch(NumberFormatException e) {}
		if(name != null) {
			ProjectsCategory category = new ProjectsCategory();
			category.setId(id);
			category.setName(name);
			ServiceLocator locator = null;
			try {
				locator = new ServiceLocator();
				ProjectsCategoryService service = locator.getService(ProjectsCategoryService.class);
				if(parentId != null) {
					category.setParent(service.findById(parentId));
				}
				service.save(category);
			} catch(ServiceException e) {
				throw new ServletException(e);
			} finally {
				try {
					locator.close();
				} catch(NullPointerException | ServiceException e) {}
			}
		}
		resp.sendRedirect(req.getContextPath() + "/admin/project/category/list.html");
	}
}