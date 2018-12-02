package com.dsliunkova.kanbanforworkers.ui;

import com.dsliunkova.kanbanforworkers.entities.Cache;
import com.dsliunkova.kanbanforworkers.entities.Case;
import com.dsliunkova.kanbanforworkers.services.CaseService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.data.selection.SelectionListener;
import com.vaadin.flow.server.VaadinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("prototype")
public class CaseLayout {
    private CaseService caseService;
    private HistoryLayout historyLayout;
    private Cache cache;

    public CaseLayout() {

    }

    @Autowired
    public CaseLayout(CaseService caseService, HistoryLayout historyLayout, Cache cache) {
        this.caseService = caseService;
        this.cache = cache;
        this.historyLayout = historyLayout;
    }

    public Div showCases() {
        Grid<Case> cases = new Grid<>();
        cases.addSelectionListener((SelectionListener<Grid<Case>, Case>) selectionEvent -> {
            VaadinService.getCurrentRequest().setAttribute("case", selectionEvent.getFirstSelectedItem().get());
        });

        //Car carId = ((Car) VaadinService.getCurrentRequest().getAttribute("car"));
        if (cache.getCar() != null) {
            List<Case> listCars = caseService.getCasesByOwnerAndCar(cache.getCar().getId());
            cases.setItems(listCars);
            cases.addColumn(Case::getName).setHeader("Problem");
            cases.addColumn(Case::getDescription).setHeader("Description");
            cases.addColumn(Case::getStartDate).setHeader("Created by");
            cases.addColumn(Case::getEndDate).setHeader("End date");
            cases.addColumn(Case::getStatus).setHeader("Status");
        }

        Div div = new Div();
        div.add(cases);
        return div;
    }
}
