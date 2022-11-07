import java.io.File

fun main(args: Array<String>) {

    var mode = "enc"
    var key = 0
    var data = ""
    var input = ""
    var output = ""
    var alg = "shift"

    for (i in args.indices) {
        when (args[i]) {
            "-mode" -> mode = args[i + 1]
            "-key" -> key = args[i + 1].toInt()
            "-data" -> data = args[i + 1]
            "-in" -> input = args[i + 1]
            "-out" -> output = args[i + 1]
            "-alg" -> alg = args[i + 1]
        }
    }

    if (input != "" && File(input).exists() && data == "") {
        data = File(input).readText()
    }

    when (mode) {
        "enc" -> encodeMessage(data, key, output, alg)
        "dec" -> decodeMessage(data, key, output, alg)
    }
}

fun encodeMessage(data: String, key: Int, output: String, alg: String) {
    var messageEncoded = ""

    for (ch in data) {
        var chCode = ch.code

        if (alg == "shift" || alg != "unicode") {
            when {
                ch.isLowerCase() -> chCode = shiftLowerCase(ch, key, "enc")
                ch.isUpperCase() -> chCode = shiftUpperCase(ch, key, "enc")
            }
        } else {
            chCode += key
        }
        messageEncoded += chCode.toChar()
    }

    if (output == "") {
        print(messageEncoded)
    } else {
        File(output).writeText(messageEncoded)
    }

}

fun decodeMessage(data: String, key: Int, output: String, alg: String) {
    var messageDecoded = ""

    for (ch in data) {
        var chCode = ch.code

        if (alg == "shift" || alg != "unicode") {
            when {
                ch.isLowerCase() -> chCode = shiftLowerCase(ch, key, "dec")
                ch.isUpperCase() -> chCode = shiftUpperCase(ch, key, "dec")
            }
        } else {
            chCode -= key
        }
        messageDecoded += chCode.toChar()
    }
    if (output == "") {
        print(messageDecoded)
    } else {
        File(output).writeText(messageDecoded)
    }
}

fun shiftLowerCase(ch: Char, key: Int, mode: String): Int {
    val keyNew = if (key > 26) key % 26 else key
    var chCode = ch.code

    when (mode) {
        "enc" -> chCode += keyNew
        "dec" -> chCode -= keyNew
    }

    if (!chCode.toChar().isLowerCase()) {
        when (mode) {
            "enc" -> chCode -= 26
            "dec" -> chCode += 26
        }

    }
    return chCode
}

fun shiftUpperCase(ch: Char, key: Int, mode: String): Int {
    val keyNew = if (key > 26) key % 26 else key
    var chCode = ch.code

    when (mode) {
        "enc" -> chCode += keyNew
        "dec" -> chCode -= keyNew
    }

    if (!chCode.toChar().isUpperCase()) {
        when (mode) {
            "enc" -> chCode -= 26
            "dec" -> chCode += 26
        }
    }
    return chCode
}