package com.projetojpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.repository.TurmaRepository;
import com.projetojpa.entities.Turma;


@Service
public class TurmaService {
	
	private final TurmaRepository TurmaRepository;
	
	@Autowired
	public TurmaService (TurmaRepository TurmaRepository) {
		this.TurmaRepository = TurmaRepository;
	}
	
	    public List<Turma> getAllTurma() {
	        return TurmaRepository.findAll();
	    }

	    public Turma getTurmaById(Long id) {
	        Optional<Turma> Turma = TurmaRepository.findById(id);
	        return Turma.orElse(null);
	    }

	    public Turma salvarTurma(Turma Turma) {
	        return TurmaRepository.save(Turma);
	    }

	    public Turma updateTurma(Long id, Turma updatedTurma) {
	        Optional<Turma> existingTurma = TurmaRepository.findById(id);
	        if (existingTurma.isPresent()) {
	            updatedTurma.setId(id);
	            return TurmaRepository.save(updatedTurma);
	        }
	        return null;
	    }
	    public boolean deleteTurma(Long id) {
	        Optional<Turma> existingTurma = TurmaRepository.findById(id);
	        if (existingTurma.isPresent()) {
	        	TurmaRepository.deleteById(id);
	            return true;
	        }
	        return false;
	    }

	}