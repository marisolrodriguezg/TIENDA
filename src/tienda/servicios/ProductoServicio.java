package tienda.servicios;

import java.util.Collection;
import tienda.entidades.Producto;
import tienda.persistencia.EntidadDaoProducto;

public class ProductoServicio {

    private EntidadDaoProducto dao;

    public ProductoServicio() {
        this.dao = new EntidadDaoProducto();
    }
//--PUNTO 8 --
    public Producto buscarProductoPorCodigo(int codigo) throws Exception {

        try {

            //Validamos
            if (codigo < 0) {
                throw new Exception("Debe indicar el codigo");
            }
            Producto producto = dao.buscarProductoPorCodigo(codigo);
            //Verificamos
            if (producto == null) {
                throw new Exception("No se econtró el codigo del producto indicado");
            }

            return producto;
        } catch (Exception e) {
            throw e;
        }
    }
//--PUNTO 1--
    public Collection<Producto> listarProductos() throws Exception {

        try {

            Collection<Producto> productos = dao.listarProductos();

            return productos;
        } catch (Exception e) {
            throw e;
        }
    }

    public void imprimirNombres() throws Exception {

        try {

            //Listamos los productos
            Collection<Producto> productos = listarProductos();

            //Imprimimos los productos
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto u : productos) {
                    System.out.println(u.getNombre() + u.getCodigoFabricante() + "\n");
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    //--PUNTO 1--
        public void imprimirProductos() throws Exception {

        try {

            //Listamos los productos
            Collection<Producto> productos = listarProductos();

            //Imprimimos los productos
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto u : productos) {
                    System.out.println(u.getCodigo()+u.getNombre() +u.getPrecio()+ u.getCodigoFabricante() + "\n");
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
//--PUNTO 2--
    public void imprimirNombresYPrecios() throws Exception {

        try {

            //Listamos los productos
            Collection<Producto> productos = listarProductosNombreYprecio();

            //Imprimimos los productos
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto u : productos) {
                    // if(u.getPrecio()>120 && u.getPrecio()<202)
                    System.out.println("Nombre: " + u.getNombre() + " | " + " Precio: " + u.getPrecio() + "\n");
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
//--PUNTO 3--
    public void imprimirProductosEntrePrecios() throws Exception {

        try {

            //Listamos los productos
            Collection<Producto> productos = listarProductosEntrePrecios();

            //Imprimimos los productos
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto u : productos) {
                    // if(u.getPrecio()>120 && u.getPrecio()<202)
                    System.out.println("Nombre: " + u.getNombre() + " | " + " Precio: " + u.getPrecio() + "\n");
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
//--PUNTO 2--
        public Collection<Producto> listarProductosNombreYprecio() throws Exception {

        try {

            Collection<Producto> productos = dao.listarProductosNombreYprecio();

            return productos;
        } catch (Exception e) {
            throw e;
        }
    }
    //--PUNTO 3--
    public Collection<Producto> listarProductosEntrePrecios() throws Exception {

        try {

            Collection<Producto> productos = dao.listarProductosEntrePrecios();

            return productos;
        } catch (Exception e) {
            throw e;
        }
    }
//--PUNTO 4--
    public void imprimirIncisoD() throws Exception {

        try {

            //Listamos los productos
            Collection<Producto> productos = dao.listarProductosIncisoD();

            //Imprimimos los productos
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto u : productos) {
                    //if(u.getNombre().equalsIgnoreCase("Portátil Yoga 520"))
                    System.out.println("Nombre: " + u.getNombre() + "\n");
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
//--PUNTO 5--
    public void imprimirIncisoE() throws Exception {

        try {

            //Listamos los productos
            Collection<Producto> productos = dao.listarProductoMasBarato();

            //Imprimimos los productos
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto u : productos) {
                    //if(u.getNombre().equalsIgnoreCase("Portátil Yoga 520"))
                    System.out.println("Nombre: " + u.getNombre() + " | " + " Precio: " + u.getPrecio() + "\n");
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
//--PUNTO 6--
    public void crearProducto(int codigo, String nombre, double precio, int codigofabricante) throws Exception {

        try {

            //Creamos el producto
            Producto producto = new Producto();
            producto.setCodigo(codigo);
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCodigoFabricante(codigofabricante);

            dao.guardar(producto);

        } catch (Exception e) {
            throw e;
        }
    }
//PUNTO 8
    public void modificarProducto(int codigo, String nombre, double precio, int codigofabricante) throws Exception {

        //Buscamos
        Producto producto = buscarProductoPorCodigo(codigo);

        //Modificamos
        producto.setCodigo(codigo);
        producto.setNombre(nombre);
        producto.setPrecio(precio);
        producto.setCodigoFabricante(codigofabricante);

        dao.modificarProducto(producto);

    }
}
