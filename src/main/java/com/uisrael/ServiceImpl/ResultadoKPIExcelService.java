package com.uisrael.ServiceImpl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.uisrael.Entity.ResultadoKpi;
import com.uisrael.Repository.ResultadoKPIRepository;

@Service
public class ResultadoKPIExcelService {

    @Autowired
    private ResultadoKPIRepository resultadoKPIRepository;

    public void cargarDesdeExcel(MultipartFile file) throws IOException {
       /* try (Workbook workbook = new XSSFWorkbook(file.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue; // Saltar cabecera

                ResultadoKpi resultado = new ResultadoKpi();
                resultado.setusuario_id((long) row.getCell(0).getNumericCellValue());
                resultado.setKpiId((long) row.getCell(1).getNumericCellValue());
                resultado.setValor(row.getCell(2).getNumericCellValue());
                resultado.setperiodoMes((int) row.getCell(3).getNumericCellValue());
                resultado.setperiodoAnio((int) row.getCell(4).getNumericCellValue());

                resultadoKPIRepository.save(resultado);
            }
        }
   */ }
}
