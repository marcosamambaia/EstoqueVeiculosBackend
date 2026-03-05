package com.unifecaf.estoqueveiculos.repository;

import com.unifecaf.estoqueveiculos.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    // Aqui você pode adicionar consultas personalizadas depois, se precisar
}
