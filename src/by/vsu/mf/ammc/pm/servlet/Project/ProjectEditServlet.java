package by.vsu.mf.ammc.pm.servlet.Project;

import by.vsu.mf.ammc.pm.domain.project.Project;
import by.vsu.mf.ammc.pm.domain.user.ContactsType;
import by.vsu.mf.ammc.pm.domain.user.User;
import by.vsu.mf.ammc.pm.exception.ServiceException;
import by.vsu.mf.ammc.pm.service.ServiceLocator;
import by.vsu.mf.ammc.pm.service.user.ContactsTypeService;
import by.vsu.mf.ammc.pm.service.user.ProjectService;
import by.vsu.mf.ammc.pm.service.user.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Pasha_R on 08.06.2016.
 */
@WebServlet("/project/edit.html")
public class ProjectEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = null;
        try {
            id = Integer.parseInt(req.getParameter("id"));
        } catch(NumberFormatException e) {}
        if(id != null) {
            ServiceLocator locator = null;
            try {
                locator = new ServiceLocator();
                ProjectService service = locator.getService(ProjectService.class);
                Project project = service.findById(id);
                req.setAttribute("project", project);
                UserService userService = locator.getService(UserService.class);
                List<User> users = userService.findAll();
                req.setAttribute("users", users);
            } catch(ServiceException e) {
                throw new ServletException(e);
            } finally {
                try { locator.close(); } catch(NullPointerException | ServiceException e) {}
            }
        }
        req.getRequestDispatcher("/WEB-INF/jsp/project/edit.jsp").forward(req, resp);
    }
}
