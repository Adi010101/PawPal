package ph.edu.mseuf.pawpal.navigation

import androidx.annotation.StringRes
import ph.edu.mseuf.pawpal.R

sealed class Screens(val route: String, @StringRes val resourceId: Int) {
    object Details : Screens("details", R.string.text_details)
}
