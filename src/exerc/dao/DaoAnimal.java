package exerc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exerc.entidade.Animal;
import exerc.interfaces.ICrud;
import exerc.utilidades.Conexao;

public class DaoAnimal implements ICrud<Animal> {

	@Override
	public boolean salvar(Animal obj) {
		String sql = "insert into animal(nome, especie, habitat) values(?,?,?)";
		Connection con = Conexao.conectar();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, obj.getNome());
			stm.setString(2, obj.getEspecie());
			stm.setString(3, obj.getHabitat());
			stm.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}

		return false;
	}

	@Override
	public boolean alterar(Animal obj) {
		String sql = "update animal set " + "nome = ?," + "especie = ?," + "habitat = ?" + "where id = ?";
		Connection con = Conexao.conectar();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setString(1, obj.getNome());
			stm.setString(2, obj.getEspecie());
			stm.setString(3, obj.getHabitat());
			stm.setInt(4, obj.getId());
			stm.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		} finally {
			Conexao.fechar();
		}
		return false;
	}

	@Override
	public void excluir(int id) {
		String sql = "delete from animal where id = " + id;
		Connection con = Conexao.conectar();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.execute();
		} catch (SQLException e) {
			System.out.println(e.getLocalizedMessage());
		} finally {
			Conexao.fechar();
		}
	}

	@Override
	public Animal consultar(int id) {
		Animal animal = new Animal();
		String sql = "select * from animal where id = " + id;
		Connection con = Conexao.conectar();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				animal.setId(rs.getInt("id"));
				animal.setNome(rs.getString("nome"));
				animal.setEspecie(rs.getString("especie"));
				animal.setHabitat(rs.getString("habitat"));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Conexao.fechar();
		}
		return animal;
	}

	@Override
	public List<Animal> consultar() {
		List<Animal> animais = new ArrayList<>();
		String sql = "select * from animal";
		Connection con = Conexao.conectar();
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Animal animal = new Animal();
				animal.setId(rs.getInt("id"));
				animal.setNome(rs.getString("nome"));
				animal.setEspecie(rs.getString("especie"));
				animal.setHabitat(rs.getString("habitat"));
				animais.add(animal);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			Conexao.fechar();
		}
		return animais;
	}
}
