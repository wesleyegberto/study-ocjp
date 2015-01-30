package formatador;

import java.text.MessageFormat;
import java.text.ParseException;
import java.util.Date;

import javax.swing.text.MaskFormatter;

public class MessageFormatTest {
	public static void main(String[] args) {
		final int BR = 0;
		final int US = 1;

		/* {0,choice,0#Parabens para|0<Happy birthday to}
		 *    Usa o param 0 para seleção (choice). Se for 0 (0#) imprime o "Parabens para" ou (|) se for maior que zero (0<) imprime "Happy birthday to"
		 * {1}
		 *    Imprime o param 1 como String
		 * {0,choice,0#neste dia|0<in this day}
		 * 	  Usa o param 0 para seleção (choice). Se for 0 (0#) imprime o "neste da" ou (|) se for maior que zero (0<) imprime "in this day"
		 * {2, date}
		 *    Imprime o param 2 como Date
		 */
		final String PATTERN_PARABENS = "{0,choice,0#Parabens para|0<Happy birthday to} {1} {0,choice,0#neste dia|0<in this day} {2, date}";
		String msg = null;

		msg = MessageFormat.format(PATTERN_PARABENS, BR, "Wesley", new Date());
		System.out.println(msg);

		msg = MessageFormat.format(PATTERN_PARABENS, US, "Wesley", new Date());
		System.out.println(msg);
		System.out.println(MessageFormat.format("###.###.###-##", 29336965223L));
		try {
			MaskFormatter maskFormatter = new MaskFormatter("###.###.###-##");
			maskFormatter.setValueContainsLiteralCharacters(false);
			System.out.println(maskFormatter.valueToString("43123909832"));
		} catch(ParseException e) {
			e.printStackTrace();
		}
		
		
	}
}
