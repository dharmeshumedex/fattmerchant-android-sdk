package omni.android

import android.content.Context
import omni.common.networking.OmniApi

data class InitParams(
    var appContext: Context,
    var apiKey: String,
    var environment: OmniApi.Environment = OmniApi.Environment.LIVE,
    var appId: String
)