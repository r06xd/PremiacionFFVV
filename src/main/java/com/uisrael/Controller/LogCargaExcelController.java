package com.uisrael.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.Entity.LogCargaExcel;
import com.uisrael.Service.LogCargaExcelService;

@RestController
@RequestMapping("/api/logs-carga")
public class LogCargaExcelController {
    @Autowired
    private LogCargaExcelService logCargaExcelService;

    @GetMapping
    public List<LogCargaExcel> listar() {
        return logCargaExcelService.Listar();
    }
}