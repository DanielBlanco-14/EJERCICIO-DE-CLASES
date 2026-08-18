package com.example.demo.service;

import com.example.demo.model.Producto;
import com.example.demo.model.Usuario;
import com.example.demo.model.Venta;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.repository.VentaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

public class VentaService {

    private final VentaRepository ventaRepository;
    private final ProductoRepository productoRepository;
    private final UsuarioRepository usuarioRepository;

    public VentaService(VentaRepository ventaRepository,
                        ProductoRepository productoRepository,
                        UsuarioRepository usuarioRepository) {
        this.ventaRepository = ventaRepository;
        this.productoRepository = productoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<Venta> listar() {
        return ventaRepository.findAllByOrderByFechaDesc();
    }

    @Transactional
    public Venta realizarVenta(Long usuarioId, Long productoId, Integer cantidad) {

        if (cantidad == null || cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que 0.");
        }

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado."));

        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado."));

        if (producto.getCantidad() < cantidad) {
            throw new IllegalArgumentException(
                    "Stock insuficiente. Disponible: " + producto.getCantidad());
        }

        producto.setCantidad(producto.getCantidad() - cantidad);
        productoRepository.save(producto);

        Venta venta = new Venta();
        venta.setUsuario(usuario);
        venta.setProducto(producto);
        venta.setCantidad(cantidad);
        venta.setPrecioUnitario(producto.getPrecio());
        venta.setTotal(producto.getPrecio().multiply(BigDecimal.valueOf(cantidad)));

        return ventaRepository.save(venta);
    }
}
