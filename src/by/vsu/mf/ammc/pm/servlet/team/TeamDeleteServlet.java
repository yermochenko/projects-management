package by.vsu.mf.ammc.pm.servlet.team;

import by.vsu.mf.ammc.pm.exception.ServiceException;
import by.vsu.mf.ammc.pm.service.ServiceLocator;
import by.vsu.mf.ammc.pm.service.user.ContactsTypeService;
import by.vsu.mf.ammc.pm.service.user.TeamService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Timofei on 08.06.2016.
 */

    @WebServlet("/team/delete.html")
    public class TeamDeleteServlet extends HttpServlet {
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
                    TeamService service = locator.getService(TeamService.class);
                    service.delete(id);
                } catch(ServiceException e) {
                    throw new ServletException(e);
                } finally {
                    try { locator.close(); } catch(NullPointerException | ServiceException e) {}
                }
            }
            resp.sendRedirect(req.getContextPath() + "/team/list.html");
        }
    }


