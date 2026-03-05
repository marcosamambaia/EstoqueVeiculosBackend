package com.unifecaf.estoqueveiculos.controller;

import com.unifecaf.estoqueveiculos.model.Modelo;
import com.unifecaf.estoqueveiculos.model.Marca;
import com.unifecaf.estoqueveiculos.repository.ModeloRepository;
import com.unifecaf.estoqueveiculos.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController indica que essa classe expõe endpoints REST
@RestController
@RequestMapping("/modelos") // todos os endpoints começam com /modelos
public class ModeloController {

    // Injeta automaticamente o repositório JPA para Modelo
    @Autowired
    private ModeloRepository modeloRepository;

    // Injeta o repositório JPA para Marca (necessário para buscar a marca pelo ID)
    @Autowired
    private MarcaRepository marcaRepository;

    // Endpoint POST para criar um novo modelo
    @PostMapping(consumes = "application/json", produces = "application/json")
    public Modelo criar(@RequestBody Modelo modelo) {
        // Buscar a marca pelo ID enviado no JSON
        Marca marca = marcaRepository.findById(modelo.getMarca().getId())
                .orElseThrow(() -> new RuntimeException("Marca não encontrada"));

        // Vincular a marca ao modelo
        modelo.setMarca(marca);

        // Salvar e retornar o modelo já vinculado à marca
        return modeloRepository.save(modelo);
    }

    // Endpoint GET para listar todos os modelos
    @GetMapping(produces = "application/json")
    public List<Modelo> listar() {
        return modeloRepository.findAll();
    }

    // Endpoint GET para buscar um modelo por ID
    @GetMapping(value = "/{id}", produces = "application/json")
    public Modelo buscarPorId(@PathVariable Long id) {
        return modeloRepository.findById(id).orElse(null);
    }

    // Endpoint PUT para atualizar um modelo existente
    @PutMapping(value = "/{id}", consumes = "application/json", produces = "application/json")
    public Modelo atualizar(@PathVariable Long id, @RequestBody Modelo modelo) {
        // Buscar a marca novamente para garantir vínculo correto
        Marca marca = marcaRepository.findById(modelo.getMarca().getId())
                .orElseThrow(() -> new RuntimeException("Marca não encontrada"));

        modelo.setId(id); // garante que o ID seja o mesmo
        modelo.setMarca(marca); // garante que a marca esteja vinculada

        return modeloRepository.save(modelo);
    }

    // Endpoint DELETE para remover um modelo
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        modeloRepository.deleteById(id);
    }
}
