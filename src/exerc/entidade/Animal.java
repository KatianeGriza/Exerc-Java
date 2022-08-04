package exerc.entidade;

public class Animal{
	private int id;
	private String nome;
	private String especie;
	private String habitat;
	
	
	public Animal() {
	}
	@Override
	public String toString() {
		return "Contato [id=" + id + ", nome=" + nome + ", especie=" + especie +", habitat=" + habitat + "]";
	}

	public Animal(String nome, String especie, String habitat) {
		this.nome = nome;
		this.especie = especie;
		this.habitat = habitat;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getHabitat() {
		return habitat;
	}

	public void setHabitat(String habitat) {
		this.habitat = habitat;
	}

	
}
