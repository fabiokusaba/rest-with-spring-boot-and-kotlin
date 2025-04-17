package br.com.fabiokusaba.mapper

import org.modelmapper.ModelMapper

object ModelMapper {

    private val mapper: ModelMapper = ModelMapper()

    fun <Origem, Destino> parseObject(origem: Origem, destino: Class<Destino>?): Destino {
        return mapper.map(origem, destino)
    }

    fun <Origem, Destino> parseListObjects(origem: List<Origem>, destino: Class<Destino>?): List<Destino> {
        val destinationObjects: ArrayList<Destino> = ArrayList()

        for (o in origem) {
            destinationObjects.add(parseObject(o, destino))
        }

        return destinationObjects
    }
}