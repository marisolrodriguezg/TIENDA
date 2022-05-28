package tienda.servicios;

import java.util.Scanner;

public class MenuServicio {

    public static void menu() throws Exception {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        ProductoServicio producto = new ProductoServicio();
        FabricanteServicio fabricante = new FabricanteServicio();
        try {

            int operacion;
            do {
                System.out.println("----------------------------------");
                System.out.println("ingrese la opcion que desee: ");
                System.out.println("1) listar nombre de todos los productos");
                System.out.println("2) listar nombre y precio de todos los productos");
                System.out.println("3) listar productos que su precio este entre 120 y 202");
                System.out.println("3) listar productos que sean portatil");
                System.out.println("5) listar nombre y precio de los productos mas baratos ");
                System.out.println("6) ingresar productos a la base de datos ");
                System.out.println("7) ingresar fabricantes a la base de datos ");
                System.out.println("8) editar un producto ");
                System.out.println("9) salir");

                System.out.println("--------------------------------");

                operacion = leer.nextInt();
                switch (operacion) {
                    case 1:
                        producto.imprimirProductos();
                        break;
                    case 2:
                        producto.imprimirNombresYPrecios();
                        break;
                    case 3:
                        producto.imprimirProductosEntrePrecios();
                        break;
                    case 4:
                        producto.imprimirIncisoD();
                        break;
                    case 5:
                        producto.imprimirIncisoE();
                        break;
                    case 6:
                        System.out.println("para crear un nuevo producto debes ingresar Codigo(no debe estar repetido)");
                        int cod = leer.nextInt();
                        System.out.println(" nombre , preecio y cod de fabricante");
                        String nombre = leer.next();
                        double precio = leer.nextDouble();
                        int codFab = leer.nextInt();

                        producto.crearProducto(cod, nombre, precio, codFab);
                        producto.imprimirProductos();
                        break;
                    case 7:
                        System.out.println("para crear un nuevo fabricante debes ingresar Codigo(no debe estar repetido), nombre");
                        cod = leer.nextInt();
                        nombre = leer.next();
                        fabricante.crearFabricante(cod, nombre);
                        fabricante.imprimirFabricantes();
                        break;
                    case 8:
                        System.out.println("para modificar un  producto debes ingresar Codigo y colocar, nombre , preecio y cod de fabricante, del art a modificar");
                        cod = leer.nextInt();
                        String nom = leer.next();
                        precio = leer.nextDouble();
                        codFab = leer.nextInt();
                        producto.modificarProducto(cod, nom, precio, codFab);
                        producto.imprimirNombres();

                        break;
                    case 9:
                        System.out.println("¿Está seguro que desea salir del programa (S/N");

                        String si = leer.next();

                        if (si.equals("s")) {
                            System.out.println("salir del programa");
                            operacion = 0;
                            break;
                        } else {

                            if (si.equals("n")) {
                                System.out.println("continuar en el programa");
                            }
                            break;
                        }
                    default:
                        System.out.println("el num es incorrecto");
                
                }
             }while (operacion==0);
            
            } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error del sistema por \n" + e.getMessage());
        }

        }
    }

