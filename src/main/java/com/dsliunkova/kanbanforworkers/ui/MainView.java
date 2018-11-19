package com.dsliunkova.kanbanforworkers.ui;

import com.dsliunkova.kanbanforworkers.KanbanForWorkersApplication;
import com.dsliunkova.kanbanforworkers.entities.User;
import com.dsliunkova.kanbanforworkers.repositories.UserRepository;
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

    @Autowired
    public MainView(UserService service) {
        this.service = service;
      //  add(new Button("Click me", e -> Notification.show(service.getUserById(1).toString())));

        Grid<User> grid = new Grid<>();
        grid.setItems(service.getUsers());

        grid.addColumn(User::getName).setHeader("Name");
        grid.addColumn(User::getSurname).setHeader("Surname");
        grid.addColumn(User::getRole).setHeader("Role");

        add(grid);
    }

    public MainView() {
        add(new Button("Click me", e -> Notification.show(service.getUserById(1).toString())));
    }
}