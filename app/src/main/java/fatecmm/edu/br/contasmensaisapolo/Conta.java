package fatecmm.edu.br.contasmensaisapolo;

/**
 * Created by Apolo on 04-07-2016.
 */
public class Conta {

    private int id;
    private String Descricao;
    private double Valor;

    @Override
    public String toString(){
        return getDescricao().toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double valor) {
        Valor = valor;
    }
}
