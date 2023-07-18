package com.rbtec.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rbtec.dslist.dto.GameDTO;
import com.rbtec.dslist.dto.GameMinDTO;
import com.rbtec.dslist.entities.Game;
import com.rbtec.dslist.projections.GameMinProjection;
import com.rbtec.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get();
		GameDTO dto = new GameDTO(result);
		return dto;
		//ou pode deixar o 'return' como abaixo]
		//return new GameDTO(result);
		
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		List<Game> result = gameRepository.findAll();
		//List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
		//return dto;
		//ou
		return result.stream().map(x -> new GameMinDTO(x)).toList();
		
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId){
		List<GameMinProjection> result = gameRepository.searchByList(listId);
		return result.stream().map(x -> new GameMinDTO(x)).toList();
		
	}

}
