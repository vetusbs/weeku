package io.weeku.data.datasource.meal

import io.weeku.data.repository.meal.JpaDish
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.Repository
import org.springframework.stereotype.Component


@Component
interface DishDatasource : Repository<JpaDish, Int> {
    @Query("select * from dish order by random() limit 1", nativeQuery = true)
    fun findRandomDish(): JpaDish

    fun findAll(): List<JpaDish>
}
