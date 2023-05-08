package com.pjatk.pamozad1.ui.recipes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.pjatk.pamozad1.R;
import com.pjatk.pamozad1.ui.recipes.adapter.RecipesAdapter;
import com.pjatk.pamozad1.ui.recipes.model.Recipe;
import org.apache.commons.io.IOUtils;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class RecipesFragment extends Fragment {

    private RecipesAdapter recipesAdapter = new RecipesAdapter();

    RecyclerView recipesList;
    @Nullable
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(requireContext()).inflate(R.layout.fragment_recipes, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setViews();
    }

    private void setViews() {
        recipesList = view.findViewById(R.id.rvRecipesList);
        recipesList.setAdapter(recipesAdapter);

        recipesAdapter.setData(loadRecipes());
    }

    private List<Recipe> loadRecipes() {
        String recipesString;
        List<Recipe> deserializedRecipes = new ArrayList<>();
        try {
            recipesString = IOUtils.toString(getContext().getResources().openRawResource(R.raw.recipes), StandardCharsets.UTF_8);

            deserializedRecipes = new GsonBuilder().create().fromJson(recipesString, new TypeToken<List<Recipe>>() {}.getType());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return deserializedRecipes;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        view = null;
    }
}
