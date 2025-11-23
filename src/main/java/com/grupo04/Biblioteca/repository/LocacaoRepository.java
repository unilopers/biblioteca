package com.grupo04.Biblioteca.repository;

import com.grupo04.Biblioteca.models.LocacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocacaoRepository extends JpaRepository<LocacaoModel, Long> {
}
