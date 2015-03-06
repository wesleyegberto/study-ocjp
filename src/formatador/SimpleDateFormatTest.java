/**
 * @author Wesley Egberto de Brito Objetivo: Teste com a classe SimpleDateFormat
 */

package formatador;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Properties;

import static java.lang.System.*;

public class SimpleDateFormatTest {
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

		// Formata a data: dd -> dia com 2 digitos, MM -> mes com 2 digitos,
		// yyyy -> ano com 4 digitos
		SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		out.println("dd/MM/yyyy => " + f.format(d));

		// Formata a hora: HH -> hora de 1 a 12, mm -> minuto 2 digitos, ss ->
		// segundo 2 digitos, SS -> milisegundos
		f = new SimpleDateFormat("HH:mm:ss.SSS");
		out.println("HH:mm:ss.SSS => " + f.format(d));

		System.out.println("\n\nTestes com Locale");
		Locale loc = new Locale("pt", "Br"); // Lingua e pais

		// EEEE -> dia da semana por extenso, MMMM -> dia do mes por extenso
		f = new SimpleDateFormat("EEEE, MMMM dd", loc);
		out.println("EEEE MMMM dd => " + f.format(d));
		

		String dataExtenso = null;
		DateFormat dateFormat = null;
		Properties myConfig = System.getProperties();
		
		String defLang = myConfig.getProperty("user.language");
		String defCountry = myConfig.getProperty("user.country");
		
		System.out.println("\nUser languange: " + defLang);
		System.out.println("User country: " + defCountry);
		
		Locale.setDefault(new Locale(defLang, defCountry));

		dateFormat = new SimpleDateFormat("EEEEE',' dd 'de' MMMM");
		dataExtenso = dateFormat.format(c.getTime());
		System.out.println(dataExtenso);

		dateFormat = new SimpleDateFormat("'Barueri,' dd 'de' MMMM 'de' yyyy");
		dataExtenso = dateFormat.format(c.getTime());
		System.out.println(dataExtenso);

		Locale.setDefault(new Locale("en", "US"));
		dateFormat = new SimpleDateFormat("MMM dd',' yyyy");
		dataExtenso = dateFormat.format(c.getTime());
		System.out.println(dataExtenso);
	}

}
