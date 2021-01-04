package com.devsuperior.dsdeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsdeliver.dto.OrderDTO;
import com.devsuperior.dsdeliver.entities.Order;
import com.devsuperior.dsdeliver.repositories.OrderRepository;

@Service
public class OrderService {
	
	// Inserindo a injeção de dependência
	@Autowired
	private OrderRepository repository;
	
	// Não faz lock de escrita
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll() {
		List<Order> list = repository.findOrdersWithProducts();
		
		// Usando expressão Lambda
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}
}
