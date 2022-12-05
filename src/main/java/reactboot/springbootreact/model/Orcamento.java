package reactboot.springbootreact.model;

import javax.persistence.*;


@Entity
@Table(name="orcamento")
public class Orcamento {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id2;

    //adicionando colunas e demais elementos pra tabela do banco de dados temporario, trabalhando com o H2 database que carreguei nas dependencias do projeto.
    @Column(name="total")
    private double total;
    @Column(name="categoria")
    private String categoria;
    @Column(name="despesas")
    private double despesas;
    @Column(name="mes")
    private String mes;
    @Column(name="ano")
    private long ano;


    public Orcamento(){

    }

    public Orcamento(double total, String categoria, double despesas, String mes, long ano){

        super();
        this.total=total;
        this.categoria=categoria;
        this.despesas=despesas;
        this.mes=mes;
        this.ano=ano;

    }

    public long getId() {
        return id2;
    }

    public void setId(long id2) {
        this.id2 = id2;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getDespesas() {
        return despesas;
    }

    public void setDespesas(double despesas) {
        this.despesas = despesas;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public long getAno() {
        return ano;
    }

    public void setAno(long ano) {
        this.ano = ano;
    }
}
