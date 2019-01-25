package br.com.compreseucarroaqui.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VEICULO")
public class Veiculo implements java.io.Serializable {
			
	private static final long serialVersionUID = 1L;
	
		private String chassi;
		private String modelo;
		private String valor;
		

	public Veiculo() {
		
	}
		
	
		public Veiculo( String chassi, String modelo,String valor) {
	
			this.chassi = chassi;
			this.modelo = modelo;
			this.valor  = valor;
			
		}

	

		@Id
		@Column(name = "CHASSI", nullable = false, precision = 22, scale = 0)
		public String getChassi() {
			return chassi;
		}

		public void setChassi(String chassi) {
			this.chassi = chassi;
		}

		@Column(name = "MODELO",  nullable = false, precision = 22, scale = 0)
		public String getModelo() {
			return modelo;
		}

		public void setModelo(String modelo) {
			this.modelo = modelo;
		}

		@Column (name = "VALOR", nullable = false, precision = 22, scale = 0)
		public String getValor() {
			return valor;
		}
		public void setValor(String valor) {
			this.valor = valor;
		}


		@Override
		public String toString() {
			return "Veiculo [chassi=" + chassi + ", modelo=" + modelo + ", valor=" + valor + "]";
		}






	
	
		
		
}
