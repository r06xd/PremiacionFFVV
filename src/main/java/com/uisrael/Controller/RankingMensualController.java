package com.uisrael.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.Entity.RankingMensual;
import com.uisrael.Service.RankingService;

@RestController
@RequestMapping("/api/rankings")
public class RankingMensualController {
    @Autowired
    private RankingService rankingMensualService;

    @GetMapping
    public List<RankingMensual> listar() {
        return rankingMensualService.findAll();
    }

    @PostMapping
    public RankingMensual crear(@RequestBody RankingMensual rankingMensual) {
        return rankingMensualService.guardar(rankingMensual);
    }
}
