package com.application;

import java.util.Date;

import com.entities.Departamento;
import com.entities.Vendedor;

public class Programa {

	public static void main(String[] args) {
		Departamento obj = new Departamento(1, "Erick");
		Vendedor vendedor = new Vendedor(1, "Erick", "email@email.com", new Date(), 2000.0, obj);
		System.out.println(obj);
		System.out.println(vendedor);
	}

}
