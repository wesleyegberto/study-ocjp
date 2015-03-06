/**
 * @author Wesley Egberto de Brito Objetivo: Teste com a classe DateFormat
 */

package formatador;

import static java.lang.System.out;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

public class DateFormatTest {
	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();

		c.set(Calendar.DAY_OF_MONTH, 21);
		c.set(Calendar.DATE, 21); // Idem ao anterior
		c.set(Calendar.MONTH, 11); // 0 -> Janeiro, ..., 11 -> Dezembro
		c.set(Calendar.YEAR, 2012);

		c.set(Calendar.HOUR, 10); // Hora da manhã ou tarde (12h e am/pm)
		c.set(Calendar.HOUR_OF_DAY, 10); // Hora do dia (24h)
		c.set(Calendar.MINUTE, 45);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 899);

		Date d = c.getTime();
		DateFormat f = DateFormat.getDateInstance();
		out.println("DateInstance - MEDIUM => " + f.format(d));
		
		// Usa o formator para a localidade e style default, SHORT (ex.: 21/12/12 10:45 AM)
		f = DateFormat.getInstance();
		out.println("SHORT => " + f.format(d));

		// Usa o formator para a localidade default e o style recebido, MEDIUM (ex.: Dec 21, 2012)
		f = DateFormat.getDateInstance(DateFormat.MEDIUM); 
		out.println("MEDIUM => " + f.format(d));

		// Usa o formator para a localidade default e o style recebido, LONG (ex.: 21 de Dezembro de 2012)
		f = DateFormat.getDateInstance(DateFormat.LONG); 
		out.println("LONG => " + f.format(d));

		// Usa o formator para a localidade default e o style recebido, FULL (ex.: Sexta-feira, 21 de Dezembro de 2012)
		f = DateFormat.getDateInstance(DateFormat.FULL); 
		out.println("FULL => " + f.format(d));

		
		System.out.println("\nTestes com Locale");
		Locale loc = new Locale("en", "Us"); // Lingua e pais

		// Usa o formatador para o style e a localidade recebida
		f = DateFormat.getDateInstance(DateFormat.LONG, loc); 
		out.println("LONG e Locale => " + f.format(d));

		Properties myConfig = System.getProperties();
		
		String defLang = myConfig.getProperty("user.language");
		String defCountry = myConfig.getProperty("user.country");
		
		System.out.println("\nUser languange: " + defLang);
		System.out.println("User country: " + defCountry);
		
		Locale.setDefault(new Locale(defLang, defCountry));

		f = DateFormat.getDateInstance(DateFormat.MEDIUM, loc);
		out.println("MEDIUM LOC => " + f.format(d));
		
	}

}
