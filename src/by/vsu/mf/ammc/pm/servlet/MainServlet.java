package by.vsu.mf.ammc.pm.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/index.html")
public class MainServlet extends HttpServlet {
	private static Map<String, List<MainMenuItem>> menu;

	static {
		menu = new HashMap<>();
	}

	@Override
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<MainMenuItem> menuItems = null;
		HttpSession session = req.getSession(false);
		if(session != null) {
			menuItems = (List<MainMenuItem>)session.getAttribute("menu");
		}
		if(menuItems != null) {
			resp.sendRedirect(req.getContextPath() + menuItems.get(0).getUrl());
			return;
		} else {
			String param = req.getParameter("role");
			if(param != null) {
				menuItems = menu.get(param);
				if(menuItems != null) {
					session = req.getSession();
					session.setAttribute("menu", menuItems);
					resp.sendRedirect(req.getContextPath());
					return;
				}
			}
		}
		req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);
	}
}
