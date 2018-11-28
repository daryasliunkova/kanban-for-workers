package com.dsliunkova.kanbanforworkers.ui;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.AppLayoutMenu;
import com.vaadin.flow.component.applayout.AppLayoutMenuItem;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class HeaderLayout extends VerticalLayout{
    public HeaderLayout() {
        AppLayout appLayout = new AppLayout();
        AppLayoutMenu menu = appLayout.createMenu();
        AppLayoutMenuItem userMenuItem = new AppLayoutMenuItem(VaadinIcon.USER_CARD.create(), "User info");
        userMenuItem.setRoute("user");
        AppLayoutMenuItem carMenuItem = new AppLayoutMenuItem(VaadinIcon.CAR.create(), "My cars");
        carMenuItem.setRoute("car");
        AppLayoutMenuItem caseMenuItem = new AppLayoutMenuItem(VaadinIcon.COGS.create(), "Cases");
        caseMenuItem.setRoute("case");
        AppLayoutMenuItem historyMenuItem = new AppLayoutMenuItem(VaadinIcon.ARCHIVE.create(), "History");
        caseMenuItem.setRoute("history");
        menu.addMenuItems(userMenuItem, carMenuItem, caseMenuItem, historyMenuItem);
        add(appLayout);
    }
}
