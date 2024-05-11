package com.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.dao.DepartamentoDao;
import com.dao.FeitoriaDao;
import com.entities.Departamento;

/**
 * @author Erick Sousa Saraiva
 * @version 10/05/2024
 * {@summary Projeto CRUD que visa implementar a lógica DAO usando JDBC.}  
 */

public class ProgramaDepartamento {

	public static void main(String[] args) {
		DepartamentoDao departamentoDao = FeitoriaDao.criarDepartamentoDao();
		Departamento novoDepartamento = new Departamento();
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		int idDesejado;
		System.out.println("--------------------------------------------------");
		System.out.println("              MENU DEPARTAMENTO                   ");
		System.out.println("--------------------------------------------------");
		System.out.println("0 - SAIR");
		System.out.println("1 - INSERIR DEPARTAMENTO");
		System.out.println("2 - ATUALIZAR DEPARTAMENTO");
		System.out.println("3 - PROCURAR POR ID DO DEPARTAMENTO");
		System.out.println("4 - DELETAR POR ID DO DEPARTAMENTO");
		System.out.println("5 - MOSTRAR TODOS OS DEPARTAMENTOS");
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
					System.out.println("===== INSERIR DEPARTAMENTO ====");
					System.out.print("Digite um nome para o novo departamento: ");
					String nomeDepartamento = teclado.readLine();
					novoDepartamento = new Departamento(null, nomeDepartamento);
					departamentoDao.inserir(novoDepartamento);
					System.out.println("Inserindo novo departamento, id: " + novoDepartamento.getId());
					break;
				case 2:
					System.out.println("===== ATUALIZAR DEPARTAMENTO ====");
					System.out.print("Digite o id desejado: ");
					idDesejado = Integer.parseInt(teclado.readLine());
					novoDepartamento = departamentoDao.acharPorId(idDesejado);
					System.out.print("Digite o novo nome para o departamento do id " + idDesejado + " : ");
					nomeDepartamento = teclado.readLine();
					novoDepartamento.setNome(nomeDepartamento);
					departamentoDao.atualizar(novoDepartamento);
					System.out.println("Atualização feita.");
					break;
				case 3:
					System.out.println("===== PROCURAR POR ID DO DEPARTAMENTO ====");
					System.out.println("Digite o id a procurar: ");
					idDesejado = Integer.parseInt(teclado.readLine());
					novoDepartamento = departamentoDao.acharPorId(idDesejado);
					System.out.println(novoDepartamento);
					break;
				case 4:
					System.out.println("===== DELETAR POR ID DO DEPARTAMENTO ====");
					System.out.print("Digite o id a DELETAR: ");
					idDesejado = Integer.parseInt(teclado.readLine());
					departamentoDao.deletarPorId(idDesejado);
					System.out.println("Departamento com id " + idDesejado + " deletado.");
					break;
				case 5:
					System.out.println("===== MOSTRAR TODOS ====");
					List<Departamento> departamento = new ArrayList<>();
					departamento = departamentoDao.acharTodos();
					departamento.forEach(System.out::println);
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
