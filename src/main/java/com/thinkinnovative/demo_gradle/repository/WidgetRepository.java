package com.thinkinnovative.demo_gradle.repository;

import com.thinkinnovative.demo_gradle.dto.WidgetsListDTO;
import com.thinkinnovative.demo_gradle.entity.Widget;
import com.thinkinnovative.demo_gradle.service.serviceImpl.WidgetService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WidgetRepository extends JpaRepository<Widget, Integer> {

    @Query("SELECT new com.thinkinnovative.demo_gradle.dto.WidgetsListDTO(w.widget_name, w.description, w.created_at, w.updated_at, w.is_active)" +
            "FROM Widget w " +
            "WHERE w.is_active=1")
    List<WidgetsListDTO> getWidgets();

}
