package com.example.carros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.carros.model.Proprietario;

public interface Proprietarios extends JpaRepository<Proprietario,Long>{}
