package com.uisrael.Controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uisrael.Entity.LogCargaExcel;
import com.uisrael.Entity.ResultadoKpi;
import com.uisrael.Service.LogCargaExcelService;
import com.uisrael.Service.ResultadoKPIService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/cargaExcel")
public class LogCargaExcelController {
    @Autowired
    private LogCargaExcelService logCargaExcelService;
    
    @Autowired
    private ResultadoKPIService resultadoKpiService;

    @GetMapping
    public List<LogCargaExcel> listar() {
        return logCargaExcelService.findAll();
    }
    
    @GetMapping("/")
    public String cargaExcel(Model model) {
        return "CargaExcel";
    }
    
    @PostMapping("/cargarExcel")
    public String procesarExcel(@RequestParam("archivo") MultipartFile archivo, RedirectAttributes redir) {
        try {
        	
        	logCargaExcelService.cargarDesdeExcel(archivo.getInputStream(),Long.parseLong("1"),archivo.getName());
            redir.addFlashAttribute("mensaje", "Archivo procesado correctamente.");
        } catch (Exception e) {
            redir.addFlashAttribute("mensaje", "Error al procesar el archivo: " + e.getMessage());
        }
        return "redirect:/cargaExcel/carts";
    }
    
    @GetMapping("/carts")
    public String Carts(Model model,HttpSession session) {
    	Long idUsuario = (Long) session.getAttribute("idUsuario");
    	String codigoPeriodo =LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM"));
    	List<ResultadoKpi> listaResultadoKpi = resultadoKpiService.listarPorUsuarioYPeriodo(idUsuario, codigoPeriodo);
    	double[] valoresMeses = new double[12];
    	
    	for (int m = 1; m <= 12; m++) {
    		final int mes = m;
    	    double suma = listaResultadoKpi.stream()
    	        .filter(k -> k.getPeriodoMes() != null && k.getPeriodoMes().equals(mes))
    	        .mapToDouble(ResultadoKpi::getPuntosCalculados)
    	        .sum();

    	    valoresMeses[mes - 1] = suma;
    	}
    	System.out.print(listaResultadoKpi);
    	List<String> etiquetas = List.of("Ene", "Feb", "Mar", "Abr","May","Jun","Jul","Ago","Sep","Oct","Nov","Dic");
	    List<Double> valores = List.of(
	    		valoresMeses[0],
	    		valoresMeses[1],
	    		valoresMeses[2],
	    		valoresMeses[3],
	    		valoresMeses[4],
	    		valoresMeses[5],
	    		valoresMeses[6],
	    		valoresMeses[7],
	    		valoresMeses[8],
	    		valoresMeses[9],
	    		valoresMeses[10],
	    		valoresMeses[11]);
    	    
	    model.addAttribute("labels", etiquetas);
	    model.addAttribute("data", valores);
    	model.addAttribute("content", "charts");
        return "base";
    }
}