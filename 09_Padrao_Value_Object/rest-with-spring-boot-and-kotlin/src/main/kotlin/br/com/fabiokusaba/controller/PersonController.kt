package br.com.fabiokusaba.controller

import br.com.fabiokusaba.data.vo.v1.PersonVO
import br.com.fabiokusaba.model.Person
import br.com.fabiokusaba.services.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/person")
class PersonController {

    @Autowired
    private lateinit var service: PersonService
    // var service: PersonService = PersonService()

    @GetMapping(produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findAll(): List<PersonVO> = service.findAll()

    @GetMapping("/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun findById(@PathVariable(value = "id") id: Long): PersonVO = service.findById(id)

    @PostMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun create(@RequestBody person: PersonVO): PersonVO = service.create(person)

    @PutMapping(consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun update(@RequestBody person: PersonVO): PersonVO = service.update(person)

    @DeleteMapping(value = ["/{id}"], produces = [MediaType.APPLICATION_JSON_VALUE])
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable(value = "id") id: Long) = service.delete(id)

}