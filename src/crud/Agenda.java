package crud;

import controls.Control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import  java.util.Iterator;
import java.util.Scanner;

public class Agenda implements Serializable {
    private  ArrayList<Persona> list = new ArrayList<Persona>();

    public boolean alta(Persona p){
        if(!list.contains(p)){
            list.add(p);
            return true;
        }
        return false;
    }
    public boolean baja(Persona p){
        if(list.contains(p)){
            list.remove(p);
            return true;
        }
        return false;
    }
    public void mostrarList(){
        Collections.sort(list);
        Iterator<Persona> elemen = list.iterator(); //to traver the arrayList, a loop "for" can be use to.

        while(elemen.hasNext()){
            Persona p = elemen.next();
            System.out.println(p);
        }
    }
    /*  public Persona buscarPorDNI(String s){
        Iterator<Persona> elem = list.iterator();

        while(elem.hasNext()){
            Persona p = elem.next();
            if(s.equals(p.getDni())) return p;
        }
        return null;
    }*/

    public boolean modificarPersona(String s, Scanner input){

        Persona p = ElimiModifiBuscar(s);
        if(p != null){
            p.setNombre(Control.preguntarNombre(input));
            p.setApellido(Control.preguntarApellido(input));
            p.setDni(Control.validDni(input));
            p.setTelef1(Control.vallidTelefono(input));
            p.setTelef2(Control.vallidTelefono(input));
            p.setMail(Control.validEmail(input));
            return true;
        }
        return false;
    }

    public void setList(ArrayList<Persona> p){
        this.list = p;
    }
    public ArrayList<Persona> getList(){
        return list;
    }

    public Persona ElimiModifiBuscar(String s){
        Iterator<Persona> elem = list.iterator();

        while(elem.hasNext()){
            Persona p = elem.next();
            if(Persona.buscar == 2){
               if(s.equals(p.getMail())) return p;
            }
            if(Persona.buscar == 1){
                if (s.equals(p.getNombre())){
                    return p;
                }else{
                    if(s.equals(p.getApellido())) return p;
                }
            }
            if(p.getDni().equals(s)){
                return p;
            }
        }
        return null;



    }
}
