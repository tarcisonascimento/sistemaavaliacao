package br.com.sa.classes;

public class CalculoDebitoCardiaco {
   public double vo2, DCresultado, operador, operador1, peso;
    
    public void falkner1(){
    //para homens e mulheres nao atletas menores de 40 anos 
    operador = vo2 * 0.52;
    DCresultado = operador + 6.6;

    }
     public void falkner2(){
    //para homens e mulheres nao atletas maiores de 40 anos 
    operador = vo2 * 0.59;
    DCresultado = operador + 4.9;

    }
     public void falkner3(){
    //para homens e mulheres Atletas
    operador = vo2 * 0.545;
    DCresultado = operador + 7.7;

    }
     public void hossack1(){
     //para homens geral    
     operador = peso * 0.0046;
     operador1 = vo2 * operador;
     DCresultado = operador1 + 5.31;
     
     }
     public void hossack2(){
     //para mulheres geral    
     operador = peso * 0.00407;
     operador1 = vo2 * operador;
     DCresultado = operador1 + 4.72;
     
     }
    
}
