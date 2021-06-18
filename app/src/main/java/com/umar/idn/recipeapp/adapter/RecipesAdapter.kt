package com.umar.idn.recipeapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.umar.idn.recipeapp.DetailActivity
import com.umar.idn.recipeapp.data.Recipes
import com.umar.idn.recipeapp.databinding.ItemRecipeBinding

class RecipesAdapter(private val listRecipes: ArrayList<Recipes>) :
    RecyclerView.Adapter<RecipesAdapter.RecipeViewHolder>() {

    inner class RecipeViewHolder(val binding: ItemRecipeBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecipeViewHolder {
        val binding = ItemRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        with(holder) {
            with(listRecipes[position]) {
                Glide.with(holder.itemView.context)
                    .load(pictures)
                    .into(binding.ivItemRecipe)
                binding.tvItemName.text = name
                binding.tvItemCategory.text = category
                binding.tvItemNumber.text = number
                val mContext = holder.itemView.context
                holder.itemView.setOnClickListener {
                    val dataSend = Recipes(
                        name = listRecipes[position].name,
                        category = listRecipes[position].category,
                        description = listRecipes[position].description,
                        ingredients = listRecipes[position].ingredients,
                        instructions = listRecipes[position].instructions,
                        pictures = listRecipes[position].pictures,
                        number = listRecipes[position].number,
                        calories = listRecipes[position].calories,
                        carbo = listRecipes[position].carbo,
                        protein = listRecipes[position].protein
                    )
                    val intentToDetail = Intent(mContext, DetailActivity::class.java)
                    intentToDetail.putExtra(DetailActivity.RECIPE_DATA, dataSend)
                    mContext.startActivity(intentToDetail)

                }
            }
        }
    }
    override fun getItemCount(): Int = listRecipes.size
}