package com.silveira.jonathang.android.domain.mapper

interface Mapper<in T, out R> {
    fun map(source: T) : R
}