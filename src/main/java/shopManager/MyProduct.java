package model;

import java.io.Serializable;

/**
 * Producto es la clase que representa todos los productos de la tienda *
 * el id (string) se usar� como clave del mapa hazelcast *
 */
 

import java.util.logging.*;
/**
 * @author Isabel Rom�n
 * @version 0.0
 * Primera versi�n de la clase MyProduct que implementa la interfaz Product y Serializable, porque debe guardarse en un mapa hazelcast
 *
 */

public class MyProduct implements Product,Serializable{
	
	private static final long serialVersionUID = 1L;
	private static Logger trazador=Logger.getLogger(MyProduct.class.getName());
	
	//identificador del producto
	private String id;
	private int number;
	private float price;
	
	public MyProduct(String id) {
		this.id=id;
		number=1;
	}
	
	MyProduct(String id,int number) {
		this.id=id;
		this.number=number;
		this.price = 0;
	}
	 @Override
    public void setId(String id) {
    	trazador.info("Estableciendo id a "+id);
        this.id=id;
    }
    @Override
    public String getId() {
    	trazador.info("Devolviendo id como "+id);
    	return this.id;
    }
    @Override
    public void setNumber(int number) {
    	this.number=number;
    }
    @Override
    public int getNumber() {
    	return number;
    }
    @Override
    public int oneMore() {
    	number++;
    	return number;
    }
    //Nuevos metodos
    public float getPrice() {
    	return this.price;
    }
    public void setPrice(float price) {
    	this.price = price;
    }
    
   
    @Override
    public int oneLess(){
    	if (number!= 0){
    		number--;
    		trazador.info("El n�mero de unidades del producto se reduce uno");
    	} else {
    		trazador.info("El n�mero de unidades del producto no se puede reducir porque es cero");
    	}
    	trazador.info(this.toString());
    	return number;
    }
    
    @Override
    public String toString() {
    	return (number+" unidades del producto con id "+id);
    }
}
