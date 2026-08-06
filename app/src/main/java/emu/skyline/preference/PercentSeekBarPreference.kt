/*
 * SPDX-License-Identifier: MPL-2.0
 * Copyright © 2020 Skyline Team and Contributors (https://github.com/skyline-emu/)
 */

package emu.skyline.preference

import android.content.Context
import android.util.AttributeSet
import androidx.preference.SeekBarPreference

/**
 * A SeekBarPreference that displays values with a % suffix
 */
class PercentSeekBarPreference @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = androidx.preference.R.attr.seekBarPreferenceStyle,
    defStyleRes: Int = 0
) : SeekBarPreference(context, attrs, defStyleAttr, defStyleRes) {

    init {
        setOnPreferenceChangeListener { _, newValue ->
            summary = context.getString(emu.skyline.R.string.resolution_scale_desc) + " (${newValue}%)"
            true
        }
    }

    override fun onSetInitialValue(defaultValue: Any?) {
        super.onSetInitialValue(defaultValue)
        val value = getPersistedInt(defaultValue as? Int ?: 100)
        summary = context.getString(emu.skyline.R.string.resolution_scale_desc) + " (${value}%)"
    }
}
