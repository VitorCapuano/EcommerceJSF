package br.com.ecommerce.modelo;

import java.sql.Date;

public class Funcionario {
	private Date dt_admissao;
	private int matricula;
	private Pessoa pessoa;
	public Date getDt_admissao() {
		return dt_admissao;
	}
	public void setDt_admissao(Date dt_admissao) {
		this.dt_admissao = dt_admissao;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dt_admissao == null) ? 0 : dt_admissao.hashCode());
		result = prime * result + matricula;
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
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
		Funcionario other = (Funcionario) obj;
		if (dt_admissao == null) {
			if (other.dt_admissao != null)
				return false;
		} else if (!dt_admissao.equals(other.dt_admissao))
			return false;
		if (matricula != other.matricula)
			return false;
		if (pessoa == null) {
			if (other.pessoa != null)
				return false;
		} else if (!pessoa.equals(other.pessoa))
			return false;
		return true;
	}
	
	
}
