package by.vsu.mf.ammc.pm.servlet.Project;

import by.vsu.mf.ammc.pm.domain.project.Project;
import by.vsu.mf.ammc.pm.domain.project.ProjectsCategory;
import by.vsu.mf.ammc.pm.domain.user.User;
import by.vsu.mf.ammc.pm.exception.ServiceException;
import by.vsu.mf.ammc.pm.service.ServiceLocator;
import by.vsu.mf.ammc.pm.service.user.ProjectService;
import by.vsu.mf.ammc.pm.service.user.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Pasha_R on 08.06.2016.
 */
@WebServlet("/project/save.html")
public class ProjectSaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = null;
        Integer manager_id = null;
        Integer category_id = null;
        try {
            id = Integer.parseInt(req.getParameter("id"));
        } catch(NumberFormatException e) {}
        try {
            manager_id = Integer.parseInt(req.getParameter("manager_id"));
            category_id = Integer.parseInt(req.getParameter("category_id"));
        } catch(NumberFormatException e) {}
        String name = req.getParameter("name");
        if(name != null && manager_id != null && category_id != null) {
            Project project = new Project();
            project.setId(id);
            project.setName(name);
            ServiceLocator locator = null;
            try {
                locator = new ServiceLocator();
                ProjectService service = locator.getService(ProjectService.class);
                UserService userService = locator.getService(UserService.class);
                User manager = userService.findById(manager_id);
                if(manager != null) {
                    project.setManager(manager);
                    project.setCategory(new ProjectsCategory()); // TODO: проверить категорию через ProjectsCategoryService аналогично менеджеру
                    project.getCategory().setId(category_id);
                    service.save(project);
                }
            } catch(ServiceException e) {
                e.printStackTrace();
                throw new ServletException(e);
            } finally {
                try { locator.close(); } catch(NullPointerException | ServiceException e) {}
            }
        }
        resp.sendRedirect(req.getContextPath() + "/project/list.html?id=" + category_id);
    }
}
