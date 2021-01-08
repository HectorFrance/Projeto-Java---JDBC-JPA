package Controller;

import java.util.List;

import DAO.ControladorFabricante;
import DAO.Controlador_Acessorios;
import DAO.Controlador_Computador;
import DAO.Controlador_Consoles;
import DAO.Controlador_Impressora;
import Model.Acessorios;
import Model.Computadores;
import Model.Consoles;
import Model.Fabricante;
import Model.Impressora;

public class Controlador {
	static Controlador_Impressora ci = new Controlador_Impressora();
	static ControladorFabricante cf = new ControladorFabricante();
	static Controlador_Computador cp = new Controlador_Computador();
	static Controlador_Acessorios ca = new Controlador_Acessorios();
	static Controlador_Consoles cs = new Controlador_Consoles();

	public void adcionarFAB(Fabricante fab) {
		cf.adcinarFAB(fab);
	}

	public void removerFAB(int cod) {
		cf.removerFAB(cod);
	}

	public List<Fabricante> FABlistarTudo() {

		return cf.FABlistarTudo();
	}

	public List<Fabricante> FABpesquisaNOME(String nome) {
		return cf.FABpesquisaNOME(nome);
	}

	public List<Impressora> pesquisaPreco(int preco) {
		return ci.IMPpesquisaPreco(preco);
	}

	public List<Impressora> pesquisaCodFab(int fab) {
		return ci.IMPpesquisaCodFab(fab);
	}

	public List<Impressora> IMP_pesquisaModelo(String modelo) {
		return ci.IMPpesquisaModelo(modelo);
	}

	public List<Impressora> IMPlistarTudo() {

		return ci.IMPlistarTudo();
	}

	public void adcionarIMP(Impressora i) {
		ci.adcinarIMP(i);
	}

	public void removerIMP(int cod) {
		ci.removerIMP(cod);
	}

	public void COMP_mudarPreco(int cod, int preco) {
		cp.mudarPreco_COMP(preco, cod);
	}

	public List<Computadores> COMP_pesquisaModelo(String modelo) {
		return cp.pesquisaModelo_COMP(modelo);
	}

	public List<Computadores> COMP_pesquisaPreco(int preco) {
		return cp.COMP_pesquisaPreco(preco);
	}

	public List<Computadores> COMP_pesquisaCodFab(int fab) {
		return cp.pesquisaCodFab_COMP(fab);
	}

	public List<Computadores> COMP_listarTudo() {

		return cp.listarTudo_COMP();
	}

	public void COMP_adcionar(Computadores i) {
		cp.adcinar_COMP(i);
	}

	public void COMP_remover(int cod) {
		cp.removerCOMP(cod);
	}

	public void IMPmudarPreco(int cod, int preco) {
		cp.mudarPreco_COMP(preco, cod);
	}

	public List<Acessorios> AC_listarTudo() {
		return ca.listarTudo_AC();
	}

	public List<Acessorios> AC_pesquisaPreco(int preco) {
		return ca.AC_pesquisaPreco(preco);
	}

	public List<Acessorios> AC_pesquisaCodFab(int fab) {
		return ca.pesquisaCodFab_AC(fab);
	}

	public List<Acessorios> AC_pesquisaModelo(String modelo) {
		return ca.pesquisaModelo_AC(modelo);
	}

	public void AC_adcionar(Acessorios i) {
		ca.adcionar_AC(i);
	}

	public void AC_remover(int cod) {
		ca.remover_AC(cod);
	}

	public void AC_alterar(int preco, int cod) {
		ca.mudarPreco_AC(preco, cod);
	}

	public List<Consoles> CS_listarTudo() {
		return cs.listarTudo_CS();
	}

	public List<Consoles> CS_pesquisaPreco(int preco) {
		return cs.CS_pesquisaPreco(preco);
	}

	public List<Consoles> CS_pesquisaCodFab(int fab) {
		return cs.pesquisaCodFab_CS(fab);
	}

	public List<Consoles> CS_pessquisaModelo(String modelo) {
		return cs.pesquisaModelo_CS(modelo);
	}

	public void CS_adcionar(Consoles i) {
		cs.adcionar_CS(i);
	}

	public void CS_remover(int cod) {
		cs.remover_CS(cod);
	}

	public void CS_alterar(int preco, int cod) {
		cs.mudarPreco_AC(preco, cod);
	}

}