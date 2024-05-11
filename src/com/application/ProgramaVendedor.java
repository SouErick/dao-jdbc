package com.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.dao.FeitoriaDao;
import com.dao.VendedorDao;
import com.entities.Departamento;
import com.entities.Vendedor;
/**
 * @author Erick Sousa Saraiva
 * @version 10/05/2024
 * {@summary Projeto CRUD que visa implementar a lógica DAO usando JDBC.}  
 */
public class ProgramaVendedor {

	public static void main(String[] args) {
		VendedorDao vendedorDao = FeitoriaDao.criarVendedorDao();
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		Vendedor novoVendedor = new Vendedor();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Departamento departamento = new Departamento();
		int idDesejado;
		System.out.println("--------------------------------------------------");
		System.out.println("               MENU VENDEDOR                      ");
		System.out.println("--------------------------------------------------");
		System.out.println("0 - SAIR");
		System.out.println("1 - INSERIR VENDEDOR");
		System.out.println("2 - ATUALIZAR VENDEDOR");
		System.out.println("3 - PROCURAR POR ID DO VENDEDOR");
		System.out.println("4 - DELETAR POR ID DO VENDEDOR");
		System.out.println("5 - MOSTRAR TODOS OS VENDEDORES");
		System.out.println("--------------------------------------------------");

		try {
			while (true) {
				System.out.print("O QUE DESEJA FAZER? ");
				int acao = Integer.parseInt(teclado.readLine());
				switch (acao) {
				case 0:
					System.out.println("FIM.");
					return;
				case 1:
					System.out.println("===== INSERIR VENDEDOR ====");
					System.out.print("Digite o nome do vendedor: ");
					String nomeVendedor = teclado.readLine();
					System.out.print("Digite o email do vendedor: ");
					String emailVendedor = teclado.readLine();
					System.out.print("Digite a data de nascimento: ");
					Date dataNascimento = sdf.parse(teclado.readLine());
					System.out.print("Digite o salário do vendedor: ");
					Double salarioVendedor = Double.parseDouble(teclado.readLine());
					System.out.print("Digite o ID do departamento do vendedor: ");
					int idDepartamento = Integer.parseInt(teclado.readLine());
					departamento.setId(idDepartamento);
					novoVendedor = new Vendedor(null, nomeVendedor, emailVendedor, dataNascimento, salarioVendedor,
							departamento);
					vendedorDao.inserir(novoVendedor);
					System.out.println("Vendedor inserido, ID: " + novoVendedor.getId());
					break;
				case 2:
					System.out.println("===== ATUALIZAR VENDEDOR ====");
					System.out.print("Digite o ID do vendedor que deseja atualizar: ");
					idDesejado = Integer.parseInt(teclado.readLine());
					novoVendedor = vendedorDao.acharPorId(idDesejado);
					System.out.print("Digite o novo nome do vendedor: ");
					nomeVendedor = teclado.readLine();
					System.out.print("Digite o novo email do vendedor: ");
					emailVendedor = teclado.readLine();
					System.out.print("Digite a data de nascimento: ");
					dataNascimento = sdf.parse(teclado.readLine());
					System.out.print("Digite o novo salário do vendedor: ");
					salarioVendedor = Double.parseDouble(teclado.readLine());
					System.out.print("Digite o novo ID do departamento do vendedor: ");
					idDepartamento = Integer.parseInt(teclado.readLine());
					departamento.setId(idDepartamento);
					novoVendedor.setNome(nomeVendedor);
					novoVendedor.setEmail(emailVendedor);
					novoVendedor.setDataNascimento(dataNascimento);
					novoVendedor.setSalarioBase(salarioVendedor);
					novoVendedor.setDepartamento(departamento);
					vendedorDao.atualizar(novoVendedor);
					System.out.println("Vendedor atualizado com sucesso.");
					break;
				case 3:
					System.out.println("===== PROCURAR POR ID DO VENDEDOR ====");
					System.out.print("Digite o ID do vendedor que deseja encontrar: ");
					idDesejado = Integer.parseInt(teclado.readLine());
					novoVendedor = vendedorDao.acharPorId(idDesejado);
					System.out.println(novoVendedor);
					break;
				case 4:
					System.out.println("===== DELETAR POR ID DO VENDEDOR ====");
					System.out.print("Digite o ID do vendedor que deseja deletar: ");
					idDesejado = Integer.parseInt(teclado.readLine());
					vendedorDao.deletarPorId(idDesejado);
					System.out.println("Vendedor com o ID " + idDesejado + " deletado com sucesso.");
					break;
				case 5:
					System.out.println("===== MOSTRAR TODOS OS VENDEDORES ====");
					List<Vendedor> listaVendedores = vendedorDao.acharTodos();
					for (Vendedor v : listaVendedores) {
						System.out.println(v);
					}
					break;
				default:
					System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("ERROR: " + e.getMessage());
		} finally {
			try {
				if (teclado != null) {
					teclado.close();
				}
			} catch (IOException e) {
				System.out.println("Erro ao fechar o BufferedReader: " + e.getMessage());
			}
		}
	}
}