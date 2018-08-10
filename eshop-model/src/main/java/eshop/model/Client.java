package eshop.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@DiscriminatorValue("cli")
public class Client extends Personne {
	@Temporal(TemporalType.DATE)
	private Date dtNaissance;
	@ManyToMany
	@JoinTable(	name = "achat", 	
				joinColumns = @JoinColumn(name = "client_id"), 
				inverseJoinColumns = @JoinColumn(name = "produit_id"), 
				uniqueConstraints = @UniqueConstraint(columnNames = { "client_id", "produit_id" }))
	private List<Produit> produits = new ArrayList<>();

	public Client() {
		super();
	}

	public Date getDtNaissance() {
		return dtNaissance;
	}

	public void setDtNaissance(Date dtNaissance) {
		this.dtNaissance = dtNaissance;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

}
