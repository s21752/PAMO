package com.pjatk.pamozad1.ui.recipes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.pjatk.pamozad1.R
import com.pjatk.pamozad1.ui.recipes.adapter.RecipesAdapter
import com.pjatk.pamozad1.ui.recipes.model.Recipe
import org.apache.commons.io.IOUtils
import java.nio.charset.StandardCharsets

class RecipesFragment : Fragment() {
    private val recipesAdapter = RecipesAdapter()
    private var recipesList: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return LayoutInflater.from(requireContext())
            .inflate(R.layout.fragment_recipes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViews()
    }

    private fun setViews() {
        recipesList = requireView().findViewById(R.id.rvRecipesList)
        recipesList?.setAdapter(recipesAdapter)
        recipesAdapter.setData(loadRecipes())
    }

    private fun loadRecipes(): List<Recipe> {
        val recipesString: String
        var deserializedRecipes: List<Recipe> = ArrayList()
        try {
            recipesString = IOUtils.toString(
                requireContext().resources.openRawResource(R.raw.recipes),
                StandardCharsets.UTF_8
            )
            deserializedRecipes = GsonBuilder().create()
                .fromJson(recipesString, object : TypeToken<List<Recipe>>() {}.type)
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
        return deserializedRecipes
    }
}