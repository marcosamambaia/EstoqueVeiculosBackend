package com.unifecaf.estoqueveiculos.service;

import com.unifecaf.estoqueveiculos.model.Veiculo;
import com.unifecaf.estoqueveiculos.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // indica que esta classe é um serviço
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    // Criar ou atualizar veículo
    public Veiculo salvar(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    // Buscar todos os veículos
    public List<Veiculo> listarTodos() {
        return veiculoRepository.findAll();
    }

    // Buscar veículo por ID
    public Optional<Veiculo> buscarPorId(Long id) {
        return veiculoRepository.findById(id);
    }

    // Deletar veículo por ID
    public void deletar(Long id) {
        veiculoRepository.deleteById(id);
    }
}
