package com.example.demo.controller;

import com.example.demo.service.ProductoService;
import com.example.demo.service.UsuarioService;
import com.example.demo.service.VentaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final UsuarioService usuarioService;
    private final ProductoService productoService;
    private final VentaService ventaService;

    public HomeController(UsuarioService usuarioService,
                           ProductoService productoService,
                           VentaService ventaService) {
        this.usuarioService = usuarioService;
        this.productoService = productoService;
        this.ventaService = ventaService;
    }

    @GetMapping("/")
    public String inicio(Model model) {
        model.addAttribute("usuarios", usuarioService.listar().size());
        model.addAttribute("productos", productoService.listar().size());
        model.addAttribute("ventas", ventaService.listar().size());
        return "index";
    }
}
