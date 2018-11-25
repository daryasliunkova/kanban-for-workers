package com.dsliunkova.kanbanforworkers.ui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.AppLayoutMenu;
import com.vaadin.flow.component.applayout.AppLayoutMenuItem;
import com.vaadin.flow.component.applayout.MenuItemClickEvent;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@Route("route")
public class MainView extends VerticalLayout {
    @Autowired
    public MainView(HeaderLayout headerLayout) {
        add(headerLayout);



       /* menu.addMenuItems(
                new AppLayoutMenuItem(VaadinIcon.CLIPBOARD_TEXT.create(), "History"),
                new AppLayoutMenuItem(VaadinIcon.SIGN_OUT.create(), "Sign out"));
        Component content = new Span(new H3("Page title"),
                new Span("Page content"));
        appLayout.setContent(content);
        add(appLayout);*/

       // AppLayoutMenuItem

    }

  /*  public Grid showUsers() {
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
    }*/

   /* public MainView() {
        add(new Button("Click me", e -> Notification.show(service.getUserById(1).toString())));
    }*/
}