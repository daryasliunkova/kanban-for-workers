package com.dsliunkova.kanbanforworkers.ui;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@org.springframework.stereotype.Component
@Route("main")
public class HeaderLayout extends VerticalLayout {
    @Autowired
    public HeaderLayout(CarLayout carLayout, CaseLayout caseLayout, HistoryLayout historyLayout) {
      /*  AppLayout appLayout = new AppLayout();
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
        add(appLayout);*/

      Tab tab1 = new Tab("Tab one");
        Div page1 = carLayout.showCars();


        Tab tab2 = new Tab("Tab two");
        Div page2 = caseLayout.showCases();
        page2.setVisible(false);

        Tab tab3 = new Tab("Tab three");
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
}
