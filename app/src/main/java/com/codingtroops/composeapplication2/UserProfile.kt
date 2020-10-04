package com.codingtroops.composeapplication2

data class UserProfile(
        val name: String,
        val profilePictureDrawableId: Int,
        val lastActivityMinutes: Int,
        val isOnline: Boolean
) {
    companion object {
        fun getMockProfileUser() = UserProfile("Catalin Ghita",
                R.drawable.profile_pic,
                2,
                true)
    }
}