package org.mps.ajnebro.purchaseorder;

/**
 * A purchase order includes, given a product, its name and the amount of it that are intended to
 * be purchased.
 *
 * @author Antonio J. Nebro
 */
public class PurchaseOrder {
  private final String productName ;
  private final int amountToBuy ;

  public PurchaseOrder(String productName, int amountToBuy) {
    this.productName = productName ;
    this.amountToBuy = amountToBuy ;
  }

  void purchase(Warehouse warehouse) {
    if (warehouse.thereAreProducts(productName, amountToBuy)) {
      warehouse.remove(productName, amountToBuy);
    }
  }
}
