package com.pjatk.pamozad1.ui.recipes.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pjatk.pamozad1.R
import com.pjatk.pamozad1.ui.recipes.model.Recipe

class RecipesAdapter : RecyclerView.Adapter<RecipesViewHolder>() {
    var recipeList: MutableList<Recipe> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesViewHolder {
        return RecipesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_recipes_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecipesViewHolder, position: Int) {
        val currentItem = recipeList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

    fun setData(newRecipes: List<Recipe>?) {
        recipeList.clear()
        recipeList.addAll(newRecipes!!)
        notifyDataSetChanged()
    }
}

class RecipesViewHolder(var rootView: View) : RecyclerView.ViewHolder(
    rootView
) {
    private val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
    private val tvIngredients: TextView = itemView.findViewById(R.id.tvIngredients)
    private val tvDetails: TextView = itemView.findViewById(R.id.tvDetails)

    fun bind(recipe: Recipe) {
        tvTitle.text = recipe.title
        tvIngredients.text = recipe.ingredients
        tvDetails.text = recipe.details
    }
}