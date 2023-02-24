package org.mps.ajnebro.purchaseorder;

/**
 * Interface representing warehouses to store items by their names and including the amount of
 * them.
 *
 * @author Antonio J. Nebro
 */
public interface Warehouse {
  boolean thereAreProducts(String name, int amount) ;
  void remove(String name, int amount) ;
}
