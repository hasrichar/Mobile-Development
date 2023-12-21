package com.development.gocipes.home.presentation.search;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import com.development.gocipes.core.model.Food;
import com.development.gocipes.home.R;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class SearchFragmentDirections {
  private SearchFragmentDirections() {
  }

  @NonNull
  public static ActionSearchFragmentToFoodGraph actionSearchFragmentToFoodGraph(
      @NonNull Food food) {
    return new ActionSearchFragmentToFoodGraph(food);
  }

  public static class ActionSearchFragmentToFoodGraph implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionSearchFragmentToFoodGraph(@NonNull Food food) {
      if (food == null) {
        throw new IllegalArgumentException("Argument \"food\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("food", food);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionSearchFragmentToFoodGraph setFood(@NonNull Food food) {
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
      return R.id.action_searchFragment_to_food_graph;
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
      ActionSearchFragmentToFoodGraph that = (ActionSearchFragmentToFoodGraph) object;
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
      return "ActionSearchFragmentToFoodGraph(actionId=" + getActionId() + "){"
          + "food=" + getFood()
          + "}";
    }
  }
}
