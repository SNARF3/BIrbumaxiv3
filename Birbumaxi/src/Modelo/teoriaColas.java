package Modelo;

import conexionBase.conexionBD;
import java.sql.*;

public class teoriaColas {

    // Atributos de la clase teoriaColas
    // Atributos de la clase teoriaColas
    private double tasaLlegada;
    private double tasaServicio;
    private double rho;
    private double po;
    private double Ls;
    private double Lq;
    private double Ws;
    private double Wq;
    private int s;

    // Constructor de la clase teoriaColas
    public teoriaColas(double tasaLlegada, double tasaServicio) {
        this.tasaLlegada = tasaLlegada;
        this.tasaServicio = tasaServicio;
    }

    // Getters y Setters
    public double getTasaLlegada() {
        return tasaLlegada;
    }

    public void setTasaLlegada(double tasaLlegada) {
        this.tasaLlegada = tasaLlegada;
    }

    public double getTasaServicio() {
        return tasaServicio;
    }

    public void setTasaServicio(double tasaServicio) {
        this.tasaServicio = tasaServicio;
    }

    public double getRho() {
        return rho;
    }

    public void setRho(double rho) {
        this.rho = rho;
    }

    public double getPo() {
        return po;
    }

    public void setPo(double po) {
        this.po = po;
    }

    public double getLs() {
        return Ls;
    }

    public void setLs(double Ls) {
        this.Ls = Ls;
    }

    public double getLq() {
        return Lq;
    }

    public void setLq(double Lq) {
        this.Lq = Lq;
    }

    public double getWs() {
        return Ws;
    }

    public void setWs(double Ws) {
        this.Ws = Ws;
    }

    public double getWq() {
        return Wq;
    }

    public void setWq(double Wq) {
        this.Wq = Wq;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    // Método que aplica la teoría de colas dependiendo de la cantidad de cajeros
    public static teoriaColas calcularTeoriaColas(int n) {
        // Parámetros promedio de un supermercado
        double tasaLlegada = 45;  // Tasa promedio de llegada de clientes por unidad de tiempo
        double tasaServicio = 20; // Tasa promedio de servicio por cajero
    
        // Crear un objeto teoriaColas
        teoriaColas teoria = new teoriaColas(tasaLlegada, tasaServicio);
        teoria.setS(n); // Establecer el número de cajeros
    
        // Aplicar teoría de colas según el número de cajeros
        if (n == 1) {
            System.out.println("Teoría de colas para un servidor (M/M/1):");
            teoria.aplicarTeoriaColas1(); // Método para M/M/1
        } else if (n > 1) {
            System.out.println("Teoría de colas para varios servidores (M/M/c):");
            teoria.aplicarTeoriaColasMultiples(n); // Método para M/M/c
        } else {
            System.out.println("No hay cajeros en el sistema.");
        }
    
        return teoria;
    }
    

    // Fórmulas para M/M/1 (un servidor)
    private void aplicarTeoriaColas1() {
        // Utilizamos la fórmula M/M/1
        this.rho = tasaLlegada / tasaServicio; // Utilización del servidor
        
        this.po = 1 - rho;
        this.Ls = Math.round(rho / (1 - rho)); // Número promedio de clientes en el sistema
        this.Lq = Math.round((tasaLlegada * tasaLlegada) / (tasaServicio * (tasaServicio - tasaLlegada))); // Número promedio de clientes en la cola
        this.Ws = 1 / (tasaServicio - tasaLlegada); // Tiempo promedio en el sistema
        this.Wq = tasaLlegada / (tasaServicio * (tasaServicio - tasaLlegada)); // Tiempo promedio en la cola

        System.out.printf("Utilización del servidor (ρ): %.2f%n", rho);
        System.out.printf("Número promedio de clientes en el sistema (L): %.2f%n", Ls);
        System.out.printf("Número promedio de clientes en la cola (Lq): %.2f%n", Lq);
        System.out.printf("Tiempo promedio en el sistema (W): %.2f%n", Ws);
        System.out.printf("Tiempo promedio en la cola (Wq): %.2f%n", Wq);
    }

    // Fórmulas para M/M/c (varios servidores)
    private void aplicarTeoriaColasMultiples(int totalCajeros) {
        // Utilizamos la fórmula M/M/c
        double m = tasaLlegada / tasaServicio;

        this.rho = tasaLlegada / (totalCajeros * tasaServicio); // Utilización del sistema
            
        this.po = calcularP0(totalCajeros); // Probabilidad de que no haya clientes en el sistema
        this.Lq = Math.round((po * Math.pow(m, totalCajeros) * rho) / (factorial(totalCajeros) * (Math.pow((1 - rho), 2)))); // Número promedio de clientes en la cola
        this.Wq = Lq / tasaLlegada; // Tiempo promedio en la cola
        this.Ws = Wq + (1 / tasaServicio); // Tiempo promedio en el sistema
        this.Ls = Math.round(tasaLlegada * (Wq + (1 / tasaServicio))) ; // Número promedio de clientes en el sistema

        System.out.printf("Utilización del sistema (ρ): %.2f%n", rho);
        System.out.printf("Número promedio de clientes en el sistema (L): %.2f%n", Ls);
        System.out.printf("Número promedio de clientes en la cola (Lq): %.2f%n", Lq);
        System.out.printf("Tiempo promedio en el sistema (W): %.2f%n", Ws);
        System.out.printf("Tiempo promedio en la cola (Wq): %.2f%n", Wq);
    }

    // Función que calcula P0 para M/M/c
    private double calcularP0(int totalCajeros) {
        double m = tasaLlegada / tasaServicio;
        double rho = tasaLlegada / (totalCajeros * tasaServicio);

        double sumatoria = 0;

        for (int i = 0; i < totalCajeros; i++) {
            sumatoria += Math.pow(m, i) / factorial(i);
        }

        double P0 = 1 / (sumatoria + (Math.pow(m, totalCajeros) / factorial(totalCajeros)) * (1 / (1 - rho)));
        return P0;
    }

    // Función que calcula el factorial de un número
    public static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    // Función que calcula p(n)
    public static double calcularP(int n, teoriaColas x) {
        double m = x.getTasaLlegada() / x.getTasaServicio(); // Corregido con los métodos get
        double p_n = 0;
    
        // Caso cuando hay solo un servidor (M/M/1)
        if (x.getS() == 1) {
            p_n = Math.pow(x.getRho(), n) * x.getPo(); // Usar Math.pow y métodos get
        } 
        // Caso cuando el número de clientes está entre 0 y el número de servidores (M/M/c)
        else if (n >= 0 && n <= x.getS()) {
            p_n = (Math.pow(m, n) * x.getPo()) / factorial(n); // Usar Math.pow y factorial
        } 
        // Caso cuando n es mayor que el número de servidores
        else if (n > x.getS()) {
            p_n = (Math.pow(m, n) * x.getPo()) / (factorial(x.getS()) * Math.pow(x.getS(), (n - x.getS()))); // Completar el cálculo
        } 

        return p_n;
    }
    
}
