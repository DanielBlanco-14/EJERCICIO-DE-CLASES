package com.example.demo.controller;

import com.example.demo.service.ProductoService;
import com.example.demo.service.UsuarioService;
import com.example.demo.service.VentaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ventas")
public class VentaController {

    private final VentaService ventaService;
    private final UsuarioService usuarioService;
    private final ProductoService productoService;

    public VentaController(VentaService ventaService,
                           UsuarioService usuarioService,
                           ProductoService productoService) {
        this.ventaService = ventaService;
        this.usuarioService = usuarioService;
        this.productoService = productoService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("ventas", ventaService.listar());
        return "ventas/lista";
    }

    @GetMapping("/nueva")
    public String nueva(Model model) {
        model.addAttribute("usuarios", usuarioService.listar());
        model.addAttribute("productos", productoService.listar());
        return "ventas/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@RequestParam Long usuarioId,
                          @RequestParam Long productoId,
                          @RequestParam Integer cantidad,
                          Model model) {
        try {
            ventaService.realizarVenta(usuarioId, productoId, cantidad);
            return "redirect:/ventas";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("usuarios", usuarioService.listar());
            model.addAttribute("productos", productoService.listar());
            return "ventas/formulario";
        }
    }
}
