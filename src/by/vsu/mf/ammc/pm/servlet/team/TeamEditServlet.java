package by.vsu.mf.ammc.pm.servlet.team;

import by.vsu.mf.ammc.pm.domain.project.management.Team;
import by.vsu.mf.ammc.pm.domain.user.User;
import by.vsu.mf.ammc.pm.exception.ServiceException;
import by.vsu.mf.ammc.pm.service.ServiceLocator;
import by.vsu.mf.ammc.pm.service.user.TeamService;
import by.vsu.mf.ammc.pm.service.user.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Timofei on 08.06.2016.
 */
@WebServlet("/manager/team/edit.html")
public class TeamEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = null;
        try {
            id = Integer.parseInt(req.getParameter("id"));
        } catch(NumberFormatException e) {}
        ServiceLocator locator = null;
        try {
            locator = new ServiceLocator();
            if(id != null) {
                TeamService service = locator.getService(TeamService.class);
                Team type = service.findById(id);
                req.setAttribute("team", type);
            }
            UserService userService = locator.getService(UserService.class);
            List<User> users = userService.findAll();
            req.setAttribute("users", users);
        } catch(ServiceException e) {
            throw new ServletException(e);
        } finally {
            try { locator.close(); } catch(NullPointerException | ServiceException e) {}
        }
        req.getRequestDispatcher("/WEB-INF/jsp/manager/team/edit.jsp").forward(req, resp);
    }
}

