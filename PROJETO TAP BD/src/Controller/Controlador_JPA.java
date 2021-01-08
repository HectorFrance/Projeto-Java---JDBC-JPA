package Controller;

import java.util.List;

import DAO.Controlador_CLientes;
import DAO.Controlador_Endereco;
import DAO.Controlador_Funcionario;
import DAO.Controlador_Pedidos;
import DAO.Controlador_Vendas;
import Model.Cliente;
import Model.Endereco;
import Model.Funcionario;
import Model.Pedido;
import Model.Vendas;

public class Controlador_JPA {
	Controlador_Endereco ce = new Controlador_Endereco();
	Controlador_CLientes cc = new Controlador_CLientes();
	Controlador_Funcionario cf = new Controlador_Funcionario();
	Controlador_Pedidos cp = new Controlador_Pedidos();
	Controlador_Vendas cv = new Controlador_Vendas();

	public void END_adicionar(Endereco i) {
		ce.END_adicioanr(i);
	}

	public List<Endereco> END_listarTudo() {
		return ce.END_listarTudo();
	}

	public void END_encerrar() {
		ce.END_encerrar();
	}

	public List<Endereco> END_pesquisaCidade(String c) {

		return ce.END_pesquisaCidade(c);
	}

	public void END_remover(int cod) {
		ce.END_remover(cod);

	}

	public List<Endereco> END_pesquisaBairro(String c) {

		return ce.END_pesquisaBairro(c);
	}

	public List<Endereco> END_pesquisaRua(String c) {

		return ce.END_pesquisaRua(c);
	}

	public void END_alterar(String c, int cod) {
		ce.END_alterar(c, cod);

	}

	public List<Cliente> CL_ListarTudo() {
		return cc.CL_listarTudo();
	}

	public List<Cliente> CL_pesquisaNome(String c) {
		return cc.CL_pesquisaNome(c);
	}

	public List<Cliente> CL_pesquisaCpf(String c) {
		return cc.CL_pesquisaCpf(c);
	}

	public List<Cliente> CL_pesquisaTelefone(String c) {
		return cc.CL_pesquisaTelefone(c);
	}

	public void CL_remover(int cod) {
		cc.CL_remover(cod);
	}

	public void CL_alterar(String c, int cod) {
		cc.CL_alterar(c, cod);
	}

	public void CL_Adicionar(Cliente i) {
		cc.CL_adicioanr(i);
	}

	public List<Funcionario> FUNC_ListarTudo() {
		return cf.FUNC_listarTudo();
	}

	public List<Funcionario> FUNC_pesquisaNome(String c) {
		return cf.FUNC_pesquisaNome(c);
	}

	public List<Funcionario> FUNC_pesquisaCpf(String c) {
		return cf.FUNC_pesquisaCpf(c);
	}

	public List<Funcionario> FUNC_pesquisaSetor(String c) {
		return cf.FUNC_pesquisaSetor(c);
	}

	public void FUNC_remover(int cod) {
		cf.FUNC_remover(cod);
	}

	public void FUNC_alterar(String c, int cod) {
		cf.FUNC_alterar(c, cod);
	}

	public void FUNC_Adicionar(Funcionario i) {
		cf.FUNC_adicioanr(i);
	}

	public List<Pedido> p_ListarTudo() {
		return cp.P_listarTudo();
	}

	public List<Pedido> P_pesquisaTipo(String c) {
		return cp.P_pesquisaTipo(c);
	}

	public List<Pedido> P_pesquisaCod(int c) {
		return cp.P_pesquisaCod(c);
	}

	public List<Pedido> P_pesquisaPreco(float c) {
		return cp.P_pesquisaPreco(c);
	}

	public void P_remover(int cod) {
		cp.P_remover(cod);
	}

	public void P_alterar(double d, int cod) {
		cp.P_alterar(d, cod);
	}

	public void P_Adicionar(Pedido i) {
		cp.P_adicioanr(i);
	}

	public List<Vendas> V_ListarTudo() {
		return cv.V_listarTudo();
	}

	public List<Vendas> V_pesquisaCliente(String c) {
		return cv.V_pesquisaClente(c);
	}

	public List<Vendas> V_pesquisaCodVendendor(int c) {
		return cv.V_pesquisaCodVendedor(c);
	}

	public List<Vendas> V_pesquisaCodEndereco(int c) {
		return cv.V_pesquisaEndereco(c);
	}

	public void V_remover(int cod) {
		cv.V_remover(cod);
	}

	public void V_alterar(double d, int cod) {
		cv.V_alterar(d, cod);
	}

	public void V_Adicionar(Vendas i) {
		cv.V_adicioanr(i);
	}
}
