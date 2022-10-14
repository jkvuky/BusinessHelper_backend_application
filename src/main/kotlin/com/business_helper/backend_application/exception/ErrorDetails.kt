package com.business_helper.backend_application.exception

import org.springframework.http.HttpStatus
import org.springframework.util.MultiValueMap

class ErrorDetails(internalServerError: HttpStatus, message: String?, description: String,
                   override val size: Int = 0,
                   override val entries: MutableSet<MutableMap.MutableEntry<String, MutableList<String>>> = mutableSetOf(),
                   override val keys: MutableSet<String> = mutableSetOf(),
                   override val values: MutableCollection<MutableList<String>> = mutableListOf()
) :
    MultiValueMap<String, String> {
    override fun containsKey(key: String?): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsValue(value: MutableList<String>?): Boolean {
        TODO("Not yet implemented")
    }

    override fun get(key: String?): MutableList<String>? {
        TODO("Not yet implemented")
    }

    override fun clear() {
        TODO("Not yet implemented")
    }

    override fun remove(key: String?): MutableList<String>? {
        TODO("Not yet implemented")
    }

    override fun putAll(from: Map<out String, MutableList<String>>) {
        TODO("Not yet implemented")
    }

    override fun put(key: String?, value: MutableList<String>?): MutableList<String>? {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun toSingleValueMap(): MutableMap<String, String> {
        TODO("Not yet implemented")
    }

    override fun setAll(values: MutableMap<String, String>) {
        TODO("Not yet implemented")
    }

    override fun set(key: String, value: String?) {
        TODO("Not yet implemented")
    }

    override fun addAll(values: MultiValueMap<String, String>) {
        TODO("Not yet implemented")
    }

    override fun addAll(key: String, values: MutableList<out String>) {
        TODO("Not yet implemented")
    }

    override fun add(key: String, value: String?) {
        TODO("Not yet implemented")
    }

    override fun getFirst(key: String): String? {
        TODO("Not yet implemented")
    }

}
