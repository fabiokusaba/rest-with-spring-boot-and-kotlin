package br.com.fabiokusaba.mapper.custom

import br.com.fabiokusaba.data.vo.v2.PersonVO
import br.com.fabiokusaba.model.Person
import org.springframework.stereotype.Service
import java.util.Date

@Service
class PersonMapper {

    fun mapEntityToVO(person: Person): PersonVO {
        val vo = PersonVO()

        vo.id = person.id
        vo.firstName = person.firstName
        vo.lastName = person.lastName
        vo.birthDay = Date()
        vo.address = person.address
        vo.gender = person.gender

        return vo
    }

    fun mapVOToEntity(vo: PersonVO): Person {
        val entity = Person()

        entity.id = vo.id
        entity.firstName = vo.firstName
        entity.lastName = vo.lastName
//        entity.birthDay = vo.birthDay
        entity.address = vo.address
        entity.gender = vo.gender

        return entity
    }
}