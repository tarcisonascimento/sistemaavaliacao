/*
protocolos de mensuraçao da capacidade anaerobica latica
 */
package br.com.sa.classes;

public class CalculoCapacidadeAnaerobicaLatica {

    public double t0, t1, t2, t3, t4, t5, t6, t7, t8, t9, distancia, peso, idade, estatura, resultado;
    public String sexo, classifica;
    double s0, s1, s2, s3, s4, s5, s6, s7;
    double a0, a1, a2, a3, a4, a5, a6, a7;
    double f1, f2, f3, f4;

    public void stuart01() {
        //PROTOCOLO DE STUART et alli - TESTE DE 36,5 m:

        s0 = t0 + t1 + t2;
        s1 = t7 + t8 + t9;

        s3 = s0 / 3;

        s4 = s1 / 3;

        resultado = s3 / s4;

        if (resultado >= 0.90) {

            classifica = "Superior";

        }
        if ((resultado >= 0.85) && (resultado < 0.90)) {

            classifica = "Bom";

        }
        if ((resultado >= 0.80) && (resultado < 0.85)) {

            classifica = "Regular";

        }
        if (resultado < 0.80) {

            classifica = "Baixo";

        }

    }

    public void almeida01() {
        //PROTOCOLO DE ALMEIDA & SAMPEDRO - TESTE DE 35 m
        //determina o indice de fadiga

        s0 = peso * 35;
        a0 = s0 / t0;
        a1 = s0 / t1;
        s1 = a0 - a1;
        s2 = s1 / a0;

        resultado = s2 * 100;

        if (resultado >= 20) {

            classifica = "Fraco";

        }
        if ((resultado >= 15) && (resultado < 20)) {

            classifica = "Razoavel";

        }
        if ((resultado >= 10) && (resultado < 15)) {

            classifica = "Bom";

        }
        if ((resultado >= 5) && (resultado < 10)) {

            classifica = "Muito Bom";

        }
        if (resultado < 5) {

            classifica = "Superior";

        }

    }

    public void almeida02() {
        //PROTOCOLO DE STUART et alli - TESTE DE 36,5 m:

        // s0 = t0 - (int) (t0);//aqui estou pegando so os numeros fracionados para calcular
        s0 = t0 + t1 + t2;
        s1 = t7 + t8 + t9;

        s3 = s0 / 3;

        s4 = s1 / 3;

        resultado = s3 / s4;

        if (resultado >= 0.90) {

            classifica = "Superior";

        }
        if ((resultado >= 0.85) && (resultado < 0.90)) {

            classifica = "Bom";

        }
        if ((resultado >= 0.80) && (resultado < 0.85)) {

            classifica = "Regular";

        }
        if (resultado < 0.80) {

            classifica = "Baixo";

        }

    }

    public void matsudo01() {

        if (sexo.equals("Masculino")) {

            if (idade < 11) {
                if (distancia < 165) {
                    resultado = distancia;
                    classifica = "Fraco";
                }
                if ((distancia >= 165) && (distancia <= 180)) {
                    resultado = distancia;
                    classifica = "Regular";
                }
                if ((distancia > 180) && (distancia <= 195)) {
                    resultado = distancia;
                    classifica = "Bom";
                }
                if ((distancia > 195) && (distancia <= 220)) {
                    resultado = distancia;
                    classifica = "Muito Bom";
                }
                if (distancia > 220) {
                    resultado = distancia;
                    classifica = "Superior";
                }
            }
            if ((idade >= 12) && (idade <= 15)) {
                if (distancia < 180) {
                    resultado = distancia;
                    classifica = "Fraco";
                }
                if ((distancia >= 180) && (distancia <= 200)) {
                    resultado = distancia;
                    classifica = "Regular";
                }
                if ((distancia > 200) && (distancia <= 220)) {
                    resultado = distancia;
                    classifica = "Bom";
                }
                if ((distancia > 220) && (distancia <= 241)) {
                    resultado = distancia;
                    classifica = "Muito Bom";
                }
                if (distancia > 241) {
                    resultado = distancia;
                    classifica = "Superior";
                }
            }
            if ((idade >= 16) && (idade <= 19)) {
                if (distancia < 235) {
                    resultado = distancia;
                    classifica = "Fraco";
                }
                if ((distancia >= 235) && (distancia <= 255)) {
                    resultado = distancia;
                    classifica = "Regular";
                }
                if ((distancia > 255) && (distancia <= 276)) {
                    resultado = distancia;
                    classifica = "Bom";
                }
                if ((distancia > 276) && (distancia <= 297)) {
                    resultado = distancia;
                    classifica = "Muito Bom";
                }
                if (distancia > 297) {
                    resultado = distancia;
                    classifica = "Superior";
                }
            }
            if (idade >= 20) {
                if (distancia < 245) {
                    resultado = distancia;
                    classifica = "Fraco";
                }
                if ((distancia >= 245) && (distancia <= 265)) {
                    resultado = distancia;
                    classifica = "Regular";
                }
                if ((distancia > 265) && (distancia <= 285)) {
                    resultado = distancia;
                    classifica = "Bom";
                }
                if ((distancia > 285) && (distancia <= 310)) {
                    resultado = distancia;
                    classifica = "Muito Bom";
                }
                if (distancia > 310) {
                    resultado = distancia;
                    classifica = "Superior";
                }
            }

        }

        if (sexo.equals("Feminino")) {

            if (idade < 11) {
                if (distancia < 148) {
                    resultado = distancia;
                    classifica = "Fraco";
                }
                if ((distancia >= 148) && (distancia <= 160)) {
                    resultado = distancia;
                    classifica = "Regular";
                }
                if ((distancia > 160) && (distancia <= 175)) {
                    resultado = distancia;
                    classifica = "Bom";
                }
                if ((distancia > 175) && (distancia <= 200)) {
                    resultado = distancia;
                    classifica = "Muito Bom";
                }
                if (distancia > 200) {
                    resultado = distancia;
                    classifica = "Superior";
                }
            }
            if ((idade >= 12) && (idade <= 15)) {
                if (distancia < 160) {
                    resultado = distancia;
                    classifica = "Fraco";
                }
                if ((distancia >= 160) && (distancia <= 175)) {
                    resultado = distancia;
                    classifica = "Regular";
                }
                if ((distancia > 175) && (distancia <= 200)) {
                    resultado = distancia;
                    classifica = "Bom";
                }
                if ((distancia > 200) && (distancia <= 215)) {
                    resultado = distancia;
                    classifica = "Muito Bom";
                }
                if (distancia > 215) {
                    resultado = distancia;
                    classifica = "Superior";
                }
            }
            if ((idade >= 16) && (idade <= 19)) {
                if (distancia < 200) {
                    resultado = distancia;
                    classifica = "Fraco";
                }
                if ((distancia >= 200) && (distancia <= 215)) {
                    resultado = distancia;
                    classifica = "Regular";
                }
                if ((distancia > 215) && (distancia <= 230)) {
                    resultado = distancia;
                    classifica = "Bom";
                }
                if ((distancia > 230) && (distancia <= 245)) {
                    resultado = distancia;
                    classifica = "Muito Bom";
                }
                if (distancia > 245) {
                    resultado = distancia;
                    classifica = "Superior";
                }
            }
            if (idade >= 20) {
                if (distancia < 210) {
                    resultado = distancia;
                    classifica = "Fraco";
                }
                if ((distancia >= 210) && (distancia <= 225)) {
                    resultado = distancia;
                    classifica = "Regular";
                }
                if ((distancia > 225) && (distancia <= 240)) {
                    resultado = distancia;
                    classifica = "Bom";
                }
                if ((distancia > 240) && (distancia <= 265)) {
                    resultado = distancia;
                    classifica = "Muito Bom";
                }
                if (distancia > 265) {
                    resultado = distancia;
                    classifica = "Superior";
                }
            }

        }

    }

    public void almeida03() {

        if (sexo.equals("Masculino")) {

            if (idade < 11) {
                if (distancia < 165) {
                    resultado = distancia;
                    classifica = "Fraco";
                }
                if ((distancia >= 165) && (distancia <= 180)) {
                    resultado = distancia;
                    classifica = "Regular";
                }
                if ((distancia > 180) && (distancia <= 195)) {
                    resultado = distancia;
                    classifica = "Bom";
                }
                if ((distancia > 195) && (distancia <= 220)) {
                    resultado = distancia;
                    classifica = "Muito Bom";
                }
                if (distancia > 220) {
                    resultado = distancia;
                    classifica = "Superior";
                }
            }
            if ((idade >= 12) && (idade <= 15)) {
                if (distancia < 180) {
                    resultado = distancia;
                    classifica = "Fraco";
                }
                if ((distancia >= 180) && (distancia <= 200)) {
                    resultado = distancia;
                    classifica = "Regular";
                }
                if ((distancia > 200) && (distancia <= 220)) {
                    resultado = distancia;
                    classifica = "Bom";
                }
                if ((distancia > 220) && (distancia <= 241)) {
                    resultado = distancia;
                    classifica = "Muito Bom";
                }
                if (distancia > 241) {
                    resultado = distancia;
                    classifica = "Superior";
                }
            }
            if ((idade >= 16) && (idade <= 19)) {
                if (distancia < 235) {
                    resultado = distancia;
                    classifica = "Fraco";
                }
                if ((distancia >= 235) && (distancia <= 255)) {
                    resultado = distancia;
                    classifica = "Regular";
                }
                if ((distancia > 255) && (distancia <= 276)) {
                    resultado = distancia;
                    classifica = "Bom";
                }
                if ((distancia > 276) && (distancia <= 297)) {
                    resultado = distancia;
                    classifica = "Muito Bom";
                }
                if (distancia > 297) {
                    resultado = distancia;
                    classifica = "Superior";
                }
            }
            if (idade >= 20) {
                if (distancia < 245) {
                    resultado = distancia;
                    classifica = "Fraco";
                }
                if ((distancia >= 245) && (distancia <= 265)) {
                    resultado = distancia;
                    classifica = "Regular";
                }
                if ((distancia > 265) && (distancia <= 285)) {
                    resultado = distancia;
                    classifica = "Bom";
                }
                if ((distancia > 285) && (distancia <= 310)) {
                    resultado = distancia;
                    classifica = "Muito Bom";
                }
                if (distancia > 310) {
                    resultado = distancia;
                    classifica = "Superior";
                }
            }

        }

        if (sexo.equals("Feminino")) {

            if (idade < 11) {
                if (distancia < 148) {
                    resultado = distancia;
                    classifica = "Fraco";
                }
                if ((distancia >= 148) && (distancia <= 160)) {
                    resultado = distancia;
                    classifica = "Regular";
                }
                if ((distancia > 160) && (distancia <= 175)) {
                    resultado = distancia;
                    classifica = "Bom";
                }
                if ((distancia > 175) && (distancia <= 200)) {
                    resultado = distancia;
                    classifica = "Muito Bom";
                }
                if (distancia > 200) {
                    resultado = distancia;
                    classifica = "Superior";
                }
            }
            if ((idade >= 12) && (idade <= 15)) {
                if (distancia < 160) {
                    resultado = distancia;
                    classifica = "Fraco";
                }
                if ((distancia >= 160) && (distancia <= 175)) {
                    resultado = distancia;
                    classifica = "Regular";
                }
                if ((distancia > 175) && (distancia <= 200)) {
                    resultado = distancia;
                    classifica = "Bom";
                }
                if ((distancia > 200) && (distancia <= 215)) {
                    resultado = distancia;
                    classifica = "Muito Bom";
                }
                if (distancia > 215) {
                    resultado = distancia;
                    classifica = "Superior";
                }
            }
            if ((idade >= 16) && (idade <= 19)) {
                if (distancia < 200) {
                    resultado = distancia;
                    classifica = "Fraco";
                }
                if ((distancia >= 200) && (distancia <= 215)) {
                    resultado = distancia;
                    classifica = "Regular";
                }
                if ((distancia > 215) && (distancia <= 230)) {
                    resultado = distancia;
                    classifica = "Bom";
                }
                if ((distancia > 230) && (distancia <= 245)) {
                    resultado = distancia;
                    classifica = "Muito Bom";
                }
                if (distancia > 245) {
                    resultado = distancia;
                    classifica = "Superior";
                }
            }
            if (idade >= 20) {
                if (distancia < 210) {
                    resultado = distancia;
                    classifica = "Fraco";
                }
                if ((distancia >= 210) && (distancia <= 225)) {
                    resultado = distancia;
                    classifica = "Regular";
                }
                if ((distancia > 225) && (distancia <= 240)) {
                    resultado = distancia;
                    classifica = "Bom";
                }
                if ((distancia > 240) && (distancia <= 265)) {
                    resultado = distancia;
                    classifica = "Muito Bom";
                }
                if (distancia > 265) {
                    resultado = distancia;
                    classifica = "Superior";
                }
            }

        }

    }

    public void lanceta01() {
        
        resultado = t0;

        if (sexo.equals("Masculino")) {
            if (idade <= 12) {

                if (t0 >= 2.09) {
                    classifica = "Fraco";
                }
                if ((t0 >= 2.05) && (t0 < 2.09)) {
                    classifica = "Regular";
                }
                if ((t0 >= 2.01) && (t0 < 2.05)) {
                    classifica = "Bom";
                }
                if ((t0 >= 1.57) && (t0 < 2.01)) {
                    classifica = "Muito Bom";
                }
                if (t0 < 1.57) {
                    classifica = "Superior";
                }

            }
            if ((idade > 12) && (idade <= 14)) {

                if (t0 >= 2.00) {
                    classifica = "Fraco";
                }
                if ((t0 >= 1.56) && (t0 < 2.00)) {
                    classifica = "Regular";
                }
                if ((t0 >= 1.49) && (t0 < 1.56)) {
                    classifica = "Bom";
                }
                if ((t0 >= 1.45) && (t0 < 1.49)) {
                    classifica = "Muito Bom";
                }
                if (t0 < 1.45) {
                    classifica = "Superior";
                }

            }
            if (idade > 14) {

                if (t0 >= 1.48) {
                    classifica = "Fraco";
                }
                if ((t0 >= 1.45) && (t0 < 1.48)) {
                    classifica = "Regular";
                }
                if ((t0 >= 1.41) && (t0 < 1.45)) {
                    classifica = "Bom";
                }
                if ((t0 >= 1.38) && (t0 < 1.41)) {
                    classifica = "Muito Bom";
                }
                if (t0 < 1.38) {
                    classifica = "Superior";
                }

            }

        }
        
        if (sexo.equals("Feminino")) {
            if (idade <= 12) {

                if (t0 >= 1.34) {
                    classifica = "Fraco";
                }
                if ((t0 >= 1.28) && (t0 < 1.34)) {
                    classifica = "Regular";
                }
                if ((t0 >= 1.23) && (t0 < 1.28)) {
                    classifica = "Bom";
                }
                if ((t0 >= 1.20) && (t0 < 1.23)) {
                    classifica = "Muito Bom";
                }
                if (t0 < 1.20) {
                    classifica = "Superior";
                }

            }
            if ((idade > 12) && (idade <= 14)) {

                if (t0 >= 1.33) {
                    classifica = "Fraco";
                }
                if ((t0 >= 1.27) && (t0 < 1.33)) {
                    classifica = "Regular";
                }
                if ((t0 >= 1.22) && (t0 < 1.27)) {
                    classifica = "Bom";
                }
                if ((t0 >= 1.19) && (t0 < 1.22)) {
                    classifica = "Muito Bom";
                }
                if (t0 < 1.19) {
                    classifica = "Superior";
                }

            }
            if (idade > 14) {

                if (t0 >= 1.27) {
                    classifica = "Fraco";
                }
                if ((t0 >= 1.20) && (t0 < 1.27)) {
                    classifica = "Regular";
                }
                if ((t0 >= 1.15) && (t0 < 1.20)) {
                    classifica = "Bom";
                }
                if ((t0 >= 1.10) && (t0 < 1.15)) {
                    classifica = "Muito Bom";
                }
                if (t0 < 1.10) {
                    classifica = "Superior";
                }

            }

        }

    }

    public void almeida04() {
        //PROTOCOLO DE ALMEIDA et alli – TESTE DE 400 m

        resultado = t1 / t3;

        if (resultado >= 0.90) {

            classifica = "Excelente";

        }
        if ((resultado >= 0.85) && (resultado < 0.90)) {

            classifica = "Muito Bom";

        }
        if ((resultado >= 0.80) && (resultado < 0.85)) {

            classifica = "Bom";

        }
        if (resultado < 0.80) {

            classifica = "Baixo";
        }

    }

    public void almeida05() {
        // PROTOCOLO DE ALMEIDA –TESTE DE VAI e VEM EM 25 m

        resultado = t1 / t7;

        if (resultado >= 0.90) {

            classifica = "Excelente";

        }
        if ((resultado >= 0.85) && (resultado < 0.90)) {

            classifica = "Muito Bom";

        }
        if ((resultado >= 0.80) && (resultado < 0.85)) {

            classifica = "Bom";

        }
        if (resultado < 0.80) {

            classifica = "Baixo";
        }

    }

}
