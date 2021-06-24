package br.com.sa.classes;

//aqui vão todos os protocolos neuromuscular
public class CalculoNeuromuscular {

    public double idade, peso, estatura, distancia, tempo;
    double s0, s1, s2;
    public int quantidade;
    public String sexo, classifica;

    public double velocidade(double temp, double distancia) {
        //protocolo para calcular a velocidade de deslocamento de um individuo
        double resultado;
        distancia = distancia / 100; //passa a distancia de km para metros
        s0 = (int) temp;
        s1 = temp - s0;

        System.out.println(s0);
        System.out.println(s1);
        System.out.println(s0+s1);

        if (s0 <= 0) {
            s1 = s1 / 60;
            System.out.println(s1);
            resultado = distancia / s1;   //calcula a velocidade
            resultado = resultado; //massa a velocidade de metros por segundo para km por hora
            System.out.println(resultado);

        } else {

            s0 = s0 / 60;
            s1 = s1 / 60;
            System.out.println(s0);
            System.out.println(s1);
            temp = s0 + s1;
            resultado = distancia / temp;   //calcula a velocidade
            resultado = resultado * 10; //massa a velocidade de metros por segundo para km por hora

        }

        return resultado;//retorna o resultado
    }

    public void ahper01abs() {
        //Protocolo da AAHPER - Teste de flexão do tronco (abdominal)

        if (sexo.equals("Masculino")) {
            if (idade <= 19) {

                if (quantidade <= 32) {
                    classifica = "Nível Ruim";
                }
                if ((quantidade > 32) && (quantidade <= 37)) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 37) && (quantidade <= 41)) {
                    classifica = "Nível Médio";
                }
                if ((quantidade > 41) && (quantidade <= 47)) {
                    classifica = "Nível Bom";
                }
                if (quantidade > 47) {
                    classifica = "Nível Ótimo";
                }
            }
            if ((idade > 19) && (idade <= 29)) {

                if (quantidade <= 28) {
                    classifica = "Nível Ruim";
                }
                if ((quantidade > 28) && (quantidade <= 32)) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 32) && (quantidade <= 36)) {
                    classifica = "Nível Médio";
                }
                if ((quantidade > 36) && (quantidade <= 42)) {
                    classifica = "Nível Bom";
                }
                if (quantidade > 42) {
                    classifica = "Nível Ótimo";
                }
            }
            if ((idade > 29) && (idade <= 39)) {

                if (quantidade <= 21) {
                    classifica = "Nível Ruim";
                }
                if ((quantidade > 21) && (quantidade <= 26)) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 26) && (quantidade <= 30)) {
                    classifica = "Nível Médio";
                }
                if ((quantidade > 30) && (quantidade <= 35)) {
                    classifica = "Nível Bom";
                }
                if (quantidade > 35) {
                    classifica = "Nível Ótimo";
                }
            }
            if ((idade > 39) && (idade <= 49)) {

                if (quantidade <= 16) {
                    classifica = "Nível Ruim";
                }
                if ((quantidade > 16) && (quantidade <= 21)) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 21) && (quantidade <= 25)) {
                    classifica = "Nível Médio";
                }
                if ((quantidade > 25) && (quantidade <= 30)) {
                    classifica = "Nível Bom";
                }
                if (quantidade > 30) {
                    classifica = "Nível Ótimo";
                }
            }
            if (idade > 49) {

                if (quantidade <= 12) {
                    classifica = "Nível Ruim";
                }
                if ((quantidade > 12) && (quantidade <= 17)) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 17) && (quantidade <= 21)) {
                    classifica = "Nível Médio";
                }
                if ((quantidade > 21) && (quantidade <= 25)) {
                    classifica = "Nível Bom";
                }
                if (quantidade > 25) {
                    classifica = "Nível Ótimo";
                }
            }

        }
        if (sexo.equals("Feminino")) {
            if (idade <= 19) {

                if (quantidade <= 26) {
                    classifica = "Nível Ruim";
                }
                if ((quantidade > 26) && (quantidade <= 31)) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 31) && (quantidade <= 35)) {
                    classifica = "Nível Médio";
                }
                if ((quantidade > 35) && (quantidade <= 44)) {
                    classifica = "Nível Bom";
                }
                if (quantidade > 44) {
                    classifica = "Nível Ótimo";
                }
            }
            if ((idade > 19) && (idade <= 29)) {

                if (quantidade <= 20) {
                    classifica = "Nível Ruim";
                }
                if ((quantidade > 20) && (quantidade <= 24)) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 24) && (quantidade <= 30)) {
                    classifica = "Nível Médio";
                }
                if ((quantidade > 30) && (quantidade <= 35)) {
                    classifica = "Nível Bom";
                }
                if (quantidade > 35) {
                    classifica = "Nível Ótimo";
                }
            }
            if ((idade > 29) && (idade <= 39)) {

                if (quantidade <= 14) {
                    classifica = "Nível Ruim";
                }
                if ((quantidade > 14) && (quantidade <= 19)) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 19) && (quantidade <= 23)) {
                    classifica = "Nível Médio";
                }
                if ((quantidade > 23) && (quantidade <= 28)) {
                    classifica = "Nível Bom";
                }
                if (quantidade > 28) {
                    classifica = "Nível Ótimo";
                }
            }
            if ((idade > 39) && (idade <= 49)) {

                if (quantidade <= 6) {
                    classifica = "Nível Ruim";
                }
                if ((quantidade > 6) && (quantidade <= 14)) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 14) && (quantidade <= 19)) {
                    classifica = "Nível Médio";
                }
                if ((quantidade > 19) && (quantidade <= 24)) {
                    classifica = "Nível Bom";
                }
                if (quantidade > 24) {
                    classifica = "Nível Ótimo";
                }
            }
            if (idade > 49) {

                if (quantidade <= 2) {
                    classifica = "Nível Ruim";
                }
                if ((quantidade > 2) && (quantidade <= 4)) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 4) && (quantidade <= 11)) {
                    classifica = "Nível Médio";
                }
                if ((quantidade > 11) && (quantidade <= 18)) {
                    classifica = "Nível Bom";
                }
                if (quantidade > 18) {
                    classifica = "Nível Ótimo";
                }
            }

        }

    }

    public void robertson01abs() {
        //Protocolo de Robertson - Teste de flexão do tronco (abdominal)

        if (sexo.equals("Masculino")) {
            if (quantidade <= 52) {
                classifica = "Nível Fraco";

            }
            if ((quantidade > 52) && (quantidade <= 68)) {
                classifica = "Nível Regular";

            }
            if ((quantidade > 68) && (quantidade <= 86)) {
                classifica = "Nível Médio";

            }
            if ((quantidade > 86) && (quantidade <= 102)) {
                classifica = "Nível Bom";

            }
            if (quantidade > 102) {
                classifica = "Nível Muito Bom";

            }

        }
        if (sexo.equals("Feminino")) {
            if (quantidade <= 41) {
                classifica = "Nível Fraco";

            }
            if ((quantidade > 41) && (quantidade <= 59)) {
                classifica = "Nível Regular";

            }
            if ((quantidade > 59) && (quantidade <= 79)) {
                classifica = "Nível Médio";

            }
            if ((quantidade > 79) && (quantidade <= 97)) {
                classifica = "Nível Bom";

            }
            if (quantidade > 97) {
                classifica = "Nível Muito Bom";

            }

        }

    }

    public void sidinei01abs() {
        //Prototocolo de Sidnei & Jeté - Teste de flexão do tronco (abdominal)

        if (sexo.equals("Masculino")) {
            if (idade <= 29) {
                if (quantidade <= 20) {
                    classifica = "Nível Ruim";
                }
                if ((quantidade > 20) && (quantidade <= 21)) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 21) && (quantidade <= 30)) {
                    classifica = "Nível Médio";
                }
                if ((quantidade > 30) && (quantidade <= 42)) {
                    classifica = "Nível Bom";
                }
                if (quantidade > 42) {
                    classifica = "Nível Ótimo";
                }

            }
            if ((idade > 29) && (idade <= 39)) {
                if (quantidade <= 15) {
                    classifica = "Nível Ruim";
                }
                if ((quantidade > 15) && (quantidade <= 20)) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 20) && (quantidade <= 26)) {
                    classifica = "Nível Médio";
                }
                if ((quantidade > 26) && (quantidade <= 34)) {
                    classifica = "Nível Bom";
                }
                if (quantidade > 34) {
                    classifica = "Nível Ótimo";
                }

            }
            if ((idade > 39) && (idade <= 49)) {
                if (quantidade <= 10) {
                    classifica = "Nível Ruim";
                }
                if ((quantidade > 10) && (quantidade <= 16)) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 16) && (quantidade <= 21)) {
                    classifica = "Nível Médio";
                }
                if ((quantidade > 21) && (quantidade <= 30)) {
                    classifica = "Nível Bom";
                }
                if (quantidade > 30) {
                    classifica = "Nível Ótimo";
                }

            }
            if ((idade > 49) && (idade <= 59)) {
                if (quantidade <= 6) {
                    classifica = "Nível Ruim";
                }
                if ((quantidade > 6) && (quantidade <= 13)) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 13) && (quantidade <= 19)) {
                    classifica = "Nível Médio";
                }
                if ((quantidade > 19) && (quantidade <= 26)) {
                    classifica = "Nível Bom";
                }
                if (quantidade > 26) {
                    classifica = "Nível Ótimo";
                }

            }
            if (idade > 59) {
                if (quantidade <= 1) {
                    classifica = "Nível Ruim";
                }
                if ((quantidade > 1) && (quantidade <= 6)) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 6) && (quantidade <= 13)) {
                    classifica = "Nível Médio";
                }
                if ((quantidade > 13) && (quantidade <= 20)) {
                    classifica = "Nível Bom";
                }
                if (quantidade > 20) {
                    classifica = "Nível Ótimo";
                }

            }

        }
        if (sexo.equals("Feminino")) {
            if (idade <= 29) {
                if (quantidade <= 12) {
                    classifica = "Nível Ruim";
                }
                if ((quantidade > 12) && (quantidade <= 19)) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 19) && (quantidade <= 23)) {
                    classifica = "Nível Médio";
                }
                if ((quantidade > 23) && (quantidade <= 30)) {
                    classifica = "Nível Bom";
                }
                if (quantidade > 30) {
                    classifica = "Nível Ótimo";
                }

            }
            if ((idade > 29) && (idade <= 39)) {
                if (quantidade <= 9) {
                    classifica = "Nível Ruim";
                }
                if ((quantidade > 9) && (quantidade <= 15)) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 15) && (quantidade <= 20)) {
                    classifica = "Nível Médio";
                }
                if ((quantidade > 20) && (quantidade <= 30)) {
                    classifica = "Nível Bom";
                }
                if (quantidade > 30) {
                    classifica = "Nível Ótimo";
                }

            }
            if ((idade > 39) && (idade <= 49)) {
                if (quantidade <= 3) {
                    classifica = "Nível Ruim";
                }
                if ((quantidade > 3) && (quantidade <= 10)) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 10) && (quantidade <= 18)) {
                    classifica = "Nível Médio";
                }
                if ((quantidade > 18) && (quantidade <= 25)) {
                    classifica = "Nível Bom";
                }
                if (quantidade > 25) {
                    classifica = "Nível Ótimo";
                }

            }
            if ((idade > 49) && (idade <= 59)) {
                if (quantidade <= 1) {
                    classifica = "Nível Ruim";
                }
                if ((quantidade > 1) && (quantidade <= 5)) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 5) && (quantidade <= 10)) {
                    classifica = "Nível Médio";
                }
                if ((quantidade > 10) && (quantidade <= 17)) {
                    classifica = "Nível Bom";
                }
                if (quantidade > 17) {
                    classifica = "Nível Ótimo";
                }

            }
            if (idade > 59) {
                if (quantidade <= 1) {
                    classifica = "Nível Ruim";
                }
                if ((quantidade > 1) && (quantidade <= 2)) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 2) && (quantidade <= 9)) {
                    classifica = "Nível Médio";
                }
                if ((quantidade > 9) && (quantidade <= 17)) {
                    classifica = "Nível Bom";
                }
                if (quantidade > 17) {
                    classifica = "Nível Ótimo";
                }

            }

        }

    }

    public void eurofit01brac() {
        //Protocolo da Eurofit - Flexão de Braços

        if (sexo.equals("Masculino")) {
            if (idade <= 19) {
                if (quantidade <= 17) {
                    classifica = "Nível Ruim";
                }
                if ((quantidade > 17) && (quantidade <= 22)) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 22) && (quantidade <= 28)) {
                    classifica = "Nível Médio";
                }
                if ((quantidade > 28) && (quantidade <= 38)) {
                    classifica = "Nível Bom";
                }
                if (quantidade > 38) {
                    classifica = "Nível Ótimo";
                }

            }
            if ((idade > 19) && (idade <= 29)) {
                if (quantidade <= 16) {
                    classifica = "Nível Ruim";
                }
                if ((quantidade > 16) && (quantidade <= 21)) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 21) && (quantidade <= 28)) {
                    classifica = "Nível Médio";
                }
                if ((quantidade > 28) && (quantidade <= 35)) {
                    classifica = "Nível Bom";
                }
                if (quantidade > 35) {
                    classifica = "Nível Ótimo";
                }

            }
            if ((idade > 29) && (idade <= 39)) {
                if (quantidade <= 11) {
                    classifica = "Nível Ruim";
                }
                if ((quantidade > 11) && (quantidade <= 16)) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 16) && (quantidade <= 21)) {
                    classifica = "Nível Médio";
                }
                if ((quantidade > 21) && (quantidade <= 29)) {
                    classifica = "Nível Bom";
                }
                if (quantidade > 29) {
                    classifica = "Nível Ótimo";
                }

            }
            if ((idade > 39) && (idade <= 49)) {
                if (quantidade <= 9) {
                    classifica = "Nível Ruim";
                }
                if ((quantidade > 9) && (quantidade <= 12)) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 12) && (quantidade <= 16)) {
                    classifica = "Nível Médio";
                }
                if ((quantidade > 16) && (quantidade <= 21)) {
                    classifica = "Nível Bom";
                }
                if (quantidade > 21) {
                    classifica = "Nível Ótimo";
                }

            }
            if (idade > 49) {
                if (quantidade <= 6) {
                    classifica = "Nível Ruim";
                }
                if ((quantidade > 6) && (quantidade <= 9)) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 9) && (quantidade <= 12)) {
                    classifica = "Nível Médio";
                }
                if ((quantidade > 12) && (quantidade <= 20)) {
                    classifica = "Nível Bom";
                }
                if (quantidade > 20) {
                    classifica = "Nível Ótimo";
                }

            }

        }
        if (sexo.equals("Feminino")) {
            if (idade <= 19) {
                if (quantidade <= 11) {
                    classifica = "Nível Ruim";
                }
                if ((quantidade > 11) && (quantidade <= 17)) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 17) && (quantidade <= 24)) {
                    classifica = "Nível Médio";
                }
                if ((quantidade > 24) && (quantidade <= 32)) {
                    classifica = "Nível Bom";
                }
                if (quantidade > 32) {
                    classifica = "Nível Ótimo";
                }

            }
            if ((idade > 19) && (idade <= 29)) {
                if (quantidade <= 9) {
                    classifica = "Nível Ruim";
                }
                if ((quantidade > 9) && (quantidade <= 14)) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 14) && (quantidade <= 20)) {
                    classifica = "Nível Médio";
                }
                if ((quantidade > 20) && (quantidade <= 29)) {
                    classifica = "Nível Bom";
                }
                if (quantidade > 29) {
                    classifica = "Nível Ótimo";
                }

            }
            if ((idade > 29) && (idade <= 39)) {
                if (quantidade <= 7) {
                    classifica = "Nível Ruim";
                }
                if ((quantidade > 7) && (quantidade <= 12)) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 12) && (quantidade <= 19)) {
                    classifica = "Nível Médio";
                }
                if ((quantidade > 19) && (quantidade <= 26)) {
                    classifica = "Nível Bom";
                }
                if (quantidade > 26) {
                    classifica = "Nível Ótimo";
                }

            }
            if ((idade > 39) && (idade <= 49)) {
                if (quantidade <= 4) {
                    classifica = "Nível Ruim";
                }
                if ((quantidade > 4) && (quantidade <= 10)) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 10) && (quantidade <= 14)) {
                    classifica = "Nível Médio";
                }
                if ((quantidade > 14) && (quantidade <= 23)) {
                    classifica = "Nível Bom";
                }
                if (quantidade > 23) {
                    classifica = "Nível Ótimo";
                }

            }
            if (idade > 49) {
                if (quantidade <= 1) {
                    classifica = "Nível Ruim";
                }
                if ((quantidade > 1) && (quantidade <= 6)) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 6) && (quantidade <= 10)) {
                    classifica = "Nível Médio";
                }
                if ((quantidade > 10) && (quantidade <= 20)) {
                    classifica = "Nível Bom";
                }
                if (quantidade > 20) {
                    classifica = "Nível Ótimo";
                }

            }

        }

    }

    public void mathews01eleva() {
        //Protocolo de Mathews - Teste de elevação vertical (barra)
        if (sexo.equals("Masculino")) {
            if (idade <= 10) {
                if (quantidade <= 12) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 12) && (quantidade <= 21)) {
                    classifica = "Nível Regular";
                }
                if ((quantidade > 21) && (quantidade <= 31)) {
                    classifica = "Nível Bom";
                }
                if ((quantidade > 31) && (quantidade <= 41)) {
                    classifica = "Nível Muito Bom";
                }
                if (quantidade > 41) {
                    classifica = "Excelente";
                }

            }
            if ((idade > 10) && (idade <= 12)) {
                if (quantidade <= 17) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 17) && (quantidade <= 27)) {
                    classifica = "Nível Regular";
                }
                if ((quantidade > 27) && (quantidade <= 37)) {
                    classifica = "Nível Bom";
                }
                if ((quantidade > 37) && (quantidade <= 47)) {
                    classifica = "Nível Muito Bom";
                }
                if (quantidade > 47) {
                    classifica = "Excelente";
                }

            }
            if ((idade > 12) && (idade <= 15)) {
                if (quantidade <= 21) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 21) && (quantidade <= 31)) {
                    classifica = "Nível Regular";
                }
                if ((quantidade > 31) && (quantidade <= 41)) {
                    classifica = "Nível Bom";
                }
                if ((quantidade > 41) && (quantidade <= 51)) {
                    classifica = "Nível Muito Bom";
                }
                if (quantidade > 51) {
                    classifica = "Nível Excelente";
                }

            }
            if (idade > 15) {
                if (quantidade <= 24) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 24) && (quantidade <= 34)) {
                    classifica = "Nível Regular";
                }
                if ((quantidade > 34) && (quantidade <= 44)) {
                    classifica = "Nível Bom";
                }
                if ((quantidade > 44) && (quantidade <= 54)) {
                    classifica = "Nível Muito Bom";
                }
                if (quantidade > 54) {
                    classifica = "Nível Excelente";
                }

            }

        }
        if (sexo.equals("Feminino")) {
            if (idade <= 10) {
                if (quantidade <= 8) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 8) && (quantidade <= 16)) {
                    classifica = "Nível Regular";
                }
                if ((quantidade > 16) && (quantidade <= 24)) {
                    classifica = "Nível Bom";
                }
                if ((quantidade > 24) && (quantidade <= 32)) {
                    classifica = "Nível Muito Bom";
                }
                if (quantidade > 32) {
                    classifica = "Nível Excelente";
                }

            }
            if ((idade > 10) && (idade <= 12)) {
                if (quantidade <= 15) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 15) && (quantidade <= 23)) {
                    classifica = "Nível Regular";
                }
                if ((quantidade > 23) && (quantidade <= 31)) {
                    classifica = "Nível Bom";
                }
                if ((quantidade > 31) && (quantidade <= 39)) {
                    classifica = "Nível Muito Bom";
                }
                if (quantidade > 39) {
                    classifica = "Nível Excelente";
                }

            }
            if ((idade > 12) && (idade <= 15)) {
                if (quantidade <= 18) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 18) && (quantidade <= 26)) {
                    classifica = "Nível Regular";
                }
                if ((quantidade > 26) && (quantidade <= 34)) {
                    classifica = "Nível Bom";
                }
                if ((quantidade > 34) && (quantidade <= 42)) {
                    classifica = "Nível Muito Bom";
                }
                if (quantidade > 42) {
                    classifica = "Nível Excelente";
                }

            }
            if (idade > 15) {
                if (quantidade <= 24) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 24) && (quantidade <= 34)) {
                    classifica = "Nível Regular";
                }
                if ((quantidade > 34) && (quantidade <= 44)) {
                    classifica = "Nível Bom";
                }
                if ((quantidade > 44) && (quantidade <= 54)) {
                    classifica = "Nível Muito Bom";
                }
                if (quantidade > 54) {
                    classifica = "Nível Excelente";
                }

            }

        }

    }

    public void almeida01perna() {
        //Protocolo de Almeida - Teste de extensão de pernas (agachamento)
        if (sexo.equals("Masculino")) {
            if (idade <= 19) {
                if (quantidade <= 25) {
                    classifica = "Nível Ruim";
                }
                if ((quantidade > 25) && (quantidade <= 35)) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 35) && (quantidade <= 48)) {
                    classifica = "Nível Médio";
                }
                if ((quantidade > 48) && (quantidade <= 63)) {
                    classifica = "Nível Bom";
                }
                if (quantidade > 63) {
                    classifica = "Nível Ótimo";
                }

            }
            if ((idade > 19) && (idade <= 29)) {
                if (quantidade <= 16) {
                    classifica = "Nível Ruim";
                }
                if ((quantidade > 16) && (quantidade <= 21)) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 21) && (quantidade <= 28)) {
                    classifica = "Nível Médio";
                }
                if ((quantidade > 28) && (quantidade <= 35)) {
                    classifica = "Nível Bom";
                }
                if (quantidade > 35) {
                    classifica = "Nível Ótimo";
                }

            }
            if ((idade > 29) && (idade <= 39)) {
                if (quantidade <= 11) {
                    classifica = "Nível Ruim";
                }
                if ((quantidade > 11) && (quantidade <= 16)) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 16) && (quantidade <= 21)) {
                    classifica = "Nível Médio";
                }
                if ((quantidade > 21) && (quantidade <= 29)) {
                    classifica = "Nível Bom";
                }
                if (quantidade > 29) {
                    classifica = "Nível Ótimo";
                }

            }
            if ((idade > 39) && (idade <= 49)) {
                if (quantidade <= 9) {
                    classifica = "Nível Ruim";
                }
                if ((quantidade > 9) && (quantidade <= 12)) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 12) && (quantidade <= 16)) {
                    classifica = "Nível Médio";
                }
                if ((quantidade > 16) && (quantidade <= 21)) {
                    classifica = "Nível Bom";
                }
                if (quantidade > 21) {
                    classifica = "Nível Ótimo";
                }

            }
            if (idade > 49) {
                if (quantidade <= 6) {
                    classifica = "Nível Ruim";
                }
                if ((quantidade > 6) && (quantidade <= 9)) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 9) && (quantidade <= 12)) {
                    classifica = "Nível Médio";
                }
                if ((quantidade > 12) && (quantidade <= 20)) {
                    classifica = "Nível Bom";
                }
                if (quantidade > 20) {
                    classifica = "Nível Ótimo";
                }

            }

        }
        if (sexo.equals("Feminino")) {
            if (idade <= 19) {
                if (quantidade <= 11) {
                    classifica = "Nível Ruim";
                }
                if ((quantidade > 11) && (quantidade <= 17)) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 17) && (quantidade <= 24)) {
                    classifica = "Nível Médio";
                }
                if ((quantidade > 24) && (quantidade <= 32)) {
                    classifica = "Nível Bom";
                }
                if (quantidade > 32) {
                    classifica = "Nível Ótimo";
                }

            }
            if ((idade > 19) && (idade <= 29)) {
                if (quantidade <= 9) {
                    classifica = "Nível Ruim";
                }
                if ((quantidade > 9) && (quantidade <= 14)) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 14) && (quantidade <= 20)) {
                    classifica = "Nível Médio";
                }
                if ((quantidade > 20) && (quantidade <= 29)) {
                    classifica = "Nível Bom";
                }
                if (quantidade > 29) {
                    classifica = "Nível Ótimo";
                }

            }
            if ((idade > 29) && (idade <= 39)) {
                if (quantidade <= 7) {
                    classifica = "Nível Ruim";
                }
                if ((quantidade > 7) && (quantidade <= 12)) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 12) && (quantidade <= 19)) {
                    classifica = "Nível Médio";
                }
                if ((quantidade > 19) && (quantidade <= 26)) {
                    classifica = "Nível Bom";
                }
                if (quantidade > 26) {
                    classifica = "Nível Ótimo";
                }

            }
            if ((idade > 39) && (idade <= 49)) {
                if (quantidade <= 4) {
                    classifica = "Nível Ruim";
                }
                if ((quantidade > 4) && (quantidade <= 10)) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 10) && (quantidade <= 14)) {
                    classifica = "Nível Médio";
                }
                if ((quantidade > 14) && (quantidade <= 23)) {
                    classifica = "Nível Bom";
                }
                if (quantidade > 23) {
                    classifica = "Nível Ótimo";
                }

            }
            if (idade > 49) {
                if (quantidade <= 1) {
                    classifica = "Nível Ruim";
                }
                if ((quantidade > 1) && (quantidade <= 6)) {
                    classifica = "Nível Fraco";
                }
                if ((quantidade > 6) && (quantidade <= 10)) {
                    classifica = "Nível Médio";
                }
                if ((quantidade > 10) && (quantidade <= 20)) {
                    classifica = "Nível Bom";
                }
                if (quantidade > 20) {
                    classifica = "Nível Ótimo";
                }

            }

        }

    }

    public void johnson01bola() {

        //Protocolo de Johonson & Nelson - Teste de lançar a bola
        s0 = distancia * 100;

        if (sexo.equals("Masculino")) {
            if (s0 <= 274) {
                classifica = "Nível Fraco";
            }
            if ((s0 > 274) && (s0 <= 366)) {
                classifica = "Nível Regular";
            }
            if ((s0 > 366) && (s0 <= 610)) {
                classifica = "Nível Bom";
            }
            if ((s0 > 610) && (s0 <= 762)) {
                classifica = "Nível Muito Bom";
            }
            if (s0 > 762) {
                classifica = "Nível Excelente";
            }

        }
        if (sexo.equals("Feminino")) {
            if (s0 <= 122) {
                classifica = "Nível Fraco";
            }
            if ((s0 > 122) && (s0 <= 213)) {
                classifica = "Nível Regular";
            }
            if ((s0 > 213) && (s0 <= 366)) {
                classifica = "Nível Bom";
            }
            if ((s0 > 366) && (s0 <= 427)) {
                classifica = "Nível Muito Bom";
            }
            if (s0 > 427) {
                classifica = "Nível Excelente";
            }

        }

    }

    public void johnson02saltovert() {
        //Protocolo de Johonson & Nelson - Teste de salto vertical
        if (sexo.equals("Masculino")) {
            if (idade <= 14) {
                if (distancia <= 44) {
                    classifica = "Nível Fraco";
                }
                if ((distancia > 44) && (distancia <= 50)) {
                    classifica = "Nível Regular";
                }
                if ((distancia > 50) && (distancia <= 57)) {
                    classifica = "Nível Bom";
                }
                if ((distancia > 57) && (distancia <= 64)) {
                    classifica = "Nível Muito Bom";
                }
                if (distancia > 64) {
                    classifica = "Excelente";
                }

            }
            if ((idade > 14) && (idade <= 16)) {
                if (distancia <= 49) {
                    classifica = "Nível Fraco";
                }
                if ((distancia > 49) && (distancia <= 55)) {
                    classifica = "Nível Regular";
                }
                if ((distancia > 55) && (distancia <= 62)) {
                    classifica = "Nível Bom";
                }
                if ((distancia > 62) && (distancia <= 69)) {
                    classifica = "Nível Muito Bom";
                }
                if (distancia > 66) {
                    classifica = "Excelente";
                }

            }
            if ((idade > 16) && (idade <= 18)) {
                if (distancia <= 57) {
                    classifica = "Nível Fraco";
                }
                if ((distancia > 57) && (distancia <= 64)) {
                    classifica = "Nível Regular";
                }
                if ((distancia > 64) && (distancia <= 72)) {
                    classifica = "Nível Bom";
                }
                if ((distancia > 72) && (distancia <= 80)) {
                    classifica = "Nível Muito Bom";
                }
                if (distancia > 80) {
                    classifica = "Excelente";
                }

            }
            if (idade > 18) {
                if (distancia <= 60) {
                    classifica = "Nível Fraco";
                }
                if ((distancia > 60) && (distancia <= 67)) {
                    classifica = "Nível Regular";
                }
                if ((distancia > 67) && (distancia <= 75)) {
                    classifica = "Nível Bom";
                }
                if ((distancia > 75) && (distancia <= 83)) {
                    classifica = "Nível Muito Bom";
                }
                if (distancia > 83) {
                    classifica = "Excelente";
                }

            }

        }
        if (sexo.equals("Feminino")) {
            if (idade <= 14) {
                if (distancia <= 42) {
                    classifica = "Nível Fraco";
                }
                if ((distancia > 42) && (distancia <= 48)) {
                    classifica = "Nível Regular";
                }
                if ((distancia > 48) && (distancia <= 55)) {
                    classifica = "Nível Bom";
                }
                if ((distancia > 55) && (distancia <= 62)) {
                    classifica = "Nível Muito Bom";
                }
                if (distancia > 62) {
                    classifica = "Excelente";
                }

            }
            if ((idade > 14) && (idade <= 16)) {
                if (distancia <= 44) {
                    classifica = "Nível Fraco";
                }
                if ((distancia > 44) && (distancia <= 50)) {
                    classifica = "Nível Regular";
                }
                if ((distancia > 50) && (distancia <= 57)) {
                    classifica = "Nível Bom";
                }
                if ((distancia > 57) && (distancia <= 64)) {
                    classifica = "Nível Muito Bom";
                }
                if (distancia > 64) {
                    classifica = "Excelente";
                }

            }
            if ((idade > 16) && (idade <= 18)) {
                if (distancia <= 48) {
                    classifica = "Nível Fraco";
                }
                if ((distancia > 48) && (distancia <= 54)) {
                    classifica = "Nível Regular";
                }
                if ((distancia > 54) && (distancia <= 61)) {
                    classifica = "Nível Bom";
                }
                if ((distancia > 61) && (distancia <= 68)) {
                    classifica = "Nível Muito Bom";
                }
                if (distancia > 68) {
                    classifica = "Excelente";
                }

            }
            if (idade > 18) {
                if (distancia <= 60) {
                    classifica = "Nível Fraco";
                }
                if ((distancia > 60) && (distancia <= 56)) {
                    classifica = "Nível Regular";
                }
                if ((distancia > 56) && (distancia <= 63)) {
                    classifica = "Nível Bom";
                }
                if ((distancia > 63) && (distancia <= 70)) {
                    classifica = "Nível Muito Bom";
                }
                if (distancia > 70) {
                    classifica = "Excelente";
                }

            }

        }

    }

    public void johnson02saltohori() {
        //Protocolo de Johonson & Nelson - Teste de salto Horizontal
        s0 = distancia * 100;

        if (sexo.equals("Masculino")) {
            if (idade <= 12) {
                if (s0 <= 179) {
                    classifica = "Nível Fraco";
                }
                if ((s0 > 179) && (s0 <= 189)) {
                    classifica = "Nível Regular";
                }
                if ((s0 > 189) && (s0 <= 199)) {
                    classifica = "Nível Bom";
                }
                if ((s0 > 199) && (s0 <= 209)) {
                    classifica = "Nível Muito Bom";
                }
                if (s0 > 209) {
                    classifica = "Nível Excelente";

                }

            }
            if ((idade > 12) && (idade <= 14)) {
                if (s0 <= 206) {
                    classifica = "Nível Fraco";
                }
                if ((s0 > 206) && (s0 <= 220)) {
                    classifica = "Nível Regular";
                }
                if ((s0 > 220) && (s0 <= 231)) {
                    classifica = "Nível Bom";
                }
                if ((s0 > 231) && (s0 <= 245)) {
                    classifica = "Nível Muito Bom";
                }
                if (s0 > 245) {
                    classifica = "Nível Excelente";

                }

            }
            if ((idade > 14) && (idade <= 16)) {
                if (s0 <= 228) {
                    classifica = "Nível Fraco";
                }
                if ((s0 > 228) && (s0 <= 242)) {
                    classifica = "Nível Regular";
                }
                if ((s0 > 242) && (s0 <= 256)) {
                    classifica = "Nível Bom";
                }
                if ((s0 > 256) && (s0 <= 270)) {
                    classifica = "Nível Muito Bom";
                }
                if (s0 > 270) {
                    classifica = "Nível Excelente";

                }

            }
            if (idade > 16) {
                if (s0 <= 230) {
                    classifica = "Nível Fraco";
                }
                if ((s0 > 230) && (s0 <= 249)) {
                    classifica = "Nível Regular";
                }
                if ((s0 > 249) && (s0 <= 269)) {
                    classifica = "Nível Bom";
                }
                if ((s0 > 269) && (s0 <= 289)) {
                    classifica = "Nível Muito Bom";
                }
                if (s0 > 289) {
                    classifica = "Nível Excelente";

                }

            }

        }

        if (sexo.equals("Feminino")) {
            if (idade <= 12) {
                if (s0 <= 177) {
                    classifica = "Nível Fraco";
                }
                if ((s0 > 177) && (s0 <= 185)) {
                    classifica = "Nível Regular";
                }
                if ((s0 > 185) && (s0 <= 193)) {
                    classifica = "Nível Bom";
                }
                if ((s0 > 193) && (s0 <= 201)) {
                    classifica = "Nível Muito Bom";
                }
                if (s0 > 201) {
                    classifica = "Nível Excelente";

                }

            }
            if ((idade > 12) && (idade <= 14)) {
                if (s0 <= 182) {
                    classifica = "Nível Fraco";
                }
                if ((s0 > 182) && (s0 <= 187)) {
                    classifica = "Nível Regular";
                }
                if ((s0 > 187) && (s0 <= 195)) {
                    classifica = "Nível Bom";
                }
                if ((s0 > 195) && (s0 <= 207)) {
                    classifica = "Nível Muito Bom";
                }
                if (s0 > 207) {
                    classifica = "Nível Excelente";

                }

            }
            if ((idade > 14) && (idade <= 16)) {
                if (s0 <= 191) {
                    classifica = "Nível Fraco";
                }
                if ((s0 > 191) && (s0 <= 198)) {
                    classifica = "Nível Regular";
                }
                if ((s0 > 198) && (s0 <= 205)) {
                    classifica = "Nível Bom";
                }
                if ((s0 > 205) && (s0 <= 212)) {
                    classifica = "Nível Muito Bom";
                }
                if (s0 > 212) {
                    classifica = "Nível Excelente";

                }

            }
            if (idade > 16) {
                if (s0 <= 230) {
                    classifica = "Nível Fraco";
                }
                if ((s0 > 230) && (s0 <= 249)) {
                    classifica = "Nível Regular";
                }
                if ((s0 > 249) && (s0 <= 269)) {
                    classifica = "Nível Bom";
                }
                if ((s0 > 269) && (s0 <= 289)) {
                    classifica = "Nível Muito Bom";
                }
                if (s0 > 289) {
                    classifica = "Nível Excelente";

                }

            }

        }

    }

    public void eurofit02suste() {
        //Protocolo da Eurofit - Teste de sustentação vertical

        if (sexo.equals("Masculino")) {
            if (idade <= 10) {
                if (tempo <= 0.12) {
                    classifica = "Nível Fraco";
                }
                if ((tempo > 0.12) && (tempo <= 0.21)) {
                    classifica = "Nível Regular";
                }
                if ((tempo > 0.21) && (tempo <= 0.31)) {
                    classifica = "Nível Bom";
                }
                if ((tempo > 0.31) && (tempo <= 0.41)) {
                    classifica = "Nível Muito Bom";
                }
                if (tempo > 0.41) {
                    classifica = "Excelente";
                }

            }
            if ((idade > 10) && (idade <= 12)) {
                if (tempo <= 0.17) {
                    classifica = "Nível Fraco";
                }
                if ((tempo > 0.17) && (tempo <= 0.27)) {
                    classifica = "Nível Regular";
                }
                if ((tempo > 0.27) && (tempo <= 0.37)) {
                    classifica = "Nível Bom";
                }
                if ((tempo > 0.37) && (tempo <= 0.47)) {
                    classifica = "Nível Muito Bom";
                }
                if (tempo > 0.47) {
                    classifica = "Excelente";
                }

            }
            if ((idade > 12) && (idade <= 15)) {
                if (tempo <= 0.21) {
                    classifica = "Nível Fraco";
                }
                if ((tempo > 0.21) && (tempo <= 0.31)) {
                    classifica = "Nível Regular";
                }
                if ((tempo > 0.31) && (tempo <= 0.41)) {
                    classifica = "Nível Bom";
                }
                if ((tempo > 0.41) && (tempo <= 0.51)) {
                    classifica = "Nível Muito Bom";
                }
                if (tempo > 0.51) {
                    classifica = "Excelente";
                }

            }
            if (idade > 15) {
                if (tempo <= 0.24) {
                    classifica = "Nível Fraco";
                }
                if ((tempo > 0.24) && (tempo <= 0.34)) {
                    classifica = "Nível Regular";
                }
                if ((tempo > 0.34) && (tempo <= 0.44)) {
                    classifica = "Nível Bom";
                }
                if ((tempo > 0.44) && (tempo <= 0.54)) {
                    classifica = "Nível Muito Bom";
                }
                if (tempo > 0.54) {
                    classifica = "Excelente";
                }

            }

        }

        if (sexo.equals("Feminino")) {
            if (idade <= 10) {
                if (tempo <= 0.8) {
                    classifica = "Nível Fraco";
                }
                if ((tempo > 0.8) && (tempo <= 0.16)) {
                    classifica = "Nível Regular";
                }
                if ((tempo > 0.16) && (tempo <= 0.24)) {
                    classifica = "Nível Bom";
                }
                if ((tempo > 0.24) && (tempo <= 0.32)) {
                    classifica = "Nível Muito Bom";
                }
                if (tempo > 0.32) {
                    classifica = "Excelente";
                }

            }
            if ((idade > 10) && (idade <= 12)) {
                if (tempo <= 0.15) {
                    classifica = "Nível Fraco";
                }
                if ((tempo > 0.15) && (tempo <= 0.23)) {
                    classifica = "Nível Regular";
                }
                if ((tempo > 0.23) && (tempo <= 0.31)) {
                    classifica = "Nível Bom";
                }
                if ((tempo > 0.31) && (tempo <= 0.39)) {
                    classifica = "Nível Muito Bom";
                }
                if (tempo > 0.39) {
                    classifica = "Excelente";
                }

            }
            if ((idade > 12) && (idade <= 15)) {
                if (tempo <= 0.18) {
                    classifica = "Nível Fraco";
                }
                if ((tempo > 0.18) && (tempo <= 0.26)) {
                    classifica = "Nível Regular";
                }
                if ((tempo > 0.26) && (tempo <= 0.34)) {
                    classifica = "Nível Bom";
                }
                if ((tempo > 0.34) && (tempo <= 0.42)) {
                    classifica = "Nível Muito Bom";
                }
                if (tempo > 0.42) {
                    classifica = "Excelente";
                }

            }
            if (idade > 15) {
                if (tempo <= 0.24) {
                    classifica = "Nível Fraco";
                }
                if ((tempo > 0.24) && (tempo <= 0.34)) {
                    classifica = "Nível Regular";
                }
                if ((tempo > 0.34) && (tempo <= 0.44)) {
                    classifica = "Nível Bom";
                }
                if ((tempo > 0.44) && (tempo <= 0.54)) {
                    classifica = "Nível Muito Bom";
                }
                if (tempo > 0.54) {
                    classifica = "Excelente";
                }

            }

        }

    }

    public void johnson03hiperextensao() {
        //PROTOCOLO DE JOHNSON & NELSON -Teste de hiper-extensão:

        if (sexo.equals("Masculino")) {
            if (distancia <= 120) {
                classifica = "Nível Deficiente";
            }
            if ((distancia > 120) && (distancia <= 130)) {
                classifica = "nìvel Normal";
            }
            if (distancia > 130) {
                classifica = "Nível Muito Bom";
            }

        }
        if (sexo.equals("Feminino")) {
            if (distancia <= 70) {
                classifica = "Nível Deficiente";
            }
            if ((distancia > 70) && (distancia <= 90)) {
                classifica = "nìvel Normal";
            }
            if (distancia > 90) {
                classifica = "Nível Muito Bom";
            }

        }

    }
}
