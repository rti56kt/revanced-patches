package app.revanced.patches.line.ads.fingerprints

import app.revanced.patcher.extensions.or
import app.revanced.patcher.fingerprint.MethodFingerprint
import com.android.tools.smali.dexlib2.AccessFlags

internal object LoadInboxAdsFingerprint : MethodFingerprint(
    returnType = "V",
    strings = listOf(
        "context",
        "getApplicationContext(...)"
    ),
    accessFlags = AccessFlags.PUBLIC or AccessFlags.FINAL,
    customFingerprint = { methodDef, _ ->
        methodDef.definingClass == "Lcom/linecorp/line/ladsdk/LineAdvertise;"
    }
)
