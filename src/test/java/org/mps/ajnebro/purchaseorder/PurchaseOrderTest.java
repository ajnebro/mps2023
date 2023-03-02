package org.mps.ajnebro.purchaseorder;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class PurchaseOrderTest {

  @Test
  void shouldPurchaseWorkProperlyWhenThereAreEnoughProducts() {
    // Step 1. Create the mock object
    Warehouse warehouse = Mockito.mock(Warehouse.class) ;

    // Step 2. Define behaviour
    Mockito.when(warehouse.thereAreProducts("Bread", 15)).thenReturn(true) ;

    // Step 3. Execute method
    PurchaseOrder purchaseOrder = new PurchaseOrder("Bread", 15) ;
    purchaseOrder.purchase(warehouse);

    // Step 4. Verify
    Mockito.verify(warehouse).remove("Bread", 15);
  }

  @Test
  void shouldPurchaseWorkProperlyWhenThereAreNOTEnoughProducts() {
    // Step 1. Create the mock object
    Warehouse warehouse = Mockito.mock(Warehouse.class) ;

    // Step 2. Define behaviour
    Mockito.when(warehouse.thereAreProducts("PlayStation", 9)).thenReturn(false) ;

    // Step 3. Execute method
    PurchaseOrder purchaseOrder = new PurchaseOrder("PlayStation", 9) ;
    purchaseOrder.purchase(warehouse);

    // Step 4. Verify
    Mockito.verify(warehouse, Mockito.never()).remove("PlayStation", 9);
  }


}