package ph.edu.mseuf.pawpal.navigation




sealed class CategoryScreen(val route: String) {

    object Cat : CategoryScreen("cat_category")
    object Dog : CategoryScreen("dog_category")
    object SeeAll: CategoryScreen("adoptionlist_page")
    object SeeAllDog: CategoryScreen("doglist_page")
    object SeeAllCat: CategoryScreen("catlist_page")
    object Search: CategoryScreen("search_page")
    object EditProfile: CategoryScreen("editProfile")
    object Details : CategoryScreen("details")

}