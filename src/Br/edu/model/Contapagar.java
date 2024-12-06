package Br.edu.model;

public class Contapagar {

    private String fornecedor;
    private double valor;
    private String dataVencimento;
    private String status;


    public Contapagar(String fornecedor, double valor, String dataVencimento, String status) {
        this.fornecedor = fornecedor;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.status = status;
    }


    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}


