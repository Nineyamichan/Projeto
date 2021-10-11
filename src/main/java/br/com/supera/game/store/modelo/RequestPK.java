package br.com.supera.game.store.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;

/**
 * The primary key class for the tb_request database table.
 * 
 */
@Embeddable
public class RequestPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="tb_client_id", insertable=false, updatable=false)
	private int tbClientId;

	public RequestPK() {
	}
	public RequestPK(int tbClientId) {
		this.tbClientId = tbClientId;
	}
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTbClientId() {
		return this.tbClientId;
	}
	public void setTbClientId(int tbClientId) {
		this.tbClientId = tbClientId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RequestPK)) {
			return false;
		}
		RequestPK castOther = (RequestPK)other;
		return 
			(this.id == castOther.id)
			&& (this.tbClientId == castOther.tbClientId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.id;
		hash = hash * prime + this.tbClientId;
		
		return hash;
	}
}