package com.dsliunkova.kanbanforworkers.ui;

import com.dsliunkova.kanbanforworkers.KanbanForWorkersApplication;
import com.dsliunkova.kanbanforworkers.entities.Case;
import com.dsliunkova.kanbanforworkers.entities.User;
import com.dsliunkova.kanbanforworkers.repositories.UserRepository;
import com.dsliunkova.kanbanforworkers.services.CaseService;
import com.dsliunkova.kanbanforworkers.services.UserService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class MainView extends VerticalLayout {
    private UserService service;
    private CaseService caseService;

    @Autowired
    public MainView(UserService service, CaseService caseService) {
        this.caseService = caseService;
        this.service = service;
        add(new Button("Users", e-> add(showUsers())));
        add(new Button("Cases", e -> add(showCases())));


    }

    public Grid showUsers() {
        Grid<User> grid = new Grid<>();
        grid.setItems(service.getUsers());

        grid.addColumn(User::getName).setHeader("Name");
        grid.addColumn(User::getSurname).setHeader("Surname");
        grid.addColumn(User::getRole).setHeader("Role");
        return grid;
       //add(grid);
    }

    public Grid showCases() {
        Grid<Case> cases = new Grid<>();
        cases.setItems(caseService.getCases());
        cases.addColumn(Case::getName);
        cases.addColumn(Case::getDescription);
        cases.addColumn(Case::getStartDate);
        cases.addColumn(Case::getEndDate);
        return cases;
    }

   /* public MainView() {
        add(new Button("Click me", e -> Notification.show(service.getUserById(1).toString())));
    }*/
}