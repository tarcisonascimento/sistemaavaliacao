package br.com.sa.classes;

//os parametros abaixo servem para calcular o imc
public class CalculoImc {
    
    public double imc, estatura, peso;
    public String classifica, obesidade;
    
//metodo calcular
    public void calculoimc (){
    
    estatura = estatura * estatura;
    imc = peso / estatura;
    
    if (imc <= 20){
    classifica = "Baixo Peso";
    obesidade = "Normal";
    }
    if (imc > 20 && imc < 25){
    classifica = "Peso Normal";
    obesidade = "Normal";
    }
    if (imc >= 25 && imc < 30){
    classifica = "Sobrepeso";
    obesidade = "Obesidade Grau I";
    }
    if (imc > 30 && imc < 40){
    classifica = "Obesidade";
    obesidade = "Obesidade Grau II";
    }
    if (imc >= 40){
    classifica = "Obesidade";
    obesidade = "Obesidade Grau III";
    }
    
    
    }
    
}
