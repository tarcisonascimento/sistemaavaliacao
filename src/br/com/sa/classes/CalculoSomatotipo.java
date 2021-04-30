package br.com.sa.classes;

public class CalculoSomatotipo {

    public double dctr, dcse, dcsi, dcper, estatura, peso, diaum, diafem, perbrac, perper, retendo, retmeso, retecto;
    double s0, s1, s2, s3, s4, s5, res1, res2;
    public String classificado;

    public void endomofia() {
        //correção das dobras cutaneas
        s0 = dctr + dcse + dcsi;
        s1 = s0 * 10;
        s2 = estatura * 100;
        s3 = 170.18 / s2;
        res1 = s1 * s3;//resultado da dobra corrigida

        //calculando a endomorfia
        s0 = res1 * res1;//elevado ao quadrado
        s1 = res1 * res1 * res1;// elevado ao cubo
        s2 = 0.1451 * res1;
        s3 = 0.00068 * s0;
        s4 = 0.0000014 * s1;
        retendo = -0.7182 + s2 - s3 + s4; //resultado endomorfia 

    }

    public void mesomorfia() {
        //corrigindo perimetro do braço
        res1 = perbrac - dctr;
        res2 = perper - dcper;
        s0 = estatura * 100;
        s1 = 0.858 * diaum;
        s2 = 0.601 * diafem;
        s3 = 0.188 * res1;
        s4 = 0.161 * res2;
        s5 = 0.131 * s0;
        retmeso = 4.50 + s1 + s2 + s3 + s4 - s5;//resultado mesomorfia

    }

    public void ectomorfia() {

        //derterminando o indice ponderal
        s0 = Math.cbrt(peso);//calculando raiz cubica
        s1 = estatura * 100;
        res1 = s1 / s0;//indice ponderal

        if (res1 >= 40.75) {
            s0 = res1 * 0.732;
            retecto = s0 - 28.58;
        } else {
            s0 = res1 * 0.463;
            retecto = s0 - 17.63;

        }

    }

    public void classifica() {
        
        s1 = retendo - retmeso;     
        s2 = retendo - retecto;
        s3 = retmeso - retecto;

        
        if ((retendo > retmeso) && (retendo > retecto)) {

            if (s3 >= -0.5 && s3 <= 0.5) {
                classificado = "Endomorfo Equilibrado";
            }
            if (s3 < -0.5) {
                classificado = "Endomorfo Ectomórfico";
            }
            if (s3 > 0.5) {
                classificado = "Endomorfo Mesomórfico";
            }
        }

        if ((retmeso > retendo) && (retmeso > retecto)) {
            if (s2 >= -0.5 && s2 <= 0.5) {
                classificado = "Mesomorfo Equilibrado";
            }
            if (s2 < -0.5) {
                classificado = "Mesomorfo Ectomórfico";
            }
            if (s2 > 0.5) {
                classificado = "Mesomorfo Endomórfico";
            }

        }
        if ((retecto > retendo) && (retecto > retmeso)) {
            if (s1 >= -0.5 && s1 <= 0.5) {
                classificado = "Ectomorfo Equilibrado";
            }
            if (s1 < -0.5) {
                classificado = "Ectomorfo Mesomórfico";
            }
            if (s1 > 0.5) {
                classificado = "Ectomorfo Endomórfico";
            }

        }       

    }

}
