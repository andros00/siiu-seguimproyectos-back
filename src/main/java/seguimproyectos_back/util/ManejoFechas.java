package seguimproyectos_back.util;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//import org.apache.log4j.Logger;

/**
* Clase para dar formato a las fechas
* @author Adalberto Montes
* @version 1.0
*/
public class ManejoFechas implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6377038168235279265L;
//	private static Logger logger = Logger.getLogger(ManejoFechas.class);
//	private static boolean debug = logger.isDebugEnabled();
	
	private static SimpleDateFormat dateFormatSql = new SimpleDateFormat("yyyy-MM-dd");
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	private static SimpleDateFormat dateTimeFormat24HM = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	private static SimpleDateFormat dateTimeFormatLargo = new SimpleDateFormat("MMMM d 'de' yyyy - h:mm a");
	private static SimpleDateFormat dateTimeFormatDiaLargo = new SimpleDateFormat("MMMM d 'de' yyyy");
	private static SimpleDateFormat dateTimeFormatMesDiaAno = new SimpleDateFormat("MMMM d 'de' yyyy");

	/**
	 * TRunca una fecha 
	 * @param fecha fecha en string
	 * @return fecha en date
	 */
	public static Date formatearFecha(Date fecha)	 {
		try {
			if(fecha == null) return null;
			return dateFormat.parse(dateFormat.format(fecha));
		} catch (Exception e) {
			return null;
		}
	}
	
	public static Date formatearFechaHora(Date fecha)	 {
		try {
			if(fecha == null) return null;
			return dateTimeFormat24HM.parse(dateTimeFormat24HM.format(fecha));
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * TRunca una fecha 
	 * @param fecha fecha en string
	 * @return fecha en date
	 */
	public static Date truncarFecha(Date fecha)	 {
		try {
			if(fecha == null) return null;
            Calendar cal = Calendar.getInstance();
            cal.setTime(fecha);
            // Set time fields to zero
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            return cal.getTime();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Convierte la fecha tipo string en date con un formato especifico
	 * @param fecha fecha en string
	 * @return fecha en date
	 */
	public static Date parseDate(String fecha)	 {
//		if (debug) logger.debug("parseDate: " + fecha);
		try {
			if(fecha != null && !fecha.equalsIgnoreCase(""))return dateFormat.parse(fecha);
		} catch (ParseException e) {
//			logger.error(e);
		}
		return null;
	}
	
	/**
	 * Convierte la fecha tipo string en date con un formato especifico
	 * @param fecha fecha en string
	 * @return fecha en date
	 */
	public static Date parseTimeDate(String fecha)	 {
//		if (debug) logger.debug("parseDateTime: " + fecha);
		try {
			return dateTimeFormat.parse(fecha);
		} catch (ParseException e) {
//			logger.error(e);
			return null;
		}
	}
	
	/**
	 * Convierte la fecha tipo string en date con un formato especifico
	 * @param fecha fecha en string
	 * @return fecha en date
	 */
	public static Date parseTimeDate24HM(String fecha)	 {
//		if (debug) logger.debug("parseDateTime24HM: " + fecha);
		try {
			return dateTimeFormat24HM.parse(fecha);
		} catch (ParseException e) {
//			logger.error(e);
			return null;
		}
	}
	/**
	 * Convierte la fecha tipo string en date con un formato especifico
	 * @param fecha fecha en string
	 * @return fecha en date
	 */
	public static String formatDate(Date fecha) {
        if(fecha == null) return "";
		return dateFormat.format(fecha);
	}
	
	/**
	 * Convierte la fecha tipo string en date con un formato especifico para la bd
	 * @param fecha fecha en string
	 * @return fecha en date
	 */
	public static String formatDateSql(Date fecha) {
        if(fecha == null) return "";
		return dateFormatSql.format(fecha);
	}

	/**
	 * Convierte la fecha tipo string en date con un formato especifico
	 * @param fecha fecha en string
	 * @return fecha en date
	 */
	public static String formatTimeDateLargo(Date fecha) {
		return dateTimeFormatLargo.format(fecha);
	}
	/**
	 * Convierte la fecha tipo string en date con un formato especifico
	 * @param fecha fecha en string
	 * @return fecha en date
	 */
	public static String formatTimeDiaLargo(Date fecha) {
		return dateTimeFormatDiaLargo.format(fecha);
	}
	/**
	 * Convierte la fecha tipo string en date con un formato especifico
	 * @param fecha fecha en string
	 * @return fecha en date
	 */
	public static String formatTimeDateMesDiaAno(Date fecha) {
		return dateTimeFormatMesDiaAno.format(fecha);
	}
	
	/**
	 * Captura la fecha inicial del mes
	 * @return fecha inicial 
	 */	
	public static Date getFechaInicialMes() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		return cal.getTime();
	}
	/**
	 * Captura la fecha final del mes
	 * @return fecha inicial 
	 */	
	public static Date getFechaFinalMes() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		return cal.getTime();
	}
	/**
	 * Captura la fecha en formato de 24 horas
	 * @return fecha en formato de 24 horas
	 */
	public static String getFormatoDateTime24HM() {
		return dateTimeFormat24HM.toPattern();
	}
	
	/**
	 * Convierte la fecha tipo string en date con un formato especifico
	 * @param fecha fecha en string
	 * @return fecha en date
	 */
	public static String formatDateTime(Date fecha) {
        if(fecha == null) return "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SS");
        return sdf.format(fecha.getTime());
	}
	
	/**
	 * Recibe una fecha y le adiciona 00:00:00. Necesario para los reportes. Si Fecha es null, devuelve la fecha actual
	 * @param fecha fecha en string
	 * @return fecha tipo date
	 */
	public static Date parseFechaInicial(String fecha) {
//		if (debug) logger.debug("parseFechaInicial: " + fecha);
		
		if (fecha == null)  fecha = formatDate(new Date());
		
		try {
			return dateTimeFormat.parse(fecha + " 00:00:00");
		} catch (ParseException e) {
//			logger.error(e);
			return null;
		}
	}

	/**
	 * Recibe una fecha y le adiciona 23:59:59. Necesario para los reportes. Si Fecha es null, devuelve la fecha actual
	 * @param fecha
	 * @return fecha tipo date
	 */
	public static Date parseFechaFinal(String fecha) {
//		if (debug) logger.debug("parseFechaFinal: " + fecha);
		
		if (fecha == null)  fecha = formatDate(new Date());
		
		try {
			return dateTimeFormat.parse(fecha + " 23:59:59");
		} catch (ParseException e) {
//			logger.error(e);
			return null;
		}
	}
	
	/**
	 * Captura la fecha final del mes
	 * @return fecha inicial 
	 */	
	public static Date getFechaInicial(int mes, int ano) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.DATE, 0);
		cal.set(Calendar.MONTH, mes - 1);
		cal.set(Calendar.YEAR, ano);
		return cal.getTime();
	}
	
	/**
	 * Captura la fecha final del mes
	 * @return fecha inicial 
	 */	
	public static Date getFechaFinal(int mes, int ano) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MONTH, mes - 1);
		cal.set(Calendar.YEAR, ano);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
		return cal.getTime();
	}

    /**
     * Suma o resta los dias a una fecha
     * @param fecha Fecha a la que se le van a restar los dias
     * @param dias Dias a restar
     * @param meses Meses a restar
     * @param anos Años a restar
     * @return Fecha con los dias restados
     */
	public static Date sumarRestarDiasFecha(Date fecha, int dias, int meses, int anos) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha); // Configuramos la fecha que se recibe
        calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<0
        calendar.add(Calendar.MONTH, meses);  // numero de meses a añadir, o restar en caso de días<0
        calendar.add(Calendar.YEAR, anos);  // numero de años a añadir, o restar en caso de días<0
        
        return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos
    }

    /**
     * Captura el año actual
     * @return Entero con el año
     */
    public static int getAnoActual(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        return calendar.get(Calendar.YEAR);
    }
    /**
     * Captura el año actual
     * @return Entero con el año
     */
    public static int getMesActual(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        return calendar.get(Calendar.MONTH);
    }
    /**
     * Captura el año actual
     * @return Entero con el año
     */
    public static int getDiaActual(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        return calendar.get(Calendar.DAY_OF_MONTH);
    }
    /**
     * Captura el año actual
     * @return Entero con el año
     */
    public static int getSemestreActual(){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        if(calendar.get(Calendar.MONTH) < 6) return 1;
        return 2;
    }
    /**
     * Captura el año actual
     * @return Entero con el año
     */
    public static int getAnoFecha(Date fecha){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha); // Configuramos la fecha que se recibe
        return calendar.get(Calendar.YEAR);
    }
    /**
     * Captura el año actual
     * @return Entero con el año
     */
    public static int getMesFecha(Date fecha){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha); // Configuramos la fecha que se recibe
        return calendar.get(Calendar.MONTH);
    }
    /**
     * Captura el año actual
     * @return Entero con el año
     */
    public static int getDiaFecha(Date fecha){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha); // Configuramos la fecha que se recibe
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * Compara dos fechas, solamente con dia, mes y año
     * @param fecha1 Fecha uno para comparar
     * @param fecha2 Fecha dos para comparar
     * @return 1 si la fecha1 es mayor que la fecha2, -1 si la fecha2 es mayor que la fecha1, 0 si las dos son iguales
     */
    public static int compararFechas(Date fecha1, Date fecha2) {
        if(fecha1 == null && fecha2 == null){
            return 0;
        }else if(fecha1 != null && fecha2 == null){
            return 1;
        }else if(fecha2 != null && fecha1 == null){
            return -1;
        }
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTime(fecha1); // Configuramos la fecha que se recibe
        calendar2.setTime(fecha2); // Configuramos la fecha que se recibe
        calendar1.set(Calendar.HOUR_OF_DAY, 0);
        calendar1.set(Calendar.MINUTE, 0);
        calendar1.set(Calendar.SECOND, 0);
        calendar1.set(Calendar.MILLISECOND, 0);
        calendar2.set(Calendar.HOUR_OF_DAY, 0);
        calendar2.set(Calendar.MINUTE, 0);
        calendar2.set(Calendar.SECOND, 0);
        calendar2.set(Calendar.MILLISECOND, 0);
        if(calendar1.after(calendar2))return 1;
        else if(calendar2.after(calendar1))return -1;
        else return 0;
    }
    
    public static Date adicionarDiasAFecha(Date fecha, Integer numeroDias) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha); // Configuramos la fecha que se recibe
        calendar.add(Calendar.DAY_OF_YEAR, numeroDias);  // numero de días a añadir, o restar en caso de días<0
        return calendar.getTime();
    }
}
