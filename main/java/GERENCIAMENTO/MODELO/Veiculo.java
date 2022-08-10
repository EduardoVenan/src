package gerenciamentodefrota.model;

import gerenciamentodefrota.model.enums.Propriedade;
import gerenciamentodefrota.model.enums.SituacaoVeiculo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotEmpty;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@Entity
@XStreamAlias("veiculo")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Audited
@AuditTable(value = "veiculo_audit", schema = "auditoria")
public class Veiculo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(unique = true, length = 8)
	@NotEmpty
	@Pattern(regexp = "^[a-zA-Z]{3}\\-\\d{4}$", message = "Placa inválida")
	private String placa;
	
	@Column
	@NotEmpty
	private String descricao;

	@Column
	@NotEmpty
	private String marca;

	@Column
	@NotEmpty
	private String modelo;

	@Column
	@NotEmpty
	private String cor;

	@Column
	@NotNull
	private Integer anoFabricacao;

	@Column
	@NotNull
	private Integer anoModelo;

	@Column
	@NotEmpty
	private String chassi;

	@Column
	@NotEmpty
	private String renavam;

	@Column
	@NotNull
	@Min(value = 1)
	private Integer capacidadeTanque;

	@Column
	private String observacao;

	@Enumerated(EnumType.STRING)
	@NotNull
	private Propriedade propriedade;

	@Enumerated(EnumType.STRING)
	@NotNull
	private SituacaoVeiculo situacao;

	@ManyToOne(fetch = FetchType.EAGER)
	private Combustivel combustivel;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		if (placa != null) {
			this.placa = placa.toUpperCase();
		}
	}

	public Integer getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(Integer anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public Integer getAnoModelo() {
		return anoModelo;
	}

	public void setAnoModelo(Integer anoModelo) {
		this.anoModelo = anoModelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Integer getCapacidadeTanque() {
		return capacidadeTanque;
	}

	public void setCapacidadeTanque(Integer capacidadeTanque) {
		this.capacidadeTanque = capacidadeTanque;
	}

	public Propriedade getPropriedade() {
		return propriedade;
	}

	public void setPropriedade(Propriedade propriedade) {
		this.propriedade = propriedade;
	}

	public SituacaoVeiculo getSituacao() {
		return situacao;
	}

	public void setSituacao(SituacaoVeiculo situacao) {
		this.situacao = situacao;
	}

	public Combustivel getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(Combustivel combustivel) {
		this.combustivel = combustivel;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
