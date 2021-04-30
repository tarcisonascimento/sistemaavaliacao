package br.com.sa.classes;

public class CalculoCapacidadeAerobica {

    public double dist, idade, peso, estatura, tempoMin, tempoSeg, resultado, fc, fc4, fc5, watts;
    public int estagio;
    public String sexo, classificado, quadro;
    double s0, s1, s2, s3, s4, s5, s6, s7, s8;

    public void astrandbicicleta() {
        //Protocolo de Astrand cicloergometro estacionario duraçao de 4 a 5 min

        s0 = 0.014 * watts;
        s1 = s0 + 0.129;
        s6 = fc4 + fc5;
        fc = s6 / 2;

        if (sexo.equals("Masculino")) {
            s2 = fc - 61;
            s3 = 134 / s2;
            s4 = s3 * s1;
            s5 = s4 / peso;
            resultado = s5 * 1000;

        }
        if (sexo.equals("Feminino")) {

            s2 = fc - 72;
            s3 = 126 / s2;
            s4 = s3 * s1;
            s5 = s4 / peso;
            resultado = s5 * 1000;

        }

        /*
            Protocolo de Astrand (Submáximo)

metodologia: escolha uma carga inicial de trabalho que varia de acordo com o sexo. Para o sexo masculino a carga deve variar entre 100 a 150 Watts e para mulheres entre 50 a 100 Watts. O avaliado deverá pedalar durante 5 minutos; registra-se a FC do 4º e 5º minutos, e se obtém o valor médio. A FC de carga deverá estar entre 120 e 170 bpm e , preferencialmente acima de 140 para os jovens (Araújo, 1984). 
         */
    }

    public void bruceesteira8est() {
        //protocolo de bruce 1.609 km ou uma milha sedentarios cardiopatas homem ativo mulher ativa

        s8 = tempoSeg / 600;
        s7 = tempoMin + s8;
        tempoMin = s7;
        
        if (quadro.equals("Cardiopata")) {
            s0 = 2.327 * tempoMin;
            resultado = s0 + 9.48;
        }
        if (quadro.equals("Sedentário (a)")) {
            s0 = 3.288 * tempoMin;
            resultado = s0 + 4.07;
        }
        if (quadro.equals("Homem Ativo")) {
            s0 = 3.778 * tempoMin;
            resultado = s0 + 0.19;
        }
        if (quadro.equals("Mulher Ativa")) {
            s0 = 3.36 * tempoMin;
            resultado = s0 + 1.06;
        }

    }

    public void bruceesteira6est() {
        //protocolo de bruce na esteira 6 estagios adaptado

        switch (estagio) {

            case 1:
                resultado = 6.4;
                break;
            case 2:
                resultado = 10.00;
                break;
            case 3:
                resultado = 15.00;
                break;
            case 4:
                resultado = 25.00;
                break;
            case 5:
                resultado = 35.00;
                break;
            case 6:
                resultado = 45.00;
                break;
            default:
                resultado = 00.00;
                break;
        }

    }

    public void ellestadesteira() {
        // protocolo ellestad 8 estagios na esteira com inclinaçao

        s1 = tempoSeg /600;
        s2 = tempoMin + s1;
        s0 = 3.933 * s2;
        resultado = 4.46 + s0;

    }

    public void cooper12Min() {
        //PROTOCOLO DE COOPER - TESTE DE 12 min

        s0 = dist - 504.8;
        resultado = s0 / 44.9;

    }

    public void cooper2400mts() {
        // PROTOCOLO DE COOPER - TESTE DE 2400 m:
        s0 = tempoMin * 60;
        s1 = s0 + tempoSeg;
        resultado = 28803.5 / s1;

    }

    public void rodrigues1600mts() {
        //PROTOCOLO DE RODRIGUES DE ALMEIDA -TESTE DE 1600 m
        s0 = tempoSeg / 600;
        s1 = tempoMin + s0;
        s2 = s1 * 13.89;
        resultado = 133.61 - s2;

    }

    public void ribsl3200m() {
        //PROTOCOLO DE RIBISL & KACHODORIAN -TESTE DE 3200m:
        s0 = tempoMin * 60;
        s1 = s0 + tempoSeg;
        s2 = 0.04689 * s1;
        s3 = 0.37817 * idade;
        s4 = 0.15406 * peso;
        resultado = 114.496 - s2 - s3 - s4;

    }

    public void weltman3200mts() {
        // PROTOCOLO DE WELTMAN -TESTE DE 3200 m:
        s0 = tempoSeg / 600;
        s1 = tempoMin + s0;
        s2 = 4.774 * s1;
        resultado = 118.49 - s2;

    }

    public void klissouras1000mts() {
        //PROTOCOLO DE KLISSOURAS - TESTE DE 1000 m:
        s0 = tempoMin * 60;
        s1 = s0 + tempoSeg;
        s2 = 652.17 - s1;
        resultado = s2 / 6.762;

    }

    public void balke15min() {
        //PROTOCOLO DE BALKE - TESTE DE 15 min:
        s0 = dist / tempoMin;
        s1 = s0 - 133;
        s2 = s1 * 1.178;
        resultado = 33 + s2;

    }

    public void caft1200mts() {
        //PROTOCOLO DO Canadian Aerobic Fitness Test (CAFT) - TESTE DE 1200 m:

        if (sexo.equals("Masculino")) {

            s0 = tempoSeg / 600;
            s1 = tempoMin + s0;

            s2 = 0.0091 * peso;
            s3 = 0.0257 * idade;
            s4 = 0.5955 * 1;
            s5 = 0.2240 * s1;
            s6 = 0.0115 * fc;
            //resultado em litros      
            s7 = 6.952 + s2 - s3 + s4 - s5 - s6;
            //convertendo de litros para ml
            s8 = s7 / peso;
            resultado = s8 * 1000;

        }
        if (sexo.equals("Feminino")) {

            s0 = tempoSeg / 600;
            s1 = tempoMin + s0;

            s2 = 0.0091 * peso;
            s3 = 0.0257 * idade;
            s4 = 0.5955 * 0;
            s5 = 0.2240 * s1;
            s6 = 0.0115 * fc;
            //resultado em litros
            s7 = 6.952 + s2 - s3 + s4 - s5 - s6;
            //convertendo de litros para ml
            s8 = s7 / peso;
            resultado = s8 * 1000;

        }

    }

    public void rockport1600mts() {
        // PROTOCOLO DE ROCKPORT- TESTE DE 1600 m:
        if (sexo.equals("Masculino")) {

            s0 = tempoSeg / 600;
            s1 = tempoMin + s0;

            s2 = 0.17 * peso;
            s3 = 0.39 * idade;
            s4 = 6.31 * 1;
            s5 = 3.27 * s1;
            s6 = 0.156 * fc;

            resultado = 132.6 - s2 - s3 + s4 - s5 - s6;

        }
        if (sexo.equals("Feminino")) {

            s0 = tempoSeg / 600;
            s1 = tempoMin + s0;

            s2 = 0.17 * peso;
            s3 = 0.39 * idade;
            s4 = 6.31 * 0;
            s5 = 3.27 * s1;
            s6 = 0.156 * fc;

            resultado = 132.6 - s2 - s3 + s4 - s5 - s6;

        }
    }

    public void classificavo2() {
        //o metodo abaixo classifica o vo2 de acordo com a idade e sexo

        if (sexo.equals("Masculino")) {

            if (idade <= 19) {

                if (resultado <= 35) {
                    classificado = "Muito Fraco";
                }
                if (resultado > 35 && resultado <= 38.3) {
                    classificado = "Nivel Fraco";
                }
                if (resultado > 38.3 && resultado <= 45) {
                    classificado = "Nivel Regular";
                }
                if (resultado > 45 && resultado <= 50.9) {
                    classificado = "Nivel Bom";
                }
                if (resultado > 50.9 && resultado <= 55.9) {
                    classificado = "Nivel Exelente";
                }
                if (resultado > 55.9) {
                    classificado = "Nivel Superior";
                }

            }
            if (idade > 19 && idade <= 29) {

                if (resultado <= 33) {
                    classificado = "Muito Fraco";
                }
                if (resultado > 33 && resultado <= 36.4) {
                    classificado = "Nivel Fraco";
                }
                if (resultado > 36.4 && resultado <= 42.4) {
                    classificado = "Nivel Regular";
                }
                if (resultado > 42.4 && resultado <= 46.4) {
                    classificado = "Nivel Bom";
                }
                if (resultado > 46.4 && resultado <= 52.4) {
                    classificado = "Nivel Exelente";
                }
                if (resultado > 52.4) {
                    classificado = "Nivel Superior";
                }

            }
            if (idade > 29 && idade <= 39) {

                if (resultado <= 31.5) {
                    classificado = "Muito Fraco";
                }
                if (resultado > 31.5 && resultado <= 35.4) {
                    classificado = "Nivel Fraco";
                }
                if (resultado > 35.4 && resultado <= 40.9) {
                    classificado = "Nivel Regular";
                }
                if (resultado > 40.9 && resultado <= 44.9) {
                    classificado = "Nivel Bom";
                }
                if (resultado > 44.9 && resultado <= 49.4) {
                    classificado = "Nivel Exelente";
                }
                if (resultado > 49.4) {
                    classificado = "Nivel Superior";
                }

            }
            if (idade > 39 && idade <= 49) {

                if (resultado <= 30.2) {
                    classificado = "Muito Fraco";
                }
                if (resultado > 30.2 && resultado <= 33.5) {
                    classificado = "Nivel Fraco";
                }
                if (resultado > 33.5 && resultado <= 38.9) {
                    classificado = "Nivel Regular";
                }
                if (resultado > 38.9 && resultado <= 43.7) {
                    classificado = "Nivel Bom";
                }
                if (resultado > 43.7 && resultado <= 48) {
                    classificado = "Nivel Exelente";
                }
                if (resultado > 48) {
                    classificado = "Nivel Superior";
                }

            }
            if (idade > 49 && idade <= 59) {

                if (resultado <= 26.1) {
                    classificado = "Muito Fraco";
                }
                if (resultado > 26.1 && resultado <= 30.9) {
                    classificado = "Nivel Fraco";
                }
                if (resultado > 30.9 && resultado <= 35.7) {
                    classificado = "Nivel Regular";
                }
                if (resultado > 35.7 && resultado <= 40.9) {
                    classificado = "Nivel Bom";
                }
                if (resultado > 40.9 && resultado <= 45.3) {
                    classificado = "Nivel Exelente";
                }
                if (resultado > 45.3) {
                    classificado = "Nivel Superior";
                }

            }
            if (idade > 59) {

                if (resultado <= 20.5) {
                    classificado = "Muito Fraco";
                }
                if (resultado > 20.5 && resultado <= 26) {
                    classificado = "Nivel Fraco";
                }
                if (resultado > 26 && resultado <= 32.2) {
                    classificado = "Nivel Regular";
                }
                if (resultado > 32.2 && resultado <= 36.4) {
                    classificado = "Nivel Bom";
                }
                if (resultado > 36.4 && resultado <= 44.2) {
                    classificado = "Nivel Exelente";
                }
                if (resultado > 44.2) {
                    classificado = "Nivel Superior";
                }

            }
        }
        if (sexo.equals("Feminino")) {

            if (idade <= 19) {

                if (resultado <= 25) {
                    classificado = "Muito Fraco";
                }
                if (resultado > 25 && resultado <= 30.9) {
                    classificado = "Nivel Fraco";
                }
                if (resultado > 30.9 && resultado <= 34.9) {
                    classificado = "Nivel Regular";
                }
                if (resultado > 34.9 && resultado <= 38.9) {
                    classificado = "Nivel Bom";
                }
                if (resultado > 38.9 && resultado <= 41.9) {
                    classificado = "Nivel Exelente";
                }
                if (resultado > 41.9) {
                    classificado = "Nivel Superior";
                }

            }
            if (idade > 19 && idade <= 29) {

                if (resultado <= 23.6) {
                    classificado = "Muito Fraco";
                }
                if (resultado > 23.6 && resultado <= 28.9) {
                    classificado = "Nivel Fraco";
                }
                if (resultado > 28.9 && resultado <= 32.9) {
                    classificado = "Nivel Regular";
                }
                if (resultado > 32.9 && resultado <= 36.9) {
                    classificado = "Nivel Bom";
                }
                if (resultado > 36.9 && resultado <= 40.9) {
                    classificado = "Nivel Exelente";
                }
                if (resultado > 40.9) {
                    classificado = "Nivel Superior";
                }

            }
            if (idade > 29 && idade <= 39) {

                if (resultado <= 22.8) {
                    classificado = "Muito Fraco";
                }
                if (resultado > 22.8 && resultado <= 26.9) {
                    classificado = "Nivel Fraco";
                }
                if (resultado > 26.9 && resultado <= 31.4) {
                    classificado = "Nivel Regular";
                }
                if (resultado > 31.4 && resultado <= 35.6) {
                    classificado = "Nivel Bom";
                }
                if (resultado > 35.6 && resultado <= 40) {
                    classificado = "Nivel Exelente";
                }
                if (resultado > 40) {
                    classificado = "Nivel Superior";
                }

            }
            if (idade > 39 && idade <= 49) {

                if (resultado <= 21) {
                    classificado = "Muito Fraco";
                }
                if (resultado > 21 && resultado <= 24.4) {
                    classificado = "Nivel Fraco";
                }
                if (resultado > 24.4 && resultado <= 28.9) {
                    classificado = "Nivel Regular";
                }
                if (resultado > 28.9 && resultado <= 32.8) {
                    classificado = "Nivel Bom";
                }
                if (resultado > 32.8 && resultado <= 36.9) {
                    classificado = "Nivel Exelente";
                }
                if (resultado > 36.9) {
                    classificado = "Nivel Superior";
                }

            }
            if (idade > 49 && idade <= 59) {

                if (resultado <= 20) {
                    classificado = "Muito Fraco";
                }
                if (resultado > 20 && resultado <= 22.7) {
                    classificado = "Nivel Fraco";
                }
                if (resultado > 22.7 && resultado <= 26.9) {
                    classificado = "Nivel Regular";
                }
                if (resultado > 26.9 && resultado <= 31.4) {
                    classificado = "Nivel Bom";
                }
                if (resultado > 31.4 && resultado <= 37.7) {
                    classificado = "Nivel Exelente";
                }
                if (resultado > 35.7) {
                    classificado = "Nivel Superior";
                }

            }
            if (idade > 59) {

                if (resultado <= 17.5) {
                    classificado = "Muito Fraco";
                }
                if (resultado > 17.5 && resultado <= 20.1) {
                    classificado = "Nivel Fraco";
                }
                if (resultado > 20.1 && resultado <= 24.4) {
                    classificado = "Nivel Regular";
                }
                if (resultado > 24.4 && resultado <= 30.2) {
                    classificado = "Nivel Bom";
                }
                if (resultado > 30.2 && resultado <= 31.4) {
                    classificado = "Nivel Exelente";
                }
                if (resultado > 31.4) {
                    classificado = "Nivel Superior";
                }

            }
        }
    }

    public void classificapsina() {
        //FORMAS INDIRETAS / TIPO CAMPO / ERGÔMETRO PISCINA
        //PROTOCOLO DE COOPER - TESTE DE 12 min:

        if (sexo.equals("Masculino")) {

            if (idade <= 19) {

                if (resultado < 457) {
                    classificado = "Nivel Fraco";
                }
                if (resultado > 457 && resultado <= 548) {
                    classificado = "Nivel Regular";
                }
                if (resultado > 548 && resultado <= 639) {
                    classificado = "Nivel Bom";
                }
                if (resultado > 639 && resultado <= 731) {
                    classificado = "Nivel Exelente";
                }
                if (resultado > 731) {
                    classificado = "Nivel Superior";
                }

            }
            if (idade > 19 && idade <= 24) {
                if (resultado < 366) {
                    classificado = "Nivel Fraco";
                }
                if (resultado > 366 && resultado <= 456) {
                    classificado = "Nivel Regular";
                }
                if (resultado > 456 && resultado <= 548) {
                    classificado = "Nivel Bom";
                }
                if (resultado > 548 && resultado <= 639) {
                    classificado = "Nivel Exelente";
                }
                if (resultado > 639) {
                    classificado = "Nivel Superior";
                }

            }
            if (idade > 24 && idade <= 39) {

                if (resultado < 320) {
                    classificado = "Nivel Fraco";
                }
                if (resultado > 320 && resultado <= 411) {
                    classificado = "Nivel Regular";
                }
                if (resultado > 411 && resultado <= 502) {
                    classificado = "Nivel Bom";
                }
                if (resultado > 502 && resultado <= 593) {
                    classificado = "Nivel Exelente";
                }
                if (resultado > 593) {
                    classificado = "Nivel Superior";
                }

            }
            if (idade > 39 && idade <= 49) {

                if (resultado < 274) {
                    classificado = "Nivel Fraco";
                }
                if (resultado > 274 && resultado <= 365) {
                    classificado = "Nivel Regular";
                }
                if (resultado > 365 && resultado <= 456) {
                    classificado = "Nivel Bom";
                }
                if (resultado > 456 && resultado <= 548) {
                    classificado = "Nivel Exelente";
                }
                if (resultado > 548) {
                    classificado = "Nivel Superior";
                }

            }
            if (idade > 49 && idade <= 59) {

                if (resultado < 229) {
                    classificado = "Nivel Fraco";
                }
                if (resultado > 229 && resultado <= 319) {
                    classificado = "Nivel Regular";
                }
                if (resultado > 319 && resultado <= 411) {
                    classificado = "Nivel Bom";
                }
                if (resultado > 411 && resultado <= 502) {
                    classificado = "Nivel Exelente";
                }
                if (resultado > 502) {
                    classificado = "Nivel Superior";
                }

            }
            if (idade > 59) {

                if (resultado < 229) {
                    classificado = "Nivel Fraco";
                }
                if (resultado > 229 && resultado <= 273) {
                    classificado = "Nivel Regular";
                }
                if (resultado > 273 && resultado <= 365) {
                    classificado = "Nivel Bom";
                }
                if (resultado > 365 && resultado <= 456) {
                    classificado = "Nivel Exelente";
                }
                if (resultado > 456) {
                    classificado = "Nivel Superior";
                }

            }
        }
        if (sexo.equals("Feminino")) {

            if (idade <= 19) {

                if (resultado < 366) {
                    classificado = "Nivel Fraco";
                }
                if (resultado > 366 && resultado <= 456) {
                    classificado = "Nivel Regular";
                }
                if (resultado > 456 && resultado <= 548) {
                    classificado = "Nivel Bom";
                }
                if (resultado > 548 && resultado <= 639) {
                    classificado = "Nivel Exelente";
                }
                if (resultado > 639) {
                    classificado = "Nivel Superior";
                }

            }
            if (idade > 19 && idade <= 24) {
                if (resultado < 274) {
                    classificado = "Nivel Fraco";
                }
                if (resultado > 274 && resultado <= 365) {
                    classificado = "Nivel Regular";
                }
                if (resultado > 365 && resultado <= 456) {
                    classificado = "Nivel Bom";
                }
                if (resultado > 456 && resultado <= 548) {
                    classificado = "Nivel Exelente";
                }
                if (resultado > 548) {
                    classificado = "Nivel Superior";
                }

            }
            if (idade > 24 && idade <= 39) {

                if (resultado < 229) {
                    classificado = "Nivel Fraco";
                }
                if (resultado > 229 && resultado <= 319) {
                    classificado = "Nivel Regular";
                }
                if (resultado > 319 && resultado <= 411) {
                    classificado = "Nivel Bom";
                }
                if (resultado > 411 && resultado <= 502) {
                    classificado = "Nivel Exelente";
                }
                if (resultado > 502) {
                    classificado = "Nivel Superior";
                }

            }
            if (idade > 39 && idade <= 49) {

                if (resultado < 183) {
                    classificado = "Nivel Fraco";
                }
                if (resultado > 183 && resultado <= 273) {
                    classificado = "Nivel Regular";
                }
                if (resultado > 273 && resultado <= 365) {
                    classificado = "Nivel Bom";
                }
                if (resultado > 365 && resultado <= 456) {
                    classificado = "Nivel Exelente";
                }
                if (resultado > 456) {
                    classificado = "Nivel Superior";
                }

            }
            if (idade > 49 && idade <= 59) {

                if (resultado < 137) {
                    classificado = "Nivel Fraco";
                }
                if (resultado > 137 && resultado <= 228) {
                    classificado = "Nivel Regular";
                }
                if (resultado > 228 && resultado <= 319) {
                    classificado = "Nivel Bom";
                }
                if (resultado > 319 && resultado <= 411) {
                    classificado = "Nivel Exelente";
                }
                if (resultado > 411) {
                    classificado = "Nivel Superior";
                }

            }
            if (idade > 59) {

                if (resultado < 137) {
                    classificado = "Nivel Fraco";
                }
                if (resultado > 137 && resultado <= 182) {
                    classificado = "Nivel Regular";
                }
                if (resultado > 182 && resultado <= 273) {
                    classificado = "Nivel Bom";
                }
                if (resultado > 273 && resultado <= 365) {
                    classificado = "Nivel Exelente";
                }
                if (resultado > 365) {
                    classificado = "Nivel Superior";
                }

            }

        }
    }

    public void classificabike() {
        //FORMA INDIRETA / TIPO CAMPO / ERGÔMETRO CICLOMÓVEL:
        //PROTOCOLO DE COOPER - TESTE DE 12 min:

        if (sexo.equals("Masculino")) {

            if (idade <= 19) {

                if (resultado < 4420) {
                    classificado = "Nivel Fraco";
                }
                if (resultado > 4420 && resultado <= 6020) {
                    classificado = "Nivel Regular";
                }
                if (resultado > 6020 && resultado <= 7630) {
                    classificado = "Nivel Bom";
                }
                if (resultado > 7630 && resultado <= 9240) {
                    classificado = "Nivel Exelente";
                }
                if (resultado > 9240) {
                    classificado = "Nivel Superior";
                }

            }
            if (idade > 19 && idade <= 29) {
                if (resultado < 4020) {
                    classificado = "Nivel Fraco";
                }
                if (resultado > 4020 && resultado <= 5620) {
                    classificado = "Nivel Regular";
                }
                if (resultado > 5620 && resultado <= 7220) {
                    classificado = "Nivel Bom";
                }
                if (resultado > 7220 && resultado <= 8830) {
                    classificado = "Nivel Exelente";
                }
                if (resultado > 8830) {
                    classificado = "Nivel Superior";
                }

            }
            if (idade > 29 && idade <= 39) {

                if (resultado < 3620) {
                    classificado = "Nivel Fraco";
                }
                if (resultado > 3620 && resultado <= 5210) {
                    classificado = "Nivel Regular";
                }
                if (resultado > 5210 && resultado <= 6820) {
                    classificado = "Nivel Bom";
                }
                if (resultado > 6820 && resultado <= 8430) {
                    classificado = "Nivel Exelente";
                }
                if (resultado > 8430) {
                    classificado = "Nivel Superior";
                }

            }
            if (idade > 39 && idade <= 49) {

                if (resultado < 3220) {
                    classificado = "Nivel Fraco";
                }
                if (resultado > 3220 && resultado <= 4810) {
                    classificado = "Nivel Regular";
                }
                if (resultado > 4810 && resultado <= 6420) {
                    classificado = "Nivel Bom";
                }
                if (resultado > 6420 && resultado <= 8030) {
                    classificado = "Nivel Exelente";
                }
                if (resultado > 8030) {
                    classificado = "Nivel Superior";
                }

            }
            if (idade > 49 && idade <= 59) {

                if (resultado < 2820) {
                    classificado = "Nivel Fraco";
                }
                if (resultado > 2820 && resultado <= 4010) {
                    classificado = "Nivel Regular";
                }
                if (resultado > 4010 && resultado <= 5620) {
                    classificado = "Nivel Bom";
                }
                if (resultado > 5620 && resultado <= 7220) {
                    classificado = "Nivel Exelente";
                }
                if (resultado > 7220) {
                    classificado = "Nivel Superior";
                }

            }
            if (idade > 59) {

                if (resultado < 2820) {
                    classificado = "Nivel Fraco";
                }
                if (resultado > 2820 && resultado <= 3600) {
                    classificado = "Nivel Regular";
                }
                if (resultado > 3600 && resultado <= 4810) {
                    classificado = "Nivel Bom";
                }
                if (resultado > 4810 && resultado <= 6420) {
                    classificado = "Nivel Exelente";
                }
                if (resultado > 6420) {
                    classificado = "Nivel Superior";
                }

            }
        }
        if (sexo.equals("Feminino")) {

            if (idade <= 19) {

                if (resultado < 2820) {
                    classificado = "Nivel Fraco";
                }
                if (resultado > 2820 && resultado <= 4410) {
                    classificado = "Nivel Regular";
                }
                if (resultado > 4410 && resultado <= 6020) {
                    classificado = "Nivel Bom";
                }
                if (resultado > 6020 && resultado <= 7630) {
                    classificado = "Nivel Exelente";
                }
                if (resultado > 7630) {
                    classificado = "Nivel Superior";
                }

            }
            if (idade > 19 && idade <= 29) {
                if (resultado < 2410) {
                    classificado = "Nivel Fraco";
                }
                if (resultado > 2410 && resultado <= 4010) {
                    classificado = "Nivel Regular";
                }
                if (resultado > 4010 && resultado <= 5620) {
                    classificado = "Nivel Bom";
                }
                if (resultado > 5620 && resultado <= 7220) {
                    classificado = "Nivel Exelente";
                }
                if (resultado > 7220) {
                    classificado = "Nivel Superior";
                }

            }
            if (idade > 29 && idade <= 39) {

                if (resultado < 2010) {
                    classificado = "Nivel Fraco";
                }
                if (resultado > 2010 && resultado <= 3600) {
                    classificado = "Nivel Regular";
                }
                if (resultado > 3600 && resultado <= 5210) {
                    classificado = "Nivel Bom";
                }
                if (resultado > 5210 && resultado <= 6820) {
                    classificado = "Nivel Exelente";
                }
                if (resultado > 6820) {
                    classificado = "Nivel Superior";
                }

            }
            if (idade > 39 && idade <= 49) {

                if (resultado < 1610) {
                    classificado = "Nivel Fraco";
                }
                if (resultado > 1610 && resultado <= 3200) {
                    classificado = "Nivel Regular";
                }
                if (resultado > 3200 && resultado <= 4810) {
                    classificado = "Nivel Bom";
                }
                if (resultado > 4810 && resultado <= 6420) {
                    classificado = "Nivel Exelente";
                }
                if (resultado > 6420) {
                    classificado = "Nivel Superior";
                }

            }
            if (idade > 49 && idade <= 59) {

                if (resultado < 1210) {
                    classificado = "Nivel Fraco";
                }
                if (resultado > 1210 && resultado <= 2400) {
                    classificado = "Nivel Regular";
                }
                if (resultado > 2400 && resultado <= 4010) {
                    classificado = "Nivel Bom";
                }
                if (resultado > 4010 && resultado <= 5620) {
                    classificado = "Nivel Exelente";
                }
                if (resultado > 5620) {
                    classificado = "Nivel Superior";
                }

            }
            if (idade > 59) {

                if (resultado < 1210) {
                    classificado = "Nivel Fraco";
                }
                if (resultado > 1210 && resultado <= 2000) {
                    classificado = "Nivel Regular";
                }
                if (resultado > 2000 && resultado <= 3200) {
                    classificado = "Nivel Bom";
                }
                if (resultado > 3200 && resultado <= 4810) {
                    classificado = "Nivel Exelente";
                }
                if (resultado > 4810) {
                    classificado = "Nivel Superior";
                }

            }

        }

    }

}
