package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import jdbc2.dao.factory.DaoFactory;
import jdbc2.model.Project;
import jdbc2.model.User;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class NewController implements Initializable {

    @FXML
    private TextArea txtList;

    @FXML
    private Button btnProjlist;

    @FXML
    private TextField txtProject;

    @FXML
    private TextField txtName;

    @FXML
    private Button btnCreate;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Hello");

        btnProjlist.setOnAction(event -> getList());

        btnCreate.setOnAction(event -> create());
    }

    private void create(){
        final String name = txtName.getText();
        final long projectId = Long.parseLong(txtProject.getText());
        User user = new User(name);
        DaoFactory.getUserDaoImpl().save(user);
        DaoFactory.getProjectDaoImpl().addUserOnProject(user, new Project(projectId));
    }

    private void getList() {

        List<Project> projects = DaoFactory.getProjectDaoImpl().findAll();
        System.out.println(projects);
        for (Project project : projects) {

            txtList.setText(projects.toString());
        }

//        System.out.println(about);
    }
}
