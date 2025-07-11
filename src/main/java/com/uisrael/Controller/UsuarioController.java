package com.uisrael.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uisrael.Entity.Usuario;
import com.uisrael.Service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	 @Autowired
	    private UsuarioService usuarioService;

	    @GetMapping
	    public String listar(Model model) {
	        model.addAttribute("usuario", usuarioService.listarTodos());
	        return "CargaExcel";//"usuarios/listar";
	    }
	    
	    @GetMapping("/cargarExcel")
	    public String cargaExcel(Model model) {
	        model.addAttribute("usuario", usuarioService.listarTodos());
	        return "CargaExcel";
	    }
	    
	    @PostMapping("/cargarExcel")
	    public String procesarExcel(@RequestParam("archivo") MultipartFile archivo, RedirectAttributes redir) {
	        try {
	            usuarioService.cargarDesdeExcel(archivo.getInputStream());
	            redir.addFlashAttribute("mensaje", "Archivo procesado correctamente.");
	        } catch (Exception e) {
	            redir.addFlashAttribute("mensaje", "Error al procesar el archivo: " + e.getMessage());
	        }
	        return "redirect:/usuarios/CargaExcel";
	    }

	    @GetMapping("/nuevo")
	    public String nuevo(Model model) {
	        model.addAttribute("usuario", new Usuario());
	        return "usuarios/formulario";
	    }

	    @PostMapping("/guardar")
	    public String guardar(@ModelAttribute Usuario usuario) {
	    	usuarioService.guardar(usuario);
	        return "redirect:/usuarios";
	    }

	    @GetMapping("/editar/{id}")
	    public String editar(@PathVariable Long id, Model model) {
	        Usuario usuario = usuarioService.buscarPorId(id).orElse(null);
	        model.addAttribute("usuario", usuario);
	        return "usuarios/formulario";
	    }

	    @GetMapping("/eliminar/{id}")
	    public String eliminar(@PathVariable Long id) {
	    	usuarioService.eliminar(id);
	        return "redirect:/usuarios";
	    }
}
