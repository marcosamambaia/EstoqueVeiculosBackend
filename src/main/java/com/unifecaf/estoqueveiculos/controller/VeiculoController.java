package com.unifecaf.estoqueveiculos.controller;

import com.unifecaf.estoqueveiculos.dto.VeiculoDTO;   // <-- importa o DTO
import com.unifecaf.estoqueveiculos.model.Veiculo;
import com.unifecaf.estoqueveiculos.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @GetMapping
    public List<VeiculoDTO> listar() {
        return veiculoRepository.findAll().stream()
                .map(VeiculoDTO::new)
                .toList();
    }

    @PostMapping
    public VeiculoDTO criar(@RequestBody Veiculo veiculo) {
        Veiculo salvo = veiculoRepository.save(veiculo);
        return new VeiculoDTO(salvo);
    }

    @GetMapping("/{id}")
    public VeiculoDTO buscarPorId(@PathVariable Long id) {
        return veiculoRepository.findById(id)
                .map(VeiculoDTO::new)
                .orElse(null);
    }

    @PutMapping("/{id}/vendido")
    public VeiculoDTO marcarComoVendido(@PathVariable Long id) {
        Veiculo veiculo = veiculoRepository.findById(id).orElseThrow();
        veiculo.setStatus("Vendido");
        Veiculo atualizado = veiculoRepository.save(veiculo);
        return new VeiculoDTO(atualizado);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        veiculoRepository.deleteById(id);
    }
}
