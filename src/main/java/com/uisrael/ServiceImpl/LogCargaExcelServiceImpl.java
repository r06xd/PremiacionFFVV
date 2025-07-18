package com.uisrael.ServiceImpl;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uisrael.Entity.LogCargaExcel;
import com.uisrael.Entity.LogCargaExcel.EstadoCarga;
import com.uisrael.Entity.ResultadoKpi;
import com.uisrael.Entity.Usuario;
import com.uisrael.Repository.KPIRepository;
import com.uisrael.Repository.LogCargaExcelRepository;
import com.uisrael.Repository.ResultadoKPIRepository;
import com.uisrael.Repository.UsuarioRepository;
import com.uisrael.Service.LogCargaExcelService;

@Service
public class LogCargaExcelServiceImpl implements LogCargaExcelService {
	
	@Autowired
	private ResultadoKPIRepository resultadoKPIRepository;
	
	@Autowired
	private KPIRepository kPIRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private LogCargaExcelRepository logCargaExcelRepository;

	@Override
	public LogCargaExcel registrar(LogCargaExcel log) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LogCargaExcel> listarPorUsuario(Long usuarioId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LogCargaExcel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void cargarDesdeExcel(InputStream inputStream, Long idUsuario, String nombreArchivo) {
	    try (Workbook workbook = new XSSFWorkbook(inputStream)) {
	    	
	        Sheet sheet = workbook.getSheetAt(0);
	        
	        for (Row row : sheet) {
	            if (row.getRowNum() == 0) continue; // omitir cabecera

	            
	            ResultadoKpi u = new ResultadoKpi();
	            u.setPeriodoAnio((int) row.getCell(0).getNumericCellValue());
	            
	            u.setPeriodoMes((int) row.getCell(1).getNumericCellValue());
	            System.out.print("entra");
	            u.setPuntosCalculados((int)row.getCell(2).getNumericCellValue());
	            System.out.print("entra2");
	            u.setValorObtenido(row.getCell(3).getNumericCellValue());
	            System.out.print("entra3");
	            u.setKpi(kPIRepository.getById((long)row.getCell(4).getNumericCellValue()));
	            System.out.print("entra4");
	            u.setUsuario(usuarioRepository.getById(idUsuario));
	            System.out.print("entra5");
	            u.setPeriodo(row.getCell(5).getStringCellValue());
	            System.out.print("entra6");
	            //u.setContrasena(Usuario.Rol.valueOf(row.getCell(2).getStringCellValue().toUpperCase()));

	            LogCargaExcel logGuardar = new LogCargaExcel();
	            logGuardar.setEstado(EstadoCarga.PROCESADO);
	            logGuardar.setErrores("Sin error");
	            logGuardar.setFechaCarga(LocalDateTime.now());
	            logGuardar.setNombreArchivo(nombreArchivo);
	            logGuardar.setUsuario(usuarioRepository.getById(idUsuario));
	            
	            resultadoKPIRepository.save(u);
	            logCargaExcelRepository.save(logGuardar);
	            
	        }
	    } catch (IOException e) {
	    	System.out.print(e.getMessage());
	    	LogCargaExcel logGuardar = new LogCargaExcel();
            logGuardar.setEstado(EstadoCarga.ERROR);
            logGuardar.setErrores(e.getMessage());
            logGuardar.setFechaCarga(LocalDateTime.now());
            logGuardar.setNombreArchivo(nombreArchivo);
            logGuardar.setUsuario(usuarioRepository.getById(idUsuario));
            logCargaExcelRepository.save(logGuardar);
            
	        throw new RuntimeException("Error al leer Excel", e);
	    }
	}

}
