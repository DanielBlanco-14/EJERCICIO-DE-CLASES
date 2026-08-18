package com.example.demo.config;

import com.example.demo.service.ProductoService;
import com.example.demo.service.UsuarioService;
import com.example.demo.service.VentaService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.repository.UsuarioRepository;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.repository.VentaRepository;


@Configuration
public class AppConfig {

    @Bean
    public UsuarioService usuarioService(
            UsuarioRepository usuarioRepository) {
        return new UsuarioService(usuarioRepository);
    }

    @Bean
    public ProductoService productoService(
            ProductoRepository productoRepository) {
        return new ProductoService(productoRepository);
    }

    @Bean
    public VentaService ventaService(
            VentaRepository ventaRepository,
            ProductoRepository productoRepository,
            UsuarioRepository usuarioRepository) {
        return new VentaService(ventaRepository, productoRepository, usuarioRepository);
    }
}
