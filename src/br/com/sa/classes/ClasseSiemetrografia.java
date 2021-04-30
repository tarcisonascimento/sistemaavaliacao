package br.com.sa.classes;

public class ClasseSiemetrografia {

    public double idade, alcance;
    public String sexo, classifica;

    public void wellsenelson() {
        //calculo do banco de wels

        if (sexo.equals("Masculino")) {
            if (idade <= 35) {
                if (alcance <= 24) {
                    classifica = "Muito Fraco";
                }
                if ((alcance > 24) && (alcance <= 33)) {
                    classifica = "Nível Fraco";
                }
                if ((alcance > 33) && (alcance <= 38)) {
                    classifica = "Nível Médio";
                }
                if ((alcance > 38) && (alcance <= 43)) {
                    classifica = "Nível Bom";
                }
                if (alcance > 43) {
                    classifica = "Excelente";
                }
            }
            if ((idade > 35) && (idade <= 49)) {
                if (alcance <= 21) {
                    classifica = "Muito Fraco";
                }
                if ((alcance > 21) && (alcance <= 25)) {
                    classifica = "Nível Fraco";
                }
                if ((alcance > 25) && (alcance <= 33)) {
                    classifica = "Nível Médio";
                }
                if ((alcance > 33) && (alcance <= 40)) {
                    classifica = "Nível Bom";
                }
                if (alcance > 40) {
                    classifica = "Excelente";
                }
            }
            if (idade > 49) {
                if (alcance <= 19) {
                    classifica = "Muito Fraco";
                }
                if ((alcance > 19) && (alcance <= 24)) {
                    classifica = "Nível Fraco";
                }
                if ((alcance > 24) && (alcance <= 29)) {
                    classifica = "Nível Médio";
                }
                if ((alcance > 29) && (alcance <= 34)) {
                    classifica = "Nível Bom";
                }
                if (alcance > 34) {
                    classifica = "Excelente";
                }
            }

        }

        if (sexo.equals("Feminino")) {
            if (idade <= 35) {
                if (alcance <= 27) {
                    classifica = "Muito Fraco";
                }
                if ((alcance > 27) && (alcance <= 36)) {
                    classifica = "Nível Fraco";
                }
                if ((alcance > 36) && (alcance <= 40)) {
                    classifica = "Nível Médio";
                }
                if ((alcance > 40) && (alcance <= 46)) {
                    classifica = "Nível Bom";
                }
                if (alcance > 46) {
                    classifica = "Excelente";
                }
            }
            if ((idade > 35) && (idade <= 49)) {
                if (alcance <= 25) {
                    classifica = "Muito Fraco";
                }
                if ((alcance > 25) && (alcance <= 32)) {
                    classifica = "Nível Fraco";
                }
                if ((alcance > 32) && (alcance <= 36)) {
                    classifica = "Nível Médio";
                }
                if ((alcance > 36) && (alcance <= 44)) {
                    classifica = "Nível Bom";
                }
                if (alcance > 44) {
                    classifica = "Excelente";
                }
            }
            if (idade > 49) {
                if (alcance <= 21) {
                    classifica = "Muito Fraco";
                }
                if ((alcance > 21) && (alcance <= 25)) {
                    classifica = "Nível Fraco";
                }
                if ((alcance > 25) && (alcance <= 30)) {
                    classifica = "Nível Médio";
                }
                if ((alcance > 30) && (alcance <= 36)) {
                    classifica = "Nível Bom";
                }
                if (alcance > 36) {
                    classifica = "Excelente";
                }
            }

        }

    }

}
