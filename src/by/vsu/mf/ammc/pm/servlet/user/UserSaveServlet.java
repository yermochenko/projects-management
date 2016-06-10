package by.vsu.mf.ammc.pm.servlet.user;

import by.vsu.mf.ammc.pm.domain.user.User;
import by.vsu.mf.ammc.pm.exception.ServiceException;
import by.vsu.mf.ammc.pm.service.ServiceLocator;
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
@WebServlet("/user/save.html")
public class UserSaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = null;
//        Integer user_id = null;
        Integer group_id = null;
        Boolean is_admin = null;
        try {
            id = Integer.parseInt(req.getParameter("id"));
//            user_id = Integer.parseInt(req.getParameter("user_id"));
            group_id = Integer.parseInt(req.getParameter("group_id"));
            is_admin = Boolean.parseBoolean(req.getParameter("is_admin"));
        } catch(NumberFormatException e) {}
        String name = req.getParameter("name");
        String password = req.getParameter("regexp");
        String first_name = req.getParameter("first_name");
        String middle_name = req.getParameter("middle_name");
        String last_name = req.getParameter("last_name");


        if(name != null && password != null && first_name != null && middle_name != null && last_name != null ) {
            User type = new User();
            type.setId(id);
            type.setName(name);
            type.setPassword(password);
            type.setFirstName(first_name);
            type.setMiddleName(middle_name);
            type.setLastName(last_name);
//            type.setGroup(UserGroupService.findById(group_id));
            type.setAdmin(is_admin);
            ServiceLocator locator = null;
            try {
                locator = new ServiceLocator();
                UserService service = locator.getService(UserService.class);
                service.save(type);
            } catch(ServiceException e) {
                throw new ServletException(e);
            } finally {
                try { locator.close(); } catch(NullPointerException | ServiceException e) {}
            }
        }
        resp.sendRedirect(req.getContextPath() + "/user/list.html");
    }
}
