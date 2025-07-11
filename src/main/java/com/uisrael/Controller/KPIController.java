package com.uisrael.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.Entity.Kpi;
import com.uisrael.Service.KPIService;

@RestController
@RequestMapping("/api/kpis")
public class KPIController {
    @Autowired
    private KPIService kpiService;

    @GetMapping
    public List<Kpi> listar() {
        return kpiService.Listar();
    }

    @PostMapping
    public Kpi crear(@RequestBody Kpi kpi) {
        return kpiService.Guardar(kpi);
    }
}