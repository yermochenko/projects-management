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
import java.util.List;

/**
 * Created by user on 09.06.2016.
 */

@WebServlet("/tasks-category/list.html")
public class TasksCategoryListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServiceLocator locator = null;
        try {
            locator = new ServiceLocator();
            TasksCategoryService service = locator.getService(TasksCategoryService.class);
            List<TasksCategory> categories = service.findAll();
            req.setAttribute("categories", categories);
            req.getRequestDispatcher("/WEB-INF/jsp/tasks-category/list.jsp").forward(req, resp);
        } catch(ServiceException e) {
            e.printStackTrace();
            throw new ServletException(e);
        } finally {
            try { locator.close(); } catch(NullPointerException | ServiceException e) {}
        }
    }
}
