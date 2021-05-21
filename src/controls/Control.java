package controls;

import crud.Persona;

import java.io.*;
import java.util.Scanner;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.*;
import crud.Agenda;

public class Control {


    public static  void escribir(String nomFile, Serializable o){
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(nomFile));
            oos.writeObject(o);
            oos.close();
        } catch (IOException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Serializable leer(String nomFile){
        Serializable aux = null;
        try {
            ObjectInputStream ois;
            ois = new ObjectInputStream(new FileInputStream(nomFile));

            // Se lee el objeto
            try {
                aux = (Serializable)ois.readObject();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            }
            ois.close();

        } catch (IOException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aux;
    }

    public static byte[] obj2AByte(Serializable o1){
        byte[] bytes=null;
        ObjectOutputStream os;
        try {
            ByteArrayOutputStream bs= new ByteArrayOutputStream();
            os = new ObjectOutputStream (bs);
            os.writeObject(o1);  // this es de tipo DatoUdp
            os.close();
            bytes =  bs.toByteArray(); // devuelve byte[]
        } catch (IOException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bytes;
    }

    public static Serializable aByte2Obj(byte bytes[] ){
        Serializable objetoSerializable=null;
        ObjectInputStream is;
        try {
            ByteArrayInputStream bs= new ByteArrayInputStream(bytes); // bytes es el byte[]
            is = new ObjectInputStream(bs);
            try {
                objetoSerializable = (Serializable)is.readObject();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            }
            is.close();
        } catch (IOException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        }
        return objetoSerializable;
    }
    /***************************************/
    public  static  Persona option_one(){
        Scanner input = new Scanner(System.in);

        String nombre = preguntarNombre(input);
        String apellido = preguntarApellido(input);
        String dni = validDni(input);
        String telef1 = vallidTelefono(input);
        String telef2 = vallidTelefono(input);
        String email = validEmail(input);

        return new Persona(nombre, apellido, dni,email,telef1 ,telef2);
    }
    public static String preguntarNombre(Scanner s){
        System.out.println("Entra tu nombre");
        return s.nextLine();
    }
    public static  String preguntarApellido(Scanner s){
        System.out.println("Entra tu Apellido.");
        return s.nextLine();
    }
    public static String validEmail(Scanner s){
        boolean exit = false;
        String email = "";

        while(!exit){
            System.out.println("Entra tu Email.");
            email = s.nextLine();

            Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            Matcher mather = pattern.matcher(email);
            if(mather.find()) exit = true;
        }
        return email;
    }
    public static String vallidTelefono(Scanner s){
        String tel = "";
        boolean exit = false;

        while (!exit){
            System.out.println("Entra tu número de telefono.");
            tel = s.nextLine();
            String regex = "[+][0-9]{9,15}";
            if(tel.matches(regex)) exit = true;
        }
        return tel;
    }

    public static String validDni(Scanner s){

        boolean exit = false;
        String dni = "";

        while(!exit){
            System.out.println("Entra tu DNI.");
            dni = s.nextLine();
            String regex = "[0-9]{8}[A-Z]";

            if(dni.matches(regex)) exit = true;
        }
        return dni;
    }

    public static int num(Scanner n){
        int num = 0;
        boolean exit = false;

        while (!exit){
            if(n.hasNextInt()){
                num = n.nextInt();
                exit = true;
            }else System.out.println("it not a number");
            n.nextLine();
        }
        return num;
    }
    public static String  buscarDni(Scanner s){
        System.out.println("Introduce el DNI, nombre o Apellido");
        return s.nextLine();
    }
    public static void blackboard(){
        System.out.println("1 Dar de alta");
        System.out.println("2 Dar de baja");
        System.out.println("3 Modificar");
        System.out.println("4 Mostrar lista");
        System.out.println("5 Buscar por DNI");
        System.out.println("6 baja por apellidos y nombre");
        System.out.println("7 modificar por apellidos y nombre");
        System.out.println("8 Mostrar lista ordenada por apellidos y nombre");
        System.out.println("9 Buscar por apellidos y nombre");
        System.out.println("10 baja por email");
        System.out.println("11 modificar por email");
        System.out.println("12 Mostrar lista ordenada por email");
        System.out.println("13 Buscar por email");
        System.out.println("14 Guardar agenda");
        System.out.println("0 salir");
    }
}
