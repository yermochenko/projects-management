package by.vsu.mf.ammc.pm.servlet.team;

import javax.servlet.annotation.WebServlet;

/**
 * Created by Timofei on 10.06.2016.
 */
@WebServlet("/manager/team/list.html")
public class TeamListServlet extends BaseTeamListServlet {
    @Override
    protected String forwardedUrl() {
        return "/WEB-INF/jsp/manager/team/list.jsp";
    }
}
