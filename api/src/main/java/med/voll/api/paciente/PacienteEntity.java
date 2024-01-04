package med.voll.api.paciente;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
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

@Entity(name ="paciente")
@Table(name="pacientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PacienteEntity
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String cpf;
	private String telefone;
	@Embedded
	private Endereco endereco;
	private Boolean ativo;
	
	public PacienteEntity(DadosCadastroPaciente dados)
	{
		this.ativo =  true;
		this.nome = dados.nome();
		this.email = dados.email();
		this.cpf = dados.cpf();
		this.telefone = dados.telefone();
		this.endereco = new Endereco(dados.endereco());
	}

	public void atualizarInformacoes(@Valid DadosAtualizarPaciente dados)
	{
		if(dados.nome()!=null)
		{
			this.nome = dados.nome();
		}
		if(dados.telefone()!=null)
		{
			this.telefone = dados.telefone();
		}
		if(dados.endereco()!= null)
		{
			this.endereco.atualizarEndereco(dados.endereco());
		}
		
	}

	public void excluir()
	{
		this.ativo = false;
	}


}
  