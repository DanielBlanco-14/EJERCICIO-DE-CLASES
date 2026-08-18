package com.example.demo.config;

import com.example.demo.service.ProductoService;
import com.example.demo.service.UsuarioService;
import com.example.demo.service.VentaService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public UsuarioService usuarioService(
            com.example.demo.repository.UsuarioRepository usuarioRepository) {
        return new UsuarioService(usuarioRepository);
    }

    @Bean
    public ProductoService productoService(
            com.example.demo.repository.ProductoRepository productoRepository) {
        return new ProductoService(productoRepository);
    }

    @Bean
    public VentaService ventaService(
            com.example.demo.repository.VentaRepository ventaRepository,
            com.example.demo.repository.ProductoRepository productoRepository,
            com.example.demo.repository.UsuarioRepository usuarioRepository) {
        return new VentaService(ventaRepository, productoRepository, usuarioRepository);
    }
}
