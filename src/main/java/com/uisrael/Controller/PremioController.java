package com.uisrael.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.Entity.Premio;
import com.uisrael.Service.PremioService;

@RestController
@RequestMapping("/api/premios")
public class PremioController {
    @Autowired
    private PremioService premioService;

    @GetMapping
    public List<Premio> listar() {
        return premioService.findAll();
    }

    @PostMapping
    public Premio crear(@RequestBody Premio premio) {
        return premioService.guardar(premio);
    }
}
