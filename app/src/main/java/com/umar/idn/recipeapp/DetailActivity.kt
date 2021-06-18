package com.umar.idn.recipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.umar.idn.recipeapp.data.Recipes
import com.umar.idn.recipeapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var detailBinding: ActivityDetailBinding

    companion object {
        const val RECIPE_DATA = "recipe_data"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding.root)

        setSupportActionBar(detailBinding.tbDetail)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        val dataRecipes = intent.getParcelableExtra<Recipes>(RECIPE_DATA) as Recipes
        Glide.with(this)
            .load(dataRecipes.pictures)
            .into(detailBinding.ivDetail)

        detailBinding.tvNameDetail.text = dataRecipes.name
        detailBinding.tvCaloriesDetail.text = dataRecipes.calories
        detailBinding.tvCarboDetail.text = dataRecipes.carbo
        detailBinding.tvProteinDetail.text = dataRecipes.protein
        detailBinding.tvDescriptionDetail.text = dataRecipes.description
        detailBinding.tvIngredients.text = dataRecipes.ingredients
        detailBinding.tvInstruction.text = dataRecipes.instructions
    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}