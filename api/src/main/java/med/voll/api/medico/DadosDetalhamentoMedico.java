package med.voll.api.medico;

import med.voll.api.endereco.Endereco;

public record DadosDetalhamentoMedico(Long id, String nome, String Email, String crm, String telefone, Especialidade especialidade, Endereco endereco)
{
	public DadosDetalhamentoMedico(MedicoEntity medico)
	{
		this(medico.getId(),medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(), medico.getEspecialidade(), medico.getEndereco());
	}

	
}
