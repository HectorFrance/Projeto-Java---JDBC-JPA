package Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "computadores")
public class Computadores {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cod;
	@Column
	private String modelo;
	@Column
	private int HD;
	@Column
	private int RAM;
	@Column
	private int cod_fab;
	@Column
	private double preco;

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getHD() {
		return HD;
	}

	public void setHD(int hD) {
		HD = hD;
	}

	public int getRAM() {
		return RAM;
	}

	public void setRAM(int rAM) {
		RAM = rAM;
	}

	public int getCod_fab() {
		return cod_fab;
	}

	public void setCod_fab(int cod_fab) {
		this.cod_fab = cod_fab;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

}
