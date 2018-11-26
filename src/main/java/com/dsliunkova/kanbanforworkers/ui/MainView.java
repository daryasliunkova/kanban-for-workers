package com.dsliunkova.kanbanforworkers.ui;

import com.dsliunkova.kanbanforworkers.services.UserService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinRequest;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;

@Route
public class MainView extends VerticalLayout {
    private UserService userService;
    private CarLayout carLayout;

    @Autowired
    public MainView(UserService userService, CarLayout carLayout) {
        this.userService = userService;
        this.carLayout = carLayout;


        Dialog dialog = new Dialog();
        dialog.setWidth("400px");
        dialog.setHeight("200px");

        FormLayout layoutWithFormItems = new FormLayout();

        TextField login = new TextField();
        login.setPlaceholder("Login");
        layoutWithFormItems.addFormItem(login, "Login");


        PasswordField password = new PasswordField();
        password.setPlaceholder("Password");
        layoutWithFormItems.addFormItem(password, "Password");

        VerticalLayout buttonLayout = new VerticalLayout();
        Button okbutton = new Button("OK", buttonClickEvent -> {
            String loginText = login.getValue();
            String passwordText = password.getValue();

            Notification.show(userService.getUserByLoginAndPassword(loginText, passwordText).toString());
            VaadinService.getCurrentRequest().setAttribute("user", userService.getUserByLoginAndPassword(loginText, passwordText));
            add(carLayout.showCars());
            dialog.close();
        });

        buttonLayout.setWidth("100%");
        buttonLayout.setHorizontalComponentAlignment(FlexComponent.Alignment.CENTER, okbutton);
        buttonLayout.add(okbutton);
        dialog.add(layoutWithFormItems);
        dialog.add(buttonLayout);
        dialog.open();

        add(dialog);
    }

 /*   protected void init(VaadinRequest request) {
        VerticalLayout verticalLayout = new VerticalLayout();

        Dialog dialog = new Dialog();
        dialog.setWidth("400px");
        dialog.setHeight("200px");

        FormLayout layoutWithFormItems = new FormLayout();

        TextField login = new TextField();
        login.setPlaceholder("Login");
        layoutWithFormItems.addFormItem(login, "Login");


        PasswordField password = new PasswordField();
        password.setPlaceholder("Password");
        layoutWithFormItems.addFormItem(password, "Password");

        VerticalLayout buttonLayout = new VerticalLayout();
        Button okbutton = new Button("OK", buttonClickEvent -> {
            String loginText = login.getValue();
            String passwordText = password.getValue();

            Notification.show(userService.getUserByLoginAndPassword(loginText, passwordText).toString());
            VaadinService.getCurrentRequest().setAttribute("user", userService.getUserByLoginAndPassword(loginText, passwordText));
            // getUI().ifPresent(ui -> ui.navigate("car"));
            add(carLayout.showCars());
            dialog.close();
        });

        buttonLayout.setWidth("100%");
        buttonLayout.setHorizontalComponentAlignment(FlexComponent.Alignment.CENTER, okbutton);
        buttonLayout.add(okbutton);
        dialog.add(layoutWithFormItems);
        dialog.add(buttonLayout);
        dialog.open();
        verticalLayout.add(dialog);
        add(verticalLayout);
    }*/

}