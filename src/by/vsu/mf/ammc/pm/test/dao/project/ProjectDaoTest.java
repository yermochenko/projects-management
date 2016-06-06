package by.vsu.mf.ammc.pm.test.dao.project;

import by.vsu.mf.ammc.pm.dao.mysql.project.ProjectDaoImpl;
import by.vsu.mf.ammc.pm.domain.project.Project;
import by.vsu.mf.ammc.pm.domain.project.ProjectsCategory;
import by.vsu.mf.ammc.pm.domain.user.User;
import by.vsu.mf.ammc.pm.exception.DaoException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Pasha_R on 03.06.2016.
 */
public class ProjectDaoTest {
    public static void main(String[] args) throws DaoException, SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pm_db?useUnicode=true&characterEncoding=UTF-8", "root", "");
        ProjectDaoImpl dao = new ProjectDaoImpl();
        dao.setConnection(connection);
        Project p = new Project();
        p.setName("Проект");
        p.setDescription("Описание проекта");
        p.setManager(new User());
        p.getManager().setId(6);
        p.setCategory(new ProjectsCategory());
        p.getCategory().setId(10);
        dao.create(p);
        connection.close();
    }
}
