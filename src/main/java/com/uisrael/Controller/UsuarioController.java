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
import java.security.Principal;
import java.util.Optional;

import com.uisrael.Entity.Usuario;
import com.uisrael.Entity.Usuario.Rol;
import com.uisrael.Service.EmpresaService;
import com.uisrael.Service.UsuarioService;

import jakarta.servlet.http.HttpSession;
@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	 @Autowired
	    private UsuarioService usuarioService;
	 @Autowired
	 private EmpresaService empresaService;
	 
	    @GetMapping
	    public String listar(Model model) {
	    	System.out.print("entra a listar usuarios");
	        model.addAttribute("usuario", usuarioService.listarTodos());
	        return "CargaExcel";//"usuarios/listar";
	    }
	    
	    @GetMapping("/login")
	    public String mostrarLogin(Model model) {
	    	model.addAttribute("usuario", new Usuario());
	    	return "login";
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
	    
	    @PostMapping("/index")
	    public String dashboard(Model model, Usuario principal,RedirectAttributes redirectAttributes, HttpSession session) {
	        System.out.print("entra a dashboard");
	        Optional<Usuario> usuario = usuarioService.buscarPorCorreo(principal.getCorreo());
	        if(usuario.isPresent() && usuario.get().getContrasena().equals(principal.getContrasena()))
	        {
	        	
	        	model.addAttribute("usuarioLogueado", usuario.get().getCorreo());
	        	model.addAttribute("idUsuarioLogeado", usuario.get().getId());
	        	session.setAttribute("idUsuario", usuario.get().getId());
	        	return "index";
	        }
	        model.addAttribute("usuario", new Usuario());
	        redirectAttributes.addFlashAttribute("mensajeError", "Las credenciales no son las correctas o el usuario no existe");
	        return "redirect:/usuarios/login";
	    }
	    
	    @GetMapping("/registro")
	    public String mostrarFormularioRegistro(Model model) {
	        model.addAttribute("usuario", new Usuario());
	        model.addAttribute("empresas", empresaService.listarTodas()); // Debes tener este método
	        return "registro";
	    }


	    @PostMapping("/registro")
	    public String registrarUsuario(@ModelAttribute Usuario usuario) {
	    	System.out.print("entra a registro");
	        usuario.setRol(Rol.VENDEDOR); // por defecto
	        usuario.setContrasena(usuario.getContrasena());
	        usuarioService.guardar(usuario);
	        return "redirect:/login";
	    }


}
