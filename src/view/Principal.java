package view;

import controls.Control;
import crud.Agenda;
import crud.Persona;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Agenda a = new Agenda();

        //Persona p1 = new Persona("PersonA", "BotierA", "44444444B", "D@gmail.com", "+123456789","+123456789");
        //Persona p2 = new Persona("PersonB", "BotierB", "33333333B", "C@gmail.com", "+123456789","+123456789");
        //Persona p3 = new Persona("PersonC", "BotierC", "22222222B", "B@gmail.com", "+123456789","+123456789");
        //Persona p4 = new Persona("PersonD", "BotierD", "11111111B", "A@gmail.com", "+123456789","+123456789");

        ArrayList<Persona> oldList =(ArrayList<Persona>)Control.leer("agenda.bin");
        a.setList(oldList);

        int option = 0;

        do {
            Control.blackboard();
            option = Control.num(input);

            switch (option){
                case 1:
                    Persona p = Control.option_one();
                    System.out.println(a.alta(p));
                    //System.out.println(a.alta(p1));
                    //System.out.println(a.alta(p2));
                    //System.out.println(a.alta(p3));
                    //System.out.println(a.alta(p4));

                    break;
                case 2:
                    if(Persona.buscar == 1) Persona.setBuscar(0);
                    String e = Control.buscarDni(input);
                    Persona pe = a.ElimiModifiBuscar(e);
                    System.out.println(a.baja(pe));
                    break;
                case 3:
                    a.modificarPersona(Control.validDni(input),input);
                    break;
                case 4:
                    a.mostrarList();
                    break;
                case 5:
                    Persona b = a.ElimiModifiBuscar(Control.buscarDni(input));
                    System.out.println(b);
                    break;
                case 6:
                    Persona.buscar = 1;
                    String e2 = Control.buscarDni(input);
                    Persona pe1 = a.ElimiModifiBuscar(e2);
                    System.out.println(a.baja(pe1));
                    break;
                case 7:
                    Persona.buscar = 1;
                    a.modificarPersona(Control.preguntarNombre(input),input);
                    break;
                case 8:
                    Persona.buscar = 1;
                    a.mostrarList();
                    break;
                case 9:
                    Persona.buscar = 1;
                    Persona bNa = a.ElimiModifiBuscar(Control.buscarDni(input));
                    System.out.println(bNa);
                    break;
                case 10:
                    Persona.buscar = 2;
                    String e3 = Control.buscarDni(input);
                    Persona pe3 = a.ElimiModifiBuscar(e3);
                    System.out.println(a.baja(pe3));
                    break;
                case 11:
                    Persona.buscar = 2;
                    a.modificarPersona(Control.validEmail(input), input);
                    break;
                case 12:
                    Persona.buscar = 2;
                    a.mostrarList();
                    break;
                case 13:
                    Persona.buscar = 2;
                    Persona mp = a.ElimiModifiBuscar(Control.validEmail(input));
                    System.out.println(mp);
                    break;
                case 14:
                    ArrayList<Persona>  list = a.getList();
                    Control.escribir("agenda.bin", list);
                    break;
            }
        }while(option != 0);
    }
}
