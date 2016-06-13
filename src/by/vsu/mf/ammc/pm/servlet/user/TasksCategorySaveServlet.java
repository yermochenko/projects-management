package by.vsu.mf.ammc.pm.servlet.user;

import by.vsu.mf.ammc.pm.domain.project.management.TasksCategory;
import by.vsu.mf.ammc.pm.exception.ServiceException;
import by.vsu.mf.ammc.pm.service.ServiceLocator;
import by.vsu.mf.ammc.pm.service.user.TasksCategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by user on 09.06.2016.
 */

@WebServlet("/tasks-category/save.html")
public class TasksCategorySaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = null;
        Integer parent_id = null;
        try {
            parent_id = Integer.parseInt(req.getParameter("parent_id"));
        } catch (NumberFormatException e) {
        }
        try {
            id = Integer.parseInt(req.getParameter("id"));
        } catch (NumberFormatException e) {
        }

        String name = req.getParameter("name");

        if (name != null) {
            TasksCategory category = new TasksCategory();
            category.setId(id);
            category.setName(name);
            //category.setParent();
            ServiceLocator locator = null;
            try {
                locator = new ServiceLocator();
                TasksCategoryService service = locator.getService(TasksCategoryService.class);
                if (parent_id != null ){
                    category.setParent(service.findById(parent_id));
                }
                service.save(category);
            } catch (ServiceException e) {
                throw new ServletException(e);
            } finally {
                try {
                    locator.close();
                } catch (NullPointerException | ServiceException e) {
                }
            }
        }
        resp.sendRedirect(req.getContextPath() + "/tasks-category/list.html");
    }
}
