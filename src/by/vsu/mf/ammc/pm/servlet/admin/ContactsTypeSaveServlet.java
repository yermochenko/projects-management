package by.vsu.mf.ammc.pm.servlet.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.vsu.mf.ammc.pm.domain.user.ContactsType;
import by.vsu.mf.ammc.pm.exception.ServiceException;
import by.vsu.mf.ammc.pm.service.ServiceLocator;
import by.vsu.mf.ammc.pm.service.user.ContactsTypeService;

@WebServlet("/admin/contacts-type/save.html")
public class ContactsTypeSaveServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		Integer id = null;
		try {
			id = Integer.parseInt(req.getParameter("id"));
		} catch(NumberFormatException e) {}
		String name = req.getParameter("name");
		String regexp = req.getParameter("regexp");
		if(name != null && regexp != null) {
			ContactsType type = new ContactsType();
			type.setId(id);
			type.setName(name);
			type.setRegexp(regexp);
			ServiceLocator locator = null;
			try {
				locator = new ServiceLocator();
				ContactsTypeService service = locator.getService(ContactsTypeService.class);
				service.save(type);
			} catch(ServiceException e) {
				throw new ServletException(e);
			} finally {
				try { locator.close(); } catch(NullPointerException | ServiceException e) {}
			}
		}
		resp.sendRedirect(req.getContextPath() + "/admin/contacts-type/list.html");
	}
}
