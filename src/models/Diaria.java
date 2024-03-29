package models;

import util.TipoVeiculo;

public class Diaria {
   private  int totalDias;

   private  TipoVeiculo tipoVeiculo;

   private Desconto desconto;

   public Diaria(int totalDias, TipoVeiculo tipoVeiculo, Desconto desconto) {
       this.totalDias = totalDias;
       this.tipoVeiculo = tipoVeiculo;
       this.desconto = desconto;
   }

   public double getValorBase() {
       switch (tipoVeiculo) {
           case PEQUENO:
               return 100.0;

           case MEDIO:
               return 150.0;

           case SUV:
               return 200.0;

           default:
               throw new IllegalArgumentException("Tipo de veículo inválido!");
       }
   }

   public double getValorTotal() {
       double valorBase = getValorBase();
       double valorTotal = valorBase * totalDias;
       double descontoAplicado = desconto.calcularDesconto(valorTotal, totalDias);
       return valorTotal * (1 - descontoAplicado);
   }
}
