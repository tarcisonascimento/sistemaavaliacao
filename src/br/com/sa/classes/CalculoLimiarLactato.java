package br.com.sa.classes;

//aqui vão os calculos do limiar de lactato sanguineo
public class CalculoLimiarLactato {
    
    public double s0,s1,resultado,tempo,idade,peso,estatura;
    public String sexo,classifica;

    
    
    public void simoes01 (){
    //PROTOCOLO DE SIMÕES - TESTE DE 700 m:
    s0 = 700 / tempo;
    s1 = s0 * 1.015;
    resultado = s1 - 5.025;   
    
    
    
    }
    
     public void simoes02 (){
    //PROTOCOLO DE SIMÕES - TESTE DE 3000 m:
    
    s0 = 3000 / tempo;
    s1 = s0 * 0.97;
    resultado = s1 - 15.81;   
    
    
    
    }
     
     public void classificalimiar (){
     
         if(resultado < 130){
         
               classifica = "Nível Fraco";

         }
         if((resultado >= 130) && (resultado < 150)){
         
               classifica = "Nível Razoavel";

         }
         if((resultado >= 150) && (resultado < 170)){
         
               classifica = "Nível Bom";

         }
         if((resultado >= 170) && (resultado < 190)){
         
               classifica = "Muito Bom";

         }
         if(resultado >= 190){
         
               classifica = "Excelente";

         }
     
     
     }
    
}
