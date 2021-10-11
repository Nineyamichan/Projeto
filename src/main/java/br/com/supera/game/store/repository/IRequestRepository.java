package br.com.supera.game.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.supera.game.store.modelo.Request;
import br.com.supera.game.store.modelo.RequestPK;

public interface IRequestRepository extends JpaRepository<Request, RequestPK> {

}
