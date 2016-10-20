 package it.sevenbits.homework.writer.implementation.stringwriter;

 import it.sevenbits.homework.writer.IWriter;

 /**
 * Writes information in different sources.
 */
public class StringWriter implements IWriter {

     /**
      * Tool to build a string.
      */
     private StringBuilder stringBuilder;
     /**
      * Default constructor.
      * @param outputString is output String
      */
     public StringWriter(final String outputString) {
         stringBuilder = new StringBuilder(outputString);
     }
     /**
      * Writes s in outputString.
      * @param s input string
      */
     public final void write(final String s) {
         stringBuilder.append(s);
     }



     /**
      * Getter.
      * @return outputString
      */
     public final String getString() {
         return stringBuilder.toString();
     }

}
