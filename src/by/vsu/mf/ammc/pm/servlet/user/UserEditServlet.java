package by.vsu.mf.ammc.pm.servlet.user;

import by.vsu.mf.ammc.pm.domain.user.ContactsType;
import by.vsu.mf.ammc.pm.domain.user.User;
import by.vsu.mf.ammc.pm.exception.ServiceException;
import by.vsu.mf.ammc.pm.service.ServiceLocator;
import by.vsu.mf.ammc.pm.service.user.ContactsTypeService;
import by.vsu.mf.ammc.pm.service.user.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Борис on 08.06.2016.
 */
@WebServlet("/user/edit.html")
public class UserEditServlet extends HttpServlet {

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
                UserService service = locator.getService(UserService.class);
                User type = service.findById(id);
                req.setAttribute("type", type);
            } catch (ServiceException e) {
                throw new ServletException(e);
            } finally {
                try {
                    locator.close();
                } catch (NullPointerException | ServiceException e) {
                }
            }
        }
        req.getRequestDispatcher("/WEB-INF/jsp/user/edit.jsp").forward(req, resp);
    }
}
