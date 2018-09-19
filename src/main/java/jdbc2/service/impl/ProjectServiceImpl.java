package jdbc2.service.impl;

import jdbc2.dao.impl.ProjectDaoImpl;
import jdbc2.model.Project;
import jdbc2.service.ProjectService;

public class ProjectServiceImpl implements ProjectService {
    @Override
    public void addProjAndSay(Project project) {
        new ProjectDaoImpl().save(project);
        System.out.println("Hello Project");
    }
}
