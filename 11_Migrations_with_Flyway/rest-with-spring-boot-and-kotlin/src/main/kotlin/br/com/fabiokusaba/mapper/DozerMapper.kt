package br.com.fabiokusaba.mapper

import com.github.dozermapper.core.DozerBeanMapperBuilder
import com.github.dozermapper.core.Mapper

object DozerMapper {

    private val mapper: Mapper = DozerBeanMapperBuilder.buildDefault()

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