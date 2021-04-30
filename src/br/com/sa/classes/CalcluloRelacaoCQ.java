package br.com.sa.classes;


public class CalcluloRelacaoCQ {
    public double retorno, cintura, quadril, idade;
    public String sexo, clas;
    
    public void calculo (){
    
    retorno = cintura / quadril;
    
    if(sexo.equals("Masculino")){
    
        if (idade <= 30){
            if(retorno <= 0.83){
            clas = "Risco Baixo";
            }
            if (retorno >= 0.84 && retorno <= 0.88){
            clas = "Risco Médio";
            }
            if (retorno >= 0.89 && retorno <= 0.94){
            clas = "Risco Alto";
            }
            if (retorno > 0.94){
            clas = "Risco Elevado";
            }
        }
        
        if (idade > 30 && idade <= 39){
            if(retorno <= 0.84){
            clas = "Risco Baixo";
            }
            if (retorno >= 0.85 && retorno <= 0.91){
            clas = "Risco Médio";
            }
            if (retorno >= 0.92 && retorno <= 0.96){
            clas = "Risco Alto";
            }
            if (retorno > 0.96){
            clas = "Risco Elevado";
            }
        }
        if (idade >= 40 && idade <= 49){
            if(retorno <= 0.88){
            clas = "Risco Baixo";
            }
            if (retorno >= 0.89 && retorno <= 0.95){
            clas = "Risco Médio";
            }
            if (retorno >= 0.96 && retorno <= 1.00){
            clas = "Risco Alto";
            }
            if (retorno > 1.00){
            clas = "Risco Elevado";
            }
        }
        if (idade >= 50 && idade <= 59){
            if(retorno <= 0.90){
            clas = "Risco Baixo";
            }
            if (retorno > 0.90 && retorno <= 0.96){
            clas = "Risco Médio";
            }
            if (retorno >= 0.97 && retorno <= 1.02){
            clas = "Risco Alto";
            }
            if (retorno > 1.02){
            clas = "Risco Elevado";
            }
        }
        if (idade > 59){
            if(retorno <= 0.91){
            clas = "Risco Baixo";
            }
            if (retorno >= 0.92 && retorno <= 0.98){
            clas = "Risco Médio";
            }
            if (retorno >= 0.99 && retorno <= 1.03){
            clas = "Risco Alto";
            }
            if (retorno > 1.03){
            clas = "Risco Elevado";
            }
        }
    }
    if(sexo.equals("Feminino")){
    
        if (idade <= 30){
            if(retorno <= 0.71){
            clas = "Risco Baixo";
            }
            if (retorno >= 0.72 && retorno <= 0.77){
            clas = "Risco Médio";
            }
            if (retorno >= 0.78 && retorno <= 0.82){
            clas = "Risco Alto";
            }
            if (retorno > 0.82){
            clas = "Risco Elevado";
            }
        }
        
        if (idade > 30 && idade <= 39){
            if(retorno <= 0.72){
            clas = "Risco Baixo";
            }
            if (retorno >= 0.73 && retorno <= 0.78){
            clas = "Risco Médio";
            }
            if (retorno >= 0.79 && retorno <= 0.84){
            clas = "Risco Alto";
            }
            if (retorno > 0.84){
            clas = "Risco Elevado";
            }
        }
        if (idade >= 40 && idade <= 49){
            if(retorno <= 0.73){
            clas = "Risco Baixo";
            }
            if (retorno >= 0.74 && retorno <= 0.79){
            clas = "Risco Médio";
            }
            if (retorno >= 0.80 && retorno <= 0.87){
            clas = "Risco Alto";
            }
            if (retorno > 0.87){
            clas = "Risco Elevado";
            }
        }
        if (idade >= 50 && idade <= 59){
            if(retorno <= 0.74){
            clas = "Risco Baixo";
            }
            if (retorno >= 0.75 && retorno <= 0.81){
            clas = "Risco Médio";
            }
            if (retorno >= 0.82 && retorno <= 0.88){
            clas = "Risco Alto";
            }
            if (retorno > 0.88){
            clas = "Risco Elevado";
            }
        }
        if (idade > 59){
            if(retorno <= 0.76){
            clas = "Risco Baixo";
            }
            if (retorno >= 0.77 && retorno <= 0.83){
            clas = "Risco Médio";
            }
            if (retorno >= 0.84 && retorno <= 0.90){
            clas = "Risco Alto";
            }
            if (retorno > 0.90){
            clas = "Risco Elevado";
            }
        }
    }
    }
}
        
        

