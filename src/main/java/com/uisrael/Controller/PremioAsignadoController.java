package com.uisrael.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.Entity.PremioAsignado;
import com.uisrael.Service.PremioAsignadoService;

@RestController
@RequestMapping("/api/premios-asignados")
public class PremioAsignadoController {
    @Autowired
    private PremioAsignadoService premioAsignadoService;

    @GetMapping
    public List<PremioAsignado> listar() {
        return premioAsignadoService.findAll();
    }

    @PostMapping
    public PremioAsignado crear(@RequestBody PremioAsignado premioAsignado) {
        return premioAsignadoService.save(premioAsignado);
    }
}
