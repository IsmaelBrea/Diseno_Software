package e1;

//definimos nuestra clase StringUtilities
public class StringUtilities {
    //todos los métodos tienen que ser PÚBLICOS y ESTÁTICOS

    //definimos el primer método estático isValidString de tipo booleano (para verificar si un String es válido o no según los criterios dados)
    public static boolean isValidString(String str, String caracteresValidos, int longitud){    //definimos el método como estático y definimos sus parámetros

        //un string nulo o vacío no puede ser válido
        if (str == null || str.isEmpty()) {     //si el string es nulo o la cadena está vacía
            return false;                       //devuelve falso
        }

        //la longitud del string tiene que ser mayor o igual que el valor numérico indicado en un parámetro del método
        if(str.length() < longitud) {   //si la longitud del string es mmenor que la longitud indicada en el parámetro,
            return false;               //entonces devuelve falso
        }

        //los caracteres del string solo pueden ser dígitos o estar entre los caracteres incluidos en un string
        for (char c : str.toCharArray()) { //recorremos caracter a caracter en el array que también hemos separado en caracteres con el método toCharArray
            if (!Character.isDigit(c) && caracteresValidos.indexOf(c) == -1){   //si el caracter no es un dígito o el caracter c no se encuentra en la cadena de los caracteres válidos
                return false;  //devuelve falso
            }
        }

        return true;    // si se cumplen todos los requisitos, el string es válido y devuelve true
    }


    //definimos el segundo método estático lowercaseFirst (reordena los caracteres de un String que se pasa como parámetro)
    public static String lowercaseFirst(String str){   //los métodos tienen que ser públicos y estáticos
        //el string debe ser NO nulo
        if (str == null) { //Si es nulo
            throw new IllegalArgumentException("El String de entrada no puede ser nulo"); //utilizamos throw new para lanzar y crear una nueva de instancia de excepción
        }

        //los strings son inmutables, para actualizarlos definimos el objeto StringBuilder
        StringBuilder resultado = new StringBuilder(str.length()); //este objeto guardará el resultado ordenado
        StringBuilder mayusculas = new StringBuilder(str.length()); //este objeto guardará las mayúsculas ordenadas

        for (int i = 0; i < str.length(); i++) {  //recorremos la longitud del string 
            char c = str.charAt(i);  //obtenemos los caracteres del string con el método charAt y los almacenamos en c
            if (Character.isLowerCase(c)) { //si el carácter es una letra minúscula
                resultado.append(c); //la añadimos al string resultado
            } else if (Character.isUpperCase(c)) { //si el carácter es una mayúscula la añadimos al string mayúsculas
                mayusculas.append(c);
            }
        }
        resultado.append(mayusculas); //juntamos el resultado reordenado por caracteres, primero minúsculas y luego mayúsculas

        return resultado.toString();  //devolvemos el resultado convirtiendolo a string
    }


    //definimos el tercer método checkTextStats, que valida si un texto que se pasa como parámetro cumple una serie de requisitos
    public static boolean checkTextStats(String str, int valorminimo, int valormaximo) {
        //el string no puede ser no nulo ni vacío
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("El String de entrada no puede ser nulo ni vacío");
        }
        //los valores que pasan como parámetros no pueden ser negativos
        if (valorminimo <= 0 || valormaximo <= 0) {
            throw new IllegalArgumentException("Los valores mínimo y máximo que se pasan como parámetros no pueden ser negativos o cero");
        }

        //comprueba que haya espacios en blanco, si hay espacios en blanco es una cadena
        String[] palabras = str.split(" ");
        float longitudMedia;
        int sumaLongitudes = 0;
        int palabraMasLarga = 0;

        for (String palabra : palabras) { //recorremos el texto palabra a palabra
            sumaLongitudes += palabra.length(); //guardamos en sumalongitudes la longitud de cada palabra
            if (palabra.length() > palabraMasLarga) { // Compara la longitud de la palabra actual
                palabraMasLarga = palabra.length();
            }
        }

        longitudMedia = (float) sumaLongitudes / palabras.length;

        return ((longitudMedia >= valorminimo) && (longitudMedia <= valormaximo) && (palabraMasLarga <= 2 * longitudMedia));
    }
}
