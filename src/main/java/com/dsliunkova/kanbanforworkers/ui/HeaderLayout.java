package com.dsliunkova.kanbanforworkers.ui;

import com.dsliunkova.kanbanforworkers.entities.Cache;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@org.springframework.stereotype.Component
@Scope("prototype")
@Route("main")
public class HeaderLayout extends VerticalLayout {
    private  Tabs tabs;
    @Autowired
    public HeaderLayout(CarLayout carLayout, CaseLayout caseLayout, HistoryLayout historyLayout) {
        Tab tab1 = new Tab("Cars");
        Div page1 = carLayout.showCars();

        Tab tab2 = new Tab("Cases");
        Div page2 = caseLayout.showCases();
        page2.setVisible(false);

        Tab tab3 = new Tab("History");
        Div page3 = historyLayout.showHistory();
        page3.setVisible(false);

        Map<Tab, Div> tabsToPages = new HashMap<>();
        tabsToPages.put(tab1, page1);
        tabsToPages.put(tab2, page2);
        tabsToPages.put(tab3, page3);
        page1.setWidth("1000px");
        page2.setWidth("1000px");
        page3.setWidth("1000px");

        Tabs tabs = new Tabs(tab1, tab2, tab3);
        Div pages = new Div(page1, page2, page3);
        pages.setWidth("1000px");
        Set<Div> pagesShown = Stream.of(page1)
                .collect(Collectors.toSet());
        this.tabs = tabs;

        tabs.addSelectedChangeListener(event -> {
            pagesShown.forEach(page -> page.setVisible(false));
            pagesShown.clear();
            Div selectedPage = tabsToPages.get(tabs.getSelectedTab());
            selectedPage.setVisible(true);
            selectedPage.setWidth("1000px");
            pagesShown.add(selectedPage);
        });

        add(tabs);
        add(pages);
    }

    public Tabs getTabs() {
        return tabs;
    }
}
