package br.com.fabiokusaba.controller

import br.com.fabiokusaba.exceptions.UnsupportedDivisionByZeroException
import br.com.fabiokusaba.exceptions.UnsupportedMathOperationException
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.math.sqrt

//@RestController
class MathController1 {

    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(@PathVariable(value= "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please, set a numeric value!")

        return convertToDouble(numberOne) + convertToDouble(numberTwo)
    }

    @RequestMapping(value = ["/sub/{numberOne}/{numberTwo}"])
    fun subtraction(@PathVariable(value= "numberOne") numberOne: String?,
                    @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please, set a numeric value!")

        return convertToDouble(numberOne) - convertToDouble(numberTwo)
    }

    @RequestMapping(value = ["/mult/{numberOne}/{numberTwo}"])
    fun multiplication(@PathVariable(value= "numberOne") numberOne: String?,
                       @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please, set a numeric value!")

        return convertToDouble(numberOne) * convertToDouble(numberTwo)
    }

    @RequestMapping(value = ["/div/{numberOne}/{numberTwo}"])
    fun division(@PathVariable(value= "numberOne") numberOne: String?,
                 @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please, set a numeric value!")

        if (convertToDouble(numberTwo) == 0.0) throw UnsupportedDivisionByZeroException("We don't support division by zero!")

        return convertToDouble(numberOne) / convertToDouble(numberTwo)
    }

    @RequestMapping(value = ["/avg/{numberOne}/{numberTwo}"])
    fun average(@PathVariable(value= "numberOne") numberOne: String?,
                @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please, set a numeric value!")

        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2.0
    }

    @RequestMapping(value = ["/sqrt/{number}"])
    fun squareRoot(@PathVariable(value= "number") number: String?): Double {
        if (!isNumeric(number))
            throw UnsupportedMathOperationException("Please, set a numeric value!")

        return sqrt(convertToDouble(number))
    }

    private fun convertToDouble(strNumber: String?): Double {
        if (strNumber.isNullOrBlank()) return 0.0

        // BR 10,20 US 10.20
        val number = strNumber.replace(",".toRegex(), ".")

        return if (isNumeric(number)) number.toDouble() else 0.0
    }

    private fun isNumeric(strNumber: String?): Boolean {
        if (strNumber.isNullOrBlank()) return false

        val number = strNumber.replace(",".toRegex(), ".")

        return number.matches("""[-+]?[0-9]*\.?[0-9]+""".toRegex())
    }
}