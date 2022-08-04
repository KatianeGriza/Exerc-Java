package exerc;

import exerc.dao.DaoAnimal;
import exerc.entidade.Animal;
import exerc.utilidades.Conexao;

public class exerc {

	public static void main(String[] args) {
		if(Conexao.conectar() != null) {
		System.out.println("Conectado");
	}
	else {
		System.out.println("Erro ao conectar");
		}
		Animal a1 = new Animal("Raposa Vermelha", "Raposa", "florestas");
		DaoAnimal dc = new DaoAnimal();
		if(dc.salvar(a1)) {
		System.out.println("Animal cadastrado com sucesso");
		}
		System.out.println(dc.consultar());
		/*Animal animal = dc.consultar(1);
		System.out.println(animal);
		
		animal.setNome("Raposa do Ártico");
		animal.setEspecie("Raposa branca");
		animal.setHabitat("Tundra Ártica");
		if(dc.alterar(animal)) {
			System.out.println("Animal alterado com sucesso");
			System.out.println(animal);
		}*/
	}
}
