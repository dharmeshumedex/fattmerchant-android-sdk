package omni.common.data.models

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.content

/**
 * An Omni Merchant
 *
 */
@Serializable
class Merchant : Model {
    override var id: String? = null
    var options: JsonObject? = null

    /**
     * Use as the apiKey for mobile reader
     *
     * @return
     */
    fun emvPassword(): String? = getOptionString("emv_password")

    private fun getOptionString(key: String): String? {
        return try {
            options?.get(key)?.content
        } catch (e: Error) {
            null
        }
    }

}