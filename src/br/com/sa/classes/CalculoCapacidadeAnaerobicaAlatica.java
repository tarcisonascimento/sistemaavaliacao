package br.com.sa.classes;

public class CalculoCapacidadeAnaerobicaAlatica {

    public double s0,s1,s2,resultado,idade,peso,estatura,distancia,tempo;
    public String sexo,classifica;

    public void margaria01() {
        //PROTOCOLO DE MARGARIA – TESTE DA ESCADA

        s0 = peso * distancia;
        resultado = s0 / tempo;

        if (sexo.equals("Masculino")) {
            if (idade < 19) {
                if (resultado <= 113) {
                    classifica = "Fraco";
                }
                if ((resultado > 113) && (resultado <= 149)) {
                    classifica = "Regular";
                }
                if ((resultado > 149) && (resultado <= 187)) {
                    classifica = "Bom";
                }
                if ((resultado > 187) && (resultado <= 224)) {
                    classifica = "Muito Bom";
                }
                if (resultado > 224) {
                    classifica = "Superior";
                }
            }

            if ((idade >= 20) && (idade <= 29)) {
                if (resultado <= 106) {
                    classifica = "Fraco";
                }
                if ((resultado > 106) && (resultado <= 139)) {
                    classifica = "Regular";
                }
                if ((resultado > 139) && (resultado <= 175)) {
                    classifica = "Bom";
                }
                if ((resultado > 175) && (resultado <= 210)) {
                    classifica = "Muito Bom";
                }
                if (resultado > 210) {
                    classifica = "Superior";
                }
            }

            if ((idade >= 30) && (idade <= 39)) {
                if (resultado <= 85) {
                    classifica = "Fraco";
                }
                if ((resultado > 85) && (resultado <= 111)) {
                    classifica = "Regular";
                }
                if ((resultado > 111) && (resultado <= 140)) {
                    classifica = "Bom";
                }
                if ((resultado > 140) && (resultado <= 168)) {
                    classifica = "Muito Bom";
                }
                if (resultado > 168) {
                    classifica = "Superior";
                }
            }

            if ((idade >= 40) && (idade <= 49)) {
                if (resultado <= 65) {
                    classifica = "Fraco";
                }
                if ((resultado > 65) && (resultado <= 84)) {
                    classifica = "Regular";
                }
                if ((resultado > 84) && (resultado <= 105)) {
                    classifica = "Bom";
                }
                if ((resultado > 105) && (resultado <= 125)) {
                    classifica = "Muito Bom";
                }
                if (resultado > 125) {
                    classifica = "Superior";
                }
            }

            if (idade >= 50) {
                if (resultado <= 50) {
                    classifica = "Fraco";
                }
                if ((resultado > 50) && (resultado <= 65)) {
                    classifica = "Regular";
                }
                if ((resultado > 65) && (resultado <= 82)) {
                    classifica = "Bom";
                }
                if ((resultado > 82) && (resultado <= 98)) {
                    classifica = "Muito Bom";
                }
                if (resultado > 98) {
                    classifica = "Superior";
                }
            }

        }

        if (sexo.equals("Feminino")) {
            if (idade < 19) {
                if (resultado <= 92) {
                    classifica = "Fraco";
                }
                if ((resultado > 92) && (resultado <= 120)) {
                    classifica = "Regular";
                }
                if ((resultado > 120) && (resultado <= 151)) {
                    classifica = "Bom";
                }
                if ((resultado > 151) && (resultado <= 182)) {
                    classifica = "Muito Bom";
                }
                if (resultado > 182) {
                    classifica = "Superior";
                }
            }

            if ((idade >= 20) && (idade <= 29)) {
                if (resultado <= 85) {
                    classifica = "Fraco";
                }
                if ((resultado > 85) && (resultado <= 111)) {
                    classifica = "Regular";
                }
                if ((resultado > 111) && (resultado <= 140)) {
                    classifica = "Bom";
                }
                if ((resultado > 140) && (resultado <= 168)) {
                    classifica = "Muito Bom";
                }
                if (resultado > 168) {
                    classifica = "Superior";
                }
            }

            if ((idade >= 30) && (idade <= 39)) {
                if (resultado <= 65) {
                    classifica = "Fraco";
                }
                if ((resultado > 65) && (resultado <= 84)) {
                    classifica = "Regular";
                }
                if ((resultado > 84) && (resultado <= 105)) {
                    classifica = "Bom";
                }
                if ((resultado > 105) && (resultado <= 125)) {
                    classifica = "Muito Bom";
                }
                if (resultado > 125) {
                    classifica = "Superior";
                }
            }

            if ((idade >= 40) && (idade <= 49)) {
                if (resultado <= 50) {
                    classifica = "Fraco";
                }
                if ((resultado > 50) && (resultado <= 65)) {
                    classifica = "Regular";
                }
                if ((resultado > 65) && (resultado <= 82)) {
                    classifica = "Bom";
                }
                if ((resultado > 82) && (resultado <= 98)) {
                    classifica = "Muito Bom";
                }
                if (resultado > 98) {
                    classifica = "Superior";
                }
            }

            if (idade >= 50) {
                if (resultado <= 38) {
                    classifica = "Fraco";
                }
                if ((resultado > 38) && (resultado <= 48)) {
                    classifica = "Regular";
                }
                if ((resultado > 48) && (resultado <= 61)) {
                    classifica = "Bom";
                }
                if ((resultado > 61) && (resultado <= 75)) {
                    classifica = "Muito Bom";
                }
                if (resultado > 75) {
                    classifica = "Superior";
                }
            }
        }

    }

    public void fletcher01() {
        //PROTOCOLO DE FLETCHER – TESTE DE MULTI-SALTOS:

        s0 = peso * distancia;
        resultado = s0 / tempo;

        if (sexo.equals("Masculino")) {
            if (idade < 19) {
                if (resultado <= 113) {
                    classifica = "Fraco";
                }
                if ((resultado > 113) && (resultado <= 149)) {
                    classifica = "Regular";
                }
                if ((resultado > 149) && (resultado <= 187)) {
                    classifica = "Bom";
                }
                if ((resultado > 187) && (resultado <= 224)) {
                    classifica = "Muito Bom";
                }
                if (resultado > 224) {
                    classifica = "Superior";
                }
            }

            if ((idade >= 20) && (idade <= 29)) {
                if (resultado <= 106) {
                    classifica = "Fraco";
                }
                if ((resultado > 106) && (resultado <= 139)) {
                    classifica = "Regular";
                }
                if ((resultado > 139) && (resultado <= 175)) {
                    classifica = "Bom";
                }
                if ((resultado > 175) && (resultado <= 210)) {
                    classifica = "Muito Bom";
                }
                if (resultado > 210) {
                    classifica = "Superior";
                }
            }

            if ((idade >= 30) && (idade <= 39)) {
                if (resultado <= 85) {
                    classifica = "Fraco";
                }
                if ((resultado > 85) && (resultado <= 111)) {
                    classifica = "Regular";
                }
                if ((resultado > 111) && (resultado <= 140)) {
                    classifica = "Bom";
                }
                if ((resultado > 140) && (resultado <= 168)) {
                    classifica = "Muito Bom";
                }
                if (resultado > 168) {
                    classifica = "Superior";
                }
            }

            if ((idade >= 40) && (idade <= 49)) {
                if (resultado <= 65) {
                    classifica = "Fraco";
                }
                if ((resultado > 65) && (resultado <= 84)) {
                    classifica = "Regular";
                }
                if ((resultado > 84) && (resultado <= 105)) {
                    classifica = "Bom";
                }
                if ((resultado > 105) && (resultado <= 125)) {
                    classifica = "Muito Bom";
                }
                if (resultado > 125) {
                    classifica = "Superior";
                }
            }

            if (idade >= 50) {
                if (resultado <= 50) {
                    classifica = "Fraco";
                }
                if ((resultado > 50) && (resultado <= 65)) {
                    classifica = "Regular";
                }
                if ((resultado > 65) && (resultado <= 82)) {
                    classifica = "Bom";
                }
                if ((resultado > 82) && (resultado <= 98)) {
                    classifica = "Muito Bom";
                }
                if (resultado > 98) {
                    classifica = "Superior";
                }
            }

        }

        if (sexo.equals("Feminino")) {
            if (idade < 19) {
                if (resultado <= 92) {
                    classifica = "Fraco";
                }
                if ((resultado > 92) && (resultado <= 120)) {
                    classifica = "Regular";
                }
                if ((resultado > 120) && (resultado <= 151)) {
                    classifica = "Bom";
                }
                if ((resultado > 151) && (resultado <= 182)) {
                    classifica = "Muito Bom";
                }
                if (resultado > 182) {
                    classifica = "Superior";
                }
            }

            if ((idade >= 20) && (idade <= 29)) {
                if (resultado <= 85) {
                    classifica = "Fraco";
                }
                if ((resultado > 85) && (resultado <= 111)) {
                    classifica = "Regular";
                }
                if ((resultado > 111) && (resultado <= 140)) {
                    classifica = "Bom";
                }
                if ((resultado > 140) && (resultado <= 168)) {
                    classifica = "Muito Bom";
                }
                if (resultado > 168) {
                    classifica = "Superior";
                }
            }

            if ((idade >= 30) && (idade <= 39)) {
                if (resultado <= 65) {
                    classifica = "Fraco";
                }
                if ((resultado > 65) && (resultado <= 84)) {
                    classifica = "Regular";
                }
                if ((resultado > 84) && (resultado <= 105)) {
                    classifica = "Bom";
                }
                if ((resultado > 105) && (resultado <= 125)) {
                    classifica = "Muito Bom";
                }
                if (resultado > 125) {
                    classifica = "Superior";
                }
            }

            if ((idade >= 40) && (idade <= 49)) {
                if (resultado <= 50) {
                    classifica = "Fraco";
                }
                if ((resultado > 50) && (resultado <= 65)) {
                    classifica = "Regular";
                }
                if ((resultado > 65) && (resultado <= 82)) {
                    classifica = "Bom";
                }
                if ((resultado > 82) && (resultado <= 98)) {
                    classifica = "Muito Bom";
                }
                if (resultado > 98) {
                    classifica = "Superior";
                }
            }

            if (idade >= 50) {
                if (resultado <= 38) {
                    classifica = "Fraco";
                }
                if ((resultado > 38) && (resultado <= 48)) {
                    classifica = "Regular";
                }
                if ((resultado > 48) && (resultado <= 61)) {
                    classifica = "Bom";
                }
                if ((resultado > 61) && (resultado <= 75)) {
                    classifica = "Muito Bom";
                }
                if (resultado > 75) {
                    classifica = "Superior";
                }
            }
        }

    }

    public void almeida01() {
        //PROTOCOLO DE ALMEIDA & SAMPEDRO - TESTE DE 30 m:

        s1 = peso * 900;
        s2 = tempo * tempo * tempo;

        resultado = s1 / s2;

        if (sexo.equals("Masculino")) {
            if (resultado <= 800) {
                classifica = "Fraco";
            }
            if ((resultado > 800) && (resultado <= 950)) {
                classifica = "Médio";
            }
            if ((resultado > 950) && (resultado <= 1100)) {
                classifica = "Bom";
            }
            if ((resultado > 1100) && (resultado <= 1250)) {
                classifica = "Muito Bom";
            }
            if (resultado > 1250) {
                classifica = "Excelente";
            }

        }

        if (sexo.equals("Feminino")) {
            if (resultado <= 650) {
                classifica = "Fraco";
            }
            if ((resultado > 650) && (resultado <= 800)) {
                classifica = "Médio";
            }
            if ((resultado > 800) && (resultado <= 950)) {
                classifica = "Bom";
            }
            if ((resultado > 950) && (resultado <= 1100)) {
                classifica = "Muito Bom";
            }
            if (resultado > 1100) {
                classifica = "Excelente";
            }

        }

    }

    public void kiss01() {
        //PROTOCOLO DE KISS – TESTE DE 45,7 m:
        //protocolo apenas classifica o tempo utilizado;

        resultado = tempo;
        if (sexo.equals("Masculino")) {
            if (tempo <= 6.4) {
                classifica = "Excelente";
            }
            if ((tempo > 6.4) && (tempo <= 6.6)) {
                classifica = "Muito Bom";
            }
            if ((tempo > 6.6) && (tempo <= 7.0)) {
                classifica = "Bom";
            }
            if ((tempo > 7.0) && (tempo <= 7.5)) {
                classifica = "Razoavel";
            }
            if (tempo > 7.5) {
                classifica = "Fraco";
            }
        }

        if (sexo.equals("Feminino")) {
            if (tempo <= 7.5) {
                classifica = "Excelente";
            }
            if ((tempo > 7.5) && (tempo <= 7.9)) {
                classifica = "Muito Bom";
            }
            if ((tempo > 7.9) && (tempo <= 8.2)) {
                classifica = "Bom";
            }
            if ((tempo > 8.2) && (tempo <= 9.0)) {
                classifica = "Razoavel";
            }
            if (tempo > 9.0) {
                classifica = "Fraco";
            }
        }
    }

}
