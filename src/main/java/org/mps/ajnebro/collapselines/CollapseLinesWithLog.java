package org.mps.ajnebro.collapselines;

public class CollapseLinesWithLog {
  public static String collapseNewLines(String arg) {
    System.out.print("0 - ") ;
    char lastReadCharacter ;
    System.out.print("1 - ") ;
    if (arg.length() == 0) {
      System.out.print("2 \n") ;
      throw new StringIndexOutOfBoundsException() ;
    } else {
      lastReadCharacter = arg.charAt(0) ;
    }

    StringBuilder result = new StringBuilder();
    System.out.print("3 - ") ;
    int index = 0;
    System.out.print("4 - ") ;
    while (index < arg.length()) {
      char currentCharacter = arg.charAt(index);
      System.out.print("5 - ") ;

      if (currentCharacter != '\n') {
        result.append(currentCharacter);
        lastReadCharacter = currentCharacter;
        System.out.print("7 - ") ;
      } else {
        System.out.print("6 - ") ;
        if (lastReadCharacter != '\n') {
          result.append(currentCharacter);
          lastReadCharacter = currentCharacter;
          System.out.print("7 - ") ;
        }
      }

      index++;
      System.out.print("8 - ") ;
      System.out.print("4 - ") ;
    }

    System.out.print("9 \n") ;
    return result.toString();
  }
}
