package omni.common.data.models

import kotlinx.serialization.Serializable


/**
 * This is a representation of the current user
 *
 * Contains info about the Merchant
 *
 */
@Serializable
class Self {
    var merchant: Merchant? = null
}
