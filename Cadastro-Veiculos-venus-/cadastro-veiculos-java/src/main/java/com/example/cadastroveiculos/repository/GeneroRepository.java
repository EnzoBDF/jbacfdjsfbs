package com.example.cadastroveiculos.repository;
import com.example.cadastroveiculos.model.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface GeneroRepository extends JpaRepository<Genero, Long> {
}
