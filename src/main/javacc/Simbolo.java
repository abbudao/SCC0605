package Simbolo;
public class Simbolo{
	public String id;
	public int nivel;
	public String categoria;
	public Simbolo tipo;
	public int num_bytes;
	public int nparam;
	public int inf;
	public int sup;

	public Simbolo(String id, int nivel, String categoria, Simbolo tipo){
		this.id = id;
		this.nivel = nivel;
		this.categoria = categoria;
		this.tipo = tipo;
		nparam = 0;
		inf = 0;
		sup = 0;
	}

}