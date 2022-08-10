package gerenciamentodefrota.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;
import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.joda.time.LocalDateTime;

@Entity
@Audited
@AuditTable(value = "hodometro_audit", schema = "auditoria")
public class Hodometro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@NotNull(message = "{campo.obrigatorio}")
	@DecimalMin(value="0.01", message="{campo.maior.que}")
	private BigDecimal quilometragem;
	
	@ManyToOne
	private Veiculo veiculo;
	
	@NotNull
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	private LocalDateTime dataLeitura;
	
	@NotNull
	@Type(type="org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	private LocalDateTime dataGravacao;
	
	@ManyToOne
	private Usuario usuario;
	
	public Hodometro() {
		this.dataGravacao = LocalDateTime.now();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public BigDecimal getQuilometragem() {
		return quilometragem;
	}

	public void setQuilometragem(BigDecimal quilometragem) {
		this.quilometragem = quilometragem;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public LocalDateTime getDataLeitura() {
		return dataLeitura;
	}

	public void setDataLeitura(LocalDateTime dataLeitura) {
		this.dataLeitura = dataLeitura;
	}

	public LocalDateTime getDataGravacao() {
		return dataGravacao;
	}

	public void setDataGravacao(LocalDateTime dataGravacao) {
		this.dataGravacao = dataGravacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
