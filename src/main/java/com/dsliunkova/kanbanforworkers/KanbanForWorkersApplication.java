package com.dsliunkova.kanbanforworkers;

import com.dsliunkova.kanbanforworkers.services.UserService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.time.LocalDateTime;

@SpringBootApplication
public class KanbanForWorkersApplication {

    @Autowired
    private static UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(KanbanForWorkersApplication.class, args);
	}
}
