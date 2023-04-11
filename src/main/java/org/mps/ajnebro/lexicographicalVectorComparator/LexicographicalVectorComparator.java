package org.mps.ajnebro.lexicographicalVectorComparator;

import java.util.Comparator;

/**
 * This class implements a class for comparing two double vectors in lexicographical order
 *
 * @author Antonio J. Nebro <antonio@lcc.uma.es>
 */
public class LexicographicalVectorComparator implements Comparator<double[]> {

  /**
   * The compare method compare the objects o1 and o2.
   *
   * @param x Vector (array) of double values
   * @param y Vector (array) of double values
   * @return The following value: -1 if x < y, 1 if x > y or 0 otherwise.
   */
  @Override
  public int compare(double[] x, double[] y) {
    if (null == x) {
      throw new RuntimeException("The first array is null") ;
    }
    if (null == y) {
      throw new RuntimeException("The second array is null") ;
    }

    int index = 0;
    while ((index < x.length)
        && (index < y.length)
        && x[index] == y[index]) {
      index++;
    }

    int result;
    if ((index >= x.length) || (index >= y.length)) {
      result = 0 ;
    } else
      result = Double.compare(x[index], y[index]);
    return result ;
  }
}
