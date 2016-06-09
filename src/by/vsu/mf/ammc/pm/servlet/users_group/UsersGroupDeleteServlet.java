package by.vsu.mf.ammc.pm.servlet.users_group;

import by.vsu.mf.ammc.pm.domain.user.UsersGroup;
import by.vsu.mf.ammc.pm.exception.ServiceException;
import by.vsu.mf.ammc.pm.service.ServiceLocator;
import by.vsu.mf.ammc.pm.service.user.ContactsTypeService;
import by.vsu.mf.ammc.pm.service.user.TeamService;
import by.vsu.mf.ammc.pm.service.user.UsersGroupService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Влад on 08.06.2016.
 */
@WebServlet("/users_group/delete.html")
public class UsersGroupDeleteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = null;
        try {
            id = Integer.parseInt(req.getParameter("id"));
        } catch(NumberFormatException e) {}
        if(id != null) {
            ServiceLocator locator = null;
            try {
                locator = new ServiceLocator();
                UsersGroupService service = locator.getService(UsersGroupService.class);
                service.delete(id);
            } catch(ServiceException e) {
                throw new ServletException(e);
            } finally {
                try { locator.close(); } catch(NullPointerException | ServiceException e) {}
            }
        }
        resp.sendRedirect(req.getContextPath() + "/users_group/list.html");
    }
}


