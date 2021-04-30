package br.com.sa.classes;

public class CalculoDensidadeCorporal {

    public double dcpt, dcbi, dctr, dcse, dcam, dcsi, dcab, dccx, dcmp, idade, resultado;
    double s0, s1, s2, s3, s4, s5, s6;

    public void petrotsky01() {
        //4 Dobras Petrotsk (1995) Geral
        s0 = dcse + dctr + dcsi + dcmp;
        s1 = s0 * 10;
        s2 = s1 * s1;
        s3 = 0.00081201 * s1;
        s4 = 0.00000212 * s2;
        s5 = 0.00041761 * idade;
        resultado = 1.10726863 - s3 + s4 - s5;

    }

    public void jacson01() {
        //3 Dobras Jackson & Pollock (1978) Geral
        s0 = dccx + dcpt + dcab;
        s1 = s0 * 10;
        s2 = s1 * s1;
        s3 = 0.0008267 * s1;
        s4 = 0.0000016 * s2;
        s5 = 0.0002574 * idade;
        resultado = 1.1093800 - s3 + s4 - s5;

    }

    public void thorland01() {
        //7 Dobras Thorland et alli (1984) Homens Adultos
        s0 = dctr + dcse + dcam + dcsi + dcab + dccx + dcmp;
        s1 = s0 * 10;
        s2 = s1 * s1;
        s3 = 0.00052 * s1;
        s4 = 0.00000032 * s2;
        resultado = 1.1091 - s3 + s4;

    }

    public void thorland02() {
        //3 Dobras Thorland et alli (1984) Homens Adultos
        s0 = dctr + dcse + dcam;
        s1 = s0 * 10;
        s2 = s1 * s1;
        s3 = 0.00154 * s1;
        s4 = 0.00000516 * s2;
        resultado = 1.1136 - s3 + s4;

    }

    public void thorland03() {
        //7 Dobras Thorland et alli (1984) Mulheres Adultas

        s0 = dctr + dcse + dcam + dcsi + dcab + dccx + dcmp;
        s1 = s0 * 10;
        s2 = s1 * s1;
        s3 = 0.00059 * s1;
        s4 = 0.00000060 * s2;
        resultado = 1.1046 - s3 + s4;

    }

    public void thorland04 () {
        //3 Dobras Thorland et alli (1984) Mulheres Adultas
        
        s0 = dctr + dcse + dcsi;
        s1 = s0 * 10;
        s2 = s1 * s1;
        s3 = 0.00122 * s1;
        s4 = 0.00000263 * s2;
        resultado = 1.0987 - s3 + s4;

    }
    public void jackson02 (){
    //3 Dobras Jackson & Pollock (1978) Homens 18 a 61 anos
        s0 = dcpt + dcab + dccx;
        s1 = s0*10;
        s2 = s1 * s1;
        s3 = 0.0008267 * s1;
        s4 = 0.0000016 * s2;
        s5 = 0.0002574 * idade;
        resultado = 1.10938000 - s3 + s4 - s5;

    }
    public void jackson03 (){
    //3 Dobras Jackson & Pollock (1978) Mulheres 18 a 55 anos
    
        s0 = dctr + dccx + dcsi;
        s1 = s0*10;
        s2 = s1 * s1;
        s3 = 0.0009929 * s1;
        s4 = 0.0000023 * s2;
        s5 = 0.0001392 * idade;
        resultado = 1.099492 - s3 + s4 - s5;

    }
    
    public void solan01 (){
    //2 Dobras Sloan (1962) Homens Universitários
        s0 = dccx * 10;
        s1 = dcse * 10;
        s2 = 0.001327 * s0;
        s3 = 0.001310 * s1;
        resultado = 1.1043 - s2 - s3;   
    
    }
    public void solan02 (){
    //2 Dobras Sloan (1962)Mulheres Universitárias
        s0 = dcsi * 10;
        s1 = dctr * 10;
        s2 = 0.0081 * s0;
        s3 = 0.00088 * s1;
        resultado = 1.0764 - s2 - s3;   
    
    }
    
    public void thorland05 (){
    //7 Dobras Thorland et alli (1984)Adolecente  Homem Atleta
        s0 = dctr + dcse + dcam + dcsi + dcab + dccx + dcmp;
        s1 = s0*10;
        s2 = s1*s1;
        s3 = 0.00052 * s1;
        s4 = 0.00000032 * s2;
        resultado = 1.1091 - s3 + s4;

    }
    public void thorland06 (){
    //3 Dobras Thorland et alli (1984)Adolecente  Homem Atleta
        s0 = dctr + dcse + dcsi;
        s1 = s0*10;
        s2 = s1*s1;
        s3 = 0.00154 * s1;
        s4 = 0.00000516 * s2;
        resultado = 1.1136 - s3 + s4;

    }
     public void thorland07 (){
    //7 Dobras Thorland et alli (1984)Adolecente  Mulher Atleta
        s0 = dctr + dcse + dcam + dcsi + dcab + dccx + dcmp;
        s1 = s0*10;
        s2 = s1*s1;
        s3 = 0.00059 * s1;
        s4 = 0.00000060 * s2;
        resultado = 1.1046 - s3 + s4;

    }
     public void thorland08 (){
    //3 Dobras Thorland et alli (1984)Adolecente  Mulher Atleta
        s0 = dctr + dcse + dcsi;
        s1 = s0*10;
        s2 = s1*s1;
        s3 = 0.00122 * s1;
        s4 = 0.00000263 * s2;
        resultado = 1.0987 - s3 + s4;

    }

}
