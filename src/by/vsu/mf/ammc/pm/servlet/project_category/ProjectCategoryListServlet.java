package by.vsu.mf.ammc.pm.servlet.project_category;

import by.vsu.mf.ammc.pm.domain.project.ProjectsCategory;
import by.vsu.mf.ammc.pm.exception.ServiceException;
import by.vsu.mf.ammc.pm.service.ServiceLocator;
import by.vsu.mf.ammc.pm.service.user.ProjectsCategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
/**
 * Created by likan on 10.06.2016.
 */
public class ProjectCategoryListServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = null;
        try {
            id = Integer.parseInt(req.getParameter("id"));
        } catch (NumberFormatException e) {}
        if(id != null) {
            ServiceLocator locator = null;
            try {
                locator = new ServiceLocator();
                ProjectsCategoryService service = locator.getService(ProjectsCategoryService.class);
                List<ProjectsCategory> projectsCategory = service.findAll(id);
                req.setAttribute("category", projectsCategory);
            } catch(ServiceException e) {
                throw new ServletException(e);
            } finally {
                try { locator.close(); } catch(NullPointerException | ServiceException e) {}
            }
        }
        req.getRequestDispatcher("/WEB-INF/jsp/project-category/list.jsp").forward(req, resp);
    }
}
