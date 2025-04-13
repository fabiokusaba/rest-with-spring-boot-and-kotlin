package br.com.fabiokusaba.controller

import br.com.fabiokusaba.converters.NumberConverter
import br.com.fabiokusaba.exceptions.UnsupportedDivisionByZeroException
import br.com.fabiokusaba.exceptions.UnsupportedMathOperationException
import br.com.fabiokusaba.math.SimpleMathOperations
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.math.sqrt

@RestController
class MathController {

    private val math: SimpleMathOperations = SimpleMathOperations()

    @RequestMapping(value = ["/sum/{numberOne}/{numberTwo}"])
    fun sum(@PathVariable(value= "numberOne") numberOne: String?,
            @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please, set a numeric value!")

        return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @RequestMapping(value = ["/sub/{numberOne}/{numberTwo}"])
    fun subtraction(@PathVariable(value= "numberOne") numberOne: String?,
                    @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please, set a numeric value!")

        return math.subtraction(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @RequestMapping(value = ["/mult/{numberOne}/{numberTwo}"])
    fun multiplication(@PathVariable(value= "numberOne") numberOne: String?,
                       @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please, set a numeric value!")

        return math.multiplication(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @RequestMapping(value = ["/div/{numberOne}/{numberTwo}"])
    fun division(@PathVariable(value= "numberOne") numberOne: String?,
                 @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please, set a numeric value!")

        if (NumberConverter.convertToDouble(numberTwo) == 0.0)
            throw UnsupportedDivisionByZeroException("We don't support division by zero!")

        return math.division(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @RequestMapping(value = ["/avg/{numberOne}/{numberTwo}"])
    fun average(@PathVariable(value= "numberOne") numberOne: String?,
                @PathVariable(value = "numberTwo") numberTwo: String?
    ): Double {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw UnsupportedMathOperationException("Please, set a numeric value!")

        return math.average(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo))
    }

    @RequestMapping(value = ["/sqrt/{number}"])
    fun squareRoot(@PathVariable(value= "number") number: String?): Double {
        if (!NumberConverter.isNumeric(number))
            throw UnsupportedMathOperationException("Please, set a numeric value!")

        return math.squareRoot(NumberConverter.convertToDouble(number))
    }
}