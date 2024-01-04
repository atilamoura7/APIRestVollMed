package med.voll.api.medico;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import med.voll.api.endereco.Endereco;

@Entity(name ="medico")
@Table(name="medicos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class MedicoEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String crm;
    @Enumerated(EnumType.STRING)
	private Especialidade especialidade;
	private String telefone;
	@Embedded
	private Endereco endereco;
	private Boolean ativo;
	public MedicoEntity(DadosCadastroMedico dados) {
		this.ativo = true;
		this.nome = dados.nome();
		this.email = dados.email();
		this.crm = dados.crm();
		this.especialidade = dados.especialidade();
		this.telefone = dados.telefone();
		this.endereco = new Endereco(dados.endereco());
	}
	public void atualizarInformacoes(@Valid DadosAtualizarMedico dados)
	{
		if(dados.nome()!=null)
		{
			this.nome = dados.nome();
		}
		if(dados.telefone()!=null)
		{
			this.telefone = dados.telefone();
		}
		if(dados.endereco()!=null)
		{
			this.endereco.atualizarEndereco(dados.endereco());
		}
	}
	public void excluir()
	{
		this.ativo=false;
		
	}
	
}
