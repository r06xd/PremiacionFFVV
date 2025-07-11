package com.uisrael.Controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.uisrael.ServiceImpl.ResultadoKPIExcelService;

@RestController
@RequestMapping("/api/excel/resultados-kpi")
public class ResultadoKPIExcelController {

    @Autowired
    private ResultadoKPIExcelService excelService;

    @PostMapping("/cargar")
    public ResponseEntity<String> cargar(@RequestParam("file") MultipartFile file) {
        try {
            excelService.cargarDesdeExcel(file);
            return ResponseEntity.ok("Carga masiva de resultados KPI exitosa");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al cargar el archivo: " + e.getMessage());
        }
    }
}