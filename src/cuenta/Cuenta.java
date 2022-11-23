//Omarsito
package cuenta;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Cuenta {

    private long numero;
    private String titular;
    private float saldo;
    private float interesAnual;
    //Libreria a utilizar
    Scanner num = new Scanner(System.in);
    Scanner un = new Scanner(System.in);
    
    public void Datos(){
        System.out.println("--------Bienvenido a tu Banco------");
        System.out.println("ingresa los datos del cliente: ");
        System.out.println("Nombre del nuevo cliente: ");
        titular = num.next();
        System.out.println("Numerode la cuenta: ");
        numero = num.nextLong();
        System.out.println("El iteres anual: ");
        interesAnual = num.nextFloat();
    }
    public void Datos2(){
        System.out.println("Ingrese ls datos del nuevo cliente: ");
        System.out.println("Nombre del nuevo cliente: ");
        titular = un.next();
        System.out.println("Numero de la cuenta: ");
        numero  =un.nextLong();
        System.out.println("El interes anual: ");
        interesAnual = un.nextFloat(); 
    }
    public void Menu(){
        System.out.println("-----Menu-----");
        System.out.println("1.- Ingresar saldo. ");
        System.out.println("2.- Retirar saldo. ");
        System.out.println("3.- Interes mensual. ");
        System.out.println("4.- Mostrar saldo. ");
        System.out.println("5.- Dar de alat a cliente. ");
        System.out.println("6.- Ingresar saldo. ");
        System.out.println("7.- Retirar saldo. ");
        System.out.println("8.- Interes mensual. ");
        System.out.println("9.- Mostrar saldo. ");   
    }
    public Cuenta(long aNumero, String aTitular, float aInteresAnual){
        numero = aNumero;
        titular = aTitular;
        saldo = 0;
        interesAnual = aInteresAnual;
    }
    public void ingreso(float cantidad){
        saldo = saldo + cantidad;
    }
    public void reintegro(float cantidad){
        saldo =saldo - cantidad;
    }
    public float IngresoMesual(){
        interesAnual = ((interesAnual/100)*saldo);
        saldo = interesAnual + saldo;
        return interesAnual;
    }
    public void ingreso2(float cantidad){
        saldo = saldo + cantidad;
    }
    public void reintegro2(float cantidad){
        saldo = saldo - cantidad;
    }
    public float IngresoMensual2(){
        interesAnual = ((interesAnual/100)*saldo);
        saldo =interesAnual + saldo;
        return interesAnual;
    }
    public boolean enRojos(){return saldo < 0; }
    public float leerSaldo(){return saldo;}
    public float leerSaldo2(){return saldo;}
    public static void main(String[]args){
        long numeroC = 0;
        String titular = "";
        float saldo, interesAnual = 0;
        Scanner uno = new Scanner(System.in);
        Cuenta ob = new Cuenta(numeroC, titular, interesAnual);
        ob.Datos();
        int ingresar = 1;
        do{
            ob.Menu();
            ingresar = uno.nextInt();
            switch(ingresar){
                case 1:
                    System.out.println("Monto a ingresar: ");
                    saldo = uno.nextFloat();
                    ob.ingreso(saldo);
                    break;
                case 2:
                    System.out.println("Monto a retirar: ");
                    saldo = uno.nextFloat();
                    if(ob.leerSaldo()< saldo)
                        System.out.println("Saldo insuficiente: ");
                    else{
                        System.out.println("Retiro exitoso: ");
                        ob.reintegro(saldo);
                    }
                    break;
                case 3:
                    System.out.println("Interes Mensual: "+ ob.IngresoMesual());
                    System.out.println("Saldo total: "+ ob.leerSaldo());
                    break;
                case 4:
                    if(ob.leerSaldo()<=0)
                        System.out.println("El saldo es de: "+ ob.leerSaldo());
                    ob.leerSaldo();
                    break;    
                case 5:
                    ob.Datos2();
                    break;
                case 6:
                    System.out.println("Monto a ingresar: ");
                    saldo = uno.nextFloat();
                    ob.ingreso2(saldo);
                    break;
                case 7:
                    System.out.println("Monto a retirar: ");
                    saldo = uno.nextFloat();
                    if(ob.leerSaldo2()< saldo)
                    System.out.println("Saldo insuficiente: ");
                else{
                    System.out.println("Retiro exitoso: ");
                    ob.reintegro2(saldo);                    
            } 
            break;
            case 8:
                System.out.println("Interes Mensual: " + ob.IngresoMensual2());
                System.out.println("Saldo total: "+ob.leerSaldo2());
                break;
            case 9:
                if(ob.leerSaldo2() <= 0)
                System.out.println("Saldo insuficiente: ");
                else{
                    System.out.println("El saldo es de: "+ ob.leerSaldo2());
                    ob.leerSaldo();
                    break;
                }
            }
        }while(ingresar < 9);
    }
}