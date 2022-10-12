package Models;

public class Veiculo {
	private String renavam;
	private String placa;
	private String ano;
	private int id;
	
	public Veiculo() {
		
	}
	
	public Veiculo(String renavam, String placa, String ano, int id) {
		this.renavam = renavam;
		this.placa = placa;
		this.ano = ano;
		this.id = id;
		
	}
	
	public String getRenavam() {
		return renavam;
	}
	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
