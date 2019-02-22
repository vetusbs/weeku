package io.weeku.data.datasource.meal

import io.weeku.data.repository.meal.JpaDish
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Component


@Component
interface DishDatasource : CrudRepository<JpaDish, Int> {
    @Query("select * from dish order by random() limit 1", nativeQuery = true)
    fun findRandomDish(): JpaDish
}
