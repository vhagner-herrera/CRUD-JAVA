package vista;

import config.conexion;
import modelo.persona;
import DAO.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

//
// Vhagner Tapullima Herrera
//

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Connection con= null;
        personaDAO personaDAO = new personaDAO();
        persona persona = new persona();
        System.out.println("___________bienvenido a nuestro sistema_________________");

        System.out.println("ingrese una de las opciones:");

        System.out.println("-----admi---"+
                "\n 1 Listar "+
                "\n 2 agregar"+
                "\n 3 actualizar"+
                "\n 4 eliminar"+
                "\n 5 buscar");
        int dato=sc.nextInt();
        switch (dato){
            case 1:

                List<persona> personas = personaDAO.findAll();
                System.out.println("Todas las personas:");
                for (persona p : personas) {
                    System.out.println(p);
                }
                break;
            case 2:
                persona nuevaPersona = escribir();
                personaDAO.save(nuevaPersona);
                break;
            case 3:
                System.out.println("Ingresa el ID del usuario a modificar: ");
                int idd = sc.nextInt();
                sc.nextLine();

                persona ac =escribir();
                ac.setId(idd);

                personaDAO per= new personaDAO();
                per.update(ac);

                System.out.println("datos actualizados");

                break;
            case 4:
                System.out.println("Ingresa el ID del usuario a eliminar: ");
                int el = sc.nextInt();
                sc.nextLine();

                persona pel= new persona();
                pel.setId(el);

                personaDAO pers = new personaDAO();
                pers.delete(pel);

                System.out.println("Usuario con ID " + el+ " eliminado correctamente de la base de datos.");
                break;
            case 5:

                System.out.println("Ingrese el ID de la persona a buscar:");
                int id = sc.nextInt();
                sc.nextLine();
                persona personaEncontrada = personaDAO.findById(id);
                if (personaEncontrada.getId() != 0) {
                    System.out.println("Persona encontrada: " + personaEncontrada);
                } else {
                    System.out.println("No se encontró una persona con el ID proporcionado.");
                }
                break;
        }


    }
    public static persona escribir() {
        Scanner sc = new Scanner(System.in);
        persona personaa = new persona();

        System.out.println("Ingresa tu nombre: ");
        personaa.setNombre(sc.nextLine());

        System.out.println("Ingresa tu apellido paterno: ");
        personaa.setApellidopa(sc.nextLine());

        System.out.println("Ingresa tu apellido materno: ");
        personaa.setApellidoma(sc.nextLine());

        System.out.println("Ingresa tu email: ");
        personaa.setEmail(sc.nextLine());

        System.out.println("Ingresa tu sueldo: ");
        personaa.setSueldo(sc.nextDouble());

        return personaa;



}}
