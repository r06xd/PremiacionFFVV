package com.uisrael.Controller;

import com.uisrael.Entity.Kpi;
import com.uisrael.Service.EmpresaService;
import com.uisrael.Service.KPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/kpis")
public class KPIThymeleafController {

    @Autowired
    private KPIService kpiService;

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("kpis", kpiService.findAll());
        return "kpi/listar";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("kpi", new Kpi());
        model.addAttribute("empresas", empresaService.listarTodas());
        return "kpi/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Kpi kpi) {
        kpiService.guardar(kpi);
        return "redirect:/kpis";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Kpi kpi = kpiService.findAll()
            .stream()
            .filter(k -> k.getId().equals(id)) // 
            .findFirst()
            .orElse(null);

        model.addAttribute("kpi", kpi);
        model.addAttribute("empresas", empresaService.listarTodas());
        return "kpi/formulario";
    }


    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        kpiService.eliminar(id);
        return "redirect:/kpis";
    }

}
