package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vendas")
public class Vendas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod;
	@Column
	int cod_pedido;
	@Column
	String nome_Cliente;
	@Column
	String nome_Vendedor;
	@Column
	int cod_vendedor;
	@Column
	int cod_Cliente;
	@Column
	int cod_endereco;
	@Column
	double preco;

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public int getCod_pedido() {
		return cod_pedido;
	}

	public void setCod_pedido(int cod_pedido) {
		this.cod_pedido = cod_pedido;
	}

	public String getNome_Cliente() {
		return nome_Cliente;
	}

	public void setNome_Cliente(String nome_Cliente) {
		this.nome_Cliente = nome_Cliente;
	}

	public String getNome_Vendedor() {
		return nome_Vendedor;
	}

	public void setNome_Vendedor(String nome_Vendedor) {
		this.nome_Vendedor = nome_Vendedor;
	}

	public int getCod_vendador() {
		return cod_vendedor;
	}

	public void setCod_vendador(int cod_vendador) {
		this.cod_vendedor = cod_vendador;
	}

	public int getCod_Cliente() {
		return cod_Cliente;
	}

	public void setCod_Cliente(int cod_Cliente) {
		this.cod_Cliente = cod_Cliente;
	}

	public int getCod_endereco() {
		return cod_endereco;
	}

	public void setCod_endereco(int cod_endereco) {
		this.cod_endereco = cod_endereco;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

}
