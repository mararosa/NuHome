package com.estudos.nuhome.home.domain

enum class CreditCardBrand(val type: String? = null) {
    VISA("Visa"),
    MASTERCARD("Mastercard"),
    ELO("Elo"),
    AMERICAN_EXPRESS("AmericanExpress"),
    HIPERCARD("Hipercard"),
    UNKNOWN;

    companion object {
        fun getEnumValue(brand: String) =
            values().find { it.type?.equals(brand, ignoreCase = true) == true } ?: UNKNOWN
    }
    // TENHO DUAS OPCOES, COLOCAR UM PARAMETRO NO ENUM OU TER IFS PRA VALIDAR STAUS POR STATUS
    //PQ eu usei o find e o equals? p find ja nao deveria achar o que quero? e pq nao consegui usar o map?

    //Quando coloquei {} ele tava retornando um unit pq eu nao especifiquei o tipo do retorno e ai no mapper reclamava que esperava um enum mas eu tava mandando um unit
    // e ai coloquei o = entao ele agora retorna o que quero, que  eh o enum
}