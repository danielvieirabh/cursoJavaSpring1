package com.projeto.curso.entities.enums;

public enum OrderStatus {
//    WAITTING_PAYMENT, //0
//    PAID, //Pago  // 1
//    SHIPPED, // 2
//    DELIVERED, // 3
//    CANCELED // 4

   // Colocando valores :
   WAITTING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

   private int code;

   //COnstrutor aqui e private
   private OrderStatus(int code) {
       this.code = code;
   }

   //Para acessar o codigo , metodo poublic
   public int getCode() {
       return this.code;
   }

   //Converter valor numero para tipo enumerado, Estatico pois vai funcionar sem instanciar
    public static OrderStatus valueOf(int code) {
       for (OrderStatus value : OrderStatus.values()) { //Percorrer todos os valores de tipo status
           if (value.getCode() == code) { //code que verifica no parametro
               return value;
           }
       }
       //Se for um codigo inexistente :
       throw new IllegalArgumentException("Invalid OrderStatus code");
    }


}
