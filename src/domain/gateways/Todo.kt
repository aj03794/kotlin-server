package domain.gateways

interface TodoGatewayInterface {
    fun delete() {}
    fun add(): String
    fun get() {}
    fun getAll() {}
}