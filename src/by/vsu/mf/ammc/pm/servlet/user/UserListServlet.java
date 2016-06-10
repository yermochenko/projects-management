package by.vsu.mf.ammc.pm.servlet.user;

import by.vsu.mf.ammc.pm.domain.user.ContactsType;
import by.vsu.mf.ammc.pm.domain.user.User;
import by.vsu.mf.ammc.pm.domain.user.UsersGroup;
import by.vsu.mf.ammc.pm.exception.ServiceException;
import by.vsu.mf.ammc.pm.service.ServiceLocator;
import by.vsu.mf.ammc.pm.service.user.ContactsTypeService;
import by.vsu.mf.ammc.pm.service.user.UserService;
import by.vsu.mf.ammc.pm.service.user.UsersGroupService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Борис on 08.06.2016.
 */
@WebServlet("/user/list.html")
public class UserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServiceLocator locator = null;
        try {
            locator = new ServiceLocator();
            UserService service = locator.getService(UserService.class);
            List<User> types = service.findAll();
            req.setAttribute("users", types);

            UsersGroupService usersGroupService = locator.getService(UsersGroupService.class);
            List<UsersGroup> groups  = usersGroupService.findAll();
            req.setAttribute("groups", groups);
            req.getRequestDispatcher("/WEB-INF/jsp/user/list.jsp").forward(req, resp);

        } catch(ServiceException e) {
            throw new ServletException(e);
        } finally {
            try { locator.close(); } catch(NullPointerException | ServiceException e) {}
        }
    }
}
