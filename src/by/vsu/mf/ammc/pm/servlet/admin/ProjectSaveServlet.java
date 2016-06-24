package by.vsu.mf.ammc.pm.servlet.admin;

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
import by.vsu.mf.ammc.pm.service.project.ProjectsCategoryService;
import by.vsu.mf.ammc.pm.service.user.UserService;

@WebServlet("/admin/project/save.html")
public class ProjectSaveServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Integer id = null;
		try {
			id = Integer.parseInt(req.getParameter("id"));
		} catch(NumberFormatException e) {}
		String name = req.getParameter("name");
		Integer managerId = null;
		Integer categoryId = null;
		try {
			managerId = Integer.parseInt(req.getParameter("manager"));
			categoryId = Integer.parseInt(req.getParameter("category"));
		} catch(NumberFormatException e) {}
		if(name != null && managerId != null && categoryId != null) {
			ServiceLocator locator = null;
			try {
				locator = new ServiceLocator();
				UserService userService = locator.getService(UserService.class);
				User manager = userService.findById(managerId);
				ProjectsCategoryService categoryService = locator.getService(ProjectsCategoryService.class);
				ProjectsCategory category = categoryService.findById(categoryId);
				if(manager != null && category != null) {
					Project project = new Project();
					project.setId(id);
					project.setName(name);
					project.setManager(manager);
					project.setCategory(category);
					ProjectService service = locator.getService(ProjectService.class);
					service.save(project);
					id = project.getId();
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
			resp.sendRedirect(req.getContextPath() + "/admin/project/edit.html?id=" + id);
		} else {
			resp.sendRedirect(req.getContextPath() + "/admin/project/list.html");
		}
	}
}