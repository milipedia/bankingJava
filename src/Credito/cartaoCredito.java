package Credito;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class cartaoCredito {
    private double limite;
    private double saldo;
    private List<compra> compras;

    public cartaoCredito(double limite) {
        this.limite = limite;
        this.saldo = limite;
        this.compras = new ArrayList<>();
    }

    public boolean lancaCompra(compra compra){
        if(this.saldo > compra.getValor()){
            this.saldo -= compra.getValor();
            return true;
        }

        return false;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<compra> getCompras() {
        return compras;
    }

    public double getLimite() {
        return limite;
    }
}