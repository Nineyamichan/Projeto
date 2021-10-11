package br.com.supera.game.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.supera.game.store.modelo.Client;

public interface IClientRepository extends JpaRepository<Client, Long> {

}
