package com.development.gocipes.home.presentation;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u000fH\u0002J\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u000fH\u0002J\b\u0010\u001b\u001a\u00020\u000fH\u0002J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J&\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020\u000fH\u0016J\u001a\u0010&\u001a\u00020\u000f2\u0006\u0010\'\u001a\u00020\u001e2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0016\u0010(\u001a\u00020\u000f2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00150*H\u0002J\u0016\u0010+\u001a\u00020\u000f2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00190*H\u0002J\u0016\u0010-\u001a\u00020\u000f2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00120*H\u0002J\u0016\u0010/\u001a\u00020\u000f2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00120*H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00061"}, d2 = {"Lcom/development/gocipes/home/presentation/HomeFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/development/gocipes/home/databinding/FragmentHomeBinding;", "binding", "getBinding", "()Lcom/development/gocipes/home/databinding/FragmentHomeBinding;", "categoryAdapter", "Lcom/development/gocipes/core/presentation/adapter/CategoryAdapter;", "foodAdapter", "Lcom/development/gocipes/core/presentation/adapter/FoodAdapter;", "informationAdapter", "Lcom/development/gocipes/core/presentation/adapter/InformationAdapter;", "navigateToArticle", "", "navigateToArticleGraph", "information", "Lcom/development/gocipes/core/model/Information;", "navigateToCategory", "category", "Lcom/development/gocipes/core/model/Category;", "navigateToFood", "navigateToFoodGraph", "food", "Lcom/development/gocipes/core/model/Food;", "navigateToSearch", "navigateToTechnique", "navigateToTechniqueGraph", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onViewCreated", "view", "setupRecyclerCategory", "categories", "", "setupRecyclerViewFood", "listFood", "setupRecyclerViewGuide", "listInformation", "setupRecyclerViewTechnique", "listTechnique", "home_debug"})
public final class HomeFragment extends androidx.fragment.app.Fragment {
    private com.development.gocipes.home.databinding.FragmentHomeBinding _binding;
    private com.development.gocipes.core.presentation.adapter.CategoryAdapter categoryAdapter;
    private com.development.gocipes.core.presentation.adapter.FoodAdapter foodAdapter;
    private com.development.gocipes.core.presentation.adapter.InformationAdapter informationAdapter;
    
    public HomeFragment() {
        super();
    }
    
    private final com.development.gocipes.home.databinding.FragmentHomeBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    @java.lang.Override
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override
    public void onViewCreated(@org.jetbrains.annotations.NotNull
    android.view.View view, @org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupRecyclerCategory(java.util.List<com.development.gocipes.core.model.Category> categories) {
    }
    
    private final void setupRecyclerViewFood(java.util.List<com.development.gocipes.core.model.Food> listFood) {
    }
    
    private final void setupRecyclerViewGuide(java.util.List<com.development.gocipes.core.model.Information> listInformation) {
    }
    
    private final void setupRecyclerViewTechnique(java.util.List<com.development.gocipes.core.model.Information> listTechnique) {
    }
    
    private final void navigateToFood() {
    }
    
    private final void navigateToFoodGraph(com.development.gocipes.core.model.Food food) {
    }
    
    private final void navigateToArticle() {
    }
    
    private final void navigateToArticleGraph(com.development.gocipes.core.model.Information information) {
    }
    
    private final void navigateToTechnique() {
    }
    
    private final void navigateToTechniqueGraph(com.development.gocipes.core.model.Information information) {
    }
    
    private final void navigateToSearch() {
    }
    
    private final void navigateToCategory(com.development.gocipes.core.model.Category category) {
    }
    
    @java.lang.Override
    public void onDestroy() {
    }
}