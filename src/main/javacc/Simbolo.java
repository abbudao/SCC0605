package Simbolo;
import java.util.ArrayList;
import java.util.List;

public class Simbolo{
	public String id;
	public int nivel;
	public String categoria;
	public Simbolo tipo;
	public int num_bytes;
	public int nparam;
	public int inf;
	public int sup;
	public List<Simbolo> arguments;

	public Simbolo(String id, int nivel, String categoria, Simbolo tipo){
		this.id = id;
		this.nivel = nivel;
		this.categoria = categoria;
		this.tipo = tipo;
		nparam = 0;
		inf = 0;
		sup = 0;
		arguments = new ArrayList<Simbolo>();
	}

}