package com.dsliunkova.kanbanforworkers.ui;

import com.dsliunkova.kanbanforworkers.entities.Car;
import com.dsliunkova.kanbanforworkers.entities.Case;
import com.dsliunkova.kanbanforworkers.entities.User;
import com.dsliunkova.kanbanforworkers.services.CaseService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.selection.SelectionEvent;
import com.vaadin.flow.data.selection.SelectionListener;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.List;

@Component
public class CaseLayout {
    private CaseService caseService;
    private HistoryLayout historyLayout;

    public CaseLayout() {

    }

    @Autowired
    public CaseLayout(CaseService caseService, HistoryLayout historyLayout) {
        this.caseService = caseService;

        this.historyLayout = historyLayout;
    }

    public Div showCases() {


        Grid<Case> cases = new Grid<>();
        cases.addSelectionListener((SelectionListener<Grid<Case>, Case>) selectionEvent -> {
            VaadinService.getCurrentRequest().setAttribute("case", selectionEvent.getFirstSelectedItem().get());

        });

        //Car carId = ((Car) VaadinService.getCurrentRequest().getAttribute("car"));

            List<Case> listCars = caseService.getCasesByOwnerAndCar(1);
            cases.setItems(listCars);
            cases.addColumn(Case::getName).setHeader("Problem");
            cases.addColumn(Case::getDescription).setHeader("Description");
            cases.addColumn(Case::getStartDate).setHeader("Created by");
            cases.addColumn(Case::getEndDate).setHeader("End date");
            cases.addColumn(Case::getStatus).setHeader("Status");

        Div div = new Div();
        div.add(cases);
        return div;
    }
}
