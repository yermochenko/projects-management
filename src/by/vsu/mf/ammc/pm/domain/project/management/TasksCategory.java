package by.vsu.mf.ammc.pm.domain.project.management;

import by.vsu.mf.ammc.pm.domain.HierarchyEntity;
import javafx.scene.Parent;

import javax.lang.model.element.Name;

public class TasksCategory extends HierarchyEntity<TasksCategory> {
    private Name name;
    private Parent parent;

    public Name getUser() {
        return name;
    }

    public void setUser(Name name) {
        this.name = name;
    }

    public Parent getTeam() {
        return parent;
    }

    public void setTeam(Parent parent) {
        this.parent = parent;
    }
}
