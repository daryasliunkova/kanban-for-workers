package com.dsliunkova.kanbanforworkers.ui;

import com.dsliunkova.kanbanforworkers.entities.Car;
import com.dsliunkova.kanbanforworkers.entities.User;
import com.dsliunkova.kanbanforworkers.services.CarService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CarLayout{
    private CarService carService;
    private CaseLayout caseLayout;

    public CarLayout() {

    }

    @Autowired
    public CarLayout(CarService carService, CaseLayout caseLayout) {
        this.carService = carService;
        this.caseLayout = caseLayout;
    }


    public Div showCars() {
        Grid<Car> cars = new Grid<>();
        cars.addSelectionListener(selectionEvent -> {
            VaadinService.getCurrentRequest().setAttribute("car", selectionEvent.getFirstSelectedItem().get());
        });

      //  User user = (User) VaadinService.getCurrentRequest().getAttribute("user");

            int id = 1;
            cars.setItems(carService.getCarsByOwnerId(id));
            cars.addColumn(Car::getVin).setHeader("VIN");
            cars.addColumn(Car::getColor).setHeader("Color");
            cars.addColumn(Car::getMake).setHeader("Make");
            cars.addColumn(Car::getModel).setHeader("Model");
            cars.addColumn(Car::getCarNumber).setHeader("Number");

        Div div = new Div();
        div.add(cars);
        return div;
    }


}
