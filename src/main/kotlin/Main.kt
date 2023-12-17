fun lang(sym: String): String
{
    val ru = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪФЬЭЮЯ".toString();
    val en = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toString();
    for(a in ru)
    {
        if (regs(sym[0]) == a) {return ru;}
    }
    for(a in en)
    {
        if (regs(sym[0]) == a) {return en;}
    }
    return "";
}
fun regs(sym: Char): Char
{
    when(sym)
    {
        'а' -> return 'А';
        'б' -> return 'Б';
        'в' -> return 'В';
        'г' -> return 'Г';
        'д' -> return 'Д';
        'е' -> return 'Е';
        'ё' -> return 'Ё';
        'ж' -> return 'Ж';
        'з' -> return 'З';
        'и' -> return 'И';
        'й' -> return 'Й';
        'к' -> return 'К';
        'л' -> return 'Л';
        'м' -> return 'М';
        'н' -> return 'Н';
        'о' -> return 'О';
        'п' -> return 'П';
        'р' -> return 'Р';
        'с' -> return 'С';
        'т' -> return 'Т';
        'у' -> return 'У';
        'ф' -> return 'Ф';
        'х' -> return 'Х';
        'ц' -> return 'Ц';
        'ч' -> return 'Ч';
        'ш' -> return 'Ш';
        'щ' -> return 'Щ';
        'ъ' -> return 'Ъ';
        'ы' -> return 'Ы';
        'ь' -> return 'Ь';
        'э' -> return 'Э';
        'ю' -> return 'Ю';
        'я' -> return 'Я';
        'a' -> return 'A';
        'g' -> return 'G';
        'b' -> return 'B';
        'c' -> return 'C';
        'd' -> return 'D';
        'e' -> return 'E';
        'f' -> return 'F';
        'h' -> return 'H';
        'i' -> return 'I';
        'j' -> return 'J';
        'k' -> return 'K';
        'l' -> return 'L';
        'm' -> return 'M';
        'n' -> return 'N';
        'o' -> return 'O';
        'p' -> return 'P';
        'q' -> return 'Q';
        'r' -> return 'R';
        's' -> return 'S';
        't' -> return 'T';
        'u' -> return 'U';
        'v' -> return 'V';
        'w' -> return 'W';
        'x' -> return 'X';
        'y' -> return 'Y';
        'z' -> return 'Z';
        else -> {return sym;};
    }
}

fun conv(str: String) : String
{
    println(str);
    val abc = lang(str);
    var res = "";
    for (i in 0 until str.length)
    {
        for (f in 0 until abc.length)
        {
            if (regs(str[i]) == abc[f])
            {
                res += (f + 1).toString() + " ";
            }
        }
    }

    return res;
}

fun conv_single(str: String) : Int
{
    val abc = lang(str);
    var res = 0;
    for (element in str)
    {
        for (f in abc.indices)
        {
            if (regs(element) == abc[f])
            {
                res = f + 1;
                return res;
            }
        }
    }
    return res;
}

fun conv(str: String, key: String) : String {
    //println(key);
    val abc = lang(key);
    var res = "";
    var keyint = 0;
    var j = 0;
    for (i in 0 until key.length) {
        keyint = conv_single(str[j].toString())
        //println(keyint);
        if (j < str.length - 1) {
            j++;
        } else {
            j = 0;
        }
        for (f in 0 until abc.length) {
            if (regs(key[i]) == abc[f]) {
                if ((f + keyint) <= abc.length) {
                    res += abc[f + keyint];
                } else {
                    res += abc[(f + keyint) - abc.length]
                }
            }
        }
    }
    return res;
}

fun unconv(str: String, key: String) : String
{
    //println(str);
    //print(key);
    val abc = lang(str);
    var res = "";
    var keyint = 0;
    var letter = 0;
    var j = 0;
    for (i in 0 until str.length)
    {
        keyint = conv_single(key[j].toString());
        letter = conv_single(str[i].toString());
        //println(keyint);
        if (j < key.length - 1) {j++;} else {j = 0;}
        if (letter - keyint < 0)
        {
            res += abc[(abc.length - 1) + (letter - keyint)];
        } else
        {
            res += abc[letter - keyint - 1];
        }
    }

    return res;
}

fun main(args: Array<String>) {
    print("Input origin word: ");
    val kw = readln();
    print("Input keyword: ");
    val origin = readln();
    val result = conv(origin, kw);
    println("Masked word: " + result);
    print("Unmasked word: " + unconv(result, origin));
}