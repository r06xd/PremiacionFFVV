package com.uisrael.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.Entity.Empresa;
import com.uisrael.Service.EmpresaService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/empresas")
public class EmpresaController {

    @Autowired
    private EmpresaService empresaService;

    @GetMapping("/")
    public String listarEmpresas(Model model) {
        model.addAttribute("empresas", empresaService.listarTodas());
        model.addAttribute("empresas", empresaService.listarTodas());
        model.addAttribute("content", "empresas/listar");
        return "base";
    }

    @GetMapping("/nueva")
    public String mostrarFormularioNueva(Model model) {
        model.addAttribute("empresa", new Empresa());
        model.addAttribute("content", "empresas/formulario");
        return "base";
    }

    @PostMapping("/guardar")
    public String guardarEmpresa(@ModelAttribute Empresa empresa, Model model) {
        empresaService.guardar(empresa);
        model.addAttribute("content", "empresas/");
        return "base";
    }

    @GetMapping("/editar/{id}")
    public String editarEmpresa(@PathVariable Long id, Model model) {
        Empresa empresa = empresaService.listarTodas()
            .stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);

        model.addAttribute("empresa", empresa);
        model.addAttribute("content", "empresas/formulario");
        return "base";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEmpresa(@PathVariable Long id) {
        empresaService.eliminar(id); // Añade este método en tu service si aún no lo tienes
        return "redirect:/empresas/";
    }
}
