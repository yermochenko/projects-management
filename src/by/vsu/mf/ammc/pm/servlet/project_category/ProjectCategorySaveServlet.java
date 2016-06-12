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

/**
 * Created by likan on 10.06.2016.
 */
public class ProjectCategorySaveServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = null;
        String name = req.getParameter("name");
        Integer parent_id = null;
        try {
            id = Integer.parseInt(req.getParameter("id"));
        } catch(NumberFormatException e) {}
        try {
            parent_id = Integer.parseInt(req.getParameter("parent_id"));
        } catch(NumberFormatException e) {}

        if(name != null) {
            ProjectsCategory type = new ProjectsCategory();
            type.setId(id);
            type.setName(name);
            //type.setParent(UsersGroupService.findById(parent_id));
            ServiceLocator locator = null;
            try {
                locator = new ServiceLocator();
                ProjectsCategoryService service = locator.getService(ProjectsCategoryService.class);
                if(parent_id != null) {
                    type.setParent(service.findById(parent_id));
                }

                service.save(type);
            } catch(ServiceException e) {
                throw new ServletException(e);
            } finally {
                try { locator.close(); } catch(NullPointerException | ServiceException e) {}
            }
        }
        resp.sendRedirect(req.getContextPath() + "/project-category/list.html");
    }
}
