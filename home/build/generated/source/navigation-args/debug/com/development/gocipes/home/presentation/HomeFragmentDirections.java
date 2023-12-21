package com.development.gocipes.home.presentation;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.development.gocipes.core.model.Category;
import com.development.gocipes.core.model.Food;
import com.development.gocipes.core.model.Information;
import com.development.gocipes.home.R;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class HomeFragmentDirections {
  private HomeFragmentDirections() {
  }

  @NonNull
  public static NavDirections actionHomeFragmentToSearchFragment() {
    return new ActionOnlyNavDirections(R.id.action_homeFragment_to_searchFragment);
  }

  @NonNull
  public static NavDirections actionHomeFragmentToArticleFragment() {
    return new ActionOnlyNavDirections(R.id.action_homeFragment_to_articleFragment);
  }

  @NonNull
  public static ActionHomeFragmentToCategoryFragment actionHomeFragmentToCategoryFragment(
      @NonNull Category category) {
    return new ActionHomeFragmentToCategoryFragment(category);
  }

  @NonNull
  public static NavDirections actionHomeFragmentToFoodFragment() {
    return new ActionOnlyNavDirections(R.id.action_homeFragment_to_foodFragment);
  }

  @NonNull
  public static NavDirections actionHomeFragmentToTechniqueFragment() {
    return new ActionOnlyNavDirections(R.id.action_homeFragment_to_techniqueFragment);
  }

  @NonNull
  public static ActionHomeFragmentToTechniqueGraph actionHomeFragmentToTechniqueGraph(
      @NonNull Information information) {
    return new ActionHomeFragmentToTechniqueGraph(information);
  }

  @NonNull
  public static ActionHomeFragmentToFoodGraph actionHomeFragmentToFoodGraph(@NonNull Food food) {
    return new ActionHomeFragmentToFoodGraph(food);
  }

  @NonNull
  public static ActionHomeFragmentToArticleGraph actionHomeFragmentToArticleGraph(
      @NonNull Information information) {
    return new ActionHomeFragmentToArticleGraph(information);
  }

  public static class ActionHomeFragmentToCategoryFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionHomeFragmentToCategoryFragment(@NonNull Category category) {
      if (category == null) {
        throw new IllegalArgumentException("Argument \"category\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("category", category);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionHomeFragmentToCategoryFragment setCategory(@NonNull Category category) {
      if (category == null) {
        throw new IllegalArgumentException("Argument \"category\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("category", category);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("category")) {
        Category category = (Category) arguments.get("category");
        if (Parcelable.class.isAssignableFrom(Category.class) || category == null) {
          __result.putParcelable("category", Parcelable.class.cast(category));
        } else if (Serializable.class.isAssignableFrom(Category.class)) {
          __result.putSerializable("category", Serializable.class.cast(category));
        } else {
          throw new UnsupportedOperationException(Category.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
        }
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_homeFragment_to_categoryFragment;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public Category getCategory() {
      return (Category) arguments.get("category");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionHomeFragmentToCategoryFragment that = (ActionHomeFragmentToCategoryFragment) object;
      if (arguments.containsKey("category") != that.arguments.containsKey("category")) {
        return false;
      }
      if (getCategory() != null ? !getCategory().equals(that.getCategory()) : that.getCategory() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getCategory() != null ? getCategory().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionHomeFragmentToCategoryFragment(actionId=" + getActionId() + "){"
          + "category=" + getCategory()
          + "}";
    }
  }

  public static class ActionHomeFragmentToTechniqueGraph implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionHomeFragmentToTechniqueGraph(@NonNull Information information) {
      if (information == null) {
        throw new IllegalArgumentException("Argument \"information\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("information", information);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionHomeFragmentToTechniqueGraph setInformation(@NonNull Information information) {
      if (information == null) {
        throw new IllegalArgumentException("Argument \"information\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("information", information);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("information")) {
        Information information = (Information) arguments.get("information");
        if (Parcelable.class.isAssignableFrom(Information.class) || information == null) {
          __result.putParcelable("information", Parcelable.class.cast(information));
        } else if (Serializable.class.isAssignableFrom(Information.class)) {
          __result.putSerializable("information", Serializable.class.cast(information));
        } else {
          throw new UnsupportedOperationException(Information.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
        }
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_homeFragment_to_technique_graph;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public Information getInformation() {
      return (Information) arguments.get("information");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionHomeFragmentToTechniqueGraph that = (ActionHomeFragmentToTechniqueGraph) object;
      if (arguments.containsKey("information") != that.arguments.containsKey("information")) {
        return false;
      }
      if (getInformation() != null ? !getInformation().equals(that.getInformation()) : that.getInformation() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getInformation() != null ? getInformation().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionHomeFragmentToTechniqueGraph(actionId=" + getActionId() + "){"
          + "information=" + getInformation()
          + "}";
    }
  }

  public static class ActionHomeFragmentToFoodGraph implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionHomeFragmentToFoodGraph(@NonNull Food food) {
      if (food == null) {
        throw new IllegalArgumentException("Argument \"food\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("food", food);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionHomeFragmentToFoodGraph setFood(@NonNull Food food) {
      if (food == null) {
        throw new IllegalArgumentException("Argument \"food\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("food", food);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("food")) {
        Food food = (Food) arguments.get("food");
        if (Parcelable.class.isAssignableFrom(Food.class) || food == null) {
          __result.putParcelable("food", Parcelable.class.cast(food));
        } else if (Serializable.class.isAssignableFrom(Food.class)) {
          __result.putSerializable("food", Serializable.class.cast(food));
        } else {
          throw new UnsupportedOperationException(Food.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
        }
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_homeFragment_to_food_graph;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public Food getFood() {
      return (Food) arguments.get("food");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionHomeFragmentToFoodGraph that = (ActionHomeFragmentToFoodGraph) object;
      if (arguments.containsKey("food") != that.arguments.containsKey("food")) {
        return false;
      }
      if (getFood() != null ? !getFood().equals(that.getFood()) : that.getFood() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getFood() != null ? getFood().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionHomeFragmentToFoodGraph(actionId=" + getActionId() + "){"
          + "food=" + getFood()
          + "}";
    }
  }

  public static class ActionHomeFragmentToArticleGraph implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionHomeFragmentToArticleGraph(@NonNull Information information) {
      if (information == null) {
        throw new IllegalArgumentException("Argument \"information\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("information", information);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionHomeFragmentToArticleGraph setInformation(@NonNull Information information) {
      if (information == null) {
        throw new IllegalArgumentException("Argument \"information\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("information", information);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("information")) {
        Information information = (Information) arguments.get("information");
        if (Parcelable.class.isAssignableFrom(Information.class) || information == null) {
          __result.putParcelable("information", Parcelable.class.cast(information));
        } else if (Serializable.class.isAssignableFrom(Information.class)) {
          __result.putSerializable("information", Serializable.class.cast(information));
        } else {
          throw new UnsupportedOperationException(Information.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
        }
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_homeFragment_to_article_graph;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public Information getInformation() {
      return (Information) arguments.get("information");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionHomeFragmentToArticleGraph that = (ActionHomeFragmentToArticleGraph) object;
      if (arguments.containsKey("information") != that.arguments.containsKey("information")) {
        return false;
      }
      if (getInformation() != null ? !getInformation().equals(that.getInformation()) : that.getInformation() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + (getInformation() != null ? getInformation().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionHomeFragmentToArticleGraph(actionId=" + getActionId() + "){"
          + "information=" + getInformation()
          + "}";
    }
  }
}
