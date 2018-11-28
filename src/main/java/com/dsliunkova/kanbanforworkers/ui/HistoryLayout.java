package com.dsliunkova.kanbanforworkers.ui;

import com.dsliunkova.kanbanforworkers.entities.Car;
import com.dsliunkova.kanbanforworkers.entities.Case;
import com.dsliunkova.kanbanforworkers.entities.HistoryItem;
import com.dsliunkova.kanbanforworkers.services.HistoryItemService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Route("history")
public class HistoryLayout extends VerticalLayout{
    private HeaderLayout headerLayout;
    private HistoryItemService historyItemService;

    @Autowired
    public HistoryLayout(HeaderLayout headerLayout, HistoryItemService historyItemService) {
        this.headerLayout = headerLayout;
        this.historyItemService = historyItemService;
    }

    public VerticalLayout showHistory() {
        add(headerLayout);
        Grid<HistoryItem> history = new Grid<>();

        Case caseId = ((Case) VaadinService.getCurrentRequest().getAttribute("case"));
        List<HistoryItem> listCars = historyItemService.getHistoryByCaseId(caseId.getId());

        history.setItems(listCars);
        history.addColumn(HistoryItem::getChangeDate).setHeader("Change date");
        history.addColumn(HistoryItem::getStatus).setHeader("Status");
        history.addColumn(HistoryItem::getDescription).setHeader("Description");
        add(history);
        return this;
    }
}
