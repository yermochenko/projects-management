package by.vsu.mf.ammc.pm.servlet.manager;

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

/**
 * Created by Pasha_R on 08.06.2016.
 */
@WebServlet("/manager/project/edit.html")
public class ProjectEditServlet extends HttpServlet {
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
				Project project = service.findById(id);
				req.setAttribute("project", project);
			} catch (ServiceException e) {
				throw new ServletException(e);
			} finally {
				try {
					locator.close();
				} catch (NullPointerException | ServiceException e) {
				}
			}
		}
		req.getRequestDispatcher("/WEB-INF/jsp/manager/project/edit.jsp").forward(req, resp);
	}
}
