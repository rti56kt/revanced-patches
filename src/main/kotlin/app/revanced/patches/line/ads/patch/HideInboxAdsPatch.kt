package app.revanced.patches.line.ads.patch

import app.revanced.util.exception
import app.revanced.patcher.data.BytecodeContext
import app.revanced.patcher.extensions.InstructionExtensions.replaceInstruction
import app.revanced.patcher.patch.BytecodePatch
import app.revanced.patcher.patch.annotation.CompatiblePackage
import app.revanced.patcher.patch.annotation.Patch
import app.revanced.patches.line.ads.fingerprints.LoadAdsFingerprint

@Patch(
    name = "Hide ads",
    description = "Hides ads.",
    compatiblePackages = [CompatiblePackage("jp.naver.line.android")]
)
@Suppress("unused")
object HideInboxAdsPatch : BytecodePatch(
    setOf(LoadAdsFingerprint)
) {
    override fun execute(context: BytecodeContext) {
        LoadAdsFingerprint.result?.mutableMethod?.apply {
            this.replaceInstruction(0, "return-void")
        } ?: throw LoadAdsFingerprint.exception
    }
}
