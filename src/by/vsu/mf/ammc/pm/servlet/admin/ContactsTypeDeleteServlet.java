package by.vsu.mf.ammc.pm.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.vsu.mf.ammc.pm.exception.ServiceException;
import by.vsu.mf.ammc.pm.service.ServiceLocator;
import by.vsu.mf.ammc.pm.service.user.ContactsTypeService;

@WebServlet("/admin/contacts-type/delete.html")
public class ContactsTypeDeleteServlet extends HttpServlet {
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
				ContactsTypeService service = locator.getService(ContactsTypeService.class);
				service.delete(id);
			} catch(ServiceException e) {
				throw new ServletException(e);
			} finally {
				try { locator.close(); } catch(NullPointerException | ServiceException e) {}
			}
		}
		resp.sendRedirect(req.getContextPath() + "/admin/contacts-type/list.html");
	}
}