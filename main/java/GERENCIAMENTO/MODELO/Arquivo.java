package gerenciamentodefrota.model;

import java.io.IOException;

@Entity
public class Arquivo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@NotEmpty
	private String nome;
	
	@NotNull
	private byte[] conteudo;
	
	@NotEmpty
	private String contentType;
	
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDateTime")
	private LocalDateTime dataModificacao;
	
	Arquivo() {
	}
	
	public Arquivo(UploadedFile uploaded) throws IOException {
		this.nome = uploaded.getFileName();
		this.conteudo = ByteStreams.toByteArray(uploaded.getFile());
		this.contentType = uploaded.getContentType();
		this.dataModificacao = LocalDateTime.now();
	}
	
	public Arquivo(String nome, byte[] conteudo, String contentType, LocalDateTime dataModificacao) {
		this.nome = nome;
		this.conteudo = conteudo;
		this.contentType = contentType;
		this.dataModificacao = dataModificacao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public byte[] getConteudo() {
		return conteudo;
	}

	public void setConteudo(byte[] conteudo) {
		this.conteudo = conteudo;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public LocalDateTime getDataModificacao() {
		return dataModificacao;
	}

	public void setDataModificacao(LocalDateTime dataModificacao) {
		this.dataModificacao = dataModificacao;
	}

}
