package tienda.servicios;

import java.util.Collection;
import tienda.entidades.Fabricante;
import tienda.entidades.Producto;
import tienda.persistencia.EntidadDaoFabricante;

public class FabricanteServicio {

    private EntidadDaoFabricante dao;

    public FabricanteServicio() {

        this.dao = new EntidadDaoFabricante();
    }
//PUNTO 7
    public void crearFabricante(int codigo, String nombre) throws Exception {

        try {

            //Creamos el producto
            Fabricante fabricante = new Fabricante();
            fabricante.setCodigo(codigo);
            fabricante.setNombre(nombre);

            dao.guardar(fabricante);

        } catch (Exception e) {
            throw e;
        }
    }
    
    public void imprimirFabricantes() throws Exception {

        try {

            //Listamos los productos
            Collection<Fabricante> fabricante = dao.listarFabricantes();

            //Imprimimos los productos
            if (fabricante.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Fabricante u : fabricante) {
                    System.out.println(u.getNombre()+u.getCodigo()+ "\n");
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
