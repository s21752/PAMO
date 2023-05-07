package com.pjatk.pamozad1.ui.recipes.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pjatk.pamozad1.R;
import com.pjatk.pamozad1.ui.recipes.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipesAdapter extends RecyclerView.Adapter<RecipesViewHolder> {

    List<Recipe> recipeList = new ArrayList<>();

    @NonNull
    @Override
    public RecipesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecipesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recipes_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecipesViewHolder holder, int position) {
        Recipe currentItem = recipeList.get(position);
        holder.bind(currentItem);
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    public void setData(List<Recipe> newRecipes) {
        recipeList.clear();
        recipeList.addAll(newRecipes);
        notifyDataSetChanged();
    }
}

class RecipesViewHolder extends RecyclerView.ViewHolder {
    View rootView;

    private TextView tvTitle, tvIngredients, tvDetails;

    public RecipesViewHolder(@NonNull View itemView) {
        super(itemView);

        rootView = itemView;
        tvTitle = itemView.findViewById(R.id.tvTitle);
        tvIngredients = itemView.findViewById(R.id.tvIngredients);
        tvDetails = itemView.findViewById(R.id.tvDetails);
    }

    public void bind(Recipe recipe) {
        tvTitle.setText(recipe.getTitle());
        tvIngredients.setText(recipe.getIngredients());
        tvDetails.setText(recipe.getDetails());
    }
}
