package app.revanced.patches.line.ads.fingerprints

import app.revanced.patcher.extensions.or
import app.revanced.patcher.fingerprint.MethodFingerprint
import com.android.tools.smali.dexlib2.AccessFlags

internal object LoadAdsFingerprint : MethodFingerprint(
    returnType = "V",
    strings = listOf(
        "CREATE TABLE IF NOT EXISTS `ads` (`rid_uaid` TEXT NOT NULL, `inventory_key` TEXT NOT NULL, `ad_total` INTEGER NOT NULL, `ad_order` INTEGER NOT NULL, `ad` TEXT NOT NULL, `state` TEXT NOT NULL, `expiration_time` INTEGER NOT NULL, PRIMARY KEY(`rid_uaid`))",
        "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)"
    ),
    accessFlags = AccessFlags.PUBLIC or AccessFlags.FINAL,
    customFingerprint = { methodDef, _ ->
        methodDef.definingClass == "Lcom/linecorp/line/ladsdk/impl/internal/db/LadDatabase_Impl;"
    }
)
