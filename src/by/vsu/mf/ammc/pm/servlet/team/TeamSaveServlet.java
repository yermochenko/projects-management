package by.vsu.mf.ammc.pm.servlet.team;

import by.vsu.mf.ammc.pm.dao.project.ProjectDao;
import by.vsu.mf.ammc.pm.domain.project.management.Team;
import by.vsu.mf.ammc.pm.domain.user.ContactsType;
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
@WebServlet("/contacts-type/save.html")
public class TeamSaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = null;
        Integer project_id = null;
        Integer leader_id = null;
        try {
            id = Integer.parseInt(req.getParameter("id"));
            project_id = Integer.parseInt(req.getParameter("project_id"));
            leader_id = Integer.parseInt(req.getParameter("leader_id"));
        } catch(NumberFormatException e) {}

        if(project_id != null && leader_id != null) {
            Team type = new Team();
            type.setId(id);
           // type.setProject(ProjectService.findById(project_id)); // Когда сделают!!!!
           // type.setLeader(UserService.findById(leader_id)); //Когда Борис сделает!!
            ServiceLocator locator = null;
            try {
                locator = new ServiceLocator();
                TeamService service = locator.getService(TeamService.class);
                service.save(type);
            } catch(ServiceException e) {
                throw new ServletException(e);
            } finally {
                try { locator.close(); } catch(NullPointerException | ServiceException e) {}
            }
        }
        resp.sendRedirect(req.getContextPath() + "/team/list.html");
    }
}
