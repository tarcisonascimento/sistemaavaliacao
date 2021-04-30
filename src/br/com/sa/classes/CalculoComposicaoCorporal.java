package br.com.sa.classes;

public class CalculoComposicaoCorporal {
    //calculo percentual de gordura
    public double denscorp, percentgord,s0,s1;
    public void percentualGordura(){
    //protocolo de siri 1961

        s0 = 4.95 / denscorp;
        s1 = s0 - 4.50;
        percentgord = s1 * 100;

    }

    //calculo do peso osseo
    public double soma1,diaradio, diafemur, retpesoosseo,operador,operador3, operador4, estatura,multiplicador;
    public void pesoosseo() {
        operador = estatura * estatura;
        operador3 = diaradio / 100;
        operador4 = diafemur / 100;
        multiplicador = operador * operador3 * operador4 * 400;
        soma1 = Math.pow(multiplicador,0.712);//caluculando a potencia
        retpesoosseo = soma1 * 3.02;
        /*calcular a potencia
        Math.pow(x, y);
        calcular a raiz com base 125
        Math.pow(125,(1/multiplicador));
         */
    }
    //calculo peso residual
    public double pct, retpesoresidual;
    public String sexo;
    public void pesoresidual(){
    
        if (sexo.equals("Masculino")){
        retpesoresidual = pct * 0.241;
        }
        if (sexo.equals("Feminino")){
        retpesoresidual = pct * 0.209;
        }
   
    }
    //calculo peso muscular
    public double pmgordura, pmosso,pmresidual,pmpct,retpesmusc,operador5, op1;
    public void pesomuscular (){
    op1 = pmgordura * pmpct / 100;
    operador5 = op1 + pmosso + pmresidual;
    retpesmusc = pmpct - operador5;

    }
    //estimativa da gordura absoluta
    public double retgabs, gapercegordura, gapct, operador6;
    public void gorduraabsoluta(){
    operador6 = gapercegordura / 100;
    retgabs = gapct * operador6;
    
    }
    //calculo massa magra ideial 
    public double mmpct,gaabs,retmm;
    public void massamagraideal (){
        retmm = mmpct - gaabs;
    }
    //calculo do peso ideal
    public double retpi,pimm;
    public void pesoideal (){
        if (sexo.equals("Masculino")){
            retpi = pimm / 0.85;
        }
        if (sexo.equals("Feminino")){
            retpi = pimm / 0.75;
        } 
    }
    //calculo do peso em excesso
    public double retpe, pepct, pepi;
    public void pesoee (){
    retpe = pepct - pepi;
    }
    
}
