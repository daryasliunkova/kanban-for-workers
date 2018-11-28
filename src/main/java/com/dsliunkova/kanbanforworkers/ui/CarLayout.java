package com.dsliunkova.kanbanforworkers.ui;

import com.dsliunkova.kanbanforworkers.entities.Car;
import com.dsliunkova.kanbanforworkers.entities.User;
import com.dsliunkova.kanbanforworkers.services.CarService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Route("car")
public class CarLayout extends VerticalLayout {
    private CarService carService;
    private HeaderLayout headerLayout;
    private CaseLayout caseLayout;

    public CarLayout() {

    }

    @Autowired
    public CarLayout(CarService carService, HeaderLayout headerLayout, CaseLayout caseLayout) {
        this.carService = carService;
        this.headerLayout = headerLayout;
        this.caseLayout = caseLayout;
    }


    public VerticalLayout showCars() {
        Grid<Car> cars = new Grid<>();
        cars.addSelectionListener(selectionEvent -> {
            VaadinService.getCurrentRequest().setAttribute("car", selectionEvent.getFirstSelectedItem().get());
            removeAll();
            add(caseLayout.showCases());
        });

        int id = ((User) VaadinService.getCurrentRequest().getAttribute("user")).getId();
        List<Car> listCars = carService.getCarsByOwnerId(id);
        System.out.println(listCars);
        cars.setItems(carService.getCarsByOwnerId(id));
        cars.addColumn(Car::getVin).setHeader("VIN");
        cars.addColumn(Car::getColor).setHeader("Color");
        cars.addColumn(Car::getMake).setHeader("Make");
        cars.addColumn(Car::getModel).setHeader("Model");
        cars.addColumn(Car::getCarNumber).setHeader("Number");

        removeAll();
        add(headerLayout);
        add(cars);

        return this;
    }


}
