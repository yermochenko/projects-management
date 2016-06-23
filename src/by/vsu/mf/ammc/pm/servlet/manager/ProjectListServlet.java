package by.vsu.mf.ammc.pm.servlet.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.vsu.mf.ammc.pm.domain.project.Project;
import by.vsu.mf.ammc.pm.domain.project.ProjectsCategory;
import by.vsu.mf.ammc.pm.exception.ServiceException;
import by.vsu.mf.ammc.pm.service.ServiceLocator;
import by.vsu.mf.ammc.pm.service.project.ProjectService;

/**
 * Created by Pasha_R on 08.06.2016.
 */
@WebServlet("/manager/project/list.html")
public class ProjectListServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = null;
		try {
			id = Integer.parseInt(req.getParameter("id"));
		} catch (NumberFormatException e) {
		}
		if (id != null) {
			ServiceLocator locator = null;
			try {
				locator = new ServiceLocator();
				ProjectService service = locator.getService(ProjectService.class);
				ProjectsCategory category = new ProjectsCategory(); // TODO: заменить на получение объекта из базы
				category.setId(id);
				List<Project> projects = service.findByCategory(category);
				req.setAttribute("projects", projects);
			} catch (ServiceException e) {
				throw new ServletException(e);
			} finally {
				try {
					locator.close();
				} catch (NullPointerException | ServiceException e) {
				}
			}
		}
		req.getRequestDispatcher("/WEB-INF/jsp/manager/project/list.jsp").forward(req, resp);
	}
}
