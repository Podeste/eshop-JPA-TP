package eshop.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("four")
public class Fournisseur extends Personne {
	private String societe;
	@OneToMany(mappedBy = "fournisseur")
	private Set<Produit> produits = new HashSet<>();

	public Fournisseur() {
		super();
	}

	public String getSociete() {
		return societe;
	}

	public void setSociete(String societe) {
		this.societe = societe;
	}

	public Set<Produit> getProduits() {
		return produits;
	}

	public void setProduits(Set<Produit> produits) {
		this.produits = produits;
	}

}
