package com.unifecaf.estoqueveiculos.repository;

import com.unifecaf.estoqueveiculos.model.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {
}
