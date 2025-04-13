package br.com.fabiokusaba.controller

import br.com.fabiokusaba.model.Person
import br.com.fabiokusaba.services.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/person")
class PersonController {

    @Autowired
    private lateinit var service: PersonService
    // var service: PersonService = PersonService()

    @RequestMapping(method = [RequestMethod.GET], produces = ["application/json"])
    fun findAll(): List<Person> = service.findAll()

    @RequestMapping(value = ["/{id}"], method = [RequestMethod.GET], produces = ["application/json"])
    fun findById(@PathVariable(value = "id") id: Long): Person = service.findById(id)

    @RequestMapping(method = [RequestMethod.POST], consumes = ["application/json"], produces = ["application/json"])
    fun create(@RequestBody person: Person): Person = service.create(person)

    @RequestMapping(method = [RequestMethod.PUT], consumes = ["application/json"], produces = ["application/json"])
    fun update(@RequestBody person: Person): Person = service.update(person)

    @RequestMapping(value = ["/{id}"], method = [RequestMethod.DELETE], produces = ["application/json"])
    fun delete(@PathVariable(value = "id") id: Long) = service.delete(id)
}