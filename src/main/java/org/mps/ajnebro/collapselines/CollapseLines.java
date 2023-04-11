package org.mps.ajnebro.collapselines;

public class CollapseLines {

  public static String collapseNewLines(String arg) {
    char lastReadCharacter;
    if (arg.length() == 0) {
      throw new StringIndexOutOfBoundsException();
    } else {
      lastReadCharacter = arg.charAt(0);
    }

    StringBuilder result = new StringBuilder();
    int index = 0;
    while (index < arg.length()) {
      char currentCharacter = arg.charAt(index);

      if (currentCharacter != '\n') {
        result.append(currentCharacter);
        lastReadCharacter = currentCharacter;
      } else {
        if (lastReadCharacter != '\n') {
          result.append(currentCharacter);
          lastReadCharacter = currentCharacter;
        }
      }

      index++;
    }
    return result.toString();
  }
}
