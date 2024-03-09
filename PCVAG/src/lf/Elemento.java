package lf;

public class Elemento {
	public String estado;
	private Elemento proximo;
	private Elemento anterior;
	public int nivel;
	private String pai;
	
	
	public Elemento(String pai,String estado,int nivel,Elemento proximo,Elemento anterior) {
		this.estado = estado;
		this.proximo = proximo;
		this.anterior = anterior;
		this.nivel = nivel;
		this.pai = pai;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Elemento getProximo() {
		return proximo;
	}

	public void setProximo(Elemento proximo) {
		this.proximo = proximo;
	}

	public Elemento getAnterior() {
		return anterior;
	}

	public void setAnterior(Elemento anterior) {
		this.anterior = anterior;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public String getPai() {
		return pai;
	}
	public void setPai(String pai) {
		this.pai = pai;
	}

	

}
