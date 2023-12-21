package com.development.gocipes.home.presentation.category;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import com.development.gocipes.core.model.Category;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class CategoryFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private CategoryFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private CategoryFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings({
      "unchecked",
      "deprecation"
  })
  public static CategoryFragmentArgs fromBundle(@NonNull Bundle bundle) {
    CategoryFragmentArgs __result = new CategoryFragmentArgs();
    bundle.setClassLoader(CategoryFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("category")) {
      Category category;
      if (Parcelable.class.isAssignableFrom(Category.class) || Serializable.class.isAssignableFrom(Category.class)) {
        category = (Category) bundle.get("category");
      } else {
        throw new UnsupportedOperationException(Category.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
      if (category == null) {
        throw new IllegalArgumentException("Argument \"category\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("category", category);
    } else {
      throw new IllegalArgumentException("Required argument \"category\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static CategoryFragmentArgs fromSavedStateHandle(
      @NonNull SavedStateHandle savedStateHandle) {
    CategoryFragmentArgs __result = new CategoryFragmentArgs();
    if (savedStateHandle.contains("category")) {
      Category category;
      category = savedStateHandle.get("category");
      if (category == null) {
        throw new IllegalArgumentException("Argument \"category\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("category", category);
    } else {
      throw new IllegalArgumentException("Required argument \"category\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Category getCategory() {
    return (Category) arguments.get("category");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
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

  @SuppressWarnings("unchecked")
  @NonNull
  public SavedStateHandle toSavedStateHandle() {
    SavedStateHandle __result = new SavedStateHandle();
    if (arguments.containsKey("category")) {
      Category category = (Category) arguments.get("category");
      if (Parcelable.class.isAssignableFrom(Category.class) || category == null) {
        __result.set("category", Parcelable.class.cast(category));
      } else if (Serializable.class.isAssignableFrom(Category.class)) {
        __result.set("category", Serializable.class.cast(category));
      } else {
        throw new UnsupportedOperationException(Category.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    CategoryFragmentArgs that = (CategoryFragmentArgs) object;
    if (arguments.containsKey("category") != that.arguments.containsKey("category")) {
      return false;
    }
    if (getCategory() != null ? !getCategory().equals(that.getCategory()) : that.getCategory() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getCategory() != null ? getCategory().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "CategoryFragmentArgs{"
        + "category=" + getCategory()
        + "}";
  }

  public static final class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(@NonNull CategoryFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(@NonNull Category category) {
      if (category == null) {
        throw new IllegalArgumentException("Argument \"category\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("category", category);
    }

    @NonNull
    public CategoryFragmentArgs build() {
      CategoryFragmentArgs result = new CategoryFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setCategory(@NonNull Category category) {
      if (category == null) {
        throw new IllegalArgumentException("Argument \"category\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("category", category);
      return this;
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @NonNull
    public Category getCategory() {
      return (Category) arguments.get("category");
    }
  }
}
