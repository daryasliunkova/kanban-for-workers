package com.dsliunkova.kanbanforworkers.ui;

import com.dsliunkova.kanbanforworkers.entities.Car;
import com.dsliunkova.kanbanforworkers.entities.Case;
import com.dsliunkova.kanbanforworkers.entities.User;
import com.dsliunkova.kanbanforworkers.services.CarService;
import com.dsliunkova.kanbanforworkers.services.UserService;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.applayout.AppLayoutMenuItem;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.selection.SelectionEvent;
import com.vaadin.flow.data.selection.SelectionListener;
import com.vaadin.flow.router.Route;
import elemental.css.CSSStyleDeclaration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Route("car")
@Component
public class CarLayout extends VerticalLayout {
    public CarLayout() {

    }

    @Autowired
    public CarLayout(CarService carService, HeaderLayout headerLayout) {
        Grid<Car> cars = new Grid<>();
        int id = 1;
        List<Car> listCars = carService.getCarsByOwnerId(id);
        System.out.println(listCars);
        cars.setItems(carService.getCarsByOwnerId(id));
        cars.addColumn(Car::getVin).setHeader("VIN");
        cars.addColumn(Car::getColor).setHeader("Color");
        cars.addColumn(Car::getMake).setHeader("Make");
        cars.addColumn(Car::getModel).setHeader("Model");
        cars.addColumn(Car::getCarNumber).setHeader("Number");

       cars.addSelectionListener((SelectionListener<Grid<Car>, Car>) selectionEvent -> {
           Icon vaadinIcon = VaadinIcon.ARROW_CIRCLE_RIGHT_O.create();
            vaadinIcon.setSize("400");
            Button button = new Button(vaadinIcon);
            button.addClickListener((ComponentEventListener<ClickEvent<Button>>) buttonClickEvent -> {

            });
            button.setHeight("400");
            button.setWidth("400");
            VerticalLayout layoutButton = new VerticalLayout();
            layoutButton.add(button);
            layoutButton.setAlignItems(Alignment.END);
            button.addClickListener((ComponentEventListener<ClickEvent<Button>>) buttonClickEvent -> {
                button.getUI().ifPresent(ui -> ui.navigate(""));
            });
            add(layoutButton);
        });

        add(headerLayout);
        add(cars);
    }


}
