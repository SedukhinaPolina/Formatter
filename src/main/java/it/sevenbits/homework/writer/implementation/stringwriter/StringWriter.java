 package it.sevenbits.homework.writer.implementation.stringwriter;

 import it.sevenbits.homework.writer.IWriter;

 /**
 * Writes information in different string.
 */
public class StringWriter implements IWriter {
     /**
      * output string.
      */
     private String outputString;

     /**
      * Default constructor.
      */
     public StringWriter() {
         outputString = "";
     }
     /**
      * Writes s in outputString
      * @param s input string
      */
     public final void write(final String s) {
        outputString += s;
     }



     /**
      * Getter.
      * @return outputString
      */
     public final String getString() {
         return outputString;
     }

}
